package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Start;

public class ButtonController {
		@FXML
		private Label button; 	
		//@FXML
		//private TextField input;
		//@FXML
		//private TextArea results;
		private static Stage origStage;
		
		Start pressedButton = new Start();
		
		public void getStage(Stage primaryStage) {
			origStage = primaryStage;
		}
		
		public void startButton(ActionEvent event)throws IOException{
			//Start pressedButton = new Start();
			
			pressedButton.openWindow(origStage);
			
			
		}
		
	/**
	 * public void handle(ActionEvent event) throws IOException {
		disneyMovies.readFiles();
		String userInput = input.getText();
		for(Movies movie: disneyMovies.getMovieList()) {	
        	if(movie.getName().equals(userInput)) {
        		results.setText(movie.toString());
        		results.appendText((movie.getCast().toString()
        				.replace("[", "").replace("]", "").replace(",", "")));
        		break;
        		}
        	else{
        		results.setText("Could not find movie...");
        	}
        }
	}
	 */
}
