package model;

import java.awt.Button;
import java.awt.Insets;

import controller.GameController;
import controller.MonsterController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class HowTo{
	
	public void openWindow(Stage origStage) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HowTo.fxml"));
			Parent root = loader.load();						
			/*
			MonsterController scene2Controller = loader.getController();

			scene2Controller.transferArmor(armor); //set the players armor
			scene2Controller.transferEnemyInitialHealth(enemyInitialHealth);
			scene2Controller.transferController(scene1Controller); //send the ButtonController of gameplay.FXML
				*/			
			Stage howTo = new Stage();
			//makes main game area unaccessible till monster window is closed.
			howTo.initModality(Modality.APPLICATION_MODAL); 
			howTo.setTitle("How to Play");			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			howTo.setScene(scene);
			howTo.show();		
		} catch(Exception e) {
			e.printStackTrace();
		}
			
		}
	}
