/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdmRack.java
 *
 * Created on Oct 2, 2011, 3:29:20 PM
 */
package Mantenimientos.Rack;

import BusinessEntity.RackBE;
import BusinessLogic.RackBL;
import BusinessLogic.UbicacionBL;
import BusinessLogic.ZonaBL;
import DataAccess.RackDA;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class AdmRack extends javax.swing.JFrame {

    /** Creates new form AdmRack */
    ArrayList<RackBE> arrRacks;
    String strIdRack;
    
    public AdmRack() {
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
        dgvRacks = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        lblRegistrarRack = new javax.swing.JLabel();
        lblModificarRack = new javax.swing.JLabel();
        lblEliminarRack = new javax.swing.JLabel();
        lblBuscarRack = new javax.swing.JLabel();
        lblCargarRacks = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Administrar rack");

        dgvRacks.setAutoCreateRowSorter(true);
        dgvRacks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Rack", "Posición X", "Posición Y", "Pisos", "Columnas", "Identificador Zona"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Byte.class, java.lang.Byte.class, java.lang.String.class
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
        jScrollPane1.setViewportView(dgvRacks);
        dgvRacks.getColumnModel().getColumn(0).setPreferredWidth(50);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        lblRegistrarRack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_page.png"))); // NOI18N
        lblRegistrarRack.setToolTipText("Agregar");
        lblRegistrarRack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRegistrarRack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegistrarRack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegistrarRackMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRegistrarRackMousePressed(evt);
            }
        });
        jToolBar1.add(lblRegistrarRack);

        lblModificarRack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/download.png"))); // NOI18N
        lblModificarRack.setToolTipText("Editar");
        lblModificarRack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblModificarRack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblModificarRack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModificarRackMouseClicked(evt);
            }
        });
        jToolBar1.add(lblModificarRack);

        lblEliminarRack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete_page.png"))); // NOI18N
        lblEliminarRack.setToolTipText("Eliminar");
        lblEliminarRack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblEliminarRack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminarRack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminarRackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEliminarRackMouseEntered(evt);
            }
        });
        jToolBar1.add(lblEliminarRack);

        lblBuscarRack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_page.png"))); // NOI18N
        lblBuscarRack.setToolTipText("Buscar");
        lblBuscarRack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBuscarRack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBuscarRack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarRackMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBuscarRackMousePressed(evt);
            }
        });
        jToolBar1.add(lblBuscarRack);

        lblCargarRacks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh.png"))); // NOI18N
        lblCargarRacks.setToolTipText("Refrescar");
        lblCargarRacks.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblCargarRacks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCargarRacks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCargarRacksMouseClicked(evt);
            }
        });
        jToolBar1.add(lblCargarRacks);

        jLabel7.setText("                                                                                                   ");
        jToolBar1.add(jLabel7);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info.png"))); // NOI18N
        jToolBar1.add(jLabel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
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

private void lblRegistrarRackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarRackMousePressed

}//GEN-LAST:event_lblRegistrarRackMousePressed

private void lblBuscarRackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarRackMousePressed

}//GEN-LAST:event_lblBuscarRackMousePressed

private void lblRegistrarRackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarRackMouseClicked
    MantenimientoRack frmManteminiento = new MantenimientoRack('R',this);
    frmManteminiento.setVisible(true);
}//GEN-LAST:event_lblRegistrarRackMouseClicked

private void lblModificarRackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificarRackMouseClicked
    int fila;
    fila = dgvRacks.getSelectedRow();
    if (fila==-1)
        JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna celda", "Error", 0);
    else{
        String strIdentificador = (String)dgvRacks.getValueAt(fila, 0);
        RackBL objRackBL = new RackBL();
        strIdRack = objRackBL.getByIdentificador(strIdentificador).getIdRack();
        MantenimientoRack frmManteminiento = new MantenimientoRack('M',strIdRack,this);
        frmManteminiento.setVisible(true);
    }
}//GEN-LAST:event_lblModificarRackMouseClicked

private void lblEliminarRackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarRackMouseClicked
    int answer = JOptionPane.showConfirmDialog(null, "La eliminación será irreversible. ¿Desea continuar?");
    if (answer != 0)
        return;
    int fila;
    boolean boolExito;
    fila = dgvRacks.getSelectedRow();
    if (fila==-1)
        JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna celda", "Error", 0);
    else{

        String strIdentificador = (String)dgvRacks.getValueAt(fila, 0);
        RackBL objRackBL = new RackBL();
        strIdRack = objRackBL.getByIdentificador(strIdentificador).getIdRack();
        UbicacionBL objUbicacionBL = new UbicacionBL();
        
        if (objUbicacionBL.getCantUbicacionesOcupadas(strIdRack) > 0){
            JOptionPane.showMessageDialog(null, objUbicacionBL.getCantUbicacionesOcupadas(strIdRack));
            JOptionPane.showMessageDialog(null, "No se puede eliminar el rack. Existen ubicaciones en uso o bloqueadas");
            return;       
        }
        
        objUbicacionBL.eliminarUbicacionesByRack(strIdRack);
        
        boolExito = objRackBL.eliminar(strIdRack);
        
        if (boolExito){
            borrarFilaDgv(fila);
        }
    }
}//GEN-LAST:event_lblEliminarRackMouseClicked

private void lblBuscarRackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarRackMouseClicked
    BuscarRack frmBusqueda = new BuscarRack(this);
    frmBusqueda.setVisible(true);
}//GEN-LAST:event_lblBuscarRackMouseClicked

private void lblCargarRacksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCargarRacksMouseClicked
    RackBL objRackBL = new RackBL();
    ArrayList<RackBE> arrRacks = objRackBL.getAllRack();
    llenarDgv(arrRacks);
}//GEN-LAST:event_lblCargarRacksMouseClicked

private void lblEliminarRackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarRackMouseEntered

}//GEN-LAST:event_lblEliminarRackMouseEntered

    public void llenarDgv(ArrayList<RackBE> arrRacks){
        
        DefaultTableModel modelo=(DefaultTableModel) dgvRacks.getModel();    
        this.limpiarDgv();
        this.arrRacks = arrRacks;
        
        for (int i=0; i<arrRacks.size(); i++){
            
            String strIdentificador = arrRacks.get(i).getIdentificador();
            int intPosX = arrRacks.get(i).getPosX();
            int intPosY = arrRacks.get(i).getPosY();
            int intPisos = arrRacks.get(i).getPisos();
            int intColumnas = arrRacks.get(i).getColumnas();
            String strIdZona = arrRacks.get(i).getIdZona();
            ZonaBL objZonaBL = new ZonaBL();
            String strIdentificadorZona = objZonaBL.getZona(strIdZona).getIdentificador();

            modelo.addRow(new Object[]{strIdentificador,intPosX, intPosY,intPisos,intColumnas,strIdentificadorZona});
            
        }
    }
    
    public void borrarFilaDgv(int intFila){
        
        DefaultTableModel modelo=(DefaultTableModel) dgvRacks.getModel();   
        modelo.removeRow(intFila);
        
    }
    
    public void limpiarDgv(){
                
        DefaultTableModel modelo=(DefaultTableModel) dgvRacks.getModel();    
        for(int i=modelo.getRowCount()-1; i>=0; i--){
            modelo.removeRow(i);
        }
    }
    
    
    public void actualizaDgv(RackBE rackBE){

        DefaultTableModel modelo=(DefaultTableModel) dgvRacks.getModel();  
        this.limpiarDgv();
        String strIdentificador = rackBE.getIdentificador();
        int intPosX = rackBE.getPosX();
        int intPosY = rackBE.getPosY();
        int intPisos = rackBE.getPisos();
        int intColumnas = rackBE.getColumnas();
        String strIdZona = rackBE.getIdZona();
        ZonaBL objZonaBL = new ZonaBL();
        String strIdentificadorZona = objZonaBL.getZona(strIdZona).getIdentificador();
        
        modelo.addRow(new Object[]{strIdentificador,intPosX, intPosY,intPisos,intColumnas,strIdentificadorZona});
        
    }
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
            java.util.logging.Logger.getLogger(AdmRack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmRack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmRack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmRack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AdmRack().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dgvRacks;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblBuscarRack;
    private javax.swing.JLabel lblCargarRacks;
    private javax.swing.JLabel lblEliminarRack;
    private javax.swing.JLabel lblModificarRack;
    private javax.swing.JLabel lblRegistrarRack;
    // End of variables declaration//GEN-END:variables
}
