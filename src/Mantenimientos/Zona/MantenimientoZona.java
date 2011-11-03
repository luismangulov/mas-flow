/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MantenimientoZona.java
 *
 * Created on Oct 2, 2011, 3:16:24 PM
 */
package Mantenimientos.Zona;

import BusinessEntity.FamiliaBE;
import Mantenimientos.FamiliaProd.AyudaFamiliaProd;
import BusinessEntity.AlmacenBE;
import BusinessLogic.AlmacenBL;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import BusinessEntity.ZonaBE;
import BusinessLogic.ZonaBL;
import BusinessLogic.RackBL;
import BusinessLogic.UbicacionBL;
import BusinessEntity.UbicacionBE;
/**
 *
 * @author DIEGO
 */
public class MantenimientoZona extends javax.swing.JFrame {
    public ArrayList<FamiliaBE> familias= new ArrayList<FamiliaBE>();
    private ArrayList<AlmacenBE> almacenes = new ArrayList<AlmacenBE>();
    /** Creates new form MantenimientoZona */
    private AdmZona objPadre;
    private String accion;
    private String codigo;


     public MantenimientoZona(AdmZona padre) {
        this.objPadre = padre;
        accion = "registrar";

        initComponents();
        this.setLocationRelativeTo(null);
        this.llenarComboAlmacen();
        this.setTitle("+Flow - Registrar zona");
        this.cbxActivo.setEnabled(false);
        this.setVisible(true);
        dgvFamilia.setColumnSelectionAllowed(false);
        dgvFamilia.setCellSelectionEnabled(false);
        dgvFamilia.setRowSelectionAllowed(true);
    }

     public MantenimientoZona(AdmZona padre,ZonaBE zona){

        this.objPadre = padre;
        this.codigo=zona.getIdZona();
        accion = "modificar";

        initComponents();
        this.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.cbxActivo.setEnabled(true);
        this.cbxActivo.setSelected(true);
        this.setTitle("+Flow - Editar zona");

        dgvFamilia.setColumnSelectionAllowed(false);
        dgvFamilia.setCellSelectionEnabled(false);
        dgvFamilia.setRowSelectionAllowed(true);

        txtCodigo.setText(zona.getIdZona());
        txtNombre.setText(zona.getNombre());
        txtIdentificador.setText(zona.getIdentificador());
        txtPosX.setText(String.valueOf(zona.getPosX()));
        txtPosY.setText(String.valueOf(zona.getPosY()));
        txtAncho.setText(String.valueOf(zona.getAncho()));
        txtLargo.setText(String.valueOf(zona.getLargo()));
        txtPosX.setEnabled(false);
        txtPosY.setEnabled(false);
        txtAncho.setEnabled(false);
        txtLargo.setEnabled(false);
        
        this.llenarComboAlmacen();
        AlmacenBL almacenBL = new AlmacenBL();
        AlmacenBE almacen = almacenBL.getAlmacen(zona.getIdAlmacen());
        cmbAlmacen.setSelectedItem(almacen.getIdentificador());
        familias=zona.getFamilias();
        recargar(this.familias);


            if (zona.getIndActivo().equals("1")){
                cbxActivo.setSelected(true);
            } else{
                cbxActivo.setSelected(false);
            }

            //txtIdDistrito.setText(cliente.getIdZona());

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

        jLabel8 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtLargo = new javax.swing.JTextField();
        txtPosX = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvFamilia = new javax.swing.JTable();
        txtPosY = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblAdd = new javax.swing.JLabel();
        txtAncho = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        cbxActivo = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        lblDelete = new javax.swing.JLabel();
        cmbAlmacen = new javax.swing.JComboBox();
        txtIdentificador = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Registrar zona");
        setResizable(false);

        jLabel8.setText("Y*:");

        txtCodigo.setEditable(false);
        txtCodigo.setEnabled(false);

        txtLargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLargoKeyTyped(evt);
            }
        });

        txtPosX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPosXKeyTyped(evt);
            }
        });

        jLabel6.setText("Almacén*:");

        dgvFamilia.setAutoCreateRowSorter(true);
        dgvFamilia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Familia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgvFamilia.setCellSelectionEnabled(false);
        jScrollPane1.setViewportView(dgvFamilia);
        dgvFamilia.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        dgvFamilia.getColumnModel().getColumn(0).setPreferredWidth(20);
        dgvFamilia.getColumnModel().getColumn(1).setPreferredWidth(100);

        txtPosY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPosYKeyTyped(evt);
            }
        });

        jLabel9.setText("Largo*:");

        jLabel1.setText("Código*:");

        lblAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add24.png"))); // NOI18N
        lblAdd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAddMousePressed(evt);
            }
        });

        txtAncho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnchoKeyTyped(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setMaximumSize(new java.awt.Dimension(100, 23));
        btnCancelar.setMinimumSize(new java.awt.Dimension(100, 23));
        btnCancelar.setPreferredSize(new java.awt.Dimension(100, 23));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCancelarMousePressed(evt);
            }
        });

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

        jLabel2.setText("Nombre*:");

        jLabel7.setText("X*:");

        jLabel3.setText("Identificador:");

        btnGuardar.setText("Guardar");
        btnGuardar.setMaximumSize(new java.awt.Dimension(100, 23));
        btnGuardar.setMinimumSize(new java.awt.Dimension(100, 23));
        btnGuardar.setPreferredSize(new java.awt.Dimension(100, 23));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGuardarMousePressed(evt);
            }
        });

        lblDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete24.png"))); // NOI18N
        lblDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblDeleteMousePressed(evt);
            }
        });

        txtIdentificador.setEnabled(false);

        jLabel10.setText("Ancho*:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/System Map.png"))); // NOI18N
        jLabel4.setToolTipText("Ver mapa del almacén");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDelete, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAdd, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPosX, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPosY, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLargo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(cbxActivo)
                .addContainerGap(304, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbAlmacen, 0, 283, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(txtPosX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPosY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(txtAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxActivo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lblAdd)
                        .addGap(18, 18, 18)
                        .addComponent(lblDelete)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMousePressed
        AyudaFamiliaProd m = new AyudaFamiliaProd(this);
        m.setVisible(true);
        
}//GEN-LAST:event_lblAddMousePressed

    private void lblDeleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteMousePressed
     if((dgvFamilia.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado una familia.", "Mensaje",0);
        } else if((dgvFamilia.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado más de una familia.", "Mensaje",0);
        }else{
        familias.remove(dgvFamilia.getSelectedRow());
        recargar(this.familias);
     }
    }//GEN-LAST:event_lblDeleteMousePressed

    private void btnCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMousePressed
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarMousePressed

    private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed

        if ((txtNombre.getText().length())==0) {
            JOptionPane.showMessageDialog(null, "Falta indicar nombre.", "Error", 0);
            return;
        }

        if ((cmbAlmacen.getSelectedIndex()==0)|| (cmbAlmacen.getSelectedIndex()==-1)) {
            JOptionPane.showMessageDialog(null, "Falta indicar almacén.", "Error", 0);
            return;
        }

        if ((txtPosX.getText().length())==0) {
            JOptionPane.showMessageDialog(null, "Falta indicar coordenada X de inicio.", "Error", 0);
            return;
        }

        if ((txtPosY.getText().length())==0) {
            JOptionPane.showMessageDialog(null, "Falta indicar coordenada Y de inicio.", "Error", 0);
            return;
        }

        if ((txtAncho.getText().length())==0) {
            JOptionPane.showMessageDialog(null, "Falta indicar ancho.", "Error", 0);
            return;
        }


        if ((txtLargo.getText().length())==0) {
            JOptionPane.showMessageDialog(null, "Falta indicar largo.", "Error", 0);
            return;
        }
        
         String indActivo = new String();
        if (cbxActivo.isSelected()) {indActivo="1";} else {indActivo="0";}

        String identificador ="";

        identificador=cmbAlmacen.getSelectedItem()+ "-" + txtNombre.getText().trim();

        ZonaBL zonaBL = new ZonaBL();

        ArrayList<ZonaBE>  zonas= zonaBL.buscar("","","","", identificador);

        try {
            if (this.accion.equals("registrar")){
                if (!zonas.isEmpty()){
                    JOptionPane.showMessageDialog(null, "El identificador formado ya existe. Cambiar nombre.", "Error", 0);
                return;
                }
                    boolean ok =zonaBL.insertar(txtCodigo.getText(),txtNombre.getText(),identificador,
                    indActivo,almacenes.get(cmbAlmacen.getSelectedIndex() -1).getIdAlmacen(),
                    Integer.parseInt(txtPosX.getText()), Integer.parseInt(txtPosY.getText()),
                    Integer.parseInt(txtAncho.getText()), Integer.parseInt(txtLargo.getText()),
                    familias  );
                    if (ok==true){
                    ZonaBE zona= zonaBL.getZona();
                    this.objPadre.recargaruno(zona);
                    this.dispose();
                     } else {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado.", "Error", 0);
                return;
                    }
            } else {
                if (!zonas.isEmpty() && !(zonas.get(0).getIdAlmacen() == null ? txtCodigo.getText() == null : zonas.get(0).getIdZona().equals(txtCodigo.getText()))){
                    JOptionPane.showMessageDialog(null, "El identificador formado ya existe. Cambiar nombre.", "Error", 0);
                return;
                }
                if (indActivo.equals("0")){
                    RackBL objRackBL = new RackBL();
                    if(!objRackBL.getListSearch(
                            almacenes.get(cmbAlmacen.getSelectedIndex()-1).getIdAlmacen(),
                            "",txtCodigo.getText() ,"1" ).isEmpty()){
                         JOptionPane.showMessageDialog(null, "La zona no se puede desactivar porque hay racks activos asociados.", "Error", 0);
                return;

                    }

                }
                 ZonaBE zona = new ZonaBE(txtCodigo.getText(),txtNombre.getText(),identificador,
                    indActivo,almacenes.get(cmbAlmacen.getSelectedIndex()-1).getIdAlmacen(),
                    Integer.parseInt(txtPosX.getText()), Integer.parseInt(txtPosY.getText()),
                    Integer.parseInt(txtAncho.getText()), Integer.parseInt(txtLargo.getText()),
                    familias);

                    boolean ok =zonaBL.modificar(zona);
                    if (ok==true){
                    this.objPadre.recargaruno(zona);
                    this.dispose();
                     } else {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado.", "Error", 0);
                return;
                    }
                    }



        } catch (Exception ex) {
            Logger.getLogger(MantenimientoZona.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarMousePressed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
    if ((this.txtNombre.getText().length() + 1) > 10) {
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtPosXKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPosXKeyTyped
    char c = (char)evt.getKeyChar();
        if((c>='0' && c<='9') || (Character.isISOControl(c))){
        } else { evt.consume(); }
        if ((this.txtPosX.getText().length() + 1) > 5) {
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_txtPosXKeyTyped

    private void txtPosYKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPosYKeyTyped
    char c = (char)evt.getKeyChar();
        if((c>='0' && c<='9') || (Character.isISOControl(c))){
        } else { evt.consume(); }
        if ((this.txtPosY.getText().length() + 1) > 5) {
            evt.consume();}        // TODO add your handling code here:

    }//GEN-LAST:event_txtPosYKeyTyped

    private void txtAnchoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnchoKeyTyped
    char c = (char)evt.getKeyChar();
        if((c>='0' && c<='9') || (Character.isISOControl(c))){
        } else { evt.consume(); }
        if ((this.txtAncho.getText().length() + 1) > 5) {
            evt.consume();}        // TODO add your handling code here:

    }//GEN-LAST:event_txtAnchoKeyTyped

    private void txtLargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLargoKeyTyped
    char c = (char)evt.getKeyChar();
        if((c>='0' && c<='9') || (Character.isISOControl(c))){
        } else { evt.consume(); }
        if ((this.txtLargo.getText().length() + 1) > 5) {
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_txtLargoKeyTyped

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
    this.txtNombre.setText(txtNombre.getText().toUpperCase());        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreFocusLost

    /**
     * @param args the command line arguments
     */
    
        /* Create and display the form */
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox cbxActivo;
    private javax.swing.JComboBox cmbAlmacen;
    private javax.swing.JTable dgvFamilia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdd;
    private javax.swing.JLabel lblDelete;
    private javax.swing.JTextField txtAncho;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtIdentificador;
    private javax.swing.JTextField txtLargo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPosX;
    private javax.swing.JTextField txtPosY;
    // End of variables declaration//GEN-END:variables

    private void llenarComboAlmacen() {
        try {
            AlmacenBL almacenBL =new AlmacenBL();
           almacenes = almacenBL.getAllAlmacen();
        cmbAlmacen.addItem("Seleccione");
        for (AlmacenBE Almacen : almacenes){
            cmbAlmacen.addItem((Almacen.getIdentificador()));
        }
} catch (Exception ex) {
            Logger.getLogger(MantenimientoZona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the familias
     */
    public ArrayList<FamiliaBE> getFamilias() {
        return familias;
    }

    /**
     * @param familias the familias to set
     */
    public void setFamilias(ArrayList<FamiliaBE> familias) {
        this.familias = familias;
    }

    public void recargar(ArrayList<FamiliaBE> familias) {
        
        
        DefaultTableModel modelo=(DefaultTableModel) dgvFamilia.getModel();

        for(int i=modelo.getRowCount()-1; i>=0; i--){
            modelo.removeRow(i);
        }

        dgvFamilia.clearSelection();


            for(int i=0;i<familias.size();i++){
                modelo.addRow(new Object[2]);
                dgvFamilia.setValueAt(familias.get(i).getIdFamilia(),i,0 );
                dgvFamilia.setValueAt(familias.get(i).getNombre(),i,1 );

            }
    }
}
