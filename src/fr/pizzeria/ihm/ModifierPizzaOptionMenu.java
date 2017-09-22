package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {
	Scanner clavier;
	
	public ModifierPizzaOptionMenu(Scanner clavier) {
		this.clavier = clavier;
	}

	public void execute() {
		PizzaDaoImpl four = PizzaDaoImpl.getInstance();
		ListerPizzasOptionMenu listerPizza = new ListerPizzasOptionMenu(clavier);
		
		System.out.println("Mise à jour d’une pizza\n");
		listerPizza.execute();
		System.out.println("Veuillez saisir le code de la pizza à modifier :\n");
		System.out.println("(99 pour abandonner)\n");
		String code = clavier.next();
		System.out.println("Veuillez saisir le nom (sans espace) :\n");
		String nom = clavier.next();
		System.out.println("Veuillez saisir le prix");
		double prix = clavier.nextDouble();
		
		Pizza pizza = new Pizza(code, nom, prix);
		four.updatePizza(code, pizza);
	}
}
