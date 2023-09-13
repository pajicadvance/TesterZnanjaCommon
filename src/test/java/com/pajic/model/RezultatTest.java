package com.pajic.model;

import com.pajic.crypto.BCryptManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class RezultatTest {

    private Rezultat obj;

    @BeforeEach
    void setUp() {
        obj = new Rezultat();
    }

    @AfterEach
    void tearDown() {
        obj = null;
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
    void testSetKorisnik() {
        Korisnik korisnik = new Korisnik();
        korisnik.setId(1000L);
        korisnik.setIme("TestIme");
        korisnik.setPrezime("TestPrezime");
        korisnik.setUsername("testuser");
        korisnik.setPassword(BCryptManager.passwordToHash("testpass"));
        korisnik.setDatumRodjenja(LocalDate.of(2020, 1, 8));
        obj.setKorisnik(korisnik);
        Assertions.assertEquals(korisnik, obj.getKorisnik());
    }

    @Test
    void testSetKorisnikNull() {
        Assertions.assertThrows(NullPointerException.class, () -> obj.setKorisnik(null));
    }

    @Test
    void testSetProsao() {
        obj.setProsao(true);
        Assertions.assertTrue(obj.isProsao());
    }

    @Test
    void testSetBrojPoena() {
        obj.setBrojPoena(10);
        Assertions.assertEquals(10, obj.getBrojPoena());
    }

    @Test
    void testSetBrojPoenaLessThan1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> obj.setBrojPoena(0));
    }

    @Test
    void testSetDatumRada() {
        obj.setDatumRada(LocalDate.of(2020, 1, 8));
        Assertions.assertEquals(LocalDate.of(2020, 1, 8), obj.getDatumRada());
    }

    @Test
    void testSetDatumRadaNull() {
        Assertions.assertThrows(NullPointerException.class, () -> obj.setDatumRada(null));
    }
}
