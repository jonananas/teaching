package se.umu.pvt;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class HusBuilderTest {
	
	@Test
	public void shouldBuildHusWithOneRoom() throws Exception {
		Rum vardagsRum = Rum.createVardagsRum();
		Hus hus = Hus.builder().withRum(vardagsRum).build();
		
		assertThat(hus).isNotNull();
		assertThat(hus.getClass()).isEqualTo(Hus.class);
		assertThat(hus.getRum()).contains(vardagsRum);
	}
	
	@Test
	public void shouldBuildHusWithThreeRoom() throws Exception {
		Rum vardagsRum = Rum.createVardagsRum();
		Rum rum2 = Rum.createVardagsRum();
		Rum rum3 = Rum.createVardagsRum();
		Hus hus = Hus.builder().withRum(vardagsRum).withRum(rum2).withRum(rum3).build();
		
		assertThat(hus).isNotNull();
		assertThat(hus.getClass()).isEqualTo(Hus.class);
		assertThat(hus.getRum()).contains(vardagsRum).contains(rum2).contains(rum3);
	}
}
