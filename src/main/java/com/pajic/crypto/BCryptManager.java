/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.crypto;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Predstavlja pomocnu klasu za metode iz JBCrypt biblioteke potrebne sistemu.
 *
 * @author pajic
 * @since 1.0.0
 */
public class BCryptManager {

    /**
     * Konvertuje lozinku u formi obicnog string-a u hash i vraca generisan hash.
     * @param password - Lozinka u formi obicnog string-a.
     * @return String - String koji sadrzi hash-ovanu lozinku.
     */
    public static String passwordToHash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * Proverava da li se lozinka i hash poklapaju i vraca rezultat provere.
     * @param password - Lozinka u formi obicnog string-a.
     * @param hash - String koji sadrzi hash-ovanu lozinku.
     * @return boolean - True ako se poklapaju, false u suprotnom.
     */
    public static boolean checkPasswordMatch(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
    
}
