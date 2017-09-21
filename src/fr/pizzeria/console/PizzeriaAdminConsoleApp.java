package fr.pizzeria.console;

import fr.pizzeria.model.Pizza;
import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		PizzeriaAdminConsoleApp app = new PizzeriaAdminConsoleApp();
		app.execute();
	}

	public void execute() {
		Scanner clavier = new Scanner(System.in);
		Pizza[] pizzas = this.initPizzas();

		int userInput = 0;

		do {
			this.interfacePizza();
			userInput = clavier.nextInt();
			switch (userInput) {
				case 1:
					System.out.println("Liste des pizzas\n");
					System.out.println(this.allPizzas(pizzas));
					break;
				case 2:
					System.out.println("Ajout d’une nouvelle pizza\n");
					System.out.println("Veuillez saisir le code :\n");
					String code = clavier.next();
					System.out.println("Veuillez saisir le nom (sans espace) :\n");
					String nom = clavier.next();
					System.out.println("Veuillez saisir le prix");
					double prix = clavier.nextDouble();
					this.addPizza(pizzas, code, nom, prix);
					break;
				case 3:
					System.out.println("Mise à jour d’une pizza\n");
					System.out.println(allPizzas(pizzas));
					System.out.println("Veuillez saisir le code de la pizza à modifier :\n");
					System.out.println("(99 pour abandonner)\n");
					String modCode = clavier.next();
					System.out.println("Veuillez saisir le nom (sans espace) :\n");
					String modNom = clavier.next();
					System.out.println("Veuillez saisir le prix");
					double modPrix = clavier.nextDouble();
					this.modifPizza(pizzas, modCode, modNom, modPrix);
					break;
				case 4:
					System.out.println("Suppression d’une pizza\n");
					System.out.println(allPizzas(pizzas));
					System.out.println("Veuillez saisir le code de la pizza à supprimer :\n");
					System.out.println("(99 pour abandonner)\n");
					String delCode = clavier.next();
					this.deletePizza(pizzas, delCode);
					break;
				case 99:
					System.out.println("Au revoir!");
					break;
			}
		} while (userInput != 99);

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

	public Pizza[] initPizzas() {
		Pizza[] pizzas = new Pizza[50];

		pizzas[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza(2, "REIN", "La Reine", 11.50);
		pizzas[3] = new Pizza(3, "FRO", "La 4 Fromages", 12.00);
		pizzas[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		pizzas[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		pizzas[6] = new Pizza(6, "ORI", "L'orientale", 13.50);
		pizzas[7] = new Pizza(7, "IND", "L'indienne", 14.00);

		return pizzas;
	}

	public String allPizzas(Pizza[] pizzas) {
		String affich = new String();

		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				affich += pizzas[i].toString() + "\n";
			}
		}

		return affich;
	}
	
	public void addPizza(Pizza[] pizzas, String code, String nom, double prix) {
		boolean added = false;
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] == null && added == false) {
				pizzas[i] = new Pizza(i, code, nom, prix);
				added = true;
			}
		}
	}
	
	public void modifPizza(Pizza[] pizzas, String code, String nom, double prix) {
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null && pizzas[i].getCode().equals(code)) {
				pizzas[i] = null;
				pizzas[i] = new Pizza(i, code, nom, prix);
			}
		}
	}

	public void deletePizza(Pizza[] pizzas, String code) {
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null && pizzas[i].getCode().equals(code)) {
				pizzas[i] = null;
			}
		}
	}

}
