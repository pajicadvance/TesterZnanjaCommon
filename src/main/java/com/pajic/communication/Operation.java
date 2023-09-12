/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.pajic.communication;

import java.io.Serializable;

/**
 *
 * @author Pavle
 */
public enum Operation implements Serializable {
    LOGIN,
    GET_ALL_TEST_ZNANJA, ADD_TEST_ZNANJA, GET_TEST_ZNANJA, DELETE_TEST_ZNANJA, FIND_TEST_ZNANJA,
    GET_ALL_UREDNIK, GET_ALL_UREDNIK_FILTERED, ADD_UREDNIK, GET_UREDNIK, DELETE_UREDNIK, FIND_UREDNIK,
    ADD_REZULTAT, FIND_REZULTAT, ADD_KORISNIK
}
