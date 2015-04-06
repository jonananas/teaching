package se.umu.pvt;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class HusFactoryTest {
	
	public static interface HusFactory {
		Hus createHus(Rum createVardagsRum);
	}
	
	public static class HusFactoryImpl implements HusFactory {

		@Override
		public Hus createHus(Rum rum) {
			Hus hus = new Hus();
			hus.addRum(rum);
			return hus;
		}
	}
	
	public static class Hus {
		
		private List<Rum> rum = Lists.newArrayList();

		private Hus() {
		}

		private void addRum(Rum rum) {
			this.rum.add(rum);
		}

		public List<Rum> getRum() {
			return this.rum;
		}
		
	}
	
	public static class Rum {
		
		private Rum() {
		}

		public static Rum createVardagsRum() {
			return new Rum();
		}
	}
	
	@Test
	public void shouldCreateHus() throws Exception {
		Hus hus = (new HusFactoryImpl()).createHus(Rum.createVardagsRum());
		
		assertThat(hus).isNotNull();
		assertThat(hus.getClass()).isEqualTo(Hus.class);
		assertThat(hus.getRum().size()).isEqualTo(1);
	}

}
