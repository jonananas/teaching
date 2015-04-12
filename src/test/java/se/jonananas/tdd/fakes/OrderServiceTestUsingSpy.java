package se.jonananas.tdd.fakes;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class OrderServiceTestUsingSpy {
	
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

		boolean isEmailSent();

		void sendEmail(Order dummyOrder);
	}
	
	public static class MailerSpy implements Mailer {

		private boolean emailSent = false;

		@Override
		public boolean isEmailSent() {
			return this.emailSent;
		}

		@Override
		public void sendEmail(Order dummyOrder) {
			this.emailSent = true;
		}
		
	}
	
	@Test
	public void shouldNotHaveSentEmailBeforeUse() throws Exception {
		assertThat(new MailerSpy().isEmailSent()).isFalse();
	}
	
	@Test
	public void shouldSendEmailWhenAddingOrder() throws Exception {
		Order dummyOrder = Order.createOrder();
		
		OrderService orderService = new OrderService();
		Mailer mailer = new MailerSpy();
		orderService.setMailer(mailer);
		orderService.addOrder(dummyOrder);
		
		assertThat(mailer.isEmailSent()).isTrue();
	}

}
