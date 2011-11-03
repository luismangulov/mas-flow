/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.AplicacionBE;
import BusinessEntity.AplicacionxServicioBE;
import BusinessEntity.ServicioBE;
import Util.conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Florencio
 */
public class AplicacionxServicioDA {
    
        public ArrayList<AplicacionxServicioBE> queryAllAplicacionxServicio(){
            
        conexion objConexion=new conexion();
        ResultSet rs = null;
        AplicacionDA objAplicacionDA=new AplicacionDA();
        AplicacionBE objAplicacionBE=new AplicacionBE();
        ArrayList<ServicioBE>arrServicios=new ArrayList<ServicioBE>();
        ArrayList<AplicacionxServicioBE> arrAplicacionxServicios= new ArrayList<AplicacionxServicioBE>();
        String sql = "SELECT distinct  AXS.idAplicacion, A.descripcion FROM aplicacionxservicio AXS, aplicacion A where A.idAplicacion = AXS.idAplicacion";
//        String sql="SELECT idAplicacion,descripcion from aplicacion";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdAplicacion;
            String strDescripcion;           
            while (rs.next()){                
                strIdAplicacion = rs.getString(1).trim();
                strDescripcion = rs.getString(2).trim();
                objAplicacionBE =objAplicacionDA.queryByIdAplicacion(strIdAplicacion);
                arrServicios=queryServiciosByAplicacion(strIdAplicacion);         
                arrAplicacionxServicios.add(new AplicacionxServicioBE(objAplicacionBE,arrServicios));               
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
        return arrAplicacionxServicios;
    }

    private ArrayList<ServicioBE> queryServiciosByAplicacion(String idAplicacion) {
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<ServicioBE> arrServicios= new ArrayList<ServicioBE>();
        
        String sql = "SELECT AXS.idServicio, S.descripcion FROM aplicacionxservicio AXS, servicio S where S.idservicio = AXS.idservicio ";
           sql += " AND AXS.idaplicacion='"+idAplicacion+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdServicio;
            String strDescripcion;
     
            while (rs.next()){
                
                strIdServicio = rs.getString(1).trim();
                strDescripcion = rs.getString(2).trim();
                arrServicios.add(new ServicioBE(strIdServicio, strDescripcion));
                
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrServicios;
    }

    
}
