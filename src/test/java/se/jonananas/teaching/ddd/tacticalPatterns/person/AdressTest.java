package se.jonananas.teaching.ddd.tacticalPatterns.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AdressTest {

	@Test
	public void shouldCreateAdress() throws Exception {
		Adress adress = Adress.createFrom("Storgatan 2");

		assertThat(adress.getGatuadress()).isEqualTo("Storgatan 2");
	}

	@Test
	public void shouldBeEqualByAttributes() throws Exception {
		Adress adress = Adress.createFrom("Storgatan 2");
		Adress same = Adress.createFrom("Storgatan 2");
		Adress other = Adress.createFrom("Storgatan 55");

		assertThat(adress).isEqualTo(same).isNotEqualTo(other).isNotEqualTo(new Object()).isNotEqualTo(null);
	}

}
