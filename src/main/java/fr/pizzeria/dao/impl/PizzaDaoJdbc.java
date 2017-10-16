package fr.pizzeria.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJdbc implements IPizzaDao {
	
	private static PizzaDaoJdbc instance = null;
	
	private static Connection connection = null;
	private static Statement statement = null;

	private PizzaDaoJdbc() {
		try {
			Class.forName("com.mysql.mariadb.Driver");
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}
	}
	
	public static IPizzaDao getInstance() {
		if (instance == null) {
			instance = new PizzaDaoJdbc();
			try {
				connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pizzeria", "root", "");
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
	
	public static boolean createStatement() {
		if (connection != null) {
			try {
				statement = connection.createStatement();
			} catch (SQLException e) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean closeStatement() {
		try {
			statement.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public List<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Pizza> findPizza(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
