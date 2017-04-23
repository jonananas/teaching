package se.jonananas.teaching.design.theCaseForNaming;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ABCDETest {
	
	public class A {
		private List<B> list = new ArrayList<B>();

		public List<B> get() {
			return list ;
		}

		public void sub(B b) {
			this.list.add(b);
		}
	}

	public class B {
	}

	public class C extends B {
	}
	
	public class D extends B {
	}
	
	public class E extends B {
	}
	
	@Test
	public void test() throws Exception {
		A a = new A();
		
		B b1 = new C();
		B b2 = new D();
		B b3 = new E();
		
		a.sub(b1);
		a.sub(b2);
		a.sub(b3);
		
		assertThat(a.get().size()).isEqualTo(3);
		assertThat(a.get()).contains(b1);
	}
}
