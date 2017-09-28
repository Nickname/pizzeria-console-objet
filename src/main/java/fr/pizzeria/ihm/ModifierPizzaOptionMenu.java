package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.*;
import fr.pizzeria.exception.BadInputException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {
	private IPizzaDao four;
	
	public ModifierPizzaOptionMenu(IPizzaDao four) {
		this.four = four;
	}

	public void execute(Scanner clavier) throws BadInputException, UpdatePizzaException {
		ListerPizzasOptionMenu listerPizza = new ListerPizzasOptionMenu(four);
		
		System.out.println("Mise à jour d’une pizza\n");
		listerPizza.execute(clavier);
		System.out.println("Veuillez saisir le code de la pizza à modifier :\n");
		System.out.println("(99 pour abandonner)\n");
		// Saisie du code
		String code = clavier.next();
		if (code.length() > 3 || code.length() == 0) {
			throw new BadInputException("Le code doit avoir 3 lettres !");
		}
		// Saisie du nom
		System.out.println("Veuillez saisir le nom (sans espace)\n");
		String nom = clavier.next();
		// Saisie du prix
		System.out.println("Veuillez saisir le prix");
		double prix = clavier.nextDouble();
		
		System.out.println("Veuillez saisir la catégorie de la pizza\n"
				+ "1. Viande"
				+ "2. Sans viande"
				+ "3. Poisson");
		String categorieInput = clavier.nextLine();
		CategoriePizza categorie = null;
		
		switch(categorieInput) {
			case "1": categorie = CategoriePizza.VIANDE;
			case "2": categorie = CategoriePizza.SANS_VIANDE;
			case "3": categorie = CategoriePizza.POISSON;
		}
		
		Pizza pizza = new Pizza(code, nom, prix, categorie);
		boolean ok = four.updatePizza(code, pizza);
		
		if (!ok) {
			throw new UpdatePizzaException("Erreur lors de la modification");
		}
	}
}
