package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.exception.*;

abstract class OptionMenu {
	
	protected abstract String execute(Scanner clavier) throws Exception;
}
