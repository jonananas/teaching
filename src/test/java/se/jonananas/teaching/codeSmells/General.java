package se.jonananas.teaching.codeSmells;

import org.junit.Ignore;
import org.junit.Test;

public class General {

	private String querySingleResult(String sql) {
		return null;
	}
	
	class Person {

		public boolean isTall() {
			return false;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * G1
	 * Multiple languages in one source file
	 * @see address_book_process.php
	 */
	
	public String numberOfOrdersAsHtml() {
		String sql = "SELECT count(*) from Orders o";
		String numberOfOrders = querySingleResult(sql);
		String html = "<script>alert('This is a very important alert');</script>";
		html+= "<strong>Number of orders: " + numberOfOrders + "</strong>";
		return html;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * G3
	 * Incorrect behavior at boundaries
	 * Don't be lazy! Write test for it!
	 */
	
	
	
	
	
	
	
	
	
	/*
	 * G4
	 * Overridden safeties
	 * - Disabled/Ignored compiler warnings
	 * "Chernobyl melted down because the plant manager overrode each of the safety mechanisms"
	 */
	@Test
	@Ignore
	public void shouldReturnEmptyStringOnUnknownEntity() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * G5
	 * Duplication
	 */
	
	/*
	 * G7
	 *  Base Classes Depending on their derivatives
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * G29
	 * Avoid negative conditionals
	 */
	public String makeHeightIndication(Person person) {
		if (!person.isTall()) {
			return "Person is short";
		} else {
			return "Person is tall";
		}
	}
	
	
	
	
	
	
	
	
	
	
	/*
	 * G23
	 * Prefer Polymorphism to If/Else or Switch/Case
	 * "ONE SWITCH" rule: There may be no more than one switch statement for a given type of selection.
	 * The cases in that switch statement must create polymorphic objects that take the place of other such switch
	 * statements in the rest of the system.
	 */
	
	public static class ProductOption {
		public enum OptionCode {delivermethod, coords, deviceID}
	}
	
	public static class Coords {
		public static boolean validCoords(String text) {
			return false;
		}
	}
	
	public static String validateText(ProductOption.OptionCode optionCode, String text) {
		switch (optionCode) {
		case coords:
			if (!Coords.validCoords(text))
				throw new IllegalArgumentException();
			break;
		case deviceID:
			if (!text.matches("\\d{10}"))
				throw new IllegalArgumentException();
			break;
		default:
			if (text.length() > 255)
				throw new IllegalArgumentException("Invalid text: " + text);
			break;
		}
		return text;
	}
	
	
	// Better?
	public static abstract class ProductOption2 {
		public abstract boolean isValidText(String text);
	}

	public static String betterValidateText(ProductOption2 productOption, String text) {
		if (!productOption.isValidText(text))
			throw new IllegalArgumentException();
		return text;
	}

	public static class Coordinate extends ProductOption2 {
		public boolean isValidText(String text) {
			return Coords.validCoords(text);
		}
	}

	public static class DeviceID extends ProductOption2 {
		public boolean isValidText(String text) {
			return text.matches("\\d{10}");
		}
	}

	public static class TextOption extends ProductOption2 {
		public boolean isValidText(String text) {
			return text.length() > 255;
		}
	}
}
