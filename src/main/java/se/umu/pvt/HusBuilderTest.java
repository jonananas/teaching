package se.umu.pvt;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class HusBuilderTest {
	
	public static class Hus {
		private List<Rum> rum = Lists.newArrayList();

		public static HusBuilder builder() {
			return new HusBuilder();
		}

		public List<Rum> getRum() {
			return this.rum;
		}
		
	}
	
	public static class HusBuilder {
		List<Rum> rum = Lists.newArrayList();

		public HusBuilder withRum(Rum rum) {
			this.rum.add(rum);
			return this;
		}
		
		public Hus build() {
			Hus hus = new Hus();
			hus.rum.addAll(this.rum);
			return hus;
		}
		
	}
	
	public static class Rum {

		public static Rum createVardagsRum() {
			return new Rum();
		}
	}
	
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
