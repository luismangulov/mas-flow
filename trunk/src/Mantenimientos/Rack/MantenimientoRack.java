/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MantenimientoRack.java
 *
 * Created on Oct 2, 2011, 3:12:27 PM
 */
package Mantenimientos.Rack;

import BusinessEntity.RackBE;
import BusinessEntity.UbicacionBE;
import BusinessEntity.UnidadMedidaBE;
import BusinessEntity.ZonaBE;
import BusinessLogic.RackBL;
import BusinessLogic.UbicacionBL;
import BusinessLogic.ZonaBL;
import DataAccess.UnidadMedidaDA;
import DataAccess.ZonaDA;
import java.util.ArrayList;

/**
 *
 * @author DIEGO
 */
public class MantenimientoRack extends javax.swing.JFrame {

    /** Creates new form MantenimientoRack */
    ZonaDA objZonaDA;
    ArrayList<ZonaBE> arrZonas;
    String strIdRack;
    int intPosX;
    int intPosY;
    int intPisos;
    int intColumnas;
    String strIndActivo;
    String strIdZona;
    char accion;
    String idRack;
    RackBL objRackBL;
    RackBE objRackBE;
    String idAlmacen;
    String guardaIdZona;
    
    public MantenimientoRack(char c) {
        initComponents();
        this.cargarComboZona();
        this.accion = c;
    }
    
    public MantenimientoRack(char c, String idRack) {
        this.accion = c;
        if (c=='M'){
            initComponents();
            objRackBL = new RackBL();
            objRackBE = objRackBL.getByIdRack(idRack);
            this.setVisible(true);
            this.cargarComponentes(objRackBE);
        }
        else eliminar(idRack);
    }
    
    private void cargarComboZona(){
        
        objZonaDA = new ZonaDA();
        arrZonas = new ArrayList<ZonaBE>();
        arrZonas = objZonaDA.queryAllFamilia();
        for(ZonaBE zona : arrZonas)
            cbZona.addItem(zona.getIdentificador());
        
    }
    
    
    private void cargarComponentes(RackBE objRackBE){
        
        objZonaDA = new ZonaDA();
        txtIdRack.setText(objRackBE.getIdRack());
        txtPosX.setText(String.valueOf(objRackBE.getPosX()));
        txtPosY.setText(String.valueOf(objRackBE.getPosY()));
        txtPisos.setText(String.valueOf(objRackBE.getPisos()));
        txtColumnas.setText(String.valueOf(objRackBE.getColumnas()));
        
        if (objRackBE.getIndActivo() == "1")
            chbxActivo.setSelected(true);
        else
            chbxActivo.setSelected(false);
        cargarComboZona();
        
        for(int i=0; i<cbZona.getSize().width; i++){
            String strIdentificadorZona = objZonaDA.queryByIdZona(objRackBE.getIdZona()).getIdentificador();
            if(cbZona.getItemAt(i).toString().equals(strIdentificadorZona)){
                cbZona.setSelectedIndex(i);
                break;
            }
        }
        guardaIdZona = cbZona.getSelectedItem().toString();
    }
    
    private void insertar(){
        
        chbxActivo.setEnabled(false);
        strIdRack = txtIdRack.getText();
        intPosX = Integer.valueOf(txtPosX.getText());
        intPosY = Integer.valueOf(txtPosY.getText());
        intPisos = Integer.valueOf(txtPisos.getText());
        intColumnas = Integer.valueOf(txtColumnas.getText());
        strIndActivo = "1";
        ZonaBL objZonaBL = new ZonaBL();
        strIdZona = objZonaBL.getByIdentificadorZona(cbZona.getSelectedItem().toString()).getIdZona();
        objRackBL = new RackBL();
        objRackBE = new RackBE("",intPosX, intPosY, intPisos, intColumnas, strIndActivo, strIdZona, "");
        objRackBL.insertar(objRackBE);
        
        UbicacionBL objUbicacionBL = new UbicacionBL();
        UbicacionBE objUbicacionBE;
        
        for (int i=1; i<=objRackBE.getPisos(); i++)
            
            for (int j=1; j<=objRackBE.getColumnas(); j++){
                
                objUbicacionBE = new UbicacionBE();
                objUbicacionBE.setFila(i);
                objUbicacionBE.setColumna(j);
                objUbicacionBE.setIdRack(objRackBE.getIdRack());
                objUbicacionBE.setIndActivo("1");
                
                objUbicacionBL.insertar(objUbicacionBE);
                
            }

    }
    
    private void modificar(){
        boolean cambioZona = false;
        if (!strIdZona.equals(cbZona.getSelectedItem().toString()))
            cambioZona = true;
        strIdRack = txtIdRack.getText();
        intPosX = Integer.valueOf(txtPosX.getText());
        intPosY = Integer.valueOf(txtPosY.getText());
        intPisos = Integer.valueOf(txtPisos.getText());
        intColumnas = Integer.valueOf(txtColumnas.getText());
        if (chbxActivo.isSelected())
            strIndActivo = "1";
        else 
            strIndActivo = "0";
        ZonaBL objZonaBL = new ZonaBL();
        strIdZona = objZonaBL.getByIdentificadorZona(cbZona.getSelectedItem().toString()).getIdZona();
        objRackBL = new RackBL();
        objRackBE = new RackBE(strIdRack,intPosX, intPosY, intPisos, intColumnas, strIndActivo, strIdZona, "");
        
        objRackBL.modificar(objRackBE,cambioZona);        
        
    }
    
    private void eliminar(String idRack){
        
        objRackBL = new RackBL();
        objRackBL.eliminar(idRack);
        
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
        txtIdRack = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPosX = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPosY = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPisos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtColumnas = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbZona = new javax.swing.JComboBox();
        chbxActivo = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow -  Registrar rack");

        jLabel1.setText("Código:");

        jLabel2.setText("Posición X:");

        txtPosX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPosXActionPerformed(evt);
            }
        });

        jLabel4.setText("Posición Y:");

        txtPosY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPosYActionPerformed(evt);
            }
        });

        jLabel6.setText("Pisos:");

        txtPisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPisosActionPerformed(evt);
            }
        });

        jLabel8.setText("Columnas:");

        txtColumnas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColumnasActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setMaximumSize(new java.awt.Dimension(75, 23));
        btnGuardar.setMinimumSize(new java.awt.Dimension(75, 23));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel7.setText("Zona:");

        cbZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbZonaActionPerformed(evt);
            }
        });

        chbxActivo.setText("Activo");
        chbxActivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chbxActivoMouseClicked(evt);
            }
        });
        chbxActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxActivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdRack, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbZona, 0, 230, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPosX, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPisos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPosY, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(14, 14, 14))))
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(chbxActivo)
                .addContainerGap(303, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdRack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPosX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtPisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPosY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(chbxActivo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-378)/2, (screenSize.height-357)/2, 378, 357);
    }// </editor-fold>//GEN-END:initComponents

private void txtPosXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPosXActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtPosXActionPerformed

private void txtPosYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPosYActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtPosYActionPerformed

private void txtPisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPisosActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtPisosActionPerformed

private void txtColumnasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColumnasActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtColumnasActionPerformed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_btnCancelarActionPerformed

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    
    if (accion == 'R')
        this.insertar();
    else if (accion == 'M')
        this.modificar();
    
}//GEN-LAST:event_btnGuardarActionPerformed

private void cbZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbZonaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_cbZonaActionPerformed

private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
    this.dispose();
}//GEN-LAST:event_btnCancelarMouseClicked

private void chbxActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxActivoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_chbxActivoActionPerformed

private void chbxActivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chbxActivoMouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_chbxActivoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MantenimientoRack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoRack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoRack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoRack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
//                new MantenimientoRack().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbZona;
    private javax.swing.JCheckBox chbxActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtColumnas;
    private javax.swing.JTextField txtIdRack;
    private javax.swing.JTextField txtPisos;
    private javax.swing.JTextField txtPosX;
    private javax.swing.JTextField txtPosY;
    // End of variables declaration//GEN-END:variables
}
