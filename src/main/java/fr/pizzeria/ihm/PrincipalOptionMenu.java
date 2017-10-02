package fr.pizzeria.ihm;

import com.github.lalyos.jfiglet.FigletFont;

public class PrincipalOptionMenu {
	
	public static void execute() {
        String pizzeriaAscii = FigletFont.convertOneLine("Pizzeria");

		System.out.println(pizzeriaAscii
                	+ "1. Lister les pizzas\r\n"
				+ "2. Ajouter une nouvelle pizza\r\n"
				+ "3. Mettre à jour une pizza\r\n"
				+ "4. Supprimer une pizza\r\n"
				+ "99. Sortir");
	}
}
