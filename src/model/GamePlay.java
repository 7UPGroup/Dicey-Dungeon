package model;

import controller.GameController;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GamePlay{
	/**
	 * opens game play window for player to start their journey
	 * @param origStage
	 */
	public void openWindow(Stage origStage) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GamePlay.fxml"));
				Parent root = loader.load();
				GameController intializeArmorPoints = loader.getController();
				intializeArmorPoints.updatearmorPointsTextBox(3); //initialize armor to say 3 on gamePlay window
				//set the scene to scenebuilder
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				origStage.setScene(scene);
				origStage.show();

			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
