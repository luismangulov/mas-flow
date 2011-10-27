/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.PerfilBE;
import Util.conexion;
import java.sql.ResultSet;

/**
 *
 * @author Florencio
 */
public class UsuarioContrasenaDA {
    
     public String corroborarContrasena(String idUsuario, String password){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        String sql = "SELECT indDetalle,idUsuario,contrasena,fechaInicio,fechaFin  FROM UsuarioContrasena ";
          sql+="WHERE Idusuario = '"+idUsuario+"' AND contrasena='"+password+"'  AND indDetalle = (SELECT MAX(INDdETALLE) FROM UsuarioContrasena where idusuario = '"+ idUsuario+"' )";
          
        try{
            rs=objConexion.EjecutarS(sql);
            if (rs.next()){
                return "1";
             }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
        return "0";
    }
}
