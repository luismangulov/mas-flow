/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.PerfilBE;
import BusinessEntity.UsuarioBE;
import Util.conexion;
import java.sql.ResultSet;

/**
 *
 * @author Florencio
 */
public class PerfilDA {


  public PerfilBE queryByIdPerfil(String idPerfil){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        PerfilBE perfil = null;
        String sql = "SELECT idPerfil,descripcion, indActivo FROM Perfil";
           sql += " WHERE idPerfil='"+idPerfil+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdPerfil;
            String strDescripcion;
            String strIndActivo;
          
            if (rs.next()){    
                               
                strIdPerfil = rs.getString(1);
                strDescripcion = rs.getString(2);
                strIndActivo = rs.getString(3);
                perfil = new PerfilBE(strIdPerfil,strDescripcion,strIndActivo);
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return perfil;
    }

    
}
