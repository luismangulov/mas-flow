/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdmMovimientosInternos.java
 *
 * Created on Oct 2, 2011, 3:27:56 PM
 */
package Procesamiento.MovimientosInternos;

import BusinessEntity.MovimientoInternoBE;
import Procesamiento.MovimientosInternos.ReubicarPallet;
import BusinessEntity.PalletBE;
import BusinessEntity.ProductoBE;
import BusinessLogic.PalletBL;
import BusinessLogic.ProductoBL;
import BusinessLogic.RackBL;
import BusinessLogic.UbicacionBL;
import BusinessLogic.UnidadMedidaBL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class AdmMovimientosInternos extends javax.swing.JFrame {

    /** Creates new form AdmMovimientosInternos */
    ArrayList<PalletBE> arrPallets;
    private ArrayList<MovimientoInternoBE> arrMovimientoInterno;

    public AdmMovimientosInternos() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        dgvMovimientoInterno = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        lblRegistrarPallet = new javax.swing.JLabel();
        lblEliminarMovimientos = new javax.swing.JLabel();
        lblBuscarMovimientos = new javax.swing.JLabel();
        lblRefrescarMovimientos = new javax.swing.JLabel();
        lblReubicarPallet = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Administrar Movimientos");

        dgvMovimientoInterno.setAutoCreateRowSorter(true);
        dgvMovimientoInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Ubicación Origen", "Ubicación Destino", "Fecha Movimiento", "Descripción", "Cantidad", "Pallet", "Producto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dgvMovimientoInterno);
        dgvMovimientoInterno.getColumnModel().getColumn(0).setPreferredWidth(20);
        dgvMovimientoInterno.getColumnModel().getColumn(1).setPreferredWidth(40);
        dgvMovimientoInterno.getColumnModel().getColumn(2).setPreferredWidth(30);
        dgvMovimientoInterno.getColumnModel().getColumn(3).setPreferredWidth(25);
        dgvMovimientoInterno.getColumnModel().getColumn(4).setPreferredWidth(25);
        dgvMovimientoInterno.getColumnModel().getColumn(5).setPreferredWidth(20);
        dgvMovimientoInterno.getColumnModel().getColumn(6).setPreferredWidth(40);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        lblRegistrarPallet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_page.png"))); // NOI18N
        lblRegistrarPallet.setToolTipText("Agregar");
        lblRegistrarPallet.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRegistrarPallet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegistrarPallet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegistrarPalletMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRegistrarPalletMousePressed(evt);
            }
        });
        jToolBar1.add(lblRegistrarPallet);

        lblEliminarMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete_page.png"))); // NOI18N
        lblEliminarMovimientos.setToolTipText("Editar");
        lblEliminarMovimientos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblEliminarMovimientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminarMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminarMovimientosMouseClicked(evt);
            }
        });
        jToolBar1.add(lblEliminarMovimientos);

        lblBuscarMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_page.png"))); // NOI18N
        lblBuscarMovimientos.setToolTipText("Buscar");
        lblBuscarMovimientos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBuscarMovimientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBuscarMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBuscarMovimientosMousePressed(evt);
            }
        });
        jToolBar1.add(lblBuscarMovimientos);

        lblRefrescarMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh.png"))); // NOI18N
        lblRefrescarMovimientos.setToolTipText("Refrescar");
        lblRefrescarMovimientos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRefrescarMovimientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRefrescarMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRefrescarMovimientosMouseClicked(evt);
            }
        });
        jToolBar1.add(lblRefrescarMovimientos);

        lblReubicarPallet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back.png"))); // NOI18N
        lblReubicarPallet.setToolTipText("Reubicar Pallet");
        lblReubicarPallet.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblReubicarPallet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblReubicarPallet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReubicarPalletMouseClicked(evt);
            }
        });
        jToolBar1.add(lblReubicarPallet);

        jLabel7.setText("                                                                                                   ");
        jLabel7.setMaximumSize(new java.awt.Dimension(0, 0));
        jLabel7.setMinimumSize(new java.awt.Dimension(0, 0));
        jToolBar1.add(jLabel7);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info.png"))); // NOI18N
        jToolBar1.add(jLabel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void lblRegistrarPalletMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarPalletMousePressed

}//GEN-LAST:event_lblRegistrarPalletMousePressed

    private void lblBuscarMovimientosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMovimientosMousePressed

    }//GEN-LAST:event_lblBuscarMovimientosMousePressed

private void lblRegistrarPalletMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarPalletMouseClicked
    DesecharPalletsPorCaducidad ventana = new DesecharPalletsPorCaducidad(this);
    ventana.setVisible(true);
}//GEN-LAST:event_lblRegistrarPalletMouseClicked

private void lblEliminarMovimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMovimientosMouseClicked
    int fila;
    fila = dgvMovimientoInterno.getSelectedRow();
    if (fila==-1)
        JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna celda", "Error", 0);
    else{
        if (JOptionPane.showConfirmDialog(null, "La eliminación será permanente, ¿realmente desea realizar la acción?") == 0){
            String idPallet = (String)dgvMovimientoInterno.getValueAt(fila, 0);
            PalletBL objPalletBL = new PalletBL();
            objPalletBL.eliminar(idPallet);
//            eliminaFilaDgv(fila);
        }
    }
}//GEN-LAST:event_lblEliminarMovimientosMouseClicked

private void lblRefrescarMovimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefrescarMovimientosMouseClicked
    PalletBL objPalletBL = new PalletBL();
//    llenarDgv(objPalletBL.getAll());
}//GEN-LAST:event_lblRefrescarMovimientosMouseClicked

private void lblReubicarPalletMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReubicarPalletMouseClicked

    ReubicarPallet ventana = new ReubicarPallet(this);
    ventana.setVisible(true);

}//GEN-LAST:event_lblReubicarPalletMouseClicked


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
            java.util.logging.Logger.getLogger(AdmMovimientosInternos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmMovimientosInternos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmMovimientosInternos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmMovimientosInternos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AdmMovimientosInternos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dgvMovimientoInterno;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblBuscarMovimientos;
    private javax.swing.JLabel lblEliminarMovimientos;
    private javax.swing.JLabel lblRefrescarMovimientos;
    private javax.swing.JLabel lblRegistrarPallet;
    private javax.swing.JLabel lblReubicarPallet;
    // End of variables declaration//GEN-END:variables

    public void llenarDgv(ArrayList<MovimientoInternoBE> arrMovimientoInterno){
        
        DefaultTableModel modelo=(DefaultTableModel) dgvMovimientoInterno.getModel();    
        limpiarDgv();
        this.arrMovimientoInterno = arrMovimientoInterno;
        
        PalletBL objPalletBL = new PalletBL();
        ProductoBL objProductoBL = new ProductoBL();

        for (int i=0; i<arrMovimientoInterno.size(); i++){

            String strIdMovimientoInterno = arrMovimientoInterno.get(i).getIdMovimiento();
            String strIdUbicacionOrigen = arrMovimientoInterno.get(i).getIdUbicacionOrigen();
            String strIdUbicacionDestino = arrMovimientoInterno.get(i).getIdUbicacionDestino();
            String strFecha = arrMovimientoInterno.get(i).getFecha().toString();
            String strDescripcion = arrMovimientoInterno.get(i).getDescripcion();
            String strIdPallet = arrMovimientoInterno.get(i).getIdPallet();

            String strIdProducto = objPalletBL.getPallet(strIdPallet).getIdProducto();

            ProductoBE objProductoBE = objProductoBL.getByIdProducto(strIdProducto);
            String strNombreProducto = objProductoBE.getNombre();
            int intCantidad = objProductoBE.getMaxCantPorPallet();

            modelo.addRow(new Object[]{strIdMovimientoInterno,strIdUbicacionOrigen,strIdUbicacionDestino,strFecha,strDescripcion,intCantidad,strNombreProducto,strIdPallet});
        }
        
    }
    
    public void limpiarDgv(){
                
        DefaultTableModel modelo=(DefaultTableModel) dgvMovimientoInterno.getModel();    
        for(int i=modelo.getRowCount()-1; i>=0; i--){
            modelo.removeRow(i);
        }
    }
    
    public void eliminaFilaDgv(int fila){
        
        DefaultTableModel modelo=(DefaultTableModel) dgvMovimientoInterno.getModel();  
        modelo.removeRow(fila);
        
    }
    
    public void actualizarDgv(MovimientoInternoBE objMovimientoInternoBE){
        
        DefaultTableModel modelo=(DefaultTableModel) dgvMovimientoInterno.getModel();    
        limpiarDgv();
       
        PalletBL objPalletBL = new PalletBL();
        ProductoBL objProductoBL = new ProductoBL();
       
        String strIdMovimientoInterno = objMovimientoInternoBE.getIdMovimiento();
        String strIdUbicacionOrigen = objMovimientoInternoBE.getIdUbicacionOrigen();
        String strIdUbicacionDestino = objMovimientoInternoBE.getIdUbicacionDestino();
        String strFecha = objMovimientoInternoBE.getFecha().toString();
        String strDescripcion = objMovimientoInternoBE.getDescripcion();
        String strIdPallet = objMovimientoInternoBE.getIdPallet();

        String strIdProducto = objPalletBL.getPallet(strIdPallet).getIdProducto();

        ProductoBE objProductoBE = objProductoBL.getByIdProducto(strIdProducto);
        String strNombreProducto = objProductoBE.getNombre();
        int intCantidad = objProductoBE.getMaxCantPorPallet();

        modelo.addRow(new Object[]{strIdMovimientoInterno,strIdUbicacionOrigen,strIdUbicacionDestino,strFecha,strDescripcion,intCantidad,strNombreProducto,strIdPallet});

    }
}
