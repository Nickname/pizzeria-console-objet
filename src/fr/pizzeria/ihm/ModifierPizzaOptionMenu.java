package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.BadInputException;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {
	Scanner clavier;
	
	public ModifierPizzaOptionMenu(Scanner clavier) {
		this.clavier = clavier;
	}

	public void execute() throws BadInputException {
		PizzaDaoImpl four = PizzaDaoImpl.getInstance();
		ListerPizzasOptionMenu listerPizza = new ListerPizzasOptionMenu(clavier);
		
		System.out.println("Mise à jour d’une pizza\n");
		listerPizza.execute();
		System.out.println("Veuillez saisir le code de la pizza à modifier :\n");
		System.out.println("(99 pour abandonner)\n");
		// Saisie du code
		String code = clavier.next();
		if (code.length() > 3 || code.length() == 0) {
			throw new BadInputException("Le code doit avoir 3 lettres !");
		}
		// Saisie du nom
		System.out.println("Veuillez saisir le nom (sans espace) :\n");
		String nom = clavier.next();
		// Saisie du prix
		System.out.println("Veuillez saisir le prix");
		double prix = clavier.nextDouble();
		
		Pizza pizza = new Pizza(code, nom, prix);
		four.updatePizza(code, pizza);
	}
}
