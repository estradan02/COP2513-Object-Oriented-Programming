package person;

public class Player extends Person implements PrintData {
	private int playerId;
	private static int totalPlayerNum = 1;
	private int x;

	public Player(int gameNum) {
		super();
		playerId = totalPlayerNum;
		totalPlayerNum++;
		x = gameNum;
	}
	
	public void printVal() {
		System.out.print("Player Id " + playerId + " from Game " + x + ";");
		super.printVal();
	}
	
	public int clearId() {
		return Player.totalPlayerNum = 1;
	}

	@Override
	public void printId() {
		
	}
}
