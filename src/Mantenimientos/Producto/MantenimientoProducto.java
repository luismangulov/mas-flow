/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MantenimientoProducto.java
 *
 * Created on Oct 2, 2011, 3:14:59 PM
 */
package Mantenimientos.Producto;

import BusinessEntity.FamiliaBE;
import BusinessEntity.ProductoBE;
import BusinessEntity.UnidadMedidaBE;
import BusinessLogic.FamiliaBL;
import BusinessLogic.ProductoBL;
import BusinessLogic.UnidadMedidaBL;
import DataAccess.FamiliaDA;
import DataAccess.ProductoDA;
import DataAccess.UnidadMedidaDA;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DIEGO
 */
public class MantenimientoProducto extends javax.swing.JFrame {

    /** Creates new form MantenimientoProducto */
    boolean boolExito = false;
    private char accion;
    private String idProducto;
    private String nombre;
    private String descripcion;
    private int maxCantPorPallet;
    private String unidadMedida;
    private String familia;
    private String indActivo;
    private double precio;
    private ProductoBE objProducto;
    AdmProducto ventanaPadre;
    ArrayList<ProductoBE> arrProductos;

    public MantenimientoProducto(char c, String idProducto, AdmProducto ventanaPadre){
        initComponents();
        this.accion = c;
        ProductoBL objProductoBL = new ProductoBL();
        objProducto = objProductoBL.getByIdProducto(idProducto);
        this.setVisible(true);
        this.cargarComponentes(objProducto);
        chbxActivo.setSelected(true);
        this.ventanaPadre = ventanaPadre;
    }

    public MantenimientoProducto(AdmProducto ventanaPadre) {
        initComponents();
//            this.txtIdProducto bloquear
        this.accion = 'R';
        this.cargarComboUnidadMedida();
        this.cargarComboFamilia();
        chbxActivo.setSelected(true);
        this.ventanaPadre = ventanaPadre;
    }

    private void cargarComponentes(ProductoBE objProducto){
        
        FamiliaDA objFamiliaDA = new FamiliaDA();
        UnidadMedidaDA objUnidadMedidaDA = new UnidadMedidaDA();
        
        txtIdProducto.setText(objProducto.getIdProducto());
        txtNombre.setText(objProducto.getNombre());
        txtDescripcion.setText(objProducto.getDescripcion());
        txtMaxCantPallet.setText(String.valueOf(objProducto.getMaxCantPorPallet()));
        cargarComboFamilia();
        cargarComboUnidadMedida();
        
        for(int i=0; i<cbFamilia.getSize().width; i++){
//            JOptionPane.showMessageDialog(null, cbFamilia.getItemAt(i).toString(),"wa",0);
            String strNombreFamilia = objFamiliaDA.queryByIdFamilia(objProducto.getIdFamilia()).getNombre();
            if(cbFamilia.getItemAt(i).toString().equals(strNombreFamilia)){
                cbFamilia.setSelectedIndex(i);
                break;
            }
        }
        for(int i=0; i<cbUnidad.getSize().width-1; i++){
            String strUnidadMedida = objUnidadMedidaDA.queryByIdUnidadMedida(objProducto.getIdUnidadMedida()).getNombre();
            if(cbUnidad.getItemAt(i).toString().equals(strUnidadMedida)){
                cbUnidad.setSelectedIndex(i);
                break;
            }
        }    

    }

    public void cargarComboUnidadMedida(){
        
        UnidadMedidaBL objUnidadMedidaBL = new UnidadMedidaBL();
        ArrayList<UnidadMedidaBE> arrUnidadMedida = new ArrayList<UnidadMedidaBE>();
        arrUnidadMedida = objUnidadMedidaBL.getAllUnidadMedida();
        
        for(UnidadMedidaBE unidadMedida : arrUnidadMedida)
            cbUnidad.addItem(unidadMedida.getNombre());
    }

    public void cargarComboFamilia(){
            
        FamiliaBL objFamiliaBL = new FamiliaBL();
        ArrayList<FamiliaBE> arrFamilia = new ArrayList<FamiliaBE>();
        
        arrFamilia = objFamiliaBL.getAllFamilia();
        for(FamiliaBE objFamilia : arrFamilia)
            cbFamilia.addItem(objFamilia.getNombre());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        cbFamilia = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtMaxCantPallet = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbUnidad = new javax.swing.JComboBox();
        chbxActivo = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Registrar producto");

        jLabel1.setText("Código:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Descripción:");

        jLabel4.setText("Familia:");

        jLabel6.setText("<html>Máx. Cant.<br>por pallet</html>");

        btnGuardar.setText("Guardar");
        btnGuardar.setMaximumSize(new java.awt.Dimension(75, 23));
        btnGuardar.setMinimumSize(new java.awt.Dimension(75, 23));
        btnGuardar.setPreferredSize(new java.awt.Dimension(75, 23));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Unidad:");

        chbxActivo.setText("Activo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(chbxActivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                    .addComponent(cbFamilia, 0, 229, Short.MAX_VALUE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbUnidad, 0, 229, Short.MAX_VALUE)
                                    .addComponent(txtMaxCantPallet, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaxCantPallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(chbxActivo)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       //System.exit(0);
       this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void insertar(){
        
        nombre = txtNombre.getText();
        descripcion = txtDescripcion.getText();
        maxCantPorPallet = Integer.parseInt(txtMaxCantPallet.getText());
        UnidadMedidaBL unidadBL = new UnidadMedidaBL();
        unidadMedida = unidadBL.getIdUnidadMedida(cbUnidad.getSelectedItem().toString());
        FamiliaBL familiaBL = new FamiliaBL();
        familia = familiaBL.getIdFamilia((String)cbFamilia.getSelectedItem());
        
        if (chbxActivo.isSelected())
            indActivo = "1";
        else
            indActivo = "0";
        
        ProductoBE productoBE = new ProductoBE("",nombre,descripcion,maxCantPorPallet,unidadMedida,familia,indActivo);
        ProductoBL productoBL = new ProductoBL();
        productoBL.insertar(productoBE);
        arrProductos = new ArrayList<ProductoBE>();
        arrProductos.add(productoBE);
        
        this.ventanaPadre.llenarDgv(arrProductos);
        this.dispose();
    }
    
    private void modificar(){
        
        idProducto = txtIdProducto.getText();
        nombre = txtNombre.getText();
        descripcion = txtDescripcion.getText();
        maxCantPorPallet = Integer.parseInt(txtMaxCantPallet.getText());
        UnidadMedidaBL unidadBL = new UnidadMedidaBL();
        unidadMedida = unidadBL.getIdUnidadMedida(cbUnidad.getSelectedItem().toString());
        FamiliaBL familiaBL = new FamiliaBL();
        familia = familiaBL.getIdFamilia((String)cbFamilia.getSelectedItem());
        
        if (chbxActivo.isSelected())
            indActivo = "1";
        else
            indActivo = "0";
        
        ProductoBE productoBE = new ProductoBE(idProducto,nombre,descripcion,maxCantPorPallet,unidadMedida,familia,indActivo);
        ProductoBL productoBL = new ProductoBL();
        productoBL.modificar(productoBE);     
        
        arrProductos = new ArrayList<ProductoBE>();
        arrProductos.add(productoBE);
        this.ventanaPadre.llenarDgv(arrProductos);
        this.dispose();
    }
    
    private void eliminar(){
        
        idProducto = txtIdProducto.getText();
        ProductoBL productoBL = new ProductoBL();
        productoBL.eliminar(idProducto);

    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        if (accion=='R')
            this.insertar();
        
        else if(accion=='M')
            this.modificar();
        
        else
            this.eliminar();
        
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(MantenimientoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
//                new MantenimientoProducto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbFamilia;
    private javax.swing.JComboBox cbUnidad;
    private javax.swing.JCheckBox chbxActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtMaxCantPallet;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
