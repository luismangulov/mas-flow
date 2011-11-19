/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuscarPallet.java
 *
 * Created on Oct 2, 2011, 3:27:34 PM
 */
package Procesamiento.MovimientosInternos;

import BusinessEntity.*;
import BusinessLogic.*;
import Util.Utilitario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DIEGO
 */


public class BuscarPallet extends javax.swing.JFrame {

    /** Creates new form BuscarPallet */
    ReubicarPallet ventanaPadreReubicar = null;
    DesecharPalletsPorCaducidad ventanaPadreDesecharPallets = null;
    AlmacenBL objAlmacenBL = new AlmacenBL();
    
    ArrayList<String> arrIdAlmacenes = new ArrayList<String>();
    ArrayList<String> arrIdZonas = new ArrayList<String>();
    ArrayList<String> arrIdRacks = new ArrayList<String>();
    ArrayList<String> arrIdUbicaciones = new ArrayList<String>();
    
    ArrayList<PalletBE> arrPallets = new ArrayList<PalletBE>();
    ArrayList<AlmacenBE> arrAlmacenes = new ArrayList<AlmacenBE>();
    ArrayList<ZonaBE> arrZonas = new ArrayList<ZonaBE>();
    ArrayList<RackBE> arrRacks = new ArrayList<RackBE>();
    ArrayList<UbicacionBE> arrUbicaciones = new ArrayList<UbicacionBE>();
                
    PalletBL objPalletBL = new PalletBL();
    String strIdPallet;
    String strIdProducto;
    String strNombreAlmacen;
    String strIdAlmacen;
    
    String strIdZona;
    String strIdRack;
    String strIdUbicacion;
    
    ZonaBL objZonaBL = new ZonaBL();
    RackBL objRackBL = new RackBL();    
    UbicacionBL objUbicacionBL = new UbicacionBL();    
    
    UbicacionBE objUbicacionBE = new UbicacionBE();
    
    
    public BuscarPallet(ReubicarPallet ventanaPadre) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaPadreReubicar = ventanaPadre;
        cargarComboAlmacen();
    }
    
    public BuscarPallet(DesecharPalletsPorCaducidad ventanaPadre) {        
        initComponents();
        this.setLocationRelativeTo(null); 
        this.ventanaPadreDesecharPallets = ventanaPadre;
        cargarComboAlmacen();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIdPallet = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbZona = new javax.swing.JComboBox();
        cbRack = new javax.swing.JComboBox();
        cbUbicacion = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cbAlmacen = new javax.swing.JComboBox();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Buscar pallet");
        setResizable(false);

        jLabel1.setText("Código:");

        txtIdPallet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPalletActionPerformed(evt);
            }
        });
        txtIdPallet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdPalletKeyTyped(evt);
            }
        });

        jLabel4.setText("<html>Nombre del<br>Producto:</html>");

        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyTyped(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        jLabel3.setText("Rack:");

        jLabel5.setText("Ubicación:");

        jLabel6.setText("Zona:");

        cbZona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbZonaMouseClicked(evt);
            }
        });
        cbZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbZonaActionPerformed(evt);
            }
        });

        cbRack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRackActionPerformed(evt);
            }
        });

        cbUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUbicacionActionPerformed(evt);
            }
        });

        jLabel7.setText("Almacén:");

        cbAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbAlmacenMouseClicked(evt);
            }
        });
        cbAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlmacenActionPerformed(evt);
            }
        });

        btnGuardar.setText("Buscar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(29, 29, 29)
                            .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbRack, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(49, 49, 49)
                                    .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(jLabel5)
                                    .addGap(23, 23, 23)
                                    .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(81, 81, 81)
                                    .addComponent(btnGuardar)
                                    .addGap(37, 37, 37)
                                    .addComponent(btnCancelar)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)
                        .addComponent(txtIdPallet, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtIdPallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cbRack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel5))
                        .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdPalletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPalletActionPerformed

    }//GEN-LAST:event_txtIdPalletActionPerformed

private void cbZonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbZonaMouseClicked
//NO
}//GEN-LAST:event_cbZonaMouseClicked

private void cbZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbZonaActionPerformed
    int intCantItem = cbZona.getItemCount() - 1;
    if (intCantItem > 0){
        strIdAlmacen = arrIdAlmacenes.get(cbAlmacen.getSelectedIndex());
        if (!cbZona.getSelectedItem().equals("Seleccione") && !cbZona.getSelectedItem().equals("")){
            strIdZona = arrIdZonas.get(cbZona.getSelectedIndex()-1);
            cargarComboRack(strIdZona);
        }else if (cbZona.getSelectedItem().equals("Seleccione")){
            cbRack.removeAllItems();
            cbUbicacion.removeAllItems();
            cbRack.addItem("");
            cbUbicacion.addItem("");
        }
    }
}//GEN-LAST:event_cbZonaActionPerformed

private void cbRackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRackActionPerformed
    int intCantItem = cbRack.getItemCount() - 1;
    if (intCantItem > 0){
        if (!cbRack.getSelectedItem().equals("Seleccione") && !cbRack.getSelectedItem().equals("")){
            strIdRack = arrIdRacks.get(cbRack.getSelectedIndex()-1);
            cargarComboUbicacion(strIdRack);
        }else if (cbRack.getSelectedItem().equals("Seleccione")){
            cbUbicacion.removeAllItems();
            cbUbicacion.addItem("");
        }
    }
}//GEN-LAST:event_cbRackActionPerformed

private void cbUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUbicacionActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_cbUbicacionActionPerformed

private void cbAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbAlmacenMouseClicked
//NO
}//GEN-LAST:event_cbAlmacenMouseClicked

private void cbAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlmacenActionPerformed
    
    int i;
    i = cbAlmacen.getSelectedIndex();
    strIdAlmacen = arrIdAlmacenes.get(i);
    cargarComboZona(strIdAlmacen);
}//GEN-LAST:event_cbAlmacenActionPerformed

private void txtIdPalletKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdPalletKeyTyped
    char c = (char)evt.getKeyChar();
    if (!Utilitario.validarSoloNumeros(evt.getKeyChar()) || (Character.isISOControl(c)))
    evt.consume();
    if ((this.txtIdPallet.getText().length() + 1) > 6) {
    evt.consume();
    
    }
}//GEN-LAST:event_txtIdPalletKeyTyped

private void txtNombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyTyped
    char c = (char)evt.getKeyChar();
    if (!Utilitario.validarCadenaAlfabetica(evt.getKeyChar()) || (Character.isISOControl(c)))
    evt.consume();
    if ((this.txtNombreProducto.getText().length() + 1) > 20) {
    evt.consume();
    
    }
}//GEN-LAST:event_txtNombreProductoKeyTyped

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked

        PalletBE objPalletBE;
        strIdPallet = txtIdPallet.getText();
        String strNombreProducto = txtNombreProducto.getText();


        if (!cbUbicacion.getSelectedItem().toString().equals("Seleccione") && !cbUbicacion.getSelectedItem().toString().equals("")){

            strIdUbicacion = arrIdUbicaciones.get(cbUbicacion.getSelectedIndex()-1);
        }else
            strIdUbicacion = "";

        if (!cbRack.getSelectedItem().toString().equals("Seleccione") && !cbRack.getSelectedItem().toString().equals("")){

            strIdRack = arrIdRacks.get(cbRack.getSelectedIndex()-1);

        }else
            strIdRack = "";

        if (!cbZona.getSelectedItem().toString().equals("Seleccione") && !cbZona.getSelectedItem().toString().equals("")){

            strIdZona = arrIdZonas.get(cbZona.getSelectedIndex()-1);

        }else
            strIdZona = "";

        if (!cbAlmacen.getSelectedItem().toString().equals("")){

            int i = cbAlmacen.getSelectedIndex();
            strIdAlmacen = arrIdAlmacenes.get(i);

        }else
            strIdAlmacen = "";

        arrPallets = objPalletBL.getPalletListSearch(strIdAlmacen, strIdZona, strIdRack, strIdUbicacion, strNombreProducto.toUpperCase(), strIdPallet);

        if (!arrPallets.isEmpty()){
            if (ventanaPadreReubicar != null)
                ventanaPadreReubicar.llenarDgv(arrPallets);
            if (ventanaPadreDesecharPallets != null)
                ventanaPadreDesecharPallets.llenarDgv(arrPallets);
            this.dispose();
        }
        else
            JOptionPane.showMessageDialog(null, "No se encontraron pallets", "Mensaje", 1);
    
    }//GEN-LAST:event_btnGuardarMouseClicked


    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbAlmacen;
    private javax.swing.JComboBox cbRack;
    private javax.swing.JComboBox cbUbicacion;
    private javax.swing.JComboBox cbZona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtIdPallet;
    private javax.swing.JTextField txtNombreProducto;
    // End of variables declaration//GEN-END:variables
    
    public void cargarComboAlmacen(){
        
        cbAlmacen.removeAllItems();
        cbZona.removeAllItems();
        cbRack.removeAllItems();
        cbUbicacion.removeAllItems();    
        
        ArrayList<AlmacenBE> arrAlmacenes = new ArrayList<AlmacenBE>();
        arrAlmacenes = objAlmacenBL.getAllAlmacenActivo();
        
        if (arrAlmacenes.size() >= 0)
            for(AlmacenBE almacen : arrAlmacenes){
                arrIdAlmacenes.add(almacen.getIdAlmacen());
                cbAlmacen.addItem(almacen.getIdentificador().trim());
            }
    }
    
    public void cargarComboZona(String idAlmacen){
        
        cbZona.removeAllItems();
        cbRack.removeAllItems();
        cbUbicacion.removeAllItems();

        ArrayList<ZonaBE> arrZonas = new ArrayList<ZonaBE>();
        objZonaBL = new ZonaBL();
        arrZonas = objZonaBL.getZonasByAlmacen(idAlmacen);
        
        if (arrZonas.size() <= 0){
            cbZona.addItem("");
            return;
        }
        
        cbZona.addItem("Seleccione");
        cbRack.addItem("");
        cbUbicacion.addItem("");
        
        arrIdZonas.clear();
        
        if (arrZonas != null)
            for(ZonaBE zona : arrZonas){
                arrIdZonas.add(zona.getIdZona());
                cbZona.addItem(zona.getIdentificador().trim());
            }
    }
    
    public void cargarComboRack(String idZona){
        
        cbRack.removeAllItems(); 
        cbUbicacion.removeAllItems();
        
        ArrayList<RackBE>arrRacks = new ArrayList<RackBE>();
        objRackBL = new RackBL();
        arrRacks = objRackBL.getRacksByZona(idZona);

        if (arrRacks.size()<=0){
            cbRack.addItem("");
            return;
        }
        
        cbRack.addItem("Seleccione");
        cbUbicacion.addItem("");
        
        arrIdRacks.clear();
        
        for(RackBE rack : arrRacks){
                arrIdRacks.add(rack.getIdRack());
                cbRack.addItem(rack.getIdentificador());
        }
    }
    
    public void cargarComboUbicacion(String idRack){
       
        cbUbicacion.removeAllItems();

        arrUbicaciones = new ArrayList<UbicacionBE>();
        arrUbicaciones = objUbicacionBL.getUbicacionesByRack(idRack,"2");
        
        if (arrUbicaciones.size()<=0){
            cbUbicacion.addItem(""); 
            return;
        }
        cbUbicacion.addItem("Seleccione"); 
        
        arrIdUbicaciones.clear();

        for(UbicacionBE ubicacion : arrUbicaciones){
            arrIdUbicaciones.add(ubicacion.getIdUbicacion());
            cbUbicacion.addItem("F" + ubicacion.getFila() + "C" + ubicacion.getColumna());
        }
        
    }

}
