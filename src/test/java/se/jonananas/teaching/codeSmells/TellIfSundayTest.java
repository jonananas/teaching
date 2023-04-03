package se.jonananas.teaching.codeSmells;
import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

public class TellIfSundayTest {

	public static class TellIfSunday {

		private LocalDate now;

		TellIfSunday() {
			this.now = LocalDate.now();
		}

		public boolean isSunday() {
			return now.getDayOfWeek() == DayOfWeek.SUNDAY;
		}
	}

	@Test
	public void shouldReturnTuesday() throws Exception {
		Assert.assertTrue(new TellIfSunday().isSunday());
	}
}
