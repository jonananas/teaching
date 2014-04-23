package se.jonananas.teaching.ddd.tacticalPatterns;

import java.io.Serializable;
import java.util.UUID;


public class Produkt implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private UUID id;

	private Produkt(String name) {
		this.name = name;
		this.id = UUID.randomUUID();
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
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Produkt))
			return false;
		Produkt other = (Produkt)obj;
		return this.id.equals(other.id);
	}
	
	@Override
	public int hashCode() {
		return 31 + ((id == null) ? 0 : id.hashCode());
	}

}
