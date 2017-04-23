package se.jonananas.teaching.ddd.tacticalPatterns;

import java.util.HashMap;
import java.util.Map;

public class ProduktRepositoryInMem implements ProduktRepository {

	private Map<String, Produkt> produkts;
	
	private ProduktRepositoryInMem() {
		produkts = new HashMap<>();
	}

	@Override
	public void persist(Produkt produkt) {
		produkts.put(produkt.getName(), produkt);
	}

	@Override
	public Produkt findByName(String name) {
		return produkts.get(name);
	}

	public static ProduktRepository create() {
		return new ProduktRepositoryInMem();
	}

	@Override
	public void delete(Produkt gräsklippare) {
		produkts.remove(gräsklippare.getName());
	}

}
