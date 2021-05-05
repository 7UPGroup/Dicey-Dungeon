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

public class Menu{
	
	public void openWindow(Stage origStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/view/Mainview.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			origStage.setScene(scene);
			origStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
			
		}
	}
