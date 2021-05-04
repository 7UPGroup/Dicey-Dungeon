package model;
import controller.ButtonController;
import javafx.application.Application;
import javafx.fxml.FXML;
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
import javafx.scene.text.Text;

import java.io.IOException;

/*
 * goblin image only showing if i use absolute path, not sure if this will cause issue
 * but just a warning... abie just do it the way you did the other images
 */
public class Monster{
	public int openWindow(Stage origStage, int armor, int weaponID) {
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
			Parent root = FXMLLoader.load(getClass().getResource("/view/Monster.fxml"));						
			//Stage monsterStage = new Stage();
			//makes main game area unaccessible till monster window is closed.
			//origStage.initModality(Modality.APPLICATION_MODAL); 
			//origStage.setTitle("Monster Battle!");			
			Scene scene = new Scene(root,700,724);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			origStage.setScene(scene);
			origStage.show();
			*/
			/*
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Monster.fxml"));
			Parent root = loader.load(getClass().getResource("/view/Monster.fxml").openStream());	
			
			ButtonController dc = loader.getController();
			//you have to set all of the default values here
			dc.setarmorPoints(armor);
			dc.showarmorPoints(armor);
			//set all default values before here 
			
			//Parent root = FXMLLoader.load(getClass().getResource("/view/Monster.fxml"));			
			Stage monsterStage = new Stage();
			//makes main game area unaccessible till monster window is closed.
			monsterStage.initModality(Modality.APPLICATION_MODAL); 
			monsterStage.setTitle("Monster Battle!");			
			Scene scene = new Scene(root,700,724);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			monsterStage.setScene(scene);
			monsterStage.show();
			monsterStage.setOnCloseRequest(event -> {
			
			//dc.sendArmorAfterFight(armor);
			});
			
			
			
			
			/*
			 * add all the monster battle code and stuff below...
			 */
			//FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Monster.fxml"));
			//ButtonController tempController = new ButtonController();
			//tempController.armorPoints = 5;
			//System.out.println("Set armor points to 5");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return armor;
			
		}
	}
