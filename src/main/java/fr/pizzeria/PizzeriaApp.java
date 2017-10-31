package fr.pizzeria;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.pizzeria.ihm.Menu;

import config.AppConfig;

public class PizzeriaApp {
	public static void main(String[] args) {
		PizzeriaApp app = new PizzeriaApp();
		app.execute();
	}
	
	public void execute() {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			Menu menu = context.getBean(Menu.class);
		}
	}
}
