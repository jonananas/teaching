package se.jonananas.teaching.codeSmells.encapsulation;

import static java.lang.Math.PI;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

import se.jonananas.teaching.codeSmells.encapsulation.CirkelTest.Cirkel;

public class CirkelTest {
	
	public static class Cirkel {

		private double r;

		public Cirkel(double r) {
			this.r = r;
		}

		public static Cirkel medRadie(double r) {
			return new Cirkel(r);
		}

		public double area() {
			return 2 * PI * r;
		}
	}
	
	@Test
	public void skaBeräknaArea() throws Exception {
		Cirkel cirkel = Cirkel.medRadie(3);
		
		assertThat(cirkel.area()).isEqualTo(6 * PI);
	}

}
