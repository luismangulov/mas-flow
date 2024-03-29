/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdmGuiaDeRemision.java
 *
 * Created on Oct 2, 2011, 3:48:47 PM
 */
package Procesamiento.GuiaDeRemision;

import Algoritmos.Mapa.Mapa;
import Algoritmos.Mapa.Nodo;
import Algoritmos.MejorUbicacion.AlgoritmoBestFirst;
import Algoritmos.RecorridoOptimo.AlgoritmoGenetico;
import BusinessEntity.AlmacenBE;
import BusinessEntity.DetalleGuiaRemisionBE;
import BusinessEntity.EstadoGRBE;
import BusinessEntity.GuiaRemisionBE;
import BusinessEntity.MovimientoInternoBE;
import BusinessEntity.PalletBE;
import BusinessEntity.ProductoBE;
import BusinessEntity.UbicacionBE;
import BusinessEntity.UsuarioBE;
import BusinessEntity.UsuarioSistema;
import BusinessLogic.AlmacenBL;
import BusinessLogic.DetalleGuiaRemisionBL;
import BusinessLogic.GuiaRemisionBL;
import BusinessLogic.MovimientoInternoBL;
import BusinessLogic.PalletBL;
import BusinessLogic.ProductoBL;
import BusinessLogic.UbicacionBL;
import DataAccess.EstadoGRDA;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import Util.conexion;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author DIEGO
 */
public class AdmGuiaDeRemision extends javax.swing.JFrame {

    
    ArrayList<PalletBE> arrPallet = new ArrayList<PalletBE>();
     ArrayList<ProductoBE> arrProducto = new ArrayList<ProductoBE>();
      ArrayList<UbicacionBE> arrUbicaciones = new ArrayList<UbicacionBE>();
    
    /** Creates new form AdmGuiaDeRemision */
    public AdmGuiaDeRemision() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblGuiaRemision = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        lblAgregar = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        lblRefrescar = new javax.swing.JLabel();
        lblDetalle = new javax.swing.JLabel();
        lblAprobar = new javax.swing.JLabel();
        lblRuta = new javax.swing.JLabel();
        lblImprimir = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Administrar orden de salida");

        tblGuiaRemision.setAutoCreateRowSorter(true);
        tblGuiaRemision.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Almacen", "Código", "Cliente", "Dirección", "Fecha", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblGuiaRemision);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        lblAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_page.png"))); // NOI18N
        lblAgregar.setToolTipText("Agregar");
        lblAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAgregarMousePressed(evt);
            }
        });
        jToolBar1.add(lblAgregar);

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_page.png"))); // NOI18N
        lblBuscar.setToolTipText("Buscar");
        lblBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBuscarMousePressed(evt);
            }
        });
        jToolBar1.add(lblBuscar);

        lblRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh.png"))); // NOI18N
        lblRefrescar.setToolTipText("Refrescar");
        lblRefrescar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRefrescar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRefrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRefrescarMousePressed(evt);
            }
        });
        jToolBar1.add(lblRefrescar);

        lblDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/folder_full.png"))); // NOI18N
        lblDetalle.setToolTipText("VisualizarDetalle");
        lblDetalle.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblDetalle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblDetalleMousePressed(evt);
            }
        });
        jToolBar1.add(lblDetalle);

        lblAprobar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/accept_page.png"))); // NOI18N
        lblAprobar.setToolTipText("Verificar Stock de Productos");
        lblAprobar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAprobar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAprobar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAprobarMousePressed(evt);
            }
        });
        jToolBar1.add(lblAprobar);

        lblRuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/System Map.png"))); // NOI18N
        lblRuta.setToolTipText("Mostrar Ruta de Salida");
        lblRuta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRuta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRutaMousePressed(evt);
            }
        });
        jToolBar1.add(lblRuta);

        lblImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/imprimir.png"))); // NOI18N
        lblImprimir.setText("jLabel1");
        lblImprimir.setToolTipText("Imprimir");
        lblImprimir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblImprimir.setMaximumSize(new java.awt.Dimension(54, 54));
        lblImprimir.setMinimumSize(new java.awt.Dimension(54, 54));
        lblImprimir.setPreferredSize(new java.awt.Dimension(54, 54));
        lblImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblImprimirMousePressed(evt);
            }
        });
        jToolBar1.add(lblImprimir);

        jLabel7.setText("                                                                                                                                  ");
        jLabel7.setMaximumSize(new java.awt.Dimension(520, 14));
        jLabel7.setPreferredSize(new java.awt.Dimension(500, 14));
        jToolBar1.add(jLabel7);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info.png"))); // NOI18N
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToolBar1.add(jLabel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void lblAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMousePressed
MantenimientoGuiaDeRemision m = new MantenimientoGuiaDeRemision(this);
m.setVisible(true);
// TODO add your handling code here:
}//GEN-LAST:event_lblAgregarMousePressed

private void lblBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMousePressed
// TODO add your handling code here:
    BuscarGuiaDeRemision m = new BuscarGuiaDeRemision(this);
    m.setVisible(true);
}//GEN-LAST:event_lblBuscarMousePressed

    private void lblRefrescarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefrescarMousePressed
        // TODO add your handling code here:
        GuiaRemisionBL objGuiaRemisionBL = new GuiaRemisionBL();
        this.recargar(objGuiaRemisionBL.queryAllGuiaRemision());
    }//GEN-LAST:event_lblRefrescarMousePressed

    private void lblDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDetalleMousePressed
        // TODO add your handling code here:
        if((tblGuiaRemision.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado una guia de remision", "Mensaje",0);
        } else if((tblGuiaRemision.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado mas de una guia de remision", "Mensaje",0);
        }else{
            int fila;
            String codigo;
            fila = tblGuiaRemision.getSelectedRow();
            codigo = (String)tblGuiaRemision.getValueAt(fila, 1);
                    
           DetalleGuiaDeRemision m = new DetalleGuiaDeRemision(this, codigo);
           m.setVisible(true);
        }    
    }//GEN-LAST:event_lblDetalleMousePressed

    private void lblAprobarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAprobarMousePressed
        // TODO add your handling code here:
        int fila1 = 0;
        if((tblGuiaRemision.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado una guia de remision", "Mensaje",0);
        } else if((tblGuiaRemision.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado mas de una guia de remision", "Mensaje",0);
        }else{
            fila1 = tblGuiaRemision.getSelectedRow();
          String  estado = tblGuiaRemision.getValueAt(fila1, 5).toString().trim();  
         if(estado.equals("Aprobado")){
            JOptionPane.showMessageDialog(null, "La guia de remision ya ha sido aprobada", "Mensaje",0);
         }else{
            int fila;
            String codigo;
            String identificador;
            String idAlmacen;
            fila = tblGuiaRemision.getSelectedRow();
            codigo = (String)tblGuiaRemision.getValueAt(fila, 1);
            
             GuiaRemisionBL objGuiaRemision = new GuiaRemisionBL(); 
             GuiaRemisionBE objGuiaRemisionBE = objGuiaRemision.queryByIdGuiaRemision(codigo);
            
            identificador = (String)tblGuiaRemision.getValueAt(fila, 0);
            AlmacenBL objAlmacenBL = new AlmacenBL();
            ArrayList<AlmacenBE> arrAlmacenes = new ArrayList<AlmacenBE>(); 
            arrAlmacenes = objAlmacenBL.buscar("", "", "1", "", "", "", identificador);
            
            idAlmacen = arrAlmacenes.get(0).getIdAlmacen();
            
            DetalleGuiaRemisionBL objDetalleGuiaRemisionBL = new DetalleGuiaRemisionBL();
            ArrayList<DetalleGuiaRemisionBE> arrDetalleGuiaRemisionBE = new ArrayList<DetalleGuiaRemisionBE>();
            arrDetalleGuiaRemisionBE = objDetalleGuiaRemisionBL.queryAllDetalleGuiaRemision(codigo);
            
            ArrayList<String> arrCodFamilia = new ArrayList<String>();
             ArrayList<Integer> arrCantUbicaciones = new ArrayList<Integer>();
           boolean ocupados = true;
             for(int i=0;i<arrDetalleGuiaRemisionBE .size();i++){
                ProductoBL objProductoBL = new ProductoBL();
                ProductoBE objProductoBE = objProductoBL.getByIdProducto(arrDetalleGuiaRemisionBE .get(i).getProducto().getIdProducto());
                UbicacionBL objUbicacionBL = new UbicacionBL();
                int ubicaOcupadas = objUbicacionBL.queryCantUbicacionesOcupadas(objProductoBE.getIdFamilia(), idAlmacen, objProductoBE.getIdProducto());
                int cantUbicaRequeridas = arrDetalleGuiaRemisionBE.get(i).getCantidad()/objProductoBE.getMaxCantPorPallet();
                //JOptionPane.showMessageDialog(null,  ubicaOcupadas, "Mensaje",1); 
                //JOptionPane.showMessageDialog(null, cantUbicaRequeridas, "Mensaje",1);
               if(cantUbicaRequeridas>ubicaOcupadas){
                   ocupados = false;
                   break;
               }
                   
            }
            
             if(ocupados == false){
                   EstadoGRDA objEstadoGRDA = new EstadoGRDA();
                   EstadoGRBE objEstadoGRBE = new EstadoGRBE();
                   objEstadoGRBE = objEstadoGRDA.queryByDescripcionEstadoGR("Pendiente");
                   GuiaRemisionBL objGuiaRemisionBL = new GuiaRemisionBL();
                    try {
                        objGuiaRemisionBL.cambiarEstado(codigo, objEstadoGRBE.getCodigo());
                        tblGuiaRemision.setValueAt( objEstadoGRBE.getDescripcion(),fila,5 );
                    } catch (Exception ex) {
                        Logger.getLogger(AdmGuiaDeRemision.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                   
               }else{
                   EstadoGRDA objEstadoGRDA = new EstadoGRDA();
                   EstadoGRBE objEstadoGRBE = new EstadoGRBE();
                   objEstadoGRBE = objEstadoGRDA.queryByDescripcionEstadoGR("Aprobado");
                   GuiaRemisionBL objGuiaRemisionBL = new GuiaRemisionBL();
                    try {
                        objGuiaRemisionBL.cambiarEstado(codigo, objEstadoGRBE.getCodigo());
                         tblGuiaRemision.setValueAt( objEstadoGRBE.getDescripcion(),fila,5 );
                         
                     for(int i=0;i<arrDetalleGuiaRemisionBE.size();i++){
                        ProductoBL objProductoBL = new ProductoBL();
                        ProductoBE objProductoBE = objProductoBL.getByIdProducto(arrDetalleGuiaRemisionBE.get(i).getProducto().getIdProducto());

                        int cantidadPallet = arrDetalleGuiaRemisionBE.get(i).getCantidad()/objProductoBE.getMaxCantPorPallet();
                      
                        for(int j=0;j<cantidadPallet;j++){
                            this.arrProducto.add(objProductoBE);
                            //PalletBE objPalletBE = new PalletBE("",objProductoBE.getIdProducto(),"1","",idAlmacen, null,"");
                            
                            //arrPallet.add(objPalletBE);
                        }
                     }
                     arrPallet = new ArrayList<PalletBE>();
                        for(int u =0;u<arrProducto.size();u++){
                            Mapa mapa = new Mapa(arrAlmacenes.get(0));
                            arrPallet.add(AlgoritmoBestFirst.ejecutar(mapa, arrProducto.get(u)));
                            //JOptionPane.showMessageDialog(null, arrUbicaciones.get(i).getIdUbicacion(), "Mensaje",0);
                                                      
                            //UbicacionBL objUbicacionBL = new UbicacionBL();
                            //objUbicacionBL.ocuparUbicacion(arrUbicaciones.get(u).getIdUbicacion());
                             PalletBL objPalletBL = new PalletBL();
                            objPalletBL.despacharPallet(arrPallet.get(u).getIdPallet());
                        }
                         arrUbicaciones = new ArrayList<UbicacionBE>();   
                        for(int i =0;i< arrPallet.size();i++){
                            UbicacionBL objUbicacionBL = new UbicacionBL();
                            UbicacionBE objUbicacionBE = new UbicacionBE();
                            objUbicacionBE = objUbicacionBL.getUbicacionById(arrPallet.get(i).getIdUbicacion());
                            arrUbicaciones.add(objUbicacionBE);
                        }
                        
                        UsuarioBE objUsuarioBE = UsuarioSistema.usuario;
                        for(int i =0;i<arrUbicaciones.size();i++){
                             UbicacionBL objUbicacionBL = new UbicacionBL();
                              objUbicacionBL.desocuparUbicacion(arrUbicaciones.get(i).getIdUbicacion());
                               MovimientoInternoBL objMovimientoInternoBL = new MovimientoInternoBL();
                                MovimientoInternoBE objMovimientoInternoBE = new MovimientoInternoBE("",arrUbicaciones.get(i).getIdUbicacion(),null,null,"Despachado",arrPallet.get(i).getIdPallet(),idAlmacen,objUsuarioBE.getIdUsuario());
                
                                objMovimientoInternoBL.insertar(objMovimientoInternoBE);
                        }
                        
                        for(int i =0;i< arrPallet.size();i++){
                            PalletBL objPalletBL = new PalletBL();
                            objPalletBL.asociarGuiaRemision(arrPallet.get(i).getIdPallet(), objGuiaRemisionBE.getCodigo());
                        }
                        
//                        for(int i =0;i< arrPallet.size();i++){
//                            PalletBL objPalletBL = new PalletBL();
//                            objPalletBL.despacharPallet(arrPallet.get(i).getIdPallet());
//                        }
                        
                        //Mapa mapa = new Mapa(arrAlmacenes.get(0));
                        
                         //ArrayList<Nodo> listaNodo = AlgoritmoGenetico.ejecutar(mapa, arrUbicaciones);
                        // mapa.mostrarGraficoMapa(listaNodo, true);
                                               
                     
                         
                    } catch (Exception ex) {
                        Logger.getLogger(AdmGuiaDeRemision.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  
               }
             
            
        } 
        }  
    }//GEN-LAST:event_lblAprobarMousePressed

    private void lblRutaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRutaMousePressed
        // TODO add your handling code here:
         int fila1 = 0;
        if((tblGuiaRemision.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado una guia de remision", "Mensaje",0);
        } else if((tblGuiaRemision.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado mas de una guia de remision", "Mensaje",0);
        }else{
            fila1 = tblGuiaRemision.getSelectedRow();
          String  estado = tblGuiaRemision.getValueAt(fila1, 5).toString().trim();  
         if(!estado.equals("Aprobado")){
            JOptionPane.showMessageDialog(null, "La guia de remision debe ser aprobada", "Mensaje",0);
         }else{
              int fila;
            String codigo;
            String identificador;
            String idAlmacen;
            fila = tblGuiaRemision.getSelectedRow();
            codigo = (String)tblGuiaRemision.getValueAt(fila, 1);
            
             GuiaRemisionBL objGuiaRemision = new GuiaRemisionBL(); 
             GuiaRemisionBE objGuiaRemisionBE = objGuiaRemision.queryByIdGuiaRemision(codigo);
             
              identificador = (String)tblGuiaRemision.getValueAt(fila, 0);
            AlmacenBL objAlmacenBL = new AlmacenBL();
            ArrayList<AlmacenBE> arrAlmacenes = new ArrayList<AlmacenBE>(); 
            arrAlmacenes = objAlmacenBL.buscar("", "", "1", "", "", "", identificador);
            
            idAlmacen = arrAlmacenes.get(0).getIdAlmacen();
             PalletBL objPalletBL = new PalletBL(); 
            
              ArrayList<PalletBE> arrPallets = objPalletBL.getPalletByIdGuiaRemision(codigo);
             ArrayList<UbicacionBE> arrUbicacion = new ArrayList<UbicacionBE>();
             for(int i = 0;i<arrPallets.size();i++){
                 UbicacionBL objUbicacionBL = new UbicacionBL();
                 UbicacionBE objUbicacion = new UbicacionBE();
                 objUbicacion = objUbicacionBL.getUbicacionById(arrPallets.get(i).getIdUbicacion());
                 arrUbicacion.add(objUbicacion);
             }
             
              Mapa mapa = new Mapa(arrAlmacenes.get(0));
                        
              ArrayList<Nodo> listaNodo = AlgoritmoGenetico.ejecutar(mapa, arrUbicacion);
              mapa.mostrarGraficoMapa(arrUbicacion,listaNodo);
             
             
         }
        }
    }//GEN-LAST:event_lblRutaMousePressed

    private void lblImprimirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImprimirMousePressed
        // TODO add your handling code here:
         if((tblGuiaRemision.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado una guia de remision", "Mensaje",0);
        } else if((tblGuiaRemision.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado mas de una guia de remision", "Mensaje",0);
        }else{
            int fila;
            String codigo;
            fila = tblGuiaRemision.getSelectedRow();
            codigo = (String)tblGuiaRemision.getValueAt(fila, 1);
                    
          this.runReporte(codigo);
        }    
        
        
    }//GEN-LAST:event_lblImprimirMousePressed

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
            java.util.logging.Logger.getLogger(AdmGuiaDeRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmGuiaDeRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmGuiaDeRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmGuiaDeRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AdmGuiaDeRemision().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblAprobar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblDetalle;
    private javax.swing.JLabel lblImprimir;
    private javax.swing.JLabel lblRefrescar;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JTable tblGuiaRemision;
    // End of variables declaration//GEN-END:variables


    public void recargaruno(GuiaRemisionBE guiaRemision,String razonSocial,String direccion,String identificador){
    ////
         
        DefaultTableModel modelo= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;  
            }
        };
        tblGuiaRemision.setModel(modelo);
        modelo.addColumn("Almacen");
        modelo.addColumn("Código");
        modelo.addColumn("Cliente");
        modelo.addColumn("Dirección");
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");
//        tblGuiaRemision.getColumnModel().getColumn(0).setPreferredWidth(40);
//        tblGuiaRemision.getColumnModel().getColumn(1).setPreferredWidth(100);
//        tblGuiaRemision.getColumnModel().getColumn(2).setPreferredWidth(120);
//        tblGuiaRemision.getColumnModel().getColumn(3).setPreferredWidth(40);
         modelo.addRow(new Object[5]);
        tblGuiaRemision.setValueAt(identificador,0,0 ); 
        tblGuiaRemision.setValueAt(guiaRemision.getCodigo(),0,1 );
        tblGuiaRemision.setValueAt(razonSocial,0,2 );
        tblGuiaRemision.setValueAt(direccion,0,3 );
        //tblGuiaRemision.setValueAt(contacto,0,3 );
        tblGuiaRemision.setValueAt(guiaRemision.getFecha(),0,4 );
        tblGuiaRemision.setValueAt(guiaRemision.getEstado().getDescripcion(),0,5 );
    }

    public void recargar(ArrayList<GuiaRemisionBE> guiaRemisiones){
    ////
         
        DefaultTableModel modelo= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;  
            }
        };
        tblGuiaRemision.setModel(modelo);
        modelo.addColumn("Almacen");
        modelo.addColumn("Código");
        modelo.addColumn("Cliente");
        modelo.addColumn("Dirección");
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");
//        tblGuiaRemision.getColumnModel().getColumn(0).setPreferredWidth(40);
//        tblGuiaRemision.getColumnModel().getColumn(1).setPreferredWidth(100);
//        tblGuiaRemision.getColumnModel().getColumn(2).setPreferredWidth(120);
//        tblGuiaRemision.getColumnModel().getColumn(3).setPreferredWidth(40);
        
        for(int i = 0;i<guiaRemisiones.size();i++){
            modelo.addRow(new Object[5]);
             tblGuiaRemision.setValueAt(guiaRemisiones.get(i).getAlmacen().getIdentificador(),i,0 ); 
            tblGuiaRemision.setValueAt(guiaRemisiones.get(i).getCodigo(),i,1 );
            tblGuiaRemision.setValueAt(guiaRemisiones.get(i).getCliente().getRazonSocial(),i,2 );
            tblGuiaRemision.setValueAt(guiaRemisiones.get(i).getCliente().getDireccion(),i,3 );
            //tblGuiaRemision.setValueAt(guiaRemisiones.get(i).getCliente().getNombreContacto(),0,3 );
            tblGuiaRemision.setValueAt(guiaRemisiones.get(i).getFecha(),i,4 );
            tblGuiaRemision.setValueAt(guiaRemisiones.get(i).getEstado().getDescripcion(),i,5 );
        }
        
          
    
        
    }

    public void runReporte(String guia)
    {

            String master = System.getProperty("user.dir") +
                                "/src/Reportes/GuiaRemision.jasper";
           
            System.out.println(master);
            if (master == null)
            {               
                JOptionPane.showMessageDialog(null, "No se encontró el archivo de la Guía de Remisión.", "Mensaje",0);
                return;
            }

            JasperReport masterReport = null;
            try
            {
                masterReport = (JasperReport) JRLoader.loadObjectFromFile(master);//.loadObject(master);
            }
            catch (JRException e)
            {
                JOptionPane.showMessageDialog(null, "Error cargando la Guía de Remisión: " + e.getMessage(), "Mensaje",0);
                return;
            }             
           
            //este es el par�metro, se pueden agregar m�s par�metros
            //basta con poner mas parametro.put
            Map parametro = new HashMap();
            parametro.put("Guia",guia);
            parametro.put("empresa",Util.Configuracion.getEmpresa());
            //Reporte dise�ado y compilado con iReport
            try {
            conexion objConexion = new conexion();
            objConexion.SetearConexion();
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,objConexion.getCon());
            objConexion.SalirUID();
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("+Flow - Guía de Remisión");
            jviewer.setVisible(true);
        }

        catch (Exception j)
        {
            JOptionPane.showMessageDialog(null, "Mensaje de Error:"+j.getMessage(), "Mensaje",0);
        }

}
}
