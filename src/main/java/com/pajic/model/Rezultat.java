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
 *
 * @author Pavle
 */
public class Rezultat implements GenericEntity {
    private Korisnik korisnik;
    private TestZnanja testZnanja;
    private boolean prosao;
    private double brojPoena;
    private LocalDate datumRada;

    public Rezultat() {
    }

    public Rezultat(Korisnik korisnik, TestZnanja testZnanja, boolean prosao, double brojPoena, LocalDate datumRada) {
        this.korisnik = korisnik;
        this.testZnanja = testZnanja;
        this.prosao = prosao;
        this.brojPoena = brojPoena;
        this.datumRada = datumRada;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public TestZnanja getTestZnanja() {
        return testZnanja;
    }

    public void setTestZnanja(TestZnanja testZnanja) {
        this.testZnanja = testZnanja;
    }

    public boolean isProsao() {
        return prosao;
    }

    public void setProsao(boolean prosao) {
        this.prosao = prosao;
    }

    public double getBrojPoena() {
        return brojPoena;
    }

    public void setBrojPoena(double brojPoena) {
        this.brojPoena = brojPoena;
    }
    
    public LocalDate getDatumRada() {
        return datumRada;
    }

    public void setDatumRada(LocalDate datumRada) {
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
