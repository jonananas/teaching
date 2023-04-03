package se.jonananas.teaching.ddd.tacticalPatterns.person;

import java.util.HashMap;
import java.util.Map;

public class PersonRepositoryInMem implements PersonRepository {

	private Map<String, Person> persons;
	
	private PersonRepositoryInMem() {
		persons = new HashMap<>();
	}

	@Override
	public void persist(Person Person) {
		persons.put(Person.getName(), Person);
	}

	@Override
	public Person findByName(String name) {
		return persons.get(name);
	}

	public static PersonRepository create() {
		return new PersonRepositoryInMem();
	}

	@Override
	public void delete(Person person) {
		persons.remove(person.getName());
	}

}
