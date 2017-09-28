package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.exception.*;

abstract class OptionMenu {
	
	protected abstract void execute(Scanner clavier) throws BadInputException, SavePizzaException, DeletePizzaException, UpdatePizzaException;
}
