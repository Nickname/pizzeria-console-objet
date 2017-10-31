package fr.pizzeria.ihm;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IPizzaDao;

@Controller
public class ResetPizzaOptionMenu extends OptionMenu {
	
	/** four : IPizzaDao */
	@Autowired private IPizzaDao four;
	
	/** logger : Logger */
	@Autowired private Logger logger;
	
	private static final String LIBELLE = "Réinitialiser les pizzas";
	
	/** Getter for LIBELLE
	 * @return the libelle
	 */
	public String getLibelle() {
		return LIBELLE;
	}

	@Override
	protected boolean execute() throws Exception {
		logger.info("Réinitialisation des pizzas...");
		four.resetPizzas();
		logger.info("OK");
		
		return true;
	}

}
