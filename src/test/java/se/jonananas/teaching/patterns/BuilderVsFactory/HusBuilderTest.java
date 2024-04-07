package se.jonananas.teaching.patterns.BuilderVsFactory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import se.jonananas.teaching.patterns.BuilderVsFactory.Hus.Kök;
import se.jonananas.teaching.patterns.BuilderVsFactory.Hus.Sovrum;
import se.jonananas.teaching.patterns.BuilderVsFactory.Hus.Toalett;

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

		assertThat(hus.rum()).containsExactly(kök, sovrum, toalett);
	}

	@Test
	public void shouldCreateTvåRumOchKök() throws Exception {

		final Sovrum sovrum2 = new Sovrum();

		Hus hus = Hus.builder()
				.medKök(kök)
				.medSovrum(this.sovrum)
				.medSovrum(sovrum2)
				.medToalett(toalett)
				.build();

		assertThat(hus.rum()).containsExactly(kök, sovrum, sovrum2, toalett);
	}
}
