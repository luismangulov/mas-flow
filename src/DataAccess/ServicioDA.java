/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;


import BusinessEntity.ServicioBE;
import Util.conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Florencio
 */
public class ServicioDA {
    
        public ArrayList<ServicioBE> queryAllServicio(){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<ServicioBE> arrServicio= new ArrayList<ServicioBE>();
        String sql = "SELECT idServicio,descripcion FROM Servicio order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdServicio;
            String strDescripcion;


            while (rs.next()){

                strIdServicio = rs.getString(1);
                strDescripcion = rs.getString(2);
                arrServicio.add(new ServicioBE(strIdServicio, strDescripcion));
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
        return arrServicio;
    }
}
