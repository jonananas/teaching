package se.jonananas.teaching.codeSmells;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class TellIfSundayTest {

	public static class TellIfSunday {

		public boolean isSunday() {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			int weekday = calendar.get(Calendar.DAY_OF_WEEK);
			return weekday == Calendar.SUNDAY;
		}
	}

	@Test
	public void shouldReturnTuesday() throws Exception {
		Assert.assertTrue(new TellIfSunday().isSunday());
	}
}
