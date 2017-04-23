package se.jonananas.teaching.ddd.tacticalPatterns;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;


public class IdTest {

	@Test
	public void shouldBeEqualOnlyToItself() {
		Id id = new Id();
		Id other = new Id();
		Id same = new Id(id);
		
		assertThat(id).isEqualTo(same)
				.isNotEqualTo(other)
				.isNotEqualTo(null)
				.isNotEqualTo(new Object());
	}
	
	@Test
	public void shouldReturnRepresentationAsString() {
		Id id = new Id();
		assertThat(id.toString()).matches("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}");
	}

}
