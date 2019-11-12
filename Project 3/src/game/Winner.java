package game;

import person.*;

import java.util.Scanner;

public class Winner {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How Many Games Do You Want To Play?: ");
		int numRuns = scan.nextInt();
		System.out.println("Enter Number of Players: ");
		int numPerson = scan.nextInt();
		
		Winner w = new Winner();
		Person[] winnersArray = new Person[numRuns];
		Person[] personArray = new Person[numPerson];
		for (int x=0; x<winnersArray.length; x++) {
			System.out.println("Game: " + x);
			w.init_game(personArray,x);
			Person p = w.find_person_winner(personArray);
			if (p!= null) {
					System.out.println("Game Winner is: ");
					p.printVal();
					winnersArray[x]=p;
			}
		
			Player player = w.find_player_winner(personArray);
			if (player != null) {
				player.clearId();
			}
			
			Staff staff = w.find_staff_winner(personArray);
			if (staff != null) {
				staff.clearId();
				
			}
		}
		
		System.out.println("Game Winners: ");
		for (int i=0; i<winnersArray.length; i++) {
			winnersArray[i].printVal();
		}
		
		Person win = w.find_game_winner(winnersArray);
		if (win != null) {
			System.out.println("All Game Winner is: ");
			win.printVal();
		}
	}
	
	private void init_game(Person[] personArray, int x) {
		for(int i = 0; i < personArray.length/2; i++) {
			personArray[i] = new Player(x);
			personArray[i].printVal();
		}
		
		for(int j = personArray.length/2; j < personArray.length; j++) {
			personArray[j] = new Staff(x);
			personArray[j].printVal();
		}
	}
	
	private Person find_person_winner(Person[] personArray) {
		double topVal = 0;
		int winnerIndex = 0;
		for(int i = 0; i < personArray.length; i++) {
			if(personArray[i] instanceof Person && personArray[i].getVal() > topVal) {
			topVal = personArray[i].getVal();
			winnerIndex = i;
		}
	  }
		Person personWinner = (Person) personArray[winnerIndex];
		return personWinner;
	}
	
	private Player find_player_winner(Person[] personArray) {
		double topVal2 = 0;
		int winnerIndex2 = 0;
		for(int i = 0; i < personArray.length; i++) {
			if(personArray[i] instanceof Player && personArray[i].getVal() > topVal2) {
			topVal2 = personArray[i].getVal();
			winnerIndex2 = i;
		}
	  }
		Player playerWinner = (Player) personArray[winnerIndex2];
		return playerWinner;
	}
	
	private Staff find_staff_winner(Person[] personArray) {
		double topVal2 = 0;
		int winnerIndex2 = 0;
		for(int i = 0; i < personArray.length; i++) {
			if(personArray[i] instanceof Staff && personArray[i].getVal() > topVal2) {
			topVal2 = personArray[i].getVal();
			winnerIndex2 = i;
		}
	  }
		Staff staffWinner = (Staff) personArray[winnerIndex2];
		return staffWinner;
	}
	
	private Person find_game_winner(Person[] winnersArray) {
		double topVal2 = 0;
		int winnerIndex2 = 0;
		for(int i = 0; i < winnersArray.length; i++) {
			if(winnersArray[i] instanceof Person && winnersArray[i].getVal() > topVal2) {
			topVal2 = winnersArray[i].getVal();
			winnerIndex2 = i;
		}
	  }
		Person gamesWinner = (Person) winnersArray[winnerIndex2];
		return gamesWinner;
	}
}
