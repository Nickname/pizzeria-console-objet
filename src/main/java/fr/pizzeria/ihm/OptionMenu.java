package fr.pizzeria.ihm;

import java.util.Scanner;

abstract class OptionMenu {
	
	/** Méthode abstraite des classes de Menus
	 * @param clavier
	 * @return
	 * @throws Exception
	 */
	protected abstract String execute(Scanner clavier) throws Exception;
}
