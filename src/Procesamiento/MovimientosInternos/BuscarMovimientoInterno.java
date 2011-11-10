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
        txtIdProducto = new javax.swing.JTextField();
        cbAlmacen = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("<html>Código  <br>de Producto</html>");

        jLabel2.setText("Almacén:");

        jLabel3.setText("Entre:");

        jLabel4.setText("y");

        txtIdProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdProductoKeyTyped(evt);
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
                .addGap(203, 203, 203)
                .addComponent(btnBuscar)
                .addGap(32, 32, 32)
                .addComponent(btnCancelar)
                .addContainerGap(212, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)
                        .addGap(37, 37, 37)
                        .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbAlmacen, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnBuscar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        
        if (!txtIdProducto.getText().equals(""))
            strIdProducto = txtIdProducto.getText();
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
            JOptionPane.showMessageDialog(null, "La fecha inicio debe ser anterior a la fecha final");
            return;
        }
        arrMovimientosInternos = objMovimientoInternoBL.getSearchList(strIdProducto,strIdAlmacen,fechaInicio,fechaFin);
        
        if (arrMovimientosInternos.size()>0){
            ventanaPadre.llenarDgv(arrMovimientosInternos);
            this.dispose();
        }else
            JOptionPane.showMessageDialog(null, "No hay resultados de búsqueda");
        
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void txtIdProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProductoKeyTyped
    char c = (char)evt.getKeyChar();
    if (!Utilitario.validarSoloNumeros(evt.getKeyChar()) || (Character.isISOControl(c)))
       evt.consume();
    if ((this.txtIdProducto.getText().length() + 1) > 6) {
       evt.consume();
    }
    }//GEN-LAST:event_txtIdProductoKeyTyped

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
    private javax.swing.JTextField txtIdProducto;
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
