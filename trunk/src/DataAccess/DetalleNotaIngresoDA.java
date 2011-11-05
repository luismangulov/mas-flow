/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.DetalleNotaIngresoBE;
import BusinessEntity.NotaIngresoBE;
import BusinessEntity.ProductoBE;
import Util.conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DIEGO
 */
public class DetalleNotaIngresoDA {
    public boolean insertar(DetalleNotaIngresoBE objDetalleNotaIngreso,String codNotaIngreso) throws Exception{
        
        boolean boolExito = false;
        conexion objConexion = new conexion();
       
        String sql = "INSERT INTO detallenotaingreso(iddetallenotaingreso,idnotaingreso,cantidad,idproducto,fechavencimiento) VALUES('"+ objDetalleNotaIngreso.getCodigo() +"','"+ codNotaIngreso +"','"+ objDetalleNotaIngreso.getCantidad() +"','"+ objDetalleNotaIngreso.getProducto().getIdProducto() +"','"+ objDetalleNotaIngreso.getFechaVencimiento() +"')";
        
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        
        return boolExito;
    }
    
     public ArrayList<DetalleNotaIngresoBE> queryAllDetalleNotaIngreso(String codNotaIngreso){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<DetalleNotaIngresoBE> arrDetalleNotaIngreso = new ArrayList<DetalleNotaIngresoBE>();
        String sql = "SELECT g.idnotaingreso,g.iddetallenotaingreso,g.cantidad,g.fechavencimiento,p.idproducto,p.nombre FROM detallenotaingreso g, producto p";
                 sql += " WHERE g.idnotaingreso='"+codNotaIngreso+"'";
                 sql += " AND p.idproducto = g.idproducto order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdNotaIngreso;
            String strIdDetalleNotaIngreso;
            int cantidad;
            Date fecha;
            
            String strIdProducto;
            String strNombre;
                        
            while (rs.next()){
              
                strIdNotaIngreso = rs.getString(1).trim();
                strIdDetalleNotaIngreso = rs.getString(2).trim();
                cantidad = rs.getInt(3);
                fecha = rs.getDate(4);
                
                strIdProducto = rs.getString(5).trim();
                strNombre = rs.getString(6).trim();
                ProductoBE objProducto = new ProductoBE();
                objProducto.setIdProducto(strIdProducto);
                objProducto.setNombre(strNombre);
                
                arrDetalleNotaIngreso.add(new DetalleNotaIngresoBE(strIdDetalleNotaIngreso,cantidad,objProducto,fecha));
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrDetalleNotaIngreso;
    }
    
    
    
}
