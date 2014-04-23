package se.jonananas.teaching.patterns.BuilderVsFactory;

import java.util.ArrayList;
import java.util.List;

import se.jonananas.teaching.patterns.BuilderVsFactory.HusBuilderTest.Kök;
import se.jonananas.teaching.patterns.BuilderVsFactory.HusBuilderTest.Rum;
import se.jonananas.teaching.patterns.BuilderVsFactory.HusBuilderTest.Toalett;
import se.jonananas.teaching.patterns.BuilderVsFactory.HusBuilderTest.Vardagsrum;

public class HusBuilder {
	
	private List<Rum> rum = new ArrayList<Rum>();

	public HusBuilder medKök() {
		rum.add(new Kök());
		return this;
	}

	public HusBuilder medVardagsrum() {
		rum.add(new Vardagsrum());
		return this;
	}

	public HusBuilder medToalett() {
		rum.add(new Toalett());
		return this;
	}

	public Hus build() {
		return new Hus(rum);
	}
	
}