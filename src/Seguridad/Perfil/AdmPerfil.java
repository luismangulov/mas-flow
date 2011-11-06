/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdmPerfil.java
 *
 * Created on Oct 2, 2011, 3:55:46 PM
 */
package Seguridad.Perfil;

import BusinessEntity.PerfilBE;
import BusinessLogic.PerfilBL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class AdmPerfil extends javax.swing.JFrame {

    /** Creates new form AdmPerfil */
    public AdmPerfil() {
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
        dgvPerfil = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        lblAgregar = new javax.swing.JLabel();
        lblEditar = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        lblRefrescar = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Administrar perfil");

        dgvPerfil.setAutoCreateRowSorter(true);
        dgvPerfil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgvPerfil.setToolTipText("");
        dgvPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(dgvPerfil);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        lblAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_page.png"))); // NOI18N
        lblAgregar.setToolTipText("Agregar");
        lblAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAgregarMousePressed(evt);
            }
        });
        jToolBar1.add(lblAgregar);

        lblEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/download.png"))); // NOI18N
        lblEditar.setToolTipText("Editar");
        lblEditar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblEditarMousePressed(evt);
            }
        });
        jToolBar1.add(lblEditar);

        lblEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete_page.png"))); // NOI18N
        lblEliminar.setToolTipText("Eliminar");
        lblEliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblEliminarMousePressed(evt);
            }
        });
        jToolBar1.add(lblEliminar);

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_page.png"))); // NOI18N
        lblBuscar.setToolTipText("Buscar");
        lblBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
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
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void lblAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMousePressed
MantenimientoPerfil m = new MantenimientoPerfil(this);
m.setVisible(true);
// TODO add your handling code here:
}//GEN-LAST:event_lblAgregarMousePressed

private void lblEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMousePressed
// TODO add your handling code here:
       if((dgvPerfil.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado un perfil", "Mensaje",0);
        } else if((dgvPerfil.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado mas de un perfil", "Mensaje",0);
        }else{
            int fila;
            String codigo;
            fila = dgvPerfil.getSelectedRow();
            codigo = (String)dgvPerfil.getValueAt(fila, 0);
            PerfilBL objPerfilBL = new PerfilBL();
            PerfilBE perfil = objPerfilBL.queryByIdPerfil(codigo);
            MantenimientoPerfil m = new MantenimientoPerfil(this,perfil);
            m.setVisible(true);
        }
            

}//GEN-LAST:event_lblEditarMousePressed

private void lblBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMousePressed
// TODO add your handling code here:
        BuscarPerfil m = new BuscarPerfil(this);
        m.setVisible(true);


        
}//GEN-LAST:event_lblBuscarMousePressed

private void lblRefrescarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefrescarMousePressed
// TODO add your handling code here:
    PerfilBL objPerfilBL = new PerfilBL();
    this.recargar(objPerfilBL.queryAll());
}//GEN-LAST:event_lblRefrescarMousePressed

private void lblEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMousePressed
// TODO add your handling code here:
    
        int respuesta = 0;
        respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este perfil? Esta acción no podrá deshacerse.", "Eliminar perfil", 0); 
        if(respuesta == 0){
            int fila;
            String codigo;
            fila = dgvPerfil.getSelectedRow();
            codigo = (String)dgvPerfil.getValueAt(fila, 0);
            PerfilBL objPerfilBL = new PerfilBL();
            try {
                objPerfilBL.eliminar(codigo);
                this.lblRefrescarMousePressed(evt);
            } catch (Exception ex) {
                Logger.getLogger(AdmPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    
}//GEN-LAST:event_lblEliminarMousePressed

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
            java.util.logging.Logger.getLogger(AdmPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AdmPerfil().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dgvPerfil;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblRefrescar;
    // End of variables declaration//GEN-END:variables
    public javax.swing.JTable getDgvPerfil() {
        return dgvPerfil;
    }
    
    public void recargaruno(PerfilBE perfil){
//        DefaultTableModel modelo=(DefaultTableModel) dgvFamilia.getModel();
//        modelo.addRow(new Object[4]);
//        for(int i=0;i<dgvFamilia.getRowCount();i++){
//             dgvFamilia.remove(i);
//            dgvFamilia.removeRowSelectionInterval(i, i);
//        }
         
                   //
//          dgvFamilia.clearSelection(); 
         
        DefaultTableModel modelo= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;  
            }
        };
        dgvPerfil.setModel(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Estado");
        
        dgvPerfil.getColumnModel().getColumn(0).setPreferredWidth(40);
        dgvPerfil.getColumnModel().getColumn(1).setPreferredWidth(100);
        dgvPerfil.getColumnModel().getColumn(2).setPreferredWidth(120);
        
        modelo.addRow(new Object[3]);
        dgvPerfil.setValueAt(perfil.getIdPerfil(),0,0 );
        dgvPerfil.setValueAt(perfil.getDescripcion(),0,1 );
        
        if (perfil.getIndActivo().equals("1")){
            dgvPerfil.setValueAt("Activo",0,2 );
        }
        else
        {
            dgvPerfil.setValueAt("Inactivo",0,2 );
        }

    }
    
    public void recargar(ArrayList<PerfilBE> perfiles){
        DefaultTableModel modelo= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;  
            }
        };
        dgvPerfil.setModel(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Estado");
        
        dgvPerfil.getColumnModel().getColumn(0).setPreferredWidth(40);
        dgvPerfil.getColumnModel().getColumn(1).setPreferredWidth(100);
        dgvPerfil.getColumnModel().getColumn(2).setPreferredWidth(120);
        
        
//        DefaultTableModel modelo=(DefaultTableModel) dgvFamilia.getModel();
//        modelo.addRow(new Object[4]);
//          for(int i=0;i<dgvFamilia.getRowCount();i++){
//            dgvFamilia.remove(i);
//            dgvFamilia.removeRowSelectionInterval(i, i);
//        }
//          dgvFamilia.clearSelection();  
                    
        for(int i=0;i<perfiles.size();i++){
             modelo.addRow(new Object[3]);
            dgvPerfil.setValueAt(perfiles.get(i).getIdPerfil(),i,0 );
            dgvPerfil.setValueAt(perfiles.get(i).getDescripcion(),i,1 );
            
            if (perfiles.get(i).getIndActivo().equals("1")){
            dgvPerfil.setValueAt("Activo",i,2 );
            }
           else
            {
            dgvPerfil.setValueAt("Inactivo",i,2 );
             }  
        }
    }

}
