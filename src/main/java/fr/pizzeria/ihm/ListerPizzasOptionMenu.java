package fr.pizzeria.ihm;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

@Controller
public class ListerPizzasOptionMenu extends OptionMenu {
	
	/** four : IPizzaDao */
	@Autowired private IPizzaDao four = null;
	
	/** logger : Logger */
	@Autowired private Logger logger;
	
	private static final String LIBELLE = "Lister les pizzas";
	
	/** Getter for LIBELLE
	 * @return the libelle
	 */
	public String getLibelle() {
		return LIBELLE;
	}
	
	/* Méthode qui renvoie la liste des pizzas sous forme de String
	 * @see fr.pizzeria.ihm.OptionMenu#execute(java.util.Scanner)
	 */
	public boolean execute() {
		logger.info("Liste des pizzas");
		
		StringBuilder affich = new StringBuilder();
		
		try {
			for (Pizza pizza : four.findAllPizzas()) {
				affich.append(pizza.toString() + "\n");
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		logger.info(affich.toString());
		
		return true;
	}
}
