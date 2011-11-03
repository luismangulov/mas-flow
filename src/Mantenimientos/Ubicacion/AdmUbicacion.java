/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdmUbicacion.java
 *
 * Created on Oct 2, 2011, 3:30:40 PM
 */
package Mantenimientos.Ubicacion;

import BusinessEntity.UbicacionBE;
import BusinessLogic.PalletBL;
import BusinessLogic.RackBL;
import BusinessLogic.UbicacionBL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VICTOR
 */


public class AdmUbicacion extends javax.swing.JFrame {

    ArrayList<UbicacionBE> arrUbicaciones;
    /** Creates new form AdmUbicacion */
    public AdmUbicacion() {
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
        dgvUbicaciones = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        lblBloquearUbicacion = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        lblRefrescar = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Administrar ubicación");

        dgvUbicaciones.setAutoCreateRowSorter(true);
        dgvUbicaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ubicación", "Rack", "Fila", "Columna", "Estado", "Pallet"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgvUbicaciones.setToolTipText("Reubicar Pallet");
        dgvUbicaciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        dgvUbicaciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(dgvUbicaciones);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        lblBloquearUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/lock.png"))); // NOI18N
        lblBloquearUbicacion.setToolTipText("Bloquear/Desbloquear");
        lblBloquearUbicacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBloquearUbicacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBloquearUbicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBloquearUbicacionMouseClicked(evt);
            }
        });
        jToolBar1.add(lblBloquearUbicacion);

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_page.png"))); // NOI18N
        lblBuscar.setToolTipText("Buscar");
        lblBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBuscarMousePressed(evt);
            }
        });
        jToolBar1.add(lblBuscar);

        lblRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh.png"))); // NOI18N
        lblRefrescar.setToolTipText("Refrescar");
        lblRefrescar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRefrescar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRefrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRefrescarMouseClicked(evt);
            }
        });
        jToolBar1.add(lblRefrescar);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("                                                                                                                                                               ");
        jToolBar1.add(jLabel7);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info.png"))); // NOI18N
        jToolBar1.add(jLabel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void lblBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMousePressed

}//GEN-LAST:event_lblBuscarMousePressed

private void lblBloquearUbicacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBloquearUbicacionMouseClicked
    int fila;
    fila = dgvUbicaciones.getSelectedRow();
    if (fila==-1)
        JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna celda", "Error", 0);
    else{
        String strIdUbicacion = (String)dgvUbicaciones.getValueAt(fila, 0);
        String strEstado = (String)dgvUbicaciones.getValueAt(fila, 4);
        String strIndActivo;
        // 0 bloqueada, 1 disponible, 2 en uso
        if (strEstado.equals("Disponible"))
            strIndActivo = "1";
        else if (strEstado.equals("Bloqueada"))
            strIndActivo = "0";
        else 
            strIndActivo = "2";
                    
        if (!strIndActivo.equals("2")){
            UbicacionBL objUbicacionBL = new UbicacionBL();
            objUbicacionBL.bloquearUbicacion(strIdUbicacion,strIndActivo);

            if (strIndActivo.equals("1"))
                removerFilaDgv(fila);
            else{
                arrUbicaciones = new ArrayList<UbicacionBE>();
                arrUbicaciones.add(objUbicacionBL.getUbicacionById(strIdUbicacion));
                llenarDgv(arrUbicaciones);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "No se puede bloquear la ubicación porque tiene un producto asociado");
    }
}//GEN-LAST:event_lblBloquearUbicacionMouseClicked

private void lblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMouseClicked
    BuscarUbicacion ventana = new BuscarUbicacion(this);
    ventana.setVisible(true);
}//GEN-LAST:event_lblBuscarMouseClicked

private void lblRefrescarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefrescarMouseClicked
    UbicacionBL objUbicacionBL = new UbicacionBL();
    llenarDgv(objUbicacionBL.getAll());
}//GEN-LAST:event_lblRefrescarMouseClicked

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
            java.util.logging.Logger.getLogger(AdmUbicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmUbicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmUbicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmUbicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AdmUbicacion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dgvUbicaciones;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblBloquearUbicacion;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblRefrescar;
    // End of variables declaration//GEN-END:variables

    public void llenarDgv(ArrayList<UbicacionBE> arrUbicaciones){

        DefaultTableModel modelo=(DefaultTableModel) dgvUbicaciones.getModel();    
        this.limpiarDgv();
        this.arrUbicaciones = arrUbicaciones;
        
        if (arrUbicaciones != null){
            
            for (int i=0; i<arrUbicaciones.size(); i++){

                String strIdUbicacion = arrUbicaciones.get(i).getIdUbicacion();
                String strIdRack = arrUbicaciones.get(i).getIdRack();
                
                RackBL objRackBL = new RackBL();
                String strIdentificadorRack = objRackBL.getByIdRack(strIdRack).getIdentificador();
                
                int intFila = arrUbicaciones.get(i).getFila();
                int intColumna = arrUbicaciones.get(i).getColumna();
                String strIndActivo = arrUbicaciones.get(i).getIndActivo();
                String strIdPallet;
                PalletBL objPalletBL = new PalletBL();
                if (objPalletBL.getPalletByIdUbicacion(strIdUbicacion) != null)
                    strIdPallet = objPalletBL.getPalletByIdUbicacion(strIdUbicacion).getIdPallet();
                else
                    strIdPallet = "";

                String strEstado;
                // 0 bloqueada, 1 disponible, 2 en uso
                if (strIndActivo.equals("0"))
                    strEstado = "Bloqueada";
                else if (strIndActivo.equals("1"))
                    strEstado = "Disponible";
                else
                    strEstado = "En uso";

                modelo.addRow(new Object[]{strIdUbicacion,strIdentificadorRack, intFila,intColumna,strEstado,strIdPallet});
            }
        }
    }
    
    public void limpiarDgv(){
                
        DefaultTableModel modelo=(DefaultTableModel) dgvUbicaciones.getModel();    
        for(int i=modelo.getRowCount()-1; i>=0; i--){
            modelo.removeRow(i);
        }
    }
    
    public void removerFilaDgv(int fila){
        
        DefaultTableModel modelo=(DefaultTableModel) dgvUbicaciones.getModel();    
        modelo.removeRow(fila);
        
    }


}
