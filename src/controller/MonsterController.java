package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.EndScreen;

public class MonsterController {
	/**
	 * FXML buttons and text boxes for monster battle  window. 
	 */
	@FXML
	private Text playerHealth;
	@FXML
	private Button attackButton;
	@FXML
	private Button dodgeButton;		
	@FXML
	private Text monsterHealth;
	@FXML
	private TextArea monsterDialogue;
	
	/**
	 * global variables and initializations for variables
	 */
	public int armorPoints; //get armorPoints from GameController
	public int monsterHitPoints = 5; //initialize monster health
	public int attackPoints = 3; //default attack point
	int monsterBeforeAttack; //holds monster health before attack
	int armorBeforeAttack; //holds armor points before monster attack
	public static GameController ControllerScene1 = new GameController(); //use variable to edit gamePlay window
	
	/**
	 * sets initial monster health on monster battle screen
	 * @param initialMonsterHealth
	 */
	public void transferEnemyInitialHealth(int initialMonsterHealth) {
		monsterHitPoints = initialMonsterHealth;
		monsterHealth.setText(String.valueOf(monsterHitPoints));
	}
	
	/**
	 * transfers armor points from game play screen to monster screen
	 * @param armorVal
	 */
	public void transferArmor(int armorVal) {
		armorPoints = armorVal;
		playerHealth.setText(String.valueOf(armorPoints));
	}
	
	/**
	 * transfers GameController object to monster class
	 * @param Scene1Controller
	 */
	public void transferController(GameController Scene1Controller) {
		System.out.println("Setting controller");
		ControllerScene1 = Scene1Controller;
	}	
	
	/**
	 * shows player health/armor on monster battle screen
	 * @param val
	 */
	public void showarmorPoints(int val) {
		playerHealth.setText(String.valueOf(armorPoints));
	}
	
	/**
	 * called when dodge button is pressed in the monster fight window
	 * @param event button pressed
	 * @throws IOException
	 */
	public void dodge(ActionEvent event)throws IOException{
		Button btn = (Button) event.getSource(); //get fx:id of whatever button was pressed
		//String id = btn.getId(); //String id = fx:id of button pressed
		dodgeButton.setStyle("-fx-background-color: #009EFF"); //LIGHT BLUE - make block button blue
		
		int min2 = 1, max2 = 3; //min and max value for monster attack
		int monsterAttack = (int)Math.floor(Math.random()*(max2-min2+1)+min2); //generate random monster attack
		int dodgeOrNot = (int)Math.floor(Math.random()*(2-1+1)+1); //random value if player will successfully dodge or not
		
		armorBeforeAttack = armorPoints; //hold value for armor
		monsterBeforeAttack = monsterHitPoints; //hold value for monster health
		
		//successfully dodged
		if (dodgeOrNot == 1) {
			monsterHitPoints -= 1; //subtract 1 health from monster
			monsterDialogue.setText("You dodged " + monsterAttack + " damage from monster\n");
			monsterDialogue.appendText("Monster had " + monsterBeforeAttack + " health and lost -1 damage\nfrom falling\n");
		}
		//did not dodge
		else if (dodgeOrNot == 2){
			armorPoints -= monsterAttack; //subtract monster attack from armor
			monsterDialogue.setText("You didn't move in time from the monster!\n");
			monsterDialogue.appendText("You had " + armorBeforeAttack + " armor!\n");
			monsterDialogue.appendText("You took -" + monsterAttack + " damage!\n");
		}
		
		//get current stage
	    Stage CurrentStage = (Stage) btn.getScene().getWindow();
	    
	    //if monster loses from blocking
		if (monsterHitPoints <= 0 && armorPoints >= 1) {
			ControllerScene1.updateResults("Monster had 1 health left.\nYou defeated the monster by dodging!\n");
		    ControllerScene1.setarmorPoints(armorPoints);
		    ControllerScene1.updatearmorPointsTextBox(armorPoints);		    
		    CurrentStage.close();
		}
		//if player loses from monster attack
		if (armorPoints <= 0 && monsterHitPoints >= 0) {
			ControllerScene1.updateResults("Monster killed you");
			CurrentStage.close();
			armorPoints = 0;
			ControllerScene1.setarmorPoints(armorPoints);
		    ControllerScene1.updatearmorPointsTextBox(armorPoints);
		    //make end screen appear	
		    EndScreen loseScreen = new EndScreen();	
		    loseScreen.openLoseWindow(ControllerScene1.returnStage(), armorBeforeAttack, monsterAttack);
		}
		//if both player and monster are still alive
		if (armorPoints >= 1) {
			monsterHealth.setText(String.valueOf(monsterHitPoints));
			showarmorPoints(armorPoints);
		}
	}

	/**
	 * called when attack button is pressed in the monster fight window
	 * @param event
	 * @throws IOException
	 */
	public void attack(ActionEvent event)throws IOException{
		int min2 = 1, max2 = 3;//min and max attack for monster
		int monsterAttack = (int)Math.floor(Math.random()*(max2-min2+1)+min2); //generate random value
		
		Button btn = (Button) event.getSource(); //get fx:id of whatever button was pressed
		//String id = btn.getId(); //String id = fx:id of button pressed
		attackButton.setStyle("-fx-background-color: #FF0000"); //RED - make attack button red
		
		monsterBeforeAttack = monsterHitPoints; //hold monster health before attack
		monsterHitPoints -= attackPoints; //subtract player attack from monster health
		monsterDialogue.setText("Monster had " + monsterBeforeAttack + " health!\n");
		monsterDialogue.appendText("You dealt -" + attackPoints + " damage!\n");
		
		//get current stage
	    Stage CurrentStage = (Stage) btn.getScene().getWindow();
		
	    //if monster is defeated
		if (monsterHitPoints <= 0 && armorPoints >= 1) {
			System.out.println("Monster Defeated");
			ControllerScene1.updateResults("Monster had "+ monsterBeforeAttack+" health left.\nYou dealt -" + attackPoints + " damage!\nYou defeated the monster!\n");
		    ControllerScene1.setarmorPoints(armorPoints);
		    ControllerScene1.updatearmorPointsTextBox(armorPoints);		    
		    CurrentStage.close();
		}
		
		armorBeforeAttack = armorPoints;//hold player armor before monster attack
		
		//if monster is still alive after player attack
		if (monsterHitPoints > 0) {
			armorPoints -= monsterAttack; //subtracting monster attack from armor
			monsterDialogue.appendText("You had " + armorBeforeAttack + " armor!\n");
			monsterDialogue.appendText("You took -" + monsterAttack + " damage!");
		}
		
		//if monster kills player
		if (armorPoints <= 0 && monsterHitPoints >= 0) {
			ControllerScene1.updateResults("Monster defeated you");
			CurrentStage.close();
			ControllerScene1.setarmorPoints(0);
		    ControllerScene1.updatearmorPointsTextBox(0);
		    //make end screen appear	
		    EndScreen loseScreen = new EndScreen();	
		    loseScreen.openLoseWindow(ControllerScene1.returnStage(), armorBeforeAttack, monsterAttack);
		}
		
		//if both player and monster are still alive
		if (armorPoints >= 1) {
			monsterHealth.setText(String.valueOf(monsterHitPoints));
			showarmorPoints(armorPoints);
		}
	}
}




















