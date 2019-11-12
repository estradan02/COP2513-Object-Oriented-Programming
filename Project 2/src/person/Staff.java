package person;

public class Staff extends Person{
	private int staffId;
	private static int totalStaffNum;
	
	public Staff() {
		super();
		staffId = totalStaffNum;
		totalStaffNum++;		
	}
	
	public void printVal() {
		System.out.print("Staff Id " + staffId + " from a total of " + totalStaffNum + ";");
		super.printVal();
	}
}
