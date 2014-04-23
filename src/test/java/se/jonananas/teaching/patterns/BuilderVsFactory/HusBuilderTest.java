package se.jonananas.teaching.patterns.BuilderVsFactory;

import static org.fest.assertions.Assertions.assertThat;


import org.junit.Test;

public class HusBuilderTest {
	
	public static class Rum {
	}

	public static class Vardagsrum extends Rum {
	}
	
	public static class Kök extends Rum {
	}
	
	public static class Toalett extends Rum {
	}
	
	@Test
	public void shouldContainRum() throws Exception {
		Hus hus = Hus.builder().medKök().medVardagsrum().medToalett().build();
		
		assertThat(hus.antalRum()).isEqualTo(3);
	}
}
