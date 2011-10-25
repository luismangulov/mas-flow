/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

/**
 *
 * @author victor
 */
import BusinessEntity.PalletBE;
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

public class PalletDA {
    
    conexion objConexion;
    Utilitario objUtilitario;
    ResultSet rs;
    String query;
    PalletBE objPalletBE;
    ArrayList<PalletBE> arrPallets;
    
    public void insertar(PalletBE objPallet){
        
        objConexion = new conexion();
        objUtilitario = new Utilitario();
        
        try {
            objPallet.setIdPallet(objUtilitario.generaCodigo("Pallet", 6));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RackDA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RackDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        query = "INSERT INTO PALLET(idPallet,idProducto,indActivo,idUbicacion,idAlmacen,fechaVencimiento) VALUES('"
                        +objPallet.getIdPallet()+"','"
                        +objPallet.getIdProducto()+"','"
                        +objPallet.getIdUbicacion()+"','"
                        +objPallet.getIdAlmacen()+"','"
                        +objPallet.getFechaVencimiento()+"')";
                                
        try{
            objConexion.EjecutarUID(query);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
        }
        finally{objConexion.SalirUID();}
    }
    
//    public void modificar(PalletBE objPallet){
//        
//        objConexion = new conexion();
//        query = "UPDATE PALLET set indActivo = '"+String.valueOf(objRack.getPosX())+"', "
//                                + "posY='"+String.valueOf(objRack.getPosY())+"', "
//                                + "pisos = '"+String.valueOf(objRack.getPisos())+"',"
//                                + "columnas ='"+String.valueOf(objRack.getColumnas())+"', "
//                                + "indActivo = '" +objRack.getIndActivo()+ "',"
//                                + "idZona ='"+objRack.getIdZona()+"'";
//        try{
//            objConexion.EjecutarUID(query);
//            JOptionPane.showMessageDialog(null, "La modificación fue exitosa", "Éxito", 0);   
//        } catch (Exception e){
//                JOptionPane.showMessageDialog(null, "No se pudo modificar el registro", "Error", 0);
//        }finally{
//            objConexion.SalirUID();
//        }
//    }
        
    public void eliminar(String idPallet){

        objConexion = new conexion();
        query = "DELETE PALLET WHERE idPallet ='" + idPallet + "'";
        
        try{
            objConexion.EjecutarUID(query);
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro", "Error", 0);
        }finally{
            objConexion.SalirUID();
        }
        
    }
    
//    public String obtieneMaxIdentificador(String idZona){
//        
//        objConexion = new conexion();
//        query = "SELECT MAX(substr(identificador,length(identificador)-2,3)) FROM RACK WHERE idZona = '"+ idZona +"'";
//        rs = objConexion.EjecutarS(query);
//        String strMaxId = null;
//        
//        try{
//            rs.next();
//            strMaxId = rs.getString(0);
//        } catch (SQLException e){
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
//        } finally{
//            objConexion.SalirS();
//        }
//        return strMaxId;   
//    }
    
    public PalletBE queryByIdPallet(String idPallet){
        
        objConexion = new conexion();
        String query = "SELECT * FROM PALLET WHERE IDPALLET = '" + idPallet + "'";
        
        rs =objConexion.EjecutarS(query);
        objPalletBE = null;
        
        try {
            rs.next();
            String strIdPallet = rs.getString("IdPallet");
            String strIdProducto = rs.getString("IdProducto");
            String strIndActivo= rs.getString("IndActivo");
            String strIdUbicacion = rs.getString("Ubicacion");
            String strIdAlmacen = rs.getString("Almacen");
            Date dateFechaVencimiento = rs.getDate("FechaVencimiento");
            
            objPalletBE = new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento);
                
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objPalletBE;
        
    }   
    
    public ArrayList<PalletBE> queryByAlmacenAllPalletsDisponibles(String idAlmacen){
        
        objConexion = new conexion();
        query = "SELECT * FROM Pallet WHERE idAlmacen ='" + idAlmacen + "'";
        rs = objConexion.EjecutarS(query);
        arrPallets = new ArrayList<PalletBE>();
        try {
            while (rs.next()) {
                
            String strIdPallet = rs.getString("IdPallet");
            String strIdProducto = rs.getString("IdProducto");
            String strIndActivo= rs.getString("IndActivo");
            String strIdUbicacion = rs.getString("Ubicacion");
            String strIdAlmacen = rs.getString("Almacen");
            Date dateFechaVencimiento = rs.getDate("FechaVencimiento");
            
            arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento));
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        return arrPallets;
        
    } 
    
    public ArrayList<PalletBE> queryByAlmacenAllPallets(String idAlmacen){
        
        objConexion = new conexion();
        query = "SELECT * FROM Pallet WHERE idAlmacen ='" + idAlmacen + "'";
        rs = objConexion.EjecutarS(query);
        arrPallets = new ArrayList<PalletBE>();
        try {
            while (rs.next()) {
                
            String strIdPallet = rs.getString("IdPallet");
            String strIdProducto = rs.getString("IdProducto");
            String strIndActivo= rs.getString("IndActivo");
            String strIdUbicacion = rs.getString("Ubicacion");
            String strIdAlmacen = rs.getString("Almacen");
            Date dateFechaVencimiento = rs.getDate("FechaVencimiento");
            
            arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento));
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        return arrPallets;
        
    } 
    

    
//    public ArrayList<PalletBE> queryListSearch(String idRack, String idZona) {
//        
//        boolean flagIdRack = false;
//        objConexion = new conexion();
//        query = "SELECT * FROM RACK WHERE indActivo ='1'";
//
//        if (!idRack.equals("")){
//            query = query + " AND idRack LIKE '%" + idRack + "%'";
//        }
//        if (!idZona.equals(""))
//            query = query + " AND idZona LIKE '%" + idZona + "%'";
//
//        rs = objConexion.EjecutarS(query);
//        arrRacks = new ArrayList<RackBE>();
//        try {
//            while (rs.next()) {
//                String strIdRack = rs.getString("IdRack");
//                int intPosX = rs.getInt("PosX");
//                int intPosY = rs.getInt("PosY");
//                int intPisos = rs.getInt("Pisos");
//                int intColumnas = rs.getInt("Columnas");
//                String strIndActivo = rs.getString("IndActivo");
//                String strIdZona = rs.getString("IdZona");
//                arrRacks.add(new RackBE(strIdRack,intPosX,intPosY,intPisos,intColumnas,strIndActivo,strIdZona, ""));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return arrRacks;
//    }
    
}
