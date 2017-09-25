package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.*;
import fr.pizzeria.exception.BadInputException;
import fr.pizzeria.exception.DeletePizzaException;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	private IPizzaDao four;
	
	public SupprimerPizzaOptionMenu(IPizzaDao four) {
		this.four = four;
	}
	
	public void execute(Scanner clavier) throws BadInputException, DeletePizzaException {
		ListerPizzasOptionMenu listerPizza = new ListerPizzasOptionMenu(four);
		
		System.out.println("Suppression d’une pizza\n");
		listerPizza.execute(clavier);
		System.out.println("Veuillez saisir le code de la pizza à supprimer :\n");
		System.out.println("(99 pour abandonner)\n");
		String code = clavier.next();
		if (code.length() > 3 || code.length() == 0) {
			throw new BadInputException("Le code doit avoir 3 lettres !");
		}
		
		boolean ok = four.deletePizza(code);
		if (!ok) {
			throw new DeletePizzaException("Erreur lors de la supression");
		}
	}
	
}
