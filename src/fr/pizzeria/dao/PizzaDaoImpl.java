package fr.pizzeria.dao;

import java.util.ArrayList;

import fr.pizzeria.model.*;

public class PizzaDaoImpl implements IPizzaDao {
	ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	static PizzaDaoImpl instance = null;
	
	private PizzaDaoImpl() {
		this.initPizzas();
	}
	
	public static PizzaDaoImpl getInstance() {
		if (instance == null) {
			instance = new PizzaDaoImpl();
		}
		return instance;
	}
	
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

	public ArrayList<Pizza> findAllPizzas() {
		return this.pizzas;
	}
	
	public boolean saveNewPizza(Pizza pizza) {
		this.pizzas.add(pizza);
		return true;
	}
	
	public boolean updatePizza(String codePizza, Pizza newPizza) {
		for (Pizza pizza : this.pizzas) {
			if (pizza.getCode().equals(codePizza)) {
				pizzas.remove(pizza);
				pizzas.add(newPizza);
				
				return true;
			}
		}
		return false;
	}
	
	public boolean deletePizza(String codePizza) {
		for (Pizza pizza : this.pizzas) {
			if (pizza.getCode().equals(codePizza)) {
				this.pizzas.remove(pizza);
				
				return true;
			}
		}
		return false;
	}
}
