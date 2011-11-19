/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuscarMovimientoInterno.java
 *
 * Created on Nov 2, 2011, 10:32:35 PM
 */
package Procesamiento.MovimientosInternos;

import BusinessEntity.AlmacenBE;
import BusinessEntity.MovimientoInternoBE;
import BusinessLogic.AlmacenBL;
import BusinessLogic.MovimientoInternoBL;
import Util.Utilitario;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author victor
 */
public class BuscarMovimientoInterno extends javax.swing.JFrame {
    
    AdmMovimientosInternos ventanaPadre;
    AlmacenBL objAlmacenBL = new AlmacenBL();
    MovimientoInternoBL objMovimientoInternoBL = new MovimientoInternoBL();
    
    ArrayList<MovimientoInternoBE> arrMovimientosInternos = new ArrayList<MovimientoInternoBE>();
    ArrayList<String> arrIdAlmacenes = new ArrayList<String>();
    ArrayList<AlmacenBE> arrAlmacenes = new ArrayList<AlmacenBE>();
    
    Date fechaInicio;
    Date fechaFin;
    
    String strIdProducto;
    String strIdAlmacen;

    public BuscarMovimientoInterno(AdmMovimientosInternos ventanaPadre) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaPadre = ventanaPadre;
        Date fechaActual = new Date();
        this.jdcFechaFin.setDate(fechaActual);
        this.jdcFechaInicio.setDate(fechaActual);
        cargarComboAlmacen();
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jdcFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jdcFechaInicio = new com.toedter.calendar.JDateChooser();
        txtNombreProducto = new javax.swing.JTextField();
        cbAlmacen = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("<html>Nombre<br>de Producto:</html>");

        jLabel2.setText("Almacén:");

        jLabel3.setText("Entre:");

        jLabel4.setText("y");

        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyTyped(evt);
            }
        });

        btnBuscar.setText("Buscar");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNombreProducto, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbAlmacen, javax.swing.GroupLayout.Alignment.LEADING, 0, 192, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnCancelar)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnBuscar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        
        if (!txtNombreProducto.getText().equals(""))
            strIdProducto = txtNombreProducto.getText();
        else
            strIdProducto = "";
        
        if (!cbAlmacen.getSelectedItem().toString().equals("")){
            strIdAlmacen = arrIdAlmacenes.get(cbAlmacen.getSelectedIndex());
        }else
            strIdAlmacen = "";

        if (jdcFechaInicio.getDate().before(jdcFechaFin.getDate()) || jdcFechaInicio.getDate().equals(jdcFechaFin.getDate())){
            fechaInicio = jdcFechaInicio.getDate();
            fechaFin = jdcFechaFin.getDate();
        }
        else{
            JOptionPane.showMessageDialog(null, "La fecha inicio debe ser anterior a la fecha final", "Error",0);
            return;
        }
        arrMovimientosInternos = objMovimientoInternoBL.getSearchList(strIdProducto,strIdAlmacen,fechaInicio,fechaFin);
        
        if (arrMovimientosInternos.size()>0){
            ventanaPadre.llenarDgv(arrMovimientosInternos);
            this.dispose();
        }else
            JOptionPane.showMessageDialog(null, "No se encontraron movimientos internos","Mensaje",1);
        
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void txtNombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyTyped
        char c = (char)evt.getKeyChar();
        if (!Utilitario.validarCadenaAlfabetica(evt.getKeyChar()) || (Character.isISOControl(c)))
           evt.consume();
        if ((this.txtNombreProducto.getText().length() + 1) > 20) {
           evt.consume();
        }
    }//GEN-LAST:event_txtNombreProductoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cbAlmacen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private com.toedter.calendar.JDateChooser jdcFechaFin;
    private com.toedter.calendar.JDateChooser jdcFechaInicio;
    private javax.swing.JTextField txtNombreProducto;
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
}
