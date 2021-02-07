package br.com.hugomed.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on : 07/10/2011, 10:50:39
 * Author     : Mcgill E. Dias
 */
public class CriptografiaMD5 {

    public static String encrypt(String senha)  {
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CriptografiaMD5.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.update(senha.getBytes(), 0, senha.length());
        return new BigInteger(1, m.digest()).toString(16);
    }

}
