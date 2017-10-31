package fr.pizzeria.dao.impl;

import java.util.List;
import java.util.Optional;

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
		
		TypedQuery<Pizza> query = em.createQuery("from Pizza", Pizza.class);
		List<Pizza> pizzas = query.getResultList();
		
		em.close();
		
		return pizzas;
	}

	public Optional<Pizza> findPizza(String codePizza) {
		EntityManager em = entityManagerFactory.createEntityManager();
		
		TypedQuery<Pizza> query = em.createQuery("from Pizza p where p.code=:code", Pizza.class);
		query.setParameter("code", codePizza);
		List<Pizza> onePizza = query.getResultList();
		
		em.close();
		
		if (onePizza.isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(onePizza.get(0));
		}
	}

	public boolean saveNewPizza(Pizza pizza) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(pizza);
		et.commit();
		em.close();
		
		return true;
	}

	public boolean updatePizza(String codePizza, Pizza pizza) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Optional<Pizza> updatePizza = findPizza(codePizza);
		
		et.begin();
		if (updatePizza.isPresent()) {
			em.remove(updatePizza.get());
			em.persist(pizza);
		} else {
			return false;
		}
		et.commit();
		em.close();
		
		return true;
	}

	public boolean deletePizza(String codePizza) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Optional<Pizza> updatePizza = findPizza(codePizza);
		
		et.begin();
		if (updatePizza.isPresent()) {
			em.remove(updatePizza.get());
		} else {
			return false;
		}
		et.commit();
		em.close();
		
		return true;
	}
	
	public void resetPizzas() {
		PizzaDaoTabl four = PizzaDaoTabl.getInstance();
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Query query = em.createNativeQuery("DELETE FROM pizza");
		query.executeUpdate();
		
		four.findAllPizzas().forEach(p -> em.persist(p));
		
		et.commit();
		em.close();
	}
	
	public void closeConnection() {
		entityManagerFactory.close();
	}
	
}
