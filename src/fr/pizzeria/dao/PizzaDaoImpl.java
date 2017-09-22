package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	Pizza[] pizzas;
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
		this.pizzas = new Pizza[50];

		this.pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50);
		this.pizzas[1] = new Pizza("MAR", "Margherita", 14.00);
		this.pizzas[2] = new Pizza("REIN", "La Reine", 11.50);
		this.pizzas[3] = new Pizza("FRO", "La 4 Fromages", 12.00);
		this.pizzas[4] = new Pizza("CAN", "La cannibale", 12.50);
		this.pizzas[5] = new Pizza("SAV", "La savoyarde", 13.00);
		this.pizzas[6] = new Pizza("ORI", "L'orientale", 13.50);
		this.pizzas[7] = new Pizza("IND", "L'indienne", 14.00);
	}

	public Pizza[] findAllPizzas() {
		return this.pizzas;
	}
	
	public boolean saveNewPizza(Pizza pizza) {
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] == null) {
				pizzas[i] = pizza;
				
				return true;
			}
		}
		return false;
	}
	
	public boolean updatePizza(String codePizza, Pizza pizza) {
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null && pizzas[i].getCode().equals(codePizza)) {
				pizzas[i] = null;
				pizzas[i] = pizza;
				
				return true;
			}
		}
		return false;
	}
	
	public boolean deletePizza(String codePizza) {
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null && pizzas[i].getCode().equals(codePizza)) {
				pizzas[i] = null;
				
				return true;
			}
		}
		return false;
	}
}
