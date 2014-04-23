package se.jonananas.teaching.ddd.tacticalPatterns;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ProduktRepositoryTest {

	private Produkt gräsklippare;
	private ProduktRepository repo;

	@Before
	public void setup() {
		gräsklippare = Produkt.createFromName("Gräsklippare");
		repo = ProduktRepositoryInMem.create();
	}

	@Test
	public void shouldFindStoredProdukt() throws Exception {
		repo.persist(gräsklippare);

		Produkt gräsklippare2 = repo.findByName("Gräsklippare");

		assertThat(gräsklippare).isEqualTo(gräsklippare2);
	}

	@Test
	public void shouldNotFindNotStoredProdukt() throws Exception {
		repo.persist(gräsklippare);

		Produkt gräsklippare2 = repo.findByName("other");

		assertThat(gräsklippare).isNotEqualTo(gräsklippare2);
	}
	
	@Test
	public void shouldDeleteProdukt() throws Exception {
		repo.persist(gräsklippare);
		repo.delete(gräsklippare);

		assertThat(repo.findByName("Gräsklippare")).isNotEqualTo(gräsklippare);

	}

}
