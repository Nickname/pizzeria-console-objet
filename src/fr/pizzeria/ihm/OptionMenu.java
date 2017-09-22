package fr.pizzeria.ihm;

import fr.pizzeria.exception.BadInputException;

abstract class OptionMenu {
	
	protected abstract void execute() throws BadInputException;
}
