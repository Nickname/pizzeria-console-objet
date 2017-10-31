package config;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;

import fr.pizzeria.PizzeriaApp;

@Configuration
@ComponentScan({ "fr.pizzeria.dao","fr.pizzeria.ihm" })
public class AppConfig {
	
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
	
	@Bean
	public Logger logger() {
		return LoggerFactory.getLogger(PizzeriaApp.class);
	}
}
