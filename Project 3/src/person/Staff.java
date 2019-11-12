package person;

public class Staff extends Person implements PrintData {
	private int staffId;
	private static int totalStaffNum = 1;
	private int x;
	
	public Staff(int gameNum) {
		super();
		staffId = totalStaffNum;
		totalStaffNum++;
		x = gameNum;
	}
	
	public void printVal() {
		System.out.print("Staff Id " + staffId + " from Game " + x + ";");
		super.printVal();
	}
	
	public int clearId() {
		return Staff.totalStaffNum = 1;
	}

	@Override
	public void printId() {
		
	}
}