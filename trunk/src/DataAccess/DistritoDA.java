/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import Util.conexion;
import BusinessEntity.DistritoBE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author giuliana
 */
public class DistritoDA {

    public static ArrayList<DistritoBE> queryAllDistrito(String idDepartamento, String idProvincia){

        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<DistritoBE> arrDistrito = new ArrayList<DistritoBE>();
        String sql = "SELECT idDepartamento, idProvincia, idDistrito, descripcion "
                + "FROM distrito where idDepartamento='"+idDepartamento+
                "' and idProvincia='"+idProvincia+"' order by 4";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdDepartamento;
            String strIdProvincia;
            String strIdDistrito;
            String strDescripcion;
            while (rs.next()){
                strIdDepartamento = rs.getString(1).trim();
                strIdProvincia = rs.getString(2).trim();
                strIdDistrito = rs.getString(3).trim();
                strDescripcion = rs.getString(4).trim();

                arrDistrito.add(new DistritoBE( strIdDepartamento, strIdProvincia,strIdDistrito, strDescripcion));
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrDistrito;

    }


     public static DistritoBE queryDistrito(String idDepartamento, String idProvincia, String idDistrito){

        conexion objConexion=new conexion();
        ResultSet rs = null;
        DistritoBE distrito = new DistritoBE("","","","");
        String sql = "SELECT idDepartamento, idProvincia, idDistrito, descripcion "
                + "FROM distrito where idDepartamento='"+idDepartamento+
                "' and idProvincia='"+idProvincia+"' and idDistrito='"+idDistrito+
                "' order by 4";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdDepartamento;
            String strIdProvincia;
            String strIdDistrito;
            String strDescripcion;
            if (rs.next()){
                strIdDepartamento = rs.getString(1).trim();
                strIdProvincia = rs.getString(2).trim();
                strIdDistrito = rs.getString(3).trim();
                strDescripcion = rs.getString(4).trim();

                distrito=new DistritoBE( strIdDepartamento, strIdProvincia,strIdDistrito, strDescripcion);
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return distrito;

    }
}

