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
import BusinessEntity.PalletBE;
import BusinessEntity.ProductoBE;
import BusinessLogic.AlmacenBL;
import BusinessLogic.PalletBL;
import BusinessLogic.ProductoBL;
import BusinessLogic.RackBL;
import BusinessLogic.UbicacionBL;
import BusinessLogic.UnidadMedidaBL;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class DesecharPalletsPorCaducidad extends javax.swing.JFrame {

    /** Creates new form DesecharPalletsPorCaducidad */

    AdmMovimientosInternos ventanaPadre;
    ArrayList<PalletBE> arrPallets;
    
    public DesecharPalletsPorCaducidad(AdmMovimientosInternos ventanaPadre) {
        initComponents();
        this.setLocationRelativeTo(null);
        txtIdPallet.setEnabled(false);   
        this.ventanaPadre = ventanaPadre;
        this.cargarComboAlmacen();
    }

    public void cargarComboAlmacen(){
        AlmacenBL objAlmacenBL = new AlmacenBL();
        ArrayList<AlmacenBE> arrAlmacenes = new ArrayList<AlmacenBE>();
        
        arrAlmacenes= objAlmacenBL.getAllAlmacenActivo();
        for(AlmacenBE objAlmacen : arrAlmacenes)
            cbAlmacen.addItem(objAlmacen.getIdAlmacen());
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
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtIdPallet = new javax.swing.JTextField();
        cbAlmacen = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        lblAdd = new javax.swing.JLabel();
        lblRemover = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgvPallets = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Desechar Pallets");

        jLabel1.setText("Código:");

        jLabel2.setText("Almacén:");

        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        jLabel3.setText("Fecha:");

        jdcFecha.setEnabled(false);

        lblAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add24.png"))); // NOI18N
        lblAdd.setText("jLabel8");
        lblAdd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAdd.setPreferredSize(new java.awt.Dimension(30, 30));
        lblAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAddMousePressed(evt);
            }
        });

        lblRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete24.png"))); // NOI18N
        lblRemover.setText("jLabel9");
        lblRemover.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRemover.setPreferredSize(new java.awt.Dimension(30, 30));
        lblRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRemoverMousePressed(evt);
            }
        });

        dgvPallets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Cantidad", "Unidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(dgvPallets);

        jLabel4.setText("Motivo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)
                        .addComponent(txtIdPallet, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3)
                        .addGap(14, 14, 14)
                        .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnGuardar)
                        .addGap(40, 40, 40)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addComponent(txtIdPallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                        .addComponent(lblAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lblRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
    
}//GEN-LAST:event_btnGuardarMouseClicked

private void lblAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMousePressed

}//GEN-LAST:event_lblAddMousePressed

private void lblRemoverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoverMousePressed
//        // TODO add your handling code here:
//        DefaultTableModel modelo=(DefaultTableModel) tblProductos.getModel();
//        if((tblProductos.getSelectedRowCount() == 0)){
//           JOptionPane.showMessageDialog(null, "No ha seleccionado un producto", "Mensaje",0);
//        } else if((tblProductos.getSelectedRowCount() > 1)){
//            JOptionPane.showMessageDialog(null, "Ha seleccionado mas de un producto", "Mensaje",0);
//        }else{
//            modelo.removeRow(tblProductos.getSelectedRow());
//        }
}//GEN-LAST:event_lblRemoverMousePressed

private void lblAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMouseClicked
    
    BuscarPallet ventana = new BuscarPallet(this);
    ventana.setVisible(true);
    
}//GEN-LAST:event_lblAddMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbAlmacen;
    private javax.swing.JTable dgvPallets;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JLabel lblAdd;
    private javax.swing.JLabel lblRemover;
    private javax.swing.JTextField txtIdPallet;
    // End of variables declaration//GEN-END:variables
    
    public void llenarDgv(ArrayList<PalletBE> arrPallets){
        
        DefaultTableModel modelo=(DefaultTableModel) dgvPallets.getModel();    
        limpiarDgv();
        this.arrPallets = arrPallets;
        
        ProductoBL objProductoBL = new ProductoBL();                
        UbicacionBL objUbicacionBL = new UbicacionBL();
        RackBL objRackBL = new RackBL();
        UnidadMedidaBL objUnidadMedidaBL = new UnidadMedidaBL();

        PalletBE palletBE = new PalletBE();
        ProductoBE objProductoBE;
        
        if(arrPallets != null){
        
            for (int i=0; i<arrPallets.size(); i++){

                String strIdPallet = arrPallets.get(i).getIdPallet();
                String strIdProducto = arrPallets.get(i).getIdProducto().trim();
                String strNombreProducto = "";
                int intMaxCantPallet = 0;
                String strIdUnidadMedida = "";
                String strNombreUnidadMedida = "";
                
                 if (!strIdProducto.equals("")){
                    objProductoBE = objProductoBL.getByIdProducto(arrPallets.get(i).getIdProducto());
                    strNombreProducto = objProductoBE.getNombre();
                    intMaxCantPallet = objProductoBE.getMaxCantPorPallet();
                    strIdUnidadMedida = objProductoBE.getIdUnidadMedida();
                    strNombreUnidadMedida = objUnidadMedidaBL.getUnidadMedida(strIdUnidadMedida).getNombre();
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
                
                String strFecha = "";
                
                if (palletBE.getFechaVencimiento() != null)
                    strFecha = palletBE.getFechaVencimiento().toString();

                modelo.addRow(new Object[]{strIdPallet,strNombreProducto,strIdentificadorRack, strIdUbicacion, intMaxCantPallet,strNombreUnidadMedida,strFecha});
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

        ProductoBL objProductoBL = new ProductoBL();                
        UbicacionBL objUbicacionBL = new UbicacionBL();
        RackBL objRackBL = new RackBL();
        UnidadMedidaBL objUnidadMedidaBL = new UnidadMedidaBL();
        
        ProductoBE objProductoBE;

        String strIdPallet = objPalletBE.getIdPallet();
        String strIdProducto = objPalletBE.getIdProducto().trim();
        String strNombreProducto = "";
        int intMaxCantPallet = 0;
        String strIdUnidadMedida = "";
        String strNombreUnidadMedida = "";

         if (!strIdProducto.equals("")){
            objProductoBE = objProductoBL.getByIdProducto(objPalletBE.getIdProducto());
            strNombreProducto = objProductoBE.getNombre();
            intMaxCantPallet = objProductoBE.getMaxCantPorPallet();
            strIdUnidadMedida = objProductoBE.getIdUnidadMedida();
            strNombreUnidadMedida = objUnidadMedidaBL.getUnidadMedida(strIdUnidadMedida).getNombre();
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

        modelo.addRow(new Object[]{strIdPallet,strNombreProducto,strIdentificadorRack, strIdUbicacion, intMaxCantPallet,strNombreUnidadMedida,strFecha});
    }

}
