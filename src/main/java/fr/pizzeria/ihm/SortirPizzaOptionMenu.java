package fr.pizzeria.ihm;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.github.lalyos.jfiglet.FigletFont;

@Controller
public class SortirPizzaOptionMenu extends OptionMenu {

	/** logger : Logger */
	@Autowired private Logger logger;
	
    /** byeAscii : String */
    private String byeAscii = FigletFont.convertOneLine("Bye...");
    
    private static final String LIBELLE = "Sortir";
    
	/** Getter for LIBELLE
	 * @return the libelle
	 */
	public String getLibelle() {
		return LIBELLE;
	}
	
	/* Exécution du menu pour sortir de l'appli
	 * @see fr.pizzeria.ihm.OptionMenu#execute(java.util.Scanner)
	 */
	protected boolean execute() throws Exception {
		logger.info(byeAscii);
		
		return false;
	}

}
