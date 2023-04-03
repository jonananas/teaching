package se.jonananas.teaching.ddd.tacticalPatterns.patterns;

import java.io.Serializable;
import java.util.UUID;

public class Id implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private UUID id;
		
		public Id() {
			this.id = UUID.randomUUID();
		}
		
		public Id(Id id) {
			this.id = id.id;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof Id))
				return false;
			Id other = (Id) obj;
			return id.equals(other.id);
		}
		
		@Override
		public int hashCode() {
			return id.hashCode();
		}
		
		public String toString() {
			return id.toString();
		}
}
