package person;

public abstract class Person {
	int id;
	double val;	
	int totalPersonNum;
	
	public Person() {
		id = totalPersonNum;
		val = Math.random();
		totalPersonNum++;
	}
	
	public double getVal() {
		return val;
	}
	
	public void printVal() {
		System.out.println(" Value " + val);
	}
}
