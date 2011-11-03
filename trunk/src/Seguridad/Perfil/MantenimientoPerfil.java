/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MantenimientoPerfil.java
 *
 * Created on Oct 2, 2011, 3:55:38 PM
 */
package Seguridad.Perfil;

import BusinessEntity.AplicacionxServicioBE;
import BusinessEntity.PerfilBE;
import BusinessEntity.PerfilDetalleBE;
import BusinessEntity.ServicioBE;
import BusinessLogic.PerfilBL;

import DataAccess.AplicacionDA;
import DataAccess.AplicacionxServicioDA;
import DataAccess.PerfilDA;
import DataAccess.PerfilDetalleDA;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.JScrollPane;


/**
 *
 * @author DIEGO
 */
public class MantenimientoPerfil extends javax.swing.JFrame {

    /** Creates new form MantenimientoPerfil */
    private AdmPerfil objPadre;
    private PerfilBE perfil;// Este perfil tiene una lista de detalles
    private String accion;
    private JTree tree=new JTree();
    private javax.swing.JCheckBox jCheckBoxAplicacion;
    private javax.swing.JCheckBox jCheckBoxServicio;
    private AbstractListModel modeloAplicacion;
    private AbstractListModel modeloServicio;
    private boolean primero;
    
    AplicacionxServicioDA objAplicacionxServicio =new AplicacionxServicioDA();
    //listaAplicacionxServicio obttiene la lista de aplicaciones del sistema con su listas de servicios
    ArrayList <AplicacionxServicioBE> listaAplicacionxServicio = objAplicacionxServicio.queryAllAplicacionxServicio();  
    //solo para el Jtree
    ArrayList <AplicacionxServicioBE> lista = objAplicacionxServicio.queryAllAplicacionxServicio();  

    //numAplicaciones tiene todos las aplicaciones del sistema
    AplicacionDA objAplicacionDA =new AplicacionDA();
    int numAplicaciones= objAplicacionDA.queryAllAplicacion().size();
    
    private String[] listaAplicaciones=new String[numAplicaciones];//de todo el sistema
    private String[] listaServicio;
    //Object[] rootNodes =new Vector[numAplicaciones];
    
    
    public MantenimientoPerfil(AdmPerfil padre){
        this.objPadre = padre;
        accion = "registrar";
        primero=true;
        
        int cont=0;           
        for (cont = 0; cont<numAplicaciones; cont++) {            
                String aplicacion = listaAplicacionxServicio.get(cont).getAplicacion().getDescripcion();
                listaAplicaciones[cont]= aplicacion;       
            
        };        
       modeloAplicacion= new AbstractListModel() {        
            String[] listaLocal=listaAplicaciones;
            public int getSize() {
                return listaLocal.length;
                
            }
            public Object getElementAt(int index) {
                return listaLocal[index];
            }
            
        };
       
        
        
//        for(int i = 0; i < numAplicaciones; i++) {
//            int numServicios=lista.get(i).getListaServicios().size();
//            CheckBoxNode[] checkBoxNodeVector =new CheckBoxNode[numServicios];
//            for(int j = 0; j < numServicios; j++) {
//            checkBoxNodeVector[j]=new CheckBoxNode(lista.get(i).getListaServicios().get(j).getIdDescripcion(),false);
//            }
//            Vector vectorAplicacion = new NamedVector(lista.get(i).getAplicacion().getDescripcion(),checkBoxNodeVector);
//            rootNodes[i]=vectorAplicacion;   
//        }
//        
//        Vector rootVector = new NamedVector("Root", rootNodes);
//        tree = new JTree(rootVector);  
//        CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();
//        tree.setCellRenderer(renderer);
//        tree.setCellEditor(new CheckBoxNodeEditor(tree));
//        tree.setEditable(true);   
        
        initComponents();
        jListAplicacion.setModel(modeloAplicacion);
        
        this.setLocationRelativeTo(null); 
        this.setTitle("+Flow - Registrar perfil");
        this.cbxActivo.setSelected(true);
        this.txtCodigo.setEnabled(false);
        this.setVisible(true);
    }

     public MantenimientoPerfil(AdmPerfil padre,PerfilBE perfilBE) {
        this.objPadre = padre;
        accion = "modificar";
        this.perfil =perfilBE;
        int cont=0; 
        
       PerfilDetalleDA objPerfilDetalleDA= new PerfilDetalleDA();
        //lista de aplicaciones por perfil
      
       final ArrayList<String> listaAplicacionesPorPerfil= objPerfilDetalleDA.queryAllAplicacionesPorPerfil(perfil.getIdPerfil());
       
       modeloAplicacion= new AbstractListModel() {        
            ArrayList<String> listaLocal=listaAplicacionesPorPerfil;
            public int getSize() {
                return listaLocal.size();
                
            }
            public Object getElementAt(int index) {
                return listaLocal.get(index);
            }
            
        };
        
       ///
//        for(int i = 0; i < numAplicaciones; i++) {
//            int numServicios=lista.get(i).getListaServicios().size();
//            CheckBoxNode[] servicios =new CheckBoxNode[numServicios];
//            for(int j = 0; j < numServicios; j++) {
//            servicios[j]=new CheckBoxNode(lista.get(i).getListaServicios().get(j).getIdDescripcion(),false);
//            }
//            Vector aplicaciones = new NamedVector(lista.get(i).getAplicacion().getDescripcion(),servicios);
//            rootNodes[i]=aplicaciones;   
//        }
//        
//        ///
//        Vector rootVector = new NamedVector("Root", rootNodes);
//        tree = new JTree(rootVector);  
//        CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();
//        tree.setCellRenderer(renderer);
//        tree.setCellEditor(new CheckBoxNodeEditor(tree));
//        tree.setEditable(true); 
//          
        
        
        initComponents();        
        this.jListAplicacion.setModel(modeloAplicacion);
        
        
             
//    ///        
       
        
        this.setLocationRelativeTo(null);
        this.cbxActivo.setEnabled(true);
        this.setTitle("+Flow - Editar perfil");
        this.txtCodigo.setEnabled(false);
        this.txtCodigo.setText(perfil.getIdPerfil());
        this.txtDescripcion.setText(perfil.getDescripcion());
        String idIndPerfil=perfil.getIndActivo().trim();
        if (idIndPerfil.equals("1"))
        {
            this.cbxActivo.setSelected(true);
         
        }else{
            this.cbxActivo.setSelected(false);
        }
        this.setVisible(true);
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
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbxActivo = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListAplicacion = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListServicio = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblAddAplicacion = new javax.swing.JLabel();
        lblRemoverAplicacion = new javax.swing.JLabel();
        lblAddServicio = new javax.swing.JLabel();
        lblRemoverServicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Registrar perfil");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Código:");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cbxActivo.setText("Activo");
        cbxActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxActivoActionPerformed(evt);
            }
        });

        jListAplicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAplicacionMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListAplicacion);

        jScrollPane3.setViewportView(jListServicio);

        jLabel3.setText("Aplicacion");

        jLabel4.setText("Servicio");

        lblAddAplicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add24.png"))); // NOI18N
        lblAddAplicacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAddAplicacion.setName(""); // NOI18N
        lblAddAplicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAddAplicacionMousePressed(evt);
            }
        });

        lblRemoverAplicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete24.png"))); // NOI18N
        lblRemoverAplicacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRemoverAplicacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblRemoverAplicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRemoverAplicacionMousePressed(evt);
            }
        });

        lblAddServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add24.png"))); // NOI18N
        lblAddServicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAddServicio.setName(""); // NOI18N
        lblAddServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAddServicioMousePressed(evt);
            }
        });

        lblRemoverServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete24.png"))); // NOI18N
        lblRemoverServicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRemoverServicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblRemoverServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRemoverServicioMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cbxActivo))))
                .addContainerGap(545, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddAplicacion)
                    .addComponent(lblRemoverAplicacion))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddServicio)
                            .addComponent(lblRemoverServicio))))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(cbxActivo)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .addComponent(lblAddAplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(lblRemoverAplicacion)
                .addGap(164, 164, 164))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addComponent(lblAddServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(lblRemoverServicio)
                .addGap(166, 166, 166))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
// TODO add your handling code here:
        PerfilBL objPerfilBL = new PerfilBL();
       
        try {
                 if(this.accion.equals("registrar")){
                    String estado;
                    if(this.cbxActivo.isSelected()){
                        estado = "1";
                    }else estado = "0";       
                    objPerfilBL.insertar(this.txtDescripcion.getText(),estado);
                    PerfilBE perfil;
                    perfil = objPerfilBL.getPerfil();
                    this.objPadre.recargaruno(perfil);
                    this.dispose();
                 }
                 
                 if(this.accion.equals("modificar")){
                     PerfilBE perfil = null;
                     String estado;
                    if(this.cbxActivo.isSelected()){
                        estado = "1";
                    }else estado = "0";   
                     perfil = objPerfilBL.setPerfil(this.txtCodigo.getText(),this.txtDescripcion.getText(),estado);
                     //familia = new FamiliaBE(this.txtCodigo.getText(), this.txtNombre.getText(), this.txtDescripcion.getText(),"1");
//                     objPerfilBL.modificar(perfil);
                     int fila;
                     fila = this.objPadre.getDgvPerfil().getSelectedRow();
                     this.objPadre.getDgvPerfil().removeRowSelectionInterval(fila, fila);
                     this.objPadre.getDgvPerfil().setValueAt(perfil.getIdPerfil(), fila, 0);
                     this.objPadre.getDgvPerfil().setValueAt(perfil.getDescripcion(), fila, 1);
                   
                     if(perfil.getIndActivo().equals("1")){
                          this.objPadre.getDgvPerfil().setValueAt("Activo", fila, 2);
                      }else if(perfil.getIndActivo().equals("0")){
                         this.objPadre.getDgvPerfil().setValueAt("Inactivo", fila, 2);
                      }
                     this.dispose();
                 }
            } catch (Exception ex) {
                Logger.getLogger(MantenimientoPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
    

}//GEN-LAST:event_btnGuardarActionPerformed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
// TODO add your handling code here:
      this.dispose();
}//GEN-LAST:event_btnCancelarActionPerformed

private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtCodigoActionPerformed

private void cbxActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxActivoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_cbxActivoActionPerformed

private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
// TODO add your handling code here:
    
  
}//GEN-LAST:event_formWindowActivated

private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
// TODO add your handling code here:
    


}//GEN-LAST:event_formWindowGainedFocus

private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
// TODO add your handling code here:
}//GEN-LAST:event_formComponentShown

private void jListAplicacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListAplicacionMouseClicked
// TODO add your handling code here:

    int indexSeleccionado = jListAplicacion.getSelectedIndex();//obtengo posicion en la lista
    
    if(accion.equals("registrar")){ //Cuando es registrar
        
        if (primero==true){ 
            
            primero=false;
            ArrayList <ServicioBE> listaServicios  =new ArrayList<ServicioBE>();
            listaServicios=listaAplicacionxServicio.get(indexSeleccionado).getListaServicios();          

            int cont=0;          
            final String[] listaLocalServicio=  new String [listaAplicacionxServicio.get(indexSeleccionado).getListaServicios().size()];

            for (cont = 0; cont<listaServicios.size(); cont++) {
                 String servicio = listaServicios.get(cont).getIdDescripcion();
                 listaLocalServicio[cont]=servicio;           
            };
            modeloServicio= new AbstractListModel() {            
                    String[] listaLocal=listaLocalServicio;
                    public int getSize() {
                        return listaLocal.length;
                    }
                    public Object getElementAt(int index) {
                        return listaLocal[index];
                    }
            };
            jListServicio.setModel(modeloServicio);
        }
    }else{// cuando es modificar
        
        PerfilDetalleDA objPerfilDetalleDA=new PerfilDetalleDA();
        indexSeleccionado++;
        String idAplicacion=String.valueOf(indexSeleccionado);
        final ArrayList<String> listaLocalServicio=objPerfilDetalleDA.queryAllServiciosPorAplicacionPorPerfil(perfil.getIdPerfil(),idAplicacion);
        modeloServicio= new AbstractListModel() {            
                    ArrayList<String> listaLocal=listaLocalServicio;
                    public int getSize() {
                        return listaLocal.size();
                    }
                    public Object getElementAt(int index) {
                        return listaLocal.get(index);
                    }
        };
        
        jListServicio.setModel(modeloServicio);
        
    }
    
            
            
            
}//GEN-LAST:event_jListAplicacionMouseClicked

private void lblAddAplicacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddAplicacionMousePressed
        // TODO add your handling code here:

        
        
}//GEN-LAST:event_lblAddAplicacionMousePressed

private void lblRemoverAplicacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoverAplicacionMousePressed
        // TODO add your handling code here:

    
}//GEN-LAST:event_lblRemoverAplicacionMousePressed

private void lblAddServicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddServicioMousePressed
// TODO add your handling code here:
}//GEN-LAST:event_lblAddServicioMousePressed

private void lblRemoverServicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoverServicioMousePressed
// TODO add your handling code here:
}//GEN-LAST:event_lblRemoverServicioMousePressed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MantenimientoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new MantenimientoPerfil().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox cbxActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jListAplicacion;
    private javax.swing.JList jListServicio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAddAplicacion;
    private javax.swing.JLabel lblAddServicio;
    private javax.swing.JLabel lblRemoverAplicacion;
    private javax.swing.JLabel lblRemoverServicio;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables



 

}
