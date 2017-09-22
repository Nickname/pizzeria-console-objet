package fr.pizzeria.console;

import fr.pizzeria.exception.BadInputException;
import fr.pizzeria.ihm.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PizzeriaAdminConsoleApp {
	public static Scanner clavier = new Scanner(System.in);
	boolean out = false;

	public static void main(String[] args) {
		PizzeriaAdminConsoleApp app = new PizzeriaAdminConsoleApp();
		app.execute();
	}

	public void execute() {
		do {
			try {
				this.interfacePizza();
				int userInput = 
				int userInput = clavier.nextInt();
				switch (userInput) {
					case 1:
						ListerPizzasOptionMenu listerMenu = new ListerPizzasOptionMenu(clavier);
						listerMenu.execute();
						break;
					case 2:
						AjouterPizzaOptionMenu ajoutMenu = new AjouterPizzaOptionMenu(clavier);
						ajoutMenu.execute();
						break;
					case 3:
						ModifierPizzaOptionMenu modifPizza = new ModifierPizzaOptionMenu(clavier);
						modifPizza.execute();
						break;
					case 4:
						SupprimerPizzaOptionMenu supprPizza = new SupprimerPizzaOptionMenu(clavier);
						supprPizza.execute();
						break;
					case 99:
						System.out.println("Au revoir!");
						out = true;
						break;
					default:
						System.out.println("Non pris en compte...");
				}
			} catch (BadInputException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("Non respect du formatage...");
			}
		} while (!out);
		
		clavier.close();
	}

	public void interfacePizza() {
		System.out.println("***** Pizzeria Administration *****\r\n" 
				+ "1. Lister les pizzas\r\n"
				+ "2. Ajouter une nouvelle pizza\r\n" 
				+ "3. Mettre à jour une pizza\r\n"
				+ "4. Supprimer une pizza\r\n"
				+ "99. Sortir");
	}

}
