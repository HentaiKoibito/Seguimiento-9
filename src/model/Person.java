package model;

public class Person {
	private Id id;
	private int number;

	public Person(Id id, int number) {
		this.id = id;
		this.number = number;
	}
	
	public Id getId() {
		return id;
	}

	public int getNumber() {
		return number;
	}

}