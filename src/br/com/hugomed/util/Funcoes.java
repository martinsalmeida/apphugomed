package br.com.hugomed.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Professor Mcgill
 */
public class Funcoes {
    
    public static Date strToDate(String data){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
            return new Date();
        }
    }
    
}
