package se.jonananas.teaching.patterns.BuilderVsFactory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * Example of how factory methods might not be enough to clarify creation
 */
public class HusFactoryTest {
	Kök kök = new Kök();
	Sovrum sovrum = new Sovrum();
	Toalett toalett = new Toalett();
	Vardagsrum vardagsrum = new Vardagsrum();
	
	@Test
	public void shouldCreateEttRumOchKök() throws Exception {

		Hus hus = Hus.createEttRumOchKök(sovrum, kök, toalett);
		
		assertThat(hus.rum()).containsOnly(kök, sovrum, toalett);
	}

	@Test
	public void shouldCreateTvåRumOchKök() throws Exception {
		
		Hus hus = Hus.createTvåRumOchKök(vardagsrum, sovrum, kök, toalett);
		
		assertThat(hus.rum()).containsOnly(vardagsrum, kök, sovrum, toalett);
	}

	/*
	 * We have two static method factories, and one that takes 4 parameters. That's two reasons to consider a Builder instead.
	 */
	public static class Hus {

		private List<Rum> rum = new ArrayList<Rum>();

		private Hus(){
		}

		public List<Rum> rum() {
			return rum ;
		}

		/*
		 * Static method factory
		 */
		public static Hus createEttRumOchKök(Rum vardagsrum, Rum kök, Rum toalett) {
			Hus hus = new Hus();
			hus.add(vardagsrum);
			hus.add(kök);
			hus.add(toalett);
			return hus;
		}

		/*
		 * Static method factory, but with too many parameters - prefer builder to this!
		 */
		public static Hus createTvåRumOchKök(Vardagsrum vardagsrum, Sovrum sovrum, Kök kök, Toalett toalett) {
			Hus hus = new Hus();
			hus.add(vardagsrum);
			hus.add(sovrum);
			hus.add(kök);
			hus.add(toalett);
			return hus;
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

	public class Sovrum extends Rum {
	}
	
	public class Kök extends Rum {
	}
	
	public class Toalett extends Rum {
	}
	
	public class Vardagsrum extends Rum {
	}
}
