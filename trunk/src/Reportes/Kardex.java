/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Kardex.java
 *
 * Created on Oct 2, 2011, 3:53:24 PM
 */
package Reportes;


import BusinessEntity.AlmacenBE;
import BusinessEntity.ProductoBE;
import Mantenimientos.Almacen.AyudaAlmacen;
import Mantenimientos.Producto.AyudaProductoV2;
import Util.conexion;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
 import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/**
 *
 * @author DIEGO
 */
public class Kardex extends javax.swing.JFrame {
    private AlmacenBE almacen = new AlmacenBE();
    private ProductoBE producto = new ProductoBE();
    /** Creates new form Kardex */
    public Kardex() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jdcFechaDesde = new com.toedter.calendar.JDateChooser();
        jdcFechaHasta = new com.toedter.calendar.JDateChooser();
        btnImprimir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtAlmacenDesde2 = new javax.swing.JTextField();
        txtAlmacenHasta2 = new javax.swing.JTextField();
        txtAlmacenDesde = new javax.swing.JTextField();
        txtAlmacenHasta = new javax.swing.JTextField();
        lblAlmacenDesde = new javax.swing.JLabel();
        lblAlmacenHasta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtProductoDesde2 = new javax.swing.JTextField();
        txtProductoHasta2 = new javax.swing.JTextField();
        txtProductoDesde = new javax.swing.JTextField();
        txtProductoHasta = new javax.swing.JTextField();
        lblProductoDesde = new javax.swing.JLabel();
        lblProductoHasta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Reporte de Kárdex");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        jLabel5.setText("Desde");

        jLabel6.setText("hasta");

        jdcFechaDesde.setDateFormatString("dd/MM/yy");

        jdcFechaHasta.setDateFormatString("dd/MM/yy");
        jdcFechaHasta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jdcFechaHastaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(jdcFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jdcFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnImprimir.setText("Imprimir");
        btnImprimir.setPreferredSize(new java.awt.Dimension(100, 23));
        btnImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnImprimirMousePressed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Almacenes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        jLabel9.setText("Desde");

        jLabel10.setText("hasta");

        txtAlmacenDesde2.setEnabled(false);

        txtAlmacenHasta2.setEnabled(false);

        txtAlmacenDesde.setEnabled(false);

        txtAlmacenHasta.setEnabled(false);

        lblAlmacenDesde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search24.png"))); // NOI18N
        lblAlmacenDesde.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAlmacenDesde.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAlmacenDesde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAlmacenDesdeMousePressed(evt);
            }
        });

        lblAlmacenHasta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search24.png"))); // NOI18N
        lblAlmacenHasta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAlmacenHasta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAlmacenHasta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAlmacenHastaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAlmacenDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlmacenHasta, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAlmacenHasta2, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(txtAlmacenDesde2, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAlmacenDesde)
                    .addComponent(lblAlmacenHasta))
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAlmacenDesde)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtAlmacenDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAlmacenDesde2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtAlmacenHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAlmacenHasta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblAlmacenHasta))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        jLabel1.setText("Desde");

        jLabel2.setText("hasta");

        txtProductoDesde2.setEnabled(false);

        txtProductoHasta2.setEnabled(false);

        txtProductoDesde.setEnabled(false);

        txtProductoHasta.setEnabled(false);

        lblProductoDesde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search24.png"))); // NOI18N
        lblProductoDesde.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblProductoDesde.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductoDesde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblProductoDesdeMousePressed(evt);
            }
        });

        lblProductoHasta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search24.png"))); // NOI18N
        lblProductoHasta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblProductoHasta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductoHasta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblProductoHastaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProductoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductoHasta, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProductoHasta2, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(txtProductoDesde2, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductoDesde)
                    .addComponent(lblProductoHasta))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblProductoDesde)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtProductoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtProductoDesde2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtProductoHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtProductoHasta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblProductoHasta))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMousePressed
        if (txtAlmacenDesde.getText().compareTo( txtAlmacenHasta.getText())>0) {
            JOptionPane.showMessageDialog(null, "Código de almacén desde mayor que almacén hasta.", "Error", 0);
            return;
        }
     if (txtProductoDesde.getText().compareTo( txtProductoHasta.getText())>0) {
            JOptionPane.showMessageDialog(null, "Código de producto desde mayor que producto hasta.", "Error", 0);
            return;
        }

        Date fechaDesde = null;
        Date fechaHasta = null;
        if (jdcFechaDesde.getCalendar()==null) fechaDesde= new Date(2011-1900,0,01);
        else jdcFechaDesde.getCalendar().getTime();
        if (jdcFechaHasta.getCalendar()==null) fechaHasta= new Date();
        else jdcFechaHasta.getCalendar().getTime();
        runReporte(txtAlmacenDesde.getText(), txtAlmacenHasta.getText(), txtProductoDesde.getText(), txtProductoHasta.getText(), fechaDesde, fechaHasta);        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirMousePressed

    private void lblAlmacenDesdeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAlmacenDesdeMousePressed
        this.almacen=new AlmacenBE();
        AyudaAlmacen m = new AyudaAlmacen(this,true,this.almacen);
        m.setVisible(true);
        this.txtAlmacenDesde.setText(almacen.getIdAlmacen());
        this.txtAlmacenDesde2.setText(almacen.getIdentificador()+ " - "+ almacen.getNombre());

        // TODO add your handling code here:
}//GEN-LAST:event_lblAlmacenDesdeMousePressed

    private void lblAlmacenHastaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAlmacenHastaMousePressed
        this.almacen=new AlmacenBE();
        AyudaAlmacen m = new AyudaAlmacen(this,true,this.almacen);
        m.setVisible(true);
        this.txtAlmacenHasta.setText(almacen.getIdAlmacen());
        this.txtAlmacenHasta2.setText(almacen.getIdentificador()+ " - "+ almacen.getNombre());// TODO add your handling code here:
}//GEN-LAST:event_lblAlmacenHastaMousePressed

    private void lblProductoDesdeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProductoDesdeMousePressed
        this.producto=new ProductoBE();
        AyudaProductoV2 m = new AyudaProductoV2(this,true,this.producto);
        m.setVisible(true);
        this.txtProductoDesde.setText(producto.getIdProducto());
        this.txtProductoDesde2.setText(producto.getNombre());// TODO add your handling code here:
        // TODO add your handling code here:
}//GEN-LAST:event_lblProductoDesdeMousePressed

    private void jdcFechaHastaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdcFechaHastaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdcFechaHastaMousePressed

    private void lblProductoHastaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProductoHastaMousePressed
        this.producto=new ProductoBE();
        AyudaProductoV2 m = new AyudaProductoV2(this,true,this.producto);
        m.setVisible(true);
        this.txtProductoHasta.setText(producto.getIdProducto());
        this.txtProductoHasta2.setText(producto.getNombre());        // TODO add your handling code here:
    }//GEN-LAST:event_lblProductoHastaMousePressed

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
            java.util.logging.Logger.getLogger(Kardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Kardex().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.toedter.calendar.JDateChooser jdcFechaDesde;
    private com.toedter.calendar.JDateChooser jdcFechaHasta;
    private javax.swing.JLabel lblAlmacenDesde;
    private javax.swing.JLabel lblAlmacenHasta;
    private javax.swing.JLabel lblProductoDesde;
    private javax.swing.JLabel lblProductoHasta;
    private javax.swing.JTextField txtAlmacenDesde;
    private javax.swing.JTextField txtAlmacenDesde2;
    private javax.swing.JTextField txtAlmacenHasta;
    private javax.swing.JTextField txtAlmacenHasta2;
    private javax.swing.JTextField txtProductoDesde;
    private javax.swing.JTextField txtProductoDesde2;
    private javax.swing.JTextField txtProductoHasta;
    private javax.swing.JTextField txtProductoHasta2;
    // End of variables declaration//GEN-END:variables

public void runReporte(String ad, String ah,String pd, String ph, Date fd, Date fh)
    {


//        try
//        {
            String master = System.getProperty("user.dir") +
                                "/src/Reportes/Kardex.jasper";

            System.out.println(master);
            if (master == null)
            {
                JOptionPane.showMessageDialog(null, "No se encontró el archivo del Reporte de Kardex.", "Mensaje",0);
                return;
            }

            JasperReport masterReport = null;
            try
            {
                masterReport = (JasperReport) JRLoader.loadObjectFromFile(master);//.loadObject(master);
            }
            catch (JRException e)
            {
                JOptionPane.showMessageDialog(null, "Error cargando el Repote de Kardex: " + e.getMessage(), "Mensaje",0);
                return;
            }

            //este es el par�metro, se pueden agregar m�s par�metros
            //basta con poner mas parametro.put
            Map parametro = new HashMap();

            

            if (pd.equals(""))parametro.put("desdeProducto","000001");
            else parametro.put("desdeProducto",pd);
            if (ph.equals(""))parametro.put("hastaProducto","999999");
            else parametro.put("hastaProducto",ph);
            if (ad.equals(""))parametro.put("desdeAlmacen","000001");
            else parametro.put("desdeAlmacen",ad);
            if (ah.equals(""))parametro.put("hastaAlmacen","999999");
            else parametro.put("hastaAlmacen",ah);
            parametro.put("empresa", Util.Configuracion.getEmpresa());
            parametro.put("desdeFecha",fd);
            parametro.put("hastaFecha",fh);
            //Reporte dise�ado y compilado con iReport
            try {
            conexion objConexion = new conexion();
            objConexion.SetearConexion();
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,objConexion.getCon());
            objConexion.SalirUID();
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("+Flow - Reporte de Kardex");
            jviewer.setVisible(true);
        }

        catch (Exception j)
        {
            JOptionPane.showMessageDialog(null, "Mensaje de Error:"+j.getMessage(), "Mensaje",0);
        }

   }


}
