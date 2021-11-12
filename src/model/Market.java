package model;

import java.time.LocalDate;
import java.util.ArrayList;
import exceptions.UnderageException;
import exceptions.NumberWrongException;

public class Market {
	private int total;
	private ArrayList<Person> registers;
	
	
	public Market() {
		total = 0;
		registers = new ArrayList<Person>();
	}

	public int getTotal() {
		return total;
	}

	public ArrayList<Person> getRegisters() {
		return registers;
	}

	public boolean register(int selection, int number) throws NumberWrongException, UnderageException {
		total++;
		boolean added = false;
		if(checkID(number)) {
			if(selection==1) {
				throw new UnderageException();
			}
			if(selection==2) {
				Person person = new Person(Id.CC, number);
				registers.add(person);
				added = true;
			}else if(selection==3) {
				Person person = new Person(Id.PP, number);
				registers.add(person);
				added = true;
			}else if(selection==4){
				Person person = new Person(Id.CE, number);
				registers.add(person);
				added = true;
			}
		}
		return added;
	}
	
	public boolean checkID(int number) throws NumberWrongException {
		number = number/10;
		int secondLastNumber = number%10;
		boolean x = false;
		if(LocalDate.now().getDayOfMonth()%2!=0 && secondLastNumber%2!=0){
			x = true;
		}else if(LocalDate.now().getDayOfMonth()%2==0 && secondLastNumber%2==0) {
			x = true;
		}else {
			throw new NumberWrongException();
		}
		
		return x;
	}

}	
	