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
import Util.Utilitario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author VICTOR
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
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.accion = c;
        this.ventanaPadre = ventanaPadre;
        this.txtIdProducto.setEnabled(false);
        ProductoBL objProductoBL = new ProductoBL();
        objProducto = objProductoBL.getByIdProducto(idProducto);
        this.cargarComponentes(objProducto);
        this.setTitle("Modificar Producto");
        chbxActivo.setSelected(true);
        
    }

    public MantenimientoProducto(AdmProducto ventanaPadre) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.txtIdProducto.setEnabled(false);
        this.accion = 'R';
        this.cargarComboUnidadMedida();
        this.cargarComboFamilia();
        chbxActivo.setSelected(true);
        this.ventanaPadre = ventanaPadre;
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
        jLabel5 = new javax.swing.JLabel();
        cbUnidad = new javax.swing.JComboBox();
        chbxActivo = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Registrar producto");

        jLabel1.setText("Código:");

        txtIdProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdProductoKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombre*:");

        jLabel3.setText("Descripción*:");

        jLabel4.setText("Familia*:");

        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel6.setText("<html>Máx. Cant.<br>por pallet*</html>");

        txtMaxCantPallet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaxCantPalletKeyTyped(evt);
            }
        });

        jLabel5.setText("Unidad*:");

        chbxActivo.setText("Activo");

        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(cbFamilia, 0, 236, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbUnidad, 0, 236, Short.MAX_VALUE)
                            .addComponent(txtMaxCantPallet, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(chbxActivo)
                .addContainerGap(336, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnGuardar)
                .addGap(55, 55, 55)
                .addComponent(btnCancelar)
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
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
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaxCantPallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(chbxActivo)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertar(){
        
        if (!validar())
            return;
        
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
        
        if (!validar())
            return;
        
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
        boolExito = productoBL.modificar(productoBE);     
       
        if (boolExito){
            arrProductos = new ArrayList<ProductoBE>();
            arrProductos.add(productoBE);
            this.ventanaPadre.llenarDgv(arrProductos);
            this.dispose();
        }
    }

private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped

    char c = (char)evt.getKeyChar();
    if (!Utilitario.validarCadenaAlfabetica(evt.getKeyChar()) || (Character.isISOControl(c)))
    evt.consume();
    if ((this.txtNombre.getText().length() + 1) > 30) {
    evt.consume();
    }
    
}//GEN-LAST:event_txtNombreKeyTyped

private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
       
    char c = (char)evt.getKeyChar();
    if (!Utilitario.validarCadenaAlfaNumerica(evt.getKeyChar()) || (Character.isISOControl(c)))
       evt.consume();
    if ((this.txtDescripcion.getText().length() + 1) > 30) {
       evt.consume();
    }
}//GEN-LAST:event_txtDescripcionKeyTyped

private void txtMaxCantPalletKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaxCantPalletKeyTyped

    char c = (char)evt.getKeyChar();
    if (!Utilitario.validarSoloNumeros(evt.getKeyChar()) || (Character.isISOControl(c)))
       evt.consume();
    if ((this.txtMaxCantPallet.getText().length() + 1) > 6) {
       evt.consume();
    }
   
}//GEN-LAST:event_txtMaxCantPalletKeyTyped

private void txtIdProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProductoKeyTyped
    char c = (char)evt.getKeyChar();
    if (!Utilitario.validarSoloNumeros(evt.getKeyChar()) || (Character.isISOControl(c)))
    evt.consume();
    if ((this.txtIdProducto.getText().length() + 1) > 6) {
    evt.consume();
    
    }
}//GEN-LAST:event_txtIdProductoKeyTyped

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked

        if (accion=='R')
            this.insertar();
        
        else if(accion=='M')
            this.modificar();
        
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    /**
     * @param args the command line arguments
     */

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
   
    private void cargarComponentes(ProductoBE objProducto){
        
        FamiliaDA objFamiliaDA = new FamiliaDA();
        UnidadMedidaDA objUnidadMedidaDA = new UnidadMedidaDA();
        
        txtIdProducto.setText(objProducto.getIdProducto());
        txtNombre.setText(objProducto.getNombre());
        txtDescripcion.setText(objProducto.getDescripcion());
        txtMaxCantPallet.setText(String.valueOf(objProducto.getMaxCantPorPallet()));
        
        if (objProducto.getEstado().equals("0"))
            chbxActivo.setSelected(false);
        else
            chbxActivo.setSelected(true);
        
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
    
    public boolean validar(){
        
        if(txtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del producto");
            return false;
        }
        
        if(txtDescripcion.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar la descripción del producto");
            return false;
        }
        
        if(txtMaxCantPallet.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad máxima del producto en el pallet");
            return false;
        }else{
            if (Integer.parseInt(txtMaxCantPallet.getText()) <= 0){
                JOptionPane.showMessageDialog(null, "La cantidad máxima dentro de un pallet debe ser mayor a 0");
                return false;
            }
        }
        
        if(cbFamilia.getItemCount() == 0){
            JOptionPane.showMessageDialog(null, "No hay familias");
            return false;
        }else{
            if (!cbFamilia.getSelectedItem().equals("Seleccione")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una familia de producto");
                return false;
            }
        }
        
        if(cbUnidad.getItemCount() == 0){
            JOptionPane.showMessageDialog(null, "No hay unidades de medida");
            return false;
        }else{
            if (!cbUnidad.getSelectedItem().equals("Seleccione")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una unidad de medida");
                return false;
            }
                
        }
            
        return true;
    }
}
