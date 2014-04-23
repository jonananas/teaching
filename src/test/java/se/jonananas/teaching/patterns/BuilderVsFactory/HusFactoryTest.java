package se.jonananas.teaching.patterns.BuilderVsFactory;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HusFactoryTest {
	
	public static class Hus {
		private List<Rum> rum = new ArrayList<Rum>();

		public List<Rum> rum() {
			return rum ;
		}

		public void add(Rum rum) {
			this.rum.add(rum);
		}

		public int antalRum() {
			return this.rum.size();
		}

		public static Hus createWithRum(Rum vardagsrum, Rum kök, Rum toalett) {
			Hus hus = new Hus();
			hus.add(vardagsrum);
			hus.add(kök);
			hus.add(toalett);
			return hus;
		}
	}

	public class Rum {
	}

	public class Vardagsrum extends Rum {
	}
	
	public class Kök extends Rum {
	}
	
	public class Toalett extends Rum {
	}
	
	@Test
	public void shouldContainRum() throws Exception {
		Hus hus = Hus.createWithRum(new Vardagsrum(), new Kök(), new Toalett());
		
		assertThat(hus.antalRum()).isEqualTo(3);
	}
}
