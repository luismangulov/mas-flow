/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AyudaPallet.java
 *
 * Created on Nov 10, 2011, 3:03:15 AM
 */
package Mantenimientos.Pallet;

import BusinessEntity.AlmacenBE;
import BusinessEntity.PalletBE;
import BusinessEntity.ProductoBE;
import BusinessEntity.RackBE;
import BusinessEntity.UbicacionBE;
import BusinessEntity.UsuarioBE;
import BusinessEntity.ZonaBE;
import BusinessLogic.AlmacenBL;
import BusinessLogic.FamiliaBL;
import BusinessLogic.MovimientoInternoBL;
import BusinessLogic.PalletBL;
import BusinessLogic.ProductoBL;
import BusinessLogic.RackBL;
import BusinessLogic.UbicacionBL;
import BusinessLogic.UnidadMedidaBL;
import BusinessLogic.ZonaBL;
import Util.Utilitario;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author victor
 */
public class AyudaPallet extends javax.swing.JDialog {

    /** Creates new form AyudaPallet */
    AlmacenBL objAlmacenBL = new AlmacenBL();
    
    ArrayList<String> arrIdAlmacenes = new ArrayList<String>();
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
    
    PalletBE objPalletBE;
    UbicacionBE objUbicacionBE = new UbicacionBE();
    
    UsuarioBE objUsuarioBE;

    String strIdUbicacionDestino;
    String strIdUbicacionOrigen;
    String strNombreFamilia;
  
    FamiliaBL objFamiliaBL = new FamiliaBL();
    ProductoBL objProductoBL = new ProductoBL();                
    UnidadMedidaBL objUnidadMedidaBL = new UnidadMedidaBL();
    MovimientoInternoBL objMovimientoInternoBL = new MovimientoInternoBL();


    
    UbicacionBE objUbicacionPadre;
    
    
    public AyudaPallet(java.awt.Frame parent, boolean modal, PalletBE objPalletBE) {
        super(parent, modal);
        initComponents();
        cargarComboAlmacen();
        this.objPalletBE = objPalletBE;
    }

    public void llenarDgv(ArrayList<PalletBE> arrPallets){
        
        DefaultTableModel modelo=(DefaultTableModel) dgvPallets.getModel(); 
        limpiarDgv();
        this.arrPallets = arrPallets;

        PalletBE palletBE = new PalletBE();
        ProductoBE objProductoBE;
        
        String strIdFamilia = "";
        strNombreFamilia = "";
        
        if(arrPallets != null){
        
            for (int i=0; i<arrPallets.size(); i++){

                strIdPallet = arrPallets.get(i).getIdPallet();
                strIdProducto = arrPallets.get(i).getIdProducto().trim();
                String strNombreProducto = "";
                int intMaxCantPallet = 0;
                String strIdUnidadMedida = "";
                String strNombreUnidadMedida = "";
                
                 if (!strIdProducto.equals("")){
                    objProductoBE = objProductoBL.getByIdProducto(arrPallets.get(i).getIdProducto());
                    strNombreProducto = objProductoBE.getNombre();
                    intMaxCantPallet = objProductoBE.getMaxCantPorPallet();
                    strIdFamilia = objProductoBE.getIdFamilia();
                    strNombreFamilia = objFamiliaBL.queryByIdFamilia(strIdFamilia).getNombre();
                }

                strIdUbicacion = arrPallets.get(i).getIdUbicacion().trim();
                int intFila = 0;
                int intColumna = 0;
                String strIdentificadorRack = "";
        
                if (!strIdUbicacion.equals("")){
                    intFila = objUbicacionBL.getUbicacionById(strIdUbicacion).getFila();
                    intColumna = objUbicacionBL.getUbicacionById(strIdUbicacion).getColumna();
                    strIdentificadorRack = objRackBL.getRackByIdUbicacion(strIdUbicacion).getIdentificador();
                }
                
//                String strFecha = "";
//                
//                if (palletBE.getFechaVencimiento() != null)
//                    strFecha = palletBE.getFechaVencimiento().toString();

                modelo.addRow(new Object[]{strIdPallet,strNombreProducto,strIdentificadorRack, "F"+String.valueOf(intFila) + "C"+String.valueOf(intColumna), intMaxCantPallet,strNombreFamilia,arrPallets.get(i).getFechaVencimiento()});
            }
        }
    }
    
    public void limpiarDgv(){
                
        DefaultTableModel modelo=(DefaultTableModel) dgvPallets.getModel();    
        for(int i=modelo.getRowCount()-1; i>=0; i--){
            modelo.removeRow(i);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        cbUbicacion = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cbZona = new javax.swing.JComboBox();
        cbRack = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbAlmacen = new javax.swing.JComboBox();
        txtIdProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIdPallet = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvPallets = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        jLabel7.setText("Almacén:");

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

        jLabel5.setText("Ubicacion:");

        jLabel6.setText("Zona:");

        jLabel3.setText("Rack:");

        cbAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlmacenActionPerformed(evt);
            }
        });

        txtIdProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdProductoKeyTyped(evt);
            }
        });

        jLabel4.setText("Producto:");

        txtIdPallet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdPalletKeyTyped(evt);
            }
        });

        jLabel1.setText("Código:");

        dgvPallets.setAutoCreateRowSorter(true);
        dgvPallets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Producto", "Rack", "Ubicación", "Cant. Máx.", "Familia", "Fecha Vencimiento"
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
        dgvPallets.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        dgvPallets.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(dgvPallets);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)
                        .addComponent(txtIdPallet, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(29, 29, 29)
                        .addComponent(txtIdProducto))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7)
                        .addGap(29, 29, 29)
                        .addComponent(cbAlmacen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6)
                        .addGap(49, 49, 49)
                        .addComponent(cbZona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3)
                        .addGap(51, 51, 51)
                        .addComponent(cbRack, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(23, 23, 23)
                                .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(180, 180, 180))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(363, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(290, 290, 290))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
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
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAceptar)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
           

    strIdPallet = txtIdPallet.getText();
    strIdProducto = txtIdProducto.getText();
    
    int intFila = 0;
    int intColumna = 0;
    
    if (!cbUbicacion.getSelectedItem().toString().equals("Seleccione") && !cbUbicacion.getSelectedItem().toString().equals("")){
        
        intFila = cbUbicacion.getSelectedItem().toString().charAt(1)-48;
        intColumna = cbUbicacion.getSelectedItem().toString().charAt(3)-48;
        
    }
    
    if (!cbRack.getSelectedItem().toString().equals("Seleccione") && !cbRack.getSelectedItem().toString().equals("")){
        
        strIdRack = objRackBL.getByIdentificador(cbRack.getSelectedItem().toString()).getIdRack();

    }
    else
        
        strIdRack = "";
    
    if (!cbZona.getSelectedItem().toString().equals("Seleccione") && !cbZona.getSelectedItem().toString().equals("")){
        
        objZonaBL = new ZonaBL();
        strIdZona = objZonaBL.getByIdentificadorZona(cbZona.getSelectedItem().toString()).getIdZona();
        
    }else
        
        strIdZona = "";
    
    if (!cbAlmacen.getSelectedItem().toString().equals("")){
        
        int i = cbAlmacen.getSelectedIndex();
        strIdAlmacen = arrIdAlmacenes.get(i);
        
    }else
        strIdAlmacen = "";
    
    arrPallets = objPalletBL.getPalletListSearch(strIdAlmacen, strIdZona, strIdRack, intFila, intColumna, strIdPallet, strIdProducto);
    
    if (arrPallets.size()>0)
        llenarDgv(arrPallets);
    else
        JOptionPane.showMessageDialog(null, "No se encontraron pallets");
                                                            
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void cbAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlmacenActionPerformed
        int i;
        i = cbAlmacen.getSelectedIndex();
        strIdAlmacen = arrIdAlmacenes.get(i);
        cargarComboZona(strIdAlmacen);
    }//GEN-LAST:event_cbAlmacenActionPerformed

    private void cbZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbZonaActionPerformed
        int intCantItem = cbZona.getItemCount() - 1;
        if (intCantItem > 0){
            if (!cbZona.getSelectedItem().equals("Seleccione")){
                strIdZona = objZonaBL.getByIdentificadorZona(cbZona.getSelectedItem().toString()).getIdZona();
                cargarComboRack(strIdZona);
            }
            else
                cbRack.removeAllItems();
        }
    }//GEN-LAST:event_cbZonaActionPerformed

    private void cbRackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRackActionPerformed
        int intCantItem = cbRack.getItemCount() - 1;
        if (intCantItem > 0){
            if (!cbRack.getSelectedItem().equals("Seleccione")){
                String strIdentificador = cbRack.getSelectedItem().toString();
                strIdRack = objRackBL.getByIdentificador(strIdentificador).getIdRack();
                cargarComboUbicacion(strIdRack);
            }
            else
                cbUbicacion.removeAllItems();
        }
    }//GEN-LAST:event_cbRackActionPerformed

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

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        if (!validar())
            return;
        
        int intFila = dgvPallets.getSelectedRow();
        objPalletBE = arrPallets.get(intFila);
        
        this.dispose();
        
    }//GEN-LAST:event_btnAceptarMouseClicked

    public boolean validar(){
        
       if((dgvPallets.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado un Pallet", "Mensaje",0);
           return false;
       } else if((dgvPallets.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado más de un Pallet", "Mensaje",0);
            return false;
       }
       
       return true;
        
    }
        
        
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AyudaPallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AyudaPallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AyudaPallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AyudaPallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                AyudaPallet dialog = new AyudaPallet(new javax.swing.JFrame(), true, objPalletBE);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox cbAlmacen;
    private javax.swing.JComboBox cbRack;
    private javax.swing.JComboBox cbUbicacion;
    private javax.swing.JComboBox cbZona;
    private javax.swing.JTable dgvPallets;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtIdPallet;
    private javax.swing.JTextField txtIdProducto;
    // End of variables declaration//GEN-END:variables
    
    public void cargarComboAlmacen(){
        
        cbAlmacen.removeAllItems();
        cbZona.removeAllItems();
        cbRack.removeAllItems();
        cbUbicacion.removeAllItems();
        
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
        cbUbicacion.removeAllItems();
        cbZona.addItem("Seleccione");
        cbRack.addItem("");
        cbUbicacion.addItem(""); 

        arrZonas = objZonaBL.getZonasByAlmacen(idAlmacen);
        
        if (arrZonas != null)
            for(ZonaBE zona : arrZonas)
                cbZona.addItem(zona.getIdentificador());
        
    }
    
    public void cargarComboRack(String idZona){
        
        cbRack.removeAllItems();        
        cbUbicacion.removeAllItems();
        cbRack.addItem("Seleccione");
        cbUbicacion.addItem(""); 
               
        arrRacks = objRackBL.getRacksByZona(idZona);
        
        if (arrRacks != null)
            for(RackBE rack : arrRacks)
                cbRack.addItem(rack.getIdentificador());
        
    }
    
    public void cargarComboUbicacion(String idRack){
       
        cbUbicacion.removeAllItems();
        
        arrUbicaciones = objUbicacionBL.getUbicacionesByRack(idRack,"2"); // "2" porque se buscarán solo las ubicaciones que estén ocupadas
             
        if (arrUbicaciones.size() > 0){
            cbUbicacion.addItem("Seleccione"); 
            for(UbicacionBE ubicacion : arrUbicaciones)
                cbUbicacion.addItem("F" + ubicacion.getFila() + "C" + ubicacion.getColumna());
        }
        
    }
}
