/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa.DB;

import despensa.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Emilsson Soler
 */
public class GestionEmpleado {
    
    public static void agregarEmpleado(String pnombre,String sNombre,String papellido
                                        ,String sApellido,float sueldo,int idEm,String direccion
                                        , String telefono,String fechaDeInicio){
    
    String sql = "insert into Empleados(pNombre,sNombre,pApellido,sApellido,direccion,numeroTelefonico,codigoEmpleado,sueldo,fechaDeInicio)"
            +" values(?,?,?,?,?,?,?,?,?)";
    
  try (Connection conn = Conexion.getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);) {

            // set parameters for statement
           pstmt.setString(1, pnombre);
           pstmt.setString(2, sNombre);
           pstmt.setString(3, papellido);
           pstmt.setString(4, sApellido);
           pstmt.setString(5, direccion);
           pstmt.setString(6, telefono);
           pstmt.setInt(7, idEm);
           pstmt.setFloat(8, sueldo);
           pstmt.setString(9, fechaDeInicio);
           
           pstmt.execute();

            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

      
    }


 public static LinkedList getLinkedListProveedores() {
        String sql = "select * from empleados";
        LinkedList<despensa.Empleado> lis = new LinkedList<>();
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
               // lis.add(new Empleado(rs.getInt(sql), 0, 0, fechaInicio, sql, sql, sql, sql, sql, sql))

            }
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lis;
    }
}