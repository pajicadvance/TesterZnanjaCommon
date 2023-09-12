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
 * Predstavlja tip testa znanja.
 *
 * Sadrzi ID i naziv.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 */
public class TipTestaZnanja implements GenericEntity {
    /**
     * ID tipa testa znanja.
     */
    private long id;
    /**
     * Naziv tipa testa znanja.
     */
    private String naziv;

    /**
     * Parametrizovani konstruktor kreiranje instance tipa testa znanja.
     * @param id - Vrednost koja se dodeljuje ID-u tipa testa znanja.
     * @param naziv - Vrednost koja se dodeljuje nazivu tipa testa znanja.
     */
    public TipTestaZnanja(long id, String naziv) {
        setId(id);
        setNaziv(naziv);
    }

    /**
     * Vraca ID tipa testa znanja.
     * @return id - ID tipa testa znanja.
     */
    public long getId() {
        return id;
    }

    /**
     * Vraca naziv tipa testa znanja.
     * @return naziv - Naziv tipa testa znanja.
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     *
     * Postavlja novu vrednost za atribut naziv.
     * @param naziv - Nova vrednost za atribut naziv.
     *
     * @throws NullPointerException - ako se unese null vrednost za naziv
     * @throws IllegalArgumentException - ako je naziv prazan String
     */
    public void setNaziv(String naziv) {
        if(naziv == null)
            throw new NullPointerException("Naziv tipa testa znanja ne sme biti null.");

        if(naziv.isEmpty())
            throw new IllegalArgumentException("Naziv tipa testa znanja ne sme biti prazan String.");

        this.naziv = naziv;
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
        if(id == null)
            throw new NullPointerException("ID vrednost ne sme biti null.");

        if(id < 1)
            throw new IllegalArgumentException("ID vrednost ne sme biti manja od 1.");

        this.id = id;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
}
