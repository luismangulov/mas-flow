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
        txtIdProducto = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbZona = new javax.swing.JComboBox();
        cbRack = new javax.swing.JComboBox();
        cbUbicacion = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cbAlmacen = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Buscar pallet");

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

        jLabel4.setText("Producto:");

        txtIdProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdProductoKeyTyped(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        jLabel3.setText("Rack:");

        jLabel5.setText("Ubicacion:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(jLabel1)
                            .addGap(41, 41, 41)
                            .addComponent(txtIdPallet, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(jLabel4)
                            .addGap(29, 29, 29)
                            .addComponent(txtIdProducto))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(jLabel7)
                            .addGap(29, 29, 29)
                            .addComponent(cbAlmacen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(jLabel6)
                            .addGap(49, 49, 49)
                            .addComponent(cbZona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(jLabel3)
                            .addGap(51, 51, 51)
                            .addComponent(cbRack, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(jLabel5)
                            .addGap(23, 23, 23)
                            .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(btnBuscar)
                        .addGap(37, 37, 37)
                        .addComponent(btnCancelar)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1))
                    .addComponent(txtIdPallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addComponent(cbRack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdPalletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPalletActionPerformed

    }//GEN-LAST:event_txtIdPalletActionPerformed

private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        
    PalletBE objPalletBE;
    strIdPallet = txtIdPallet.getText();
    strIdProducto = txtIdProducto.getText();
    int intFila = 0;
    int intColumna = 0;
    
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
    
    arrPallets = objPalletBL.getPalletListSearch(strIdAlmacen, strIdZona, strIdRack, intFila, intColumna, strIdPallet, strIdProducto);
    
    if (!arrPallets.isEmpty()){
        if (ventanaPadreReubicar != null)
            ventanaPadreReubicar.llenarDgv(arrPallets);
        if (ventanaPadreDesecharPallets != null)
            ventanaPadreDesecharPallets.llenarDgv(arrPallets);
        this.dispose();
    }
    else
        JOptionPane.showMessageDialog(null, "No se encontraron pallets", "Advertencia", 0);
    
}//GEN-LAST:event_btnBuscarMouseClicked

private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_btnBuscarActionPerformed

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
        }
    }
}//GEN-LAST:event_cbZonaActionPerformed

private void cbRackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRackActionPerformed
    int intCantItem = cbRack.getItemCount() - 1;
    if (intCantItem > 0){
        if (!cbRack.getSelectedItem().equals("Seleccione") && !cbRack.getSelectedItem().equals("")){
            strIdRack = arrIdRacks.get(cbRack.getSelectedIndex()-1);
            cargarComboUbicacion(strIdRack);
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

private void txtIdProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProductoKeyTyped
    char c = (char)evt.getKeyChar();
    if (!Utilitario.validarSoloNumeros(evt.getKeyChar()) || (Character.isISOControl(c)))
    evt.consume();
    if ((this.txtIdProducto.getText().length() + 1) > 6) {
    evt.consume();
    
    }
}//GEN-LAST:event_txtIdProductoKeyTyped

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked


    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
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
    private javax.swing.JTextField txtIdProducto;
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
        
        if (arrZonas != null)
            for(ZonaBE zona : arrZonas){
                arrIdZonas.add(zona.getIdZona());
                cbZona.addItem(zona.getIdentificador().trim());
            }
    }
    
    public void cargarComboRack(String idZona){
        
        cbRack.removeAllItems();        
        
        ArrayList<RackBE> arrRacks = new ArrayList<RackBE>();
        objRackBL = new RackBL();
        arrRacks = objRackBL.getRacksByZona(idZona);

        if (arrRacks.size()<=0){
            cbRack.addItem("");
            return;
        }
        
        cbRack.addItem("Seleccione");
        cbUbicacion.addItem("");
        
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

        for(UbicacionBE ubicacion : arrUbicaciones){
            arrIdUbicaciones.add(ubicacion.getIdUbicacion());
            cbUbicacion.addItem("F" + ubicacion.getFila() + "C" + ubicacion.getColumna());
        }
        
    }

}
