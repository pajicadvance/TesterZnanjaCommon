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
 * Predstavlja administratora u sistemu.
 *
 * Nasledjuje generickog korisnika.
 *
 * @author Pavle
 */
public class Administrator extends GenericUser {

    /**
     * Neparametrizovani konstruktor za kreiranje instance administratora.
     */
    public Administrator() {
    }

    /**
     * Parametrizovani konstruktor za kreiranje instance administratora.
     * @param id - Vrednost koja se dodeljuje ID-u administratora.
     * @param ime - Vrednost koja se dodeljuje imenu administratora.
     * @param prezime - Vrednost koja se dodeljuje prezimenu administratora.
     * @param datumRodjenja - Vrednost koja se dodeljuje datumu rodjenja administratora.
     * @param username - Vrednost koja se dodeljuje korisnickom imenu administratora.
     * @param password - Vrednost koja se dodeljuje lozinki administratora.
     */
    public Administrator(long id, String ime, String prezime, LocalDate datumRodjenja, String username, String password) {
        super(id, ime, prezime, datumRodjenja, username, password);
    }
    
    @Override
    public String getTableName() {
        return "administrator";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id, ime, prezime, datum_rodjenja, username, password";
    }

    @Override
    public String getInsertValues() {
        return "(?,?,?,?,?,?)";
    }

    @Override
    public String getUpdateValues() {
        return    "ime='" + ime + "', "
                + "prezime='" + prezime + "', "
                + "datum_rodjenja=" + datumRodjenja + ","
                + "username='" + username + "',"
                + "password='" + password + "' ";
    }

    @Override
    public String getWhereCondition() {
        return "id=" + id;
    }

    @Override
    public GenericEntity selectObject(ResultSet rs) throws SQLException {
        return new Administrator(rs.getLong("id"), rs.getString("ime"), rs.getString("prezime"), (rs.getDate("datum_rodjenja")).toLocalDate(), rs.getString("username"), rs.getString("password"));
    }

    @Override
    public String getWhereFilteredCondition() {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement statement, GenericEntity entity) {
        Administrator administrator = (Administrator) entity;
        try {
            statement.setLong(1, administrator.getId());
            statement.setString(2, administrator.getIme());
            statement.setString(3, administrator.getPrezime());
            statement.setDate(4, java.sql.Date.valueOf(administrator.getDatumRodjenja()));
            statement.setString(5, administrator.getUsername());
            statement.setString(6, administrator.getPassword());
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statement;
    }
    
}
