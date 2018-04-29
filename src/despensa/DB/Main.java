/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa.DB;

/**
 *
 * @author Emilsson Soler
 */
 import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
   
 
/**
 *
 * @author mysqltutorial.org
 */
public class Main {
 
    public static void main(String[] args) {
        // create a new connection from MySQLJDBCUtil
        try (Connection conn = Conexion.getConnection()) {
            
            Statement stmt  = conn.createStatement();
            
            String sql = "select * from candidates";
            
            ResultSet rs    = stmt.executeQuery(sql);
            
        
            
            System.out.println(rs.getString("first_name") + "\t" + rs.getString("last_name")  + "\t" +  rs.getString("email") + "\t" + rs.getString("phone") );
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    
        
        
        
        
    }
}
    

