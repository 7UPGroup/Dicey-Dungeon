package model;

import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HowTo{
	/**
	 * opens how to window for player to look at instructions to the game
	 * @param origStage
	 */
	public void openWindow(Stage origStage) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HowTo.fxml"));
			Parent root = loader.load();						
			
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
