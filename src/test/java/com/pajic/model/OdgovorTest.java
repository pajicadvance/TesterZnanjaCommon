package com.pajic.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class OdgovorTest {

    private Odgovor obj;

    @BeforeEach
    void setUp() {
        obj = new Odgovor();
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
    void testSetTekst() {
        obj.setTekst("tekst");
        Assertions.assertEquals("tekst", obj.getTekst());
    }

    @Test
    void testSetTekstNull() {
        Assertions.assertThrows(NullPointerException.class, () -> obj.setTekst(null));
    }

    @Test
    void testSetTekstEmptyString() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> obj.setTekst(""));
    }

    @Test
    void testSetTacan() {
        obj.setTacan(true);
        Assertions.assertTrue(obj.isTacan());
    }

    @Test
    void testSetTestZnanja() {
        TestZnanja testZnanja = new TestZnanja();
        testZnanja.setId(1001L);
        testZnanja.setNaziv("TestTest");
        testZnanja.setPoeniZaProlaz(10);
        testZnanja.setTipTestaZnanja(new TipTestaZnanja(1L, "Kviz"));
        testZnanja.setListaPitanja(new ArrayList<>());
        obj.setTestZnanja(testZnanja);
        Assertions.assertEquals(testZnanja, obj.getTestZnanja());
    }

    @Test
    void testSetTestZnanjaNull() {
        Assertions.assertThrows(NullPointerException.class, () -> obj.setTestZnanja(null));
    }

    @Test
    void testSetPitanje() {
        Pitanje pitanje = new Pitanje();
        pitanje.setId(1L);
        pitanje.setPoeni(10);
        pitanje.setListaOdgovora(new ArrayList<>());
        pitanje.setTekst("tekst");
        pitanje.setTestZnanja(new TestZnanja());
        obj.setPitanje(pitanje);
        Assertions.assertEquals(pitanje, obj.getPitanje());
    }
}
