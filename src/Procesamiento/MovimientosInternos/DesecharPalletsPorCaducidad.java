/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DesecharPalletsPorCaducidad.java
 *
 * Created on Oct 2, 2011, 3:27:45 PM
 */
package Procesamiento.MovimientosInternos;


import BusinessEntity.AlmacenBE;
import BusinessEntity.MovimientoInternoBE;
import BusinessEntity.PalletBE;
import BusinessEntity.ProductoBE;
import BusinessEntity.UsuarioSistema;
import BusinessLogic.AlmacenBL;
import BusinessLogic.MovimientoInternoBL;
import BusinessLogic.PalletBL;
import BusinessLogic.ProductoBL;
import BusinessLogic.RackBL;
import BusinessLogic.UbicacionBL;
import BusinessLogic.UnidadMedidaBL;
import Util.Utilitario;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VICTOR
 */
public class DesecharPalletsPorCaducidad extends javax.swing.JFrame {

    /** Creates new form DesecharPalletsPorCaducidad */

    AdmMovimientosInternos ventanaPadre;
    
    AlmacenBL objAlmacenBL = new AlmacenBL();
    MovimientoInternoBL objMovimientoInternoBL = new MovimientoInternoBL();
    UnidadMedidaBL objUnidadMedidaBL = new UnidadMedidaBL();
    ProductoBL objProductoBL = new ProductoBL();                
    UbicacionBL objUbicacionBL = new UbicacionBL();
    RackBL objRackBL = new RackBL();
    PalletBL objPalletBL = new PalletBL();
    
    ArrayList<MovimientoInternoBE> arrMovimientosInternos = new ArrayList<MovimientoInternoBE>();
    ArrayList<String> arrIdAlmacenes = new ArrayList<String>();
    ArrayList<AlmacenBE> arrAlmacenes = new ArrayList<AlmacenBE>();
    ArrayList<PalletBE> arrPallets = new ArrayList<PalletBE>();
    
    Date fecha;
    
    String strIdProducto;
    String strIdAlmacen;
    String strIdPallet;
    String strNombreProducto;
    String strIdUnidadMedida;
    String strNombreUnidadMedida;
    String strIdUbicacion;
    String strIdFechaVencimiento;
    String strMotivo;
    String strFecha;
    
    int intMaxCantPallet;
    
    PalletBE objPalletBE = new PalletBE();
    ProductoBE objProductoBE = new ProductoBE();
    MovimientoInternoBE objMovimientoInternoBE = new MovimientoInternoBE();
   
    
    public DesecharPalletsPorCaducidad(AdmMovimientosInternos ventanaPadre) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaPadre = ventanaPadre;
        Date f = new Date();
        Timestamp fechaActual = new Timestamp(f.getTime());
        this.jdcFecha.setDate(fechaActual);
        this.cargarComboAlmacen();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnDesechar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbAlmacen = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        lblAdd = new javax.swing.JLabel();
        lblRemover = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgvPallets = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtMotivo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Desechar Pallets");
        setResizable(false);

        jLabel2.setText("Almacén:");

        btnDesechar.setText("Desechar");
        btnDesechar.setToolTipText("");
        btnDesechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDesecharMouseClicked(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        jLabel3.setText("Fecha:");

        jdcFecha.setEnabled(false);

        lblAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add24.png"))); // NOI18N
        lblAdd.setText("jLabel8");
        lblAdd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAdd.setPreferredSize(new java.awt.Dimension(30, 30));
        lblAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddMouseClicked(evt);
            }
        });

        lblRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete24.png"))); // NOI18N
        lblRemover.setText("jLabel9");
        lblRemover.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRemover.setPreferredSize(new java.awt.Dimension(30, 30));
        lblRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRemoverMouseClicked(evt);
            }
        });

        dgvPallets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ubicación", "Código", "Producto", "Cantidad", "Unidad de Medida", "Fecha Vencimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgvPallets.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        dgvPallets.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(dgvPallets);

        jLabel4.setText("Motivo*:");

        txtMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMotivoKeyTyped(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(197, 86, 86));
        jLabel1.setText("Puede seleccionar más de un pallet con la tecla Control");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(198, 198, 198)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jdcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                                    .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(btnDesechar)
                        .addGap(40, 40, 40)
                        .addComponent(btnCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4))
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(lblAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(lblRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDesechar)
                    .addComponent(btnCancelar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnDesecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDesecharMouseClicked

    int intConfirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar los pallets seleccionados?", "Advertencia", 2);
    if (intConfirmacion != 0)
        return;
    
    if (!validar())
        return;
    
    strIdAlmacen = arrIdAlmacenes.get(cbAlmacen.getSelectedIndex());
    strMotivo = txtMotivo.getText();
    //fecha = jdcFecha.getDate();
    DefaultTableModel modelo=(DefaultTableModel) dgvPallets.getModel();
    
    int intCantFilas = dgvPallets.getSelectedRowCount();
    String strIdUsuario = UsuarioSistema.usuario.getIdUsuario();
    int intFila = dgvPallets.getSelectedRow();
    
    arrPallets.clear();
    arrMovimientosInternos.clear();
    
    int[] arrFilas = dgvPallets.getSelectedRows();
    
    for (int i : arrFilas){
//        JOptionPane.showMessageDialog(null, modelo.getRowCount());

        strIdUbicacion = modelo.getValueAt(i,0).toString();
        strIdPallet = modelo.getValueAt(i,1).toString();
        strIdProducto = objProductoBL.getByNombreProducto(modelo.getValueAt(i, 2).toString()).getIdProducto();
        
        objPalletBE = new PalletBE(strIdPallet, strIdProducto, "3", strIdUbicacion, strIdAlmacen, null, null, null);
        
        arrPallets.add(objPalletBE);

        objMovimientoInternoBE = new MovimientoInternoBE("", strIdUbicacion, null, null,strMotivo, strIdPallet, strIdAlmacen, strIdUsuario);
        
        arrMovimientosInternos.add(objMovimientoInternoBE);

    }
    
    for (PalletBE palletBE : arrPallets)
        objPalletBL.desechar(palletBE);
    
    for (MovimientoInternoBE movimientoInternoBE : arrMovimientosInternos)
        objMovimientoInternoBL.insertar(movimientoInternoBE);

    if (arrMovimientosInternos.size()>0){
        ventanaPadre.llenarDgv(arrMovimientosInternos);
        this.dispose();
    }
    else 
        JOptionPane.showMessageDialog(null, "Hubo un error en la operación", "Error", 0);

}//GEN-LAST:event_btnDesecharMouseClicked

private void lblAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMouseClicked
    
    BuscarPallet ventana = new BuscarPallet(this);
    ventana.setVisible(true);
    
}//GEN-LAST:event_lblAddMouseClicked

    private void txtMotivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMotivoKeyTyped
        char c = (char)evt.getKeyChar();
        if (!Utilitario.validarCadenaAlfabetica(evt.getKeyChar()) || (Character.isISOControl(c)))
           evt.consume();
        if ((this.txtMotivo.getText().length() + 1) > 30) {
           evt.consume();
        }
    }//GEN-LAST:event_txtMotivoKeyTyped

    private void lblRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoverMouseClicked
        DefaultTableModel modelo=(DefaultTableModel) dgvPallets.getModel();
        
        int intFila = dgvPallets.getSelectedRow();
        if (intFila != -1)
            eliminaFilaDgv(intFila);
        
    }//GEN-LAST:event_lblRemoverMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesechar;
    private javax.swing.JComboBox cbAlmacen;
    private javax.swing.JTable dgvPallets;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JLabel lblAdd;
    private javax.swing.JLabel lblRemover;
    private javax.swing.JTextField txtMotivo;
    // End of variables declaration//GEN-END:variables
    
    public void cargarComboAlmacen(){
        
        cbAlmacen.removeAllItems();

        arrAlmacenes = objAlmacenBL.getAllAlmacenActivo();
        
        if (arrAlmacenes != null)
            for(AlmacenBE almacen : arrAlmacenes){
                arrIdAlmacenes.add(almacen.getIdAlmacen());
                cbAlmacen.addItem(almacen.getIdentificador().trim());
            }

    }
    
    public void llenarDgv(ArrayList<PalletBE> arrPallets){
        
        strIdAlmacen = arrPallets.get(0).getIdAlmacen();
        
        for (int i=0; i<arrIdAlmacenes.size(); i++){
            if (strIdAlmacen.equals(arrIdAlmacenes.get(i))){
                cbAlmacen.setSelectedIndex(i);
                cbAlmacen.setEnabled(false);
                break;
            }
        }
        
        DefaultTableModel modelo=(DefaultTableModel) dgvPallets.getModel();    
        limpiarDgv();
        this.arrPallets = arrPallets;

        if(arrPallets != null){
        
            for (int i=0; i<arrPallets.size(); i++){

                strIdPallet = arrPallets.get(i).getIdPallet();
                strIdUbicacion = arrPallets.get(i).getIdUbicacion();
                strIdProducto = arrPallets.get(i).getIdProducto();
                 
                objProductoBE = objProductoBL.getByIdProducto(strIdProducto);
                
                intMaxCantPallet = objProductoBE.getMaxCantPorPallet();
                strNombreProducto = objProductoBE.getNombre();
                strIdUnidadMedida = objProductoBE.getIdUnidadMedida();
                
                strNombreUnidadMedida = objUnidadMedidaBL.getUnidadMedida(strIdUnidadMedida).getNombre();

                
                if (arrPallets.get(i).getFechaVencimiento() != null)
                    strIdFechaVencimiento = arrPallets.get(i).getFechaVencimiento().toString();

                modelo.addRow(new Object[]{strIdUbicacion,strIdPallet,strNombreProducto, intMaxCantPallet, strNombreUnidadMedida,strIdFechaVencimiento});
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
    
    /*
     * VALIDACIÓN
     */
    public boolean validar(){
        
        DefaultTableModel modelo=(DefaultTableModel) dgvPallets.getModel();
        if (modelo.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún pallet", "Error",0);
            return false;
        }
        
        if (txtMotivo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe indicar el motivo de la operación", "Error",0);
            return false;
        }
        
        return true;
    }
    
}
