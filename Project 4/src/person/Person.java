package person;

import java.util.Random;
													 
public abstract class Person implements PrintData {  
	private Random r = new Random();
	private int id = 0;
	private double val = 0;
	private int game = 0;

	public Person(int i,int x) { 
	    id = i;
	    game = x;
	    val = r.nextDouble();
	}
	public String toString() { 
	    return " Value " + val + "\n";
	}
	
	public int getId() { 
		return id;
	}
	public double getVal() {
		return val;
	}
	public int getGame() {
		return game;
	}
}