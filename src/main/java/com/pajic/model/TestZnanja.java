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
 * Predstavlja test znanja.
 *
 * Sadrzi ID, naziv, poene potrebne za prolaz, listu pitanja i tip testa znanja.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 */
public class TestZnanja implements GenericEntity {
    /**
     * ID testa znanja.
     */
    private long id;
    /**
     * Naziv testa znanja.
     */
    private String naziv;
    /**
     * Poeni potrebni za prolaz testa znanja.
     */
    private double poeniZaProlaz;
    /**
     * Lista pitanja testa znanja.
     */
    private List<Pitanje> listaPitanja;
    /**
     * Tip testa znanja.
     */
    private TipTestaZnanja tipTestaZnanja;

    /**
     * Neparametrizovani konstruktor za kreiranje instance testa znanja.
     */
    public TestZnanja() {
    }

    /**
     * Parametrizovani konstruktor za kreiranje instance testa znanja.
     * @param id - Vrednost koja se dodeljuje ID-u testa znanja.
     * @param naziv - Vrednost koja se dodeljuje nazivu testa znanja.
     * @param poeniZaProlaz - Vrednost koja se dodeljuje poenima za prolaz testa znanja.
     * @param listaPitanja - Vrednost koja se dodeljuje listi pitanja testa znanja.
     * @param tipTestaZnanja - Vrednost koja se dodeljuje tipu testa znanja.
     */
    public TestZnanja(long id, String naziv, double poeniZaProlaz, List<Pitanje> listaPitanja, TipTestaZnanja tipTestaZnanja) {
        setId(id);
        setNaziv(naziv);
        setPoeniZaProlaz(poeniZaProlaz);
        setListaPitanja(listaPitanja);
        setTipTestaZnanja(tipTestaZnanja);
    }

    /**
     * Vraca tip testa znanja.
     * @return tipTestaZnanja - Tip testa znanja.
     */
    public TipTestaZnanja getTipTestaZnanja() {
        return tipTestaZnanja;
    }

    /**
     * Postavlja novu vrednost za atribut tipTestaZnanja.
     * @param tipTestaZnanja - Nova vrednost za atribut tipTestaZnanja.
     *
     * @throws NullPointerException - ako se unese null vrednost za tipTestaZnanja
     */
    public void setTipTestaZnanja(TipTestaZnanja tipTestaZnanja) {
        if(tipTestaZnanja == null)
            throw new NullPointerException("Tip testa znanja ne sme biti null.");

        this.tipTestaZnanja = tipTestaZnanja;
    }

    /**
     * Vraca ID testa znanja.
     * @return id - ID testa znanja.
     */
    public long getId() {
        return id;
    }

    /**
     * Vraca naziv testa znanja.
     * @return naziv - Naziv testa znanja.
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     *
     * Postavlja novu vrednost za atribut naziv testa znanja.
     * @param naziv - Nova vrednost za atribut naziv.
     *
     * @throws NullPointerException - ako se unese null vrednost za naziv
     * @throws IllegalArgumentException - ako je naziv prazan String
     */
    public void setNaziv(String naziv) {
        if(naziv == null)
            throw new NullPointerException("Naziv testa znanja ne sme biti null.");

        if(naziv.isEmpty())
            throw new IllegalArgumentException("Naziv testa znanja ne sme biti prazan String.");

        this.naziv = naziv;
    }

    /**
     * Vraca poene za prolaz testa znanja.
     * @return poeniZaProlaz - Poeni za prolaz testa znanja.
     */
    public double getPoeniZaProlaz() {
        return poeniZaProlaz;
    }

    /**
     * Postavlje novu vrednost za atribut poeniZaProlaz testa znanja.
     * @param poeniZaProlaz - Nova vrednost za atribut poeniZaProlaz.
     *
     * @throws IllegalArgumentException - ako je poeniZaProlaz negativan broj
     */
    public void setPoeniZaProlaz(double poeniZaProlaz) {
        if(poeniZaProlaz < 0)
            throw new IllegalArgumentException("Poeni za prolaz ne sme biti negativan broj.");

        this.poeniZaProlaz = poeniZaProlaz;
    }

    /**
     * Vraca listu pitanja testa znanja.
     * @return listaPitanja - Lista pitanja testa znanja.
     */
    public List<Pitanje> getListaPitanja() {
        return listaPitanja;
    }

    /**
     * Postavlja novu vrednost za atribut listaPitanja.
     * @param listaPitanja - Nova vrednost za atribut listaPitanja.
     *
     * @throws NullPointerException - ako se unese null vrednost za listaPitanja
     */
    public void setListaPitanja(List<Pitanje> listaPitanja) {
        if(listaPitanja == null)
            throw new NullPointerException("Lista pitanja ne sme biti null.");

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
        if(id == null)
            throw new NullPointerException("ID vrednost ne sme biti null.");

        if(id < 1)
            throw new IllegalArgumentException("ID vrednost ne sme biti manja od 1.");

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
