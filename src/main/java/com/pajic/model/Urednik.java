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
 * Predstavlja urednika u sistemu.
 *
 * Sadrzi objekat tipa Administrator koji predstavlja administratora koji je dodao urednika.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 */
public class Urednik extends GenericUser {

    /**
     * Administrator koji je dodao urednika u sistem.
     */
    private Administrator administrator;

    /**
     * Neparametrizovani konstruktor za kreiranje instance urednika.
     */
    public Urednik() {
    }

    /**
     * Parametrizovani konstruktor za kreiranje instance urednika.
     * @param id - Vrednost koja se dodeljuje ID-u urednika.
     * @param ime - Vrednost koja se dodeljuje imenu urednika.
     * @param prezime - Vrednost koja se dodeljuje prezimenu urednika.
     * @param datumRodjenja - Vrednost koja se dodeljuje datumu rodjenja urednika.
     * @param username - Vrednost koja se dodeljuje korisnickom imenu urednika.
     * @param password - Vrednost koja se dodeljuje lozinki urednika.
     * @param administrator - Administrator koji se dodeljuje administratoru urednika.
     */
    public Urednik(long id, String ime, String prezime, LocalDate datumRodjenja, String username, String password, Administrator administrator) {
        super(id, ime, prezime, datumRodjenja, username, password);
        setAdministrator(administrator);
    }

    /**
     * Vraca administratora vezanog za urednika.
     * @return administrator - Administrator vezan za urednika.
     */
    public Administrator getAdministrator() {
        return administrator;
    }

    /**
     * Postavlja novu vrednost za atribut Administrator urednika.
     * @param administrator - Nova vrednost za atribut administrator.
     *
     * @throws NullPointerException - ako se unese null vrednost za administrator
     */
    public void setAdministrator(Administrator administrator) {
        if(administrator == null)
            throw new NullPointerException("Administrator urednika ne sme biti null.");

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
