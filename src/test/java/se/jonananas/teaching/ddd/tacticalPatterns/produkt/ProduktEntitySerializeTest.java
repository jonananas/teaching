package se.jonananas.teaching.ddd.tacticalPatterns.produkt;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.junit.Before;
import org.junit.Test;

public class ProduktEntitySerializeTest {

	private Produkt gräsklippare;

	@Before
	public void setup() {
		gräsklippare = Produkt.createFromName("Gräsklippare");
	}

	@Test
	public void shouldCreateProdukt() throws Exception {
		Produkt gräsklippare = Produkt.createFromName("Gräsklippare");

		assertThat(gräsklippare.getName()).isEqualTo("Gräsklippare");
	}

	@Test
	public void shouldBeEntity() throws Exception {
		Produkt other = Produkt.createFromName("Gräsklippare");
		
		Produkt same = (Produkt) deserialize(serialize(gräsklippare));

		assertThat(same).isEqualTo(gräsklippare)
				.isNotEqualTo(other)
				.isNotEqualTo(null)
				.isNotEqualTo(new Object());
	}


	// TODO: Get rid of throws!
	private Object deserialize(byte[] serialize) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bis = new ByteArrayInputStream(serialize);
		ObjectInput in = null;
		try {
			in = new ObjectInputStream(bis);
			Object o = in.readObject();
			return o;
		} finally {
			try {
				bis.close();
			} catch (IOException ex) {
				// ignore close exception
			}
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				// ignore close exception
			}
		}
	}

	// TODO: Get rid of throws
	private byte[] serialize(Object object) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = null;
		try {
		  out = new ObjectOutputStream(bos);   
		  out.writeObject(object);
		  byte[] serializedBytes = bos.toByteArray();
		  return serializedBytes;
		} finally {
		  try {
		    if (out != null) {
		      out.close();
		    }
		  } catch (IOException ex) {
		    // ignore close exception
		  }
		  try {
		    bos.close();
		  } catch (IOException ex) {
		    // ignore close exception
		  }
		}	}

	@Test
	public void shouldFindStoredProdukt() throws Exception {
		ProduktRepository repo = ProduktRepositoryInMem.create();
		repo.persist(gräsklippare);

		Produkt gräsklippare2 = repo.findByName("gräsklippare");

		assertThat(gräsklippare).isNotEqualTo(gräsklippare2);
	}

	@Test
	public void shouldNotFindNotStoredProdukt() throws Exception {
		ProduktRepository repo = ProduktRepositoryInMem.create();
		repo.persist(gräsklippare);

		Produkt gräsklippare2 = repo.findByName("other");

		assertThat(gräsklippare).isNotEqualTo(gräsklippare2);
	}

}
