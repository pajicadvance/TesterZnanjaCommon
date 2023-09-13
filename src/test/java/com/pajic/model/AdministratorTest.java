package com.pajic.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AdministratorTest {

    private Administrator obj;

    @BeforeEach
    void setUp() {
        obj = new Administrator();
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
    void testSetIme() {
        obj.setIme("ime");
        Assertions.assertEquals("ime", obj.getIme());
    }

    @Test
    void testSetImeNull() {
        Assertions.assertThrows(NullPointerException.class, () -> obj.setIme(null));
    }

    @Test
    void testSetImeEmptyString() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> obj.setIme(""));
    }

    @Test
    void testSetPrezime() {
        obj.setPrezime("prezime");
        Assertions.assertEquals("prezime", obj.getPrezime());
    }

    @Test
    void testSetPrezimeNull() {
        Assertions.assertThrows(NullPointerException.class, () -> obj.setPrezime(null));
    }

    @Test
    void testSetPrezimeEmptyString() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> obj.setPrezime(""));
    }

    @Test
    void testSetUsername() {
        obj.setUsername("username");
        Assertions.assertEquals("username", obj.getUsername());
    }

    @Test
    void testSetUsernameNull() {
        Assertions.assertThrows(NullPointerException.class, () -> obj.setUsername(null));
    }

    @Test
    void testSetUsernameEmptyString() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> obj.setUsername(""));
    }

    @Test
    void testSetPassword() {
        obj.setPassword("password");
        Assertions.assertEquals("password", obj.getPassword());
    }

    @Test
    void testSetPasswordNull() {
        Assertions.assertThrows(NullPointerException.class, () -> obj.setPassword(null));
    }

    @Test
    void testSetPasswordEmptyString() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> obj.setPassword(""));
    }

    @Test
    void testSetDatumRodjenja() {
        obj.setDatumRodjenja(LocalDate.of(2020, 1, 8));
        Assertions.assertEquals(LocalDate.of(2020, 1, 8), obj.getDatumRodjenja());
    }

    @Test
    void testSetDatumRodjenjaNull() {
        Assertions.assertThrows(NullPointerException.class, () -> obj.setDatumRodjenja(null));
    }
}
