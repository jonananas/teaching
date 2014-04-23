package se.jonananas.teaching.codeSmells;

public class Comments {
	
	class SellResponse {
		public SellResponse(int i) {
		}
	}
	class SellRequest {
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 *  C2
	 *  Obsolete Comment
	 */
	
	public SellRequest createSellRequest() {
		// Loop over all cellrequests and return the highest
		return new SellRequest();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 *  C3 
	 *  Redundant Comment
	 */
	
	/**
	 * @param sellRequest
	 * @return
	 * @throws Exception 
	 */
	public SellResponse beginSellItem(SellRequest sellRequest) throws Exception {
		int i = 0;
		i++;  // Increment i
		
		return new SellResponse(i);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * C5
	 * Commented out code
	 */

	public SellResponse createSellResponse() {
//		int i = 0;
//		i++;  
		
		return new SellResponse(0);
	}
}


























