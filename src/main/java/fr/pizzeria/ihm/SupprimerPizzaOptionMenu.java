package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.*;
import fr.pizzeria.exception.BadInputException;
import fr.pizzeria.exception.DeletePizzaException;

@Controller
public class SupprimerPizzaOptionMenu extends OptionMenu {
	
	/** four : IPizzaDao */
	@Autowired private IPizzaDao four;
	
	/** logger : Logger */
	@Autowired private Logger logger;
	
	/** clavier : Scanner */
	@Autowired private Scanner clavier;
	
	/** listerPizza : ListerPizzasOptionMenu */
	@Autowired private ListerPizzasOptionMenu listerPizza;
	
	/** LIBELLE : String */
	private static final String LIBELLE = "Supprimer une pizza";
	
	/** Getter for LIBELLE
	 * @return the libelle
	 */
	public String getLibelle() {
		return LIBELLE;
	}
	
	/* Exécution du menu de suppression d'une pizza
	 * @see fr.pizzeria.ihm.OptionMenu#execute(java.util.Scanner)
	 */
	public boolean execute() throws BadInputException, DeletePizzaException {
		logger.info("Suppression d’une pizza\n");
		listerPizza.execute();
		
		logger.info("Veuillez saisir le code de la pizza à supprimer :\n");
		logger.info("(99 pour abandonner)\n");
		String code = clavier.next();
		
		if (code == "99") {
			logger.info("Abandon...");
			return true;
		}
		
		if (code.length() > 3 || code.length() == 0) {
			throw new BadInputException("Le code doit avoir 3 lettres !");
		}
		
		boolean ok = four.deletePizza(code);
		if (!ok) {
			throw new DeletePizzaException("Erreur lors de la supression");
		} else {
			logger.info("Pizza supprimé !");
			return true;
		}
	}
	
}
