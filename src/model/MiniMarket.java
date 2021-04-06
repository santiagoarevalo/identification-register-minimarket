package model;

import java.time.LocalDate;
import java.util.ArrayList;

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

	public boolean addPerson(int documentationType, int id) {
		boolean added = false;
		contAttempts++;
		Person newPerson = new Person(documentationType, id);
		String digit = Integer.toString(id);
		digit = String.valueOf((digit.length()-2));
		int penultimate = Integer.parseInt(digit);
		if(!people.contains(newPerson)) {
			if(documentationType != TI) {
				//throw new UnderAgeException
			}
			else if((penultimate%2 == 0 && LocalDate.now().getDayOfMonth()%2 == 0) || (penultimate%2 != 0 && LocalDate.now().getDayOfMonth()%2 != 0)) {
				//throw new Exception
			}
			added = people.add(newPerson);
		}
		
		return added;
	}
}
