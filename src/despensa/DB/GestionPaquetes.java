/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa.DB;

import despensa.Producto;
import despensa.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Emilsson Soler
 */
public class GestionPaquetes {
    
    //metodo para agreagar
    public static boolean agregarPaquete(java.sql.Date fecha,int idProductos,int idProveedores,int cantidad) {

        boolean ms = false;

        String sql = "INSERT INTO Paquetes(idProductosInPaquetes,idProveedoresInPaquetes,fechaDeVencimiento,Cantidad)"
                + "VALUES(?,?,?,?)";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {

            // set parameters for statement
            pstmt.setInt(1, idProductos);
            pstmt.setInt(2,idProveedores);
            pstmt.setDate(3, fecha);
            pstmt.setInt(4, cantidad);
             

           pstmt.execute();
            
            
           pstmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ms;
    }
    
     public static LinkedList getLinkedListPaquetes() {
        String sql = "select * from paquetes p inner join productos  pr on p.idProductosInPaquetes = pr.idProductos inner join proveedores prove on p.idProveedoresInPaquetes = prove.idProveedores";
      
        LinkedList<despensa.Paquete> lis = new LinkedList<>();
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {
           
            while (rs.next()) {
               
                 
                lis.add(new despensa.Paquete(rs.getInt("idPaquetes"),rs.getDate("fechaDeVencimiento"), rs.getInt("Cantidad"),
                        new Producto(rs.getInt("CodigoDeProducto"),rs.getInt("idProductos"), rs.getString("nombreProducto"), rs.getFloat("precioCompra"), rs.getFloat("precioVenta"), new Proveedor(rs.getString("nombre"),rs.getString("Descripcion"),rs.getInt("idProveedores")), rs.getBoolean("refrigeracion"))));
                
                
            }
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lis;
    }
     
     public static LinkedList getLinkedListPaquetesPorNombre(String txt) {
        String sql = "select * from paquetes p inner join productos  pr on p.idProductosInPaquetes = pr.idProductos inner join proveedores prove on p.idProveedoresInPaquetes = prove.idProveedores where nombreProducto like" + '"' + txt + "%" + '"';
      
        LinkedList<despensa.Paquete> lis = new LinkedList<>();
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {
           
            while (rs.next()) {
               
                 
                lis.add(new despensa.Paquete(rs.getInt("idPaquetes"),rs.getDate("fechaDeVencimiento"), rs.getInt("Cantidad"),
                        new Producto(rs.getInt("CodigoDeProducto"),rs.getInt("idProductos"), rs.getString("nombreProducto"), rs.getFloat("precioCompra"), rs.getFloat("precioVenta"), new Proveedor(rs.getString("nombre"),rs.getString("Descripcion"),rs.getInt("idProveedores")), rs.getBoolean("refrigeracion"))));
                
                
            }
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lis;
    }
     public static Object[][] getArregloPaquetes() {
        LinkedList<despensa.Paquete> lista = getLinkedListPaquetes();
        Object[][] data = new Object[lista.size()][4];

        for (int i = 0; i < lista.size(); i++) {
             data[i][0] = lista.get(i).getPrd().getNombre();
            data[i][1] = lista.get(i).getCantidad();
            data[i][2] = lista.get(i).getFechaVencimiento();
            data[i][3] = lista.get(i).getPrd().getProveedor().getNombre();
          

        }
        return data;
    }
      public static Object[][] getArregloPaquetesPorNombre(String txt) {
        LinkedList<despensa.Paquete> lista = getLinkedListPaquetesPorNombre(txt);
        Object[][] data = new Object[lista.size()][4];

        for (int i = 0; i < lista.size(); i++) {
             data[i][0] = lista.get(i).getPrd().getNombre();
            data[i][1] = lista.get(i).getCantidad();
            data[i][2] = lista.get(i).getFechaVencimiento();
            data[i][3] = lista.get(i).getPrd().getProveedor().getNombre();
          

        }
        return data;
    }
     
     public static boolean eliminarDeDBProducto(int id) {

        String sql = "delete from paquetes where idPaquetes = ?";
        boolean result = false;
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, id);
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) {
                result = true;
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
      public static void modificarPaquetesTodosLosCamposUpdate(int idProductos,String fechaven,int cantidad,int idpaquete) {
        String sqlUpdate = "UPDATE Paquetes "
                + "SET idProductosInPaquetes = ?,fechaDeVencimiento = ?,Cantidad=?"
                + " WHERE idPaquetes = ?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
            pstmt.setInt(1, idProductos);
            pstmt.setString(2, fechaven);
             pstmt.setInt(3, cantidad);
             pstmt.setInt(4,idpaquete);
           pstmt.execute();
           
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
     
     public static DefaultComboBoxModel getDefaultCboModelPaquetes() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        LinkedList<despensa.Paquete> lista = getLinkedListPaquetes();
        for (int i = 0; i < lista.size(); i++) {
            model.addElement(lista.get(i));
        }
        return model;
    }
}
