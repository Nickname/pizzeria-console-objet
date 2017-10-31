package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.IPizzaDao;

public class ResetPizzaOptionMenu extends OptionMenu {
	/** four : IPizzaDao */
	private IPizzaDao four = null;
	/** LOG : Logger */
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	public ResetPizzaOptionMenu(IPizzaDao four) {
		this.four = four;
	}

	@Override
	protected String execute(Scanner clavier) throws Exception {
		LOG.info("Réinitialisation des pizzas...");
		four.resetPizzas();
		
		return "OK";
	}

}
