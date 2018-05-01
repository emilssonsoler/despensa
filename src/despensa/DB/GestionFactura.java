/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa.DB;

import InterfacesGraficas.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Emilsson Soler
 */
public class GestionFactura {

    public static void agregarFactura(java.sql.Date fechaActual,float total) {

        String sql = "INSERT INTO Facturas(FechaEmision,TotalFinal,Empleados_idEmpleados)"
                + "VALUES(?,?,1)";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {

            // set parameters for statement
            pstmt.setDate(1, fechaActual);
            pstmt.setFloat(2, total);
            pstmt.execute();

            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void agregarFactura(String fechaActual,float total) {

        String sql = "INSERT INTO Facturas(FechaEmision,TotalFinal,Empleados_idEmpleados)"
                + "VALUES(?,?,1)";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {

            // set parameters for statement
            pstmt.setString(1, fechaActual);
            pstmt.setFloat(2, total);
            pstmt.execute();

            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static int obtenerUltimoIdGenerado() {
        int ultimogenerado = -1;
        String sql = "select max(idFacturaEncabezado) idFactura from facturas";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {
            
            rs.next();
            ultimogenerado = rs.getInt("idFactura");

            stmt.close();
            rs.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ultimogenerado;
    }

    /*public static boolean agregarFacturaDetalle(int idProducto, int idFacturaDetalle, int cantidad) {
        boolean ms = false;

        String sql = "INSERT INTO FacturaDetalle(FacturaDetalle,idProductosInFacturaDetalle,cantidad)"
                + "VALUES(?,?,?)";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            // set parameters for statement
            pstmt.setInt(1, obtenerUltimoIdGenerado());
            pstmt.setInt(2, idProducto);
            pstmt.setInt(3, cantidad);
            pstmt.execute();

            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ms;
    }
    */
    public static void limpiarTabla(){
    String sql = "truncate table paquetes";
        try(Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
        }
    
    }

    public static boolean actualizarBaseDeDatosPaquetes(java.sql.Date fecha, int idProductos, int idProveedores, int cantidad) {
        boolean ms = false;

        String sql = "INSERT INTO Paquetes(idProductosInPaquetes,idProveedoresInPaquetes,fechaDeVencimiento,Cantidad)"
                + "VALUES(?,?,?,?)";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {

            // set parameters for statement
            pstmt.setInt(1, idProductos);
            pstmt.setInt(2, idProveedores);
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
    
    public static void agregarFacturaDetalle(int idfactura, int idProducto,int cantidad, float total){
   

        String sql = "INSERT INTO FacturaDetalle(idFacturaEncabezadoInFacturaDetalle,idProductosInFacturaDetalle,cantidad,total) " +
                "VALUES(?,?,?,?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);){

            // set parameters for statement
            pstmt.setInt(1, idfactura);
            pstmt.setInt(2, idProducto);
            pstmt.setInt(3, cantidad);
            pstmt.setFloat(4, total);
            

           pstmt.execute();
            
            
           pstmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
     
    }
    
    public static void generarFacturaPDF(){
    try {
           Connection conn = Conexion.getConnection();
            JasperReport reporte = null;
            String path ="src\\Reportes\\Factura.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn);
            JasperViewer view  = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
              conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
