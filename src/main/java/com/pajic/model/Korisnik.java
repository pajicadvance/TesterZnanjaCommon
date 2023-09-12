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
public class Korisnik extends GenericUser {

    public Korisnik() {
    }

    public Korisnik(long id, String ime, String prezime, LocalDate datumRodjenja, String username, String password) {
        super(id, ime, prezime, datumRodjenja, username, password);
    }

    @Override
    public String getTableName() {
        return "korisnik";
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
        return new Korisnik(rs.getLong("id"), rs.getString("ime"), rs.getString("prezime"), (rs.getDate("datum_rodjenja")).toLocalDate(), rs.getString("username"), rs.getString("password"));
    }

    @Override
    public String getWhereFilteredCondition() {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement statement, GenericEntity entity) {
        Korisnik korisnik = (Korisnik) entity;
        try {
            statement.setLong(1, korisnik.getId());
            statement.setString(2, korisnik.getIme());
            statement.setString(3, korisnik.getPrezime());
            statement.setDate(4, java.sql.Date.valueOf(korisnik.getDatumRodjenja()));
            statement.setString(5, korisnik.getUsername());
            statement.setString(6, korisnik.getPassword());
        } catch (SQLException ex) {
            Logger.getLogger(Korisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statement; 
    }
    
}