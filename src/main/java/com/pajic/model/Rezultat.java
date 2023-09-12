/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Predstavlja rezultat rada testa znanja.
 *
 * Sadrzi test znanja, korisnika koji je radio test, da li je prosao, broj ostvarenih poena i datum rada.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 */
public class Rezultat implements GenericEntity {
    /**
     * Korisnik koji je radio test.
     */
    private Korisnik korisnik;
    /**
     * Test znanja koji je radjen.
     */
    private TestZnanja testZnanja;
    /**
     * Da li je korisnik koji je radio test polozio test.
     */
    private boolean prosao;
    /**
     * Broj poena koji je korisnik ostvario na testu.
     */
    private double brojPoena;
    /**
     * Datum rada testa.
     */
    private LocalDate datumRada;

    /**
     * Neparametrizovani konstruktor za kreiranje instance rezultata.
     */
    public Rezultat() {
    }

    /**
     * Parametrizovani konstruktor za kreiranje instance rezultata.
     * @param korisnik - Vrednost koja se dodeljuje korisniku vezanim za rezultat.
     * @param testZnanja - Vrednost koja se dodeljuje testu znanja vezanim za rezultat.
     * @param prosao - Vrednost koja se dodeljuje atributu prosao.
     * @param brojPoena - Vrednost koja se dodeljuje broju ostvarenih poena.
     * @param datumRada - Vrednost koja se dodeljuje datumu rada.
     */
    public Rezultat(Korisnik korisnik, TestZnanja testZnanja, boolean prosao, double brojPoena, LocalDate datumRada) {
        setKorisnik(korisnik);
        setTestZnanja(testZnanja);
        setProsao(prosao);
        setBrojPoena(brojPoena);
        setDatumRada(datumRada);
    }

    /**
     * Vraca korisnika vezanog za rezultat.
     * @return korisnik - Korisnik vezan za rezultat.
     */
    public Korisnik getKorisnik() {
        return korisnik;
    }

    /**
     * Postavlja novu vrednost za atribut korisnik.
     * @param korisnik - Nova vrednost za atribut korisnik.
     *
     * @throws NullPointerException - ako se unese null vrednost za korisnik
     */
    public void setKorisnik(Korisnik korisnik) {
        if(korisnik == null)
            throw new NullPointerException("Korisnik vezan za rezultat ne sme biti null.");

        this.korisnik = korisnik;
    }

    /**
     * Vraca test znanja vezan za rezultat.
     * @return korisnik - Test znanja vezan za rezultat.
     */
    public TestZnanja getTestZnanja() {
        return testZnanja;
    }

    /**
     * Postavlja novu vrednost za atribut testZnanja.
     * @param testZnanja - Nova vrednost za atribut testZnanja.
     *
     * @throws NullPointerException - ako se unese null vrednost za testZnanja
     */
    public void setTestZnanja(TestZnanja testZnanja) {
        if(testZnanja == null)
            throw new NullPointerException("Test znanja vezan za rezultat ne sme biti null.");

        this.testZnanja = testZnanja;
    }

    /**
     * Vraca boolean vrednost koja pokazuje da li je korisnik prosao test ili ne.
     * @return prosao - boolean vrednost koja pokazuje da li je korisnik prosao test ili ne.
     */
    public boolean isProsao() {
        return prosao;
    }

    /**
     * Postavlja novu vrednost za atribut prosao.
     * @param prosao - Nova vrednost za atribut prosao.
     */
    public void setProsao(boolean prosao) {
        this.prosao = prosao;
    }

    /**
     * Vraca broj poena koji je korisnik ostvario na testu.
     * @return brojPoena - Broj poena koji je korisnik ostvario na testu.
     */
    public double getBrojPoena() {
        return brojPoena;
    }

    /**
     * Postavlja novu vrednost za atribut brojPoena.
     * @param brojPoena - Nova vrednost za atribut brojPoena.
     *
     * @throws IllegalArgumentException - ako se unese broj poena manji od 1
     */
    public void setBrojPoena(double brojPoena) {
        if(brojPoena < 1)
            throw new IllegalArgumentException("Broj poena ne sme biti manji od 1.");

        this.brojPoena = brojPoena;
    }

    /**
     * Vraca datum kada je korisnik radio test.
     * @return datumRada - Datum kada je korisnik radio test.
     */
    public LocalDate getDatumRada() {
        return datumRada;
    }

    /**
     * Postavlja novu vrednost za atribut datumRada.
     * @param datumRada - Nova vrednost za atribut datumRada.
     *
     * @throws NullPointerException - ako se unese null vrednost za datumRada
     */
    public void setDatumRada(LocalDate datumRada) {
        if(datumRada == null)
            throw new NullPointerException("Datum rada vezan za rezultat ne sme biti null.");

        this.datumRada = datumRada;
    }

    @Override
    public String getTableName() {
        return "rezultat";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "korisnik_id, test_znanja_id, prosao, broj_poena, datum_rada";
    }

    @Override
    public String getInsertValues() {
        return "(?,?,?,?,?)";
    }

    @Override
    public String getUpdateValues() {
        return null;
    }

    @Override
    public String getWhereCondition() {
        return "korisnik_id=" + korisnik.getId() + " AND test_znanja_id=" + testZnanja.getId();
    }

    @Override
    public GenericEntity selectObject(ResultSet rs) throws SQLException {
        Korisnik k = new Korisnik();
        TestZnanja tz = new TestZnanja();
        k.setId(rs.getLong("korisnik_id"));
        tz.setId(rs.getLong("test_znanja_id"));
        return new Rezultat(k, tz, rs.getBoolean("prosao"), rs.getDouble("broj_poena"), rs.getDate("datum_rada").toLocalDate());
    }

    @Override
    public void setId(Long id) {
    }

    @Override
    public String getWhereFilteredCondition() {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement statement, GenericEntity entity) {
        Rezultat rezultat = (Rezultat) entity;
        try {
            statement.setLong(1, rezultat.getKorisnik().getId());
            statement.setLong(2, rezultat.getTestZnanja().getId());
            statement.setBoolean(3, rezultat.isProsao());
            statement.setDouble(4, rezultat.getBrojPoena());
            statement.setDate(5, java.sql.Date.valueOf(rezultat.getDatumRada()));
        } catch (SQLException ex) {
            Logger.getLogger(Rezultat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statement;
    }
}
