package se.jonananas.teaching.codeSmells.featureEnvy;

public class Person {

	public Object getKey() {
		return null;
	}

	public boolean hasSamePnrAs(Person existingPerson) {
		return false;
	}

}
