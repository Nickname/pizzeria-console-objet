package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.*;
import fr.pizzeria.exception.BadInputException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Controller
public class ModifierPizzaOptionMenu extends OptionMenu {
	
	/** four : IPizzaDao */
	@Autowired private IPizzaDao four;
	
	/** logger : Logger */
	@Autowired private Logger logger;
	
	/** clavier : Scanner */
	@Autowired private Scanner clavier;
	
	/** listerPizza : ListerPizzasOptionMenu */
	@Autowired private ListerPizzasOptionMenu listerPizza;
	
	/** LIBELLE : String */
	private static final String LIBELLE = "Mettre à jour une pizza";
	
	/** Getter for LIBELLE
	 * @return the libelle
	 */
	public String getLibelle() {
		return LIBELLE;
	}
	
	/* Exécute le menu pour modifier une pizza
	 * @see fr.pizzeria.ihm.OptionMenu#execute(java.util.Scanner)
	 */
	public boolean execute() throws BadInputException, UpdatePizzaException {
		logger.info("Mise à jour d’une pizza\n");
		listerPizza.execute();
		logger.info("Veuillez saisir le code de la pizza à modifier :\n");
		logger.info("(99 pour abandonner)\n");
		
		// Saisie du code
		String code = clavier.next();
		if (code.length() > 3 || code.length() == 0) {
			throw new BadInputException("Le code doit avoir 3 lettres !");
		}
		
		// Saisie du nom
		logger.info("Veuillez saisir le nom (sans espace)\n");
		String nom = clavier.next();
		
		// Saisie du prix
		logger.info("Veuillez saisir le prix");
		double prix = clavier.nextDouble();
		
		logger.info("Veuillez saisir la catégorie de la pizza\n"
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
			logger.info("Pizza modifié !");
			return true;
		}
	}
}
