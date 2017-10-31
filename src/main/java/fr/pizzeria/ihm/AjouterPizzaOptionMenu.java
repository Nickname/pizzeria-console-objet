package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.*;
import fr.pizzeria.exception.BadInputException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Controller
public class AjouterPizzaOptionMenu extends OptionMenu {
	
	/** four : IPizzaDao */
	@Autowired private IPizzaDao four = null;
	
	/** logger : Logger */
	@Autowired private Logger logger;
	
	/** clavier : Scanner */
	@Autowired private Scanner clavier;
	
	private static final String LIBELLE = "Ajouter une nouvelle pizza";
	
	/** Getter for LIBELLE
	 * @return the libelle
	 */
	public String getLibelle() {
		return LIBELLE;
	}
	
	/* Exécute le menu pour ajouter une pizza
	 * @see fr.pizzeria.ihm.OptionMenu#execute(java.util.Scanner)
	 */
	public boolean execute() throws BadInputException, SavePizzaException {
		logger.info("Ajout d’une nouvelle pizza");
		
		// Saisie du code
		logger.info("Veuillez saisir le code :");
		String code = clavier.next();
		if (code.length() > 3 || code.length() == 0) {
			throw new BadInputException("Le code doit avoir 3 lettres !");
		}
		
		// Saisie du nom
		logger.info("Veuillez saisir le nom (sans espace) :");
		String nom = clavier.next();
		
		// Saisie du prix
		logger.info("Veuillez saisir le prix");
		float prix = clavier.nextFloat();
		
		logger.info("Veuillez saisir la catégorie de la pizza :\n"
				+ "1. Viande\n"
				+ "2. Sans viande\n"
				+ "3. Poisson\n");
		CategoriePizza categorie = null;
		
		while (categorie == null) {
			String categorieInput = clavier.nextLine();
			switch(categorieInput) {
				case "1": categorie = CategoriePizza.VIANDE;
				case "2": categorie = CategoriePizza.SANS_VIANDE;
				case "3": categorie = CategoriePizza.POISSON;
				default : logger.info("Veuillez saisir une catégorie!");
			}
		}
		
		Pizza pizza = new Pizza(code, nom, prix, categorie);
		boolean ok = four.saveNewPizza(pizza);
		
		if (!ok) {
			throw new SavePizzaException("Erreur lors de la sauvegarde");
		} else {
			logger.info("Pizza sauvegardé !");
			return true;
		}
	}
	
}
