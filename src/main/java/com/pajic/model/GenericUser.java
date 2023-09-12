/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.model;

import java.time.LocalDate;

/**
 *
 * @author Pavle
 */
public abstract class GenericUser implements GenericEntity {
    protected long id;
    protected String ime;
    protected String prezime;
    protected LocalDate datumRodjenja;
    protected String username;
    protected String password;

    public GenericUser() {
    }

    public GenericUser(long id, String ime, String prezime, LocalDate datumRodjenja, String username, String password) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }
    
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public abstract String getTableName();

    @Override
    public abstract String getColumnNamesForInsert();

    @Override
    public abstract String getInsertValues();

    @Override
    public abstract String getUpdateValues();

    @Override
    public abstract String getWhereCondition();
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
