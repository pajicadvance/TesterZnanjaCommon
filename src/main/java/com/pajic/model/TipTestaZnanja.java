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
 * @author pajic
 */
public class TipTestaZnanja implements GenericEntity {
    
    private long id;
    private String naziv;

    public TipTestaZnanja(long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String nazivTipa) {
        this.naziv = nazivTipa;
    }

    @Override
    public String getTableName() {
        return "tip_testa_znanja";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id, naziv";
    }

    @Override
    public String getInsertValues() {
        return "(?,?)";
    }

    @Override
    public String getUpdateValues() {
        return "naziv='" + naziv + "'";
    }

    @Override
    public String getWhereCondition() {
        return "id=" + id;
    }

    @Override
    public String getWhereFilteredCondition() {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement statement, GenericEntity entity) {
        TipTestaZnanja tipTestaZnanja = (TipTestaZnanja) entity;
        try {
            statement.setLong(1, tipTestaZnanja.getId());
            statement.setString(2, tipTestaZnanja.getNaziv());
        } catch (SQLException ex) {
            Logger.getLogger(TipTestaZnanja.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statement;
    }

    @Override
    public GenericEntity selectObject(ResultSet rs) throws SQLException {
        return new TipTestaZnanja(rs.getLong("id"), rs.getString("naziv"));
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
}
