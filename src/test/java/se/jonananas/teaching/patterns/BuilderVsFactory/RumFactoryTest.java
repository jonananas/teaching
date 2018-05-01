package se.jonananas.teaching.patterns.BuilderVsFactory;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RumFactoryTest {

    public static class Rum {
        boolean harFönster;

        // private constructor för att tvinga användandet av factory-metoden.
        private Rum(boolean harFönster) {
            this.harFönster = harFönster;
        }

        public static Rum medFönster() {
            return new Rum(true);
        }

        public static Rum utanFönster() {
            return new Rum(false);
        }
    }

    @Test
    public void bör_skapa_rum_med_fönster() {
        Rum rum = Rum.medFönster();

        assertThat(rum.harFönster).isTrue();
    }

    @Test
    public void bör_skapa_rum_utan_fönster() {
        Rum rum = Rum.utanFönster();

        assertThat(rum.harFönster).isFalse();
    }
}
