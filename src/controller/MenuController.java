package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.GamePlay;
import model.HowTo;

public class MenuController {
	/**
	 * FXML buttons for main menu
	 */
	@FXML
	private Button returnToMenu;
	@FXML
	private Button startButton;
	@FXML
	private Button howToPlayButton;
	
	/**
	 * using to reset the stage for the menu
	 */
	GameController stageReturn = new GameController(); //GameController object for getting original stage
	private static Stage origStage; //creating global variable for stage
	
	/**
	 * Opening the how to window in main screen
	 * @param event button event
	 */
	public void openHowToWindow(ActionEvent event) {
		try {
			origStage = stageReturn.returnStage();
			HowTo howToWindow = new HowTo();
			howToWindow.openWindow(origStage);
		}
		catch(Exception e) {
			System.out.println("Couldn't load how to window");
		}
	}
	
	/**
	 * closing the how to window in main screen
	 * @param event button
	 */
	public void closeHowToWindow(ActionEvent event) {
		origStage = stageReturn.returnStage();
		Button btn = (Button) event.getSource(); //get fx:id of whatever button was pressed
	    Stage CurrentStage = (Stage) btn.getScene().getWindow();
	    CurrentStage.close();
	}
	
	/*
	 * This function is called when the user presses the "Click me to start" button
	 * on the main screen and changes it to the gamePlay.fxml / Start.java screen
	 */
	public void startButton(ActionEvent event)throws IOException{
		origStage = stageReturn.returnStage();
		GamePlay pressedButton = new GamePlay();		
		pressedButton.openWindow(origStage);
	}
}
