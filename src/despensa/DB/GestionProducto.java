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
public class GestionProducto {
    
     public static boolean agregarProducto(int idProveedores,int codigoProducto,String nombreProducto,float precioCompra,float precioVenta,boolean refrigeracion) {

        boolean ms = false;

        String sql = "INSERT INTO productos(idProveedoresInProductos,CodigoDeProducto,nombreProducto,precioCompra,precioVenta,refrigeracion)"
                + "VALUES(?,?,?,?,?,?)";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {

            // set parameters for statement
            pstmt.setInt(1, idProveedores);
             pstmt.setInt(2, codigoProducto);
             pstmt.setString(3, nombreProducto);
             pstmt.setFloat(4, precioCompra);
             pstmt.setFloat(5, precioVenta);
             pstmt.setBoolean(6, refrigeracion);
             

           pstmt.execute();
            
            
           pstmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ms;
    }
     //lst proveedores
      public static LinkedList getLinkedListProducto() {
        String sql = "select * from productos p inner join proveedores pr on p.idProveedoresInProductos = pr.idProveedores";
      
        LinkedList<despensa.Producto> lis = new LinkedList<>();
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {
           
            while (rs.next()) {
               
                 
                lis.add(new Producto(rs.getInt("CodigoDeProducto"),rs.getInt("idProductos"), rs.getString("nombreProducto"), rs.getFloat("precioCompra"), rs.getFloat("precioVenta"), new Proveedor(rs.getString("nombre"),rs.getString("Descripcion"),rs.getInt("idProveedores")), rs.getBoolean("refrigeracion")));
                
                
            }
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lis;
    }
    public static Object[][] getArregloProveedores() {
        LinkedList<despensa.Producto> lista = getLinkedListProducto();
        Object[][] data = new Object[lista.size()][6];

        for (int i = 0; i < lista.size(); i++) {
             data[i][0] = lista.get(i).getNombre();
            data[i][1] = lista.get(i).getCodigo();
            data[i][2] = lista.get(i).getProveedor().getNombre();
            data[i][3] = lista.get(i).getPrecioCompra();
            data[i][4] = lista.get(i).getPrecioVenta();
            data[i][5] = "No";
            if (lista.get(i).getRefrigeracion().isRefrigeracion()) {
               data[i][5] = "Si";
            }
            
             

        }
        return data;
    }
    
     public static boolean eliminarDeDBProducto(int id) {

        String sql = "delete from productos where idProductos = ?";
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
     public static void modificarProductosTodosLosCamposUpdate(int idproveedor,int codigoProducto,
             String nombreProducto,float precioCompra,float precioventa,boolean refrigeracion, int codigoproductodb) {
        String sqlUpdate = "UPDATE productos "
                + "SET idProveedoresInProductos = ?,CodigoDeProducto = ?,nombreProducto=?,"
                + "precioCompra=?,precioVenta=?,refrigeracion=? "
                + "WHERE idProductos = ?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {

           pstmt.setInt(1, idproveedor);
           pstmt.setInt(2, codigoProducto);
           pstmt.setString(3, nombreProducto);
           pstmt.setFloat(4, precioCompra);
           pstmt.setFloat(5, precioventa);
           pstmt.setBoolean(6, refrigeracion);
           pstmt.setInt(7, codigoproductodb);
           pstmt.execute();
           
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
      /**
     * metodo para convertir la lista de proveedores en un combobox
     *
     * @return
     */
    public static DefaultComboBoxModel getDefaultCboModelProducto() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        LinkedList<despensa.Producto> lista = getLinkedListProducto();
        for (int i = 0; i < lista.size(); i++) {
            model.addElement(lista.get(i));
        }
        return model;
    }
}
