package se.jonananas.teaching.ddd.tacticalPatterns;

public class Produkt extends Entity {
	private static final long serialVersionUID = 1L;
	private String name;

	private Produkt(String name) {
		super();
		this.name = name;
	}

	public static Produkt createFromName(String name) {
		return new Produkt(name);
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
