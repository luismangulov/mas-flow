/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MantenimientoAlmacen.java
 *
 * Created on Oct 2, 2011, 2:57:54 PM
 */
package Mantenimientos.Almacen;
import BusinessEntity.AlmacenBE;
import BusinessLogic.AlmacenBL;
import BusinessLogic.ZonaBL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import BusinessEntity.DepartamentoBE;
import DataAccess.DepartamentoDA;
import BusinessEntity.ProvinciaBE;
import DataAccess.ProvinciaDA;
import BusinessEntity.DistritoBE;
import DataAccess.DistritoDA;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author DIEGO
 */
public class MantenimientoAlmacen extends javax.swing.JFrame {

    /** Creates new form MantenimientoAlmacen */
    private AdmAlmacen objPadre;
    private String accion;
    //private String codigo;
    private ArrayList<DepartamentoBE> departamentos= new ArrayList<DepartamentoBE>();
    private ArrayList<ProvinciaBE> provincias= new ArrayList<ProvinciaBE>();
    private ArrayList<DistritoBE> distritos= new ArrayList<DistritoBE>();

     public MantenimientoAlmacen(AdmAlmacen padre) {
        this.objPadre = padre;
        accion = "registrar";

        initComponents();
        this.setLocationRelativeTo(null);
        this.llenarComboDepartamentos();
        this.setTitle("+Flow - Registrar almacén");
        this.cbxActivo.setEnabled(false);
        this.setVisible(true);
    }

     public MantenimientoAlmacen(AdmAlmacen padre,AlmacenBE almacen){

        this.objPadre = padre;
        //this.codigo=almacen.getIdAlmacen();
        accion = "modificar";

        initComponents();
        this.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.cbxActivo.setEnabled(true);
        this.cbxActivo.setSelected(true);
        this.setTitle("+Flow - Editar almacén");

        txtCodigo.setText(almacen.getIdAlmacen());
        txtNombre.setText(almacen.getNombre());
        txtDireccion.setText(almacen.getDireccion());
        txtTelefono.setText(almacen.getTelefono());
        txtLargo.setText(String.valueOf(almacen.getLargo()));
        txtAncho.setText(String.valueOf(almacen.getAncho()));
        txtPuertaX.setText(String.valueOf(almacen.getPuertaX()));
        txtPuertaY.setText(String.valueOf(almacen.getPuertaY()));
        txtIdentificador.setText(almacen.getIdentificador());

        this.llenarComboDepartamentos();
        DepartamentoBE departamento = DepartamentoDA.queryDepartamento(almacen.getIdDepartamento());
        cmbDepartamento.setSelectedItem(departamento.getDescripcion());
        this.llenarComboProvincias();
        ProvinciaBE provincia = ProvinciaDA.queryProvincia(almacen.getIdDepartamento(), almacen.getIdProvincia());
        cmbProvincia.setSelectedItem(provincia.getDescripcion());
        this.llenarComboDistritos();
        DistritoBE distrito = DistritoDA.queryDistrito(almacen.getIdDepartamento(), almacen.getIdProvincia(), almacen.getIdDistrito());
        cmbDistrito.setSelectedItem(distrito.getDescripcion());
        
            if (almacen.getIndActivo().equals("1")){
                cbxActivo.setSelected(true);
            } else{
                cbxActivo.setSelected(false);
            }

            //txtIdDistrito.setText(cliente.getIdAlmacen());

            this.setVisible(true) ;


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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        cmbDistrito = new javax.swing.JComboBox();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        cbxActivo = new javax.swing.JCheckBox();
        cmbDepartamento = new javax.swing.JComboBox();
        cmbProvincia = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtLargo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAncho = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPuertaX = new javax.swing.JTextField();
        txtPuertaY = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtIdentificador = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Registrar almacén");

        jLabel1.setText("Código:");

        jLabel4.setText("Departamento*:");

        jLabel5.setText("Provincia*:");

        jLabel6.setText("Distrito*:");

        txtCodigo.setEditable(false);
        txtCodigo.setEnabled(false);

        btnGuardar.setText("Guardar");
        btnGuardar.setPreferredSize(new java.awt.Dimension(100, 23));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGuardarMousePressed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(100, 23));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCancelarMousePressed(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel9.setText("Dirección*:");

        jLabel10.setText("Teléfono:");

        txtDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDireccionFocusLost(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel11.setText("Nombre*:");

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        cbxActivo.setSelected(true);
        cbxActivo.setText("Activo");

        cmbDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepartamentoActionPerformed(evt);
            }
        });

        cmbProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProvinciaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dimensiones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        jLabel3.setText("Ancho*:");

        txtLargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLargoKeyTyped(evt);
            }
        });

        jLabel7.setText("mts.");

        jLabel8.setText("mts.");

        jLabel2.setText("Largo*:");

        txtAncho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnchoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAncho)
                    .addComponent(txtLargo, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(txtAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2)
                    .addComponent(txtLargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Puerta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        jLabel12.setText("Y*:");

        jLabel13.setText("X*:");

        txtPuertaX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPuertaXKeyTyped(evt);
            }
        });

        txtPuertaY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPuertaYKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPuertaY, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPuertaX, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtPuertaX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtPuertaY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel16.setText("Identificador:");

        txtIdentificador.setEnabled(false);
        txtIdentificador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificadorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbxActivo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addComponent(jLabel1)
                            .addComponent(jLabel16))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                                    .addComponent(txtDireccion)
                                    .addComponent(txtIdentificador)
                                    .addComponent(cmbDistrito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbProvincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
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
                    .addComponent(jLabel16)
                    .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(cbxActivo)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_btnCancelarActionPerformed

private void btnCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMousePressed
    this.dispose();    // TODO add your handling code here:
}//GEN-LAST:event_btnCancelarMousePressed

private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed

    if ((txtNombre.getText().length())==0) {
            JOptionPane.showMessageDialog(null, "Falta indicar nombre.", "Error", 0);
            return;
        }

    if ((cmbDepartamento.getSelectedIndex()==0)|| (cmbDepartamento.getSelectedIndex()==-1)) {
            JOptionPane.showMessageDialog(null, "Falta indicar departamento.", "Error", 0);
            return;
        }

    if ((cmbProvincia.getSelectedIndex()==0)|| (cmbProvincia.getSelectedIndex()==-1)) {
            JOptionPane.showMessageDialog(null, "Falta indicar provincia.", "Error", 0);
            return;
        }

    if ((cmbDistrito.getSelectedIndex()==0)|| (cmbDistrito.getSelectedIndex()==-1)) {
            JOptionPane.showMessageDialog(null, "Falta indicar distrito.", "Error", 0);
            return;
        }

    if ((txtDireccion.getText().length())==0) {
            JOptionPane.showMessageDialog(null, "Falta indicar dirección.", "Error", 0);
            return;
        }

     if ((txtLargo.getText().length())==0) {
            JOptionPane.showMessageDialog(null, "Falta indicar largo.", "Error", 0);
            return;
        }

    if ((txtAncho.getText().length())==0) {
            JOptionPane.showMessageDialog(null, "Falta indicar ancho.", "Error", 0);
            return;
        }

    if ((txtPuertaX.getText().length())==0) {
            JOptionPane.showMessageDialog(null, "Falta indicar coordenada X de la puerta.", "Error", 0);
            return;
        }

    if ((txtPuertaX.getText().length())==0) {
            JOptionPane.showMessageDialog(null, "Falta indicar coordenada X de la puerta.", "Error", 0);
            return;
        }

    String indActivo = new String();
        if (cbxActivo.isSelected()) {indActivo="1";} else {indActivo="0";}

        String identificador = "";
        identificador=cmbDepartamento.getSelectedItem().toString().substring(0, 3)+"-"+
                cmbProvincia.getSelectedItem().toString().substring(0, 3)+"-"+
                cmbDistrito.getSelectedItem().toString().substring(0, 3)+"-"+
                txtNombre.getText().trim();


        AlmacenBL almacenBL = new AlmacenBL();
        try {
            ArrayList<AlmacenBE>  almacenes= almacenBL.buscar("","","","","","", identificador);

            if (this.accion.equals("registrar")){

                if (!almacenes.isEmpty()){
                    JOptionPane.showMessageDialog(null, "El identificador formado ya existe. Cambiar nombre.", "Error", 0);
                return;
                }
                    boolean ok =almacenBL.insertar(txtCodigo.getText(),txtNombre.getText(),Double.parseDouble(txtLargo.getText()),
                    Double.parseDouble(txtAncho.getText()),txtDireccion.getText(),txtTelefono.getText(),
                    distritos.get(cmbDistrito.getSelectedIndex()-1).getIdDistrito(),
                    provincias.get(cmbProvincia.getSelectedIndex()-1).getIdProvincia(),
                    departamentos.get(cmbDepartamento.getSelectedIndex()-1).getIdDepartamento(), indActivo,
                    Integer.parseInt(txtPuertaX.getText()), Integer.parseInt(txtPuertaY.getText()),identificador );
                    if (ok==true){
                    AlmacenBE almacen = almacenBL.getAlmacen();
                    this.objPadre.recargaruno(almacen);
                    this.dispose();
                     } else {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado.", "Error", 0);
                return;
                    }
            } else {
                if (!almacenes.isEmpty() && (almacenes.get(0).getIdAlmacen() == null ? txtCodigo.getText() == null : almacenes.get(0).getIdAlmacen().equals(txtCodigo.getText()))){
                    JOptionPane.showMessageDialog(null, "El identificador formado ya existe. Cambiar nombre.", "Error", 0);
                return;
                }

                if (indActivo.equals("0")){
                    ZonaBL objRackBL = new ZonaBL();
                    if(!objRackBL.buscar("","", "1",txtCodigo.getText(), "").isEmpty()){
                         JOptionPane.showMessageDialog(null, "El almacén no se puede desactivar porque hay zonas activas asociadas.", "Error", 0);
                return;

                    }
                }
                AlmacenBE almacen = new AlmacenBE(txtCodigo.getText(),txtNombre.getText(),Double.parseDouble(txtLargo.getText()),
                    Double.parseDouble(txtAncho.getText()),txtDireccion.getText(),txtTelefono.getText(),
                    distritos.get(cmbDistrito.getSelectedIndex()-1).getIdDistrito(),
                    provincias.get(cmbProvincia.getSelectedIndex()-1).getIdProvincia(),
                    departamentos.get(cmbDepartamento.getSelectedIndex()-1).getIdDepartamento(),  indActivo,
                    Integer.parseInt(txtPuertaX.getText()), Integer.parseInt(txtPuertaY.getText()), identificador);

                    boolean ok =almacenBL.modificar(almacen);
                    if (ok==true){
                    this.objPadre.recargaruno(almacen);
                    this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado.", "Error", 0);
                return;
                    }
                    }

        } catch (Exception ex) {
            Logger.getLogger(MantenimientoAlmacen.class.getName()).log(Level.SEVERE, null, ex);
        }

    // TODO add your handling code here:
}//GEN-LAST:event_btnGuardarMousePressed

private void cmbDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartamentoActionPerformed
    if (cmbDepartamento.getSelectedIndex()!=0){
        this.llenarComboProvincias();
    }// TODO add your handling code here:
}//GEN-LAST:event_cmbDepartamentoActionPerformed

private void cmbProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProvinciaActionPerformed
    if (cmbProvincia.getSelectedIndex()!=0){
        this.llenarComboDistritos();
    }// TODO add your handling code here:
}//GEN-LAST:event_cmbProvinciaActionPerformed

private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
    if ((this.txtNombre.getText().length() + 1) > 10) {
            evt.consume();}     // TODO add your handling code here:
}//GEN-LAST:event_txtNombreKeyTyped

private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
    if ((this.txtDireccion.getText().length() + 1) > 30) {
            evt.consume();}     // TODO add your handling code here:
}//GEN-LAST:event_txtDireccionKeyTyped

private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = (char)evt.getKeyChar();
        if((c>='0' && c<='9') || (Character.isISOControl(c))){
        } else { evt.consume(); }

        if ((this.txtTelefono.getText().length() + 1) > 12) {
            evt.consume();
        }    // TODO add your handling code here:
}//GEN-LAST:event_txtTelefonoKeyTyped

private void txtAnchoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnchoKeyTyped
        char c = (char)evt.getKeyChar();
        if((c>='0' && c<='9') || (Character.isISOControl(c))||(c=='.')){
        } else { evt.consume(); }
        if((txtAncho.getText().contains("."))&&(c=='.')){
        evt.consume(); }
        
        if (txtAncho.getText().contains(".")){
        if((txtAncho.getCaretPosition()<=txtAncho.getText().indexOf(".")) && txtAncho.getText().indexOf(".")==4)
            evt.consume();
        else if ((txtAncho.getCaretPosition()>txtAncho.getText().indexOf(".")) && ((txtAncho.getText().length()-txtAncho.getText().indexOf("."))==3))
            evt.consume();
        } else if (txtAncho.getText().length()==4 && (c!='.') )  evt.consume();
        if (txtAncho.getText().length()==0 && (c=='.')) evt.consume();
        
    // TODO add your handling code here:
}//GEN-LAST:event_txtAnchoKeyTyped

private void txtLargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLargoKeyTyped
    char c = (char)evt.getKeyChar();
        if((c>='0' && c<='9') || (Character.isISOControl(c))||(c=='.')){
        } else { evt.consume(); }
        if((txtLargo.getText().contains("."))&&(c=='.')){
        evt.consume(); }

        if (txtLargo.getText().contains(".")){
        if((txtLargo.getCaretPosition()<=txtLargo.getText().indexOf(".")) && txtLargo.getText().indexOf(".")==4)
            evt.consume();
        else if ((txtLargo.getCaretPosition()>txtLargo.getText().indexOf(".")) && ((txtLargo.getText().length()-txtLargo.getText().indexOf("."))==3))
            evt.consume();
        } else if (txtLargo.getText().length()==4 && (c!='.') )  evt.consume();
        if (txtLargo.getText().length()==0 && (c=='.')) evt.consume();
        // TODO add your handling code here:
}//GEN-LAST:event_txtLargoKeyTyped

private void txtPuertaXKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPuertaXKeyTyped
    char c = (char)evt.getKeyChar();
        if((c>='0' && c<='9') || (Character.isISOControl(c))){
        } else { evt.consume(); }
        if ((this.txtPuertaX.getText().length() + 1) > 5) {
            evt.consume();}  // TODO add your handling code here:
}//GEN-LAST:event_txtPuertaXKeyTyped

private void txtPuertaYKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPuertaYKeyTyped
    char c = (char)evt.getKeyChar();
    if((c>='0' && c<='9') || (Character.isISOControl(c))){
    } else { evt.consume(); }
    if ((this.txtPuertaY.getText().length() + 1) > 5) {
        evt.consume();}      // TODO add your handling code here:
}//GEN-LAST:event_txtPuertaYKeyTyped

private void txtIdentificadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificadorKeyTyped
    // TODO add your handling code here:
}//GEN-LAST:event_txtIdentificadorKeyTyped

private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
    this.txtNombre.setText(txtNombre.getText().toUpperCase());    // TODO add your handling code here:
}//GEN-LAST:event_txtNombreFocusLost

private void txtDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusLost
    this.txtDireccion.setText(txtDireccion.getText().toUpperCase()); // TODO add your handling code here:
}//GEN-LAST:event_txtDireccionFocusLost


    /**
     * @param args the command line arguments
     */
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox cbxActivo;
    private javax.swing.JComboBox cmbDepartamento;
    private javax.swing.JComboBox cmbDistrito;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtAncho;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdentificador;
    private javax.swing.JTextField txtLargo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPuertaX;
    private javax.swing.JTextField txtPuertaY;
    private javax.swing.JTextField txtTelefono;
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

