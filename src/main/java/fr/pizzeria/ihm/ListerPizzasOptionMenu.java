package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu {
	private IPizzaDao four;
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	public ListerPizzasOptionMenu(IPizzaDao four) {
		this.four = four;
	}
	
<<<<<<< HEAD
	public void execute(Scanner clavier) {
		System.out.println("Liste des pizzas\n");
		StringBuilder affich = new StringBuilder();
		
		for (Pizza pizza : four.findAllPizzas()) {
			affich.append(pizza.toString());
			affich.append("\n");
		}
		
		System.out.println(affich.toString());
=======
	public String execute(Scanner clavier) {
		LOG.info("Liste des pizzas");
		
		StringBuilder affich = new StringBuilder();
		
		for (Pizza pizza : four.findAllPizzas()) {
			affich.append(pizza.toString() + "\n");
		}
		
		return affich.toString();
>>>>>>> fc5a3220aad792719231319e300c1d6cafc23bb9
	}
}
