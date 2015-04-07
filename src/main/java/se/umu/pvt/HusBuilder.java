package se.umu.pvt;

import java.util.List;

import com.google.common.collect.Lists;

public class HusBuilder {
	List<Rum> rum = Lists.newArrayList();

	public HusBuilder withRum(Rum rum) {
		this.rum.add(rum);
		return this;
	}
	
	public Hus build() {
		Hus hus = new Hus();
		hus.rum.addAll(this.rum);
		return hus;
	}
	
}