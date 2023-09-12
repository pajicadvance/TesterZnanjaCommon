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
public class TestZnanja implements GenericEntity {
    private long id;
    private String naziv;
    private double poeniZaProlaz;
    private List<Pitanje> listaPitanja;
    private TipTestaZnanja tipTestaZnanja;

    public TestZnanja() {
    }

    public TestZnanja(long id, String naziv, double poeniZaProlaz, List<Pitanje> listaPitanja, TipTestaZnanja tipTestaZnanja) {
        this.id = id;
        this.naziv = naziv;
        this.poeniZaProlaz = poeniZaProlaz;
        this.listaPitanja = listaPitanja;
        this.tipTestaZnanja = tipTestaZnanja;
    }

    public TipTestaZnanja getTipTestaZnanja() {
        return tipTestaZnanja;
    }

    public void setTipTestaZnanja(TipTestaZnanja tipTestaZnanja) {
        this.tipTestaZnanja = tipTestaZnanja;
    }

    public long getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getPoeniZaProlaz() {
        return poeniZaProlaz;
    }

    public void setPoeniZaProlaz(double poeniZaProlaz) {
        this.poeniZaProlaz = poeniZaProlaz;
    }

    public List<Pitanje> getListaPitanja() {
        return listaPitanja;
    }

    public void setListaPitanja(List<Pitanje> listaPitanja) {
        this.listaPitanja = listaPitanja;
    }

    @Override
    public String getTableName() {
        return "test_znanja";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id, naziv, poeni_za_prolaz, tip_testa_znanja_id";
    }

    @Override
    public String getInsertValues() {
        return "(?,?,?,?)";
    }

    @Override
    public String getUpdateValues() {
        return    "naziv='" + naziv + "', "
                + "poeni_za_prolaz=" + poeniZaProlaz + ", "
                + "tip_testa_znanja_id" + tipTestaZnanja.getId();
    }

    @Override
    public String getWhereCondition() {
        return "id=" + id;
    }

    @Override
    public GenericEntity selectObject(ResultSet rs) throws SQLException {
        return new TestZnanja(rs.getLong("id"), rs.getString("naziv"), rs.getDouble("poeni_za_prolaz"), null, null);
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getWhereFilteredCondition() {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement statement, GenericEntity entity) {
        TestZnanja testZnanja = (TestZnanja) entity;
        try {
            statement.setLong(1, testZnanja.getId());
            statement.setString(2, testZnanja.getNaziv());
            statement.setDouble(3, testZnanja.getPoeniZaProlaz());
            statement.setLong(4, testZnanja.getTipTestaZnanja().getId());
        } catch (SQLException ex) {
            Logger.getLogger(TestZnanja.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statement;
    }

    @Override
    public String toString() {
        return "TestZnanja{" + "id=" + id + ", naziv=" + naziv + ", poeniZaProlaz=" + poeniZaProlaz + ", listaPitanja=" + listaPitanja + ", tipTestaZnanja=" + tipTestaZnanja + '}';
    }

}
