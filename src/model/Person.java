package model;

public class Person {
	
	private int type;
	private String number;
	/**
	 * @param type
	 * @param number
	 */
	public Person(int type, String number) {
		this.type = type;
		this.number = number;
	}
	
	public int getType() {
		return type;
	}

	public String getNumber() {
		return number;
	}
}
