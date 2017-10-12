package fr.pizzeria.ihm;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.lalyos.jfiglet.FigletFont;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.*;

public class PrincipalPizzaOptionMenu extends OptionMenu {
	private static final IPizzaDao four = PizzaDaoImpl.getInstance();
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	private Map<String, OptionMenu> mapMenu = new TreeMap<>();
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
			mapMenu.put("1  ->  Lister les pizzas", new ListerPizzasOptionMenu(four));
			mapMenu.put("2  ->  Ajouter une nouvelle pizza", new AjouterPizzaOptionMenu(four));
			mapMenu.put("3  ->  Mettre à jour une pizza", new ModifierPizzaOptionMenu(four));
			mapMenu.put("4  ->  Supprimer une pizza", new SupprimerPizzaOptionMenu(four));
			//mapMenu.put("99 -> Sortir", "Au revoir !");
		} catch (Exception e) {
			LOG.info(e.getMessage());
		}
	}
	
	public String affichMenu() {
		StringBuilder strMenu = new StringBuilder();
		
		strMenu.append(pizzeriaAscii);
		
		mapMenu.keySet().stream().forEach(op -> strMenu.append(op + "\n"));
		
		return strMenu.toString();
	}

	public String execute(Scanner clavier) throws Exception {
		String userInput = clavier.nextLine();
		
		String keyMenu = mapMenu.keySet().stream()
						.filter(k -> k.substring(0, 3).trim().equals(userInput))
						.collect(Collectors.joining());
		
		return mapMenu.get(keyMenu).execute(clavier);
	}
	


}
