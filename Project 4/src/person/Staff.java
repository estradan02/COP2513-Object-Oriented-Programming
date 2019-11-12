package person;

public class Staff extends Person { 

	private int staffId = 0;
	
	public Staff(int i,int num,int x) {
	    super(i,x);
	    staffId = num;
	}
	public void printId() {
		System.out.println(" Staff Id " + staffId);
	}
	public String printVal() {
		return " Staff Id " + staffId + " from Game: " + getGame() + ";" + toString();
	}
}