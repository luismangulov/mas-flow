/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuscarRack.java
 *
 * Created on Oct 2, 2011, 3:29:35 PM
 */
package Mantenimientos.Rack;

import BusinessEntity.AlmacenBE;
import BusinessEntity.RackBE;
import BusinessEntity.ZonaBE;
import BusinessLogic.AlmacenBL;
import BusinessLogic.RackBL;
import BusinessLogic.ZonaBL;
import DataAccess.ZonaDA;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DIEGO
 */
public class BuscarRack extends javax.swing.JFrame {

    /** Creates new form BuscarRack */
    ArrayList<ZonaBE> arrZonas;
    ArrayList<RackBE> arrRacks;
    ZonaBL objZonaBL;
    ZonaDA objZonaDA;
    RackBL objRackBL;
    String strIdZona;
    String strIdRack;
    AdmRack ventanaPadre;
    String strIndActivo;
    AlmacenBL objAlmacenBL;
    
    ArrayList<String> arrIdAlmacenes = new ArrayList<String>();
    ArrayList<String> arrIdZonas = new ArrayList<String>();
    ArrayList<String> arrIdRacks = new ArrayList<String>();
    
    
    public BuscarRack(AdmRack ventanaPadre) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cargarComboAlmacen();
        this.ventanaPadre = ventanaPadre;
        chbxActivos.setSelected(true);
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
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbZona = new javax.swing.JComboBox();
        chbxActivos = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        cbAlmacen = new javax.swing.JComboBox();
        cbRack = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Buscar rack");

        jLabel1.setText("Zona:");

        btnBuscar.setText(" Buscar ");
        btnBuscar.setMaximumSize(new java.awt.Dimension(75, 23));
        btnBuscar.setMinimumSize(new java.awt.Dimension(75, 23));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        jLabel2.setText("Rack:");

        cbZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbZonaActionPerformed(evt);
            }
        });

        chbxActivos.setText("Activos");

        jLabel3.setText("Almacén:");

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
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbxActivos)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbRack, 0, 106, Short.MAX_VALUE)
                            .addComponent(cbZona, 0, 106, Short.MAX_VALUE)
                            .addComponent(cbAlmacen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbRack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(chbxActivos)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cbZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbZonaActionPerformed
    int intCantItem = cbZona.getItemCount() - 1;
    if (intCantItem > 0){
        String strIdAlmacen = arrIdAlmacenes.get(cbAlmacen.getSelectedIndex());
        if (!cbZona.getSelectedItem().equals("Seleccione") && !cbZona.getSelectedItem().equals("")){
            strIdZona = arrIdZonas.get(cbZona.getSelectedIndex()-1);
            cargarComboRack(strIdZona);
        }else if (cbZona.getSelectedItem().equals("Seleccione")){
            cbRack.removeAllItems();
            cbRack.addItem("");
        }
    }
   
}//GEN-LAST:event_cbZonaActionPerformed

private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        
        objAlmacenBL = new AlmacenBL();
        String strIdAlmacen = arrIdAlmacenes.get(cbAlmacen.getSelectedIndex());
    
        objZonaBL = new ZonaBL();
        if (!cbZona.getSelectedItem().toString().equals("Seleccione") && !cbZona.getSelectedItem().toString().equals("")){
            strIdZona = arrIdZonas.get(cbZona.getSelectedIndex()-1);
        }
        else 
            strIdZona = "";
        
        objRackBL = new RackBL();
        if (!cbRack.getSelectedItem().toString().equals("Seleccione") && !cbRack.getSelectedItem().toString().equals("")){
            strIdRack = arrIdRacks.get(cbRack.getSelectedIndex()-1);
        }
        else 
            strIdRack = "";
        
        if (chbxActivos.isSelected())
            strIndActivo = "1";
        else 
            strIndActivo = "0";
            
        objRackBL = new RackBL();
        arrRacks = objRackBL.getListSearch(strIdAlmacen, strIdRack, strIdZona, strIndActivo);
        
        if (arrRacks.size()!=0){
            ventanaPadre.llenarDgv(arrRacks);
            this.dispose();
        }
        
        else
            JOptionPane.showMessageDialog(null, "No se encontraron racks", "Advertencia", 0);
}//GEN-LAST:event_btnBuscarMouseClicked

private void cbAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlmacenActionPerformed
    objAlmacenBL = new AlmacenBL();
    int i;
    i = cbAlmacen.getSelectedIndex();
    String strIdAlmacen = arrIdAlmacenes.get(i);
    cargarComboZona(strIdAlmacen);
}//GEN-LAST:event_cbAlmacenActionPerformed

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
    private javax.swing.JComboBox cbZona;
    private javax.swing.JCheckBox chbxActivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    public void cargarComboAlmacen(){
        
        cbAlmacen.removeAllItems();
        cbZona.removeAllItems();
        cbRack.removeAllItems();
        cbZona.addItem("");
        cbRack.addItem("");
        
        ArrayList<AlmacenBE> arrAlmacenes = new ArrayList<AlmacenBE>();
        objAlmacenBL = new AlmacenBL();
        arrAlmacenes = objAlmacenBL.getAllAlmacenActivo();
        
        if (arrAlmacenes != null)
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
        
        arrIdZonas.clear();
        
        if (arrZonas != null)
            for(ZonaBE zona : arrZonas){
                arrIdZonas.add(zona.getIdZona());
                cbZona.addItem(zona.getIdentificador().trim());
            }
    }
    
    public void cargarComboRack(String idZona){
        
        cbRack.removeAllItems();        
        
        ArrayList<RackBE>arrRacks = new ArrayList<RackBE>();
        objRackBL = new RackBL();
        arrRacks = objRackBL.getRacksByZona(idZona);

        if (arrRacks.size()<=0){
            cbRack.addItem("");
            return;
        }
        
        cbRack.addItem("Seleccione");
        
        arrIdRacks.clear();
        
        for(RackBE rack : arrRacks){
                arrIdRacks.add(rack.getIdRack());
                cbRack.addItem(rack.getIdentificador());
        }
    }
}
