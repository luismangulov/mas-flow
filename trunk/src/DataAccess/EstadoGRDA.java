 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.EstadoGRBE;
import Util.conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DIEGO
 */
public class EstadoGRDA {
    public EstadoGRBE queryByDescripcionEstadoGR(String descripcion){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        EstadoGRBE estado = null;
        String sql = "SELECT idestadogr,descripcion FROM estadogr ";
           sql += " WHERE descripcion='"+descripcion+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strCodigo;
            String strDescripcion;
            if (rs.next()){

                strCodigo = rs.getString(1);
                
                strDescripcion = rs.getString(2);
                
                estado = new  EstadoGRBE(strCodigo,strDescripcion);
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return estado;
    }
    
     public EstadoGRBE queryByIdEstadoGRBE(String codigo){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        EstadoGRBE estado = null;
        String sql = "SELECT idestadogr,descripcion FROM estadogr ";
           sql += " WHERE idestadogr='"+codigo+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strCodigo;
            String strDescripcion;
            if (rs.next()){

                strCodigo = rs.getString(1);
                
                strDescripcion = rs.getString(2);
                
                estado = new  EstadoGRBE(strCodigo,strDescripcion);
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return estado;
     }
     
     public ArrayList<EstadoGRBE> queryAllEstadoGRBE(){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<EstadoGRBE> arrEstadoGRBE = new ArrayList<EstadoGRBE>();
        String sql = "SELECT idestadogr,descripcion FROM estadogr order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
             String strCodigo;
            String strDescripcion;
            while (rs.next()){
               strCodigo = rs.getString(1);
               strDescripcion = rs.getString(2);
                arrEstadoGRBE.add(new EstadoGRBE(strCodigo,strDescripcion));
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrEstadoGRBE;
    }
     
}
