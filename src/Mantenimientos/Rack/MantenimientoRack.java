/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MantenimientoRack.java
 *
 * Created on Oct 2, 2011, 3:12:27 PM
 */
package Mantenimientos.Rack;

import BusinessEntity.AlmacenBE;
import BusinessEntity.RackBE;
import BusinessEntity.UbicacionBE;
import BusinessEntity.UnidadMedidaBE;
import BusinessEntity.ZonaBE;
import BusinessLogic.AlmacenBL;
import BusinessLogic.RackBL;
import BusinessLogic.UbicacionBL;
import BusinessLogic.ZonaBL;
import DataAccess.AlmacenDA;
import DataAccess.UnidadMedidaDA;
import DataAccess.ZonaDA;
import Util.Utilitario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author VICTOR
 */
public class MantenimientoRack extends javax.swing.JFrame {

    /** Creates new form MantenimientoRack */
    ZonaDA objZonaDA;
    ArrayList<ZonaBE> arrZonas;
    ArrayList<String> arrIdAlmacenes = new ArrayList<String>();
    String strIdRack;
    int intPosX;
    int intPosY;
    int intPisos;
    int intColumnas;
    String strIndActivo;
    String strIdZona;
    char accion;
    String idRack;
    String strOrientacion;
    
    RackBL objRackBL;
    RackBE objRackBE;
    String idAlmacen;
    String guardaIdZona;
    ZonaBE objZonaBE;
    String strIdRackObjetivo;
    AdmRack ventanaPadre;
    AlmacenBL objAlmacenBL;
    ZonaBL objZonaBL;
    
    boolean boolExito;
    
    public MantenimientoRack(char c, AdmRack ventanaPadre) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cargarComboAlmacen();
        txtIdRack.setEnabled(false);
        this.accion = c;
        this.ventanaPadre = ventanaPadre;
        txtIdRack.setEnabled(false);
        chbxActivo.setSelected(true);
    }
    
    public MantenimientoRack(char c, String idRack, AdmRack ventanaPadre) {
        this.accion = c;
        strIdRackObjetivo = idRack;
        this.ventanaPadre = ventanaPadre;
        initComponents();
        objRackBL = new RackBL();
        objRackBE = objRackBL.getByIdRack(strIdRackObjetivo);
        this.setVisible(true);
        this.cargarComponentes(objRackBE);
        txtIdRack.setEnabled(false);

    }
    
    private void insertar(){
        
        if (!validar())
            return;
        
        strIdRack = txtIdRack.getText();
        intPosX = Integer.valueOf(txtPosX.getText());
        intPosY = Integer.valueOf(txtPosY.getText());
        intPisos = Integer.valueOf(txtPisos.getText());
        intColumnas = Integer.valueOf(txtColumnas.getText());
        
        if (chbxActivo.isSelected())
            strIndActivo = "1";
        else 
            strIndActivo = "0";
        
        if (cbOrientacion.getSelectedItem().toString().equals("Vertical"))
            strOrientacion = "V";
        else
            strOrientacion = "H";
        
        objZonaBL = new ZonaBL();
        strIdZona = objZonaBL.getByIdentificadorZona(cbZona.getSelectedItem().toString()).getIdZona();
        objRackBL = new RackBL();
        objRackBE = new RackBE("",intPosX, intPosY, intPisos, intColumnas, strIndActivo, strIdZona, "", strOrientacion);
        objRackBL.insertar(objRackBE);
        
        UbicacionBL objUbicacionBL = new UbicacionBL();
        UbicacionBE objUbicacionBE;
        int pisos = objRackBE.getPisos();
        int columnas = objRackBE.getColumnas();
        strIdRack = objRackBE.getIdRack();
        
        for (int i=1; i<=pisos; i++)
            
            for (int j=1; j<=columnas; j++){
                
                objUbicacionBE = new UbicacionBE();
                objUbicacionBE.setFila(i);
                objUbicacionBE.setColumna(j);
                objUbicacionBE.setIdRack(strIdRack);
                objUbicacionBE.setIndActivo("1");
                
                objUbicacionBL.insertar(objUbicacionBE);
                
            }
        this.dispose();
        ventanaPadre.actualizaDgv(objRackBE);
    }
    
    private void modificar(){
        
        if (!validar())
            return;
        
        boolean cambioZona = false;
        ZonaBL objZonaBL = new ZonaBL();
        
        if (!guardaIdZona.equals(cbZona.getSelectedItem().toString().trim()))
            cambioZona = true;
        
        strIdRack = txtIdRack.getText();
        intPosX = Integer.valueOf(txtPosX.getText());
        intPosY = Integer.valueOf(txtPosY.getText());
        intPisos = Integer.valueOf(txtPisos.getText());
        intColumnas = Integer.valueOf(txtColumnas.getText());
        
        if (chbxActivo.isSelected())
            strIndActivo = "1";
        else 
            strIndActivo = "0";
        
        if (cbOrientacion.getSelectedItem().equals("Vertical"))
            strOrientacion = "V";
        else
            strOrientacion = "H";
        
        String strIdentificador = cbZona.getSelectedItem().toString().trim();
        strIdZona = objZonaBL.getByIdentificadorZona(strIdentificador).getIdZona();
        objRackBL = new RackBL();
        
        if (!cambioZona)
            strIdentificador = objRackBE.getIdentificador();
        objRackBE = new RackBE(strIdRack,intPosX, intPosY, intPisos, intColumnas, strIndActivo, strIdZona, strIdentificador,strOrientacion);

        UbicacionBL objUbicacionBL = new UbicacionBL();
        
        if (strIndActivo.equals("0")){
            int intCantUbicacionesOcupadas = objUbicacionBL.getCantUbicacionesOcupadas(strIdRack);
            if (intCantUbicacionesOcupadas > 0)
                JOptionPane.showMessageDialog(null, "No se puede inactivar. Hay ubicaciones en uso o bloqueadas en el rack");
            else{
                objUbicacionBL.bloquearUbicacionByRack(strIdRack);
            }
        }
        else
            objUbicacionBL.desbloquearUbicacionByRack(strIdRack);
        boolExito = objRackBL.modificar(objRackBE,cambioZona);
        if (boolExito)
            ventanaPadre.actualizaDgv(objRackBE);

        this.dispose();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIdRack = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPosX = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPosY = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPisos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtColumnas = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbZona = new javax.swing.JComboBox();
        chbxActivo = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        cbAlmacen = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbOrientacion = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow -  Registrar rack");

        jLabel1.setText("Código:");

        jLabel2.setText("Posición X*:");

        txtPosX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPosXKeyTyped(evt);
            }
        });

        jLabel4.setText("Posición Y*:");

        txtPosY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPosYKeyTyped(evt);
            }
        });

        jLabel6.setText("Pisos*:");

        txtPisos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPisosKeyTyped(evt);
            }
        });

        jLabel8.setText("Columnas*:");

        txtColumnas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColumnasKeyTyped(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setMaximumSize(new java.awt.Dimension(75, 23));
        btnGuardar.setMinimumSize(new java.awt.Dimension(75, 23));
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

        jLabel7.setText("Zona*:");

        chbxActivo.setText("Activo");

        jLabel3.setText("Almacén*:");

        cbAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlmacenActionPerformed(evt);
            }
        });

        jLabel5.setText("Orientación*:");

        cbOrientacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Horizontal", "Vertical" }));
        cbOrientacion.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnCancelar)
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chbxActivo)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPosX, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPisos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPosY, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(13, 13, 13))
                                    .addComponent(cbOrientacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdRack, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbZona, 0, 246, Short.MAX_VALUE)
                                    .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIdRack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPosX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPosY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbOrientacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(chbxActivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addGap(24, 24, 24))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-419)/2, (screenSize.height-373)/2, 419, 373);
    }// </editor-fold>//GEN-END:initComponents

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    
    if (accion == 'R')
        this.insertar();
    else if (accion == 'M')
        this.modificar();
    
}//GEN-LAST:event_btnGuardarActionPerformed

private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
    this.dispose();
}//GEN-LAST:event_btnCancelarMouseClicked

private void txtPosXKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPosXKeyTyped
    char c = (char)evt.getKeyChar();
    if (!Utilitario.validarSoloNumeros(evt.getKeyChar()) || (Character.isISOControl(c)))
       evt.consume();
    if ((this.txtPosX.getText().length() + 1) > 6) {
       evt.consume();
    }
}//GEN-LAST:event_txtPosXKeyTyped

private void txtPosYKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPosYKeyTyped
    char c = (char)evt.getKeyChar();
    if (!Utilitario.validarSoloNumeros(evt.getKeyChar()) || (Character.isISOControl(c)))
       evt.consume();
    if ((this.txtPosY.getText().length() + 1) > 6) {
       evt.consume();
    }
}//GEN-LAST:event_txtPosYKeyTyped

private void txtPisosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPisosKeyTyped
    char c = (char)evt.getKeyChar();
    if (!Utilitario.validarSoloNumeros(evt.getKeyChar()) || (Character.isISOControl(c)))
       evt.consume();
    if ((this.txtPisos.getText().length() + 1) > 1) {
       evt.consume();
    }
}//GEN-LAST:event_txtPisosKeyTyped

private void txtColumnasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColumnasKeyTyped
    char c = (char)evt.getKeyChar();
    if (!Utilitario.validarSoloNumeros(evt.getKeyChar()) || (Character.isISOControl(c)))
       evt.consume();
    if ((this.txtColumnas.getText().length() + 1) > 6) {
       evt.consume();
    }
}//GEN-LAST:event_txtColumnasKeyTyped

    private void cbAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlmacenActionPerformed
    objAlmacenBL = new AlmacenBL();
    int i;
    i = cbAlmacen.getSelectedIndex();
    String strIdAlmacen = arrIdAlmacenes.get(i);
    cargarComboZona(strIdAlmacen);
    }//GEN-LAST:event_cbAlmacenActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbAlmacen;
    private javax.swing.JComboBox cbOrientacion;
    private javax.swing.JComboBox cbZona;
    private javax.swing.JCheckBox chbxActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtColumnas;
    private javax.swing.JTextField txtIdRack;
    private javax.swing.JTextField txtPisos;
    private javax.swing.JTextField txtPosX;
    private javax.swing.JTextField txtPosY;
    // End of variables declaration//GEN-END:variables


    private void cargarComboAlmacen(){
        
        cbAlmacen.removeAllItems();
        cbZona.removeAllItems();
       
        ArrayList<AlmacenBE> arrAlmacenes = new ArrayList<AlmacenBE>();
        objAlmacenBL = new AlmacenBL();
        arrAlmacenes = objAlmacenBL.getAllAlmacenActivo();
        
        if (arrAlmacenes != null)
            for(AlmacenBE almacen : arrAlmacenes){
                arrIdAlmacenes.add(almacen.getIdAlmacen());
                cbAlmacen.addItem(almacen.getIdentificador().trim());
            }
    }
    
    private void cargarComboZona(String idAlmacen){
        
        cbZona.removeAllItems();

        ArrayList<ZonaBE> arrZonas = new ArrayList<ZonaBE>();
        objZonaBL = new ZonaBL();
        arrZonas = objZonaBL.getZonasByAlmacen(idAlmacen);
        
        if (arrZonas != null)
            for(ZonaBE zona : arrZonas)
                cbZona.addItem(zona.getIdentificador().trim());
    }
    
    private void cargarComponentes(RackBE objRackBE){
        
        this.setTitle("Modificar Rack");
        txtIdRack.setText(objRackBE.getIdRack());
        txtIdRack.setEnabled(false);
        txtPosX.setText(String.valueOf(objRackBE.getPosX()));
        txtPosY.setText(String.valueOf(objRackBE.getPosY()));
        txtPisos.setText(String.valueOf(objRackBE.getPisos()));
        txtPisos.setEnabled(false);
        txtColumnas.setText(String.valueOf(objRackBE.getColumnas()));
        txtColumnas.setEnabled(false);
        
        if ("1".equals(objRackBE.getIndActivo()))
            chbxActivo.setSelected(true);
        else
            chbxActivo.setSelected(false);

        objAlmacenBL = new AlmacenBL();
        
        this.cargarComboAlmacen();
        
        objZonaDA = new ZonaDA();
        
        for(int i=0; i<cbZona.getItemCount() ; i++){
            String strIdentificadorZona = objZonaDA.queryByIdZona(objRackBE.getIdZona()).getIdentificador();
//            JOptionPane.showMessageDialog(null, cbZona.getItemCount());
            if(cbZona.getItemAt(i).toString().equals(strIdentificadorZona)){
                cbZona.setSelectedIndex(i);
                break;
            }
        }
        String strIdZona = objRackBE.getIdZona();
        objZonaBL = new ZonaBL();
        guardaIdZona = objZonaBL.getZona(strIdZona).getIdentificador();
    }
    
    public boolean validar(){
        
        if(cbOrientacion.getItemCount()==0){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un almacén");
            return false;            
        }
        
        if (cbAlmacen.getItemCount()==0){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un almacén");
            return false;
        }
        
        if (cbZona.getItemCount()==0){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una zona");
            return false;
        }
        
        if (txtPosX.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar la posición X del rack");
            return false;
        }
        
        if (txtPosY.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar la posición Y del rack");
            return false;
        }
         
        if (txtPisos.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad de pisos del rack");
            return false;
        }
            
        if (txtColumnas.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad de columnas del rack");
            return false;
        }
        
        if (!validarPosicionamiento())
            return false;
        
        return true;
    }
    
    public boolean validarPosicionamiento(){
        
        objZonaBL = new ZonaBL();
        objZonaBE = objZonaBL.getByIdentificadorZona(cbZona.getSelectedItem().toString());
        int intPosXZona = objZonaBE.getPosX();
        int intPosYZona = objZonaBE.getPosY();
        int intAnchoZona = objZonaBE.getAncho();
        int intLargoZona = objZonaBE.getLargo();
        
        int intPosXRack = Integer.parseInt(txtPosX.getText());
        int intPosYRack = Integer.parseInt(txtPosY.getText());
        int intColumnasRack = Integer.parseInt(txtColumnas.getText());
        
        if (cbOrientacion.getSelectedItem().toString().equals("Horizontal"))
            strOrientacion = "H";
        else
            strOrientacion = "V";
        
        //1 validar límites de la zona
        
        if ((intPosXRack < intPosXZona && intPosYRack < intPosYZona) || (intPosYRack > intPosYZona + intLargoZona 
            && intPosXRack > intPosXZona) || (intPosXRack > intPosXZona + intAnchoZona && intPosYRack < intPosYZona) 
            || (intPosXRack > intPosXZona + intAnchoZona && intPosYRack > intPosYZona + intLargoZona)){ 
            
            JOptionPane.showMessageDialog(null, "El rack excede las dimensiones de la zona");
            return false;
        }
        
        //2 validar que los racks no se solapen
        
        objRackBL = new RackBL();
        ArrayList<RackBE> arrRacks = objRackBL.getRacksByZona(strIdZona);
        boolExito = true;
        //si no hay racks en el sistema entonces se termina el registro del rack
        
        if (arrRacks != null){

            //2.1 se crea una matriz de la zona solo con las posiciones que ocuparía el rack  a agregar (set 1)

            int matrizZonaRack[][] = new int[intAnchoZona][intLargoZona];

            //2.1.1 inicialización de matriz

            for (int i=0; i<intPosXZona; i++)
                for (int j=0; j<intPosYZona; j++)
                    matrizZonaRack[i][j] = 0;

            if (strOrientacion.equals("H"))
                for (int i=0; i<intColumnasRack; i++)
                    matrizZonaRack[intPosXRack+i][intPosYRack] = 1;

            else
                for (int i=0; i<intColumnasRack; i++)
                    matrizZonaRack[intPosXRack][intPosYRack+i] = 1;
            
            //2.2 se crea una matriz de la zona con las posiciones ocupadas por los racks en el sistema

            int matrizZona[][] = new int[intAnchoZona][intLargoZona];

            //2.2.1 inicialización de matriz

            for (int i=0; i<intPosXZona; i++)
                for (int j=0; j<intPosYZona; j++)
                    matrizZona[i][j] = 0;
            
            for (RackBE rack : arrRacks){
                if (rack.getOrientacion().equals("H"))
                    for (int i=0; i<rack.getColumnas(); i++)
                        matrizZona[rack.getPosX()+i][rack.getPosY()] = 1;

                else
                    for (int i=0; i<intColumnasRack; i++)
                        matrizZona[rack.getPosX()][rack.getPosY()+i] = 1;
            }
            
            //3 comparar matrices
            
            for (int i=0; i<intPosXZona; i++)
                for (int j=0; j<intPosYZona; j++)
                    if (matrizZonaRack[i][j] == 1 && matrizZona[i][j] == 1){
                        JOptionPane.showMessageDialog(null, "Existe solapamiento de racks");
                        return false;
                    }
                        
        }
        
        return true;
    }
    
}
