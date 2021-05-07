package model;

import controller.GameController;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class EndScreen{
	
	/**
	 * opens window letting player know they won
	 * @param origStage change the scene of the original stage
	 * @param armor end armor/score for player
	 */
	public void openWinWindow(Stage origStage, int armor, String msg) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/WinEndScreen.fxml"));
			Parent root = loader.load();
			GameController setText = loader.getController();
			setText.updateWinScreenText(msg + "You won with a score of " + armor + "!"); //allows player to see their score
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());						
			origStage.setScene(scene);
			origStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}			
	}
	/**
	 * opens window letting player know they lost
	 * @param origStage change scene of original stage
	 * @param armor armor player had left
	 * @param damage damage monster dealt to them
	 */
	public void openLoseWindow(Stage origStage, int armor, int damage){
		try {						
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoseEndScreen.fxml"));
			Parent root = loader.load();						
			GameController scene2Controller = loader.getController();
			scene2Controller.updateLoseScreenText("Monster dealt " + damage + " damage and you only had " + armor + " left"); //set the players armor

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
									
			origStage.setScene(scene);
			origStage.show();			

		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
