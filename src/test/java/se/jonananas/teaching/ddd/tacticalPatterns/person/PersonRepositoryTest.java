package se.jonananas.teaching.ddd.tacticalPatterns.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PersonRepositoryTest {

	private Person person;
	private PersonRepository repo;

	@Before
	public void setup() {
		person = Person.createFromNameAndAdress("Ulla Red", Adress.createFrom("Ullared"));
		repo = PersonRepositoryInMem.create();
	}

	@Test
	public void shouldFindStoredPerson() throws Exception {
		repo.persist(person);

		Person person2 = repo.findByName("Ulla Red");

		assertThat(person).isEqualTo(person2);
	}

	@Test
	public void shouldNotFindNotStoredPerson() throws Exception {
		repo.persist(person);

		Person person2 = repo.findByName("other");

		assertThat(person).isNotEqualTo(person2);
	}
	
	@Test
	public void shouldDeletePerson() throws Exception {
		repo.persist(person);
		repo.delete(person);

		assertThat(repo.findByName("person")).isNotEqualTo(person);

	}

}
