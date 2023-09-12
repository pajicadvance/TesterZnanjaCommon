/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.model;

import java.time.LocalDate;

/**
 * Predstavlja genericku klasu korisnika sistema.
 *
 * Sadrzi ID, ime, prezime, datum rodjenja, korisnicko ime i lozinku.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 */
public abstract class GenericUser implements GenericEntity {
    /**
     * ID generickog korisnika.
     */
    protected long id;
    /**
     * Ime generickog korisnika.
     */
    protected String ime;
    /**
     * Prezime generickog korisnika.
     */
    protected String prezime;
    /**
     * Datum rodjenja generickog korisnika.
     */
    protected LocalDate datumRodjenja;
    /**
     * Korisnicko ime generickog korisnika.
     */
    protected String username;
    /**
     * Lozinka generickog korisnika.
     */
    protected String password;

    /**
     * Neparametrizovani konstruktor za kreiranje instance generickog korisnika.
     */
    public GenericUser() {
    }

    /**
     * Parametrizovani konstruktor za kreiranje instance generickog korisnika.
     * @param id - Vrednost koja se dodeljuje ID-u generickog korisnika.
     * @param ime - Vrednost koja se dodeljuje imenu generickog korisnika.
     * @param prezime - Vrednost koja se dodeljuje prezimenu generickog korisnika.
     * @param datumRodjenja - Vrednost koja se dodeljuje datumu rodjenja generickog korisnika.
     * @param username - Vrednost koja se dodeljuje korisnickom imenu generickog korisnika.
     * @param password - Vrednost koja se dodeljuje lozinki generickog korisnika.
     */
    public GenericUser(long id, String ime, String prezime, LocalDate datumRodjenja, String username, String password) {
        setId(id);
        setIme(ime);
        setPrezime(prezime);
        setDatumRodjenja(datumRodjenja);
        setUsername(username);
        setPassword(password);
    }

    /**
     * Vraca ID generickog korisnika.
     * @return id - ID generickog korisnika.
     */
    public long getId() {
        return id;
    }

    /**
     * Vraca ime generickog korisnika.
     * @return ime - Ime generickog korisnika.
     */
    public String getIme() {
        return ime;
    }

    /**
     *
     * Postavlja novu vrednost za atribut ime generickog korisnika.
     * @param ime - Nova vrednost za atribut ime.
     *
     * @throws NullPointerException - ako se unese null vrednost za ime
     * @throws IllegalArgumentException - ako je ime prazan String
     */
    public void setIme(String ime) {
        if(ime == null)
            throw new NullPointerException("Ime generickog korisnika ne sme biti null.");

        if(ime.isEmpty())
            throw new IllegalArgumentException("Ime generickog korisnika ne sme biti prazan String.");

        this.ime = ime;
    }

    /**
     * Vraca prezime generickog korisnika.
     * @return prezime - Prezime generickog korisnika.
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     *
     * Postavlja novu vrednost za atribut prezime generickog korisnika.
     * @param prezime - Nova vrednost za atribut prezime.
     *
     * @throws NullPointerException - ako se unese null vrednost za prezime
     * @throws IllegalArgumentException - ako je prezime prazan String
     */
    public void setPrezime(String prezime) {
        if(prezime == null)
            throw new NullPointerException("Prezime generickog korisnika ne sme biti null.");

        if(prezime.isEmpty())
            throw new IllegalArgumentException("Prezime generickog korisnika ne sme biti prazan String.");

        this.prezime = prezime;
    }

    /**
     * Vraca datum rodjenja generickog korisnika.
     * @return datumRodjenja - Datum rodjenja generickog korisnika.
     */
    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    /**
     * Postavlje novu vrednost za atribut datumRodjenja servisa.
     * @param datumRodjenja - Nova vrednost za atribut datumRodjenja.
     *
     * @throws NullPointerException - ako se unese null vrednost za datumRodjenja
     */
    public void setDatumRodjenja(LocalDate datumRodjenja) {
        if(datumRodjenja == null)
            throw new NullPointerException("Datum rodjenja ne sme biti null.");

        this.datumRodjenja = datumRodjenja;
    }

    /**
     * Vraca korisnicko ime generickog korisnika.
     * @return username - Korisnicko ime generickog korisnika.
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * Postavlja novu vrednost za atribut username generickog korisnika.
     * @param username - Nova vrednost za atribut username.
     *
     * @throws NullPointerException - ako se unese null vrednost za username
     * @throws IllegalArgumentException - ako je username prazan String
     */
    public void setUsername(String username) {
        if(username == null)
            throw new NullPointerException("Korisnicko ime generickog korisnika ne sme biti null.");

        if(username.isEmpty())
            throw new IllegalArgumentException("Korisnicko ime generickog korisnika ne sme biti prazan String.");

        this.username = username;
    }

    /**
     * Vraca lozinku generickog korisnika.
     * @return username - Lozinka generickog korisnika.
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * Postavlja novu vrednost za atribut password generickog korisnika.
     * @param password - Nova vrednost za atribut password.
     *
     * @throws NullPointerException - ako se unese null vrednost za password
     * @throws IllegalArgumentException - ako je password prazan String
     */
    public void setPassword(String password) {
        if(password == null)
            throw new NullPointerException("Lozinka generickog korisnika ne sme biti null.");

        if(password.isEmpty())
            throw new IllegalArgumentException("Lozinka generickog korisnika ne sme biti prazan String.");

        this.password = password;
    }

    @Override
    public abstract String getTableName();

    @Override
    public abstract String getColumnNamesForInsert();

    @Override
    public abstract String getInsertValues();

    @Override
    public abstract String getUpdateValues();

    @Override
    public abstract String getWhereCondition();
    
    @Override
    public void setId(Long id) {
        if(id == null)
            throw new NullPointerException("ID vrednost ne sme biti null.");

        if(id < 1)
            throw new IllegalArgumentException("ID vrednost ne sme biti manja od 1.");

        this.id = id;
    }

}
