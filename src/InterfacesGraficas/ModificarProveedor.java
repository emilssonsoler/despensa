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




public class ModificarProveedor extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmTipoHabitacion
     */
   
    public ModificarProveedor() {
        initComponents();
        Principal.actualizarComboBoxProveedor(proveedoresCombox);
         
        
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
        descripcionField = new javax.swing.JTextArea();
        nombreField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        modificarProveedor = new javax.swing.JButton();
        proveedoresCombox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);

        descripcionField.setColumns(20);
        descripcionField.setRows(5);
        jScrollPane1.setViewportView(descripcionField);

        nombreField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Descripcion");

        modificarProveedor.setText("Modificar");
        modificarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarProveedorActionPerformed(evt);
            }
        });

        proveedoresCombox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Elige el proveedor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(modificarProveedor)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(proveedoresCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proveedoresCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)))
                .addGap(28, 28, 28)
                .addComponent(modificarProveedor)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreFieldActionPerformed

    private void modificarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarProveedorActionPerformed
        if (!(this.nombreField.getText().isEmpty())) {
            despensa.Proveedor proveedor = (despensa.Proveedor) this.proveedoresCombox.getSelectedItem();
            if (this.descripcionField.getText().isEmpty()) {
                despensa.DB.GestionProveedor.modificarProveedorSoloElNombreUpdate(this.nombreField.getText(), proveedor.getCodigo());
                Principal.actualizarInformacionTablaProveedores(GestionProveedor.tablaProveedores);
                Principal.actualizarComboBoxProveedor(proveedoresCombox);
                nombreField.setText(null);
                descripcionField.setText(null);
            }else{
            despensa.DB.GestionProveedor.modificarProveedorTodosLosCamposUpdate(this.nombreField.getText(),proveedor.getCodigo(), this.descripcionField.getText());
            Principal.actualizarInformacionTablaProveedores(GestionProveedor.tablaProveedores);
                Principal.actualizarComboBoxProveedor(proveedoresCombox);
                nombreField.setText(null);
                descripcionField.setText(null);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "nombre no puede ir vacio");
        }
    }//GEN-LAST:event_modificarProveedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descripcionField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarProveedor;
    private javax.swing.JTextField nombreField;
    private javax.swing.JComboBox<String> proveedoresCombox;
    // End of variables declaration//GEN-END:variables
}
