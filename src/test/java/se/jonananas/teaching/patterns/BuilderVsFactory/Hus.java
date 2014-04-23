package se.jonananas.teaching.patterns.BuilderVsFactory;

import java.util.ArrayList;
import java.util.List;

import se.jonananas.teaching.patterns.BuilderVsFactory.HusBuilderTest.Rum;

public class Hus {
	private List<Rum> rum = new ArrayList<Rum>();

	Hus(List<Rum> rum) {
		this.rum = rum;
	}

	public List<Rum> rum() {
		return rum ;
	}

	public void add(Rum rum) {
		this.rum.add(rum);
	}

	public int antalRum() {
		return this.rum.size();
	}

	public static HusBuilder builder() {
		return new HusBuilder();
	}
}