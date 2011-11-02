/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.AplicacionBE;
import BusinessEntity.AplicacionxServicioBE;
import BusinessEntity.PerfilBE;
import BusinessEntity.PerfilDetalleBE;
import BusinessEntity.ServicioBE;
import Util.conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Florencio
 */
public class PerfilDetalleDA {
    
    
        public ArrayList<PerfilDetalleBE> queryAllByIdPerfil(String idPerfil){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<PerfilDetalleBE> arrPerfilDetalle = new ArrayList<PerfilDetalleBE>();
        PerfilBE objPerfilBE =new PerfilBE();
        PerfilDA objPerfilDA=new PerfilDA();
        AplicacionBE objAplicacionBE = new AplicacionBE();
        AplicacionDA objAplicacionDA =new AplicacionDA();
        ServicioBE objServicioBE = new ServicioBE();
        ServicioDA objServicioDA =new ServicioDA();
        
        
        String sql = "SELECT idPerfil,indDetalle,idAplicacion,idServicio FROM PerfilDetalle WHERE idPerfil= '"+idPerfil+"' order by 2";
        
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdPerfil;
            String strIndDetalle;
            String strIdAplicacion;
            String strIdServicio;
            while (rs.next()){
                strIdPerfil = rs.getString(1).trim();
                strIndDetalle = rs.getString(2).trim();
                strIdAplicacion = rs.getString(3).trim();
                strIdServicio = rs.getString(4).trim();
                objPerfilBE=objPerfilDA.queryById(strIdPerfil);
                objServicioBE=objServicioDA.queryByIdServicio(strIdServicio);
                objAplicacionBE=objAplicacionDA.queryByIdAplicacion(strIdAplicacion);
                arrPerfilDetalle.add(new PerfilDetalleBE(objPerfilBE,strIndDetalle,objAplicacionBE,objServicioBE));
                
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrPerfilDetalle;
        
    }
        
        


    
}
