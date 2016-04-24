package se.jonananas.teaching.patterns.BuilderVsFactory;

import java.util.ArrayList;
import java.util.List;

import se.jonananas.teaching.patterns.BuilderVsFactory.HusBuilderTest.Kök;
import se.jonananas.teaching.patterns.BuilderVsFactory.HusBuilderTest.Rum;
import se.jonananas.teaching.patterns.BuilderVsFactory.HusBuilderTest.Sovrum;
import se.jonananas.teaching.patterns.BuilderVsFactory.HusBuilderTest.Toalett;
import se.jonananas.teaching.patterns.BuilderVsFactory.HusBuilderTest.Vardagsrum;

public class HusBuilder {
	
	private List<Rum> rum = new ArrayList<Rum>();

	public HusBuilder medKök(Kök kök) {
		rum.add(kök);
		return this;
	}

	public HusBuilder medVardagsrum(Vardagsrum vardagsrum) {
		rum.add(vardagsrum);
		return this;
	}

	public HusBuilder medToalett(Toalett toalett) {
		rum.add(toalett);
		return this;
	}

	public Hus build() {
		return new Hus(rum);
	}

	public HusBuilder medSovrum(Sovrum sovrum) {
		rum.add(sovrum);
		return this;
	}
}