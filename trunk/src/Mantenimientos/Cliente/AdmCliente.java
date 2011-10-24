/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdmCliente.java
 *
 * Created on Oct 2, 2011, 3:34:36 PM
 */
package Mantenimientos.Cliente;

import BusinessEntity.EntidadBE;
import BusinessLogic.EntidadBL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class AdmCliente extends javax.swing.JFrame {

    /** Creates new form AdmCliente */
    public AdmCliente() {
       
        
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
        dgvCliente = new javax.swing.JTable();
        tlbCliente = new javax.swing.JToolBar();
        lblAgregar = new javax.swing.JLabel();
        lblEditar = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        lblRefrescar = new javax.swing.JLabel();
        lblBlanco = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Administrar cliente");
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        dgvCliente.setAutoCreateRowSorter(true);
        dgvCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "RUC", "Razón Social", "Teléfonos", "E-mail", "Contacto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        dgvCliente.setCellSelectionEnabled(false);
        dgvCliente.setName("dgvCliente"); // NOI18N
        dgvCliente.setRowSelectionAllowed(true);
        jScrollPane1.setViewportView(dgvCliente);
        dgvCliente.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        dgvCliente.getColumnModel().getColumn(0).setResizable(false);
        dgvCliente.getColumnModel().getColumn(0).setPreferredWidth(40);
        dgvCliente.getColumnModel().getColumn(1).setResizable(false);
        dgvCliente.getColumnModel().getColumn(1).setPreferredWidth(40);
        dgvCliente.getColumnModel().getColumn(2).setResizable(false);
        dgvCliente.getColumnModel().getColumn(2).setPreferredWidth(100);
        dgvCliente.getColumnModel().getColumn(3).setResizable(false);
        dgvCliente.getColumnModel().getColumn(3).setPreferredWidth(40);
        dgvCliente.getColumnModel().getColumn(4).setResizable(false);
        dgvCliente.getColumnModel().getColumn(4).setPreferredWidth(60);
        dgvCliente.getColumnModel().getColumn(5).setResizable(false);
        dgvCliente.getColumnModel().getColumn(5).setPreferredWidth(100);

        tlbCliente.setFloatable(false);
        tlbCliente.setRollover(true);

        lblAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_page.png"))); // NOI18N
        lblAgregar.setToolTipText("Agregar");
        lblAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAgregarMousePressed(evt);
            }
        });
        tlbCliente.add(lblAgregar);

        lblEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/download.png"))); // NOI18N
        lblEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblEditarMousePressed(evt);
            }
        });
        tlbCliente.add(lblEditar);

        lblEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete_page.png"))); // NOI18N
        tlbCliente.add(lblEliminar);

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_page.png"))); // NOI18N
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBuscarMousePressed(evt);
            }
        });
        tlbCliente.add(lblBuscar);

        lblRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh.png"))); // NOI18N
        lblRefrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRefrescarMousePressed(evt);
            }
        });
        tlbCliente.add(lblRefrescar);

        lblBlanco.setText("                                                                                                   ");
        tlbCliente.add(lblBlanco);

        lblInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info.png"))); // NOI18N
        tlbCliente.add(lblInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tlbCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tlbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void lblAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMousePressed
        try {
            MantenimientoCliente m = new MantenimientoCliente(0,"");
            m.setVisible(true);
            // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(AdmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_lblAgregarMousePressed

private void lblBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMousePressed
BuscarCliente m = new BuscarCliente();
m.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_lblBuscarMousePressed

private void lblEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMousePressed
// TODO add your handling code here:
    
            int fila;
            String codigo;
            fila = dgvCliente.getSelectedRow();
            codigo = (String)dgvCliente.getValueAt(fila, 0);
            
             try {
            MantenimientoCliente m = new MantenimientoCliente(1,codigo);
            m.setVisible(true);
            // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(AdmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            //EntidadBL objClienteBL = new EntidadBL(1, codigo);
//            EntidadBE cliente = objClienteBL.getCliente(codigo);
//            MantenimientoCliente m = new MantenimientoCliente(this,cliente);
//            m.setVisible(true);
    
}//GEN-LAST:event_lblEditarMousePressed

private void lblRefrescarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefrescarMousePressed
        try {
            // TODO add your handling code here:
                EntidadBL objClienteBL =new EntidadBL();
                this.recargar(objClienteBL.getAllClientesActivos());
        } catch (Exception ex) {
            Logger.getLogger(AdmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_lblRefrescarMousePressed

private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange

String espacios= "";
for (int i=0;i<this.getWidth()/2-100; i++){
    espacios=espacios+ "  ";
}
lblBlanco.setText(espacios);      
  
    
    // TODO add your handling code here:
}//GEN-LAST:event_formPropertyChange

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
            java.util.logging.Logger.getLogger(AdmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AdmCliente().setVisible(true);
            }
        });
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dgvCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblBlanco;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblRefrescar;
    private javax.swing.JToolBar tlbCliente;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTable getDgvCliente() {
        return dgvCliente;
    }
    
    public void recargaruno(EntidadBE cliente){
        
        DefaultTableModel modelo=(DefaultTableModel) dgvCliente.getModel();
        modelo.addRow(new Object[6]);
        dgvCliente.clearSelection();
        dgvCliente.setValueAt(cliente.getIdEntidad(),0,0 );
        dgvCliente.setValueAt(cliente.getNroDocumento(),0,1 );
        dgvCliente.setValueAt(cliente.getRazonSocial(),0,2 );
        dgvCliente.setValueAt(cliente.getTelefono(),0,3);
        dgvCliente.setValueAt(cliente.getEmail(),0,4 );
        dgvCliente.setValueAt(cliente.getNombreContacto(),0,5 );
    }
    
    public void recargar(ArrayList<EntidadBE> clientes){
        
        
        
        DefaultTableModel modelo=(DefaultTableModel) dgvCliente.getModel();
        dgvCliente.clearSelection();
        
        for(int i=0;i<clientes.size();i++){
            modelo.addRow(new Object[6]);
            dgvCliente.setValueAt(clientes.get(i).getIdEntidad(),i,0 );
            dgvCliente.setValueAt(clientes.get(i).getNroDocumento(),i,1 );
            dgvCliente.setValueAt(clientes.get(i).getRazonSocial(),i,2 );
            dgvCliente.setValueAt(clientes.get(i).getTelefono(),i,3 );
            dgvCliente.setValueAt(clientes.get(i).getEmail(),i,4 );
            dgvCliente.setValueAt(clientes.get(i).getNombreContacto(),i,5 );
        }
    }



}
