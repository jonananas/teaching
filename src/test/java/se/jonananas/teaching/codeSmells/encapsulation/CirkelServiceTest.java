package se.jonananas.teaching.codeSmells.encapsulation;

import static java.lang.Math.PI;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import se.jonananas.teaching.codeSmells.encapsulation.CirkelServiceTest.Cirkel;

public class CirkelServiceTest {
	
	public static class Cirkel {

		private double r;

		public Cirkel(double r) {
			this.r = r;
		}

		public static Cirkel medRadie(double r) {
			return new Cirkel(r);
		}

		public double radie() {
			return r;
		}
	}
	
	public static class CirkelService {

		public double areaAv(Cirkel cirkel) {
			return 2*PI*cirkel.radie();
		}
		
	}
	
	@Test
	public void skaBeräknaArea() throws Exception {
		Cirkel cirkel = Cirkel.medRadie(3);
		
		assertThat(new CirkelService().areaAv(cirkel)).isEqualTo(6 * PI);
	}

}
