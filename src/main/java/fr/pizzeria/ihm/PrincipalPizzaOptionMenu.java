package fr.pizzeria.ihm;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.lalyos.jfiglet.FigletFont;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.*;
import fr.pizzeria.exception.*;

public class PrincipalPizzaOptionMenu extends OptionMenu {
	private static final IPizzaDao four = PizzaDaoImpl.getInstance();
	private static final Logger LOG = LoggerFactory.getLogger(PrincipalPizzaOptionMenu.class);
	
	private Map<String, String> mapMenu = new TreeMap<>();
    private String pizzeriaAscii = FigletFont.convertOneLine("Pizzeria");
    
    private static PrincipalPizzaOptionMenu instanceMenu = null;
    
    private PrincipalPizzaOptionMenu() {    }
    
    public static PrincipalPizzaOptionMenu getInstance() {
    	if (instanceMenu == null) {
    		instanceMenu = new PrincipalPizzaOptionMenu();
    	}
    	return instanceMenu;
    }
	
	public void initMenu(Scanner clavier) {
        try {
			mapMenu.put("1  ->  Lister les pizzas\r\n", new ListerPizzasOptionMenu(four).execute(clavier));
			mapMenu.put("2  ->  Ajouter une nouvelle pizza\r\n", new AjouterPizzaOptionMenu(four).execute(clavier));
			mapMenu.put("3  ->  Mettre à jour une pizza\r\n", new ModifierPizzaOptionMenu(four).execute(clavier));
			mapMenu.put("4  ->  Supprimer une pizza\r\n", new SupprimerPizzaOptionMenu(four).execute(clavier));
			mapMenu.put("99 -> Sortir", "Au revoir !");
		} catch (SavePizzaException | UpdatePizzaException | DeletePizzaException | BadInputException e) {
			LOG.info(e.getMessage());
		}
	}
	
	public void affichMenu() {
		LOG.info(pizzeriaAscii);
		LOG.info(mapMenu.keySet().stream().toString());
	}

	public String execute(Scanner clavier) {
		String userInput = clavier.nextLine();
		
		String keyMenu = mapMenu.keySet().stream()
						.filter(k -> k.substring(0, 3).trim() == userInput)
						.parallel()
						.toString();
		
		return mapMenu.get(keyMenu);
	}
	


}
