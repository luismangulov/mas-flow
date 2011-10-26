/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import Util.conexion;
import BusinessEntity.ProvinciaBE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author giuliana
 */
public class ProvinciaDA {

       public static ArrayList<ProvinciaBE> queryAllProvincia(String idDepartamento){

        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<ProvinciaBE> arrProvincia = new ArrayList<ProvinciaBE>();
        String sql = "SELECT idDepartamento, idProvincia, descripcion "
                + "FROM distrito where idDepartamento='"+idDepartamento+"' order by 3";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdDepartamento;
            String strIdProvincia;
            String strDescripcion;
            while (rs.next()){
                strIdDepartamento = rs.getString(1);
                strIdProvincia = rs.getString(2);
                strDescripcion = rs.getString(3);

                arrProvincia.add(new ProvinciaBE( strIdDepartamento, strIdProvincia, strDescripcion));
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrProvincia;

    }



}
