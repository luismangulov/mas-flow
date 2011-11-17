/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuscarUbicacion.java
 *
 * Created on Oct 2, 2011, 3:13:20 PM
 */
package Mantenimientos.Ubicacion;

import BusinessEntity.AlmacenBE;
import BusinessEntity.RackBE;
import BusinessEntity.UbicacionBE;
import BusinessEntity.ZonaBE;
import BusinessLogic.AlmacenBL;
import BusinessLogic.RackBL;
import BusinessLogic.UbicacionBL;
import BusinessLogic.ZonaBL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author VICTOR
 */
public class BuscarUbicacion extends javax.swing.JFrame {

    /** Creates new form BuscarUbicacion */
    
    String strIdAlmacen;
    String strIdZona;
    String strIdRack;
    String strIdUbicacion;
    
    AlmacenBL objAlmacenBL = new AlmacenBL();
    ZonaBL objZonaBL = new ZonaBL();
    RackBL objRackBL = new RackBL();    
    UbicacionBL objUbicacionBL = new UbicacionBL();    
    
    UbicacionBE objUbicacionBE = new UbicacionBE();
    
    ArrayList<String> arrIdAlmacenes = new ArrayList<String>();
    ArrayList<String> arrIdZonas = new ArrayList<String>();
    ArrayList<String> arrIdRacks = new ArrayList<String>();
    ArrayList<String> arrIdUbicaciones = new ArrayList<String>();
    ArrayList<UbicacionBE> arrUbicaciones;
    
    AdmUbicacion ventanaPadre;
    
    public BuscarUbicacion(AdmUbicacion ventanaPadre) {
        initComponents();
        this.setLocationRelativeTo(null);
        objAlmacenBL = new AlmacenBL();
        this.ventanaPadre = ventanaPadre;
        cargarComboAlmacen();
        cargarComboEstado();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbZona = new javax.swing.JComboBox();
        cbRack = new javax.swing.JComboBox();
        cbUbicacion = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbAlmacen = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("+Flow - Buscar Ubicación");

        jLabel1.setText("Zona:");

        jLabel2.setText("Rack:");

        jLabel3.setText("Ubicación:");

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
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cbAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlmacenActionPerformed(evt);
            }
        });

        jLabel5.setText("Almacén:");

        jLabel4.setText("Estado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5)
                        .addGap(50, 50, 50)
                        .addComponent(cbAlmacen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addGap(70, 70, 70)
                        .addComponent(cbZona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addGap(72, 72, 72)
                        .addComponent(cbRack, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)
                        .addGap(44, 44, 44)
                        .addComponent(cbUbicacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel4)
                        .addGap(61, 61, 61)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnCancelar)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2))
                    .addComponent(cbRack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnCancelar))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cbAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlmacenActionPerformed
    
    int i;
    i = cbAlmacen.getSelectedIndex();
    strIdAlmacen = arrIdAlmacenes.get(i);
    cargarComboZona(strIdAlmacen);
    
}//GEN-LAST:event_cbAlmacenActionPerformed

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

private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
    
    arrUbicaciones = new ArrayList<UbicacionBE>();
    String strIndActivo = "3";
    int intFila = 0;
    int intColumna = 0;
    
    if(cbEstado.getSelectedItem().toString().equals("Bloqueado"))
        strIndActivo = "0";
    else if(cbEstado.getSelectedItem().toString().equals("Disponible"))
        strIndActivo = "1";
    else if(cbEstado.getSelectedItem().toString().equals("En uso"))
        strIndActivo = "2";
    else if(cbEstado.getSelectedItem().toString().equals("Todos"))
        strIndActivo = "3";
    
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
    
    arrUbicaciones = objUbicacionBL.getUbicacionListSearch(strIdAlmacen, strIdZona, strIdRack, strIdUbicacion, strIndActivo);
    
    if (!arrUbicaciones.isEmpty()){
        ventanaPadre.llenarDgv(arrUbicaciones);
        this.dispose();
    }
    else
        JOptionPane.showMessageDialog(null, "No se encontraron ubicaciones", "Advertencia", 0);
    
    
}//GEN-LAST:event_btnBuscarMouseClicked

private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_btnBuscarActionPerformed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    this.dispose();
}//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cbAlmacen;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JComboBox cbRack;
    private javax.swing.JComboBox cbUbicacion;
    private javax.swing.JComboBox cbZona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
        arrUbicaciones = objUbicacionBL.getUbicacionesByRack(idRack,"3");
        
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
    
    public void cargarComboEstado(){
        
        cbEstado.addItem("Todos");
        cbEstado.addItem("En uso");
        cbEstado.addItem("Disponible");
        cbEstado.addItem("Bloqueado");
    }
}
