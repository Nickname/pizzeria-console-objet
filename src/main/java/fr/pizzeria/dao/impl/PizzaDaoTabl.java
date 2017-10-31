package fr.pizzeria.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.*;

public class PizzaDaoTabl implements IPizzaDao {
	/** pizzas : ArrayList<Pizza> */
	ArrayList<Pizza> pizzas = new ArrayList<>();
	/** instance : PizzaDaoImpl */
	private static PizzaDaoTabl instance = null;
	
	/**
	 * Constructeur privé : initialise la liste des pizzas en mémoire
	 */
	private PizzaDaoTabl() {
		this.initPizzas();
	}
	
	/** Méthode singleton
	 * @return
	 */
	public static PizzaDaoTabl getInstance() {
		if (instance == null) {
			instance = new PizzaDaoTabl();
		}
		return instance;
	}
	
	/**
	 * Méthode d'initialisation des pizzas dans une ArrayList
	 */
	public void initPizzas() {
		Pizza pizza0 = new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE);
		pizzas.add(pizza0);
		Pizza pizza1 = new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VIANDE);
		pizzas.add(pizza1);
		Pizza pizza2 = new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE);
		pizzas.add(pizza2);
		Pizza pizza3 = new Pizza("FRO", "La 4 Fromages", 12.00, CategoriePizza.SANS_VIANDE);
		pizzas.add(pizza3);
		Pizza pizza4 = new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE);
		pizzas.add(pizza4);
		Pizza pizza5 = new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE);
		pizzas.add(pizza5);
		Pizza pizza6 = new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE);
		pizzas.add(pizza6);
		Pizza pizza7 = new Pizza("IND", "L'indienne", 14.00, CategoriePizza.VIANDE);
		pizzas.add(pizza7);
	}

	/* Retourne la liste des pizzas
	 * @see fr.pizzeria.dao.IPizzaDao#findAllPizzas()
	 */
	public List<Pizza> findAllPizzas() {
		return this.pizzas;
	}
	
	/** Retourne une pizza correspondant au code
	 * @param codePizza
	 * @return
	 */
	public Optional<Pizza> findPizza(String codePizza) {
		return this.pizzas.stream()
					.filter(p -> p.getCode().equals(codePizza))
					.findFirst();
	}
	
	/* Sauvegarde d'une nouvelle pizza
	 * @see fr.pizzeria.dao.IPizzaDao#saveNewPizza(fr.pizzeria.model.Pizza)
	 */
	public boolean saveNewPizza(Pizza pizza) {
		this.pizzas.add(pizza);
		
		return true;
	}
	
	/* Met à jour une pizza avec des nouvelles informations
	 * @see fr.pizzeria.dao.IPizzaDao#updatePizza(java.lang.String, fr.pizzeria.model.Pizza)
	 */
	public boolean updatePizza(String codePizza, Pizza newPizza) {
		Optional<Pizza> tmpPizza = findPizza(codePizza);
		
		if (tmpPizza.isPresent()) {
			this.pizzas.remove(tmpPizza.get());
			this.pizzas.add(newPizza);
			
			return true;
		}
		return false;
	}
	
	/* Supprime une pizza correspondant au code
	 * @see fr.pizzeria.dao.IPizzaDao#deletePizza(java.lang.String)
	 */
	public boolean deletePizza(String codePizza) {
		Optional<Pizza> tmpPizza = findPizza(codePizza);
		if (tmpPizza.isPresent()) {
			pizzas.remove(tmpPizza.get());
			
			return true;
		} else {
			return false;
		}
	}
	
	/* Réinitialise toutes les pizzas
	 * @see fr.pizzeria.dao.IPizzaDao#resetPizzas()
	 */
	public void resetPizzas() {
		this.pizzas = null;
		this.initPizzas();
	}
	
	
	/* Ne sert à rien ici
	 * @see fr.pizzeria.dao.IPizzaDao#closeConnection()
	 */
	public void close() {
		
	}
}
