package fr.pizzeria.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJdbc implements IPizzaDao {
	
	private static PizzaDaoJdbc instance = null;
	
	private static Connection connection = null;
	private static final String URL_BDD = "jdbc:mariadb://localhost:3306/pizzeria";

	private PizzaDaoJdbc() {
		try {
			Class.forName("org.mariadb.mysql.Driver");
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}
	}
	
	public static PizzaDaoJdbc getInstance() {
		if (instance == null) {
			instance = new PizzaDaoJdbc();
			try {
				connection = DriverManager.getConnection(URL_BDD, "root", "");
			} catch (SQLException e) {
				e.getErrorCode();
			}
		}
		return instance;
	}
	
	public static boolean closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public List<Pizza> findAllPizzas() throws SQLException {
		List<Pizza> pizzas = new ArrayList<>();
		ResultSet result = null;
		String query = "SELECT * FROM pizza ORDER BY ID";
		PreparedStatement stmt = null;
		
		try {
			stmt = connection.prepareStatement(query);
			result = stmt.executeQuery();
			while(result.next()) {
				String code = result.getString("CODE");
				String nom = result.getString("NOM");
				double prix = result.getDouble("PRIX");
				String categorie = result.getString("CATEGORIE");
				pizzas.add(new Pizza(code, nom, prix, CategoriePizza.getType(categorie)));
			}
		} catch (SQLException e) {
				e.getMessage();
		} finally {
				result.close();
				stmt.close();
		}
		
		return pizzas;
	}

	public Optional<Pizza> findPizza(String codePizza) {
		ResultSet result = null;
		Pizza pizza = null;
		String query = "SELECT * FROM pizza WHERE CODE=? ORDER BY ID";
		PreparedStatement stmt = null;
		
		try {
			stmt = connection.prepareStatement(query);
			stmt.setString(1, codePizza);
			result = stmt.executeQuery(query);
			while(result.next()) {
				String code = result.getString("CODE");
				String nom = result.getString("NOM");
				double prix = result.getDouble("PRIX");
				String categorie = result.getString("CATEGORIE");
				pizza = new Pizza(code, nom, prix, CategoriePizza.getType(categorie));
				pizza.setId(result.getInt("ID"));
			}
		} catch (SQLException e) {
				e.getMessage();
		} finally {
				try {
					result.close();
					stmt.close();
				} catch (SQLException e) {
					e.getMessage();
				}
		}
		
		return Optional.ofNullable(pizza);
	}

	public boolean saveNewPizza(Pizza pizza) {
		int insertPizza;
		String query = "INSERT INTO PIZZA(CODE, NOM, PRIX, CATEGORIE) VALUES (?, ?, ?, ?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(query);
			stmt.setString(1, pizza.getCode());
			stmt.setString(2, pizza.getNom());
			stmt.setDouble(3, pizza.getPrix());
			stmt.setString(4, pizza.getCategorie());
			insertPizza = stmt.executeUpdate();
		} catch (SQLException e) {
			return false;
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return insertPizza == 1;
	}
	
	public int initOldPizzas() {
		PizzaDaoTabl oldFour = PizzaDaoTabl.getInstance();
		int insertPizza = 0;
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			e1.getMessage();
		}
		
		for (Pizza pizza : oldFour.findAllPizzas()) {
			try {
				int deleteAll = statement.executeUpdate("DELETE * FROM PIZZA");
				insertPizza = statement.executeUpdate("INSERT INTO PIZZA(CODE, NOM, PRIX, CATEGORIE) "
														+ "VALUES ('" + pizza.getCode() + "', '" 
														+ pizza.getNom() + "', " 
														+ pizza.getPrix() + ", '" 
														+ pizza.getCategorie() + "')");
			} catch (SQLException e) {
				return -1;
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		return insertPizza;
	}

	public boolean updatePizza(String codePizza, Pizza pizza) {
		int updatePizza;
		String query = "UPDATE PIZZA SET CODE=?, NOM=?, PRIX=? ,CATEGORIE=? WHERE CODE=?";
		PreparedStatement stmt = null;
		
		try {
			stmt = connection.prepareStatement(query);
			stmt.setString(1, pizza.getCode());
			stmt.setString(2, pizza.getNom());
			stmt.setDouble(3, pizza.getPrix());
			stmt.setString(4, pizza.getCategorie());
			stmt.setString(5, codePizza);
			updatePizza = stmt.executeUpdate();
		} catch (SQLException e) {
			return false;
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.getMessage();
			}
		}
		return updatePizza == 1;
	}

	public boolean deletePizza(String codePizza) {
		int deletePizza;
		String query = "DELETE PIZZA WHERE CODE=?";
		PreparedStatement stmt = null;
		
		try {
			stmt = connection.prepareStatement(query);
			stmt.setString(1, codePizza);
			deletePizza = stmt.executeUpdate(query);
		} catch (SQLException e) {
			return false;
		}
		return deletePizza == 1;
	}

}
