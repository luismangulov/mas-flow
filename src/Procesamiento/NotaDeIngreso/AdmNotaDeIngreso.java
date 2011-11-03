/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdmNotaDeIngreso.java
 *
 * Created on Oct 2, 2011, 3:44:28 PM
 */
package Procesamiento.NotaDeIngreso;

import BusinessEntity.AlmacenBE;
import BusinessEntity.DetalleNotaIngresoBE;
import BusinessEntity.EstadoGRBE;
import BusinessEntity.EstadoNIBE;
import BusinessEntity.NotaIngresoBE;
import BusinessEntity.ProductoBE;
import BusinessLogic.AlmacenBL;
import BusinessLogic.DetalleNotaIngresoBL;
import BusinessLogic.NotaIngresoBL;
import BusinessLogic.ProductoBL;
import BusinessLogic.UbicacionBL;
import DataAccess.EstadoGRDA;
import DataAccess.EstadoNIDA;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class AdmNotaDeIngreso extends javax.swing.JFrame {

    /** Creates new form AdmNotaDeIngreso */
    public AdmNotaDeIngreso() {
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
        tblNotaIngreso = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        lblAgregar = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        lblRefrescar = new javax.swing.JLabel();
        lblDetalle = new javax.swing.JLabel();
        lblAprobar = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Administrar Nota de ingreso");

        tblNotaIngreso.setAutoCreateRowSorter(true);
        tblNotaIngreso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Almacen", "Código", "Proveedor", "Direccion", "Fecha", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tblNotaIngreso);
        tblNotaIngreso.getColumnModel().getColumn(4).setPreferredWidth(20);

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

        lblAprobar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check.png"))); // NOI18N
        lblAprobar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAprobar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAprobar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAprobarMousePressed(evt);
            }
        });
        jToolBar1.add(lblAprobar);

        jLabel7.setText("                                                                                                                                  ");
        jLabel7.setMaximumSize(new java.awt.Dimension(500, 14));
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
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void lblAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMousePressed
    MantenimientoNotaDeIngreso m = new MantenimientoNotaDeIngreso(this);
    m.setVisible(true);
// TODO add your handling code here:
}//GEN-LAST:event_lblAgregarMousePressed

private void lblBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMousePressed
// TODO add your handling code here:
    BuscarNotaDeIngreso m = new BuscarNotaDeIngreso(this);
    m.setVisible(true);
}//GEN-LAST:event_lblBuscarMousePressed

    private void lblRefrescarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefrescarMousePressed
        // TODO add your handling code here:
        NotaIngresoBL objNotaIngresoBL = new NotaIngresoBL();
        this.recargar(objNotaIngresoBL.queryAllNotaIngreso());
    }//GEN-LAST:event_lblRefrescarMousePressed

    private void lblDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDetalleMousePressed
        // TODO add your handling code here:
         if((tblNotaIngreso.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado una nota de ingreso", "Mensaje",0);
        } else if((tblNotaIngreso.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado mas de una nota de ingreso", "Mensaje",0);
        }else{
            int fila;
            String codigo;
            fila = tblNotaIngreso.getSelectedRow();
            codigo = (String)tblNotaIngreso.getValueAt(fila, 1);
                    
           DetalleNotaIngreso m = new DetalleNotaIngreso(this, codigo);
           m.setVisible(true);
        }    
    }//GEN-LAST:event_lblDetalleMousePressed

    private void lblAprobarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAprobarMousePressed
        // TODO add your handling code here:
        int fila1 = tblNotaIngreso.getSelectedRow();
        String  estado = tblNotaIngreso.getValueAt(fila1, 5).toString().trim();
         if((tblNotaIngreso.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado una nota de ingreso", "Mensaje",0);
        } else if((tblNotaIngreso.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado mas de una nota de ingreso", "Mensaje",0);
        }else if(estado.equals("Aprobado")){
            JOptionPane.showMessageDialog(null, "La nota de ingreso ya ha sido aprobada", "Mensaje",0);
        }else{
            int fila;
            String codigo;
            String identificador;
            String idAlmacen;
            fila = tblNotaIngreso.getSelectedRow();
            codigo = (String)tblNotaIngreso.getValueAt(fila, 1);
            
            
            identificador = (String)tblNotaIngreso.getValueAt(fila, 0);
            AlmacenBL objAlmacenBL = new AlmacenBL();
            ArrayList<AlmacenBE> arrAlmacenes = new ArrayList<AlmacenBE>(); 
            arrAlmacenes = objAlmacenBL.buscar("", "", "1", "", "", "", identificador);
            
            idAlmacen = arrAlmacenes.get(0).getIdAlmacen();
            
            
            DetalleNotaIngresoBL objDetalleNotaIngresoBL = new DetalleNotaIngresoBL();        
            ArrayList<DetalleNotaIngresoBE> arrDetalleNotaIngresoBE = new ArrayList<DetalleNotaIngresoBE>();
            arrDetalleNotaIngresoBE = objDetalleNotaIngresoBL.queryAllDetalleNotaIngreso(codigo);
            
            ArrayList<String> arrCodFamilia = new ArrayList<String>();
             ArrayList<Integer> arrCantUbicaciones = new ArrayList<Integer>();
            for(int i=0;i<arrDetalleNotaIngresoBE.size();i++){
                ProductoBL objProductoBL = new ProductoBL();
                ProductoBE objProductoBE = objProductoBL.getByIdProducto(arrDetalleNotaIngresoBE.get(i).getProducto().getIdProducto());
                arrCodFamilia.add(objProductoBE.getIdFamilia());
                arrCantUbicaciones.add(arrDetalleNotaIngresoBE.get(i).getCantidad()/objProductoBE.getMaxCantPorPallet());
            }
            boolean libres = true;
            for(int i=0;i<arrCodFamilia.size();i++){
                int cantUbicacion = 0;
                for(int j=0;j<arrCodFamilia.size();j++){
                    if(arrCodFamilia.get(j).equals(arrCodFamilia.get(i))){
                        cantUbicacion += arrCantUbicaciones.get(j);
                    }
                }
                UbicacionBL objUbicacionBL = new UbicacionBL();
               int ubicaLibres = objUbicacionBL.queryCantUbicacionesLibres(arrCodFamilia.get(i), idAlmacen);
                JOptionPane.showMessageDialog(null, idAlmacen, "Mensaje",1);
                JOptionPane.showMessageDialog(null, cantUbicacion, "Mensaje",1); 
                JOptionPane.showMessageDialog(null, ubicaLibres, "Mensaje",1);
                if(cantUbicacion> ubicaLibres){
                    libres = false;
                    break;
                }
            }
            if(libres == false){
                EstadoNIDA objEstadoNIDA = new EstadoNIDA();
                EstadoNIBE objEstadoNIBE = new EstadoNIBE();
                objEstadoNIBE = objEstadoNIDA.queryByDescripcionEstadoNI("Pendiente");
                NotaIngresoBL objNotaIngresoBL = new NotaIngresoBL();
                try {
                    //objNotaIngresoBL.cambiarEstado(codigo, objEstadoNIBE.getCodigo());
                    //tblNotaIngreso.setValueAt( objEstadoNIBE.getDescripcion(),fila,5 );
                } catch (Exception ex) {
                    Logger.getLogger(AdmNotaDeIngreso.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            }else{
                EstadoNIDA objEstadoNIDA = new EstadoNIDA();
                EstadoNIBE objEstadoNIBE = new EstadoNIBE();
                objEstadoNIBE = objEstadoNIDA.queryByDescripcionEstadoNI("Aprobado");
                NotaIngresoBL objNotaIngresoBL = new NotaIngresoBL();
                try {
                    //objNotaIngresoBL.cambiarEstado(codigo, objEstadoNIBE.getCodigo());
                     //tblNotaIngreso.setValueAt( objEstadoNIBE.getDescripcion(),fila,5 );
                } catch (Exception ex) {
                    Logger.getLogger(AdmNotaDeIngreso.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
            
        }    
    }//GEN-LAST:event_lblAprobarMousePressed

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
            java.util.logging.Logger.getLogger(AdmNotaDeIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmNotaDeIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmNotaDeIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmNotaDeIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AdmNotaDeIngreso().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblAprobar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblDetalle;
    private javax.swing.JLabel lblRefrescar;
    private javax.swing.JTable tblNotaIngreso;
    // End of variables declaration//GEN-END:variables

public void recargaruno(NotaIngresoBE notaIngreso,String razonSocial,String direccion,String identificador){
    ////
         
        DefaultTableModel modelo= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;  
            }
        };
        tblNotaIngreso.setModel(modelo);
         modelo.addColumn("Almacen");         
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
          tblNotaIngreso.setValueAt(identificador,0,0 ); 
         tblNotaIngreso.setValueAt(notaIngreso.getCodigo(),0,1 );
         tblNotaIngreso.setValueAt(razonSocial,0,2 );
         tblNotaIngreso.setValueAt(direccion,0,3 );
         
         tblNotaIngreso.setValueAt(notaIngreso.getFecha(),0,4 );
         tblNotaIngreso.setValueAt(notaIngreso.getEstado().getDescripcion(),0,5 );
    }

    public void recargar(ArrayList<NotaIngresoBE> notasIngreso){
    ////
         
        DefaultTableModel modelo= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;  
            }
        };
         tblNotaIngreso.setModel(modelo);
          modelo.addColumn("Almacen");
        modelo.addColumn("Código");
        modelo.addColumn("Cliente");
        modelo.addColumn("Dirección");
        
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");
//        tblGuiaRemision.getColumnModel().getColumn(0).setPreferredWidth(40);
//        tblGuiaRemision.getColumnModel().getColumn(1).setPreferredWidth(100);
//        tblGuiaRemision.getColumnModel().getColumn(2).setPreferredWidth(120);
//        tblGuiaRemision.getColumnModel().getColumn(3).setPreferredWidth(40);
        
        for(int i = 0;i<notasIngreso.size();i++){
            modelo.addRow(new Object[5]);
             tblNotaIngreso.setValueAt(notasIngreso.get(i).getAlmacen().getIdentificador(),i,0 );
             tblNotaIngreso.setValueAt(notasIngreso.get(i).getCodigo(),i,1 );
             tblNotaIngreso.setValueAt(notasIngreso.get(i).getProveedor().getRazonSocial(),i,2 );
             tblNotaIngreso.setValueAt(notasIngreso.get(i).getProveedor().getDireccion(),i,3 );
             
             tblNotaIngreso.setValueAt(notasIngreso.get(i).getFecha(),i,4 );
             tblNotaIngreso.setValueAt(notasIngreso.get(i).getEstado().getDescripcion(),i,5 );
        }
        
    }

}
