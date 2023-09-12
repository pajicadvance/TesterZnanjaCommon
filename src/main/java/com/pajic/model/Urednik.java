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
public class Urednik extends GenericUser {

    private Administrator administrator;
    
    public Urednik() {
    }

    public Urednik(long id, String ime, String prezime, LocalDate datumRodjenja, String username, String password, Administrator administrator) {
        super(id, ime, prezime, datumRodjenja, username, password);
        this.administrator = administrator;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public String getTableName() {
        return "urednik";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id, ime, prezime, datum_rodjenja, username, password, administrator_id";
    }

    @Override
    public String getInsertValues() {
        return "(?,?,?,?,?,?,?)";
    }

    @Override
    public String getUpdateValues() {
        return    "ime='" + ime + "', "
                + "prezime='" + prezime + "', "
                + "datum_rodjenja=" + datumRodjenja + ","
                + "username='" + username + "',"
                + "password='" + password + "' "
                + "administrator_id=" + administrator.getId();
    }

    @Override
    public String getWhereCondition() {
        return "id=" + id;
    }

    @Override
    public GenericEntity selectObject(ResultSet rs) throws SQLException {
        Administrator a = new Administrator();
        a.setId(rs.getLong("administrator_id"));
        return new Urednik(rs.getLong("id"), rs.getString("ime"), rs.getString("prezime"), (rs.getDate("datum_rodjenja")).toLocalDate(), rs.getString("username"), rs.getString("password"), a);
    }

    @Override
    public String getWhereFilteredCondition() {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement statement, GenericEntity entity) {
        Urednik urednik = (Urednik) entity;
        try {
            statement.setLong(1, urednik.getId());
            statement.setString(2, urednik.getIme());
            statement.setString(3, urednik.getPrezime());
            statement.setDate(4, java.sql.Date.valueOf(urednik.getDatumRodjenja()));
            statement.setString(5, urednik.getUsername());
            statement.setString(6, urednik.getPassword());
            statement.setLong(7, urednik.getAdministrator().getId());
        } catch (SQLException ex) {
            Logger.getLogger(Urednik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statement;
    }
}
