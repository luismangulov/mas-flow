/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Util.conexion;
import BusinessEntity.DetalleGuiaRemisionBE;
import BusinessEntity.ProductoBE;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DIEGO
 */
public class DetalleGuiaRemisionDA {
    public boolean insertar(DetalleGuiaRemisionBE objDetalleGuiaRemision,String codGuiaRemision) throws Exception{
        
        boolean boolExito = false;
        conexion objConexion = new conexion();
       
        String sql = "INSERT INTO detalleguiaremision(iddetalleguiaremision,idguiaremision,cantidad,idproducto) VALUES('"+ objDetalleGuiaRemision.getCodigo() +"','"+ codGuiaRemision +"','"+ objDetalleGuiaRemision.getCantidad() +"','"+ objDetalleGuiaRemision.getProducto().getIdProducto() +"')";
        
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        
        return boolExito;
    }
    
    public ArrayList<DetalleGuiaRemisionBE> queryAllDetalleGuiaRemision(String codGuiaRemision){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<DetalleGuiaRemisionBE> arrDetalleGuiaRemision = new ArrayList<DetalleGuiaRemisionBE>();
        String sql = "SELECT g.idguiaremision,g.iddetalleguiaremision,g.cantidad,p.idproducto,p.nombre FROM detalleguiaremision g, producto p";
                 sql += " WHERE g.idguiaremision='"+codGuiaRemision+"'";
                 sql += " AND p.idproducto = g.idproducto order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdGuiaRemision;
            String strIdDetalleGuiaRemision;
            int cantidad;
            String strIdProducto;
            String strNombre;
                        
            while (rs.next()){
              
                strIdGuiaRemision = rs.getString(1).trim();;
                strIdDetalleGuiaRemision = rs.getString(2).trim();;
                cantidad = rs.getInt(3);
                strIdProducto = rs.getString(4).trim();;
                strNombre = rs.getString(5).trim();;
                ProductoBE objProducto = new ProductoBE();
                objProducto.setIdProducto(strIdProducto);
                objProducto.setNombre(strNombre);
                
                arrDetalleGuiaRemision.add(new DetalleGuiaRemisionBE(strIdDetalleGuiaRemision,cantidad,objProducto));
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrDetalleGuiaRemision;
    }
    
    
}
