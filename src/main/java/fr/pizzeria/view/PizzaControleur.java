package fr.pizzeria.view;

import java.net.URL;
import java.util.ResourceBundle;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class PizzaControleur implements Initializable{

	@FXML
	ListView<Pizza> listPizzas;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		IPizzaDao dao = PizzaDaoImpl.getInstance();
		
		listPizzas.getItems().setAll(dao.findAllPizzas());
	}



}
