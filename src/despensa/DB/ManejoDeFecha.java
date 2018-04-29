/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa.DB;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Emilsson Soler
 */
public class ManejoDeFecha {

    public static java.sql.Date manejofecha(String fecha) {
        java.sql.Date sqlDate = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            String date = fecha;
            java.util.Date utilDate = formatter.parse(date);
            sqlDate = new java.sql.Date(utilDate.getTime());
            
        } catch (ParseException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return sqlDate;
    }
   

}
