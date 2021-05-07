package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.EndScreen;
import model.Menu;
import model.Monster;

public class GameController {
	/**
	 * FXML buttons and text boxes for game play window. 
	 */
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
		@FXML
		private Text loseScreenText;
		@FXML
		private Text winScreenText;
		@FXML
		private TextArea results; 
		@FXML
		private TextArea armorPointsTextBox;
		@FXML
		
		/**
		 * global variables for game play window
		 */
		public int attackPoints = 3; //default attack points
		public int totalClicks = 0; //count number of boxes clicked
		public int armorPoints = 3; //default value for armor points
		public int monsterHitPoints = 5; //default enemy health
		private static Stage origStage; //original window, use to change scene
		Menu menuButton = new Menu(); //creating a Menu object to return to menu
		Monster monsterEvent = new Monster(); //creating a Monster object to open Monster Battle
		
		/**
		 * shows text on lose screen
		 * @param Text shows monster damage and armor left
		 */
		public void updateLoseScreenText(String Text) {
			loseScreenText.setText(Text);
		}
		
		/**
		 * shows text on win screen
		 * @param Text shows armor left when you successfully left dungeon
		 */
		public void updateWinScreenText(String Text) {
			winScreenText.setText(Text);
		}
		
		/**
		 * sets armorPoints
		 * @param val
		 */
		public void setarmorPoints(int val) {
			this.armorPoints = val;
		}
		/**
		 * updates armor text box on GamePlay screen
		 * @param num
		 */
		public void updatearmorPointsTextBox(int num) {
			armorPointsTextBox.setText(String.valueOf("Armor: " + num));
		}
		
		/**
		 * returns the original menu stage
		 * @return
		 */
		public Stage returnStage() {
			return origStage;
		}
		
		/**
		 * this method grabs the primary stage from the Main.java
		 * @param primaryStage
		 */
		public void getStage(Stage primaryStage) {
			origStage = primaryStage;
		}
		
		/**
		 * This function is called on the gameplay screen to go back to the main menu
		 * @param event when button is pressed 
		 * @throws IOException
		 */
		public void returnToMenu(ActionEvent event)throws IOException{								
			menuButton.openWindow(origStage);		
		}
		
		/**
		 * updates the result screen on the bottom of the GamePlay window
		 * @param msg
		 */
		public void updateResults(String msg) {
			results.setText(String.valueOf(msg));
		}
		
		/**
		 * function to handle when the user presses a button on the grid
		 * @param event when button is pressed
		 * @throws IOException
		 */
		public void gridButtonPressed(ActionEvent event)throws IOException{
			updatearmorPointsTextBox(armorPoints);
			int min = 1, max =3, randomBox = 0; //random value variables		
			
			Button btn = (Button) event.getSource(); //get fx:id of whatever button was pressed
			//String id = btn.getId(); //String id = fx:id of button pressed
			
			/*
			 * using this eventually to check location of the button pressed
			 * and then only allow buttons next to it to be pressed
			*/
			//String buttonColumn = id.substring(id.length() - 1);
			//String buttonRow	= id.substring(id.length() - 2);
			
			randomBox = (int)Math.floor(Math.random()*(max-min+1)+min); //generate random value
			//System.out.println("Random Event Value: " + randomBox); //print the random value
						
			btn.setDisable(true); //Disables btn from being pressed again but makes color lighter unfortunately
			
			totalClicks++;
			
			//player will gain an additional piece of armor
			if (randomBox == 1) {
				btn.setStyle("-fx-background-color: #F6FF64"); //YELLOW - TREASURE
				updateResults("CONGRATS! YOU'VE FOUND TREASURE... \n+1 ARMOR");
				armorPoints++; //add 1 armor point
			}
			//player will fight monster
			else if (randomBox == 2 && totalClicks != 12) { 
				btn.setStyle("-fx-background-color: #FF0000"); //RED - ENEMY		
				int ranMonHealth = (int)Math.floor(Math.random()*(5-4+1)+4);
				monsterEvent.openWindow(armorPoints, ranMonHealth, this);					
			}
			//player finds nothing
			else if (randomBox == 3) { 			
				btn.setStyle("-fx-background-color: #FFFFFF"); //WHITE - NOTHING/BLANK TILE
				updateResults("EMPTY AREA...");
			}
			//if player goes through entire dungeon they win
			if (totalClicks == 12) {
				EndScreen winScreen = new EndScreen();
				if ((randomBox == 1))
					winScreen.openWinWindow(returnStage(), armorPoints, "You found treasure and gained 1 armor!\n");
				else 
					winScreen.openWinWindow(returnStage(), armorPoints, "You found an empty area!\n");
			}
			//update armor
			updatearmorPointsTextBox(armorPoints);
		}
}

