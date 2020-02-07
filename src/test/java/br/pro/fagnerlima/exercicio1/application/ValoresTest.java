package br.pro.fagnerlima.exercicio1.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ValoresTest {

    private Valores valores;

    @Before
    public void setUp() throws Exception {
        valores = new Valores();
    }

    @Test
    public void testIns() {
        assertTrue(valores.ins(1));
        assertTrue(valores.ins(10));
    }

    @Test
    public void testIns_whenZero() {
        assertFalse(valores.ins(0));
    }

    @Test
    public void testIns_whenNegativo() {
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
