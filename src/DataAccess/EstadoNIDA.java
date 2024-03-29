/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.EstadoNIBE;
import Util.conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DIEGO
 */
public class EstadoNIDA {
     public EstadoNIBE queryByDescripcionEstadoNI(String descripcion){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        EstadoNIBE estado = null;
        String sql = "SELECT idestadoni,descripcion FROM estadoni ";
           sql += " WHERE descripcion='"+descripcion+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strCodigo;
            String strDescripcion;
            if (rs.next()){

                strCodigo = rs.getString(1);
                
                strDescripcion = rs.getString(2);
                
                estado = new  EstadoNIBE(strCodigo,strDescripcion);
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return estado;
    }
    
     public EstadoNIBE queryByIdEstadoNI(String codigo){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        EstadoNIBE estado = null;
        String sql = "SELECT idestadoni,descripcion FROM estadoni ";
           sql += " WHERE idestadoni='"+codigo+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strCodigo;
            String strDescripcion;
            if (rs.next()){

                strCodigo = rs.getString(1);
                
                strDescripcion = rs.getString(2);
                
                estado = new  EstadoNIBE(strCodigo,strDescripcion);
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return estado;
     } 
     
      public ArrayList<EstadoNIBE> queryAllEstadoNIBE(){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<EstadoNIBE> arrEstadoNIBE = new ArrayList<EstadoNIBE>();
        String sql = "SELECT idestadoni,descripcion FROM estadoni order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
             String strCodigo;
            String strDescripcion;
            while (rs.next()){
               strCodigo = rs.getString(1);
               strDescripcion = rs.getString(2);
                arrEstadoNIBE.add(new EstadoNIBE(strCodigo,strDescripcion));
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrEstadoNIBE;
    }
     
     
}
