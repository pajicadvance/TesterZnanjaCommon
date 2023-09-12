/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pajic.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 * Predstavlja genericki entitet koji moze vratiti ime tabele u bazi, nazive kolona za operacije dodavanja i prikazivanja,
 * vrednosti atributa za operaciju dodavanja, nazive metoda koje ce posluziti u radu sa ResultSet-om,
 * vrednosti atributa za operaciju izmene podataka u bazi, kao i uslove koji ce se koristiti u operacijama brisanja i izmene podataka.
 *
 * @author Pavle Pajic
 * @since 1.1.0
 *
 */
public interface GenericEntity extends Serializable {

    /**
     * Vraca naziv tabele datog entiteta u bazi podataka.
     * @return tableName - Ime tabele u bazi podataka kao String vrednost.
     */
    String getTableName();

    /**
     * Vraca nazive kolona koje ce se koristiti za potrebe operacije dodavanja novog entiteta u bazu podataka.
     * @return columnNamesInsert - String koji sadrzi odredjene nazive kolona koje pripadaju tabeli vezanoj za odgovarajuci entitet. Nazivi kolona su odvojeni zarezom i blanko znakom.
     */
    String getColumnNamesForInsert();

    /**
     * Vraca vrednosti atributa odredjenog entiteta koje predstavljaju deo upita za izvodjenje operacije dodavanja novog entiteta u bazu podataka.
     * @return insertValues - String vrednost koja sadrzi odgovarajuce vrednosti atributa koje treba navesti prilikom pisanja INSERT upita. Vrednosti su obuhvacene navodnicima u slucajevima kada je to potrebno.
     */
    String getInsertValues();

    /**
     * Vraca vrednosti atributa odredjenog entiteta koje predstavljaju deo upita za izvodjenje operacije izmene podataka entiteta u bazi podataka.
     * @return updateValues - String vrednost koja sadrzi odgovarajuce vrednosti atributa koje treba navesti prilikom pisanja UPDATE upita. Vrednosti su obuhvacene navodnicima u slucajevima kada je to potrebno.
     */
    String getUpdateValues();

    /**
     * Vraca WHERE deo upita koji predstavlja uslov prilikom izvrsavanja odredjenog upita. U okviru aplikacije koristi se kod operacije za brisanje odgovarajuceg entiteta iz baze podataka.
     * @return whereCondition - String vrednost koja predstavlja WHERE uslov prilikom izvrsavanja upita za brisanje podataka iz baze, koji se dodaje na samom kraju upita.
     */
    String getWhereCondition();

    /**
     * Vraca WHERE deo upita koji predstavlja uslov prilikom izvrsavanja odredjenog upita. U okviru aplikacije koristi se kod operacije za brisanje odgovarajuceg entiteta iz baze podataka.
     * @return whereFilteredCondition - String vrednost koja predstavlja WHERE uslov prilikom izvrsavanja upita za brisanje podataka iz baze, koji se dodaje na samom kraju upita.
     */
    String getWhereFilteredCondition();

    /**
     * Vraca PreparedStatement objekat koji se u programu koristi za dodavanje odgovarajuceg entiteta u bazu podataka.
     * @param statement - Sveze instanciran PreparedStatement koji ce biti popunjen podacima specificnim za odgovarajuci entitet.
     * @param entity - Genericki objekat za koji se priprema PreparedStatement objekat.
     * @return PreparedStatement - PreparedStatement objekat popunjen podacima specificnim za odgovarajuci entitet.
     */
    PreparedStatement prepareStatement(PreparedStatement statement, GenericEntity entity);

    /**
     * Konstruise GenericEntity objekat koristeci podatke iz ResultSet-a izvucenih iz baze podataka i vraca ga.
     * U programu se koristi za izvrsavanja upita za vracanje i pretragu svih objekata odgovarajuceg tipa.
     * @param rs - ResultSet iz baze podataka
     * @return GenericEntity - GenericEntity objekat konstruisan podacima iz ResultSet-a
     * @throws SQLException - Ako se prilikom izvlacenja podataka iz ResultSet-a desi greska.
     */
    GenericEntity selectObject(ResultSet rs) throws SQLException;

    /**
     * Postavlja novu vrednost id atributu odgovarajuceg entiteta.
     * @param id - Nova ID vrednost nekog entiteta koja se dodaje id atributu u vidu Long vrednosti (ceo broj).
     *
     * @throws NullPointerException - ako se unese null vrednost za ID
     * @throws IllegalArgumentException - ako se ID vrednost koja je manja od 1
     */
    void setId(Long id);
    
}
