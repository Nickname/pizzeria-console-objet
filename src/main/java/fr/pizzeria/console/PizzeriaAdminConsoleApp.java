package fr.pizzeria.console;

import fr.pizzeria.dao.*;
import fr.pizzeria.exception.*;
import fr.pizzeria.ihm.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.github.lalyos.jfiglet.FigletFont;

public class PizzeriaAdminConsoleApp {
	public static Scanner clavier = new Scanner(System.in);
    boolean out = false;
	String userInput;

	public static void main(String[] args) {
		PizzeriaAdminConsoleApp app = new PizzeriaAdminConsoleApp();
		app.execute();
	}

	public void execute() {
		IPizzaDao four = PizzaDaoImpl.getInstance();

		do {
			try {
				userInput = "0";
				this.interfacePizza();
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
	}

	public void interfacePizza() {
        String pizzeriaAscii = FigletFont.convertOneLine("Pizzeria");

		System.out.println(pizzeriaAscii
                + "1. Lister les pizzas\r\n"
				+ "2. Ajouter une nouvelle pizza\r\n"
				+ "3. Mettre à jour une pizza\r\n"
				+ "4. Supprimer une pizza\r\n"
				+ "99. Sortir");
	}

}
