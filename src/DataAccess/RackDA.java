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
        
        query = "INSERT INTO RACK(idRack,alto,ancho,pisos,columnas,indActivo,idZona) VALUES('"
                        +objRack.getIdRack()+"','"
                        +String.valueOf(objRack.getAlto())+"','"
                        +String.valueOf(objRack.getAncho())+"','"
                        +String.valueOf(objRack.getPisos())+"','"
                        +String.valueOf(objRack.getColumnas())+"','"
                        +objRack.getIndActivo()+"','"
                        +objRack.getIdZona()+"')";
        
        try{
            objConexion.EjecutarUID(query);
            JOptionPane.showMessageDialog(null, "El registro fue exitoso", "Éxito", 0);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
        }
        finally{objConexion.SalirUID();}
    }
    
    public void modificar(RackBE objRack){
        
        objConexion = new conexion();
        query = "UPDATE RACK set alto = '"+String.valueOf(objRack.getAlto())+"', "
                                + "ancho='"+String.valueOf(objRack.getAncho())+"', "
                                + "pisos = '"+String.valueOf(objRack.getPisos())+"',"
                                + "columnas ='"+String.valueOf(objRack.getColumnas())+"', "
                                + "indActivo = '" +objRack.getIndActivo()+ "',"
                                + "idZona ='"+objRack.getIdZona()+"'";
        try{
            objConexion.EjecutarUID(query);
            JOptionPane.showMessageDialog(null, "La modificación fue exitosa", "Éxito", 0);   
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo modificar el registro", "Error", 0);
        }finally{
            objConexion.SalirUID();
        }
    }
        
    public void eliminar(String idRack){

        objConexion = new conexion();
        query = "UPDATE RACK set indActivo = '0' WHERE idRack ='"+idRack+"'";
        try{
            objConexion.EjecutarUID(query);
            JOptionPane.showMessageDialog(null, "La eliminación fue exitosa", "Éxito", 0);
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro", "Error", 0);
        }finally{
            objConexion.SalirUID();
        }
    }
    
    public RackBE queryByIdRack(String idRack){
        
        objConexion = new conexion();
        String query = "SELECT * FROM RACK WHERE IDRACK = '" + idRack + "'";
        rs =objConexion.EjecutarS(query);
        objRackBE = null;
        try {
            rs.next();
            String strIdRack = rs.getString("IdRack");
                Double douAlto = rs.getDouble("Alto");
                Double douAncho = rs.getDouble("Ancho");
                int intPisos = rs.getInt("Pisos");
                int intColumnas = rs.getInt("Columnas");
                String strIndActivo = rs.getString("IndActivo");
                String strIdZona = rs.getString("IdZona");
                objRackBE = new RackBE(strIdRack,douAlto,douAncho,intPisos,intColumnas,strIndActivo,strIdZona);
                
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
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
                Double douAlto = rs.getDouble("Alto");
                Double douAncho = rs.getDouble("Ancho");
                int intPisos = rs.getInt("Pisos");
                int intColumnas = rs.getInt("Columnas");
                String strIndActivo = rs.getString("IndActivo");
                String strIdZona = rs.getString("IdZona");
                arrRacks.add(new RackBE(strIdRack,douAlto,douAncho,intPisos,intColumnas,strIndActivo,strIdZona));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrRacks;
        
    } 
    
    public ArrayList<RackBE> queryListSearch(String idRack, String idZona) {
        
        boolean flagIdRack = false;
        objConexion = new conexion();
        query = "SELECT * FROM RACK WHERE indActivo ='1'";

        if (!idRack.equals("")){
            query = query + " AND idRack LIKE '%" + idRack + "%'";
        }
        if (!idZona.equals(""))
            query = query + " AND idZona LIKE '%" + idZona + "%'";

        rs = objConexion.EjecutarS(query);
        arrRacks = new ArrayList<RackBE>();
        try {
            while (rs.next()) {
                String strIdRack = rs.getString("IdRack");
                Double douAlto = rs.getDouble("Alto");
                Double douAncho = rs.getDouble("Ancho");
                int intPisos = rs.getInt("Pisos");
                int intColumnas = rs.getInt("Columnas");
                String strIndActivo = rs.getString("IndActivo");
                String strIdZona = rs.getString("IdZona");
                arrRacks.add(new RackBE(strIdRack,douAlto,douAncho,intPisos,intColumnas,strIndActivo,strIdZona));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrRacks;
    }
}
