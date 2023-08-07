/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt.lab4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Kien Luu
 */
public class XDate {
    private static SimpleDateFormat formater = new SimpleDateFormat();
    public static Date parse(String text, String pattern) throws RuntimeException {
        try {
            formater.applyPattern(pattern);
            return formater.parse(text);
        }
        catch(ParseException e) {
            throw new RuntimeException(e);
        }
        
    } 
    public static Date parse(String text) throws RuntimeException {
        return XDate.parse(text, "dd-MM-yyyy");
    }
}
