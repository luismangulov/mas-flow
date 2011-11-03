/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AyudaProveedor.java
 *
 * Created on 17/10/2011, 02:10:49 PM
 */
package Mantenimientos.Proveedor;

import Util.Utilitario;
import BusinessEntity.EntidadBE;
import BusinessLogic.EntidadBL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Giuliana
 */
public class AyudaProveedor extends javax.swing.JDialog {
EntidadBE proveedor;
    /** Creates new form AyudaProveedor */
    public AyudaProveedor(java.awt.Frame parent, boolean modal,EntidadBE proveedor) {

        super(parent, modal);
        this.proveedor=proveedor;
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

        txtRazonSocial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvProveedor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Ayuda Proveedor");
        setResizable(false);

        txtRazonSocial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRazonSocialFocusLost(evt);
            }
        });
        txtRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSocialKeyTyped(evt);
            }
        });

        jLabel2.setText("Documento:");

        jLabel3.setText("Razón Social:");

        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarMousePressed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAceptarMousePressed(evt);
            }
        });

        dgvProveedor.setAutoCreateRowSorter(true);
        dgvProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Razón Social"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgvProveedor.setColumnSelectionAllowed(true);
        dgvProveedor.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(dgvProveedor);
        dgvProveedor.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        dgvProveedor.getColumnModel().getColumn(0).setPreferredWidth(10);
        dgvProveedor.getColumnModel().getColumn(1).setPreferredWidth(100);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(btnAceptar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(btnBuscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAceptar)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMousePressed
     EntidadBL objEntidadBL = new EntidadBL();
        ArrayList<EntidadBE> proveedores = objEntidadBL.buscarProveedor("", this.txtDocumento.getText(), this.txtRazonSocial.getText(),"","1");
        this.recargar(proveedores);
                // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarMousePressed

    private void btnAceptarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMousePressed
       if((dgvProveedor.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado un proveedor.", "Mensaje",0);
        } else if((dgvProveedor.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado más de un proveedor", "Mensaje",0);
        }else{
            int fila;
            String codigo;
            fila = dgvProveedor.getSelectedRow();
            codigo = (String)dgvProveedor.getValueAt(fila, 0);
            EntidadBL objEntidadBL = new EntidadBL();
            EntidadBE objProveedorBE = objEntidadBL.getProveedor(codigo);

            this.proveedor.setIdEntidad(objProveedorBE.getIdEntidad());
            this.proveedor.setRazonSocial(objProveedorBE.getRazonSocial());
            this.proveedor.setNroDocumento(objProveedorBE.getNroDocumento());
            this.proveedor.setDireccion(objProveedorBE.getDireccion());

            this.dispose();  // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarMousePressed
    }
       private void txtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyTyped
           if ((this.txtDocumento.getText().length() + 1) > 11) {
            evt.consume();}  // TODO add your handling code here:
       }//GEN-LAST:event_txtDocumentoKeyTyped

       private void txtRazonSocialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSocialKeyTyped
          if ((this.txtRazonSocial.getText().length() + 1) > 60) {
            evt.consume();}             // TODO add your handling code here:
       }//GEN-LAST:event_txtRazonSocialKeyTyped

       private void txtRazonSocialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRazonSocialFocusLost
            txtRazonSocial.setText( txtRazonSocial.getText().toUpperCase());             // TODO add your handling code here:
       }//GEN-LAST:event_txtRazonSocialFocusLost
    
    /**
     * @param args the command line arguments
     */
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JTable dgvProveedor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtRazonSocial;
    // End of variables declaration//GEN-END:variables

public void recargar(ArrayList<EntidadBE> proveedores){
            DefaultTableModel modelo=(DefaultTableModel) dgvProveedor.getModel();
            for(int i=modelo.getRowCount()-1; i>=0; i--){
                modelo.removeRow(i);
            }

            dgvProveedor.clearSelection();

            for(int i=0;i<proveedores.size();i++){
                 modelo.addRow(new Object[4]);
                dgvProveedor.setValueAt(proveedores.get(i).getIdEntidad(),i,0 );
                dgvProveedor.setValueAt(proveedores.get(i).getRazonSocial(),i,1 );

            }
    }

}
