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


 public static LinkedList getLinkedListEmpleado() {
        String sql = "select * from empleados";
        LinkedList<despensa.Empleado> lis = new LinkedList<>();
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                lis.addLast(new Empleado(rs.getInt("codigoEmpleado"), rs.getInt("idEmpleados"), rs.getFloat("sueldo"), rs.getString("fechaDeInicio"), rs.getString("pNombre"), rs.getString("sNombre"), rs.getString("pApellido"), rs.getString("sApellido"), rs.getString("direccion"), rs.getString("numeroTelefonico")));

            }
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lis;
    }
 
 public static Object[][] getArregloEmpleado() {
        LinkedList<despensa.Empleado> lista = getLinkedListEmpleado();
        Object[][] data = new Object[lista.size()][6];

        for (int i = 0; i < lista.size(); i++) {
            data[i][0] = lista.get(i).getNombreCompleto();
            data[i][1] = lista.get(i).getIdEmpleado();
            data[i][2]=lista.get(i).getSueldo();
            data[i][3]=lista.get(i).getFechaInicio();
            data[i][4]=lista.get(i).getDireccion();
            data[i][5]=lista.get(i).getNumeroTelefonico();

        }
        return data;
    }
}
