package exceptions;

@SuppressWarnings("serial")
public class IDNumberException extends Exception{
	private int secondLastNumber; 
	private int dayOfTheMonth;

	public IDNumberException(int dayOfTheMonth, int secondLastNumber) {
		super("The parity of the second last number of the id and the current day of the month are the same");
		this.dayOfTheMonth = dayOfTheMonth;
		this.secondLastNumber = secondLastNumber;
	}
	
	public int getSecondLastNumber() {
		return secondLastNumber;
	}

	public void setSecondLastNumber(int secondLastNumber) {
		this.secondLastNumber = secondLastNumber;
	}

	public int getDayOfTheMonth() {
		return dayOfTheMonth;
	}

	public void setDayOfTheMonth(int dayOfTheMonth) {
		this.dayOfTheMonth = dayOfTheMonth;
	}
	
}
