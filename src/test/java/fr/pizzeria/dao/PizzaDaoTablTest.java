package fr.pizzeria.dao;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.pizzeria.dao.impl.PizzaDaoTabl;
import fr.pizzeria.model.Pizza;

public class PizzaDaoTablTest {
	
	private static PizzaDaoTabl four = null;
	
	@BeforeClass
	public static void recupInstance() {
		four = PizzaDaoTabl.getInstance();
		four.initPizzas();
	}
	
	@Test
	public void testFindPizza() {
		Optional<Pizza> pizza = four.findPizza("LOL");
		
		assert(Optional.ofNullable(pizza) == null);
	}
	
	@Test
	public void testSaveNewPizza() {
		
	}
	
	@Test
	public void testUpdatePizza() {
		
	}
	
	@Test
	public void testDeletePizza() {
		
	}
}
