package fr.pizzeria.console;

import fr.pizzeria.ihm.*;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PizzeriaAdminConsoleApp {
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	public static final Scanner clavier = new Scanner(System.in);
	
	boolean out = false;
	String userInput = "0";

	public static void main(String[] args) {
		PizzeriaAdminConsoleApp app = new PizzeriaAdminConsoleApp();
		app.execute();
	}

	
	public void execute() {
		PrincipalPizzaOptionMenu menuPrincipal = PrincipalPizzaOptionMenu.getInstance();
		menuPrincipal.initMenu(clavier);
		
		do {
			menuPrincipal.affichMenu();
			//LOG.info(menuPrincipal.execute(clavier));
		} while (!out);
	}
	
/*	public void execute() {
		IPizzaDao four = PizzaDaoImpl.getInstance();

		do {
			try {
				userInput = "0";
				PrincipalOptionMenu.execute();
				userInput = clavier.nextLine();
				switch (userInput) {
					case "1":
						ListerPizzasOptionMenu listerMenu = new ListerPizzasOptionMenu(four);
						listerMenu.execute(clavier);
						break;
					case "2":
						AjouterPizzaOptionMenu ajoutMenu = new AjouterPizzaOptionMenu(four);
						ajoutMenu.execute(clavier);
						break;
					case "3":
						ModifierPizzaOptionMenu modifPizza = new ModifierPizzaOptionMenu(four);
						modifPizza.execute(clavier);
						break;
					case "4":
						SupprimerPizzaOptionMenu supprPizza = new SupprimerPizzaOptionMenu(four);
						supprPizza.execute(clavier);
						break;
					case "99":
						System.out.println("Au revoir!");
						out = true;
						break;
				}
			} catch (BadInputException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("Non respect du formatage...");
			} catch (StockageException e) {
				System.out.println(e.getMessage());
			}
		} while (!out);

		clavier.close();
	}*/
}
