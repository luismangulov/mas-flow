/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdmGuiaDeRemision.java
 *
 * Created on Oct 2, 2011, 3:48:47 PM
 */
package Procesamiento.GuiaDeRemision;

import BusinessEntity.GuiaRemisionBE;
import BusinessLogic.GuiaRemisionBL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class AdmGuiaDeRemision extends javax.swing.JFrame {

    /** Creates new form AdmGuiaDeRemision */
    public AdmGuiaDeRemision() {
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
        tblGuiaRemision = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        lblAgregar = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        lblRefrescar = new javax.swing.JLabel();
        lblDetalle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Administrar guia de remision");

        tblGuiaRemision.setAutoCreateRowSorter(true);
        tblGuiaRemision.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Cliente", "Dirección", "Fecha", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblGuiaRemision);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        lblAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_page.png"))); // NOI18N
        lblAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAgregarMousePressed(evt);
            }
        });
        jToolBar1.add(lblAgregar);

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_page.png"))); // NOI18N
        lblBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBuscarMousePressed(evt);
            }
        });
        jToolBar1.add(lblBuscar);

        lblRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh.png"))); // NOI18N
        lblRefrescar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRefrescar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRefrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRefrescarMousePressed(evt);
            }
        });
        jToolBar1.add(lblRefrescar);

        lblDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/detalle2.png"))); // NOI18N
        lblDetalle.setToolTipText("VisualizarDetalle");
        lblDetalle.setMaximumSize(new java.awt.Dimension(54, 54));
        lblDetalle.setPreferredSize(new java.awt.Dimension(54, 54));
        lblDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblDetalleMousePressed(evt);
            }
        });
        jToolBar1.add(lblDetalle);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check.png"))); // NOI18N
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setMaximumSize(new java.awt.Dimension(54, 54));
        jLabel1.setPreferredSize(new java.awt.Dimension(54, 54));
        jToolBar1.add(jLabel1);

        jLabel7.setText("                                                                                                                                  ");
        jLabel7.setMaximumSize(new java.awt.Dimension(520, 14));
        jLabel7.setPreferredSize(new java.awt.Dimension(500, 14));
        jToolBar1.add(jLabel7);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info.png"))); // NOI18N
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToolBar1.add(jLabel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
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

private void lblAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMousePressed
MantenimientoGuiaDeRemision m = new MantenimientoGuiaDeRemision(this);
m.setVisible(true);
// TODO add your handling code here:
}//GEN-LAST:event_lblAgregarMousePressed

private void lblBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMousePressed
// TODO add your handling code here:
    BuscarGuiaDeRemision m = new BuscarGuiaDeRemision(this);
    m.setVisible(true);
}//GEN-LAST:event_lblBuscarMousePressed

    private void lblRefrescarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefrescarMousePressed
        // TODO add your handling code here:
        GuiaRemisionBL objGuiaRemisionBL = new GuiaRemisionBL();
        this.recargar(objGuiaRemisionBL.queryAllGuiaRemision());
    }//GEN-LAST:event_lblRefrescarMousePressed

    private void lblDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDetalleMousePressed
        // TODO add your handling code here:
        if((tblGuiaRemision.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado una guia de remision", "Mensaje",0);
        } else if((tblGuiaRemision.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado mas de una guia de remision", "Mensaje",0);
        }else{
            int fila;
            String codigo;
            fila = tblGuiaRemision.getSelectedRow();
            codigo = (String)tblGuiaRemision.getValueAt(fila, 0);
                    
           DetalleGuiaDeRemision m = new DetalleGuiaDeRemision(this, codigo);
           m.setVisible(true);
        }    
    }//GEN-LAST:event_lblDetalleMousePressed

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
            java.util.logging.Logger.getLogger(AdmGuiaDeRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmGuiaDeRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmGuiaDeRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmGuiaDeRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AdmGuiaDeRemision().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblDetalle;
    private javax.swing.JLabel lblRefrescar;
    private javax.swing.JTable tblGuiaRemision;
    // End of variables declaration//GEN-END:variables


    public void recargaruno(GuiaRemisionBE guiaRemision,String razonSocial,String direccion){
    ////
         
        DefaultTableModel modelo= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;  
            }
        };
        tblGuiaRemision.setModel(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Cliente");
        modelo.addColumn("Dirección");
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");
//        tblGuiaRemision.getColumnModel().getColumn(0).setPreferredWidth(40);
//        tblGuiaRemision.getColumnModel().getColumn(1).setPreferredWidth(100);
//        tblGuiaRemision.getColumnModel().getColumn(2).setPreferredWidth(120);
//        tblGuiaRemision.getColumnModel().getColumn(3).setPreferredWidth(40);
         modelo.addRow(new Object[5]);
        tblGuiaRemision.setValueAt(guiaRemision.getCodigo(),0,0 );
        tblGuiaRemision.setValueAt(razonSocial,0,1 );
        tblGuiaRemision.setValueAt(direccion,0,2 );
        //tblGuiaRemision.setValueAt(contacto,0,3 );
        tblGuiaRemision.setValueAt(guiaRemision.getFecha(),0,3 );
        tblGuiaRemision.setValueAt(guiaRemision.getEstado().getDescripcion(),0,4 );
    }

    public void recargar(ArrayList<GuiaRemisionBE> guiaRemisiones){
    ////
         
        DefaultTableModel modelo= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;  
            }
        };
        tblGuiaRemision.setModel(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Cliente");
        modelo.addColumn("Dirección");
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");
//        tblGuiaRemision.getColumnModel().getColumn(0).setPreferredWidth(40);
//        tblGuiaRemision.getColumnModel().getColumn(1).setPreferredWidth(100);
//        tblGuiaRemision.getColumnModel().getColumn(2).setPreferredWidth(120);
//        tblGuiaRemision.getColumnModel().getColumn(3).setPreferredWidth(40);
        
        for(int i = 0;i<guiaRemisiones.size();i++){
            modelo.addRow(new Object[5]);
            tblGuiaRemision.setValueAt(guiaRemisiones.get(i).getCodigo(),i,0 );
            tblGuiaRemision.setValueAt(guiaRemisiones.get(i).getCliente().getRazonSocial(),i,1 );
            tblGuiaRemision.setValueAt(guiaRemisiones.get(i).getCliente().getDireccion(),i,2 );
            //tblGuiaRemision.setValueAt(guiaRemisiones.get(i).getCliente().getNombreContacto(),0,3 );
            tblGuiaRemision.setValueAt(guiaRemisiones.get(i).getFecha(),i,3 );
            tblGuiaRemision.setValueAt(guiaRemisiones.get(i).getEstado().getDescripcion(),i,4 );
        }
        
    }

}
