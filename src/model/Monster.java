package model;
import controller.GameController;
import controller.MonsterController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.awt.Button;
import java.awt.Insets;
import controller.GameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class Monster{
	public void openWindow(Stage origStage, int armor, int enemyInitialHealth, GameController scene1Controller) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Monster.fxml"));
			Parent root = loader.load();						
			MonsterController scene2Controller = loader.getController();

			scene2Controller.transferArmor(armor); //set the players armor
			scene2Controller.transferEnemyInitialHealth(enemyInitialHealth);
			scene2Controller.transferController(scene1Controller); //send the ButtonController of gameplay.FXML
							
			Stage monsterStage = new Stage();
			//makes main game area unaccessible till monster window is closed.
			monsterStage.initModality(Modality.APPLICATION_MODAL); 
			monsterStage.setTitle("Monster Battle!");			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			monsterStage.setScene(scene);
			monsterStage.show();			
			
		} catch(Exception e) {
			e.printStackTrace();
		}

			
		}
	}
