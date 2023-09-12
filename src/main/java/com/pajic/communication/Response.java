/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.communication;

import java.io.Serializable;

/**
 * Predstavlja odgovor kao rezultat izvrsenja odredjene operacije u okviru aplikacije.
 *
 * Moze sadrzati podatak o rezultatu operacije i o eventualnom izuzetku odnosno nepredvidjenoj gresci koja se desila prilikom izvrsavanja opreracije.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public class Response implements Serializable {
    /**
     * Objekat koji predstavlja rezultat izvrsenja operacije.
     */
    private Object data;
    /**
     * Izuzetak koji se dogodio prilikom izvrsenja operacije.
     */
    private Exception exception;

    /**
     * Vraca rezultat izvrsenja operacije.
     * @return data - Rezultat izvrsenja operacije sadrzan u odgovoru.
     */
    public Object getData() {
        return data;
    }

    /**
     * Vraca izuzetak koji se vezuje za odgovor na zahtev za izvrsenja operacije.
     * @return exception - Izuzetak koji se dogodio pri izvrsenju operacije, pa je stoga sadrzan u odgovoru.
     */
    public Exception getException() {
        return exception;
    }

    /**
     * Postavlja novu vrednost za atribut result odgovora.
     * @param data - Nova vrednost atributa data, odnosno rezultata izvrsenja operacije.
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Postavlja novu vrednost za atribut exception odgovora.
     * @param exception - Nova vrednost atributa exception, odnosno izuzetka nastalog pri izvrsenju operacije.
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }
}
