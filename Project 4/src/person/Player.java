package person;

public class Player extends Person { 
	
	private int playerId = 0;
	
	public Player(int i,int num,int x) {
	    super(i,x);
	    playerId = num;
	}
	public void printId() {
		System.out.println(" Player Id " + playerId);
	}
	public String printVal() {
		return " Player Id " + playerId + " from Game: " + getGame() + ";" + toString();
	}
}