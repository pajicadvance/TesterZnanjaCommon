/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.communication;

import java.io.Serializable;

/**
 * Predstavlja zahtev koji se koristi za slanje odgovarajuce operacije i argumenta.
 *
 * Sadrzi operaciju koju treba izvrsiti i odgovarajuci argument koji se prosledjuje pri izvrsavanju operacije.
 * Klasa implementira Serializable interfejs kako bi omogućila serijalizaciju objekata tipa Request.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public class Request implements Serializable {
    /**
     * Podatak nad kojim ce se raditi u okviru operacije.
     */
    private Object data;
    /**
     * Opreracija koju treba izvrsiti.
     */
    private Operation operation;

    /**
     * Vraca podatak koji se prosledjuje u okviru zahteva.
     * @return data - Podatak prosledjen uz zahtev prilikom izvrsenja operacije.
     */
    public Object getData() {
        return data;
    }

    /**
     * Vraca operaciju vezanu za konkretan zahtev.
     * @return operation - Operacija specificirana u zahtevu.
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * Postavlja novu vrednost atributa data.
     * @param data - Nova vrednost podatka zahteva za izvrsenje operacije, odnosno atributa data u okviru zahteva.
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Postavlja novu vrednost atributa operation.
     * @param operation - Nova vrednost operacije, odnosno atributa operation u okviru zahteva.
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
