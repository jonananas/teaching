package se.jonananas.teaching.ddd.tacticalPatterns.person;

import se.jonananas.teaching.ddd.tacticalPatterns.patterns.ValueObject;

public class Adress extends ValueObject {

	private String gatuAdress;

	private Adress(String gatuAdress) {
		this.gatuAdress = gatuAdress;
	}

	public static Adress createFrom(String gatuAdress) {
		return new Adress(gatuAdress);
	}
	
	public String getGatuadress() {
		return gatuAdress;
	}
}
