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

		private Cirkel(Builder builder) {
			this.r = builder.r;
		}

		public double radie() {
			return r;
		}
		
		public static Builder builder() {
			return new Builder();
		}
		
		public static class Builder {
			private double r;

			public Builder medRadie(double radie) {
				this.r = radie;
				return this;
			}

			public Builder färg(int gRÖN) {
				return this;
			}

			public Cirkel build() {
				return new Cirkel(this);
			}
			
		}
	}
	
	public static class CirkelService {

		public double areaAv(Cirkel cirkel) {
			return 2*PI*cirkel.radie();
		}
		
	}
	
	@Test
	public void skaBeräknaArea() throws Exception {
		final int GRÖN = 1; 
		Cirkel cirkel = Cirkel.builder().medRadie(3).färg(GRÖN).build();
		Cirkel cirkel2 = Cirkel.builder().medRadie(3).build();
		
		assertThat(new CirkelService().areaAv(cirkel)).isEqualTo(6 * PI);
	}

}
