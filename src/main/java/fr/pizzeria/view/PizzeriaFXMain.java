package fr.pizzeria.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PizzeriaFXMain extends Application {
	
	@Override
	public void start(Stage stage) throws IOException {		
		Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));     
		
		Scene scene = new Scene(root);
		      
		stage.setScene(scene);
		
		stage.setMinWidth(600);
		stage.setMinHeight(600);
		
		stage.setTitle("MiamPizza");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
