/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdmUsuario.java
 *
 * Created on Oct 2, 2011, 3:56:57 PM
 */
package Seguridad.Usuario;

import BusinessEntity.UsuarioBE;
import BusinessLogic.UsuarioBL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class AdmUsuario extends javax.swing.JFrame {

    /** Creates new form AdmUsuario */
    public AdmUsuario() {
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

        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        lblAgregar = new javax.swing.JLabel();
        lblEditar = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        lblRefrescar = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvUsuario = new javax.swing.JTable();

        jToolBar1.setRollover(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_page.png"))); // NOI18N
        jToolBar1.add(jLabel1);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/download.png"))); // NOI18N
        jToolBar1.add(jLabel2);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete_page.png"))); // NOI18N
        jToolBar1.add(jLabel3);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_page.png"))); // NOI18N
        jToolBar1.add(jLabel4);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh.png"))); // NOI18N
        jToolBar1.add(jLabel5);

        jLabel7.setText("                                                                                                   ");
        jToolBar1.add(jLabel7);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info.png"))); // NOI18N
        jToolBar1.add(jLabel6);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Administrar usuario");

        jToolBar2.setRollover(true);

        lblAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_page.png"))); // NOI18N
        lblAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAgregarMousePressed(evt);
            }
        });
        jToolBar2.add(lblAgregar);

        lblEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/download.png"))); // NOI18N
        lblEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblEditarMousePressed(evt);
            }
        });
        jToolBar2.add(lblEditar);

        lblEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete_page.png"))); // NOI18N
        lblEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblEliminarMousePressed(evt);
            }
        });
        jToolBar2.add(lblEliminar);

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_page.png"))); // NOI18N
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBuscarMousePressed(evt);
            }
        });
        jToolBar2.add(lblBuscar);

        lblRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh.png"))); // NOI18N
        lblRefrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRefrescarMousePressed(evt);
            }
        });
        jToolBar2.add(lblRefrescar);

        jLabel13.setText("                                                                                                   ");
        jToolBar2.add(jLabel13);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info.png"))); // NOI18N
        jToolBar2.add(jLabel14);

        dgvUsuario.setAutoCreateRowSorter(true);
        dgvUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Nombre", "Apellido Paterno", "Apellido Materno", "Perfil", "Estado "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Byte.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(dgvUsuario);
        dgvUsuario.getColumnModel().getColumn(1).setResizable(false);
        dgvUsuario.getColumnModel().getColumn(2).setResizable(false);
        dgvUsuario.getColumnModel().getColumn(4).setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void lblAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMousePressed
// TODO add your handling code here:
    
    MantenimientoUsuario m = new MantenimientoUsuario(this);
    m.setVisible(true);

}//GEN-LAST:event_lblAgregarMousePressed

private void lblEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMousePressed
// TODO add your handling code here:
        if((dgvUsuario.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado un usuario", "Mensaje",0);
        } else if((dgvUsuario.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado mas de un usuario", "Mensaje",0);
        }else{
            int fila;
            String codigo;
            fila = dgvUsuario.getSelectedRow();
            codigo = (String)dgvUsuario.getValueAt(fila, 0);
            UsuarioBL objUsuarioBL = new UsuarioBL();
            UsuarioBE usuario = objUsuarioBL.queryByIdUsuario(codigo);
            MantenimientoUsuario m = new MantenimientoUsuario(this,usuario);
            m.setVisible(true);
        }
}//GEN-LAST:event_lblEditarMousePressed

private void lblBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMousePressed
// TODO add your handling code here:
    BuscarUsuario m = new BuscarUsuario(this);
    m.setVisible(true);
}//GEN-LAST:event_lblBuscarMousePressed

private void lblEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMousePressed
// TODO add your handling code here:
           int respuesta = 0;
        respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este usuario? Esta acción no podrá deshacerse.", "Eliminar usuario", 0); 
        if(respuesta == 0){
            int fila;
            String codigo;
            fila = dgvUsuario.getSelectedRow();
            codigo = (String)dgvUsuario.getValueAt(fila, 0);
            UsuarioBL objUsuarioBL = new UsuarioBL();
            try {
                objUsuarioBL.eliminar(codigo);
                this.lblRefrescarMousePressed(evt);
            } catch (Exception ex) {
                Logger.getLogger(AdmUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
}//GEN-LAST:event_lblEliminarMousePressed

private void lblRefrescarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefrescarMousePressed
// TODO add your handling code here:
        UsuarioBL objUsuarioBL = new UsuarioBL();
        this.recargar(objUsuarioBL.queryAllUsuario());
}//GEN-LAST:event_lblRefrescarMousePressed

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
            java.util.logging.Logger.getLogger(AdmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AdmUsuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dgvUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblRefrescar;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTable getDgvUsuario() {
        return dgvUsuario;
    }
    
    public void recargaruno(UsuarioBE usuario){
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
         
        dgvUsuario.setModel(modelo);
        modelo.addColumn("IdUsuario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno"); 
        modelo.addColumn("Perfil"); 
        modelo.addColumn("Estado");         
        dgvUsuario.getColumnModel().getColumn(0).setPreferredWidth(40);
        dgvUsuario.getColumnModel().getColumn(1).setPreferredWidth(100);
        dgvUsuario.getColumnModel().getColumn(2).setPreferredWidth(100);
        dgvUsuario.getColumnModel().getColumn(3).setPreferredWidth(100);
        dgvUsuario.getColumnModel().getColumn(4).setPreferredWidth(40);
        dgvUsuario.getColumnModel().getColumn(5).setPreferredWidth(40);
        modelo.addRow(new Object[6]);
        dgvUsuario.setValueAt(usuario.getIdUsuario(),0,0 );
        dgvUsuario.setValueAt(usuario.getNombre(),0,1 );
        dgvUsuario.setValueAt(usuario.getPaterno(),0,2 );
        dgvUsuario.setValueAt(usuario.getMaterno(),0,3 );
        dgvUsuario.setValueAt(usuario.getPerfil().getDescripcion(),0,4 ); 
        dgvUsuario.setValueAt(usuario.getEstadoUsuario().getDescripcion(),0,5 );
        
    }
    
    public void recargar(ArrayList<UsuarioBE> usuarios){
        
        DefaultTableModel modelo= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;  
            }
        };
        dgvUsuario.setModel(modelo);
        modelo.addColumn("IdUsuario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno"); 
        modelo.addColumn("Perfil"); 
        modelo.addColumn("Estado"); 
        
        dgvUsuario.getColumnModel().getColumn(0).setPreferredWidth(40);
        dgvUsuario.getColumnModel().getColumn(1).setPreferredWidth(100);
        dgvUsuario.getColumnModel().getColumn(2).setPreferredWidth(100);
        dgvUsuario.getColumnModel().getColumn(3).setPreferredWidth(100);
        dgvUsuario.getColumnModel().getColumn(4).setPreferredWidth(40);
        dgvUsuario.getColumnModel().getColumn(5).setPreferredWidth(40);
        
//        DefaultTableModel modelo=(DefaultTableModel) dgvFamilia.getModel();
//        modelo.addRow(new Object[4]);
//          for(int i=0;i<dgvFamilia.getRowCount();i++){
//            dgvFamilia.remove(i);
//            dgvFamilia.removeRowSelectionInterval(i, i);
//        }
//          dgvFamilia.clearSelection();  
                    
        for(int i=0;i<usuarios.size();i++){
            
        modelo.addRow(new Object[6]);
        dgvUsuario.setValueAt(usuarios.get(i).getIdUsuario(),i,0 );
        dgvUsuario.setValueAt(usuarios.get(i).getNombre(),i,1 );
        dgvUsuario.setValueAt(usuarios.get(i).getPaterno(),i,2 );
        dgvUsuario.setValueAt(usuarios.get(i).getMaterno(),i,3 );
        dgvUsuario.setValueAt(usuarios.get(i).getPerfil().getDescripcion(),i,4 );
        dgvUsuario.setValueAt(usuarios.get(i).getEstadoUsuario().getDescripcion(),i,5 );

        }
               
 
    }

}
