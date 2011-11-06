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
        
      //obtiene un listado de las aplicaciones por perfil
      public ArrayList<String> queryAllAplicacionesPorPerfil(String idPerfil){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<String> listaAplicaciones = new ArrayList<String>();
        
        String sql = "SELECT DISTINCT idAplicacion FROM PerfilDetalle WHERE idPerfil= '"+idPerfil+"' order by 1";
        AplicacionDA objAplicacionDA=new AplicacionDA();  
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdAplicacion;
            while (rs.next()){

                strIdAplicacion = rs.getString(1).trim();
                listaAplicaciones.add(objAplicacionDA.queryByIdAplicacion(strIdAplicacion).getDescripcion());
                
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return listaAplicaciones;
        
        }
      
      //obtiene todos los servicios para una determinada aplicacion de un PERFIL ESPECÏFICO
       public ArrayList<String> queryAllServiciosPorAplicacionPorPerfil(String idPerfil,String idAplicacion){
           
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<String> listaServicios = new ArrayList<String>();
        
        String sql = "SELECT DISTINCT idServicio FROM PerfilDetalle WHERE idPerfil= '"+idPerfil+"' AND idAplicacion LIKE '%"+idAplicacion+"' order by 1";
        ServicioDA objServicioDA=new ServicioDA();                                                  
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdServicio;
            while (rs.next()){
                
                strIdServicio = rs.getString(1).trim();
                listaServicios.add(objServicioDA.queryByIdServicio(strIdServicio).getIdDescripcion());
                
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return listaServicios;
        
        }


    public boolean insertar(PerfilDetalleBE objPerfilDetalle) throws Exception{

        boolean boolExito = false;
        conexion objConexion = new conexion();
        String sql = "INSERT INTO PerfilDetalle(idPerfil, indDetalle,idAplicacion,idServicio) VALUES('"+ objPerfilDetalle.getPerfil().getIdPerfil() +"','"+ objPerfilDetalle.getIndDetalle() +"','"+ objPerfilDetalle.getAplicacion().getIdAplicacion() +"','"+ objPerfilDetalle.getServicio().getIdServicio() +"')";
   
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        return boolExito;
    }

    //elimina toda la lista de detalles perfil de la tabla perfil

    public boolean eliminarDetallePerfil(String idPerfil) throws Exception{

        boolean boolExito = false;
        conexion objConexion = new conexion();

        String sql = "DELETE FROM PerfilDetalle";
             sql += " WHERE idPerfil='"+idPerfil+"'";

        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}

        return boolExito;
    }
        


    
}
