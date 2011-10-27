/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MantenimientoPallet.java
 *
 * Created on Oct 2, 2011, 3:27:45 PM
 */
package Mantenimientos.Pallet;

import BusinessEntity.AlmacenBE;
import BusinessEntity.PalletBE;
import BusinessLogic.AlmacenBL;
import BusinessLogic.PalletBL;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author DIEGO
 */
public class MantenimientoPallet extends javax.swing.JFrame {

    /** Creates new form MantenimientoPallet */
    String strIdPallet;
    String strIdProducto;
    String strIndActivo;
    String strIdUbicacion;
    String strIdAlmacen;
    Date datfechaVencimiento;
    String strNombreAlmacen;
    ArrayList<AlmacenBE> arrAlmacenes;
    PalletBE objPalletBE;
    AlmacenBL objAlmacenBL;
    AlmacenBE objAlmacenBE;
    PalletBL objPalletBL;
    String idPalletSeleccionado;
    AdmPallet ventanaPadre;
    
    public MantenimientoPallet(AdmPallet ventanaPadre) {
        this.setLocationRelativeTo(null); 
        txtIdPallet.setEnabled(false);        
        initComponents();
        this.ventanaPadre = ventanaPadre;
        this.cargarComboAlmacen();
    }
    
//    public MantenimientoPallet(char accion, String idPallet) {
//        initComponents();
//        this.accion = accion;
//        this.idPalletSeleccionado = idPallet;
//
//        this.cargarComboAlmacen();
//    }
    
    public void cargarComboAlmacen(){
        objAlmacenBL = new AlmacenBL();
        arrAlmacenes = new ArrayList<AlmacenBE>();
        
        arrAlmacenes= objAlmacenBL.getAllAlmacenActivo();
        for(AlmacenBE objAlmacen : arrAlmacenes)
            cbAlmacen.addItem(objAlmacen.getIdAlmacen());
        
//        if (accion == 'M'){
//            for(int i=0; i<cbAlmacen.getSize().width-1; i++){
//                String strAlmacen = objAlmacenBL.getAlmacenById(objPalletBE.getIdAlmacen()).getNombre();
//                if(cbAlmacen.getItemAt(i).toString().equals(strAlmacen)){
//                    cbAlmacen.setSelectedIndex(i);
//                    break;
//                }
//            }    
//        }
    }
    
    public void insertar(){
        
        strIndActivo = "1";
        objAlmacenBL = new AlmacenBL();
        strIdAlmacen = cbAlmacen.getSelectedItem().toString();
//        strIdAlmacen = objAlmacenBL.ge(strNombreAlmacen).getIdAlmacen();
        objPalletBE = new PalletBE("","",strIndActivo,"",strIdAlmacen,null);
        objPalletBL = new PalletBL();
        objPalletBL.insertar(objPalletBE); 
        
        ventanaPadre.actualizaDgv(objPalletBE);
        this.dispose();
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
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtIdPallet = new javax.swing.JTextField();
        cbAlmacen = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Registrar pallet");

        jLabel1.setText("Código:");

        jLabel2.setText("Almacén");

        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdPallet, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(cbAlmacen, 0, 147, Short.MAX_VALUE))
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdPallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked

        this.insertar();
}//GEN-LAST:event_btnGuardarMouseClicked

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
            java.util.logging.Logger.getLogger(MantenimientoPallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoPallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoPallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoPallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
//                new MantenimientoPallet().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbAlmacen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtIdPallet;
    // End of variables declaration//GEN-END:variables
}
