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


//inserta un UsuarioContrasena
public String insertarUsuarioContrasena(String indDetalle,String idUsuario, String nuevoPassword, Date fechaInicio,Date fechaFin) {
        conexion objConexion=new conexion();
        ResultSet rs = null;
        String sql ;        
        sql = "INSERT INTO UsuarioContrasena( indDetalle,idUsuario,contrasena,fechaInicio,fechaFin) VALUES('"+indDetalle+"','"+idUsuario+"','"+nuevoPassword+"','"+fechaInicio+"','"+fechaFin+"')";
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

//devuelve el indDetalle correspondiente(MAXIMO) de para un idUsuario determinado
    public String indDetalleByIdUsuario(String idUsuario) {
        conexion objConexion=new conexion();
        ResultSet rs = null;
        String indDetalle="";
        String sql = "SELECT max(indDetalle) FROM UsuarioContrasena WHERE idUsuario='"+idUsuario+"'";

        try{
            rs=objConexion.EjecutarS(sql);
            String strIndDetalle;
            if (rs.next()){
                strIndDetalle = rs.getString(1).trim();
                if(strIndDetalle.equals("")){
                    indDetalle="1";
                }else
                {
                    indDetalle=String.valueOf(Integer.parseInt(strIndDetalle));
                }

             }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return indDetalle;
    }

//devuelve el mas reciente objeto usuariocontrasena
    public UsuarioContrasenaBE QueryByIdUsuario(String idUsuario) {
        conexion objConexion=new conexion();
        ResultSet rs = null;
        UsuarioContrasenaBE usuarioContrasenaBE = null;
        String indDetalle=indDetalleByIdUsuario(idUsuario);
        String sql = "SELECT indDetalle,idUsuario,contrasena,fechaInicio,fechaFin FROM UsuarioContrasena ";
           sql += " WHERE idUsuario='"+idUsuario+"' AND indDetalle='"+indDetalle+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIndDetalle;
            String strIdUsuario;
            String strContrasena;
            Date dateFechaInicio;
            Date dateFechaFin;

            if (rs.next()){
                strIndDetalle = rs.getString(1).trim();
                strIdUsuario = rs.getString(2).trim();
                strContrasena = rs.getString(3).trim();
                dateFechaInicio=rs.getDate(4);
                dateFechaFin=rs.getDate(5);
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
