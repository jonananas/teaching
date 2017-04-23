package se.jonananas.teaching.patterns.BuilderVsFactory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HusTest {
	
	public class Hus {
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
		Hus hus = new Hus();
		
		Rum vardagsrum = new Vardagsrum();
		Rum kök = new Kök();
		Rum toalett = new Toalett();
		
		hus.add(vardagsrum);
		hus.add(kök);
		hus.add(toalett);
		
		assertThat(hus.antalRum()).isEqualTo(3);
		assertThat(hus.rum()).contains(vardagsrum);
	}
}
