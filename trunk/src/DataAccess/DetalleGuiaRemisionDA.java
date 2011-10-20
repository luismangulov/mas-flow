/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BD.conexion;
import BusinessEntity.DetalleGuiaRemisionBE;

/**
 *
 * @author DIEGO
 */
public class DetalleGuiaRemisionDA {
    public boolean insertar(DetalleGuiaRemisionBE objDetalleGuiaRemision,String codGuiaRemision) throws Exception{
        
        boolean boolExito = false;
        conexion objConexion = new conexion();
       
        String sql = "INSERT INTO guiaremision(iddetalleguiaremision,idguiaremision,cantidad,subtotal,idproducto,indactivo) VALUES('"+ objDetalleGuiaRemision.getCodigo() +"','"+ codGuiaRemision +"','"+ objDetalleGuiaRemision.getCantidad() +"','"+ objDetalleGuiaRemision.getSubtotal() +"','"+ objDetalleGuiaRemision.getProducto().getCodigo() +"','"+ objDetalleGuiaRemision.getEstado() +"')";
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        
        return boolExito;
    }
}
