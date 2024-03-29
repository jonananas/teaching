package se.jonananas.teaching.ddd.tacticalPatterns.produkt;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import se.jonananas.teaching.ddd.tacticalPatterns.patterns.Entity;

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
	public void shouldSetName() throws Exception {
		gräsklippare.setName("Grusklippare");
		assertThat(gräsklippare.getName()).isEqualTo("Grusklippare");
	}
	
	@Test
	public void shouldBeAnEntity() {
		assertThat(gräsklippare).isInstanceOf(Entity.class);
	}
}
