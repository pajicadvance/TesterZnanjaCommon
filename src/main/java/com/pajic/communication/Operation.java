/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.pajic.communication;

import java.io.Serializable;

/**
 * Predstavlja enumeraciju koja opisuje koje su sve moguce operacije u okviru aplikacije.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public enum Operation implements Serializable {
    /**
     * Prijavljuje korisnika na sistem.
     */
    LOGIN,
    /**
     * Vraca sve testove znanja iz baze podataka.
     */
    GET_ALL_TEST_ZNANJA,
    /**
     * Dodaje test znanja u bazu podataka.
     */
    ADD_TEST_ZNANJA,
    /**
     * Brise test znanja iz baze podataka.
     */
    DELETE_TEST_ZNANJA,
    /**
     * Pretrazuje testove znanja iz baze podataka prema zadatom parametru i vraca ih.
     */
    FIND_TEST_ZNANJA,
    /**
     * Vraca sve urednike iz baze podataka.
     */
    GET_ALL_UREDNIK,
    /**
     * Vraca sve urednike sa specificiranim ID-jem iz baze podataka.
     */
    GET_ALL_UREDNIK_FILTERED,
    /**
     * Dodaje urednika u bazu podataka..
     */
    ADD_UREDNIK,
    /**
     * Brise urednika iz baze podataka.
     */
    DELETE_UREDNIK,
    /**
     * Pretrazuje urednike iz baze podataka prema zadatom parametru i vraca ih.
     */
    FIND_UREDNIK,
    /**
     * Dodaje rezultat u bazu podataka.
     */
    ADD_REZULTAT,
    /**
     * Pretrazuje rezultate iz baze podataka prema zadatom parametru i vraca ih.
     */
    FIND_REZULTAT,
    /**
     * Dodaje korisnika u bazu podataka.
     */
    ADD_KORISNIK
}
