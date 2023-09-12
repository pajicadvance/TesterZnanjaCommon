/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.crypto;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author pajic
 */
public class BCryptManager {
    
    public static String passwordToHash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    
    public static boolean checkPasswordMatch(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
    
}
