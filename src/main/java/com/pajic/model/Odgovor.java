/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Predstavlja odgovor u pitanju.
 *
 * Sadrzi ID, pitanje kome odgovor pripada, test znanja kome odgovor pripada, tekst odgovora i da li je odgovor tacan.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 */
public class Odgovor implements GenericEntity {
    /**
     * ID odgovora.
     */
    private long id;
    /**
     * Pitanje kome odgovor pripada.
     */
    private Pitanje pitanje;
    /**
     * Test znanja kome odgovor pripada.
     */
    private TestZnanja testZnanja;
    /**
     * Tekst odgovora.
     */
    private String tekst;
    /**
     * Da li je odgovor tacan.
     */
    private boolean tacan;

    /**
     * Neparametrizovani konstruktor za kreiranje instance odgovora.
     */
    public Odgovor() {
    }

    /**
     * Parametrizovani konstruktor za kreiranje instance odgovora.
     * @param id - Vrednost koja se dodeljuje ID-u odgovora.
     * @param pitanje - Vrednost koja se dodeljuje pitanju kome odgovor pripada.
     * @param testZnanja - Vrednost koja se dodeljuje testu znanja kome odgovor pripada.
     * @param tekst - Vrednost koja se dodeljuje tekstu odgovora.
     * @param tacan - Vrednost koja se dodeljuje atributu tacan.
     */
    public Odgovor(long id, Pitanje pitanje, TestZnanja testZnanja, String tekst, boolean tacan) {
        setId(id);
        setPitanje(pitanje);
        setTestZnanja(testZnanja);
        setTekst(tekst);
        setTacan(tacan);
    }

    /**
     * Vraca ID odgovora.
     * @return id - ID odgovora.
     */
    public long getId() {
        return id;
    }

    /**
     * Vraca pitanje kome odgovor pripada.
     * @return pitanje - Pitanje kome odgovor pripada.
     */
    public Pitanje getPitanje() {
        return pitanje;
    }

    /**
     * Postavlje novu vrednost za atribut pitanje.
     * @param pitanje - Nova vrednost za atribut pitanje.
     *
     * @throws NullPointerException - ako se unese null vrednost za pitanje
     */
    public void setPitanje(Pitanje pitanje) {
        if(pitanje == null)
            throw new NullPointerException("Pitanje ne sme biti null.");

        this.pitanje = pitanje;
    }

    /**
     * Vraca test znanja kome odgovor pripada.
     * @return testZnanja - Test znanja kome odgovor pripada.
     */
    public TestZnanja getTestZnanja() {
        return testZnanja;
    }

    /**
     * Postavlje novu vrednost za atribut testZnanja.
     * @param testZnanja - Nova vrednost za atribut testZnanja.
     *
     * @throws NullPointerException - ako se unese null vrednost za testZnanja
     */
    public void setTestZnanja(TestZnanja testZnanja) {
        if(testZnanja == null)
            throw new NullPointerException("Test znanja ne sme biti null.");

        this.testZnanja = testZnanja;
    }

    /**
     * Vraca tekst odgovora.
     * @return tekst - Tekst odgovora.
     */
    public String getTekst() {
        return tekst;
    }

    /**
     * Postavlje novu vrednost za atribut tekst.
     * @param tekst - Nova vrednost za atribut tekst.
     *
     * @throws NullPointerException - ako se unese null vrednost za tekst
     * @throws IllegalArgumentException - ako je tekst prazan String
     */
    public void setTekst(String tekst) {
        if(tekst == null)
            throw new NullPointerException("Tekst odgovora ne sme biti null.");

        if(tekst.isEmpty())
            throw new IllegalArgumentException("Tekst odgovora ne sme biti prazan String.");

        this.tekst = tekst;
    }

    /**
     * Vraca da li je odgovor tacan.
     * @return tacan - Da li je odgovor tacan.
     */
    public boolean isTacan() {
        return tacan;
    }

    /**
     * Postavlja novu vrednost za atribut tacan.
     * @param tacan - Nova vrednost za atribut tacan.
     */
    public void setTacan(boolean tacan) {
        this.tacan = tacan;
    }

    @Override
    public String getTableName() {
        return "odgovor";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id, pitanje_id, test_znanja_id, tekst, tacan";
    }

    @Override
    public String getInsertValues() {
        return "(?,?,?,?,?)";
    }

    @Override
    public String getUpdateValues() {
        return    "pitanje_id=" + pitanje.getId() + ", "
                + "test_znanja_id=" + testZnanja.getId() + ", "
                + "tekst='" + tekst + "', "
                + "tacan=" + tacan;
    }

    @Override
    public String getWhereCondition() {
        return "id=" + id;
    }

    @Override
    public GenericEntity selectObject(ResultSet rs) throws SQLException {
        Pitanje p = new Pitanje();
        TestZnanja tz = new TestZnanja();
        p.setId(rs.getLong("pitanje_id"));
        tz.setId(rs.getLong("test_znanja_id"));
        return new Odgovor(rs.getLong("id"), p, tz, rs.getString("tekst"), rs.getBoolean("tacan"));
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getWhereFilteredCondition() {
        return "pitanje_id=";
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement statement, GenericEntity entity) {
        Odgovor odgovor = (Odgovor) entity;
        try {
            statement.setLong(1, odgovor.getId());
            statement.setLong(2, odgovor.getPitanje().getId());
            statement.setLong(3, odgovor.getTestZnanja().getId());
            statement.setString(4, odgovor.getTekst());
            statement.setBoolean(5, odgovor.isTacan());
        } catch (SQLException ex) {
            Logger.getLogger(Odgovor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statement;
    }

    @Override
    public String toString() {
        return "        Odgovor{" + "id=" + id + ", pitanje=" + pitanje + ", testZnanja=" + testZnanja + ", tekst=" + tekst + ", tacan=" + tacan + '}';
    }
    
}
