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
 *
 * @author Pavle
 */
public class Odgovor implements GenericEntity {
    private long id;
    private Pitanje pitanje;
    private TestZnanja testZnanja;
    private String tekst;
    private boolean tacan;

    public Odgovor() {
    }

    public Odgovor(long id, Pitanje pitanje, TestZnanja testZnanja, String tekst, boolean tacan) {
        this.id = id;
        this.pitanje = pitanje;
        this.testZnanja = testZnanja;
        this.tekst = tekst;
        this.tacan = tacan;
    }

    public long getId() {
        return id;
    }

    public Pitanje getPitanje() {
        return pitanje;
    }

    public void setPitanje(Pitanje pitanje) {
        this.pitanje = pitanje;
    }

    public TestZnanja getTestZnanja() {
        return testZnanja;
    }

    public void setTestZnanja(TestZnanja testZnanja) {
        this.testZnanja = testZnanja;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public boolean isTacan() {
        return tacan;
    }

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
