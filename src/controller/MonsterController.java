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
import model.Menu;
import model.Monster;

public class MonsterController {
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
	
	public int armorPoints;
	
	public int monsterHitPoints = 5;
	
	public int attackPoints = 3; //default attack point
	
	public static GameController ControllerScene1 = new GameController(); //use this variable to edit gamePlay window
		
	public void returnToMenu(ActionEvent event)throws IOException{
		System.out.println("Return to Menu button pressed");								
		
		//menuButton.openWindow(origStage);			
	}
	
	public void transferEnemyInitialHealth(int initialMonsterHealth) {
		monsterHitPoints = initialMonsterHealth;
		monsterHealth.setText(String.valueOf(monsterHitPoints));
	}
	public void transferArmor(int armorVal) {
		armorPoints = armorVal;
		System.out.println("Setting New armor value");
		playerHealth.setText(String.valueOf(armorPoints));
	}

	public void transferController(GameController Scene1Controller) {
		System.out.println("Setting controller");
		ControllerScene1 = Scene1Controller;
	}	
	
	public void showarmorPoints(int val) {
		playerHealth.setText(String.valueOf(armorPoints));
	}
	
	/*
	 * called when dodge button is pressed in the monster fight window
	 */
	public void dodge(ActionEvent event)throws IOException{
		Button btn = (Button) event.getSource(); //get fx:id of whatever button was pressed
		String id = btn.getId(); //String id = fx:id of button pressed
		System.out.println(id + " PRESSED");	
		dodgeButton.setStyle("-fx-background-color: #009EFF"); //LIGHT BLUE - make block button blue
		
		/* 
		 * random value for monster attacks and blocked 
		*/
		int min2 = 1; int max2 = 3;
		int monsterAttack = (int)Math.floor(Math.random()*(max2-min2+1)+min2); //generate random value
		int dodgeOrNot = (int)Math.floor(Math.random()*(2-1+1)+1);
		System.out.println("Random Monster Attack: " + monsterAttack); //print the random value
		
		//subtract 1 from monsterAttack
		if (dodgeOrNot == 1) {
			monsterHitPoints -= 1;
			//userReads = "You dealt " + attackPoints + " damage!\n";
			monsterDialogue.setText("You dodged " + monsterAttack + " damage from monster\n");
			monsterDialogue.appendText("Monster loses 1 damage from falling\n");
		}
		else if (dodgeOrNot == 2){
			armorPoints -= monsterAttack;
			monsterDialogue.setText("You didn't move in time from the monster!\n");
			monsterDialogue.appendText("You took " + monsterAttack + " damage!\n");
		}
		
	    Stage CurrentStage = (Stage) btn.getScene().getWindow();
	    
	    //if monster loses from blocking
		if (monsterHitPoints <= 0 && armorPoints >= 1) {
			System.out.println("Monster Defeated");
			ControllerScene1.updateResults("You defeated the monster by dodging!\n");
		    ControllerScene1.setarmorPoints(armorPoints);
		    ControllerScene1.updatearmorPointsTextBox(armorPoints);		    
		    CurrentStage.close();
		}
		//if player loses
		if (armorPoints <= 0 && monsterHitPoints >= 0) {
			ControllerScene1.updateResults("Monster killed you");
			CurrentStage.close();
			armorPoints = 0;
			ControllerScene1.setarmorPoints(armorPoints);
		    ControllerScene1.updatearmorPointsTextBox(armorPoints);
		    	
		    EndScreen loseScreen = new EndScreen();	
		    //make end screen appear	
		    loseScreen.openLoseWindow(ControllerScene1.returnStage(), armorPoints, monsterAttack);//, randomValue2, ControllerScene1);
		}

		if (armorPoints >= 1) {
			monsterHealth.setText(String.valueOf(monsterHitPoints));
			showarmorPoints(armorPoints);
		}
	}
	/*
	 * called when attack button is pressed in the monster fight window
	 */
	public void attack(ActionEvent event)throws IOException{
		//String userReads = "";

		System.out.println("Attack Button Pressed");
		int min2 = 1; int max2 = 3;
		int randomValue2 = (int)Math.floor(Math.random()*(max2-min2+1)+min2); //generate random value
		System.out.println("Random Monster Attack: " + randomValue2); //print the random value
		
		Button btn = (Button) event.getSource(); //get fx:id of whatever button was pressed
		String id = btn.getId(); //String id = fx:id of button pressed
		attackButton.setStyle("-fx-background-color: #FF0000"); //RED - make attack button red
		System.out.println(id + " PRESSED");
		
		monsterHitPoints -= attackPoints;
		//userReads = "You dealt " + attackPoints + " damage!\n";
		monsterDialogue.appendText("You dealt " + attackPoints + " damage!\n");
		
	    Stage CurrentStage = (Stage) btn.getScene().getWindow();
			
		if (monsterHitPoints <= 0 && armorPoints >= 1) {
			System.out.println("Monster Defeated");
			ControllerScene1.updateResults("You dealt " + attackPoints + " damage!\nYou defeated the monster!\n");
		    ControllerScene1.setarmorPoints(armorPoints);
		    ControllerScene1.updatearmorPointsTextBox(armorPoints);		    
		    CurrentStage.close();
		}
		
		int beforeAttack = armorPoints;
		if (monsterHitPoints > 0) {
			armorPoints -= randomValue2; //subtracting monster attack from armor
			monsterDialogue.appendText("You took " + randomValue2 + " damage!\n");
		}
		
		if (armorPoints <= 0 && monsterHitPoints >= 0) {
			System.out.println("Monster defeated you aka you died");
			ControllerScene1.updateResults("Monster defeated you");
			CurrentStage.close();
			ControllerScene1.setarmorPoints(0);
		    ControllerScene1.updatearmorPointsTextBox(0);
		    	
		    EndScreen loseScreen = new EndScreen();	
		    //make end screen appear	
		    loseScreen.openLoseWindow(ControllerScene1.returnStage(), beforeAttack, randomValue2);//, randomValue2, ControllerScene1);
		}

		if (armorPoints >= 1) {
			monsterHealth.setText(String.valueOf(monsterHitPoints));
			showarmorPoints(armorPoints);
		}
		
		
		
	}
}




















