package model;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import exceptions.IDNumberException;
import exceptions.UnderAgeException;

public class MiniMarketTest {
	private MiniMarket m;
	
	public void setupScenary1() {
		m = new MiniMarket();
	}
	
	@Test
	public void testAddPerson1() throws UnderAgeException, IDNumberException {
		setupScenary1();
		
		int type = 2;
		int number = 1005865627;
		
		boolean added = m.addPerson(type, number);
		assertTrue(added);
		
		ArrayList<Person> people = m.getPeople();
		assertEquals(1, people.size());
		
		Person p = people.get(0);
		assertEquals(type, p.getType());
		assertEquals(number, p.getNumber());
	}
	
	@Test
	public void testAddPerson2() {
		setupScenary1();
		
		int type = 1;
		int number = 1002839617;
		
		//boolean added = true;
		try {
			m.addPerson(type, number);
			fail();
		} catch (UnderAgeException e) {
			// TODO Auto-generated catch block
			//assertFalse(added);
			ArrayList<Person> people = m.getPeople();
			assertEquals(0, people.size());
			e.printStackTrace();
		} catch (IDNumberException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	@Test
	public void testAddPerson3() {
		setupScenary1();
		
		int type = 3;
		int number = 1008867657;
		
		//boolean added = true;
		try {
			m.addPerson(type, number);
		} catch (UnderAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IDNumberException e) {
			// TODO Auto-generated catch block
			//assertFalse(added);
			ArrayList<Person> people = m.getPeople();
			assertEquals(0, people.size());
			//e.printStackTrace();
		}
	}
}
