/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.EstadoGRBE;
import Util.conexion;
import java.sql.ResultSet;

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
}
