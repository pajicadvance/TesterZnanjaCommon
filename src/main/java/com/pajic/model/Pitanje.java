/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.model;

import com.google.gson.annotations.Expose;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Predstavlja pitanje u testu znanja.
 *
 * Sadrzi ID, test znanja kome pitanje pripada, tekst pitanja, poeni koje nosi pitanje i listu odgovora na pitanje.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 */
public class Pitanje implements GenericEntity {
    /**
     * ID pitanja.
     */
    @Expose
    private long id;
    /**
     * Test znanja kome pitanje pripada.
     */
    private TestZnanja testZnanja;
    /**
     * Tekst pitanja.
     */
    @Expose
    private String tekst;
    /**
     * Poeni koje nosi pitanje.
     */
    @Expose
    private double poeni;
    /**
     * Lista odgovora na pitanje.
     */
    @Expose
    private List<Odgovor> listaOdgovora;

    /**
     * Neparametrizovani konstruktor za kreiranje instance pitanja.
     */
    public Pitanje() {
    }

    /**
     * Parametrizovani konstruktor za kreiranje instance pitanja.
     * @param id - Vrednost koja se dodeljuje ID-u pitanja.
     * @param testZnanja - Vrednost koja se dodeljuje testu znanja kome pitanje pripada.
     * @param tekst - Vrednost koja se dodeljuje tekstu pitanja.
     * @param poeni - Vrednost koja se dodeljuje poenima koje pitanje nosi.
     * @param listaOdgovora - Vrednost koja se dodeljuje listi odgovora na pitanje.
     */
    public Pitanje(long id, TestZnanja testZnanja, String tekst, double poeni, List<Odgovor> listaOdgovora) {
        setId(id);
        setTestZnanja(testZnanja);
        setTekst(tekst);
        setPoeni(poeni);
        setListaOdgovora(listaOdgovora);
    }

    /**
     * Vraca ID pitanja.
     * @return id - ID pitanja.
     */
    public long getId() {
        return id;
    }

    /**
     * Vraca test znanja kome pitanje pripada.
     * @return testZnanja - Test znanja kome pitanje pripada.
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
     * Vraca tekst pitanja.
     * @return tekst - Tekst pitanja.
     */
    public String getTekst() {
        return tekst;
    }

    /**
     * Postavlja novu vrednost za atribut tekst.
     * @param tekst - Nova vrednost za atribut tekst.
     *
     * @throws NullPointerException - ako se unese null vrednost za tekst
     * @throws IllegalArgumentException - ako je tekst prazan String
     */
    public void setTekst(String tekst) {
        if(tekst == null)
            throw new NullPointerException("Tekst pitanja ne sme biti null.");

        if(tekst.isEmpty())
            throw new IllegalArgumentException("Tekst pitanja ne sme biti prazan String.");

        this.tekst = tekst;
    }

    /**
     * Vraca poene koje pitanje nosi.
     * @return poeni - Poeni koje pitanje nosi.
     */
    public double getPoeni() {
        return poeni;
    }

    /**
     * Postavlja novu vrednost za atribut poeni.
     * @param poeni - Nova vrednost za atribut poeni.
     *
     * @throws IllegalArgumentException - ako se unesu poeni manji od 1
     */
    public void setPoeni(double poeni) {
        if(poeni < 1)
            throw new IllegalArgumentException("Poeni ne smeju biti manji od 1.");

        this.poeni = poeni;
    }

    /**
     * Vraca listu odgovora na pitanje.
     * @return listaOdgovora - Lista odgovora na pitanje.
     */
    public List<Odgovor> getListaOdgovora() {
        return listaOdgovora;
    }

    /**
     * Postavlja novu vrednost za atribut listaOdgovora.
     * @param listaOdgovora - Nova vrednost za atribut listaOdgovora.
     */
    public void setListaOdgovora(List<Odgovor> listaOdgovora) {
        this.listaOdgovora = listaOdgovora;
    }

    @Override
    public String getTableName() {
        return "pitanje";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id, test_znanja_id, tekst, poeni";
    }

    @Override
    public String getInsertValues() {
        return "(?,?,?,?)";
    }

    @Override
    public String getUpdateValues() {
        return  "test_znanja_id=" + testZnanja.getId() + ", "
                + "tekst='" + tekst + "', "
                + "poeni=" + poeni + ", ";
    }

    @Override
    public String getWhereCondition() {
        return "id=" + id;
    }

    @Override
    public GenericEntity selectObject(ResultSet rs) throws SQLException {
        TestZnanja tz = new TestZnanja();
        tz.setId(rs.getLong("test_znanja_id"));
        return new Pitanje(rs.getLong("id"), tz, rs.getString("tekst"), rs.getDouble("poeni"), null);
    }

    @Override
    public void setId(Long id) {
        if(id == null)
            throw new NullPointerException("ID vrednost ne sme biti null.");

        if(id < 1)
            throw new IllegalArgumentException("ID vrednost ne sme biti manja od 1.");

        this.id = id;
    }

    @Override
    public String getWhereFilteredCondition() {
        return "test_znanja_id=";
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement statement, GenericEntity entity) {
        Pitanje pitanje = (Pitanje) entity;
        try {
            statement.setLong(1, pitanje.getId());
            statement.setLong(2, pitanje.getTestZnanja().getId());
            statement.setString(3, pitanje.getTekst());
            statement.setDouble(4, pitanje.getPoeni());
        } catch (SQLException ex) {
            Logger.getLogger(Pitanje.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statement;
    }
    
}
