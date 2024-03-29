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

import BusinessEntity.AplicacionBE;
import BusinessEntity.AplicacionxServicioBE;
import BusinessEntity.PerfilBE;
import BusinessEntity.PerfilDetalleBE;
import BusinessEntity.ServicioBE;
import BusinessLogic.PerfilBL;

import DataAccess.AplicacionDA;
import DataAccess.AplicacionxServicioDA;
import DataAccess.PerfilDA;
import DataAccess.PerfilDetalleDA;
import DataAccess.ServicioDA;
import Util.Utilitario;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    private PerfilDetalleDA objPerfilDetalleDA= new PerfilDetalleDA();
    private AplicacionDA objAplicacionDA=new AplicacionDA();
    private ServicioDA objServicioDA=new ServicioDA();
    private PerfilDetalleBE perfilDetalle = new PerfilDetalleBE();
    private String accion;

    private AbstractListModel modeloAplicacion;
    private AbstractListModel modeloAplicacionSelected;
    private AbstractListModel modeloServicio;
    private AbstractListModel modeloServicioSelected;

    
    AplicacionxServicioDA objAplicacionxServicio =new AplicacionxServicioDA();
    //Lista de aplicaciones de todo el sistema
    private ArrayList <String> listaAplicacionesSistema=objAplicacionxServicio.queryAllNombreAplicaciones();
    //Lista de aplicaciones del perfil (argumento del constructor)
    private ArrayList<String> listaAplicacionesPerfil=new ArrayList<String>();
    //Lista de aplicaciones seleccionadas
    private ArrayList<String> listaAplicacionesSelected=new ArrayList<String>();

    //Lista de servicios de una aplicacion del sistema
    private ArrayList<String> listaServiciosSistema=new ArrayList<String>();
    //Lista de servicios de la Aplicacion del perfil(argumento del constructor)
    private ArrayList<String>listaServiciosPerfil=new ArrayList<String>();
    //Lista de servicios de una aplicacion del perfil(argumento del constructor)
    private ArrayList<String>listaServiciosSelected=new ArrayList<String>();


    public MantenimientoPerfil() {  }

   
    public MantenimientoPerfil(AdmPerfil padre){

        this.objPadre = padre;
        accion = "registrar";     


       modeloAplicacion= new AbstractListModel() {
            ArrayList <String> listaLocal=listaAplicacionesSistema;
            public int getSize() {
                return listaLocal.size();

            }
            public Object getElementAt(int index) {
                return listaLocal.get(index);
            }

        };
        modeloAplicacionSelected= new AbstractListModel() {
            ArrayList <String> listaLocal=listaAplicacionesSelected;
            public int getSize() {
                return listaLocal.size();

            }
            public Object getElementAt(int index) {
                return listaLocal.get(index);
            }

        };
        
        initComponents();
        jListAplicacion.setModel(modeloAplicacion);
        jListAplicacionSelected.setModel(modeloAplicacionSelected);

//        this.jListServicio.setEnabled(false);
//        this.jListServicioSelected.setEnabled(false);
        
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
        

        //lista de aplicaciones por perfil      
        listaAplicacionesPerfil= objPerfilDetalleDA.queryAllAplicacionesPorPerfil(perfil.getIdPerfil());
        
        //Elimina de la listaAplicacionesSistema las aplicaciones que ya tiene el perfil
        ArrayList <Integer>listaIndexMarcados=new ArrayList<Integer>();
        for(int i=0;i<listaAplicacionesSistema.size();i++)
        {
            for(int j=0;j<listaAplicacionesPerfil.size();j++)
            {
                if (listaAplicacionesSistema.get(i).equals(listaAplicacionesPerfil.get(j))){
                    listaIndexMarcados.add(i);
                    break;
                }

            }
        }
        boolean primer=true;
        for(int i=0; i<listaIndexMarcados.size();i++){
            int ind=listaIndexMarcados.get(i);
//            if (primer)
//            {
//                primer=false;
//            }else
//            {
//                ind--;
//            }
            listaAplicacionesSistema.remove(0);
        }


        modeloAplicacion= new AbstractListModel() {
            ArrayList<String> listaLocal=listaAplicacionesSistema;
            public int getSize() {
                return listaLocal.size();                
            }
            public Object getElementAt(int index) {
                return listaLocal.get(index);
            }            
        };

        modeloAplicacionSelected= new AbstractListModel() {
            ArrayList <String> listaLocal=listaAplicacionesPerfil;
            public int getSize() {
                return listaLocal.size();

            }
            public Object getElementAt(int index) {
                return listaLocal.get(index);
            }

        };
        
        initComponents();        
        this.jListAplicacion.setModel(modeloAplicacion);
        this.jListAplicacionSelected.setModel(modeloAplicacionSelected);
        
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


 //       this.jListServicio.setEnabled(false);
 //       this.jListServicioSelected.setEnabled(false);
        this.btnAgregarTodo.setEnabled(false);
 

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
        jScrollPane2 = new javax.swing.JScrollPane();
        jListAplicacion = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListAplicacionSelected = new javax.swing.JList();
        btnAgregarTodo = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Registrar perfil");
        setResizable(false);
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

        jLabel2.setText("Nombre * :");

        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

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

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aplicaciones no asociadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 14))); // NOI18N

        jListAplicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAplicacionMouseClicked(evt);
            }
        });
        jListAplicacion.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jListAplicacionComponentAdded(evt);
            }
        });
        jScrollPane2.setViewportView(jListAplicacion);

        jLabel3.setText("Aplicacion");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aplicaciones asociadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 14))); // NOI18N

        jListAplicacionSelected.setModel(modeloAplicacionSelected);
        jListAplicacionSelected.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAplicacionSelectedMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListAplicacionSelected);

        btnAgregarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/folder_accept.png"))); // NOI18N
        btnAgregarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTodoActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/next.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back.png"))); // NOI18N
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAdd)
                                .addComponent(btnRemover))
                            .addComponent(btnAgregarTodo))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbxActivo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxActivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(btnRemover)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarTodo)
                .addGap(176, 176, 176))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
// TODO add your handling code here:
    
    if ((txtDescripcion.getText().length())==0) {
            JOptionPane.showMessageDialog(null, "Falta indicar nombre de perfil.", "Error", 0);
            return;
    }

    PerfilBL objPerfilBL = new PerfilBL();
    AplicacionBE objAplicacionBE=new AplicacionBE();

    String estado;
    if(this.cbxActivo.isSelected()){
        estado = "1";
    }else estado = "0";


    try {

        if(this.accion.equals("registrar")){

                objPerfilBL.insertar(this.txtDescripcion.getText(),estado);
                perfil=objPerfilBL.getPerfil();
                int cont=1;
                for(int i=0;i<listaAplicacionesSelected.size();i++){
                    perfilDetalle.setPerfil(perfil);
                    objAplicacionBE=objAplicacionDA.queryByNombreAplicacion(listaAplicacionesSelected.get(i));
                    perfilDetalle.setAplicacion(objAplicacionBE);
                    //Agregar todos los servicios que tiene la aplicacion en el sistema
                    ArrayList <ServicioBE> listaServicios=objAplicacionxServicio.queryServiciosByAplicacion(objAplicacionBE.getIdAplicacion());
                    for(int j=0;j<listaServicios.size();j++)
                    {   
                        perfilDetalle.setIndDetalle(String.valueOf(cont));
                        cont++;
                        perfilDetalle.setServicio(listaServicios.get(j));
                        //inserta el detalle en la tabla perfil detalle
                        objPerfilDetalleDA.insertar(perfilDetalle);

                    }

                }

                perfil = objPerfilBL.getPerfil();
                this.objPadre.recargaruno(perfil);
                this.dispose();
        }

        if(this.accion.equals("modificar")){
                perfil.setDescripcion(this.txtDescripcion.getText().trim());
                perfil.setIndActivo(estado);
                objPerfilBL.modificar(perfil);
                //Elimina todo el detalle de la tabla detalle perfil para determinado perfil
                objPerfilDetalleDA.eliminarDetallePerfil(perfil.getIdPerfil());
                int cont=1;
                for(int i=0;i<listaAplicacionesPerfil.size();i++){
                    perfilDetalle.setPerfil(perfil);
                    objAplicacionBE=objAplicacionDA.queryByNombreAplicacion(listaAplicacionesPerfil.get(i));
                    perfilDetalle.setAplicacion(objAplicacionBE);
                    //Agregar todos los servicios que tiene la aplicacion en el sistema
                    ArrayList <ServicioBE> listaServicios=objAplicacionxServicio.queryServiciosByAplicacion(objAplicacionBE.getIdAplicacion());
                    for(int j=0;j<listaServicios.size();j++)
                    {   
                        perfilDetalle.setIndDetalle(String.valueOf(cont));
                        cont++;
                        perfilDetalle.setServicio(listaServicios.get(j));
                        //inserta el detalle en la tabla perfil detalle
                        objPerfilDetalleDA.insertar(perfilDetalle);

                    }

                }

                this.objPadre.recargaruno(perfil);
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
}//GEN-LAST:event_jListAplicacionMouseClicked

private void jListAplicacionComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jListAplicacionComponentAdded
    // TODO add your handling code here:

}//GEN-LAST:event_jListAplicacionComponentAdded

private void jListAplicacionSelectedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListAplicacionSelectedMouseClicked
    // TODO add your handling code here:

//    int indexSelected = jListAplicacionSelected.getSelectedIndex();//obtengo posicion en la lista
//
//    if (indexSelected>-1){
//
//        String nombreAplicacion=listaAplicacionesSelected.get(indexSelected);
//
//        if(accion.equals("registrar")){
//
//            listaServiciosSistema=objAplicacionxServicio.queryNombreServiciosByNombreAplicacion(nombreAplicacion);
//            modeloServicio= new AbstractListModel() {
//                ArrayList<String> listaLocal=listaServiciosSistema;
//                public int getSize() {
//                    return listaLocal.size();
//                }
//                public Object getElementAt(int index) {
//                    return listaLocal.get(index);
//                }
//            };
//            jListServicio.setModel(modeloServicio);
//
//        }else //modificar
//        {
//            String idAplicacion = objAplicacionDA.queryByNombreAplicacion(nombreAplicacion).getIdAplicacion();
//            listaServiciosPerfil=objPerfilDetalleDA.queryAllServiciosPorAplicacionPorPerfil(perfil.getIdPerfil(),idAplicacion);
//            modeloServicio= new AbstractListModel() {
//                ArrayList<String> listaLocal=listaServiciosPerfil;
//                public int getSize() {
//                    return listaLocal.size();
//                }
//                public Object getElementAt(int index) {
//                    return listaLocal.get(index);
//                }
//            };
//            jListServicio.setModel(modeloServicio);
//        }
//    }

}//GEN-LAST:event_jListAplicacionSelectedMouseClicked

private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
    // TODO add your handling code here:
        char c = (char)evt.getKeyChar();
        if (!Utilitario.validarCadenaAlfabetica(evt.getKeyChar()) || (Character.isISOControl(c)))
            evt.consume();
       if ((this.txtDescripcion.getText().length() + 1) > 30) {
            evt.consume();
        }
}//GEN-LAST:event_txtDescripcionKeyTyped

private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
    // TODO add your handling code here:
            // TODO add your handling code here:
    int itemSelected=this.jListAplicacion.getSelectedIndex();
    if(itemSelected>-1){

        if (accion.equals("registrar")){

            this.listaAplicacionesSelected.add(this.listaAplicacionesSistema.get(itemSelected));
            this.listaAplicacionesSistema.remove(itemSelected);

            modeloAplicacion= new AbstractListModel() {
                ArrayList <String> listaLocal=listaAplicacionesSistema;
                public int getSize() {
                    return listaLocal.size();

                }
                public Object getElementAt(int index) {
                    return listaLocal.get(index);
                }

            };
            this.jListAplicacion.setModel(modeloAplicacion);

            modeloAplicacionSelected= new AbstractListModel() {
                ArrayList <String> listaLocal=listaAplicacionesSelected;
                public int getSize() {
                    return listaLocal.size();
                }
                public Object getElementAt(int index) {
                    return listaLocal.get(index);
                }

            };
            this.jListAplicacionSelected.setModel(modeloAplicacionSelected);

        }else{//modificar

            if (this.listaAplicacionesSistema.size()>0){//Valida que listaAplicacionesPerfil tenga elementos para hacer un get
                this.listaAplicacionesPerfil.add(this.listaAplicacionesSistema.get(itemSelected));
                this.listaAplicacionesSistema.remove(itemSelected);
            }

            modeloAplicacion= new AbstractListModel() {
                ArrayList <String> listaLocal=listaAplicacionesSistema;
                public int getSize() {
                    return listaLocal.size();

                }
                public Object getElementAt(int index) {
                    return listaLocal.get(index);
                }

            };
            this.jListAplicacion.setModel(modeloAplicacion);

            modeloAplicacionSelected= new AbstractListModel() {
                ArrayList <String> listaLocal=listaAplicacionesPerfil;
                public int getSize() {
                    return listaLocal.size();
                }
                public Object getElementAt(int index) {
                    return listaLocal.get(index);
                }

            };
            this.jListAplicacionSelected.setModel(modeloAplicacionSelected);
        }

    }

}//GEN-LAST:event_btnAddActionPerformed

private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
    // TODO add your handling code here:
        int itemSelected=this.jListAplicacionSelected.getSelectedIndex();

    if(itemSelected>-1){

        if(accion.equals("registrar")){

            this.listaAplicacionesSistema.add(this.listaAplicacionesSelected.get(itemSelected));
            this.listaAplicacionesSelected.remove(itemSelected);
            modeloAplicacion= new AbstractListModel() {
                ArrayList <String> listaLocal=listaAplicacionesSistema;
                public int getSize() {
                    return listaLocal.size();

                }
                public Object getElementAt(int index) {
                    return listaLocal.get(index);
                }

            };

            this.jListAplicacion.setModel(modeloAplicacion);

            modeloAplicacionSelected= new AbstractListModel() {
                ArrayList <String> listaLocal=listaAplicacionesSelected;
                public int getSize() {
                    return listaLocal.size();

                }
                public Object getElementAt(int index) {
                    return listaLocal.get(index);
                }

            };
            this.jListAplicacionSelected.setModel(modeloAplicacionSelected);

        }else{//modificar

            if(this.listaAplicacionesPerfil.size()>0){ //verifica q la listaAplicacionesSistema tenga elementos para hacer un get

                this.listaAplicacionesSistema.add(this.listaAplicacionesPerfil.get(itemSelected));
                this.listaAplicacionesPerfil.remove(itemSelected);

            }


            modeloAplicacion= new AbstractListModel() {
                ArrayList <String> listaLocal=listaAplicacionesSistema;
                public int getSize() {
                    return listaLocal.size();

                }
                public Object getElementAt(int index) {
                    return listaLocal.get(index);
                }

            };
            this.jListAplicacion.setModel(modeloAplicacion);

            modeloAplicacionSelected= new AbstractListModel() {
                ArrayList <String> listaLocal=listaAplicacionesPerfil;
                public int getSize() {
                    return listaLocal.size();
                }
                public Object getElementAt(int index) {
                    return listaLocal.get(index);
                }

            };
            this.jListAplicacionSelected.setModel(modeloAplicacionSelected);
        }
    }
}//GEN-LAST:event_btnRemoverActionPerformed

private void btnAgregarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTodoActionPerformed
    // TODO add your handling code here:
        PerfilBL objPerfilBL = new PerfilBL();
    AplicacionBE objAplicacionBE=new AplicacionBE();

    int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea seleccionar todas las aplicaciones.", "Agregar todo", 0);
    if(respuesta == 0){

    try {

        if(this.accion.equals("registrar")){

            this.listaAplicacionesSelected=listaAplicacionesSistema;
            modeloAplicacionSelected= new AbstractListModel() {
                ArrayList <String> listaLocal=listaAplicacionesSelected;
                public int getSize() {
                    return listaLocal.size();
                }
                public Object getElementAt(int index) {
                    return listaLocal.get(index);
                }

            };
            this.jListAplicacionSelected.setModel(modeloAplicacionSelected);


            this.listaAplicacionesSistema=new ArrayList<String>();
            modeloAplicacion= new AbstractListModel() {
                ArrayList <String> listaLocal=listaAplicacionesSistema;
                public int getSize() {
                    return listaLocal.size();

                }
                public Object getElementAt(int index) {
                    return listaLocal.get(index);
                }

            };
            this.jListAplicacion.setModel(modeloAplicacion);
        }

        this.btnAdd.setEnabled(false);
        this.btnRemover.setEnabled(false);
        this.btnAgregarTodo.setEnabled(false);


//        if(this.accion.equals("modificar")){
//                perfil.setDescripcion(this.txtDescripcion.getText().trim());
//                perfil.setIndActivo(estado);
//                objPerfilBL.modificar(perfil);
//                //Elimina todo el detalle de la tabla detalle perfil para determinado perfil
//                objPerfilDetalleDA.eliminarDetallePerfil(perfil.getIdPerfil());
//                int cont=1;
//                for(int i=0;i<listaAplicacionesPerfil.size();i++){
//                    perfilDetalle.setPerfil(perfil);
//                    objAplicacionBE=objAplicacionDA.queryByNombreAplicacion(listaAplicacionesPerfil.get(i));
//                    perfilDetalle.setAplicacion(objAplicacionBE);
//                    //Agregar todos los servicios que tiene la aplicacion en el sistema
//                    ArrayList <ServicioBE> listaServicios=objAplicacionxServicio.queryServiciosByAplicacion(objAplicacionBE.getIdAplicacion());
//                    for(int j=0;j<listaServicios.size();j++)
//                    {
//                        perfilDetalle.setIndDetalle(String.valueOf(cont));
//                        cont++;
//                        perfilDetalle.setServicio(listaServicios.get(j));
//                        //inserta el detalle en la tabla perfil detalle
//                        objPerfilDetalleDA.insertar(perfilDetalle);
//
//                    }
//
//                }
//
//                this.objPadre.recargaruno(perfil);
//                this.dispose();
//
//         }


    } catch (Exception ex) {

        Logger.getLogger(MantenimientoPerfil.class.getName()).log(Level.SEVERE, null, ex);

    }

    }
}//GEN-LAST:event_btnAgregarTodoActionPerformed

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
            java.util.logging.Logger.getLogger(MantenimientoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MantenimientoPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAgregarTodo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JCheckBox cbxActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jListAplicacion;
    private javax.swing.JList jListAplicacionSelected;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables



 

}
