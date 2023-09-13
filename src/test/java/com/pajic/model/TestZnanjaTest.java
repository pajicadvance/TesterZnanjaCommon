package com.pajic.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestZnanjaTest {

    private TestZnanja obj;

    @BeforeEach
    void setUp() {
        obj = new TestZnanja();
    }

    @AfterEach
    void tearDown() {
        obj = null;
    }

    @Test
    void testSetId() {
        obj.setId(1L);
        Assertions.assertEquals(1, obj.getId());
    }

    @Test
    void testSetIdNull() {
        Assertions.assertThrows(NullPointerException.class, () -> obj.setId(null));
    }

    @Test
    void testSetIdLessThan1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> obj.setId(0L));
    }

    @Test
    void testSetNaziv() {
        obj.setNaziv("naziv");
        Assertions.assertEquals("naziv", obj.getNaziv());
    }

    @Test
    void testSetNazivNull() {
        Assertions.assertThrows(NullPointerException.class, () -> obj.setNaziv(null));
    }

    @Test
    void testSetNazivEmptyString() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> obj.setNaziv(""));
    }

    @Test
    void testSetPoeniZaProlaz() {
        obj.setPoeniZaProlaz(10);
        Assertions.assertEquals(10, obj.getPoeniZaProlaz());
    }

    @Test
    void testSetPoeniZaProlazLessThan0() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> obj.setPoeniZaProlaz(-1));
    }

    @Test
    void testSetListaPitanja() {
        List<Pitanje> pitanja = new ArrayList<>();
        pitanja.add(new Pitanje());
        obj.setListaPitanja(pitanja);
        Assertions.assertEquals(pitanja, obj.getListaPitanja());
    }

    @Test
    void testSetTipTestaZnanja() {
        TipTestaZnanja tip = new TipTestaZnanja();
        tip.setId(1L);
        tip.setNaziv("Kviz");
        obj.setTipTestaZnanja(tip);
        Assertions.assertEquals(tip, obj.getTipTestaZnanja());
    }
}
