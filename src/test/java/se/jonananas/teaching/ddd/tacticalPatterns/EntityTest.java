package se.jonananas.teaching.ddd.tacticalPatterns;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class EntityTest {
	
	private class AnEntity extends Entity {
		private static final long serialVersionUID = 1L;

		public AnEntity(Id id) {
			super(id);
		}

		public AnEntity() {
			super();
		}
	}
	
	
	@Test
	public void shouldBeEqualOnlyToItself() {
		AnEntity entity = new AnEntity();
		AnEntity other = new AnEntity();
		AnEntity same = new AnEntity(entity.id());
		
		assertThat(entity).isEqualTo(same)
				.isNotEqualTo(other)
				.isNotEqualTo(null)
				.isNotEqualTo(new Object());
	}
}
