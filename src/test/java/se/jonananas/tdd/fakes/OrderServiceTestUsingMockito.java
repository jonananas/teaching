package se.jonananas.tdd.fakes;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class OrderServiceTestUsingMockito {
	
	public static class Order {
		public static Order createOrder() {
			return new Order();
		}
	}
	
	public static class OrderService {
		private Mailer mailer;

		public void addOrder(Order dummyOrder) {
			this.mailer.sendEmail(dummyOrder);
		}

		public void setMailer(Mailer mailer) {
			this.mailer = mailer;
		}
	}
	
	public static interface Mailer {
		void sendEmail(Order dummyOrder);
	}
	
	@Test
	public void shouldSendEmailWhenAddingOrder() throws Exception {
		// Setup
		Order dummyOrder = Order.createOrder();
		OrderService orderService = new OrderService();
		Mailer mailer = mock(Mailer.class);
		orderService.setMailer(mailer);
		
		// Exercise
		orderService.addOrder(dummyOrder);
		
		// Verify
		verify(mailer, times(1)).sendEmail((Order) any());
	}

}
