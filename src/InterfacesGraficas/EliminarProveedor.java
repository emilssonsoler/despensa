/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import javax.swing.JOptionPane;



/**
 *
 * @author 
 */




public class EliminarProveedor extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmTipoHabitacion
     */
   
    public EliminarProveedor() {
        initComponents();
        Principal.actualizarComboBoxProveedor(ProveedoresCombox);
         
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProveedoresCombox = new javax.swing.JComboBox<>();
        EliminarButton = new javax.swing.JButton();

        setClosable(true);

        ProveedoresCombox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        EliminarButton.setText("Eliminar");
        EliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(ProveedoresCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(EliminarButton)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProveedoresCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EliminarButton))
                .addGap(109, 109, 109))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarButtonActionPerformed
        if (JOptionPane.showConfirmDialog(null, "esta seguro")==0) {
             despensa.Proveedor proveedor = (despensa.Proveedor) this.ProveedoresCombox.getSelectedItem();
        despensa.DB.GestionProveedor.eliminarDeDBProveedores(proveedor.getCodigo());
        Principal.actualizarComboBoxProveedor(this.ProveedoresCombox);
        Principal.actualizarInformacionTablaProveedores(GestionProveedor.tablaProveedores);
        }
        
    }//GEN-LAST:event_EliminarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EliminarButton;
    private javax.swing.JComboBox<String> ProveedoresCombox;
    // End of variables declaration//GEN-END:variables
}
