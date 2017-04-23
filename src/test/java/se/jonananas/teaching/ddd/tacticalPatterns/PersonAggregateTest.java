package se.jonananas.teaching.ddd.tacticalPatterns;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PersonAggregateTest {

	private Person person;
	private Adress adress;

	@Before
	public void setup() {
		adress = Adress.createFrom("Storgatan");
		person = Person.createFromNameAndAdress("Pelle Person", adress);
	}

	@Test
	public void shouldCreatePerson() throws Exception {
		assertThat(person.getName()).isEqualTo("Pelle Person");
		assertThat(person.getAdress()).isEqualTo(adress);
	}

	@Test
	public void shouldBeEqualOnlyToItself() throws Exception {
		Person other = Person.createFromNameAndAdress("Pelle Person", Adress.createFrom("Storgatan"));
		
		Person same = person;

		assertThat(same).isEqualTo(person)
				.isNotEqualTo(other)
				.isNotEqualTo(null)
				.isNotEqualTo(new Object());
	}
	
	@Test
	public void shouldSetName() throws Exception {
		person.setName("Palle Parsson");
		assertThat(person.getName()).isEqualTo("Palle Parsson");
	}
}
