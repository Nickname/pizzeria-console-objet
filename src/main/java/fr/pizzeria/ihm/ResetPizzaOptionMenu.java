package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.impl.PizzaDaoJdbc;

public class ResetPizzaOptionMenu extends OptionMenu {
	/** four : IPizzaDao */
	private PizzaDaoJdbc four = null;
	/** LOG : Logger */
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	public ResetPizzaOptionMenu(IPizzaDao four) {
		this.four = (PizzaDaoJdbc) four;
	}

	@Override
	protected String execute(Scanner clavier) throws Exception {
		LOG.info("Réinitialisation des pizzas...");
		four.initOldPizzas();
		
		return "OK";
	}

}
