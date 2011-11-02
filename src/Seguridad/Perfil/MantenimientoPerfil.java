/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MantenimientoPerfil.java
 *
 * Created on Oct 2, 2011, 3:55:38 PM
 */
package Seguridad.Perfil;

import BusinessEntity.AplicacionxServicioBE;
import BusinessEntity.PerfilBE;
import BusinessEntity.PerfilDetalleBE;
import BusinessLogic.PerfilBL;
import DataAccess.AplicacionDA;
import DataAccess.AplicacionxServicioDA;
import DataAccess.PerfilDA;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.JScrollPane;


/**
 *
 * @author DIEGO
 */
public class MantenimientoPerfil extends javax.swing.JFrame {

    /** Creates new form MantenimientoPerfil */
    private AdmPerfil objPadre;
    private String accion;
    private JTree tree=new JTree();
    
    AplicacionxServicioDA objAplicacionxServicio =new AplicacionxServicioDA();
    ArrayList <AplicacionxServicioBE> lista = objAplicacionxServicio.queryAllAplicacionxServicio();   
    AplicacionDA objAplicacionDA =new AplicacionDA();
    int numAplicaciones= objAplicacionDA.queryAllAplicacion().size();
    Object[] rootNodes =new Vector[numAplicaciones];
  
       
    
    public MantenimientoPerfil(AdmPerfil padre) {
        this.objPadre = padre;
        accion = "registrar";
        
        for(int i = 0; i < numAplicaciones; i++) {
            int numServicios=lista.get(i).getListaServicios().size();
            CheckBoxNode[] checkBoxNodeVector =new CheckBoxNode[numServicios];
            for(int j = 0; j < numServicios; j++) {
            checkBoxNodeVector[j]=new CheckBoxNode(lista.get(i).getListaServicios().get(j).getIdDescripcion(),false);
            }
            Vector vectorAplicacion = new NamedVector(lista.get(i).getAplicacion().getDescripcion(),checkBoxNodeVector);
            rootNodes[i]=vectorAplicacion;   
        }
        
        Vector rootVector = new NamedVector("Root", rootNodes);
        tree = new JTree(rootVector);  
        CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();
        tree.setCellRenderer(renderer);
        tree.setCellEditor(new CheckBoxNodeEditor(tree));
        tree.setEditable(true);   
        
        initComponents();
        this.setLocationRelativeTo(null); 
        this.setTitle("+Flow - Registrar perfil");
        this.txtCodigo.setEnabled(false);
        this.setVisible(true);
    }

     public MantenimientoPerfil(AdmPerfil padre,PerfilBE perfil) {
        this.objPadre = padre;
        accion = "modificar";
        
       
        for(int i = 0; i < numAplicaciones; i++) {
            int numServicios=lista.get(i).getListaServicios().size();
            CheckBoxNode[] servicios =new CheckBoxNode[numServicios];
            for(int j = 0; j < numServicios; j++) {
            servicios[j]=new CheckBoxNode(lista.get(i).getListaServicios().get(j).getIdDescripcion(),false);
            }
            Vector aplicaciones = new NamedVector(lista.get(i).getAplicacion().getDescripcion(),servicios);
            rootNodes[i]=aplicaciones;   
        }
        
        Vector rootVector = new NamedVector("Root", rootNodes);
        tree = new JTree(rootVector);  
        CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();
        tree.setCellRenderer(renderer);
        tree.setCellEditor(new CheckBoxNodeEditor(tree));
        tree.setEditable(true); 
    
        
        initComponents();
             
        PerfilDA objPerfilDA =new PerfilDA();
        PerfilBE objPerfilBE=new PerfilBE();
        objPerfilBE=objPerfilDA.queryByIdPerfil(perfil.getIdPerfil());
        ArrayList <PerfilDetalleBE> listaDetallePerfil=objPerfilBE.getListaPerfilDetalle();
              
        for(int i = 0; i <numAplicaciones; i++) {
        //int numServicios=lista.get(i).getListaServicios().size();
        //CheckBoxNode[] checkBoxNodeVector =new CheckBoxNode[numServicios];        
            String aplicacion=rootNodes[i].toString().trim();
            System.out.println(aplicacion);
            
            Object servicios[]=new CheckBoxNode[rootNodes.length];
            
            for(int j = 0; j < 3; j++) {
                
                String servicio =servicios[j].toString().trim();
                
                System.out.println(aplicacion);
             //   String servicio = rootNodes[i][j].toString();
                
          //checkBoxNodeVector[j]=new CheckBoxNode(lista.get(i).getListaServicios().get(j).getIdDescripcion(),false);
                        
            
            
   
        //Vector vectorAplicacion = new NamedVector(lista.get(i).getAplicacion().getDescripcion(),checkBoxNodeVector);
        //rootNodes[i]=vectorAplicacion;   
             }
        }
        
       
        
        this.setLocationRelativeTo(null);
        this.cbxActivo.setEnabled(true);
        this.setTitle("+Flow - Editar perfil");
        this.txtCodigo.setEnabled(false);
        this.txtCodigo.setText(perfil.getIdPerfil());
        this.txtDescripcion.setText(perfil.getDescripcion());
        String idIndPerfil=perfil.getIndActivo().trim();
        if (idIndPerfil.equals("1"))
        {
            this.cbxActivo.setSelected(true);
         
        }else{
            this.cbxActivo.setSelected(false);
        }
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

        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbxActivo = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane(tree);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Registrar perfil");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Código:");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cbxActivo.setText("Activo");
        cbxActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxActivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cbxActivo))))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(cbxActivo)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
// TODO add your handling code here:
        PerfilBL objPerfilBL = new PerfilBL();
       
        try {
                 if(this.accion.equals("registrar")){
                    String estado;
                    if(this.cbxActivo.isSelected()){
                        estado = "1";
                    }else estado = "0";       
//                    objPerfilBL.insertar(this.txtDescripcion.getText(),estado);
                    PerfilBE perfil;
                    perfil = objPerfilBL.getPerfil();
                    this.objPadre.recargaruno(perfil);
                    this.dispose();
                 }
                 
                 if(this.accion.equals("modificar")){
                     PerfilBE perfil = null;
                     String estado;
                    if(this.cbxActivo.isSelected()){
                        estado = "1";
                    }else estado = "0";   
                     perfil = objPerfilBL.setPerfil(this.txtCodigo.getText(),this.txtDescripcion.getText(),estado);
                     //familia = new FamiliaBE(this.txtCodigo.getText(), this.txtNombre.getText(), this.txtDescripcion.getText(),"1");
//                     objPerfilBL.modificar(perfil);
                     int fila;
                     fila = this.objPadre.getDgvPerfil().getSelectedRow();
                     this.objPadre.getDgvPerfil().removeRowSelectionInterval(fila, fila);
                     this.objPadre.getDgvPerfil().setValueAt(perfil.getIdPerfil(), fila, 0);
                     this.objPadre.getDgvPerfil().setValueAt(perfil.getDescripcion(), fila, 1);
                   
                     if(perfil.getIndActivo().equals("1")){
                          this.objPadre.getDgvPerfil().setValueAt("Activo", fila, 2);
                      }else if(perfil.getIndActivo().equals("0")){
                         this.objPadre.getDgvPerfil().setValueAt("Inactivo", fila, 2);
                      }
                     this.dispose();
                 }
            } catch (Exception ex) {
                Logger.getLogger(MantenimientoPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
    

}//GEN-LAST:event_btnGuardarActionPerformed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
// TODO add your handling code here:
      this.dispose();
}//GEN-LAST:event_btnCancelarActionPerformed

private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtCodigoActionPerformed

private void cbxActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxActivoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_cbxActivoActionPerformed

private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
// TODO add your handling code here:
    
  
}//GEN-LAST:event_formWindowActivated

private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
// TODO add your handling code here:
    


}//GEN-LAST:event_formWindowGainedFocus

private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
// TODO add your handling code here:
}//GEN-LAST:event_formComponentShown

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
//            java.util.logging.Logger.getLogger(MantenimientoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new MantenimientoPerfil().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox cbxActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables

 

}
