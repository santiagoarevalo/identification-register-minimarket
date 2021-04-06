package model;

public class Person {
	
	private int type;
	private int number;
	/**
	 * @param type
	 * @param number
	 */
	public Person(int type, int number) {
		this.type = type;
		this.number = number;
	}
	
	public int getType() {
		return type;
	}

	public int getNumber() {
		return number;
	}
}
