package person;

public class Player extends Person{
	private int playerId;
	private static int totalPlayerNum;

	public Player() {
		super();
		playerId = totalPlayerNum;
		totalPlayerNum++;		
	}
	
	public void printVal() {
		System.out.print("Player Id " + playerId + " from a total of " + totalPlayerNum + ";");
		super.printVal();
	}
}
