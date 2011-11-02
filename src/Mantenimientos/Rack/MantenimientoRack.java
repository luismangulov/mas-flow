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
 * @author DIEGO
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
        
        strIdRack = txtIdRack.getText();
        intPosX = Integer.valueOf(txtPosX.getText());
        intPosY = Integer.valueOf(txtPosY.getText());
        intPisos = Integer.valueOf(txtPisos.getText());
        intColumnas = Integer.valueOf(txtColumnas.getText());
        
        if (chbxActivo.isSelected())
            strIndActivo = "1";
        else 
            strIndActivo = "0";
        
        ZonaBL objZonaBL = new ZonaBL();
        strIdZona = objZonaBL.getByIdentificadorZona(cbZona.getSelectedItem().toString()).getIdZona();
        objRackBL = new RackBL();
        objRackBE = new RackBE("",intPosX, intPosY, intPisos, intColumnas, strIndActivo, strIdZona, "");
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
   
        String strIdentificador = cbZona.getSelectedItem().toString().trim();
        strIdZona = objZonaBL.getByIdentificadorZona(strIdentificador).getIdZona();
        objRackBL = new RackBL();
        
        if (!cambioZona)
            strIdentificador = objRackBE.getIdentificador();
        objRackBE = new RackBE(strIdRack,intPosX, intPosY, intPisos, intColumnas, strIndActivo, strIdZona, strIdentificador);

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow -  Registrar rack");

        jLabel1.setText("Código:");

        jLabel2.setText("Posición X:");

        txtPosX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPosXActionPerformed(evt);
            }
        });
        txtPosX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPosXKeyTyped(evt);
            }
        });

        jLabel4.setText("Posición Y:");

        txtPosY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPosYActionPerformed(evt);
            }
        });
        txtPosY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPosYKeyTyped(evt);
            }
        });

        jLabel6.setText("Pisos:");

        txtPisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPisosActionPerformed(evt);
            }
        });
        txtPisos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPisosKeyTyped(evt);
            }
        });

        jLabel8.setText("Columnas:");

        txtColumnas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColumnasActionPerformed(evt);
            }
        });
        txtColumnas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtColumnasKeyReleased(evt);
            }
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
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel7.setText("Zona:");

        cbZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbZonaActionPerformed(evt);
            }
        });

        chbxActivo.setText("Activo");
        chbxActivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chbxActivoMouseClicked(evt);
            }
        });
        chbxActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxActivoActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbxActivo)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdRack, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbZona, 0, 207, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(41, 41, 41)
                                .addComponent(txtPosX, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(68, 68, 68)
                                .addComponent(txtPisos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(11, 11, 11)
                                .addComponent(txtPosY, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(12, 12, 12)
                                .addComponent(txtColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIdRack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2))
                            .addComponent(txtPosX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtPisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(chbxActivo))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4))
                            .addComponent(txtPosY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8))
                            .addComponent(txtColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addGap(24, 24, 24))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-394)/2, (screenSize.height-338)/2, 394, 338);
    }// </editor-fold>//GEN-END:initComponents

private void txtPosXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPosXActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtPosXActionPerformed

private void txtPosYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPosYActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtPosYActionPerformed

private void txtPisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPisosActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtPisosActionPerformed

private void txtColumnasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColumnasActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtColumnasActionPerformed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_btnCancelarActionPerformed

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    
    if (accion == 'R')
        this.insertar();
    else if (accion == 'M')
        this.modificar();
    
}//GEN-LAST:event_btnGuardarActionPerformed

private void cbZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbZonaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_cbZonaActionPerformed

private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
    this.dispose();
}//GEN-LAST:event_btnCancelarMouseClicked

private void chbxActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxActivoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_chbxActivoActionPerformed

private void chbxActivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chbxActivoMouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_chbxActivoMouseClicked

private void cbAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlmacenActionPerformed
    AlmacenBL objAlmacenBL = new AlmacenBL();
    int i;
    i = cbAlmacen.getSelectedIndex();
    String strIdAlmacen = arrIdAlmacenes.get(i);
    cargarComboZona(strIdAlmacen);
}//GEN-LAST:event_cbAlmacenActionPerformed

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
    if ((this.txtPisos.getText().length() + 1) > 6) {
       evt.consume();
    }
}//GEN-LAST:event_txtPisosKeyTyped

private void txtColumnasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColumnasKeyReleased

}//GEN-LAST:event_txtColumnasKeyReleased

private void txtColumnasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColumnasKeyTyped
    char c = (char)evt.getKeyChar();
    if (!Utilitario.validarSoloNumeros(evt.getKeyChar()) || (Character.isISOControl(c)))
       evt.consume();
    if ((this.txtColumnas.getText().length() + 1) > 6) {
       evt.consume();
    }
}//GEN-LAST:event_txtColumnasKeyTyped

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbAlmacen;
    private javax.swing.JComboBox cbZona;
    private javax.swing.JCheckBox chbxActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
        
//        cbZona.addItem("");
        
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
    
    
}
