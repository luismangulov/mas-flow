/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.PerfilBE;
import BusinessEntity.UsuarioContrasenaBE;
import Util.conexion;
import java.sql.ResultSet;
import java.util.Date;

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

    public String actualizarContrasena(String idUsuario, String nuevoPassword) {
        conexion objConexion=new conexion();
        ResultSet rs = null;
        String sql = "SELECT max(indDetalle) FROM UsuarioContrasena";
        String indDetalle="";
        try{
            rs=objConexion.EjecutarS(sql);
            
            if (rs.next()){
                
                int ind=(rs.getInt(1))+1;
                indDetalle=String.valueOf(ind);
                
                sql = "INSERT INTO UsuarioContrasena( indDetalle,idUsuario,contrasena) VALUES('"+indDetalle+"','"+idUsuario+"','"+nuevoPassword+"')";
          
                try{
                    rs=objConexion.EjecutarS(sql);
                    return "1";
                }catch (Exception a){
                    System.out.println(a.getMessage());
                 }
                 finally{
                     objConexion.SalirS();
                 }
                return "0";
             }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
        
        return "0";       

    }



public String insertarUsuarioContrasena(String idUsuario, String nuevoPassword, Date fechaInicio,Date fechaFin) {
        conexion objConexion=new conexion();
        ResultSet rs = null;
        String sql ;        
        sql = "INSERT INTO UsuarioContrasena( indDetalle,idUsuario,contrasena,fechaInicio,fechaFin) VALUES('1','"+idUsuario+"','"+nuevoPassword+"','"+fechaInicio+"','"+fechaFin+"')";
        try{
            rs=objConexion.EjecutarS(sql);
            return "1";
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
        return "0";
}


//devuelve el mas reciente objeto usuariocontrasena
    public UsuarioContrasenaBE QueryByIdUsuario(String idUsuario) {
        conexion objConexion=new conexion();
        ResultSet rs = null;
        UsuarioContrasenaBE usuarioContrasenaBE = null;
        String sql = "SELECT idUsuario,indDetalle,user,contrasena,fechaInicio,fechaFin FROM UsuarioContrasena ";
           sql += " WHERE idUsuario='"+idUsuario+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdUsuario;
            String strIndDetalle;
            String strUser;
            String strContrasena;
            Date dateFechaInicio;
            Date dateFechaFin;

            if (rs.next()){

                strIdUsuario = rs.getString(1).trim();
                strIndDetalle = rs.getString(2).trim();
                strUser = rs.getString(3).trim();
                strContrasena = rs.getString(4).trim();
                dateFechaInicio=rs.getDate(5);
                dateFechaFin=rs.getDate(6);
                usuarioContrasenaBE = new UsuarioContrasenaBE(strIndDetalle,strIdUsuario,strContrasena,dateFechaInicio,dateFechaFin);
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return usuarioContrasenaBE;
    }
}
