package model;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Menu{
	/**
	 * opens window for the main menu where player can actually start game
	 * @param origStage
	 */
	public void openWindow(Stage origStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			origStage.setScene(scene);
			origStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
