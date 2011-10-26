/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Util.conexion;
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
    
    public ArrayList<ZonaBE> queryAllZona(){
        
        objConexion = new conexion();
        ResultSet rs = null;
        arrZonas = new ArrayList<ZonaBE>();
        
        query = "SELECT * FROM Zona WHERE IndActivo = '1' order by 1";
        
        try{
            rs = objConexion.EjecutarS(query);
            String strIdZona;
            String strNombre;
            String strDescripcion;
            String strIndActivo;
            String strIdAlmacen;
            Double douLargo;
            Double douAncho;
            int intPosX;
            int intPosY;
            String strIdentificador;
            
            while (rs.next()){
              
                strIdZona = rs.getString("idZona");
                strNombre = rs.getString("nombre");
                strIndActivo = rs.getString("indActivo");
                strIdAlmacen = rs.getString("idAlmacen");
                douLargo = rs.getDouble("Largo");
                douAncho = rs.getDouble("Ancho");
                intPosX = rs.getInt("PosX");
                intPosY = rs.getInt("posY");
                strIdentificador = rs.getString("Identificador");
                
                arrZonas.add(new ZonaBE(strIdZona,strNombre,strIndActivo,strIdAlmacen,douLargo,douAncho,intPosX,intPosY,strIdentificador));
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
        
        query = "SELECT * FROM Zona WHERE idZona = '"+idZona+"'";
        
        try{
            rs = objConexion.EjecutarS(query);
            String strIdZona;
            String strNombre;
            String strDescripcion;
            String strIndActivo;
            String strIdAlmacen;
            Double douLargo;
            Double douAncho;
            int intPosX;
            int intPosY;
            String strIdentificador;
            
            rs.next();
            strIdZona = rs.getString("idZona");
            strNombre = rs.getString("nombre");
            strIndActivo = rs.getString("indActivo");
            strIdAlmacen = rs.getString("idAlmacen");
            douLargo = rs.getDouble("Largo");
            douAncho = rs.getDouble("Ancho");
            intPosX = rs.getInt("PosX");
            intPosY = rs.getInt("posY");
            strIdentificador = rs.getString("Identificador");
            
            objZonaBE = new ZonaBE(strIdZona,strNombre,strIndActivo,strIdAlmacen,douLargo,douAncho,intPosX,intPosY,strIdentificador);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e, query, 0);
         }
         finally{
             objConexion.SalirS();
         }
        
      return objZonaBE;
    }
    
    public ZonaBE queryByIdentificadorZona(String identificador){
        
        objConexion = new conexion();
        ResultSet rs = null;
        
        query = "SELECT * FROM Zona WHERE identificador = '"+identificador+"'";
        
        try{
            rs = objConexion.EjecutarS(query);
            String strIdZona;
            String strNombre;
            String strDescripcion;
            String strIndActivo;
            String strIdAlmacen;
            Double douLargo;
            Double douAncho;
            int intPosX;
            int intPosY;
            String strIdentificador;
            
            rs.next();
            strIdZona = rs.getString("idZona");
            strNombre = rs.getString("nombre");
            strIndActivo = rs.getString("indActivo");
            strIdAlmacen = rs.getString("idAlmacen");
            douLargo = rs.getDouble("Largo");
            douAncho = rs.getDouble("Ancho");
            intPosX = rs.getInt("PosX");
            intPosY = rs.getInt("posY");
            strIdentificador = rs.getString("Identificador");
            
            objZonaBE = new ZonaBE(strIdZona,strNombre,strIndActivo,strIdAlmacen,douLargo,douAncho,intPosX,intPosY,strIdentificador);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e, query, 0);
         }
         finally{
             objConexion.SalirS();
         }
        
      return objZonaBE;
    }
}
