package br.pro.fagnerlima.exercicio1.application;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(valores.ins(1));
        assertTrue(valores.ins(10));
    }
    
    @Test
    public void testIns_whenNaoPositivo() {
        assertFalse(valores.ins(0));
        assertFalse(valores.ins(-1));
    }

    @Test
    public void testIns_whenLimiteAtingido() {
        for (int i = 1; i <= 10; i++) {
            assertTrue(valores.ins(i));
        }

        assertFalse(valores.ins(11));
    }

    @Test
    public void testDel() {
        valores.ins(10);
        valores.ins(15);
        valores.ins(20);

        assertEquals(valores.del(0), 10);
        assertEquals(valores.del(2), 20);
    }

    @Test
    public void testDel_whenSizeZero() {
        assertEquals(valores.del(0), -1);
    }

    @Test
    public void testDel_whenNotFound() {
        valores.ins(10);

        assertEquals(valores.del(1), -1);
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

        assertEquals(valores.size(), 3);
    }

    @Test
    public void testSize_whenDelete() {
        valores.ins(10);
        valores.ins(15);
        valores.ins(20);
        valores.del(1);

        assertEquals(valores.size(), 2);
    }

}
