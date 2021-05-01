package model;

import java.awt.Button;
import java.awt.Insets;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Start{
	
	public void openWindow(Stage origStage, int num) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/view/gamePlay.fxml"));
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
