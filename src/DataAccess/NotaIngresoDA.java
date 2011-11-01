/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.EntidadBE;
import BusinessEntity.EstadoNIBE;
import BusinessEntity.NotaIngresoBE;
import BusinessLogic.EntidadBL;
import BusinessLogic.EstadoNIBL;
import Util.conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DIEGO
 */
public class NotaIngresoDA {
    public boolean insertar(NotaIngresoBE objNotaIngreso) throws Exception{
        
        boolean boolExito = false;
        conexion objConexion = new conexion();
       
        String sql = "INSERT INTO notaingreso(idnotaingreso, fecha, identidad, idestadoni) VALUES('"+ objNotaIngreso.getCodigo() +"','"+ objNotaIngreso.getFecha() +"','"+ objNotaIngreso.getProveedor().getIdEntidad() +"','"+ objNotaIngreso.getEstado().getCodigo() +"')";
        
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
             sql += "idestadoni='"+codEstado+ "'"+ 
                    " WHERE idnotaingreso='"+strCodigo+"'";
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        
        return boolExito;
    }
    
    
     public ArrayList<NotaIngresoBE> queryAllNotaIngreso(){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<NotaIngresoBE> arrNotaIngreso = new ArrayList<NotaIngresoBE>();
        String sql = "SELECT idnotaingreso,fecha,identidad,idestadoni FROM notaingreso order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strCodigo;
            Date fecha;
            String strIdEntidad;
            String strCodEstado;
            while (rs.next()){
              
                strCodigo = rs.getString(1).trim();
                fecha = rs.getDate(2);
                strIdEntidad = rs.getString(3).trim();
                strCodEstado = rs.getString(4).trim();
                EntidadBL objEntidadBL = new EntidadBL();
                EntidadBE objEntidadBE = objEntidadBL.getCliente(strIdEntidad);
               
                EstadoNIBL objEstadoNIBL = new EstadoNIBL();
                EstadoNIBE objEstadoNIBE = new EstadoNIBE();
                objEstadoNIBE = objEstadoNIBL.queryByIdEstadoNI(strCodEstado);
                
                
                arrNotaIngreso.add(new NotaIngresoBE(strCodigo,fecha,objEntidadBE,objEstadoNIBE));
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrNotaIngreso;
    }
     
     public ArrayList<NotaIngresoBE> buscar(String codigo,String nombproveedor,String codestado){
        conexion objConexion=new conexion();
        ResultSet rs = null;
         ArrayList<NotaIngresoBE> arrNotaIngreso = new ArrayList<NotaIngresoBE>();
                
        String sql = "SELECT g.idnotaingreso, g.fecha, g.identidad, g.idestadoni FROM  notaingreso g, entidad e";
               
        sql  +=" WHERE g.idestadoni LIKE '%"+codestado+"%'";
        sql +=  " AND g.identidad = e.identidad";
       
        //sql+= " WHERE";
        if(!(codigo.equals("")) || !(nombproveedor.equals(""))){
           if (!codigo.equals("")){           
               
               sql +=  " AND g.idnotaingreso LIKE '%"+codigo+"%'";
           }
           if (!nombproveedor.equals("")){
               
               sql += " AND e.razonsocial LIKE '%"+nombproveedor+"%'";
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
              
                strCodigo = rs.getString(1).trim();
                fecha = rs.getDate(2);
                strIdEntidad = rs.getString(3).trim();
                strCodEstado = rs.getString(4).trim();
                EntidadBL objEntidadBL = new EntidadBL();
                EntidadBE objEntidadBE = objEntidadBL.getCliente(strIdEntidad);
               
                EstadoNIBL objEstadoNIBL = new EstadoNIBL();
                EstadoNIBE objEstadoNIBE = new EstadoNIBE();
                objEstadoNIBE = objEstadoNIBL.queryByIdEstadoNI(strCodEstado);
                
                
                arrNotaIngreso.add(new NotaIngresoBE(strCodigo,fecha,objEntidadBE,objEstadoNIBE));
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrNotaIngreso;
        
      }     
     
     
}
