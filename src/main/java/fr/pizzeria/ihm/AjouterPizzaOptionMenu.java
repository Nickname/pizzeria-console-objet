package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.*;
import fr.pizzeria.exception.BadInputException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {
	private IPizzaDao four;
	private static final Logger LOG = LoggerFactory.getLogger(AjouterPizzaOptionMenu.class);
	
	public AjouterPizzaOptionMenu(IPizzaDao four) {
		this.four = four;
	}

	public String execute(Scanner clavier) throws BadInputException, SavePizzaException {
		LOG.info("Ajout d’une nouvelle pizza");
		
		// Saisie du code
		LOG.info("Veuillez saisir le code :");
		String code = clavier.next();
		if (code.length() > 3 || code.length() == 0) {
			throw new BadInputException("Le code doit avoir 3 lettres !");
		}
		
		// Saisie du nom
		LOG.info("Veuillez saisir le nom (sans espace) :");
		String nom = clavier.next();
		
		// Saisie du prix
		LOG.info("Veuillez saisir le prix");
		double prix = clavier.nextDouble();
		
		LOG.info("Veuillez saisir la catégorie de la pizza :"
				+ "1. Viande"
				+ "2. Sans viande"
				+ "3. Poisson");
		String categorieInput = clavier.nextLine();
		CategoriePizza categorie = null;
		
		switch(categorieInput) {
			case "1": categorie = CategoriePizza.VIANDE;
						break;
			case "2": categorie = CategoriePizza.SANS_VIANDE;
						break;
			case "3": categorie = CategoriePizza.POISSON;
						break;
			default: categorie = null;
		}
		
		Pizza pizza = new Pizza(code, nom, prix, categorie);
		boolean ok = four.saveNewPizza(pizza);
		
		if (!ok) {
			throw new SavePizzaException("Erreur lors de la sauvegarde");
		} else {
			return "Pizza sauvegardé !";
		}
	}
	
}
