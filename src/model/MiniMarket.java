package model;

import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.IDNumberException;
import exceptions.UnderAgeException;

public class MiniMarket {
	private final static int TI = 1;
	private ArrayList<Person> people;
	private int contAttempts;
	
	public MiniMarket() {
		people = new ArrayList<Person>();
		contAttempts = 0;
	}
	
	public int getContAttempts() {
		return contAttempts;
	}

	public boolean addPerson(int documentationType, int id) throws UnderAgeException, IDNumberException {
		boolean added = false;
		contAttempts++;
		Person newPerson = new Person(documentationType, id);
		String digit = Integer.toString(id);
		digit = digit.substring((digit.length()-2), (digit.length()-1));
		int penultimate = Integer.parseInt(digit);
		int dayOfMonth = LocalDate.now().getDayOfMonth();
		if(!people.contains(newPerson)) {
			if(documentationType == TI) {
				throw new UnderAgeException();
			}
			else if((penultimate%2 == 0 && dayOfMonth%2 == 0) || (penultimate%2 != 0 && dayOfMonth%2 != 0)) {
				throw new IDNumberException(dayOfMonth, penultimate);
			}
			added = people.add(newPerson);
		}
		
		return added;
	}
}
