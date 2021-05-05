package model;

import java.awt.Button;
import java.awt.Insets;

import controller.GameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class EndScreen{
	
	public void openWinWindow(Stage origStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/view/Mainview.fxml"));
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

			Parent root = FXMLLoader.load(getClass().getResource("/view/Mainview.fxml"));
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
