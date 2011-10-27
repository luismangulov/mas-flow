/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import Util.conexion;
import BusinessEntity.DepartamentoBE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author giuliana
 */
public class DepartamentoDA {

    public static ArrayList<DepartamentoBE> queryAllDepartamento(){

        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<DepartamentoBE> arrDepartamento = new ArrayList<DepartamentoBE>();
        String sql = "SELECT idDepartamento, descripcion "
                + "FROM distrito order by 2";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdDepartamento;
            String strDescripcion;
            while (rs.next()){
                strIdDepartamento = rs.getString(1);
                strDescripcion = rs.getString(2);

                arrDepartamento.add(new DepartamentoBE( strIdDepartamento, strDescripcion));
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrDepartamento;
    }


        public static DepartamentoBE queryDepartamento(String idDepartamento){

        conexion objConexion=new conexion();
        ResultSet rs = null;
        DepartamentoBE departamento = new DepartamentoBE("","");
        String sql = "SELECT idDepartamento, descripcion "
                + "FROM distrito where idDepartamento='"+idDepartamento+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdDepartamento;
            String strDescripcion;
            if (rs.next()){
                strIdDepartamento = rs.getString(1);
                strDescripcion = rs.getString(2);

                departamento =new DepartamentoBE( strIdDepartamento, strDescripcion);
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return departamento;
    }


}
