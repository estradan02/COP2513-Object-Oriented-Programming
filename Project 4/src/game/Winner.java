package game;

import person.*;
import java.util.Random;

public class Winner { 
	public Random r = new Random(); 
	
	public String init_game(Person[] pa, int x) { 
		double tmp = 0;
		int numPlayers = 0;
		int numStaff = 0;
		String result = "";
		
		for (int i=0; i<pa.length; i++) {
			tmp = r.nextDouble();
			if (tmp <= 0.5) { //Randomly assigns new player or staff objects to be created
				numPlayers++;
				pa[i] = new Player(i,numPlayers,x);
			}
			else {
				numStaff++;
				pa[i] = new Staff(i,numStaff, x);
			}
			result += pa[i].printVal(); 
		}
		return result;
	}
	
	//Sorts the given array to the largest value and returns that index in that object array
	public Person find_person_winner(Person[] pa) {  
		int id1 = 0, id2 = 0;
		double val1 = 0, val2 = 0;
		
		for (int i=0; i<pa.length; i++) {
			id1 = pa[i].getId();
			val1 = pa[i].getVal();
			if (val1 > val2) {
				val2 = val1;
				id2 = id1;
			}
		}	
		return pa[id2];
	}
	public Person find_game_winner(Person[] pa) { 
		int id1 = 0, id2 = 0;
		double val1 = 0, val2 = 0;
		
		for (int i=0; i<pa.length; i++) {
			id1 = i; 
			val1 = pa[i].getVal();
			pa[i].printVal(); 
			if (val1 > val2) {
				val2 = val1;
				id2 = id1;
			}
		}
		return pa[id2];
	}
}