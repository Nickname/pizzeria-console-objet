package fr.pizzeria.dao;

import java.util.List;
import java.util.Optional;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	List<Pizza> findAllPizzas() throws Exception;
	Optional<Pizza> findPizza(String codePizza);
	boolean saveNewPizza(Pizza pizza);
	boolean updatePizza(String codePizza, Pizza pizza);
	boolean deletePizza(String codePizza);

}