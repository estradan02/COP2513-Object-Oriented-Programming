package game;

import java.util.Scanner;
import person.*;

public class Winner {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of players: ");
		int numPerson = scan.nextInt();
		
		Person[] personArray = new Person[numPerson];
		Winner w = new Winner();
		w.init_game(personArray);
		
		Person p = w.find_person_winner(personArray);
		if (p!= null) {
			System.out.println("Person Winner is: ");
			p.printVal();
		}
		
		Player player = w.find_player_winner(personArray);
		if (player != null) {
			System.out.println("Player Winner is: ");
			player.printVal();
		}
		
		Staff staff = w.find_staff_winner(personArray);
		if (staff != null) {
			System.out.println("Staff Winner is: ");
			staff.printVal();
		}
	}
	
	private void init_game(Person[] personArray) {
		for(int i = 0; i < personArray.length/2; i++) {
			personArray[i] = new Player();
			personArray[i].printVal();
		}
		
		for(int j = personArray.length/2; j < personArray.length; j++) {
			personArray[j] = new Staff();
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
}