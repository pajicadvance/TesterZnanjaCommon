/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pavle
 */
public class Pitanje implements GenericEntity {
    private long id;
    private TestZnanja testZnanja;
    private String tekst;
    private double poeni;
    private List<Odgovor> listaOdgovora;

    public Pitanje() {
    }

    public Pitanje(long id, TestZnanja testZnanja, String tekst, double poeni, List<Odgovor> listaOdgovora) {
        this.id = id;
        this.testZnanja = testZnanja;
        this.tekst = tekst;
        this.poeni = poeni;
        this.listaOdgovora = listaOdgovora;
    }

    public long getId() {
        return id;
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

    public double getPoeni() {
        return poeni;
    }

    public void setPoeni(double poeni) {
        this.poeni = poeni;
    }

    public List<Odgovor> getListaOdgovora() {
        return listaOdgovora;
    }

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

    @Override
    public String toString() {
        return "    Pitanje{" + "id=" + id + ", testZnanja=" + testZnanja + ", tekst=" + tekst + ", poeni=" + poeni + '}';
    }
    
}
