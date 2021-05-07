package model;
import java.awt.Button;

import java.awt.Insets;

import controller.GameController;
import controller.MonsterController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class EndScreen{
	
	public void openWinWindow(Stage origStage, int armor) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/WinEndScreen.fxml"));
			Parent root = loader.load();
			GameController setText = loader.getController();
			setText.updateWinScreenText("You won with a score of " + armor + "!"); //set the players armor
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());						
			origStage.setScene(scene);
			origStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}			
		}
	public void openLoseWindow(Stage origStage, int val, int damage){//, GameController ControllerScene1) {
		try {						
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoseEndScreen.fxml"));
			Parent root = loader.load();						
			GameController scene2Controller = loader.getController();
			scene2Controller.updateLoseScreenText("Monster dealt " + damage + " damage and you only had " + val + " left"); //set the players armor

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
									
			origStage.setScene(scene);
			origStage.show();			

		} catch(Exception e) {
			e.printStackTrace();
		}
			
		}
	}
