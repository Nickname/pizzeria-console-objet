package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu {
	Scanner clavier;
	
	public ListerPizzasOptionMenu(Scanner clavier) {
		this.clavier = clavier;
	}
	
	public void execute() {
		PizzaDaoImpl four = PizzaDaoImpl.getInstance();
		
		System.out.println("Liste des pizzas\n");
		String affich = new String();
		
		Pizza[] pizzas = four.findAllPizzas();
		
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				affich += pizzas[i].toString() + "\n";
			} else {
				break;
			}
		}
		System.out.println(affich);
		
	}
}
