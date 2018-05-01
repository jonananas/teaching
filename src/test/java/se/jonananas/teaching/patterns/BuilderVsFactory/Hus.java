package se.jonananas.teaching.patterns.BuilderVsFactory;

import java.util.ArrayList;
import java.util.List;

import se.jonananas.teaching.patterns.BuilderVsFactory.HusBuilderTest.Rum;

public class Hus {
	private List<Rum> rum = new ArrayList<Rum>();

	private Hus(HusBuilder builder) {
		this.rum = builder.rum;
	}

	public List<Rum> rum() {
		return rum;
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

	public static class HusBuilder {

        private List<Rum> rum = new ArrayList<Rum>();

        public HusBuilder medKök(HusBuilderTest.Kök kök) {
            rum.add(kök);
            return this;
        }

        public HusBuilder medVardagsrum(HusBuilderTest.Vardagsrum vardagsrum) {
            rum.add(vardagsrum);
            return this;
        }

        public HusBuilder medToalett(HusBuilderTest.Toalett toalett) {
            rum.add(toalett);
            return this;
        }

        public Hus build() {
            return new Hus(this);
        }

        public HusBuilder medSovrum(HusBuilderTest.Sovrum sovrum) {
            rum.add(sovrum);
            return this;
        }
    }
}