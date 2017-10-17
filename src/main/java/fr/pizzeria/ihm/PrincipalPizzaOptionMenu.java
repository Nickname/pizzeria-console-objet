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
import fr.pizzeria.dao.impl.*;

public class PrincipalPizzaOptionMenu extends OptionMenu {
	/** four : IPizzaDao */
	private static IPizzaDao four = PizzaDaoJdbc.getInstance();
	/** LOG : Logger */
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	/** mapMenu : Map<String,OptionMenu> */
	private Map<String, OptionMenu> mapMenu = new TreeMap<>();
    /** pizzeriaAscii : String */
    private String pizzeriaAscii = FigletFont.convertOneLine("Pizzeria");
    
    /** instanceMenu : PrincipalPizzaOptionMenu */
    private static PrincipalPizzaOptionMenu instanceMenu = null;

    private PrincipalPizzaOptionMenu() {	}
    
    /** Méthode récupération instance : singleton
     * @return
     */
    public static PrincipalPizzaOptionMenu getInstance() {
    	if (instanceMenu == null) {
    		instanceMenu = new PrincipalPizzaOptionMenu();
    	}
    	return instanceMenu;
    }
	
	/** Méthode permettant d'initialiser la map contenant le menu
	 * @param clavier
	 */
	public void init() {
        try {
			mapMenu.put("1  ->  Lister les pizzas", new ListerPizzasOptionMenu(four));
			mapMenu.put("2  ->  Ajouter une nouvelle pizza", new AjouterPizzaOptionMenu(four));
			mapMenu.put("3  ->  Mettre à jour une pizza", new ModifierPizzaOptionMenu(four));
			mapMenu.put("4  ->  Supprimer une pizza", new SupprimerPizzaOptionMenu(four));
			if (four instanceof PizzaDaoJdbc) {
				mapMenu.put("5  ->  Réinitialiser les pizzas", new ResetPizzaOptionMenu(four));
			}
			mapMenu.put("99 -> Sortir", new SortirPizzaOptionMenu());
		} catch (Exception e) {
			LOG.info(e.getMessage());
		}
	}
	
	/** Méthode pour afficher le menu
	 * @return
	 */
	public String affich() {
		StringBuilder strMenu = new StringBuilder();
		
		strMenu.append(pizzeriaAscii);
		
		mapMenu.keySet().stream().forEach(op -> strMenu.append(op + "\n"));
		
		return strMenu.toString();
	}

	/* Méthode exécutant le bon menu suivant l'entrée au clavier de l'utilisateur
	 * @see fr.pizzeria.ihm.OptionMenu#execute(java.util.Scanner)
	 */
	public String execute(Scanner clavier) throws Exception {
		String userInput = clavier.nextLine();
		
		String keyMenu = mapMenu.keySet().stream()
										.filter(k -> k.substring(0, 3).trim().equals(userInput))
										.collect(Collectors.joining());
		
		return mapMenu.get(keyMenu).execute(clavier);
	}
	


}
