package gui;

import game.Winner;
import person.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javax.swing.JOptionPane;


public class GameGUI extends Application{
	
	//Objects and variables in GUI
	private Button btInit = new Button("Initialize Players");
	private Button btRun = new Button("Play");
	private Button btClose = new Button("Close");
	private TextField tfNumPlayers = new TextField();
	private TextField tfNumGames = new TextField();
	private TextField tfResult = new TextField();
	private TextArea tfTextBox = new TextArea();
	Person [] personArray;
	Person [] winnersArray;
	int numPlayers = 0;
	int numGames = 0;
	  
	public void start(Stage primaryStage) {
			
			//Create GUI
			GridPane gridPane = new GridPane();
			gridPane.setHgap(5);
			gridPane.setVgap(5);
			gridPane.add(new Label("Number of Players:"), 0, 0);
		    gridPane.add(tfNumPlayers, 1, 0);
		    gridPane.add(new Label("Number of Games:"), 0, 1);
		    gridPane.add(tfNumGames, 1, 1);  
		    gridPane.add(new Label("Game Results:"), 0, 2);
		    gridPane.add(tfTextBox, 1, 2);
		    tfResult.setPrefHeight(300);
		    tfResult.setPrefWidth(400);
		    gridPane.add(btInit, 1, 4);
		    gridPane.add(btRun, 2, 4);
		    gridPane.add(btClose, 0, 4);
		    
		    Scene scene = new Scene(gridPane, 800, 475); //Create scene
		    primaryStage.setTitle("Assignment 4"); // Set the stage title
		    primaryStage.setScene(scene); // Place the scene in the stage
		    primaryStage.show(); // Display the stage
		    
		    //Set properties for UI
		    gridPane.setAlignment(Pos.CENTER);
		    tfNumPlayers.setAlignment(Pos.BOTTOM_RIGHT); 
		    tfNumGames.setAlignment(Pos.BOTTOM_RIGHT);
		    tfResult.setAlignment(Pos.TOP_LEFT);
		    GridPane.setHalignment(btInit, HPos.RIGHT);
		    
		    tfTextBox.setWrapText(true);
		    tfTextBox.setEditable(false);
		    
		    //Process Events
		    btInit.setOnAction(e -> initGame());
		    btRun.setOnAction(e -> runGame());
			btClose.setOnAction(e -> closeWindow(primaryStage));
	}
	
	private void initGame() {
	   try {
		   numPlayers = Integer.parseInt(tfNumPlayers.getText());
		   numGames = Integer.parseInt(tfNumGames.getText());
	   } catch (IllegalArgumentException e) {
		   JOptionPane.showMessageDialog(null, "You Must Enter An Integer For Both Fields.");
	   }
	    personArray = new Person[numPlayers];
		winnersArray = new Person[numGames];
	    Winner win = new Winner(); 
		String result = new String();
		
		for(int x=0; x<Integer.parseInt(tfNumGames.getText()); x++){
			result += "Game: " + x + "\n" + win.init_game(personArray, x) + '\n';
			winnersArray[x] = win.find_person_winner(personArray);	
		}	
		tfTextBox.setText(result);
	}
		
	private void runGame() {
		String final_win = new String();
		String game_winners = new String();
		Winner win = new Winner();
		
		try {
			Person fWin = win.find_game_winner(winnersArray);
			
			for(int x=0; x<Integer.parseInt(tfNumGames.getText()); x++) {
				game_winners += "Winner for Game: " + x + "\n" + winnersArray[x].printVal() + "\n";
			}
			final_win += "All Game Winner is: \n" + fWin.printVal() + "\n";
			} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "You Must Enter An Integer For Each Field.");
			}
		tfTextBox.insertText(0,final_win);
		tfTextBox.insertText(0,game_winners);
		
	}
	
	//Closes GUI from button click
	private void closeWindow(Stage stage) {
		  stage.close();
	  }
	
	//String formatting
	public void setText(String text) {
		tfTextBox.setText(String.format("%s", text));
	  }
	
	public static void main(String[] args) {
		launch(args);
	}
}