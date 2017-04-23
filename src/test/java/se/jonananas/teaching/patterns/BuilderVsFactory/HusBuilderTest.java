package se.jonananas.teaching.patterns.BuilderVsFactory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class HusBuilderTest {
	Kök kök = new Kök();
	Sovrum sovrum = new Sovrum();
	Toalett toalett = new Toalett();
	
	@Test
	public void shouldCreateEttRumOchKök() throws Exception {

		Hus hus = Hus.builder()
				.medKök(kök)
				.medSovrum(sovrum)
				.medToalett(toalett)
				.build();

		assertThat(hus.rum()).containsOnly(kök, sovrum, toalett);
	}
	
	public static class Rum {
	}

	public static class Vardagsrum extends Rum {
	}
	
	public static class Sovrum extends Rum {
	}

	public static class Kök extends Rum {
	}

	public static class Toalett extends Rum {
	}
}
