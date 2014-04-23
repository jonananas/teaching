package se.jonananas.teaching.ddd.tacticalPatterns;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ProduktEntityTest {

	private Produkt gräsklippare;

	@Before
	public void setup() {
		gräsklippare = Produkt.createFromName("Gräsklippare");
	}

	@Test
	public void shouldCreateProdukt() throws Exception {
		Produkt gräsklippare = Produkt.createFromName("Gräsklippare");

		assertThat(gräsklippare.getName()).isEqualTo("Gräsklippare");
	}

	@Test
	public void shouldBeEqualOnlyToItself() throws Exception {
		Produkt other = Produkt.createFromName("Gräsklippare");
		
		Produkt same = gräsklippare;

		assertThat(same).isEqualTo(gräsklippare)
				.isNotEqualTo(other)
				.isNotEqualTo(null)
				.isNotEqualTo(new Object());
	}
	
	@Test
	public void shouldSetName() throws Exception {
		gräsklippare.setName("Grusklippare");
		assertThat(gräsklippare.getName()).isEqualTo("Grusklippare");
	}
}
