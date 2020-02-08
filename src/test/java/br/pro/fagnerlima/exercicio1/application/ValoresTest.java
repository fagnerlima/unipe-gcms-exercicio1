package br.pro.fagnerlima.exercicio1.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValoresTest {

    private Valores valores;

    @BeforeEach
    public void setUp() throws Exception {
        valores = new Valores();
    }

    @Test
    public void testIns() {
        assertThat(valores.ins(1)).isTrue();
        assertThat(valores.ins(10)).isTrue();
    }
    
    @Test
    public void testIns_whenNaoPositivo() {
        assertThat(valores.ins(0)).isFalse();
        assertThat(valores.ins(-1)).isFalse();
    }

    @Test
    public void testIns_whenLimiteAtingido() {
        for (int i = 1; i <= 10; i++) {
            assertThat(valores.ins(i)).isTrue();
        }

        assertThat(valores.ins(11)).isFalse();
    }

    @Test
    public void testDel() {
        valores.ins(10);
        valores.ins(15);
        valores.ins(20);

        assertThat(valores.del(0)).isEqualTo(10);
        assertThat(valores.del(2)).isEqualTo(20);
    }

    @Test
    public void testDel_whenSizeZero() {
        assertThat(valores.del(0)).isEqualTo(-1);
    }

    @Test
    public void testDel_whenNotFound() {
        valores.ins(10);

        assertThat(valores.del(1)).isEqualTo(-1);
    }

    @Test
    public void testDel_whenArrayIndexOutOfBounds() {
        valores.ins(10);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> valores.del(11));
    }

    @Test
    public void testSize() {
        valores.ins(10);
        valores.ins(15);
        valores.ins(20);

        assertThat(valores.size()).isEqualTo(3);
    }

    @Test
    public void testSize_whenDelete() {
        valores.ins(10);
        valores.ins(15);
        valores.ins(20);
        valores.del(1);

        assertThat(valores.size()).isEqualTo(2);
    }

}
