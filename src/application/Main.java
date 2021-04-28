package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
/**
 * @name Main.java
 * The Main class is the driver of our program that allows the user to search through
 * a csv tfile of movies
 * 
 * @author Randolph Sewell (qto630) Abie Faz (gcw022)
 */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//load the fxml file
			Parent root = FXMLLoader.load(getClass().getResource("/view/Mainview.fxml"));
			//set the scene to scenebuilder
			Scene scene = new Scene(root,700,724);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}