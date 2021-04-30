package model;
import controller.ButtonController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.awt.Button;
import java.awt.Insets;
import controller.ButtonController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.IOException;

/*
 * goblin image only showing if i use absolute path, not sure if this will cause issue
 * but just a warning... abie just do it the way you did the other images
 */

public class Monster{
	public void openWindow(Stage origStage) {
		try {			
			Parent root = FXMLLoader.load(getClass().getResource("/view/Monster.fxml"));			
			Stage monsterStage = new Stage();
			//makes main game area unaccessible till monster window is closed.
			monsterStage.initModality(Modality.APPLICATION_MODAL); 
			monsterStage.setTitle("Monster Battle!");			
			Scene scene = new Scene(root,700,724);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			monsterStage.setScene(scene);
			monsterStage.show();
						
			/*
			 * add all the monster battle code and stuff below...
			 */
			
		} catch(Exception e) {
			e.printStackTrace();
		}
			
		}
	}
