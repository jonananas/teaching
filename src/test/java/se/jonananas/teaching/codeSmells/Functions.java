package se.jonananas.teaching.codeSmells;

public class Functions {

	class AdressLabel {

		public String label;
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

	public void createAdressLabel(AdressLabel label, String address, String apartment, String zip, String city) {
		label.label = address + " " + apartment + "\n" + zip + city;
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
	private int calcNumberOfLegs() {
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
