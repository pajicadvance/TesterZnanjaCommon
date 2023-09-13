package com.pajic.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PitanjeTest {

    private Pitanje obj;

    @BeforeEach
    void setUp() {
        obj = new Pitanje();
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
    void testSetPoeni() {
        obj.setPoeni(10);
        Assertions.assertEquals(10, obj.getPoeni());
    }

    @Test
    void testSetPoeniLessThan1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> obj.setPoeni(0));
    }

    @Test
    void testSetListaOdgovora() {
        List<Odgovor> odgovori = new ArrayList<>();
        odgovori.add(new Odgovor());
        obj.setListaOdgovora(odgovori);
        Assertions.assertEquals(odgovori, obj.getListaOdgovora());
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
}
