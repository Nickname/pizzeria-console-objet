package fr.pizzeria.console;

import fr.pizzeria.ihm.*;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PizzeriaAdminConsoleApp {
	/** LOG : Logger */
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	/** clavier : Scanner */
	public static final Scanner clavier = new Scanner(System.in);
	/** out : boolean */
	private static boolean out = false;

	/** Méthode main
	 * @param args
	 */
	public static void main(String[] args) {
		PizzeriaAdminConsoleApp app = new PizzeriaAdminConsoleApp();
		app.execute();
	}
	
	/** Méthode principale : lance l'exécution de la pizzeria
	 * 
	 */
	public void execute() {
		PrincipalPizzaOptionMenu menuPrincipal = PrincipalPizzaOptionMenu.getInstance();
		menuPrincipal.initMenu();
		
		while (!out) {
			try {
				LOG.info(menuPrincipal.affichMenu());
				LOG.info(menuPrincipal.execute(clavier));
			} catch (Exception e) {
				LOG.info(e.getMessage());
			}
		}
		
		clavier.close();
	}
	
	public static void exit() {
		out = true;
	}
	
}
