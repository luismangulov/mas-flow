/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.DetalleNotaIngresoBE;
import Util.conexion;

/**
 *
 * @author DIEGO
 */
public class DetalleNotaIngresoDA {
    public boolean insertar(DetalleNotaIngresoBE objDetalleNotaIngreso,String codNotaIngreso) throws Exception{
        
        boolean boolExito = false;
        conexion objConexion = new conexion();
       
        String sql = "INSERT INTO detallenotaingreso(iddetallenotaingreso,idnotaingreso,cantidad,idproducto) VALUES('"+ objDetalleNotaIngreso.getCodigo() +"','"+ codNotaIngreso +"','"+ objDetalleNotaIngreso.getCantidad() +"','"+ objDetalleNotaIngreso.getProducto().getIdProducto() +"')";
        
        
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
