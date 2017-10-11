package fr.pizzeria.ihm;

import com.github.lalyos.jfiglet.FigletFont;

public class PrincipalOptionMenu {
	
	public static void execute() {
        String pizzeriaAscii = FigletFont.convertOneLine("Pizzeria");

        StringBuilder strMenu = new StringBuilder(pizzeriaAscii);
        
        strMenu.append("1. Lister les pizzas\r\n");
		strMenu.append("2. Ajouter une nouvelle pizza\r\n");
		strMenu.append("3. Mettre à jour une pizza\r\n");
		strMenu.append("4. Supprimer une pizza\r\n");
		strMenu.append("99. Sortir");
        
		System.out.println(strMenu.toString());
	}
}
