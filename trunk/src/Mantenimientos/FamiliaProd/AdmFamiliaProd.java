/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdmFamiliaProd.java
 *
 * Created on Oct 2, 2011, 3:17:57 PM
 */
package Mantenimientos.FamiliaProd;

import BusinessEntity.FamiliaBE;
import BusinessLogic.FamiliaBL;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class AdmFamiliaProd extends javax.swing.JFrame {

    /** Creates new form AdmFamiliaProd */
    public AdmFamiliaProd() {
        initComponents();
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
        dgvFamilia = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        lblInsertar = new javax.swing.JLabel();
        lblEditar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        lblRefrescar = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Administrar familia de producto");

        dgvFamilia.setAutoCreateRowSorter(true);
        dgvFamilia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Descripción", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dgvFamilia);

        jToolBar1.setRollover(true);

        lblInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_page.png"))); // NOI18N
        lblInsertar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInsertarMousePressed(evt);
            }
        });
        jToolBar1.add(lblInsertar);

        lblEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/download.png"))); // NOI18N
        lblEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblEditarMousePressed(evt);
            }
        });
        jToolBar1.add(lblEditar);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete_page.png"))); // NOI18N
        jToolBar1.add(jLabel3);

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_page.png"))); // NOI18N
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBuscarMousePressed(evt);
            }
        });
        jToolBar1.add(lblBuscar);

        lblRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh.png"))); // NOI18N
        lblRefrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRefrescarMousePressed(evt);
            }
        });
        jToolBar1.add(lblRefrescar);

        jLabel7.setText("                                                                                                   ");
        jToolBar1.add(jLabel7);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info.png"))); // NOI18N
        jToolBar1.add(jLabel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void lblInsertarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInsertarMousePressed
MantenimientoFamiliaProd m = new MantenimientoFamiliaProd(this);
m.setVisible(true);
// TODO add your handling code here:
}//GEN-LAST:event_lblInsertarMousePressed

    private void lblBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMousePressed
       BuscarFamiliaProd b = new BuscarFamiliaProd(this);
       b.setVisible(true);
    }//GEN-LAST:event_lblBuscarMousePressed

    private void lblRefrescarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefrescarMousePressed
        // TODO add your handling code here:
        FamiliaBL objFamiliaBL = new FamiliaBL();
        this.recargar(objFamiliaBL.queryAllFamilia());
    }//GEN-LAST:event_lblRefrescarMousePressed

    private void lblEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMousePressed
        // TODO add your handling code here:
//        if((dgvFamilia.getRowCount() == -1)){
//           
//        } else if((dgvFamilia.getRowCount() > 1)){
//            
//        }else{
            int fila;
            String codigo;
            fila = dgvFamilia.getSelectedRow();
            codigo = (String)dgvFamilia.getValueAt(fila, 0);
            FamiliaBL objFamiliaBL = new FamiliaBL();
            FamiliaBE familia = objFamiliaBL.queryByIdFamilia(codigo);
            MantenimientoFamiliaProd m = new MantenimientoFamiliaProd(this,familia);
            m.setVisible(true);
//        }
            
        
    }//GEN-LAST:event_lblEditarMousePressed

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
            java.util.logging.Logger.getLogger(AdmFamiliaProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmFamiliaProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmFamiliaProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmFamiliaProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AdmFamiliaProd().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dgvFamilia;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblInsertar;
    private javax.swing.JLabel lblRefrescar;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the dgvFamilia
     */
    public javax.swing.JTable getDgvFamilia() {
        return dgvFamilia;
    }
    
    public void recargaruno(FamiliaBE familia){
        DefaultTableModel modelo=(DefaultTableModel) dgvFamilia.getModel();
        modelo.addRow(new Object[4]);
        dgvFamilia.clearSelection();
        dgvFamilia.setValueAt(familia.getCodigo(),0,0 );
        dgvFamilia.setValueAt(familia.getNombre(),0,1 );
        dgvFamilia.setValueAt(familia.getDescripcion(),0,2 );
        if(familia.getEstado().equals("1")){
             dgvFamilia.setValueAt("Activo",0,3 );
        }else if(familia.getEstado().equals("0")){
             dgvFamilia.setValueAt("Inactivo",0,3 );
        }
    }
    
    public void recargar(ArrayList<FamiliaBE> familias){
        DefaultTableModel modelo=(DefaultTableModel) dgvFamilia.getModel();
        modelo.addRow(new Object[4]);
        dgvFamilia.clearSelection();
        for(int i=0;i<familias.size();i++){
            dgvFamilia.setValueAt(familias.get(i).getCodigo(),i,0 );
            dgvFamilia.setValueAt(familias.get(i).getNombre(),i,1 );
            dgvFamilia.setValueAt(familias.get(i).getDescripcion(),i,2 );
            if(familias.get(i).getEstado().equals("1")){
                dgvFamilia.setValueAt("Activo",i,3 );
            }else if(familias.get(i).getEstado().equals("0")){
                dgvFamilia.setValueAt("Inactivo",i,3 );
        }
        }
    }
}
