/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdmAlmacen.java
 *
 * Created on Oct 2, 2011, 3:15:24 PM
 */
package Mantenimientos.Almacen;

import BusinessEntity.AlmacenBE;

/**
 *
 * @author DIEGO
 */
public class AdmAlmacen extends javax.swing.JFrame {

    /** Creates new form AdmAlmacen */
    public AdmAlmacen() {
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
        dgvAlmacen = new javax.swing.JTable();
        tlbAlmacen = new javax.swing.JToolBar();
        lblAgregar = new javax.swing.JLabel();
        lblEditar = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        lblRefrescar = new javax.swing.JLabel();
        lblVerMapa = new javax.swing.JLabel();
        lblBlanco = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Administrar almacén");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        dgvAlmacen.setAutoCreateRowSorter(true);
        dgvAlmacen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Estado", "Distrito", "Provincia", "Departamento"
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
        dgvAlmacen.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(dgvAlmacen);
        dgvAlmacen.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        tlbAlmacen.setFloatable(false);
        tlbAlmacen.setRollover(true);

        lblAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_page.png"))); // NOI18N
        lblAgregar.setToolTipText("Agregar");
        lblAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAgregarMousePressed(evt);
            }
        });
        tlbAlmacen.add(lblAgregar);

        lblEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/download.png"))); // NOI18N
        lblEditar.setToolTipText("Editar");
        lblEditar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tlbAlmacen.add(lblEditar);

        lblEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete_page.png"))); // NOI18N
        lblEliminar.setToolTipText("Eliminar");
        lblEliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tlbAlmacen.add(lblEliminar);

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_page.png"))); // NOI18N
        lblBuscar.setToolTipText("Buscar");
        lblBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBuscarMousePressed(evt);
            }
        });
        tlbAlmacen.add(lblBuscar);

        lblRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh.png"))); // NOI18N
        lblRefrescar.setToolTipText("Refrescar");
        lblRefrescar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRefrescar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tlbAlmacen.add(lblRefrescar);

        lblVerMapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/System Map.png"))); // NOI18N
        lblVerMapa.setToolTipText("Ver mapa");
        lblVerMapa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblVerMapa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tlbAlmacen.add(lblVerMapa);

        lblBlanco.setText("                                                                     ");
        tlbAlmacen.add(lblBlanco);

        lblInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info.png"))); // NOI18N
        lblInfo.setToolTipText("Información");
        lblInfo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tlbAlmacen.add(lblInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tlbAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tlbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void lblAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMousePressed
MantenimientoAlmacen m = new MantenimientoAlmacen(this);
m.setVisible(true);
// TODO add your handling code here:
}//GEN-LAST:event_lblAgregarMousePressed

    private void lblBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMousePressed
        // TODO add your handling code here:
        BuscarAlmacen b = new BuscarAlmacen();
        b.setVisible(true);
    }//GEN-LAST:event_lblBuscarMousePressed

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
            java.util.logging.Logger.getLogger(AdmAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AdmAlmacen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dgvAlmacen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblBlanco;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblRefrescar;
    private javax.swing.JLabel lblVerMapa;
    private javax.swing.JToolBar tlbAlmacen;
    // End of variables declaration//GEN-END:variables


public javax.swing.JTable getDgvAlmacen() {
        return dgvAlmacen;
    }

    void recargaruno(AlmacenBE almacen) {
        
    }


}
