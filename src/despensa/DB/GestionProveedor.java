/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa.DB;

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
public class GestionProveedor {

    /**
     * Metodo para agregar
     *
     * @param nombre
     * @param descripcion
     * @return un booleano que representa el exito de la funcion
     */
    public static boolean agregarProveedor(String nombre, String descripcion) {

        boolean ms = false;

        String sql = "INSERT INTO proveedores(nombre,descripcion)"
                + "VALUES(?,?)";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            // set parameters for statement
            pstmt.setString(1, nombre);
            pstmt.setString(2, descripcion);

            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) {
                ms = true;
            }

            conn.close();
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return ms;
    }

    /**
     * Metodo para que la informacion de la tabla proveedores en la BD se
     * convierta en un likedlist de tipo proveedor
     *
     * @return LikedList
     */
    public static LinkedList getLinkedListProveedores() {
        String sql = "select * from Proveedores";
        LinkedList<despensa.Proveedor> lis = new LinkedList<>();
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                lis.add(new Proveedor(rs.getString("nombre"), rs.getString("Descripcion"), rs.getInt("idProveedores")));

            }
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lis;
    }

    /**
     * metodo para convertir el linkedlist en una matriz para pasarlo luego a la
     * tabla
     *
     * @return Object[][]
     */
    public static Object[][] getArregloProveedores() {
        LinkedList<despensa.Proveedor> lista = getLinkedListProveedores();
        Object[][] data = new Object[lista.size()][2];

        for (int i = 0; i < lista.size(); i++) {
            data[i][0] = lista.get(i).getNombre();
            data[i][1] = lista.get(i).getDescripcion();

        }
        return data;
    }

    /**
     * Metodo para que la informacion de la tabla proveedores en la BD se
     * convierta en un likedlist de tipo proveedor con filtro de nombre
     *
     * @param txt
     * @return LikedList
     */
    public static LinkedList getLinkedListProveedoresPorNombre(String txt) {
        String sql = "select nombre,Descripcion,idProveedores from proveedores where nombre like" + '"' + txt + "%" + '"';
        LinkedList<despensa.Proveedor> lis = new LinkedList<>();
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                lis.add(new Proveedor(rs.getString("nombre"), rs.getString("Descripcion"), rs.getInt("idProveedores")));

            }

            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lis;
    }

    /**
     * metodo para convertir el linkedlist en una matriz para pasarlo luego a la
     * tabla con filtro el nombre
     *
     * @param txt
     * @return Object[][]
     */
    public static Object[][] getArregloProveedoresPorNombrere(String txt) {
        LinkedList<despensa.Proveedor> lista = getLinkedListProveedoresPorNombre(txt);
        Object[][] data = new Object[lista.size()][2];
        for (int i = 0; i < lista.size(); i++) {
            data[i][0] = lista.get(i).getNombre();
            data[i][1] = lista.get(i).getDescripcion();

        }

        return data;
    }

    /**
     * metodo que elimina el porveedor de la tabla por indice
     *
     * @param id
     * @return
     */
    public static boolean eliminarDeDBProveedores(int id) {

        String sql = "delete from proveedores where idProveedores = ?";
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

    public static void modificarProveedorTodosLosCamposUpdate(String nombre, int id, String descripcion) {
        String sqlUpdate = "UPDATE proveedores "
                + "SET nombre = ?,Descripcion=? "
                + "WHERE idProveedores = ?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, descripcion);
            pstmt.setInt(3, id);
            pstmt.execute();

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
    
    public static void modificarProveedorSoloElNombreUpdate(String nombre, int id) {
        String sqlUpdate = "UPDATE proveedores "
                + "SET nombre = ?"
                + "WHERE idProveedores = ?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {

            pstmt.setString(1, nombre);
            pstmt.setInt(2, id);
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
    public static DefaultComboBoxModel getDefaultCboModel() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        LinkedList<despensa.Proveedor> lista = getLinkedListProveedores();
        for (int i = 0; i < lista.size(); i++) {
            model.addElement(lista.get(i));
        }
        return model;
    }
}
