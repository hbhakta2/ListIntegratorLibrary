/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listintegratorlibrary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * FormattedDateCreator class
 * 
 * @author Hardikkumar Bhakta
 */
public class FormattedDateCreator {
    /**
     * getFormattedDate() method takes
     * @param date
     * @return String formatted date
     */
    public static String getFormattedDate(Date date) {
        return new SimpleDateFormat("EEEE, MMMM d, yyyy", Locale.getDefault()).format(date);
    }
    
    
}
