package se.jonananas.teaching.ddd.tacticalPatterns;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class AdressValueObjectTest {

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
