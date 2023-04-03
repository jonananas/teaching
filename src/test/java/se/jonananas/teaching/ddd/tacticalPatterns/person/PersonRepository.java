package se.jonananas.teaching.ddd.tacticalPatterns.person;

public interface PersonRepository {

	void persist(Person person);

	Person findByName(String name);

	void delete(Person produkt);

}
