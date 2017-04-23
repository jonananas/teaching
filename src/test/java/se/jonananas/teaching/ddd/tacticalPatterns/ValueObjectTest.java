package se.jonananas.teaching.ddd.tacticalPatterns;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ValueObjectTest {
	
	@SuppressWarnings("unused")
	private static class AValueObject extends ValueObject {
		private int anInt;
		private String aString;

		private transient int transientInt;
		
		public AValueObject(int i, String s) {
			this.anInt = i;
			this.aString = s;
			this.transientInt = 7;
		}
		
		public AValueObject(int i, String s, int t) {
			this.anInt = i;
			this.aString = s;
			this.transientInt = t;
		}
	}
	
	// Test for inheritance as well - which rules apply?
	AValueObject aValueObject = new AValueObject(3, "tjo");
	AValueObject same = new AValueObject(3, "tjo");
	AValueObject otherInt = new AValueObject(4, "tjo");
	AValueObject otherString = new AValueObject(3, "tja");
	
	@Test
	public void shouldBeEqualByAttributes() throws Exception {

		assertThat(aValueObject).isEqualTo(same).isNotEqualTo(otherInt).isNotEqualTo(otherString).isNotEqualTo(new Object()).isNotEqualTo(null);
		assertThat(aValueObject.hashCode()).isEqualTo(same.hashCode()).isNotEqualTo(otherInt.hashCode()).isNotEqualTo(otherString.hashCode()).isNotEqualTo(new Object().hashCode());
	}
	
	@Test
	public void shouldIgnoreTransients() {
		AValueObject sameButDifferentTransient = new AValueObject(3, "tjo", 6);
		
		assertThat(aValueObject).isEqualTo(sameButDifferentTransient);
		assertThat(aValueObject.hashCode()).isEqualTo(sameButDifferentTransient.hashCode());
	}
	
	@Test
	public void shouldDifferNullAndEmpty() {
		AValueObject hasNull = new AValueObject(3, null);
		AValueObject isEmpty = new AValueObject(3, "");
		
		assertThat(hasNull).isNotEqualTo(isEmpty);
		// However they produce same hashcode!
		assertThat(hasNull.hashCode()).isEqualTo(isEmpty.hashCode());
	}

	private static class SameValueObject extends AValueObject {

		public SameValueObject(int i, String s) {
			super(i, s);
		}
	}
	
	@Test
	public void shouldBeSameIfSameFieldEvenIfDifferentClasses() {
		SameValueObject inherited = new SameValueObject(3, "tjo");
		
		assertThat(inherited).isEqualTo(aValueObject);
		assertThat(inherited.hashCode()).isEqualTo(aValueObject.hashCode());
	}
	
	@SuppressWarnings("unused")
	private static class DifferentValueObject extends AValueObject {
		double extra = 1.0d;

		public DifferentValueObject(int i, String s) {
			super(i, s);
		}
	}		

	@Test
	public void shouldBeDifferentIfDifferentFields() {
		DifferentValueObject inherited = new DifferentValueObject(3, "tjo");
		
		assertThat(inherited).isNotEqualTo(aValueObject);
		assertThat(inherited.hashCode()).isNotEqualTo(aValueObject.hashCode());
	}
}
