/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.AplicacionBE;
import Util.conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Florencio
 */
public class AplicacionDA {
    
        public ArrayList<AplicacionBE> queryAllAplicacion(){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<AplicacionBE> arrAplicacion= new ArrayList<AplicacionBE>();
        String sql = "SELECT idAplicacion,descripcion FROM Aplicacion order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdAplicacion;
            String strDescripcion;


            while (rs.next()){

                strIdAplicacion = rs.getString(1);
                strDescripcion = rs.getString(2);
                arrAplicacion.add(new AplicacionBE(strIdAplicacion, strDescripcion));
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
        return arrAplicacion;
    }

}
