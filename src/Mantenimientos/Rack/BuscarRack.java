/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuscarRack.java
 *
 * Created on Oct 2, 2011, 3:29:35 PM
 */
package Mantenimientos.Rack;

import BusinessEntity.AlmacenBE;
import BusinessEntity.RackBE;
import BusinessEntity.ZonaBE;
import BusinessLogic.AlmacenBL;
import BusinessLogic.RackBL;
import BusinessLogic.ZonaBL;
import DataAccess.ZonaDA;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DIEGO
 */
public class BuscarRack extends javax.swing.JFrame {

    /** Creates new form BuscarRack */
    ArrayList<ZonaBE> arrZonas;
    ArrayList<RackBE> arrRacks;
    ZonaBL objZonaBL;
    ZonaDA objZonaDA;
    RackBL objRackBL;
    String strIdZona;
    String strIdRack;
    AdmRack ventanaPadre;
    String strIndActivo;
    AlmacenBL objAlmacenBL;
    
    
    public BuscarRack(AdmRack ventanaPadre) {
        initComponents();
        this.cargarComboAlmacen();
        this.ventanaPadre = ventanaPadre;
        chbxActivos.setSelected(true);
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
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtIdRack = new javax.swing.JTextField();
        cbZona = new javax.swing.JComboBox();
        chbxActivos = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        cbAlmacen = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Buscar rack");

        jLabel1.setText("Zona:");

        btnBuscar.setText(" Buscar ");
        btnBuscar.setMaximumSize(new java.awt.Dimension(75, 23));
        btnBuscar.setMinimumSize(new java.awt.Dimension(75, 23));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        jLabel2.setText("Rack:");

        cbZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbZonaActionPerformed(evt);
            }
        });

        chbxActivos.setText("Activos");

        jLabel3.setText("Almacén:");

        cbAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlmacenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chbxActivos)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdRack, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdRack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(chbxActivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cbZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbZonaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_cbZonaActionPerformed

private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        
        objAlmacenBL = new AlmacenBL();
        String strIdAlmacen = cbAlmacen.getSelectedItem().toString();
    
        objZonaBL = new ZonaBL();
        if (!cbZona.getSelectedItem().toString().equals(""))
            strIdZona = objZonaBL.getByIdentificadorZona(cbZona.getSelectedItem().toString()).getIdZona();
        else
            strIdZona = "";
        
        strIdRack = txtIdRack.getText();
        
        if (chbxActivos.isSelected())
            strIndActivo = "1";
        else 
            strIndActivo = "0";
            
        objRackBL = new RackBL();
        arrRacks = objRackBL.getListSearch(strIdAlmacen, strIdRack, strIdZona, strIndActivo);
        
        if (arrRacks.size()!=0){
            ventanaPadre.llenarDgv(arrRacks);
            this.dispose();
        }
        
        else
            JOptionPane.showMessageDialog(null, "No existen productos de dicho criterio", "Advertencia", 0);
}//GEN-LAST:event_btnBuscarMouseClicked

private void cbAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlmacenActionPerformed
        String strIdAlmacen = cbAlmacen.getSelectedItem().toString();
        cargarComboZona(strIdAlmacen);
        
}//GEN-LAST:event_cbAlmacenActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarRack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarRack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarRack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarRack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
//                new BuscarRack().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cbAlmacen;
    private javax.swing.JComboBox cbZona;
    private javax.swing.JCheckBox chbxActivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtIdRack;
    // End of variables declaration//GEN-END:variables

    private void cargarComboZona(String idAlmacen){
        
        cbZona.removeAllItems();

        ArrayList<ZonaBE> arrZonas = new ArrayList<ZonaBE>();
        objZonaBL = new ZonaBL();
        arrZonas = objZonaBL.getZonasByAlmacen(idAlmacen);
        
        cbZona.addItem("");
        
        if (arrZonas != null)
            for(ZonaBE zona : arrZonas)
                cbZona.addItem(zona.getIdentificador());
        
    }
    
    private void cargarComboAlmacen(){
        
        cbAlmacen.removeAllItems();
        cbZona.removeAllItems();
       
        ArrayList<AlmacenBE> arrAlmacenes = new ArrayList<AlmacenBE>();
        objAlmacenBL = new AlmacenBL();
        arrAlmacenes = objAlmacenBL.getAllAlmacenActivo();
        
        if (arrAlmacenes != null)
            for(AlmacenBE almacen : arrAlmacenes)
                cbAlmacen.addItem(almacen.getIdAlmacen());

    }
}
