/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ReubicarPallet.java
 *
 * Created on Oct 2, 2011, 3:31:13 PM
 */
package Procesamiento.MovimientosInternos;

import BusinessEntity.AlmacenBE;
import BusinessEntity.PalletBE;
import BusinessEntity.ProductoBE;
import BusinessEntity.RackBE;
import BusinessEntity.UbicacionBE;
import BusinessEntity.ZonaBE;
import BusinessLogic.AlmacenBL;
import BusinessLogic.PalletBL;
import BusinessLogic.ProductoBL;
import BusinessLogic.RackBL;
import BusinessLogic.UbicacionBL;
import BusinessLogic.UnidadMedidaBL;
import BusinessLogic.ZonaBL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class ReubicarPallet extends javax.swing.JFrame {

    /** Creates new form ReubicarPallet */
    String strIdAlmacen;
    String strIdZona;
    String strIdRack;
    String strIdUbicacionDestino;
    String strIdUbicacionOrigen;
    String strIdPallet;
    
    AlmacenBL objAlmacenBL = new AlmacenBL();   
    ZonaBL objZonaBL = new ZonaBL();
    RackBL objRackBL = new RackBL();    
    UbicacionBL objUbicacionBL = new UbicacionBL();    
    
    UbicacionBE objUbicacionBE = new UbicacionBE();
    
    ArrayList<PalletBE> arrPallets;
    ArrayList<UbicacionBE> arrUbicaciones;
    
    AdmMovimientosInternos ventanaPadre;
    
    public ReubicarPallet(AdmMovimientosInternos ventanaPadre) {
        this.setLocationRelativeTo(null); 
        initComponents();
        this.ventanaPadre = ventanaPadre;
//        this.strIdUbicacionOrigen = idUbicacionOrigen;
//        this.strIdPallet = idPallet;
//        txtIdPallet.setText(idPallet);
//        txtIdUbicacionOrigen.setText(idUbicacionOrigen);
//        txtIdUbicacionOrigen.setEnabled(false);
//        txtIdPallet.setEnabled(false);
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
        arrUbicaciones = objUbicacionBL.getUbicacionesByRack(idRack);
        
        if (arrUbicaciones != null)
            for(UbicacionBE ubicacion : arrUbicaciones)
                cbUbicacion.addItem("F" + ubicacion.getFila() + "C" + ubicacion.getColumna());
        
    }
    
    public void llenarDgv(ArrayList<PalletBE> arrPallets){
        
        DefaultTableModel modelo=(DefaultTableModel) dgvPallets.getModel();    
        limpiarDgv();
        this.arrPallets = arrPallets;
        dgvPallets.clearSelection();
        ProductoBL objProductoBL = new ProductoBL();                
        UbicacionBL objUbicacionBL = new UbicacionBL();
        RackBL objRackBL = new RackBL();
        UnidadMedidaBL objUnidadMedidaBL = new UnidadMedidaBL();
        String strNombreProducto = "";
        int intMaxCantPallet = 0;
        int intFila = 0;
        int intColumna = 0;
        String strIdentificadorRack = "";
        String fecha = "";
        String strIdUnidadMedida = "";
        String strNombreUnidadMedida = "";
        PalletBE palletBE = new PalletBE();
        ProductoBE objProductoBE = new ProductoBE();
        
        if(arrPallets != null){
        
            for (int i=0; i<arrPallets.size(); i++){

                String strIdPallet = arrPallets.get(i).getIdPallet();

                String strIdProducto = arrPallets.get(i).getIdProducto().trim();

                 if (!strIdProducto.equals("")){
                    objProductoBE = objProductoBL.getByIdProducto(arrPallets.get(i).getIdProducto());
                    strNombreProducto = objProductoBE.getNombre();
                    intMaxCantPallet = objProductoBE.getMaxCantPorPallet();
                    strIdUnidadMedida = objProductoBE.getIdUnidadMedida();
                    strNombreUnidadMedida = objUnidadMedidaBL.getUnidadMedida(strIdUnidadMedida).getNombre();
                }

                String strIdUbicacion = arrPallets.get(i).getIdUbicacion().trim();

                if (!strIdUbicacion.equals("")){
                    intFila = objUbicacionBL.getUbicacionById(strIdUbicacion).getFila();
                    intColumna = objUbicacionBL.getUbicacionById(strIdUbicacion).getColumna();
                    strIdentificadorRack = objRackBL.getRackByIdUbicacion(strIdUbicacion).getIdentificador();
                }

                if (palletBE.getFechaVencimiento() != null)
                  fecha = palletBE.getFechaVencimiento().toString();

                modelo.addRow(new Object[]{strIdPallet,strNombreProducto,strIdentificadorRack, strIdUbicacion, intMaxCantPallet,strNombreUnidadMedida,fecha});
            }
        }
    }
    
    public void limpiarDgv(){
                
        DefaultTableModel modelo=(DefaultTableModel) dgvPallets.getModel();    
        for(int i=modelo.getRowCount()-1; i>=0; i--){
            modelo.removeRow(i);
        }
    }
    
    public void eliminaFilaDgv(int fila){
        DefaultTableModel modelo=(DefaultTableModel) dgvPallets.getModel();  
        modelo.removeRow(fila);
    }
    
    
    public void actualizaDgv(PalletBE palletBE){

       DefaultTableModel modelo=(DefaultTableModel) dgvPallets.getModel();    
        for(int i=modelo.getRowCount()-1; i>=0; i--){
            modelo.removeRow(i);
        }
        dgvPallets.clearSelection();
        ProductoBL objProductoBL = new ProductoBL();                
        UbicacionBL objUbicacionBL = new UbicacionBL();
        RackBL objRackBL = new RackBL();
        UnidadMedidaBL objUnidadMedidaBL = new UnidadMedidaBL();
        String strNombreProducto = "";
        int intMaxCantPallet = 0;
        int intFila = 0;
        int intColumna = 0;
        String strIdentificadorRack = "";
        String strIdUnidad = "";
        String fecha = "";
        String strIdPallet = palletBE.getIdPallet();
        String strNombreUnidad = "";
        
        String strIdProducto = palletBE.getIdProducto().trim();
        
        if (!strIdProducto.equals("")){
            strNombreProducto = objProductoBL.getByIdProducto(strIdProducto).getNombre();
            intMaxCantPallet = objProductoBL.getByIdProducto(strIdProducto).getMaxCantPorPallet();
            strIdUnidad = objProductoBL.getByIdProducto(strIdProducto).getIdUnidadMedida();
            strNombreUnidad = objUnidadMedidaBL.getUnidadMedida(strIdUnidad).getNombre();
            
        }

        String strIdUbicacion = palletBE.getIdUbicacion().trim();

        if (!strIdUbicacion.equals("")){
            intFila = objUbicacionBL.getUbicacionById(strIdUbicacion).getFila();
            intColumna = objUbicacionBL.getUbicacionById(strIdUbicacion).getColumna();
            strIdentificadorRack = objRackBL.getRackByIdUbicacion(strIdUbicacion).getIdentificador();
        }
        
        if (palletBE.getFechaVencimiento() != null)
            fecha = palletBE.getFechaVencimiento().toString();
       
        modelo.addRow(new Object[]{strIdPallet,strNombreProducto,strIdentificadorRack, intMaxCantPallet,strNombreUnidad,fecha});


}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbZona = new javax.swing.JComboBox();
        cbRack = new javax.swing.JComboBox();
        cbUbicacion = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbAlmacen = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvPallets = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Reubicar pallet");

        jLabel2.setText("<html>Rack<br>destino:</html>");

        jLabel3.setText("<html>Ubicación <br>destino:</html>");

        btnGuardar.setText("Guardar");
        btnGuardar.setMaximumSize(new java.awt.Dimension(75, 23));
        btnGuardar.setMinimumSize(new java.awt.Dimension(75, 23));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        jLabel4.setText("<html>Zona<br>destino:</html>");

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

        jLabel5.setText("Almacén:");

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

        jButton1.setText("Buscar Pallet");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        dgvPallets.setAutoCreateRowSorter(true);
        dgvPallets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Producto", "Rack", "Ubicación", "Cant. Máx.", "Unidad", "Fecha Vencimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Byte.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dgvPallets);

        jLabel6.setText("Fecha:");

        jdcFecha.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton1)
                        .addGap(279, 279, 279)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5)
                        .addGap(59, 59, 59)
                        .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(cbRack, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnCancelar)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cbAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbAlmacenMouseClicked
//NO
}//GEN-LAST:event_cbAlmacenMouseClicked

private void cbZonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbZonaMouseClicked
//NO
}//GEN-LAST:event_cbZonaMouseClicked

private void cbUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUbicacionActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_cbUbicacionActionPerformed

private void cbAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlmacenActionPerformed
        strIdAlmacen = cbAlmacen.getSelectedItem().toString();
        cargarComboZona(strIdAlmacen);
}//GEN-LAST:event_cbAlmacenActionPerformed

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

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    
//    String strIdentificador = cbRack.getSelectedItem().toString();
//    String strIdRackDestino = objRackBL.getByIdentificador(strIdentificador).getIdRack();
//    int intFilaDestino = cbUbicacion.getSelectedItem().toString().charAt(1)-48;
//    int intColumnaDestino = cbUbicacion.getSelectedItem().toString().charAt(3)-48;
//    strIdUbicacionDestino = objUbicacionBL.getUbicacionByRackFilaColumna(strIdRackDestino, intFilaDestino, intColumnaDestino,"1").getIdUbicacion();
//    PalletBL objPalletBL = new PalletBL();
//    objPalletBL.reubicarPallet(strIdPallet, strIdUbicacionOrigen, strIdUbicacionDestino);
    
    int intFila;
    intFila = dgvPallets.getSelectedRow();
    if (intFila==-1)
        JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna celda", "Error", 0);
    else{
        String strIdPallet = (String)dgvPallets.getValueAt(intFila, 0);
        strIdUbicacionOrigen = (String)dgvPallets.getValueAt(intFila, 3);
        int intFilaUbicacion = cbUbicacion.getSelectedItem().toString().charAt(1)-48;
        int intColumnaUbicacion = cbUbicacion.getSelectedItem().toString().charAt(3)-48;
        String strIdentificadorRack = cbRack.getSelectedItem().toString();
        strIdRack = objRackBL.getByIdentificador(strIdentificadorRack).getIdRack();
        strIdUbicacionDestino = objUbicacionBL.getUbicacionByRackFilaColumna(strIdRack, intFilaUbicacion, intColumnaUbicacion,"1").getIdUbicacion();
        PalletBL objPalletBL = new PalletBL();
        objPalletBL.reubicarPallet(strIdPallet, strIdUbicacionOrigen, strIdUbicacionDestino);
    }
    
}//GEN-LAST:event_btnGuardarActionPerformed

private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
    
    BuscarPallet ventana = new BuscarPallet(this);
    ventana.setVisible(true);
    
}//GEN-LAST:event_jButton1MouseClicked

private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
    
}//GEN-LAST:event_btnGuardarMouseClicked

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
            java.util.logging.Logger.getLogger(ReubicarPallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReubicarPallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReubicarPallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReubicarPallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbAlmacen;
    private javax.swing.JComboBox cbRack;
    private javax.swing.JComboBox cbUbicacion;
    private javax.swing.JComboBox cbZona;
    private javax.swing.JTable dgvPallets;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    // End of variables declaration//GEN-END:variables
}