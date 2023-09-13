package com.pajic.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TipTestaZnanjaTest {

    private TipTestaZnanja obj;

    @BeforeEach
    void setUp() {
        obj = new TipTestaZnanja();
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
    void testToString() {
        obj.setNaziv("naziv");
        Assertions.assertEquals("naziv", obj.toString());
    }
}
