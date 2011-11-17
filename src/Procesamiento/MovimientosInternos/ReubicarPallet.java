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

import BusinessEntity.*;
import BusinessLogic.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class ReubicarPallet extends javax.swing.JDialog {

    /** Creates new form ReubicarPallet */
    UsuarioBE objUsuarioBE;
    String strIdAlmacen;
    String strIdZona;
    String strIdRack;
    String strIdUbicacionDestino;
    String strIdUbicacionOrigen;
    String strIdPallet;
    String strNombreFamilia;
    
    AlmacenBL objAlmacenBL = new AlmacenBL();   
    ZonaBL objZonaBL = new ZonaBL();
    RackBL objRackBL = new RackBL();    
    UbicacionBL objUbicacionBL = new UbicacionBL();
    FamiliaBL objFamiliaBL = new FamiliaBL();
    PalletBL objPalletBL = new PalletBL();
    ProductoBL objProductoBL = new ProductoBL();                
    UnidadMedidaBL objUnidadMedidaBL = new UnidadMedidaBL();
    MovimientoInternoBL objMovimientoInternoBL = new MovimientoInternoBL();

    ArrayList<PalletBE> arrPallets = new ArrayList<PalletBE>();

    ArrayList<AlmacenBE> arrAlmacenes = new ArrayList<AlmacenBE>();
    ArrayList<ZonaBE> arrZonas = new ArrayList<ZonaBE>();
    ArrayList<RackBE> arrRacks = new ArrayList<RackBE>();
    ArrayList<UbicacionBE> arrUbicaciones = new ArrayList<UbicacionBE>();
    UbicacionBE objUbicacionBE = new UbicacionBE();

    ArrayList<String> arrIdAlmacenes = new ArrayList<String>();
    ArrayList<String> arrIdZonas = new ArrayList<String>();
    ArrayList<String> arrIdRacks = new ArrayList<String>();
    ArrayList<String> arrIdUbicaciones = new ArrayList<String>();
    
    
    UbicacionBE objUbicacionPadre;
    
    AdmMovimientosInternos ventanaPadre;

    PalletBE objPalletBE = new PalletBE();

    
    /*
     *  CONSTRUCTOR
     */
        
    public ReubicarPallet(AdmMovimientosInternos ventanaPadre) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaPadre = ventanaPadre;
        Date fechaActual = new Date();
        this.jdcFecha.setDate(fechaActual);
        cargarComboAlmacen();
    }
    
    public ReubicarPallet(java.awt.Frame parent, boolean modal,ArrayList<PalletBE> arrPallets,String strIdAlmacen){
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaPadre = null;        
        Date fechaActual = new Date();
        this.jdcFecha.setDate(fechaActual);
        this.setTitle("Ubicar Pallet");
        this.btnBuscarPallet.setEnabled(false);
        llenarDgv(arrPallets);
        cargarComboAlmacen();
        for (int i=0; i<arrIdAlmacenes.size(); i++)
            if (arrIdAlmacenes.get(i).equals(strIdAlmacen)){
                cbAlmacen.setSelectedIndex(i);
                cbAlmacen.setEnabled(false);
                return;
            }
    }
    
    /*
     * OPERACIONES DE VENTANA
     */
    
    public void llenarDgv(ArrayList<PalletBE> arrPallets){
        
        strIdAlmacen = arrPallets.get(0).getIdAlmacen();
        
        for (int i=0; i<arrIdAlmacenes.size(); i++){
            if (strIdAlmacen.equals(arrIdAlmacenes.get(i))){
                cbAlmacen.setSelectedIndex(i+1);
                cbAlmacen.setEnabled(false);
                break;
            }
        }
        
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
                String strIdProducto = arrPallets.get(i).getIdProducto().trim();
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

                String strIdUbicacion = arrPallets.get(i).getIdUbicacion().trim();
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
    
    public void eliminaFilaDgv(int fila){
        DefaultTableModel modelo=(DefaultTableModel) dgvPallets.getModel();  
        modelo.removeRow(fila);
    }
    
    
    public void actualizaDgv(PalletBE objPalletBE){

       DefaultTableModel modelo=(DefaultTableModel) dgvPallets.getModel();    
        for(int i=modelo.getRowCount()-1; i>=0; i--){
            modelo.removeRow(i);
        }
        
        ProductoBE objProductoBE;

        strIdPallet = objPalletBE.getIdPallet();
        String strIdProducto = objPalletBE.getIdProducto().trim();
        String strNombreProducto = "";
        int intMaxCantPallet = 0;
        String strIdUnidadMedida = "";
        String strNombreUnidadMedida = "";
        String strIdFamilia = "";
        strNombreFamilia = "";

         if (!strIdProducto.equals("")){
            objProductoBE = objProductoBL.getByIdProducto(objPalletBE.getIdProducto());
            strNombreProducto = objProductoBE.getNombre();
            intMaxCantPallet = objProductoBE.getMaxCantPorPallet();
            strIdFamilia = objProductoBE.getIdFamilia();
            strNombreFamilia = objFamiliaBL.queryByIdFamilia(strIdFamilia).getNombre();
        }

        String strIdUbicacion = objPalletBE.getIdUbicacion().trim();
        int intFila = 0;
        int intColumna = 0;
        String strIdentificadorRack = "";

        if (!strIdUbicacion.equals("")){
            intFila = objUbicacionBL.getUbicacionById(strIdUbicacion).getFila();
            intColumna = objUbicacionBL.getUbicacionById(strIdUbicacion).getColumna();
            strIdentificadorRack = objRackBL.getRackByIdUbicacion(strIdUbicacion).getIdentificador();
        }

        String strFecha = "";

        if (objPalletBE.getFechaVencimiento() != null)
            strFecha = objPalletBE.getFechaVencimiento().toString();

        modelo.addRow(new Object[]{strIdPallet,strNombreProducto,strIdentificadorRack, "F"+String.valueOf(intFila) + "C"+String.valueOf(intColumna), intMaxCantPallet,strNombreFamilia,strFecha});
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
        btnBuscarPallet = new javax.swing.JButton();
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
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        jLabel4.setText("<html>Zona<br>destino:</html>");

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

        jLabel5.setText("Almacén:");

        cbAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlmacenActionPerformed(evt);
            }
        });

        btnBuscarPallet.setText("Buscar Pallet");
        btnBuscarPallet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarPalletMouseClicked(evt);
            }
        });

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
        dgvPallets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvPalletsMouseClicked(evt);
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
                .addGap(20, 20, 20)
                .addComponent(btnBuscarPallet)
                .addGap(279, 279, 279)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel5)
                .addGap(39, 39, 39)
                .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(cbRack, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCancelar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarPallet)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     *  MANEJO DE EVENTOS
     */
    
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

/*
 * EVENTO BOTÓN GUARDAR
 */
private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    
    if (!validar())
        return;
    
    int intFila;
    boolean boolExito = false;
    intFila = dgvPallets.getSelectedRow();
    if (intFila==-1)
        JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila", "Advertencia", 0);
    else{
        
        strIdPallet = (String)dgvPallets.getValueAt(intFila, 0);
        // se obtiene la ubicacion origen
        objUbicacionBE = objUbicacionBL.getUbicacionByPallet(strIdPallet);
        strIdUbicacionOrigen = objUbicacionBE.getIdUbicacion();
        // se obtiene la ubicacion destino
        strIdUbicacionDestino = arrIdUbicaciones.get(cbUbicacion.getSelectedIndex()-1);
        UbicacionBE objUbicacion = objUbicacionBL.getUbicacionById(strIdUbicacionDestino);
        strIdAlmacen = arrIdAlmacenes.get(cbAlmacen.getSelectedIndex());
        String strIdUsuario = UsuarioSistema.usuario.getIdUsuario();
        
        MovimientoInternoBE objMovimientoInternoBE = new MovimientoInternoBE("", strIdUbicacionOrigen, strIdUbicacionDestino, jdcFecha.getDate(), "Reubicación", strIdPallet, strIdAlmacen, strIdUsuario);
        
        if (this.ventanaPadre == null){
            // Ubicar Pallet
            objUbicacionBL.desocuparUbicacion(objMovimientoInternoBE.getIdUbicacionOrigen());
            objPalletBL.asociarUbicacionAPallet(objMovimientoInternoBE.getIdPallet(), objMovimientoInternoBE.getIdUbicacionDestino());
        }
        else{
            //Reubicar Pallet
        if (objUbicacionBL.desocuparUbicacion(objMovimientoInternoBE.getIdUbicacionOrigen()))
            if (objPalletBL.asociarUbicacionAPallet(objMovimientoInternoBE.getIdPallet(),objMovimientoInternoBE.getIdUbicacionDestino()))
                boolExito = objUbicacionBL.ocuparUbicacion(objMovimientoInternoBE.getIdUbicacionDestino());
        
            if (boolExito){
                objMovimientoInternoBL.insertar(objMovimientoInternoBE);
//                if(ventanaPadre != null)
                ventanaPadre.actualizarDgv(objMovimientoInternoBE);
                this.dispose();
            }else
            JOptionPane.showMessageDialog(null, "No se pudo reubicar el pallet","Error",0);
        }
        
    }
    
}//GEN-LAST:event_btnGuardarActionPerformed

private void btnBuscarPalletMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarPalletMouseClicked
    
    BuscarPallet ventana = new BuscarPallet(this);
    ventana.setVisible(true);
    
}//GEN-LAST:event_btnBuscarPalletMouseClicked

private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
    
}//GEN-LAST:event_btnGuardarMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void dgvPalletsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvPalletsMouseClicked
//        DefaultTableModel modelo=(DefaultTableModel) dgvPallets.getModel();
//        int intFila = dgvPallets.getSelectedRow();
//        strIdUbicacionOrigen = dgvPallets.getValueAt(intFila, 3);
        cargarComboZona(strIdAlmacen);
        
    }//GEN-LAST:event_dgvPalletsMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPallet;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbAlmacen;
    private javax.swing.JComboBox cbRack;
    private javax.swing.JComboBox cbUbicacion;
    private javax.swing.JComboBox cbZona;
    private javax.swing.JTable dgvPallets;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    // End of variables declaration//GEN-END:variables
   
    /*
     *  CARGA DE COMPONENTES INICIALES
     */
    
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
        
        int intFila;
        intFila = dgvPallets.getSelectedRow();
        if (intFila!=-1)
            strNombreFamilia = (String)dgvPallets.getValueAt(intFila,5);
        else
            return;
        
        String strIdFamilia = objFamiliaBL.getIdFamilia(strNombreFamilia);
        
        cbZona.removeAllItems();
        cbRack.removeAllItems();
        cbUbicacion.removeAllItems();

        arrZonas = objZonaBL.getZonasByFamilia(idAlmacen,strIdFamilia);
        
        if (arrZonas.size() <= 0){
            cbZona.addItem("");
            return;
        }
        
        cbZona.addItem("Seleccione");
        cbRack.addItem("");
        cbUbicacion.addItem(""); 
        arrIdZonas.clear();
        
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
        
        arrIdRacks.clear();
        
        for(RackBE rack : arrRacks){
                arrIdRacks.add(rack.getIdRack());
                cbRack.addItem(rack.getIdentificador());
        }
        
    }
    
    public void cargarComboUbicacion(String idRack){
       
        cbUbicacion.removeAllItems();

        arrUbicaciones = new ArrayList<UbicacionBE>();
        arrUbicaciones = objUbicacionBL.getUbicacionesByRack(idRack,"1"); //solo se buscarán ubicaciones libres
        
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

    private boolean validar() {
    
    int fila = dgvPallets.getSelectedRow();
    if (fila==-1){
        JOptionPane.showMessageDialog(null, "No ha seleccionado ningún pallet", "Advertencia",0);
        return false;
    }
        
    if (cbUbicacion.getItemCount() != 0){
        if (cbUbicacion.getSelectedItem().toString().equals("") || cbUbicacion.getSelectedItem().toString().equals("Seleccione")){
            JOptionPane.showMessageDialog(null, "Debe seleccionar ubicación destino");
            return false;
        }else
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar ubicación destino");
            return false;
        }
    }

}
