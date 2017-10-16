package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu {
	/** four : IPizzaDao */
	private IPizzaDao four = null;
	/** LOG : Logger */
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	/**
	 * @param four
	 */
	public ListerPizzasOptionMenu(IPizzaDao four) {
		this.four = four;
	}
	/* Méthode qui renvoie la liste des pizzas sous forme de String
	 * @see fr.pizzeria.ihm.OptionMenu#execute(java.util.Scanner)
	 */
	public String execute(Scanner clavier) {
		LOG.info("Liste des pizzas");
		
		StringBuilder affich = new StringBuilder();
		
		for (Pizza pizza : four.findAllPizzas()) {
			affich.append(pizza.toString() + "\n");
		}
		
		return affich.toString();
	}
}
