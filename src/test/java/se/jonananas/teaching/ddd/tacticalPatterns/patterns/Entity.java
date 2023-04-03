package se.jonananas.teaching.ddd.tacticalPatterns.patterns;

import java.io.Serializable;

public abstract class Entity implements Serializable {
	private static final long serialVersionUID = 1L;
	Id id;
	
	public Entity() {
		id = new Id();
	}
	
	public Entity(Id id) {
		this.id = id;
	}
	
	public Id id() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Entity))
			return false;
		Entity other = (Entity) obj;
		return this.id.equals(other.id);
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
