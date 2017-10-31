package fr.pizzeria.ihm;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import com.github.lalyos.jfiglet.FigletFont;

@Controller
public class Menu {
	
	/** logger : Logger */
	@Autowired private Logger logger;
	
	/** clavier : Scanner */
	@Autowired private Scanner clavier;
	
	/** context : ApplicationContext */
	@Autowired private ApplicationContext context;
	
	/** mapMenu : Map<String,OptionMenu> */
	private Map<Integer, OptionMenu> optionMenu = new TreeMap<>();
	
	/** pizzeriaAscii : String */
	private String pizzeriaAscii = FigletFont.convertOneLine("Pizzeria");
	
	/** Méthode permettant d'initialiser la map contenant le menu
	 * @param clavier
	 */
	@PostConstruct
	public void init() {
		AtomicInteger incr = new AtomicInteger();
		
		Map<String, OptionMenu> mapMenu = context.getBeansOfType(OptionMenu.class);
		
		mapMenu.forEach((id, option) -> {
			optionMenu.put(incr.incrementAndGet(), option);
		});
		
		try {
			execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Méthode exécutant le bon menu suivant l'entrée au clavier de l'utilisateur
	 * @see fr.pizzeria.ihm.OptionMenu#execute(java.util.Scanner)
	 */
	public void execute() throws Exception {
		boolean continuer = true;
		
		while (continuer) {
			logger.info(pizzeriaAscii);
			
			optionMenu.forEach((cle, valeur) -> {
				logger.info(cle + "  ->  " + valeur.getLibelle());
			});
			
			int userInput = clavier.nextInt();
			
			continuer = optionMenu.get(userInput).execute();
		}
	}
	


}
