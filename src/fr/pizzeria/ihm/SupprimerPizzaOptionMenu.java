package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	Scanner clavier;
	
	public SupprimerPizzaOptionMenu(Scanner clavier) {
		this.clavier = clavier;
	}
	
	public void execute() {
		PizzaDaoImpl four = PizzaDaoImpl.getInstance();
		ListerPizzasOptionMenu listerPizza = new ListerPizzasOptionMenu(clavier);
		
		System.out.println("Suppression d’une pizza\n");
		listerPizza.execute();
		System.out.println("Veuillez saisir le code de la pizza à supprimer :\n");
		System.out.println("(99 pour abandonner)\n");
		String code = clavier.next();
		
		four.deletePizza(code);
	}
	
}
