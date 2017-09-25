package fr.pizzeria.dao;

import java.util.ArrayList;

import fr.pizzeria.model.Pizza;

public class PizzaDaoFile {
	
	ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	static PizzaDaoFile instance = null;
	
	private PizzaDaoFile() {
		this.initPizzas();
	}
	
	public static PizzaDaoFile getInstance() {
		if (instance == null) {
			instance = new PizzaDaoFile();
		}
		return instance;
	}
	
	public void initPizzas() {
		
	}
	
}
