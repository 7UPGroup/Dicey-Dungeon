package model;

import java.awt.Button;
import java.awt.Insets;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Start{
	
	public void openWindow(){
		Stage window;
        Scene SecondScene;
        Button button;

       // window = primaryStage;
        window.setTitle("TacMint");


        //Button
        button = new Button("Click Me");

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(button);

        SecondScene = new Scene(layout, 300, 250);
        window.setScene(SecondScene);
        button.setOnAction(e -> window.setScene(FirstScene));
        //window.show();
        //**

		
		
		/**
	}
		class Start extends Application {
		@Override
		public void start(Stage game){
			try {
				//load the fxml file
				Parent root = FXMLLoader.load(getClass().getResource("/view/Mainview.fxml"));
				//set the scene to scenebuilder
				Scene scene = new Scene(root,700,724);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				game.setScene(scene);
				game.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		}
		**/
	}

}
