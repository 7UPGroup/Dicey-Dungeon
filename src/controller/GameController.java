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
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Start;
import model.EndScreen;
import model.HowTo;
import model.Menu;
import model.Monster;

public class GameController {
	/**
	 * FXML buttons and text boxes for main menu and game windows
	 */
		@FXML
		private Button returnToMenu;
		@FXML
		private Button startButton;
		@FXML
		private Button howToPlayButton;
		@FXML
		private Text loseScreenText;
		public void updateLoseScreenText(String Text) {
			loseScreenText.setText(Text);
		}
		
		@FXML
		private Text winScreenText;
		public void updateWinScreenText(String Text) {
			winScreenText.setText(Text);
		}
		@FXML
		private TextArea results;

		@FXML
		private TextArea armorPointsTextBox;
		public void updatearmorPointsTextBox(int num) {
			armorPointsTextBox.setText(String.valueOf("Armor: " + num));
		}

		@FXML
		private Button button00; 	
		@FXML
		private Button button01; 	
		@FXML
		private Button button02; 	
		@FXML
		private Button button03; 	
		@FXML
		private Button button10; 	
		@FXML
		private Button button11; 	
		@FXML
		private Button button12; 	
		@FXML
		private Button button13; 	
		@FXML
		private Button button20; 	
		@FXML
		private Button button21; 	
		@FXML
		private Button button22; 	
		@FXML
		private Button button23; 
		
		/**
		 * Opening the how to window in main screen
		 * @param event button event
		 */
		public void openHowToWindow(ActionEvent event) {
			try {
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
			Button btn = (Button) event.getSource(); //get fx:id of whatever button was pressed
		    Stage CurrentStage = (Stage) btn.getScene().getWindow();
		    CurrentStage.close();
		}
		
		public int attackPoints = 3; //default attack points
		
		public int totalClicks = 0;
		
		public int armorPoints = 3; //default value for armor points
		public void setarmorPoints(int val) {
			System.out.println("setarmorPoints: " + val);
			this.armorPoints = val;
		}
		/*
		public void showarmorPoints(int val) {
			playerHealth.setText(String.valueOf(armorPoints));
		}
		*/
		public int monsterHitPoints = 5; //default enemy health
		private static Stage origStage;
		
		public Stage returnStage() {
			return origStage;
		}
		
		
		/* create Start class object called pressedButton*/
		Menu menuButton = new Menu();
		Monster monsterEvent = new Monster();
		
		/*
		 * this function grabs the primary stage from the Main.java
		 */
		public void getStage(Stage primaryStage) {
			origStage = primaryStage;
		}
		
		/*
		 * This function is called when the user presses the "Click me to start" button
		 * on the main screen and changes it to the gamePlay.fxml / Start.java screen
		 */
		public void startButton(ActionEvent event)throws IOException{
			Start pressedButton = new Start();		
			pressedButton.openWindow(origStage);
		}
		/*
		 * This function is called on the gameplay screen to go back to the main menu
		 */
		public void returnToMenu(ActionEvent event)throws IOException{
			System.out.println("Return to Menu button pressed");								
			menuButton.openWindow(origStage);			
		}
		
		public void updateResults(String msg) {
			results.setText(String.valueOf(msg));
		}
		/*
		 * function to handle when the user presses a button on the grid
		 */
		public void gridButtonPressed(ActionEvent event)throws IOException{
			//armorPointsTextBox.setText(String.valueOf("Armor: " + armorPoints));
			
			
			updatearmorPointsTextBox(armorPoints);
			int min = 1; //inclusive min value adjust these and the if statements to change likelyhood of an option 
			int max = 3; //inclusive max value
			int randomValue = 0;			
			
			Button btn = (Button) event.getSource(); //get fx:id of whatever button was pressed
			String id = btn.getId(); //String id = fx:id of button pressed
			System.out.print(id + " PRESSED");
			System.out.println("Grid button was pressed");	
			
			/*
			 * using this eventually to check location of the button pressed
			 * and then only allow buttons next to it to be pressed
			*/
			String buttonColumn = id.substring(id.length() - 1);
			String buttonRow	= id.substring(id.length() - 2);
			int row = Integer.parseInt(buttonRow);
			int column = Integer.parseInt(buttonColumn);
			
			randomValue = (int)Math.floor(Math.random()*(max-min+1)+min); //generate random value
			System.out.println("Random Event Value: " + randomValue); //print the random value
						
			/* Disables btn from being pressed again but makes color lighter unfortunately */
			btn.setDisable(true); 
			
			
			
			//need to fix the last square when fighting a monster
			
			if (randomValue == 1) { //adjust this and the min/max statements to change likelihood of an option
				updatearmorPointsTextBox(armorPoints);
				btn.setStyle("-fx-background-color: #F6FF64"); //YELLOW - TREASURE
				updateResults("CONGRATS! YOU'VE FOUND TREASURE... \n+1 ARMOR");
				armorPoints++; //add 1 armor point
				//armorPointsTextBox.setText(String.valueOf("Armor: " + armorPoints));
				updatearmorPointsTextBox(armorPoints);
				totalClicks++;
			}
			
			else if (randomValue == 2) { 
				btn.setStyle("-fx-background-color: #FF0000"); //RED - ENEMY		
				/*
				 * OPEN ENEMY ENCOUNTER WINDOW...
				 * see attack and block actionEvent handler function below
				 */
				//armorPoints--;
				System.out.println("About to open window");
				//monsterEvent.openWindow(origStage, armorPoints, weaponIDplaceholder);
				
				
				
				//monsterEvent.openWindow(origStage, armorPoints, weaponIDplaceholder, menuButton);
				//test
				System.out.println("Test");
				int ranMonHealth = (int)Math.floor(Math.random()*(5-4+1)+4);
				monsterEvent.openWindow(origStage, armorPoints, ranMonHealth, this);
				System.out.println("opened window");
				
				updatearmorPointsTextBox(armorPoints);
				totalClicks++;
								
			}
			else if (randomValue == 3) { 
				updatearmorPointsTextBox(armorPoints);				
				btn.setStyle("-fx-background-color: #FFFFFF"); //WHITE - NOTHING/BLANK TILE
				updateResults("EMPTY AREA...");
				totalClicks++;
			}
			
			if (totalClicks == 12) {
				EndScreen winScreen = new EndScreen();
				winScreen.openWinWindow(returnStage(), armorPoints);
			}

			updatearmorPointsTextBox(armorPoints);
			
			
		}
}

