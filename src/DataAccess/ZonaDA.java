/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BD.conexion;
import BusinessEntity.ZonaBE;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author victor
 */
public class ZonaDA {
    
    ArrayList<ZonaBE> arrZonas;
    ZonaBE objZonaBE;
    conexion objConexion;
    String query;
    
    public ArrayList<ZonaBE> queryAllFamilia(){
        
        objConexion = new conexion();
        ResultSet rs = null;
        arrZonas = new ArrayList<ZonaBE>();
        
        query = "SELECT idZona,nombre,descripcion,indActivo,idAlmacen FROM Zona WHERE IndActivo = '1' order by 1";
        
        try{
            rs = objConexion.EjecutarS(query);
            String strIdZona;
            String strNombre;
            String strDescripcion;
            String strIndActivo;
            String strIdAlmacen;
            
            while (rs.next()){
              
                strIdZona = rs.getString("idZona");
                strNombre = rs.getString("nombre");
                strDescripcion = rs.getString("descripcion");
                strIndActivo = rs.getString("indActivo");
                strIdAlmacen = rs.getString("idAlmacen");
                
                arrZonas.add(new ZonaBE(strIdZona,strNombre,strDescripcion,strIndActivo,strIdAlmacen));
            }
             
        }catch (Exception e){
            System.out.println(e.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrZonas;
    }
    
    public ZonaBE queryByIdZona(String idZona){
        
        objConexion = new conexion();
        ResultSet rs = null;
        
        query = "SELECT idZona,nombre,descripcion,indActivo,idAlmacen FROM Zona WHERE idZona = '"+idZona+"'";
        
        try{
            rs = objConexion.EjecutarS(query);
            String strIdZona;
            String strNombre;
            String strDescripcion;
            String strIndActivo;
            String strIdAlmacen;
            
            rs.next();
            strIdZona = rs.getString("idZona");
            strNombre = rs.getString("nombre");
            strDescripcion = rs.getString("descripcion");
            strIndActivo = rs.getString("indActivo");
            strIdAlmacen = rs.getString("idAlmacen");

            objZonaBE = new ZonaBE(strIdZona,strNombre,strDescripcion,strIndActivo,strIdAlmacen);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e, query, 0);
         }
         finally{
             objConexion.SalirS();
         }
        
      return objZonaBE;
    }
    
    public ZonaBE queryByNombreZona(String nombreZona){
        
        objConexion = new conexion();
        ResultSet rs = null;
        
        query = "SELECT idZona,nombre,descripcion,indActivo,idAlmacen FROM Zona WHERE nombre = '"+nombreZona+"'";
        
        try{
            rs = objConexion.EjecutarS(query);
            String strIdZona;
            String strNombre;
            String strDescripcion;
            String strIndActivo;
            String strIdAlmacen;
            
            rs.next();
            strIdZona = rs.getString("idZona");
            strNombre = rs.getString("nombre");
            strDescripcion = rs.getString("descripcion");
            strIndActivo = rs.getString("indActivo");
            strIdAlmacen = rs.getString("idAlmacen");

            objZonaBE = new ZonaBE(strIdZona,strNombre,strDescripcion,strIndActivo,strIdAlmacen);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e, query, 0);
         }
         finally{
             objConexion.SalirS();
         }
        
      return objZonaBE;
    }
}
