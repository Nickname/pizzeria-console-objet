package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.*;
import fr.pizzeria.exception.BadInputException;
import fr.pizzeria.exception.DeletePizzaException;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	private IPizzaDao four;
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	public SupprimerPizzaOptionMenu(IPizzaDao four) {
		this.four = four;
	}
	
	public String execute(Scanner clavier) throws BadInputException, DeletePizzaException {
		LOG.info("Suppression d’une pizza\n");
		new ListerPizzasOptionMenu(four).execute(clavier);
		LOG.info("Veuillez saisir le code de la pizza à supprimer :\n");
		LOG.info("(99 pour abandonner)\n");
		String code = clavier.next();
		if (code.length() > 3 || code.length() == 0) {
			throw new BadInputException("Le code doit avoir 3 lettres !");
		}
		
		boolean ok = four.deletePizza(code);
		if (!ok) {
			throw new DeletePizzaException("Erreur lors de la supression");
		} else {
			return "Pizza supprimé !";
		}
	}
	
}
