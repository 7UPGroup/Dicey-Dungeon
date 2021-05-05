package model;

import java.awt.Button;

import java.awt.Insets;

import controller.GameController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;


//private Text results;

public class EndScreen{
	
	public void openWinWindow(Stage origStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/view/WinEndScreen.fxml"));
			//set the scene to scenebuilder
			Scene scene = new Scene(root,700,724);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			origStage.setScene(scene);
			origStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
			
		}
	public void openLoseWindow(Stage origStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/view/LoseEndScreen.fxml"));
			//set the scene to scenebuilder
			Scene scene = new Scene(root,700,724);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			origStage.setScene(scene);
			origStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
			
		}
	}
