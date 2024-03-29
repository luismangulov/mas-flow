/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AyudaAlmacen.java
 *
 * Created on 17/10/2011, 02:08:00 PM
 */
package Seguridad.Usuario;

import Seguridad.Usuario.*;
import Util.Utilitario;
import BusinessEntity.UsuarioBE;
import BusinessLogic.UsuarioBL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Giuliana
 */
public class AyudaUsuario extends javax.swing.JDialog {
    UsuarioBE usuario;
    /** Creates new form AyudaAlmacen */
    public AyudaUsuario(java.awt.Frame parent, boolean modal,UsuarioBE usuario) {
        super(parent, modal);
        initComponents();
        this.usuario = usuario;
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

        btnAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvUsuario = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Ayuda Cliente");
        setResizable(false);

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAceptarMousePressed(evt);
            }
        });

        dgvUsuario.setAutoCreateRowSorter(true);
        dgvUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Nombre"
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
        jScrollPane1.setViewportView(dgvUsuario);
        dgvUsuario.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        dgvUsuario.getColumnModel().getColumn(0).setPreferredWidth(10);
        dgvUsuario.getColumnModel().getColumn(1).setPreferredWidth(100);

        jLabel3.setText("Nombre:");

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarMousePressed(evt);
            }
        });

        jLabel4.setText("Usuario:");

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(btnAceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(48, 48, 48)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(43, 43, 43)
                                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMousePressed
    UsuarioBL objUsuarioBL = new UsuarioBL();
        ArrayList<UsuarioBE> usuarios = objUsuarioBL.buscar(this.txtCodigo.getText(), this.txtNombre.getText(), this.txtNombre.getText(), this.txtNombre.getText(),"", "");
        this.recargar(usuarios);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarMousePressed

    private void btnAceptarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMousePressed
        if((dgvUsuario.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado un usuario.", "Mensaje",0);
        } else if((dgvUsuario.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado más de un usuario", "Mensaje",0);
        }else{
            int fila;
            String codigo;
            fila = dgvUsuario.getSelectedRow();
            codigo = (String)dgvUsuario.getValueAt(fila, 0);
            UsuarioBL objUsuarioBL = new UsuarioBL();
            UsuarioBE objUsuarioBE = objUsuarioBL.queryByIdUsuario(codigo);

            this.usuario.setIdUsuario(objUsuarioBE.getIdUsuario());
            this.dispose();
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarMousePressed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if ((this.txtNombre.getText().length() + 1) > 30) {
            evt.consume();}          // TODO add your handling code here:
}//GEN-LAST:event_txtNombreKeyTyped

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        txtNombre.setText( txtNombre.getText().toUpperCase());
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        if ((this.txtCodigo.getText().length() + 1) > 6){
            evt.consume();}  // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JTable dgvUsuario;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

 public void recargar(ArrayList<UsuarioBE> usuarios){
            DefaultTableModel modelo=(DefaultTableModel) dgvUsuario.getModel();
            for(int i=modelo.getRowCount()-1; i>=0; i--){
                modelo.removeRow(i);
            }

            dgvUsuario.clearSelection();

            for(int i=0;i<usuarios.size();i++){
                 modelo.addRow(new Object[4]);
                dgvUsuario.setValueAt(usuarios.get(i).getIdUsuario(),i,0 );
                dgvUsuario.setValueAt(usuarios.get(i).getNombre()+ " " + usuarios.get(i).getPaterno(),i,1 );
            }
    }


}
