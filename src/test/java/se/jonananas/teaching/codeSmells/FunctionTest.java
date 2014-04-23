package se.jonananas.teaching.codeSmells;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class FunctionTest {
	
	class MyClass {
		public String param = new String();
	}
	
	@Test
	public void shouldPassByReference() throws Exception {
		MyClass anObject = new MyClass();
		alterParam(anObject);
		
		assertThat(anObject.param).isEqualTo("tjoho");
	}

	private void alterParam(final MyClass anObject) {
		anObject.param = "tjoho";
	}

}
