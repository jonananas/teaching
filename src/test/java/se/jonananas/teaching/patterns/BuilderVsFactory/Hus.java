package se.jonananas.teaching.patterns.BuilderVsFactory;

import java.util.ArrayList;
import java.util.List;

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


	public static class HusBuilder {

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
            return new Hus(this);
        }

        public HusBuilder medSovrum(Sovrum sovrum) {
            rum.add(sovrum);
            return this;
        }
    }
}
