package se.jonananas.teaching.ddd.tacticalPatterns;

import java.util.UUID;

public class Person {

	private UUID id;

	private String name;
	private Adress adress;

	private Person(String namn, Adress adress) {
		this.name = namn;
		this.adress = adress;
		this.id = UUID.randomUUID();
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
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person))
			return false;
		Person other = (Person)obj;
		return this.id.equals(other.id);
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
