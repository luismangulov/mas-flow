/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MantenimientoFamiliaProd.java
 *
 * Created on Oct 2, 2011, 3:17:43 PM
 */
package Mantenimientos.FamiliaProd;

import BD.Utilitario;
import BusinessEntity.FamiliaBE;
import BusinessLogic.FamiliaBL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DIEGO
 */
public class MantenimientoFamiliaProd extends javax.swing.JFrame {
    
    private AdmFamiliaProd objPadre;
    private String accion;
    /** Creates new form MantenimientoFamiliaProd */
    public MantenimientoFamiliaProd(AdmFamiliaProd padre) {
        this.objPadre = padre;
        accion = "registrar";
        initComponents();
        this.setVisible(true);
    }

     public MantenimientoFamiliaProd(AdmFamiliaProd padre,FamiliaBE familia) {
        this.objPadre = padre;
        accion = "modificar";
        initComponents();
        this.setVisible(true);
        this.txtCodigo.setText(familia.getIdFamilia());
        this.txtNombre.setText(familia.getNombre());
        this.txtDescripcion.setText(familia.getDescripcion());
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbxActivo = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Registrar familia de productos");

        txtCodigo.setEditable(false);

        jLabel2.setText("Nombre:");

        jLabel3.setText("Descripción:");

        jLabel1.setText("Código:");

        txtNombre.setName("lblNombre"); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtDescripcion.setName("lblDescripcion"); // NOI18N
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setName("btnGuardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cbxActivo.setSelected(true);
        cbxActivo.setText("Activo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(28, 28, 28)
                .addComponent(btnCancelar)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxActivo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDescripcion)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(cbxActivo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
// TODO add your handling code here:
    FamiliaBL objFamiliaBL = new FamiliaBL();
    if(this.valida()){    
        try {
                 if(this.accion.equals("registrar")){
                    String estado;
                    if(this.cbxActivo.isSelected()){
                        estado = "1";
                    }else estado = "0";       
                    objFamiliaBL.insertar(this.txtNombre.getText(), this.txtDescripcion.getText(),estado);
                    FamiliaBE familia;
                    familia = objFamiliaBL.getFamilia();
                    this.objPadre.recargaruno(familia);
                    this.dispose();
                 }
                 if(this.accion.equals("modificar")){
                     FamiliaBE familia = null;
                     String estado;
                    if(this.cbxActivo.isSelected()){
                        estado = "1";
                    }else estado = "0";   
                     familia = objFamiliaBL.setFamilia(this.txtCodigo.getText(), this.txtNombre.getText(), this.txtDescripcion.getText(),estado);
                     //familia = new FamiliaBE(this.txtCodigo.getText(), this.txtNombre.getText(), this.txtDescripcion.getText(),"1");
                     objFamiliaBL.modificar(familia);
                     int fila;
                     fila = this.objPadre.getDgvFamilia().getSelectedRow();
                     this.objPadre.getDgvFamilia().removeRowSelectionInterval(fila, fila);
                     this.objPadre.getDgvFamilia().setValueAt(familia.getIdFamilia(), fila, 0);
                     this.objPadre.getDgvFamilia().setValueAt(familia.getNombre(), fila, 1);
                     this.objPadre.getDgvFamilia().setValueAt(familia.getDescripcion(), fila, 2);
                     if(familia.getEstado().equals("1")){
                          this.objPadre.getDgvFamilia().setValueAt("Activo", fila, 3);
                      }else if(familia.getEstado().equals("0")){
                         this.objPadre.getDgvFamilia().setValueAt("Inactivo", fila, 3);
                      }
                     this.dispose();
                 }
            } catch (Exception ex) {
                Logger.getLogger(MantenimientoFamiliaProd.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
       if (!Utilitario.validarCadenaAlfabetica(evt.getKeyChar()))
            evt.consume();
       if ((this.txtNombre.getText().length() + 1) > 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        // TODO add your handling code here:
       if (!Utilitario.validarCadenaAlfabetica(evt.getKeyChar()))
            evt.consume();
       if ((this.txtDescripcion.getText().length() + 1) > 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped

    
    private boolean valida(){
        boolean esValido = true;

        if(this.txtNombre.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre de la familia de producto", "Error",0);
            esValido = false;
        }

        if(this.txtDescripcion.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar la descripcion de la familia de producto", "Error",0);
            esValido = false;
        }

        return esValido;
    }
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoFamiliaProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoFamiliaProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoFamiliaProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoFamiliaProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new MantenimientoFamiliaProd().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox cbxActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
