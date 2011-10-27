    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Util.conexion;
import BusinessEntity.EntidadBE;
import BusinessEntity.EstadoGRBE;
import BusinessEntity.GuiaRemisionBE;
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
       
        String sql = "INSERT INTO guiaremision(idguiaremision, fecha, identidad, idestadogr) VALUES('"+ objGuiaRemision.getCodigo() +"','"+ objGuiaRemision.getFecha() +"','"+ objGuiaRemision.getCliente().getIdEntidad() +"','"+ objGuiaRemision.getEstado().getCodigo() +"')";
        
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
        String sql = "SELECT idguiaremision,fecha,identidad,idestadogr FROM guiaremision order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strCodigo;
            Date fecha;
            String strIdEntidad;
            String strCodEstado;
            
            while (rs.next()){
              
                strCodigo = rs.getString(1);
                fecha = rs.getDate(2);
                strIdEntidad = rs.getString(3);
                strCodEstado = rs.getString(4);
                EntidadBL objEntidadBL = new EntidadBL();
                EntidadBE objEntidadBE = objEntidadBL.getCliente(strIdEntidad);
               
                EstadoGRBL objEstadoGRBL = new EstadoGRBL();
                EstadoGRBE objEstadoGRBE = new EstadoGRBE();
                objEstadoGRBE = objEstadoGRBL.queryByIdEstadoGRBE(strCodEstado);
                
                arrGuiaRemision.add(new GuiaRemisionBE(strCodigo,fecha,objEntidadBE,objEstadoGRBE));
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrGuiaRemision;
    }
     
     
      public ArrayList<GuiaRemisionBE> buscar(String codigo,String nombcliente,String codestado){
        conexion objConexion=new conexion();
        ResultSet rs = null;
         ArrayList<GuiaRemisionBE> arrGuiaRemision = new ArrayList<GuiaRemisionBE>();
                
        String sql = "SELECT g.idguiaremision, g.fecha, g.identidad, g.idestadogr FROM  guiaremision g,entidad e";
               
        sql  +=" WHERE g.idestadogr ='"+codestado+"'";
        
       
        //sql+= " WHERE";
        if(!(codigo.equals("")) || !(nombcliente.equals(""))){
           if (!codigo.equals("")){           
               
               sql +=  " AND idguiaremision LIKE '%"+codigo+"%'";
           }
           if (!nombcliente.equals("")){
               
               sql += " AND e.identidad = g.identidad AND e.razonsocial LIKE '%"+nombcliente+"%'";
           }
          
        }
        sql +=" order by 1";
              
        
        try{
            rs=objConexion.EjecutarS(sql);
            String strCodigo;
            Date fecha;
            String strIdEntidad;
            String strCodEstado;
            while (rs.next()){
              
                strCodigo = rs.getString(1);
                fecha = rs.getDate(2);
                strIdEntidad = rs.getString(3);
                strCodEstado = rs.getString(4);
                EntidadBL objEntidadBL = new EntidadBL();
                EntidadBE objEntidadBE = objEntidadBL.getCliente(strIdEntidad);
               
                EstadoGRBL objEstadoGRBL = new EstadoGRBL();
                EstadoGRBE objEstadoGRBE = new EstadoGRBE();
                objEstadoGRBE = objEstadoGRBL.queryByIdEstadoGRBE(strCodEstado);
                
                arrGuiaRemision.add(new GuiaRemisionBE(strCodigo,fecha,objEntidadBE,objEstadoGRBE));
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
