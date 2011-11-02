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

import Procesamiento.MovimientosInternos.AdmMovimientosInternos;
import BusinessEntity.AlmacenBE;
import BusinessEntity.PalletBE;
import BusinessEntity.RackBE;
import BusinessEntity.UbicacionBE;
import BusinessEntity.ZonaBE;
import BusinessLogic.AlmacenBL;
import BusinessLogic.PalletBL;
import BusinessLogic.ProductoBL;
import BusinessLogic.RackBL;
import BusinessLogic.UbicacionBL;
import BusinessLogic.ZonaBL;
import java.util.ArrayList;

/**
 *
 * @author DIEGO
 */


public class BuscarPallet extends javax.swing.JFrame {

    /** Creates new form BuscarPallet */
    ReubicarPallet ventanaPadreReubicar = null;
    DesecharPalletsPorCaducidad ventanaPadreMant = null;
    AlmacenBL objAlmacenBL = new AlmacenBL();

    ArrayList<PalletBE> arrPallets;
    
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
        this.setLocationRelativeTo(null); 
        initComponents();
        this.ventanaPadreReubicar = ventanaPadre;
        cargarComboAlmacen();
    }
    
    public BuscarPallet(DesecharPalletsPorCaducidad ventanaPadre) {
        this.setLocationRelativeTo(null); 
        initComponents();
        this.ventanaPadreMant = ventanaPadre;
        cargarComboAlmacen();
    }
    
    public void cargarComboAlmacen(){
        
        cbAlmacen.removeAllItems();
        cbZona.removeAllItems();
        cbRack.removeAllItems();
        cbUbicacion.removeAllItems();
        
        ArrayList<AlmacenBE> arrAlmacenes = new ArrayList<AlmacenBE>();
        arrAlmacenes = objAlmacenBL.getAllAlmacenActivo();
        
        if (arrAlmacenes != null)
            for(AlmacenBE almacen : arrAlmacenes)
                cbAlmacen.addItem(almacen.getIdAlmacen());

    }
    
    public void cargarComboZona(String idAlmacen){
        
        cbZona.removeAllItems();
        cbRack.removeAllItems();
        cbUbicacion.removeAllItems();
        cbZona.addItem("");
        cbRack.addItem("");
        cbUbicacion.addItem(""); 

        ArrayList<ZonaBE> arrZonas = new ArrayList<ZonaBE>();
        arrZonas = objZonaBL.getZonasByAlmacen(idAlmacen);
        
        if (arrZonas != null)
            for(ZonaBE zona : arrZonas)
                cbZona.addItem(zona.getIdentificador());
        
    }
    
    public void cargarComboRack(String idZona){
        
        cbRack.removeAllItems();        
        cbUbicacion.removeAllItems();
        cbRack.addItem("");
        cbUbicacion.addItem(""); 
               
        ArrayList<RackBE> arrRacks = new ArrayList<RackBE>();
        arrRacks = objRackBL.getRacksByZona(idZona);
        
        if (arrRacks != null)
            for(RackBE rack : arrRacks)
                cbRack.addItem(rack.getIdentificador());
        
    }
    
    public void cargarComboUbicacion(String idRack){
       
        cbUbicacion.removeAllItems();
        cbUbicacion.addItem(""); 
        ArrayList<UbicacionBE> arrUbicaciones = new ArrayList<UbicacionBE>();
        arrUbicaciones = objUbicacionBL.getUbicacionesByRack(idRack,"2"); // "2" porque se buscarán solo las ubicaciones que estén ocupadas
        
        if (arrUbicaciones != null)
            for(UbicacionBE ubicacion : arrUbicaciones)
                cbUbicacion.addItem("F" + ubicacion.getFila() + "C" + ubicacion.getColumna());
        
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

        jLabel4.setText("Producto:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnBuscar)
                        .addGap(37, 37, 37)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)))
                            .addComponent(jLabel1))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdPallet, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbRack, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdPallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(cbRack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
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
    
    String strIndActivo;
    PalletBE objPalletBE;
    
    if (!cbUbicacion.getSelectedItem().toString().equals("")){
        
        strIdRack = objRackBL.getByIdentificador(cbRack.getSelectedItem().toString()).getIdRack();
        int intFila = cbUbicacion.getSelectedItem().toString().charAt(1)-48;
        int intColumna = cbUbicacion.getSelectedItem().toString().charAt(3)-48;
        objUbicacionBE = objUbicacionBL.getUbicacionByRackFilaColumna(strIdRack,intFila,intColumna,"2");
        if (objUbicacionBE != null){
            objPalletBE =objPalletBL.getPalletByIdUbicacion(objUbicacionBE.getIdUbicacion());
            arrPallets.add(objPalletBE);
        }
        
    }
    else if (cbUbicacion.getSelectedItem().toString().equals("") && !cbRack.getSelectedItem().toString().equals("")){
        
        strIdRack = objRackBL.getByIdentificador(cbRack.getSelectedItem().toString()).getIdRack();
        arrPallets = objPalletBL.getPalletsByRack(strIdRack);
    }
    else if (cbRack.getSelectedItem().toString().equals("") && !cbZona.getSelectedItem().toString().equals("")){
        
        strIdZona = objZonaBL.getByIdentificadorZona(cbZona.getSelectedItem().toString()).getIdZona();
        arrPallets = objPalletBL.getPalletsByZona(strIdZona);
        
    }
    else if (cbZona.getSelectedItem().toString().equals("") && !cbAlmacen.getSelectedItem().toString().equals("")){
        
        strIdAlmacen = cbAlmacen.getSelectedItem().toString();
        arrPallets = objPalletBL.getPalletsByAlmacen(strIdAlmacen);
        
    }
    
    if (ventanaPadreReubicar != null)
        ventanaPadreReubicar.llenarDgv(arrPallets);

    this.dispose();
    
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
        if (!cbZona.getSelectedItem().equals("")){
            strIdZona = objZonaBL.getByIdentificadorZona(cbZona.getSelectedItem().toString()).getIdZona();
            cargarComboRack(strIdZona);
        }
    }
}//GEN-LAST:event_cbZonaActionPerformed

private void cbRackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRackActionPerformed
    int intCantItem = cbRack.getItemCount() - 1;
    if (intCantItem > 0){
        if (!cbRack.getSelectedItem().equals("")){
            String strIdentificador = cbRack.getSelectedItem().toString();
            strIdRack = objRackBL.getByIdentificador(strIdentificador).getIdRack();
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
    strIdAlmacen = cbAlmacen.getSelectedItem().toString();
    cargarComboZona(strIdAlmacen);
}//GEN-LAST:event_cbAlmacenActionPerformed


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
}
