/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DetalleNotaIngreso.java
 *
 * Created on Oct 29, 2011, 7:34:12 PM
 */
package Procesamiento.OrdenDeEntrega;

import BusinessEntity.DetalleNotaIngresoBE;
import BusinessLogic.DetalleNotaIngresoBL;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class DetalleOrdenDeEntrega extends javax.swing.JFrame {
    private AdmOrdenDeEntrega padre;
    private String codNotaIngreso;
    /** Creates new form DetalleNotaIngreso */
    public DetalleOrdenDeEntrega(AdmOrdenDeEntrega objPadre,String codigo) {
        this.padre = objPadre;
        this.codNotaIngreso = codigo;
        initComponents();
        this.setLocationRelativeTo(null); 
        DetalleNotaIngresoBL objDetalleNotaIngresoBL = new DetalleNotaIngresoBL();
        ArrayList<DetalleNotaIngresoBE> arrDetalleNotaIngresoBE = new ArrayList<DetalleNotaIngresoBE>();
        arrDetalleNotaIngresoBE = objDetalleNotaIngresoBL.queryAllDetalleNotaIngreso(codNotaIngreso);
        
        this.recargar(arrDetalleNotaIngresoBE);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("+Flow - Detalle orden de entrega");

        tblNotaIngreso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdOrdenEntrega", "IdDetalleOrdenEntrega", "Cantidad", "NombreProducto", "FechaVencimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Byte.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblNotaIngreso);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
//            java.util.logging.Logger.getLogger(DetalleNotaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DetalleNotaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DetalleNotaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DetalleNotaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new DetalleNotaIngreso().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNotaIngreso;
    // End of variables declaration//GEN-END:variables
    
   public final void recargar(ArrayList<DetalleNotaIngresoBE> detalleNotaIngreso){
    ////
         
        DefaultTableModel modelo= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;  
            }
        };
        tblNotaIngreso.setModel(modelo);
        modelo.addColumn("IdNotaIngreso");
        modelo.addColumn("IdDetalleNotaIngreso");
        modelo.addColumn("Cantidad");
        modelo.addColumn("NombreProducto");
        modelo.addColumn("FechaVencimiento");
        
//        tblGuiaRemision.getColumnModel().getColumn(0).setPreferredWidth(40);
//        tblGuiaRemision.getColumnModel().getColumn(1).setPreferredWidth(100);
//        tblGuiaRemision.getColumnModel().getColumn(2).setPreferredWidth(120);
//        tblGuiaRemision.getColumnModel().getColumn(3).setPreferredWidth(40);
        
        for(int i = 0;i<detalleNotaIngreso.size();i++){
            modelo.addRow(new Object[5]);
            tblNotaIngreso.setValueAt(this.codNotaIngreso,i,0 );
            tblNotaIngreso.setValueAt(detalleNotaIngreso.get(i).getCodigo(),i,1 );
            tblNotaIngreso.setValueAt(detalleNotaIngreso.get(i).getCantidad(),i,2 );
            
            tblNotaIngreso.setValueAt(detalleNotaIngreso.get(i).getProducto().getNombre(),i,3 );
             tblNotaIngreso.setValueAt(detalleNotaIngreso.get(i).getFechaVencimiento(),i,4 );
            
        }
        
    }


}
