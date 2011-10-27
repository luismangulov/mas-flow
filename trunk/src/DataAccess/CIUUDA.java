/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import Util.conexion;
import BusinessEntity.CIUUBE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author giuliana
 */
public class CIUUDA {


        public static ArrayList<CIUUBE> queryAllCIUU(){

        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<CIUUBE> arrCIUU = new ArrayList<CIUUBE>();
        String sql = "SELECT idciuu, descripcion FROM CIUU order by 1;";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdCIUU;
            String strDescripcion;
            while (rs.next()){
                strIdCIUU = rs.getString(1);
                strDescripcion = rs.getString(2);
                
                arrCIUU.add(new CIUUBE( strIdCIUU, strDescripcion));
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrCIUU;
    }

          public static CIUUBE getCIUU(String codigo){
          CIUUBE ciuu = new CIUUBE();
        conexion objConexion=new conexion();
        ResultSet rs = null;
        String sql = "SELECT idciuu, descripcion FROM CIUU where idciuu='"+codigo+"' order by 1;";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdCIUU;
            String strDescripcion;
            if (rs.next()){
                strIdCIUU = rs.getString(1);
                strDescripcion = rs.getString(2);
                
                ciuu= new CIUUBE(strIdCIUU, strDescripcion);
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return ciuu;
    }
}
