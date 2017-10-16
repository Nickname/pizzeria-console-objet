package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.*;
import fr.pizzeria.exception.BadInputException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {
	/** four : IPizzaDao */
	private IPizzaDao four = null;
	/** LOG : Logger */
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	/**
	 * @param four
	 */
	public ModifierPizzaOptionMenu(IPizzaDao four) {
		this.four = four;
	}

	/* Exécute le menu pour modifier une pizza
	 * @see fr.pizzeria.ihm.OptionMenu#execute(java.util.Scanner)
	 */
	public String execute(Scanner clavier) throws BadInputException, UpdatePizzaException {
		ListerPizzasOptionMenu listerPizza = new ListerPizzasOptionMenu(four);
		
		LOG.info("Mise à jour d’une pizza\n");
		listerPizza.execute(clavier);
		LOG.info("Veuillez saisir le code de la pizza à modifier :\n");
		LOG.info("(99 pour abandonner)\n");
		// Saisie du code
		String code = clavier.next();
		if (code.length() > 3 || code.length() == 0) {
			throw new BadInputException("Le code doit avoir 3 lettres !");
		}
		// Saisie du nom
		LOG.info("Veuillez saisir le nom (sans espace)\n");
		String nom = clavier.next();
		// Saisie du prix
		LOG.info("Veuillez saisir le prix");
		double prix = clavier.nextDouble();
		
		LOG.info("Veuillez saisir la catégorie de la pizza\n"
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
		} else {
			return "Pizza modifié !";
		}
	}
}
