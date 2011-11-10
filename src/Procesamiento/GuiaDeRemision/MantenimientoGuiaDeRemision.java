/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MantenimientoGuiaDeRemision.java
 *
 * Created on Oct 2, 2011, 3:48:14 PM
 */
package Procesamiento.GuiaDeRemision;

import BusinessEntity.AlmacenBE;
import BusinessEntity.EntidadBE;
import BusinessEntity.GuiaRemisionBE;
import BusinessEntity.ProductoBE;
import BusinessEntity.UnidadMedidaBE;
import BusinessLogic.AlmacenBL;
import BusinessLogic.DetalleGuiaRemisionBL;
import BusinessLogic.GuiaRemisionBL;
import BusinessLogic.ProductoBL;
import BusinessLogic.UnidadMedidaBL;
import Util.Utilitario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class MantenimientoGuiaDeRemision extends javax.swing.JFrame {
    private AdmGuiaDeRemision objPadre;
    //private ProductoBE producto =new ProductoBE();
    private ArrayList<ProductoBE> arrProducto = new ArrayList<ProductoBE>();
    private EntidadBE cliente = new EntidadBE();
    ArrayList<AlmacenBE> arrAlmacenes = new ArrayList<AlmacenBE>();
    
    /** Creates new form MantenimientoGuiaDeRemision */
    public MantenimientoGuiaDeRemision(AdmGuiaDeRemision padre){
        this.objPadre = padre;
        initComponents();
         this.setLocationRelativeTo(null); 
//        Calendar currentDate = Calendar.getInstance(); 
//        SimpleDateFormat formatter=  new SimpleDateFormat("dd-MM-yyyy");
//        String dateNow = formatter.format(currentDate.getTime());
         
        Date fechaActual = new Date();
        
        DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        
       this.jdcFecha.setDate(fechaActual);
       this.cargarComboAlmacen();
        this.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtRUCDNI = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblAyuda = new javax.swing.JLabel();
        lblRemover = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblAdd = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        cbAlmacen = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Registrar Orden de Salida");

        jLabel1.setText("Cliente*:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtRUCDNI.setEditable(false);
        txtRUCDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRUCDNIActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtCodigo.setEditable(false);
        txtCodigo.setEnabled(false);

        txtNombre.setEditable(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Cantidad", "MaxCantEnPallet"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblProductosPropertyChange(evt);
            }
        });
        tblProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblProductosKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);
        tblProductos.getColumnModel().getColumn(0).setPreferredWidth(20);
        tblProductos.getColumnModel().getColumn(1).setPreferredWidth(65);
        tblProductos.getColumnModel().getColumn(2).setPreferredWidth(25);
        tblProductos.getColumnModel().getColumn(3).setPreferredWidth(60);

        jLabel3.setText("Nombre*:");

        jLabel2.setText("Código*:");

        jLabel4.setText("Fecha*:");

        lblAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search24.png"))); // NOI18N
        lblAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAyudaMousePressed(evt);
            }
        });

        lblRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete24.png"))); // NOI18N
        lblRemover.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRemoverMousePressed(evt);
            }
        });

        txtCliente.setEditable(false);
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        jLabel8.setText("Dirección*:");

        jLabel9.setText("RUC/DNI*:");

        lblAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add24.png"))); // NOI18N
        lblAdd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAdd.setName(""); // NOI18N
        lblAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAddMousePressed(evt);
            }
        });

        txtDireccion.setEditable(false);
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        jdcFecha.setEnabled(false);

        jLabel5.setText("Almacen*:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(btnGuardar)
                        .addGap(44, 44, 44)
                        .addComponent(btnCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblAyuda))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtRUCDNI)
                                    .addComponent(jdcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(3, 3, 3)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdd)
                            .addComponent(lblRemover))))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4))
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRUCDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(lblAyuda))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(lblRemover))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
// TODO add your handling code here:
    GuiaRemisionBL objGuiaRemisionBL = new GuiaRemisionBL();
    //SimpleDateFormat df1 = new SimpleDateFormat( "dd/MM/yy" );
     GuiaRemisionBE objGuiaRemisionBE;  
   if(this.valida()){  
     try {
        if(objGuiaRemisionBL.insertar(this.jdcFecha.getDate(),this.txtCliente.getText().trim(),this.arrAlmacenes.get(cbAlmacen.getSelectedIndex()).getIdAlmacen())){
            
            objGuiaRemisionBE = objGuiaRemisionBL.getObjGuiaRemisionBE();
            for(int i = 0;i<this.tblProductos.getRowCount();i++){
                DetalleGuiaRemisionBL objDetalleGuiaRemisionBL = new DetalleGuiaRemisionBL();
                try {
                   objDetalleGuiaRemisionBL.insertar(objGuiaRemisionBE.getCodigo(), (String)this.tblProductos.getValueAt(i, 0), (Integer)(this.tblProductos.getValueAt(i, 2)));
                   
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MantenimientoGuiaDeRemision.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MantenimientoGuiaDeRemision.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(MantenimientoGuiaDeRemision.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        objGuiaRemisionBE = objGuiaRemisionBL.getObjGuiaRemisionBE();
        this.objPadre.recargaruno(objGuiaRemisionBE, cliente.getRazonSocial(),cliente.getDireccion(),(String)this.cbAlmacen.getSelectedItem());
        this.dispose();
    } catch (Exception ex) {
        Logger.getLogger(MantenimientoGuiaDeRemision.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
       
    
}//GEN-LAST:event_btnGuardarActionPerformed

private void txtRUCDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRUCDNIActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtRUCDNIActionPerformed

private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtNombreActionPerformed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
// TODO add your handling code here:
    this.dispose();
    
}//GEN-LAST:event_btnCancelarActionPerformed

private void lblAyudaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAyudaMousePressed
// TODO add your handling code here:
    Mantenimientos.Cliente.AyudaCliente m = new Mantenimientos.Cliente.AyudaCliente(this,true,this.cliente);
    m.setVisible(true);
    this.txtCliente.setText(cliente.getIdEntidad());
    this.txtRUCDNI.setText(cliente.getNroDocumento());
    this.txtNombre.setText(cliente.getRazonSocial());
    this.txtDireccion.setText(cliente.getDireccion());
}//GEN-LAST:event_lblAyudaMousePressed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
        
         
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void lblAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMousePressed
        // TODO add your handling code here:
        Mantenimientos.Producto.AyudaProducto m = new Mantenimientos.Producto.AyudaProducto(this,true,this.arrProducto);
        m.setVisible(true);
        boolean seleccion = false;
        for(int j = 0;j<this.arrProducto.size();j++){
            for( int i = 0;i<this.tblProductos.getRowCount();i++){
               
                if(arrProducto.get(j).getIdProducto().equals((String)this.tblProductos.getValueAt(i, 0))){
                    JOptionPane.showMessageDialog(null, "El producto ya ha sido seleccionado", "Mensaje",0);
                    seleccion = true;
                }
            }    
        }
        if(seleccion == false){
            if(arrProducto.get(0).getIdProducto().equals("")){
                JOptionPane.showMessageDialog(null, "No ha seleccionado uno o mas producto", "Mensaje",0);
            }else recargar(this.arrProducto);
        }
       
        
        
    }//GEN-LAST:event_lblAddMousePressed

    private void lblRemoverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoverMousePressed
        // TODO add your handling code here:
        DefaultTableModel modelo=(DefaultTableModel) tblProductos.getModel();
        if((tblProductos.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado un producto", "Mensaje",0);
        } else if((tblProductos.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado mas de un producto", "Mensaje",0);
        }else{
            modelo.removeRow(tblProductos.getSelectedRow());
        }
    }//GEN-LAST:event_lblRemoverMousePressed

    private void tblProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductosKeyTyped
        // TODO add your handling code here:
      
    }//GEN-LAST:event_tblProductosKeyTyped

    private void tblProductosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblProductosPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_tblProductosPropertyChange

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoGuiaDeRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoGuiaDeRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoGuiaDeRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoGuiaDeRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new MantenimientoGuiaDeRemision().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbAlmacen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JLabel lblAdd;
    private javax.swing.JLabel lblAyuda;
    private javax.swing.JLabel lblRemover;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRUCDNI;
    // End of variables declaration//GEN-END:variables

    public void recargaruno(ProductoBE producto){
        DefaultTableModel modelo=(DefaultTableModel) tblProductos.getModel();
        
         modelo.addRow(new Object[4]);
        tblProductos.setValueAt(producto.getIdProducto(),tblProductos.getRowCount()-1,0 );
        tblProductos.setValueAt(producto.getNombre(),tblProductos.getRowCount()-1,1 );
//        UnidadMedidaBL objUnidadMedidadBL = new UnidadMedidaBL();
//        UnidadMedidaBE objUnidadMedidadBE = new UnidadMedidaBE();
//        objUnidadMedidadBE = objUnidadMedidadBL.getUnidadMedida(producto.getIdUnidadMedida());
         tblProductos.setValueAt(producto.getMaxCantPorPallet(),tblProductos.getRowCount()-1,3 );
    }

    public void recargar(ArrayList<ProductoBE> arrProductos){
        DefaultTableModel modelo=(DefaultTableModel) tblProductos.getModel();
        
        for(int i = 0;i<this.arrProducto.size();i++){
             modelo.addRow(new Object[4]);
            tblProductos.setValueAt(arrProducto.get(i).getIdProducto(),tblProductos.getRowCount()-1,0 );
            tblProductos.setValueAt(arrProducto.get(i).getNombre(),tblProductos.getRowCount()-1,1 );
//            UnidadMedidaBL objUnidadMedidadBL = new UnidadMedidaBL();
//            UnidadMedidaBE objUnidadMedidadBE = new UnidadMedidaBE();
//            objUnidadMedidadBE = objUnidadMedidadBL.getUnidadMedida(arrProducto.get(i).getIdUnidadMedida());
             tblProductos.setValueAt(arrProducto.get(i).getMaxCantPorPallet(),tblProductos.getRowCount()-1,3 );
        } 
    }
    
    
    
    
    private boolean valida(){
        boolean esValido = true;

        if(this.tblProductos.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Debe elegir uno o varios productos", "Mensaje",1);
            esValido = false;
        }
        
        if(this.txtCliente.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Debe elegir un cliente", "Error",0);
            esValido = false;
        }
        
        for(int i = 0;i<this.tblProductos.getRowCount();i++){
            ProductoBL objProductoBL = new ProductoBL();
            ProductoBE objProductoBE = objProductoBL.getByIdProducto(this.tblProductos.getValueAt(i, 0).toString());
            //int cantProd = Integer.parseInt(this.tblProductos.getValueAt(i, 2).toString());
            
            if(this.tblProductos.getValueAt(i, 2) == null){
                JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad de producto", "Mensaje",1);
                esValido = false;
                break;
            }
            
            //if((Integer.parseInt((String)this.tblProductos.getValueAt(i, 2))%objProductoBE.getMaxCantPorPallet()) != 0){
            if(((Integer)this.tblProductos.getValueAt(i, 2)%objProductoBE.getMaxCantPorPallet()) != 0){ 
                JOptionPane.showMessageDialog(null, "La cantidad debe ser múltiplo de la maxcantidadenpallet", "Mensaje",1);
                esValido = false;
                break;
            }
        }
              
        

        return esValido;
    }
    
      
    public final void cargarComboAlmacen(){
        
        cbAlmacen.removeAllItems();
        AlmacenBL objAlmacenBL = new AlmacenBL();          
        arrAlmacenes = new ArrayList<AlmacenBE>();
        arrAlmacenes = objAlmacenBL.getAllAlmacenActivo();
        
        if (arrAlmacenes != null)
            for(AlmacenBE almacen : arrAlmacenes)
                cbAlmacen.addItem(almacen.getIdentificador());

    }
    
    
}
