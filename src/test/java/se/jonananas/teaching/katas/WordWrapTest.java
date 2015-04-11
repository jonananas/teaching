package se.jonananas.teaching.katas;

import static org.fest.assertions.Assertions.assertThat;

import org.fest.assertions.StringAssert;
import org.junit.Test;

public class WordWrapTest {

	public static class WordWrap {

		public static String wrap(String text, int wrapAfter) {
			int wrapPoint = text.indexOf(" ", wrapAfter);
			if (nothingToWrap(wrapPoint))
				return text;
			return head(text, wrapPoint) + "\n" + wrap(tail(text, wrapPoint), wrapAfter);
		}

		private static String tail(String text, int wrapPoint) {
			return text.substring(wrapPoint+1);
		}

		private static String head(String text, int wrapPoint) {
			return text.substring(0, wrapPoint);
		}

		private static boolean nothingToWrap(int wrapPoint) {
			return wrapPoint == -1;
		}

	}

	@Test
	public void shouldWrapSentence() throws Exception {
		String input = "detta är en lite längre mening";
		int wrapAfter = 10;
		String expected = "detta är en\nlite längre\nmening";
		assertWrap(input, wrapAfter).isEqualTo(expected);
	}

	@Test(expected = NullPointerException.class)
	public void shouldThrowOnNull() throws Exception {
		WordWrap.wrap(null, 0);
	}

	@Test
	public void shouldNotWrapEmptyString() throws Exception {
		assertWrap("", 0).isEqualTo("");
	}
	
	@Test
	public void shouldNotWrapOneWord() throws Exception {
		assertWrap("one", 0).isEqualTo("one");
	}
	
	@Test
	public void shouldWrapTwoWords() throws Exception {
		assertWrap("one two", 0).isEqualTo("one\ntwo");
	}

	@Test
	public void shouldNotWrapTwoWordsWithLateWrapPoint() throws Exception {
		assertWrap("one two", 4).isEqualTo("one two");
	}
	
	@Test
	public void shouldWrapTwoWordAtWrapPoint() throws Exception {
		assertWrap("one two", 3).isEqualTo("one\ntwo");
	}
	
	@Test
	public void shouldWrapThreeWords() throws Exception {
		assertWrap("one two three", 3).isEqualTo("one\ntwo\nthree");
	}
	
	private StringAssert assertWrap(String input, int wrapAfter) {
		return assertThat(wrap(input, wrapAfter));
	}

	private String wrap(String input, int wrapAfter) {
		return WordWrap.wrap(input, wrapAfter);
	}
}
