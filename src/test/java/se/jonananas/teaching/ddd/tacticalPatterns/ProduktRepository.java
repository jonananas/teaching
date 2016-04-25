package se.jonananas.teaching.ddd.tacticalPatterns;

public interface ProduktRepository {

	void persist(Produkt produkt);

	Produkt findByName(String name);

	void delete(Produkt produkt);

}
