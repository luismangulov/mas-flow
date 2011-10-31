/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.RackBE;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import Util.conexion;
import Util.Utilitario;
import java.sql.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author victor
 */
public class RackDA {
    
    conexion objConexion;
    Utilitario objUtilitario;
    String query;
    ResultSet rs;
    ArrayList<RackBE> arrRacks;
    RackBE objRackBE;
    
    public void insertar(RackBE objRack){
        
        objConexion = new conexion();
        objUtilitario = new Utilitario();
        
        try {
            objRack.setIdRack(objUtilitario.generaCodigo("Rack", 6));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RackDA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RackDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        objRack.setIdentificador(generaIdentificador(objRack.getIdZona()));
        
        query = "INSERT INTO RACK(idRack,posX,posY,pisos,columnas,indActivo,idZona,identificador) VALUES('"
                        +objRack.getIdRack()+"','"
                        +String.valueOf(objRack.getPosX())+"','"
                        +String.valueOf(objRack.getPosY())+"','"
                        +String.valueOf(objRack.getPisos())+"','"
                        +String.valueOf(objRack.getColumnas())+"','"
                        +objRack.getIndActivo()+"','"
                        +objRack.getIdZona()+"','"
                        +objRack.getIdentificador()+"')";
        
        try{
            objConexion.EjecutarUID(query);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
        }
        finally{objConexion.SalirUID();}
    }
    
    public void modificar(RackBE objRack, boolean cambioZona){
        
        objConexion = new conexion();
        
        if (cambioZona)
            objRack.setIdentificador(generaIdentificador(objRack.getIdZona()));
        
        
        query = "UPDATE RACK set posX = '"+String.valueOf(objRack.getPosX())+"', "
                                + "posY='"+String.valueOf(objRack.getPosY())+"', "
//                                + "pisos = '"+String.valueOf(objRack.getPisos())+"',"
//                                + "columnas ='"+String.valueOf(objRack.getColumnas())+"', "
                                + "indActivo = '" +objRack.getIndActivo()+ "',"
                                + "idZona ='"+objRack.getIdZona()+"',"
                                + "identificador='"+objRack.getIdentificador()+"'"
                                + " WHERE idRack = '"+objRack.getIdRack()+"'";
            
        try{
            objConexion.EjecutarUID(query);
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo modificar la modificacion", "Error", 0);
        }finally{
            objConexion.SalirUID();
        }
    }
        
    public void eliminar(String idRack){

        objConexion = new conexion();
        query = "DELETE FROM RACK WHERE idRack ='"+idRack+"'";
        try{
            objConexion.EjecutarUID(query);
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro", "Error", 0);
        }finally{
            objConexion.SalirUID();
        }
    }
    
    public String generaIdentificador(String idZona){
        
        objConexion = new conexion();
        query = "SELECT MAX(substr(identificador,length(identificador)-2,3)) FROM RACK WHERE idZona = '"+ idZona +"'";
        rs = objConexion.EjecutarS(query);
        String strMaxId = null;
        String strNombreZona = null;
        String strIdentificador;
        int intCantidadCaracteres;
        int intMaxId;
        
        try{
            rs.next();
            strMaxId = rs.getString(1);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
        } finally{
            objConexion.SalirS();
        }
        
        if (strMaxId != null){
            intMaxId = Integer.valueOf(strMaxId);
            intMaxId++;
            strMaxId = String.valueOf(intMaxId);
        
            while (strMaxId.length() < 3)
                strMaxId = "0" + strMaxId;
            
           query = "SELECT substr(identificador,1,length(identificador)-"
                   + "length(substr(identificador,length(identificador)-2,3))) FROM RACK WHERE idZona = '"+ idZona +"'";
            
        }else{
            strMaxId = "001";
            query = "SELECT TRIM(nombre) FROM ZONA WHERE idZona ='" + idZona + "'";
        }
        rs = objConexion.EjecutarS(query);

        try{
            rs.next();
            strNombreZona = rs.getString(1);
            if (strMaxId.equals("001"))
                strNombreZona = strNombreZona + "-";
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
        } finally{
            objConexion.SalirS();
        }
        return strNombreZona + strMaxId;
    }
    
    public RackBE queryByIdRack(String idRack){
        
        objConexion = new conexion();
        String query = "SELECT * FROM RACK WHERE IDRACK = '" + idRack + "'";
        rs =objConexion.EjecutarS(query);
        objRackBE = null;
        try {
            rs.next();
            String strIdRack = rs.getString("IdRack");
                int posX = rs.getInt("PosX");
                int posY = rs.getInt("PosY");
                int intPisos = rs.getInt("Pisos");
                int intColumnas = rs.getInt("Columnas");
                String strIndActivo = rs.getString("IndActivo");
                String strIdZona = rs.getString("IdZona");
                String strIdentificador = rs.getString("Identificador");
                objRackBE = new RackBE(strIdRack,posX,posY,intPisos,intColumnas,strIndActivo,strIdZona,strIdentificador);
                
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConexion.SalirS();
        }
        return objRackBE;
        
    }   
    
    public ArrayList<RackBE> queryAllActivo(){
        
        objConexion = new conexion();
        query = "SELECT * FROM RACK WHERE indActivo = '1'";
        rs = objConexion.EjecutarS(query);
        arrRacks = new ArrayList<RackBE>();
        try {
            while (rs.next()) {
                String strIdRack = rs.getString("IdRack");
                int intPosX = rs.getInt("PosX");
                int intPosY = rs.getInt("PosY");
                int intPisos = rs.getInt("Pisos");
                int intColumnas = rs.getInt("Columnas");
                String strIndActivo = rs.getString("IndActivo");
                String strIdZona = rs.getString("IdZona");
                String strIdentificador = rs.getString("Identificador");                
                arrRacks.add(new RackBE(strIdRack,intPosX,intPosY,intPisos,intColumnas,strIndActivo,strIdZona, strIdentificador));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConexion.SalirS();
        }
        return arrRacks;
        
    } 
    
    public ArrayList<RackBE> queryListSearch(String idAlmacen, String idRack, String idZona, String indActivos) {
        
        objConexion = new conexion();
        //SELECT r.idrack, r.posx, r.posy, r.pisos, r.columnas, r.indactivo, r.idzona, r.identificador FROM RACK r, ZONA z 
        //WHERE r.idzona = z.idzona AND z.idAlmacen = '000001' AND r.indActivo ='1'
        query = "SELECT r.idrack, r.posx, r.posy, r.pisos, r.columnas, r.indactivo, r.idzona, r.identificador"
                + " FROM RACK r, ZONA z WHERE r.idzona = z.idzona AND z.idAlmacen = '" + idAlmacen + "' AND r.indActivo ='" +indActivos+"'";

        if (!idRack.equals(""))
            query = query + " AND r.idRack LIKE '%" + idRack + "%'";
        
        
        if (!idZona.equals(""))
                query = query + " AND z.idZona LIKE '%" + idZona + "%'";
        

        rs = objConexion.EjecutarS(query);
        arrRacks = new ArrayList<RackBE>();
        try {
            while (rs.next()) {
                String strIdRack = rs.getString("IdRack");
                int intPosX = rs.getInt("PosX");
                int intPosY = rs.getInt("PosY");
                int intPisos = rs.getInt("Pisos");
                int intColumnas = rs.getInt("Columnas");
                String strIndActivo = rs.getString("IndActivo");
                String strIdZona = rs.getString("IdZona");
                String strIdentificador = rs.getString("Identificador");
                arrRacks.add(new RackBE(strIdRack,intPosX,intPosY,intPisos,intColumnas,strIndActivo,strIdZona,strIdentificador));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConexion.SalirS();
        }
        return arrRacks;
    }

    public RackBE queryRackByUbicacion(String strIdUbicacion) {
        
        objConexion = new conexion();
        query = "SELECT a.idRack, a.posx, a.posy, a.pisos, a.columnas, a.indActivo, a.idZona, a.identificador FROM RACK a, UBICACION b WHERE a.indActivo = '1' AND a.idRack = b.idRack AND b.idUbicacion = '" +strIdUbicacion+"'";
        rs = objConexion.EjecutarS(query);
        
        try {
            rs.next();
            String strIdRack = rs.getString("IdRack");
            int intPosX = rs.getInt("PosX");
            int intPosY = rs.getInt("PosY");
            int intPisos = rs.getInt("Pisos");
            int intColumnas = rs.getInt("Columnas");
            String strIndActivo = rs.getString("IndActivo");
            String strIdZona = rs.getString("IdZona");
            String strIdentificador = rs.getString("Identificador");
            objRackBE = new RackBE(strIdRack,intPosX,intPosY,intPisos,intColumnas,strIndActivo,strIdZona,strIdentificador);
        
        } catch (SQLException ex) {
            Logger.getLogger(RackDA.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConexion.SalirS();
        }
        
        return objRackBE;
    }

    public RackBE queryRackByIdentificador(String identificador) {

        objConexion = new conexion();
        query = "SELECT * FROM RACK WHERE indActivo ='1' AND identificador ='"+identificador +"'";
        rs = objConexion.EjecutarS(query);
        
        try {
            rs.next();
            String strIdRack = rs.getString("IdRack");
            int intPosX = rs.getInt("PosX");
            int intPosY = rs.getInt("PosY");
            int intPisos = rs.getInt("Pisos");
            int intColumnas = rs.getInt("Columnas");
            String strIndActivo = rs.getString("IndActivo");
            String strIdZona = rs.getString("IdZona");
            String strIdentificador = rs.getString("Identificador");
            objRackBE = new RackBE(strIdRack,intPosX,intPosY,intPisos,intColumnas,strIndActivo,strIdZona,strIdentificador);
        
        } catch (SQLException ex) {
            Logger.getLogger(RackDA.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConexion.SalirS();
        }
        
        return objRackBE;
  
    }

    public ArrayList<RackBE> queryRackByZona(String idZona) {
                objConexion = new conexion();
        query = "SELECT * FROM RACK WHERE indActivo = '1' AND idZona ='" +idZona+"'";
        rs = objConexion.EjecutarS(query);
        arrRacks = new ArrayList<RackBE>();
        try {
            while (rs.next()) {
                String strIdRack = rs.getString("IdRack");
                int intPosX = rs.getInt("PosX");
                int intPosY = rs.getInt("PosY");
                int intPisos = rs.getInt("Pisos");
                int intColumnas = rs.getInt("Columnas");
                String strIndActivo = rs.getString("IndActivo");
                String strIdZona = rs.getString("IdZona");
                String strIdentificador = rs.getString("Identificador");
                arrRacks.add(new RackBE(strIdRack,intPosX,intPosY,intPisos,intColumnas,strIndActivo,strIdZona,strIdentificador));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConexion.SalirS();
        }
        return arrRacks;
        
    }
    
    
    
}
