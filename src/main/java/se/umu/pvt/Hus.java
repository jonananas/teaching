package se.umu.pvt;

import java.util.List;

import com.google.common.collect.Lists;

public class Hus {
	List<Rum> rum = Lists.newArrayList();

	public static HusBuilder builder() {
		return new HusBuilder();
	}

	public List<Rum> getRum() {
		return this.rum;
	}
}