package fr.pizzeria.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.*;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements IPizzaDao {
	
	private static PizzaDaoJpa instance = null;
	private EntityManagerFactory entityManagerFactory = null;
	
	private PizzaDaoJpa() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("pizzeria");
		}
	}
	
	public static PizzaDaoJpa getInstance() {
		if (instance == null) {
			instance = new PizzaDaoJpa();
		}
		return instance;
	}

	public List<Pizza> findAllPizzas() throws Exception {
		EntityManager em = entityManagerFactory.createEntityManager();
		
		TypedQuery<Pizza> pizzas = em.createQuery("from Pizza", Pizza.class);
		
		return pizzas.getResultList().stream().collect(Collectors.toList());
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
	
	public void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}
	
}
