package se.jonananas.teaching.codeSmells;

public class Functions {
	
	abstract class Address {
		public abstract String address();
		public abstract String apartment();
		public abstract String zip();
		public abstract String city();
	}

	static class AddressLabel {

		public String label;

		public AddressLabel(String label) {
			this.label = label;
		}

		public static AddressLabel fromString(String label) {
			return new AddressLabel(label);
		}
	}

	private void renderTest() {
	}

	private void renderSuite() {
	}


	
	
	
	
	
	
	/*
	 * F1
	 * Too many arguments Prefer none one, two, three is ok (sort of) More than that is smelling
	 * really bad!
	 */

	public String createAdressLabel(String address, String apartment, String zip, String city) {
		return address + " " + apartment + "\n" + zip + city;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * F2
	 * Output arguments
	 */

	public void createAdressLabel(AddressLabel label, Address address) {
		label.label = address.address() + " " + address.apartment() + "\n" + address.zip() + address.city();
	}

	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Bättre?
	 */
	public AddressLabel createAdressLabel(Address address) {
		return AddressLabel.fromString(address.address() + " " + address.apartment() + "\n" + address.zip() + address.city());
	}

	
	
	
	
	
	
	
	
	
	
	
	/*
	 * F3
	 * Flag arguments
	 */

	public void render(boolean isSuite) {
		if (isSuite)
			renderSuite();
		else
			renderTest();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * F4/G9
	 * Dead code
	 */
	public int calcNumberOfLegs() {
		try {
			boolean makeItThree = false;
			int result = 0;
			if (makeItThree) {
				result = 3;
			} else {
				result = 4;
			}
			return result;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
