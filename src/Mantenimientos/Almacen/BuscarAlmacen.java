/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuscarAlmacen.java
 *
 * Created on Oct 2, 2011, 3:15:38 PM
 */
package Mantenimientos.Almacen;
import BusinessEntity.AlmacenBE;
import BusinessLogic.AlmacenBL;
import java.util.ArrayList;
import BusinessEntity.DepartamentoBE;
import DataAccess.DepartamentoDA;
import BusinessEntity.ProvinciaBE;
import DataAccess.ProvinciaDA;
import BusinessEntity.DistritoBE;
import DataAccess.DistritoDA;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DIEGO
 */
public class BuscarAlmacen extends javax.swing.JFrame {
    private AdmAlmacen ventanaPadre ;
    private ArrayList<DepartamentoBE> departamentos= new ArrayList<DepartamentoBE>();
    private ArrayList<ProvinciaBE> provincias= new ArrayList<ProvinciaBE>();
    private ArrayList<DistritoBE> distritos= new ArrayList<DistritoBE>();
    /** Creates new form BuscarAlmacen */
    
    public BuscarAlmacen(AdmAlmacen padre) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaPadre=padre;
        this.llenarComboDepartamentos();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbDistrito = new javax.swing.JComboBox();
        cmbProvincia = new javax.swing.JComboBox();
        cmbDepartamento = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Buscar almacén");

        jLabel1.setText("Código:");

        cmbProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProvinciaActionPerformed(evt);
            }
        });

        cmbDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepartamentoActionPerformed(evt);
            }
        });

        jLabel6.setText("Distrito:");

        jLabel4.setText("Departamento:");

        jLabel5.setText("Provincia:");

        btnBuscar.setText("Buscar");
        btnBuscar.setMaximumSize(new java.awt.Dimension(100, 23));
        btnBuscar.setMinimumSize(new java.awt.Dimension(100, 23));
        btnBuscar.setPreferredSize(new java.awt.Dimension(100, 23));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarMousePressed(evt);
            }
        });

        jLabel7.setText("Nombre:");

        jLabel8.setText("Estado:");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Activos", "Inactivos" }));

        btnCancelar.setText("Cancelar");
        btnCancelar.setMaximumSize(new java.awt.Dimension(100, 23));
        btnCancelar.setMinimumSize(new java.awt.Dimension(100, 23));
        btnCancelar.setPreferredSize(new java.awt.Dimension(100, 23));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCancelarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbDepartamento, 0, 162, Short.MAX_VALUE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                .addComponent(cmbProvincia, 0, 162, Short.MAX_VALUE)
                                .addComponent(cmbDistrito, 0, 162, Short.MAX_VALUE)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMousePressed
    this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarMousePressed

    private void btnBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMousePressed

        AlmacenBL a = new AlmacenBL();
        String indActivo="";
        if (cmbEstado.getSelectedItem()=="Activos"){
        indActivo="1";
        }
        if (cmbEstado.getSelectedItem()=="Inactivos"){
        indActivo="0";
        }

        String dep="";
        String prov="";
        String dist="";
        if (cmbDepartamento.getSelectedIndex()!=0){
        dep=departamentos.get(cmbDepartamento.getSelectedIndex() -1).getIdDepartamento();
        }
        if (cmbProvincia.getSelectedIndex()!=0 && cmbProvincia.getSelectedIndex()!=-1){
        prov=provincias.get(cmbProvincia.getSelectedIndex() -1).getIdProvincia();
        }
        if (cmbDistrito.getSelectedIndex()!=0 &&  cmbDistrito.getSelectedIndex()!=-1){
        dist=distritos.get(cmbDistrito.getSelectedIndex() -1).getIdDistrito();
        }
        this.ventanaPadre.recargar(a.buscar(txtCodigo.getText(), txtNombre.getText(), indActivo, dep, prov, dist));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarMousePressed

    private void cmbDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartamentoActionPerformed

        if (cmbDepartamento.getSelectedIndex()!=0){
        this.llenarComboProvincias();
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDepartamentoActionPerformed

    private void cmbProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProvinciaActionPerformed
    if (cmbProvincia.getSelectedIndex()!=0){
        this.llenarComboDistritos();
    }        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProvinciaActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbDepartamento;
    private javax.swing.JComboBox cmbDistrito;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    private void llenarComboDepartamentos() {

        cmbDepartamento.removeAllItems();

        try {

           departamentos = DataAccess.DepartamentoDA.queryAllDepartamento();
        cmbDepartamento.addItem("Seleccione");
        for (DepartamentoBE Departamento : departamentos){
            cmbDepartamento.addItem((Departamento.getDescripcion()));
        }
} catch (Exception ex) {
            Logger.getLogger(MantenimientoAlmacen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenarComboProvincias() {

            if (distritos.size()>0)this.distritos.clear();
            if (provincias.size()>0)this.provincias.clear();
            this.cmbProvincia.removeAllItems();
            this.cmbDistrito.removeAllItems();
         try {   provincias = DataAccess.ProvinciaDA.queryAllProvincia(
                    departamentos.get(cmbDepartamento.getSelectedIndex()-1).getIdDepartamento());
        cmbProvincia.addItem("Seleccione");
        for (ProvinciaBE Provincia : provincias){
            cmbProvincia.addItem((Provincia.getDescripcion()));

        }
} catch (Exception ex) {
            Logger.getLogger(MantenimientoAlmacen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenarComboDistritos() {

      try {
          if(cmbProvincia.getSelectedIndex()!=0 && cmbProvincia.getSelectedIndex()!=-1){
             if (distritos.size()>0)this.distritos.clear();
             this.cmbDistrito.removeAllItems();
            distritos = DataAccess.DistritoDA.queryAllDistrito(
                departamentos.get(cmbDepartamento.getSelectedIndex()-1).getIdDepartamento(),
                provincias.get(cmbProvincia.getSelectedIndex()-1).getIdProvincia());
        cmbDistrito.addItem("Seleccione");
        for (DistritoBE Distrito : distritos){
            cmbDistrito.addItem((Distrito.getDescripcion()));
        }
          }
} catch (Exception ex) {
            Logger.getLogger(MantenimientoAlmacen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
