package fr.pizzeria.dao;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImplTest {
	
	private static final PizzaDaoImpl four = null;
	
	@BeforeClass
	public static void recupInstance() {
		four = PizzaDaoImpl.getInstance();
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
