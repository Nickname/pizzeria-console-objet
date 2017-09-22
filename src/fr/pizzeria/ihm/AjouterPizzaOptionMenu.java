package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.BadInputException;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {
	Scanner clavier;
	
	public AjouterPizzaOptionMenu(Scanner clavier) {
		this.clavier = clavier;
	}

	public void execute() throws BadInputException {
		System.out.println("Ajout d’une nouvelle pizza\n");
		
		// Saisie du code
		System.out.println("Veuillez saisir le code :\n");
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
		
		PizzaDaoImpl four = PizzaDaoImpl.getInstance();
		Pizza pizza = new Pizza(code, nom, prix);
		four.saveNewPizza(pizza);
	}
	
}
