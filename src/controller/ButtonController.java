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
import model.Menu;
import model.Monster;

public class ButtonController {
	//start code folding - will add later java doesn't support it natively like C does
		@FXML
		private Text playerHealth;
		@FXML
		private Button attackButton;
		@FXML
		private Button blockButton;		
		@FXML
		private TextArea results;
		@FXML
		private Text monsterHealth;
		@FXML
		private TextArea armorPointsTextBox;
		public void updatearmorPointsTextBox(int num) {
			armorPointsTextBox.setText(String.valueOf("Armor: " + num));
		}
		public void sendArmorAfterFight(int num) {
			updatearmorPointsTextBox(num);
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
		
	//end code folding - will add later java doesn't support it natively like C does
		
		public int clickedCount = 0; //tally of how many times a button has been pressed;
		public int attackPoints = 3; //default attack points
		
		
		public int armorPoints = 3; //default value for armor points
		public void setarmorPoints(int val) {
			this.armorPoints = val;
		}
		public void showarmorPoints(int val) {
			playerHealth.setText(String.valueOf(armorPoints));
		}
		
		public int monsterHitPoints = 5; //default enemy health
		private static Stage origStage;
		private static int number =7;
		/* create Start class object called pressedButton*/
		Start pressedButton = new Start();
		Menu menuButton = new Menu();
		Monster monsterEvent = new Monster();
		
		/*
		 * this function grabs the primary stage from the Main.java
		 */
		public void getStage(Stage primaryStage, int num) {
			origStage = primaryStage;
			number = num;
		}
		
		/*
		 * This function is called when the user presses the "Click me to start" button
		 * on the main screen and changes it to the gamePlay.fxml / Start.java screen
		 */
		public void startButton(ActionEvent event)throws IOException{
			//Start pressedButton = new Start();			
			pressedButton.openWindow(origStage, number);						
		}
		/*
		 * This function is called on the gameplay screen to go back to the main menu
		 */
		public void returnToMenu(ActionEvent event)throws IOException{
			System.out.println("Return to Menu button pressed");								
			menuButton.openWindow(origStage);			
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
			System.out.println(id + " PRESSED");
			System.out.println("Grid button was pressed");
			clickedCount++; //add 1 to total clicks			
			
			/*
			 * using this eventually to check location of the button pressed
			 * and then only allow buttons next to it to be pressed
			*/
			String buttonColumn = id.substring(id.length() - 1);
			String buttonRow	 = id.substring(id.length() - 2);
			int row = Integer.parseInt(buttonRow);
			int column = Integer.parseInt(buttonColumn);
			
			randomValue = (int)Math.floor(Math.random()*(max-min+1)+min); //generate random value
			System.out.println("Random value is : " + randomValue); //print the random value
						
			/* Disables btn from being pressed again but makes color lighter unfortunately */
			btn.setDisable(true); 
			
			if (randomValue == 1) { //adjust this and the min/max statements to change likelihood of an option
				btn.setStyle("-fx-background-color: #F6FF64"); //YELLOW - TREASURE
				results.setText(String.valueOf("CONGRATS! YOU'VE FOUND TREASURE... +1 ARMOR"));
				armorPoints++; //add 1 armor point
				//armorPointsTextBox.setText(String.valueOf("Armor: " + armorPoints));
				updatearmorPointsTextBox(armorPoints);
			}
			else if (randomValue == 2) { 
				btn.setStyle("-fx-background-color: #FF0000"); //RED - ENEMY
				//results.setText(String.valueOf("YOU'VE ENCOUNTERED AN ENEMY!... -1 ARMOR"));
				//armorPoints--; //minus 1 armor point				
				/*
				 * OPEN ENEMY ENCOUNTER WINDOW... 
				 * see attack and block actionEvent handler function below
				 */
				//armorPoints--;
				int weaponIDplaceholder = 0;
				
				armorPoints = monsterEvent.openWindow(origStage, armorPoints, weaponIDplaceholder);
				updatearmorPointsTextBox(armorPoints);
								
			}
			else if (randomValue == 3) { 
				btn.setStyle("-fx-background-color: #FFFFFF"); //WHITE - NOTHING/BLANK TILE
				results.setText(String.valueOf("EMPTY AREA..."));
				//don't do anything, blank square
			}
			
			//results.setText(String.valueOf(clickedCount)); //print clickedCount in textField "results"
			//armorPointsTextBox.setText(String.valueOf("Armor: " + armorPoints));
			updatearmorPointsTextBox(armorPoints);
		}		
		/*
		 * called when block button is pressed in the monster fight window
		 */
		public void block(ActionEvent event)throws IOException{
			Button btn = (Button) event.getSource(); //get fx:id of whatever button was pressed
			String id = btn.getId(); //String id = fx:id of button pressed
			System.out.println(id + " PRESSED");	
			blockButton.setStyle("-fx-background-color: #009EFF"); //LIGHT BLUE - make block button blue			
		}
		/*
		 * called when attack button is pressed in the monster fight window
		 */
		public void attack(ActionEvent event)throws IOException{
			System.out.println("Monster Attacked");
			int min2 = 1; int max2 = 3;
			int randomValue2 = (int)Math.floor(Math.random()*(max2-min2+1)+min2); //generate random value
			System.out.println("Random value is : " + randomValue2); //print the random value
			armorPoints -= randomValue2;
			showarmorPoints(armorPoints);
			
			Button btn = (Button) event.getSource(); //get fx:id of whatever button was pressed
			String id = btn.getId(); //String id = fx:id of button pressed
			attackButton.setStyle("-fx-background-color: #FF0000"); //RED - make attack button red
			System.out.println(id + " PRESSED");
			monsterHitPoints -= attackPoints;
			if (monsterHitPoints <= 0) {
				System.out.println("Monster Defeated");
				// get a handle to the stage
			    Stage CurrentStage = (Stage) btn.getScene().getWindow();
			    // close stage
			    //pressedButton.openWindow(origStage, number);	
			    CurrentStage.close();
			    //updatearmorPointsTextBox(armorPoints);
			}
			monsterHealth.setText(String.valueOf(monsterHitPoints));
			/*
			 * This is where we have the monster attack
			 */
			
			//armorPointsTextBox.setText(String.valueOf("Armor: " + armorPoints));
			//sendArmorAfterFight(armorPoints);
			//updatearmorPointsTextBox(armorPoints);
		}
}
