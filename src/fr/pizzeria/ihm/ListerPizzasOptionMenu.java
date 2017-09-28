package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu {
	private IPizzaDao four;
	
	public ListerPizzasOptionMenu(IPizzaDao four) {
		this.four = four;
	}
	
	public void execute(Scanner clavier) {
		System.out.println("Liste des pizzas\n");
		String affich = new String();
		
		for (Pizza pizza : four.findAllPizzas()) {
			affich += pizza.toString() + "\n";
		}
		System.out.println(affich);
	}
}
