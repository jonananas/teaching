package se.jonananas.teaching.ddd.tacticalPatterns.person;

import se.jonananas.teaching.ddd.tacticalPatterns.patterns.Entity;

public class Person extends Entity {

	private String name;
	private Adress adress;

	private Person(String namn, Adress adress) {
		this.name = namn;
		this.adress = adress;
	}

	public static Person createFromNameAndAdress(String namn, Adress adress) {
		return new Person(namn, adress);
	}

	public String getName() {
		return name;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setName(String name) {
		this.name = name;
	}
}
