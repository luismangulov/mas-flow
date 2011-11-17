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
    
    ArrayList<String> arrIdZonas = new ArrayList<String>();
    ArrayList<String> arrIdRacks = new ArrayList<String>();
    ArrayList<String> arrIdUbicaciones = new ArrayList<String>();
                
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
        this.setLocationRelativeTo(null);
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
        txtNombreProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIdPallet = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvPallets = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

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

        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyTyped(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(41, 41, 41)
                                .addComponent(txtIdPallet, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(49, 49, 49)
                                .addComponent(cbZona, 0, 111, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(29, 29, 29)
                                .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(51, 51, 51)
                                .addComponent(cbRack, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(23, 23, 23)
                                .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(btnAceptar)
                        .addGap(26, 26, 26)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
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
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)))))
                            .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(cbRack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnBuscar)))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
           

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

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        if (!validar())
            return;


            int fila;
            String codigo;
            fila = dgvPallets.getSelectedRow();
            codigo = (String)dgvPallets.getValueAt(fila, 0);

            this.objPalletBE.setIdPallet(codigo);

            this.dispose();
        
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

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
    private javax.swing.JButton btnCancelar;
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
