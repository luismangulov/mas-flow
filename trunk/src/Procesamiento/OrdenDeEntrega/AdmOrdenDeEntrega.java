/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdmNotaDeIngreso.java
 *
 * Created on Oct 2, 2011, 3:44:28 PM
 */
package Procesamiento.OrdenDeEntrega;

import Algoritmos.Mapa.GUIMapa;
import Algoritmos.Mapa.Mapa;
import Algoritmos.Mapa.Nodo;
import Algoritmos.MejorUbicacion.AlgoritmoBestFirst;
import Algoritmos.RecorridoOptimo.AlgoritmoGenetico;
import BusinessEntity.AlmacenBE;
import BusinessEntity.DetalleNotaIngresoBE;
import BusinessEntity.EstadoGRBE;
import BusinessEntity.EstadoNIBE;
import BusinessEntity.MovimientoInternoBE;
import BusinessEntity.NotaIngresoBE;
import BusinessEntity.PalletBE;
import BusinessEntity.ProductoBE;
import BusinessEntity.UbicacionBE;
import BusinessEntity.UsuarioBE;
import BusinessEntity.UsuarioSistema;
import BusinessLogic.AlmacenBL;
import BusinessLogic.DetalleNotaIngresoBL;
import BusinessLogic.MovimientoInternoBL;
import BusinessLogic.NotaIngresoBL;
import BusinessLogic.PalletBL;
import BusinessLogic.ProductoBL;
import BusinessLogic.UbicacionBL;
import DataAccess.EstadoGRDA;
import DataAccess.EstadoNIDA;
import Procesamiento.MovimientosInternos.ReubicarPallet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class AdmOrdenDeEntrega extends javax.swing.JFrame {
     ArrayList<PalletBE> arrPallet = new ArrayList<PalletBE>();
     UbicacionBE objUbicacionBE = new UbicacionBE();
      ArrayList<UbicacionBE> arrUbicaciones = new ArrayList<UbicacionBE>();
    /** Creates new form AdmNotaDeIngreso */
    public AdmOrdenDeEntrega() {
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
        tblNotaIngreso = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        lblAgregar = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        lblRefrescar = new javax.swing.JLabel();
        lblDetalle = new javax.swing.JLabel();
        lblAprobar = new javax.swing.JLabel();
        lblIngresar = new javax.swing.JLabel();
        lblRuta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Administrar orden de entrega");

        tblNotaIngreso.setAutoCreateRowSorter(true);
        tblNotaIngreso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Almacen", "Código", "Proveedor", "Direccion", "Fecha", "Estado"
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
        jScrollPane1.setViewportView(tblNotaIngreso);
        tblNotaIngreso.getColumnModel().getColumn(4).setPreferredWidth(20);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        lblAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_page.png"))); // NOI18N
        lblAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAgregarMousePressed(evt);
            }
        });
        jToolBar1.add(lblAgregar);

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_page.png"))); // NOI18N
        lblBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBuscarMousePressed(evt);
            }
        });
        jToolBar1.add(lblBuscar);

        lblRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh.png"))); // NOI18N
        lblRefrescar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRefrescar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRefrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRefrescarMousePressed(evt);
            }
        });
        jToolBar1.add(lblRefrescar);

        lblDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/detalle2.png"))); // NOI18N
        lblDetalle.setToolTipText("VisualizarDetalle");
        lblDetalle.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblDetalle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDetalle.setMaximumSize(new java.awt.Dimension(54, 54));
        lblDetalle.setPreferredSize(new java.awt.Dimension(54, 54));
        lblDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblDetalleMousePressed(evt);
            }
        });
        jToolBar1.add(lblDetalle);

        lblAprobar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check.png"))); // NOI18N
        lblAprobar.setToolTipText("Aprobar");
        lblAprobar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAprobar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAprobar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAprobarMousePressed(evt);
            }
        });
        jToolBar1.add(lblAprobar);

        lblIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/50px-Vista-forward.png"))); // NOI18N
        lblIngresar.setText("jLabel1");
        lblIngresar.setToolTipText("Ingresar");
        lblIngresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIngresar.setMaximumSize(new java.awt.Dimension(54, 54));
        lblIngresar.setPreferredSize(new java.awt.Dimension(54, 54));
        lblIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblIngresarMousePressed(evt);
            }
        });
        jToolBar1.add(lblIngresar);

        lblRuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/System Map.png"))); // NOI18N
        lblRuta.setText("jLabel1");
        lblRuta.setToolTipText("Mostrar Ruta");
        lblRuta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRuta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRuta.setMaximumSize(new java.awt.Dimension(54, 54));
        lblRuta.setPreferredSize(new java.awt.Dimension(54, 54));
        lblRuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRutaMousePressed(evt);
            }
        });
        jToolBar1.add(lblRuta);

        jLabel1.setToolTipText("Mostrar Pallets");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setMaximumSize(new java.awt.Dimension(54, 54));
        jLabel1.setPreferredSize(new java.awt.Dimension(54, 54));
        jToolBar1.add(jLabel1);

        jLabel7.setText("                                                                                                                                  ");
        jLabel7.setMaximumSize(new java.awt.Dimension(500, 14));
        jLabel7.setPreferredSize(new java.awt.Dimension(500, 14));
        jToolBar1.add(jLabel7);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info.png"))); // NOI18N
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jToolBar1.add(jLabel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void lblAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMousePressed
    MantenimientoOrdenDeEntrega m = new MantenimientoOrdenDeEntrega(this);
    m.setVisible(true);
// TODO add your handling code here:
}//GEN-LAST:event_lblAgregarMousePressed

private void lblBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMousePressed
// TODO add your handling code here:
    BuscarOrdenDeEntrega m = new BuscarOrdenDeEntrega(this);
    m.setVisible(true);
}//GEN-LAST:event_lblBuscarMousePressed

    private void lblRefrescarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefrescarMousePressed
        // TODO add your handling code here:
        NotaIngresoBL objNotaIngresoBL = new NotaIngresoBL();
        this.recargar(objNotaIngresoBL.queryAllNotaIngreso());
    }//GEN-LAST:event_lblRefrescarMousePressed

    private void lblDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDetalleMousePressed
        // TODO add your handling code here:
         if((tblNotaIngreso.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado una orden de entrega", "Mensaje",0);
        } else if((tblNotaIngreso.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado mas de una orden de entrega", "Mensaje",0);
        }else{
            int fila;
            String codigo;
            fila = tblNotaIngreso.getSelectedRow();
            codigo = (String)tblNotaIngreso.getValueAt(fila, 1);
                    
           DetalleOrdenDeEntrega m = new DetalleOrdenDeEntrega(this, codigo);
           m.setVisible(true);
        }    
    }//GEN-LAST:event_lblDetalleMousePressed

    private void lblAprobarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAprobarMousePressed
        // TODO add your handling code here:
        int fila1 = 0;
         if((tblNotaIngreso.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado una orden de entrega", "Mensaje",0);
        } else if((tblNotaIngreso.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado mas de una orden de entrega", "Mensaje",0);
        }else{
          fila1 = tblNotaIngreso.getSelectedRow();
          String  estado = tblNotaIngreso.getValueAt(fila1, 5).toString().trim();  
         if(estado.equals("Aprobado")){
            JOptionPane.showMessageDialog(null, "La orden de entrega ya ha sido aprobada", "Mensaje",0);
          }else if(estado.equals("Ingresado")){
            JOptionPane.showMessageDialog(null, "La orden de entrega ya ha sido aprobada", "Mensaje",0);   
         }else{
            int fila;
            String codigo;
            String identificador;
            String idAlmacen;
            fila = tblNotaIngreso.getSelectedRow();
            codigo = (String)tblNotaIngreso.getValueAt(fila, 1);
            
            
            identificador = (String)tblNotaIngreso.getValueAt(fila, 0);
            AlmacenBL objAlmacenBL = new AlmacenBL();
            ArrayList<AlmacenBE> arrAlmacenes = new ArrayList<AlmacenBE>(); 
            arrAlmacenes = objAlmacenBL.buscar("", "", "1", "", "", "", identificador);
            
            idAlmacen = arrAlmacenes.get(0).getIdAlmacen();
            
            NotaIngresoBL objNotaIngreso = new NotaIngresoBL(); 
            NotaIngresoBE objNotaIngresoBE = objNotaIngreso.queryByIdNotaIngreso(codigo);
            
            DetalleNotaIngresoBL objDetalleNotaIngresoBL = new DetalleNotaIngresoBL();        
            ArrayList<DetalleNotaIngresoBE> arrDetalleNotaIngresoBE = new ArrayList<DetalleNotaIngresoBE>();
            arrDetalleNotaIngresoBE = objDetalleNotaIngresoBL.queryAllDetalleNotaIngreso(codigo);
            
            ArrayList<String> arrCodFamilia = new ArrayList<String>();
             ArrayList<Integer> arrCantUbicaciones = new ArrayList<Integer>();
            for(int i=0;i<arrDetalleNotaIngresoBE.size();i++){
                ProductoBL objProductoBL = new ProductoBL();
                ProductoBE objProductoBE = objProductoBL.getByIdProducto(arrDetalleNotaIngresoBE.get(i).getProducto().getIdProducto());
                arrCodFamilia.add(objProductoBE.getIdFamilia());
                arrCantUbicaciones.add(arrDetalleNotaIngresoBE.get(i).getCantidad()/objProductoBE.getMaxCantPorPallet());
            }
            boolean libres = true;
            for(int i=0;i<arrCodFamilia.size();i++){
                int cantUbicacion = 0;
                for(int j=0;j<arrCodFamilia.size();j++){
                    if(arrCodFamilia.get(j).equals(arrCodFamilia.get(i))){
                        cantUbicacion += arrCantUbicaciones.get(j);
                    }
                }
                UbicacionBL objUbicacionBL = new UbicacionBL();
               int ubicaLibres = objUbicacionBL.queryCantUbicacionesLibres(arrCodFamilia.get(i), idAlmacen);
                //JOptionPane.showMessageDialog(null, idAlmacen, "Mensaje",1);
                //JOptionPane.showMessageDialog(null, cantUbicacion, "Mensaje",1); 
                //JOptionPane.showMessageDialog(null, ubicaLibres, "Mensaje",1);
                if(cantUbicacion> ubicaLibres){
                    libres = false;
                    break;
                }
            }
            if(libres == false){
                EstadoNIDA objEstadoNIDA = new EstadoNIDA();
                EstadoNIBE objEstadoNIBE = new EstadoNIBE();
                objEstadoNIBE = objEstadoNIDA.queryByDescripcionEstadoNI("Pendiente");
                NotaIngresoBL objNotaIngresoBL = new NotaIngresoBL();
                try {
                    objNotaIngresoBL.cambiarEstado(codigo, objEstadoNIBE.getCodigo());
                    tblNotaIngreso.setValueAt( objEstadoNIBE.getDescripcion(),fila,5 );
                    
                } catch (Exception ex) {
                    Logger.getLogger(AdmOrdenDeEntrega.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            }else{
                EstadoNIDA objEstadoNIDA = new EstadoNIDA();
                EstadoNIBE objEstadoNIBE = new EstadoNIBE();
                objEstadoNIBE = objEstadoNIDA.queryByDescripcionEstadoNI("Aprobado");
                NotaIngresoBL objNotaIngresoBL = new NotaIngresoBL();
                try {
                   objNotaIngresoBL.cambiarEstado(codigo, objEstadoNIBE.getCodigo());
                    tblNotaIngreso.setValueAt( objEstadoNIBE.getDescripcion(),fila,5 );
                    
                     for(int i=0;i<arrDetalleNotaIngresoBE.size();i++){
                        ProductoBL objProductoBL = new ProductoBL();
                        ProductoBE objProductoBE = objProductoBL.getByIdProducto(arrDetalleNotaIngresoBE.get(i).getProducto().getIdProducto());

                        int cantidadPallet = arrDetalleNotaIngresoBE.get(i).getCantidad()/objProductoBE.getMaxCantPorPallet();
                      
                        for(int j=0;j<cantidadPallet;j++){
                            
                            PalletBE objPalletBE = new PalletBE("",objProductoBE.getIdProducto(),"1","",idAlmacen, arrDetalleNotaIngresoBE.get(i).getFechaVencimiento(),codigo,null);
                            
                            arrPallet.add(objPalletBE);
                        }
                                               
                     }
                    
                    
                    
                    
               
                //Mapa mapa = new Mapa(arrAlmacenes.get(0));
                
            for(int i =0;i<arrPallet.size();i++){
                Mapa mapa = new Mapa(arrAlmacenes.get(0));
                arrUbicaciones.add(AlgoritmoBestFirst.ejecutar(mapa, arrPallet.get(i)));
                //JOptionPane.showMessageDialog(null, arrUbicaciones.get(i).getIdUbicacion(), "Mensaje",0);
                arrPallet.get(i).setIdUbicacion(arrUbicaciones.get(i).getIdUbicacion());
                PalletBL objPalletBL = new PalletBL();
                objPalletBL.insertar(arrPallet.get(i));
                UbicacionBL objUbicacionBL = new UbicacionBL();
                objUbicacionBL.ocuparUbicacion(arrUbicaciones.get(i).getIdUbicacion());
            }
            
            for(int i =0;i<arrUbicaciones.size();i++){
                UbicacionBL objUbicacionBL = new UbicacionBL();
                objUbicacionBL.desocuparUbicacion(arrUbicaciones.get(i).getIdUbicacion());
            }

            Mapa mapa = new Mapa(arrAlmacenes.get(0));
            mapa.mostrarGraficoMapa(arrUbicaciones);
            
            //ArrayList<Nodo> listaNodo = AlgoritmoGenetico.ejecutar(mapa, arrUbicaciones);
            //mapa.mostrarGraficoMapa(listaNodo, true);

           //ArrayList<UbicacionBE> arrUbicacion = new ArrayList<UbicacionBE>();
           
            
            
            
            
            
            //for(int u = 0;u<arrPallet.size();u++){
             int respuesta = 0;
            respuesta = JOptionPane.showConfirmDialog(null, "Desea realizar la asignación de ubiciones en forma manual?", "Asignar ubicación a pallets", 0); 
            if (respuesta == 0) {    
               ReubicarPallet r = new ReubicarPallet(this,false,arrPallet,idAlmacen);
              r.setVisible(true);
            }     
              //  arrUbicacion.add(this.objUbicacionBE);
           // }

//                 PalletBL objPalletBL = new PalletBL();
//            
//            ArrayList<PalletBE> arrPallets = objPalletBL.getPalletByIdNotaIngreso(codigo);
//             ArrayList<UbicacionBE> arrUbicacion = new ArrayList<UbicacionBE>();
//             for(int i = 0;i<arrPallets.size();i++){
//                 UbicacionBL objUbicacionBL = new UbicacionBL();
//                 UbicacionBE objUbicacion = new UbicacionBE();
//                 objUbicacion = objUbicacionBL.getUbicacionById(arrPallets.get(i).getIdUbicacion());
//                 arrUbicacion.add(objUbicacion);
//             }
//                
//                
//              for(int i =0;i<arrUbicacion.size();i++){
//                UbicacionBL objUbicacionBL = new UbicacionBL();
//                objUbicacionBL.ocuparUbicacion(arrUbicacion.get(i).getIdUbicacion());
//                
//                 MovimientoInternoBL objMovimientoInternoBL = new MovimientoInternoBL();
//                MovimientoInternoBE objMovimientoInternoBE = new MovimientoInternoBE("",null,arrUbicacion.get(i).getIdUbicacion(),objNotaIngresoBE.getFecha(),"Ingresado",arrPallet.get(i).getIdPallet(),idAlmacen,"admin");
//                
//                objMovimientoInternoBL.insertar(objMovimientoInternoBE);
//            }
              
              
              
            
                } catch (Exception ex) {
                    Logger.getLogger(AdmOrdenDeEntrega.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
            
        }
        }  
    }//GEN-LAST:event_lblAprobarMousePressed

    private void lblIngresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIngresarMousePressed
        // TODO add your handling code here:
         int fila1 = 0;
         if((tblNotaIngreso.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado una orden de entrega", "Mensaje",0);
         } else if((tblNotaIngreso.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado mas de una orden de entrega", "Mensaje",0);
         }else{
          fila1 = tblNotaIngreso.getSelectedRow();
          String  estado = tblNotaIngreso.getValueAt(fila1, 5).toString().trim();  
         if(estado.equals("Registrado")){
            JOptionPane.showMessageDialog(null, "La orden de entrega debe ser aprobada", "Mensaje",0);
         }else if(estado.equals("Pendiente")){
            JOptionPane.showMessageDialog(null, "La orden de entrega debe ser aprobada", "Mensaje",0);   
         }else if(estado.equals("Ingresado")){
            JOptionPane.showMessageDialog(null, "La orden de entrega ya ha sido ingresada", "Mensaje",0);
         }else{
              int fila;
            String codigo;
            String identificador;
            String idAlmacen;
            fila = tblNotaIngreso.getSelectedRow();
            codigo = (String)tblNotaIngreso.getValueAt(fila, 1);
            
             identificador = (String)tblNotaIngreso.getValueAt(fila, 0);
            AlmacenBL objAlmacenBL = new AlmacenBL();
            ArrayList<AlmacenBE> arrAlmacenes = new ArrayList<AlmacenBE>(); 
            arrAlmacenes = objAlmacenBL.buscar("", "", "1", "", "", "", identificador);
            
            idAlmacen = arrAlmacenes.get(0).getIdAlmacen();
  
            NotaIngresoBL objNotaIngreso = new NotaIngresoBL(); 
             NotaIngresoBE objNotaIngresoBE = objNotaIngreso.queryByIdNotaIngreso(codigo);
       //cambiar estado a ingresado     
            
            EstadoNIDA objEstadoNIDA = new EstadoNIDA();
            EstadoNIBE objEstadoNIBE = new EstadoNIBE();
            objEstadoNIBE = objEstadoNIDA.queryByDescripcionEstadoNI("Ingresado");
            NotaIngresoBL objNotaIngresoBL = new NotaIngresoBL();
           
            try {
                objNotaIngresoBL.cambiarEstado(codigo, objEstadoNIBE.getCodigo());
            } catch (Exception ex) {
                Logger.getLogger(AdmOrdenDeEntrega.class.getName()).log(Level.SEVERE, null, ex);
            }
                tblNotaIngreso.setValueAt( objEstadoNIBE.getDescripcion(),fila,5 );
                
                
            PalletBL objPalletBL = new PalletBL();
            
            ArrayList<PalletBE> arrPallets = objPalletBL.getPalletByIdNotaIngreso(codigo);
             ArrayList<UbicacionBE> arrUbicacion = new ArrayList<UbicacionBE>();
             for(int i = 0;i<arrPallets.size();i++){
                 UbicacionBL objUbicacionBL = new UbicacionBL();
                 UbicacionBE objUbicacion = new UbicacionBE();
                 objUbicacion = objUbicacionBL.getUbicacionById(arrPallets.get(i).getIdUbicacion());
                 arrUbicacion.add(objUbicacion);
             }
             
            UsuarioBE objUsuarioBE = UsuarioSistema.usuario;
             
             //cambia ubicaciones a ocupado
            for(int i =0;i<arrUbicacion.size();i++){
                UbicacionBL objUbicacionBL = new UbicacionBL();
                objUbicacionBL.ocuparUbicacion(arrUbicacion.get(i).getIdUbicacion());
                
                 MovimientoInternoBL objMovimientoInternoBL = new MovimientoInternoBL();
                MovimientoInternoBE objMovimientoInternoBE = new MovimientoInternoBE("",null,arrUbicacion.get(i).getIdUbicacion(),objNotaIngresoBE.getFecha(),"Ingresado",arrPallets.get(i).getIdPallet(),idAlmacen,objUsuarioBE.getIdUsuario());
                
                objMovimientoInternoBL.insertar(objMovimientoInternoBE);
            }
            
              //Mapa mapa = new Mapa(arrAlmacenes.get(0));
            
            
            //ArrayList<Nodo> listaNodo = AlgoritmoGenetico.ejecutar(mapa, arrUbicacion);
            //mapa.mostrarGraficoMapa(listaNodo, true);
         }
         }
    }//GEN-LAST:event_lblIngresarMousePressed

    private void lblRutaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRutaMousePressed
        // TODO add your handling code here:
         int fila1 = 0;
         if((tblNotaIngreso.getSelectedRowCount() == 0)){
           JOptionPane.showMessageDialog(null, "No ha seleccionado una orden de entrega", "Mensaje",0);
         } else if((tblNotaIngreso.getSelectedRowCount() > 1)){
            JOptionPane.showMessageDialog(null, "Ha seleccionado mas de una orden de entrega", "Mensaje",0);
         }else{
          fila1 = tblNotaIngreso.getSelectedRow();
          String  estado = tblNotaIngreso.getValueAt(fila1, 5).toString().trim();  
         if(estado.equals("Registrado")){
            JOptionPane.showMessageDialog(null, "La orden de entrega debe ser aprobada", "Mensaje",0);
            
         }else if(estado.equals("Pendiente")){
            JOptionPane.showMessageDialog(null, "La orden de entrega debe ser aprobada", "Mensaje",0);   
         }else{
              int fila;
            String codigo;
            String identificador;
            String idAlmacen;
            fila = tblNotaIngreso.getSelectedRow();
            codigo = (String)tblNotaIngreso.getValueAt(fila, 1);
            
             identificador = (String)tblNotaIngreso.getValueAt(fila, 0);
            AlmacenBL objAlmacenBL = new AlmacenBL();
            ArrayList<AlmacenBE> arrAlmacenes = new ArrayList<AlmacenBE>(); 
            arrAlmacenes = objAlmacenBL.buscar("", "", "1", "", "", "", identificador);
            
            idAlmacen = arrAlmacenes.get(0).getIdAlmacen();
  
          
       //cambiar estado a ingresado     
            
                         
            PalletBL objPalletBL = new PalletBL();
            
            ArrayList<PalletBE> arrPallets = objPalletBL.getPalletByIdNotaIngreso(codigo);
             ArrayList<UbicacionBE> arrUbicacion = new ArrayList<UbicacionBE>();
             for(int i = 0;i<arrPallets.size();i++){
                 UbicacionBL objUbicacionBL = new UbicacionBL();
                 UbicacionBE objUbicacion = new UbicacionBE();
                 objUbicacion = objUbicacionBL.getUbicacionById(arrPallets.get(i).getIdUbicacion());
                 arrUbicacion.add(objUbicacion);
             }
             
                         
              Mapa mapa = new Mapa(arrAlmacenes.get(0));
            
            
            ArrayList<Nodo> listaNodo = AlgoritmoGenetico.ejecutar(mapa, arrUbicacion);
            mapa.mostrarGraficoMapa(listaNodo, true);
         }
         }
    }//GEN-LAST:event_lblRutaMousePressed
        
   

    
    
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
            java.util.logging.Logger.getLogger(AdmOrdenDeEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmOrdenDeEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmOrdenDeEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmOrdenDeEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AdmOrdenDeEntrega().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblAprobar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblDetalle;
    private javax.swing.JLabel lblIngresar;
    private javax.swing.JLabel lblRefrescar;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JTable tblNotaIngreso;
    // End of variables declaration//GEN-END:variables

public void recargaruno(NotaIngresoBE notaIngreso,String razonSocial,String direccion,String identificador){
    ////
         
        DefaultTableModel modelo= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;  
            }
        };
        tblNotaIngreso.setModel(modelo);
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
          tblNotaIngreso.setValueAt(identificador,0,0 ); 
         tblNotaIngreso.setValueAt(notaIngreso.getCodigo(),0,1 );
         tblNotaIngreso.setValueAt(razonSocial,0,2 );
         tblNotaIngreso.setValueAt(direccion,0,3 );
         
         tblNotaIngreso.setValueAt(notaIngreso.getFecha(),0,4 );
         tblNotaIngreso.setValueAt(notaIngreso.getEstado().getDescripcion(),0,5 );
    }

    public void recargar(ArrayList<NotaIngresoBE> notasIngreso){
    ////
         
        DefaultTableModel modelo= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;  
            }
        };
         tblNotaIngreso.setModel(modelo);
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
        
        for(int i = 0;i<notasIngreso.size();i++){
            modelo.addRow(new Object[5]);
             tblNotaIngreso.setValueAt(notasIngreso.get(i).getAlmacen().getIdentificador(),i,0 );
             tblNotaIngreso.setValueAt(notasIngreso.get(i).getCodigo(),i,1 );
             tblNotaIngreso.setValueAt(notasIngreso.get(i).getProveedor().getRazonSocial(),i,2 );
             tblNotaIngreso.setValueAt(notasIngreso.get(i).getProveedor().getDireccion(),i,3 );
             
             tblNotaIngreso.setValueAt(notasIngreso.get(i).getFecha(),i,4 );
             tblNotaIngreso.setValueAt(notasIngreso.get(i).getEstado().getDescripcion(),i,5 );
        }
        
    }

}
