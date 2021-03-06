/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import despensa.FacturaDetalleDB;
import despensa.Paquete;
import java.util.LinkedList;

/**
 *
 * @author Emilsson Soler
 */
public class Facturar extends javax.swing.JInternalFrame {

   
     LinkedList<despensa.Paquete> original = despensa.DB.GestionPaquetes.getLinkedListPaquetes();
     LinkedList<despensa.Paquete> beta = new LinkedList<>();
    public static LinkedList<despensa.FacturaDetalleDB> lstcompra = new LinkedList<>();
    public int contador = 1;
    int cantidad = 1;

    public Facturar() {
        initComponents();
        lstcompra.clear();
        Principal.actualizarInformacionTablaFactura(factura);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        factura = new javax.swing.JTable();
        codigoField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cantidadField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        agragarbutton = new javax.swing.JButton();
        facturarButton = new javax.swing.JButton();
        totalfield = new javax.swing.JTextField();

        setClosable(true);

        factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(factura);

        codigoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo");

        jLabel2.setText("Cantidad");

        agragarbutton.setText("Agregrar");
        agragarbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agragarbuttonActionPerformed(evt);
            }
        });

        facturarButton.setText("Facturar");
        facturarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturarButtonActionPerformed(evt);
            }
        });

        totalfield.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(codigoField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20)
                        .addComponent(cantidadField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agragarbutton)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(facturarButton)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalfield, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidadField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(agragarbutton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(totalfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(facturarButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoFieldActionPerformed

    private void agragarbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agragarbuttonActionPerformed
        try {
            if (contador == 1) {
                int codigo = Integer.parseInt(codigoField.getText());
                if (despensa.DB.ProcesoDeVerificacionDeFactura.verificarSiHayPaqueteDelProdutoOexiste(codigo, original)) {
                    despensa.Producto producto = despensa.DB.ProcesoDeVerificacionDeFactura.obtenerProducto(despensa.DB.GestionProducto.getLinkedListProducto(), codigo);
                    int existencia = despensa.DB.ProcesoDeVerificacionDeFactura.verificarCuantoProductoHayEnLosPaquetes(codigo, original);
                    
                    if (!(cantidadField.getText().isEmpty())) {
                        cantidad = Integer.parseInt(cantidadField.getText());
                    }
                    if (existencia - cantidad >= 0) {
                        original = despensa.DB.ProcesoDeVerificacionDeFactura.restarLaCantidadNecesaria(original, cantidad, codigo);
                    } else {
                        original = despensa.DB.ProcesoDeVerificacionDeFactura.restarLaCantidadNecesaria(original, existencia, codigo);
                        cantidad = existencia;
                    }
                    if (despensa.DB.ProcesoDeVerificacionDeFactura.verificarSiYaHabiaUnProductoIgual(lstcompra, codigo, cantidad)) {
                        lstcompra = despensa.DB.ProcesoDeVerificacionDeFactura.setCantidadNueva(lstcompra, codigo, cantidad);
                        Principal.actualizarInformacionTablaFactura(factura);
                        beta = original;
                        contador++;
                        cantidad=1;
                        this.totalfield.setText(String.valueOf(despensa.DB.ProcesoDeVerificacionDeFactura.obtenerTotalFinal(lstcompra)));
                    } else {
                        lstcompra.add(new FacturaDetalleDB(producto, cantidad, cantidad * producto.getPrecioVenta()));
                        Principal.actualizarInformacionTablaFactura(factura);
                        beta = original;
                        contador++;
                        cantidad=1;
                         this.totalfield.setText(String.valueOf(despensa.DB.ProcesoDeVerificacionDeFactura.obtenerTotalFinal(lstcompra)));
                    }
                } else {

                    System.out.println("no existe codigo o paquete");
                }

            } else {
                
                    int codigo = Integer.parseInt(codigoField.getText());
                    if (despensa.DB.ProcesoDeVerificacionDeFactura.verificarSiHayPaqueteDelProdutoOexiste(codigo, beta)) {
                        despensa.Producto producto = despensa.DB.ProcesoDeVerificacionDeFactura.obtenerProducto(despensa.DB.GestionProducto.getLinkedListProducto(), codigo);
                        int existencia = despensa.DB.ProcesoDeVerificacionDeFactura.verificarCuantoProductoHayEnLosPaquetes(codigo, beta);
                        
                        if (!(cantidadField.getText().isEmpty())) {
                            cantidad = Integer.parseInt(cantidadField.getText());
                        }
                        if (existencia - cantidad > 0) {
                            beta = despensa.DB.ProcesoDeVerificacionDeFactura.restarLaCantidadNecesaria(beta, cantidad, codigo);
                        } else {
                            beta = despensa.DB.ProcesoDeVerificacionDeFactura.restarLaCantidadNecesaria(beta, existencia, codigo);
                             cantidad = existencia;
                        }
                        if (despensa.DB.ProcesoDeVerificacionDeFactura.verificarSiYaHabiaUnProductoIgual(lstcompra, codigo, cantidad)) {
                            lstcompra = despensa.DB.ProcesoDeVerificacionDeFactura.setCantidadNueva(lstcompra, codigo, cantidad);
                            Principal.actualizarInformacionTablaFactura(factura);
                           cantidad=1;
                            this.totalfield.setText(String.valueOf(despensa.DB.ProcesoDeVerificacionDeFactura.obtenerTotalFinal(lstcompra)));
                           
                        } else {
                            lstcompra.add(new FacturaDetalleDB(producto, cantidad, cantidad * producto.getPrecioVenta()));
                            Principal.actualizarInformacionTablaFactura(factura);
                              cantidad=1;
                               this.totalfield.setText(String.valueOf(despensa.DB.ProcesoDeVerificacionDeFactura.obtenerTotalFinal(lstcompra)));
                           
                        }
                    } else {

                        System.out.println("no existe codigo o paquete");
                    }
                
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_agragarbuttonActionPerformed

    private void facturarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturarButtonActionPerformed
        try {
            despensa.DB.GestionFactura.agregarFactura(despensa.AdminFechas.getFechaActualString(), despensa.DB.ProcesoDeVerificacionDeFactura.obtenerTotalFinal(lstcompra));
            for (FacturaDetalleDB facturaDetalleDB : lstcompra) {
                despensa.DB.GestionFactura.agregarFacturaDetalle(despensa.DB.GestionFactura.obtenerUltimoIdGenerado(), facturaDetalleDB.getProducto().getCodigoDB(), facturaDetalleDB.getCantidad(),facturaDetalleDB.getTotal() );
            }
            
            if (beta.isEmpty()) {
                despensa.DB.GestionFactura.limpiarTabla();
                for (Paquete paquete : original) {
                    despensa.DB.GestionFactura.actualizarBaseDeDatosPaquetes(paquete.getFechaVencimiento(),paquete.getPrd().getCodigoDB(),paquete.getPrd().getProveedor().getCodigo(), paquete.getCantidad());
                }
            }else{
            despensa.DB.GestionFactura.limpiarTabla();
                for (Paquete paquete : beta) {
                    despensa.DB.GestionFactura.actualizarBaseDeDatosPaquetes(paquete.getFechaVencimiento(),paquete.getPrd().getCodigoDB(),paquete.getPrd().getProveedor().getCodigo(), paquete.getCantidad());
                }
            }
            //cambios
            contador =1;
            cantidad=1;
            lstcompra.clear();
            original =despensa.DB.GestionPaquetes.getLinkedListPaquetes();
            beta.clear();
            despensa.DB.GestionFactura.generarFacturaPDF();
            Principal.actualizarInformacionTablaFactura(factura);
            totalfield.setText(null);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_facturarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agragarbutton;
    private javax.swing.JTextField cantidadField;
    private javax.swing.JTextField codigoField;
    private javax.swing.JTable factura;
    private javax.swing.JButton facturarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField totalfield;
    // End of variables declaration//GEN-END:variables
}
