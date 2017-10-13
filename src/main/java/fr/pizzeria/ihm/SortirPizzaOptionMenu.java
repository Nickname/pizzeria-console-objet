package fr.pizzeria.ihm;

import java.util.Scanner;

import com.github.lalyos.jfiglet.FigletFont;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;

public class SortirPizzaOptionMenu extends OptionMenu {

    /** byeAscii : String */
    private String byeAscii = FigletFont.convertOneLine("Bye...");

	/* Exécution du menu pour sortir de l'appli
	 * @see fr.pizzeria.ihm.OptionMenu#execute(java.util.Scanner)
	 */
	protected String execute(Scanner clavier) throws Exception {
		PizzeriaAdminConsoleApp.exit();
		return byeAscii;
	}

}
