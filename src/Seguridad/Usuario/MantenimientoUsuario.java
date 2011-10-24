/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MantenimientoUsuario.java
 *
 * Created on Oct 2, 2011, 3:57:16 PM
 */
package Seguridad.Usuario;

import BusinessEntity.UsuarioBE;
import BusinessLogic.UsuarioBL;
import java.util.logging.Logger;

/**
 *
 * @author DIEGO
 */
public class MantenimientoUsuario extends javax.swing.JFrame {

    /** Creates new form MantenimientoUsuario */
    private AdmUsuario objPadre;
    private String accion;
    
    public MantenimientoUsuario(AdmUsuario padre) {
        this.objPadre = padre;
        accion = "registrar";       
        initComponents();
        this.setLocationRelativeTo(null); 
        this.setTitle("+Flow - Registrar usuario");                        
        this.setVisible(true);
    }

    MantenimientoUsuario(AdmUsuario padre, UsuarioBE usuario) {
        this.objPadre = padre;
        accion = "modificar";
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.ckbActivo.setEnabled(true);
        this.setTitle("+Flow - Editar Usuario");
        this.txtIdUsuario.setText(usuario.getIdUsuario());
        this.txtNombre.setText(usuario.getNombre());
        this.txtPaterno.setText(usuario.getNombre());
        this.txtMaterno.setText(usuario.getNombre());
        //this.cbxPerfil.setSelectedIndex(usuario.getIdPerfil());               
        this.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIdUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbxPerfil = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPaterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMaterno = new javax.swing.JTextField();
        ckbActivo = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Registrar  usuario");

        jLabel1.setText("Usuario:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel3.setText("Perfil:");

        jLabel2.setText("Apellido Materno:");

        jLabel4.setText("Apellido Paterno:");

        jLabel5.setText("Nombres:");

        ckbActivo.setText("Activo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(ckbActivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE))
                            .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(ckbActivo)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
// TODO add your handling code here:
    UsuarioBL objUsuarioBL = new UsuarioBL();    
    
    try {
                 
        if(this.accion.equals("registrar")){
                    String estado;
                    if(this.ckbActivo.isSelected()){
                        estado = "1";
                    }else estado = "0";       
                    objUsuarioBL.insertar(this.txtNombre.getText(), this.txtNombre.getText(),this.txtMaterno,this.txtPaterno.getText(),this.cbxPerfil.getSelectedIndex(),estado,"");
                    UsuarioBE usuario;
                    usuario = objUsuarioBL.getUsuario();
                    this.objPadre.recargaruno(usuario);
                    this.dispose();
                 }
                 if(this.accion.equals("modificar")){
                     UsuarioBE usuario = null;
                     String estado;
                    if(this.ckbActivo.isSelected()){
                        estado = "1";
                    }else estado = "0";   
                     usuario = objUsuarioBL.setUsuario(this.txtCodigo.getText(), this.txtNombre.getText(), this.txtDescripcion.getText(),estado);
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

    
}//GEN-LAST:event_btnGuardarActionPerformed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
// TODO add your handling code here:
     this.dispose();
}//GEN-LAST:event_btnCancelarActionPerformed

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
//            java.util.logging.Logger.getLogger(MantenimientoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new MantenimientoUsuario().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbxPerfil;
    private javax.swing.JCheckBox ckbActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPaterno;
    // End of variables declaration//GEN-END:variables
}
