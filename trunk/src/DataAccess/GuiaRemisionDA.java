    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.AlmacenBE;
import Util.conexion;
import BusinessEntity.EntidadBE;
import BusinessEntity.EstadoGRBE;
import BusinessEntity.GuiaRemisionBE;
import BusinessLogic.AlmacenBL;
import BusinessLogic.EntidadBL;
import BusinessLogic.EstadoGRBL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DIEGO
 */
public class GuiaRemisionDA {
     public boolean insertar(GuiaRemisionBE objGuiaRemision) throws Exception{
        
        boolean boolExito = false;
        conexion objConexion = new conexion();
       
        String sql = "INSERT INTO guiaremision(idguiaremision, fecha, identidad, idestadogr, idalmacen) VALUES('"+ objGuiaRemision.getCodigo() +"','"+ objGuiaRemision.getFecha() +"','"+ objGuiaRemision.getCliente().getIdEntidad() +"','"+ objGuiaRemision.getEstado().getCodigo() +"','"+ objGuiaRemision.getAlmacen().getIdAlmacen() +"')";
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        
        return boolExito;
    }
     
    public boolean cambiarEstado(String strCodigo,String codEstado) throws Exception{
        
        boolean boolExito = false;
        conexion objConexion = new conexion();
       
        String sql = "UPDATE guiaremision SET";
             sql += " idestadogr='"+codEstado+"'"; 
             sql+=  " WHERE idguiaremision='"+strCodigo+"'";
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        
        return boolExito;
    }
     
     
     public ArrayList<GuiaRemisionBE> queryAllGuiaRemision(){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<GuiaRemisionBE> arrGuiaRemision = new ArrayList<GuiaRemisionBE>();
        String sql = "SELECT idguiaremision,fecha,identidad,idestadogr,idalmacen FROM guiaremision order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strCodigo;
            Date fecha;
            String strIdEntidad;
            String strCodEstado;
            String strIdAlmacen;
            
            while (rs.next()){
              
                strCodigo = rs.getString(1).trim();
                fecha = rs.getDate(2);
                strIdEntidad = rs.getString(3).trim();
                strCodEstado = rs.getString(4).trim();
                strIdAlmacen = rs.getString(5).trim();
                
                EntidadBL objEntidadBL = new EntidadBL();
                EntidadBE objEntidadBE = objEntidadBL.getCliente(strIdEntidad);
                
                AlmacenBL objAlmacenBL = new AlmacenBL();
                AlmacenBE objAlmacenBE = objAlmacenBL.getAlmacen(strIdAlmacen);
               
                EstadoGRBL objEstadoGRBL = new EstadoGRBL();
                EstadoGRBE objEstadoGRBE = new EstadoGRBE();
                objEstadoGRBE = objEstadoGRBL.queryByIdEstadoGRBE(strCodEstado);
                
                arrGuiaRemision.add(new GuiaRemisionBE(strCodigo,fecha,objEntidadBE,objAlmacenBE,objEstadoGRBE));
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrGuiaRemision;
    }
     
     
      public ArrayList<GuiaRemisionBE> buscar(String codigo,String nombcliente,String codestado,String idAlmacen){
        conexion objConexion=new conexion();
        ResultSet rs = null;
         ArrayList<GuiaRemisionBE> arrGuiaRemision = new ArrayList<GuiaRemisionBE>();
                
        String sql = "SELECT g.idguiaremision, g.fecha, g.identidad, g.idestadogr, g.idalmacen FROM  guiaremision g, entidad e";
               
        sql  +=" WHERE g.idestadogr LIKE '%"+codestado+"%'";
        sql +=  " AND g.identidad = e.identidad";
       
        //sql+= " WHERE";
        if(!(codigo.equals("")) || !(nombcliente.equals("")) || !(idAlmacen.equals(""))){
           if (!idAlmacen.equals("")){           
               
               sql +=  " AND g.idalmacen LIKE '%"+idAlmacen+"%'";
           }
            
            if (!codigo.equals("")){           
               
               sql +=  " AND g.idguiaremision LIKE '%"+codigo+"%'";
           }
           if (!nombcliente.equals("")){
               
               sql += " AND e.razonsocial LIKE '%"+nombcliente+"%'";
           }
          
        }
        sql +=" order by 1";
              
        
        try{
            rs=objConexion.EjecutarS(sql);
            String strCodigo;
            Date fecha;
            String strIdEntidad;
            String strCodEstado;
            String strIdAlmacen;
            while (rs.next()){
              
                strCodigo = rs.getString(1).trim();
                fecha = rs.getDate(2);
                strIdEntidad = rs.getString(3).trim();
                strCodEstado = rs.getString(4).trim();
                 strIdAlmacen = rs.getString(5).trim();
                
                EntidadBL objEntidadBL = new EntidadBL();
                EntidadBE objEntidadBE = objEntidadBL.getCliente(strIdEntidad);
                
                 AlmacenBL objAlmacenBL = new AlmacenBL();
                AlmacenBE objAlmacenBE = objAlmacenBL.getAlmacen(strIdAlmacen);
               
                EstadoGRBL objEstadoGRBL = new EstadoGRBL();
                EstadoGRBE objEstadoGRBE = new EstadoGRBE();
                objEstadoGRBE = objEstadoGRBL.queryByIdEstadoGRBE(strCodEstado);
                
                arrGuiaRemision.add(new GuiaRemisionBE(strCodigo,fecha,objEntidadBE, objAlmacenBE,objEstadoGRBE));
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrGuiaRemision;
        
      }     
      
       public ArrayList<GuiaRemisionBE> buscarbyCodigoEntidad(String codigo){
        conexion objConexion=new conexion();
        ResultSet rs = null;
         ArrayList<GuiaRemisionBE> arrGuiaRemision = new ArrayList<GuiaRemisionBE>();
                
        String sql = "SELECT idguiaremision, fecha, identidad, idestadogr, idalmacen FROM  guiaremision";
               
        sql  +=" WHERE identidad = '"+codigo+"'";
        
                
        try{
            rs=objConexion.EjecutarS(sql);
            String strCodigo;
            Date fecha;
            String strIdEntidad;
            String strCodEstado;
            String strIdAlmacen;
            while (rs.next()){
              
                strCodigo = rs.getString(1).trim();
                fecha = rs.getDate(2);
                strIdEntidad = rs.getString(3).trim();
                strCodEstado = rs.getString(4).trim();
                 strIdAlmacen = rs.getString(5).trim();
                
                EntidadBL objEntidadBL = new EntidadBL();
                EntidadBE objEntidadBE = objEntidadBL.getCliente(strIdEntidad);
                
                 AlmacenBL objAlmacenBL = new AlmacenBL();
                AlmacenBE objAlmacenBE = objAlmacenBL.getAlmacen(strIdAlmacen);
               
                EstadoGRBL objEstadoGRBL = new EstadoGRBL();
                EstadoGRBE objEstadoGRBE = new EstadoGRBE();
                objEstadoGRBE = objEstadoGRBL.queryByIdEstadoGRBE(strCodEstado);
                
                arrGuiaRemision.add(new GuiaRemisionBE(strCodigo,fecha,objEntidadBE, objAlmacenBE,objEstadoGRBE));
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrGuiaRemision;
        
      }     
      
}
