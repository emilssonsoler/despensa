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




public class EliminarPaquete extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmTipoHabitacion
     */
   
    public EliminarPaquete() {
        initComponents();
        Principal.actualizarComboBoxPaquete(paquetesCombox);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paquetesCombox = new javax.swing.JComboBox<>();
        eliminarButton = new javax.swing.JButton();

        setClosable(true);

        paquetesCombox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        eliminarButton.setText("Eliminar");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(paquetesCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(eliminarButton)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eliminarButton)
                    .addComponent(paquetesCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
       if (JOptionPane.showConfirmDialog(null, "esta seguro")==0) {
            despensa.Paquete paquete = (despensa.Paquete) paquetesCombox.getSelectedItem();
            despensa.DB.GestionPaquetes.eliminarDeDBProducto(paquete.getIdPaqueteDB());
            Principal.actualizarComboBoxPaquete(paquetesCombox);
            Principal.actualizarInformacionTablaPaquetes(GestionPaquetes.tablaPaquetes);
            
        }
    }//GEN-LAST:event_eliminarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminarButton;
    private javax.swing.JComboBox<String> paquetesCombox;
    // End of variables declaration//GEN-END:variables
}