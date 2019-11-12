package person;

public class Person {
	private int id;
	private double val;	
	private static int totalPersonNum;
	
	public Person() {
		id = totalPersonNum;
		val = Math.random();
		totalPersonNum++;
	}
	
	public double getVal() {
		return val;
	}
	
	public void printVal() {
		System.out.println(" Person Id " + id + " from a total of " + totalPersonNum + "; Value " + val);
	}
	
}
