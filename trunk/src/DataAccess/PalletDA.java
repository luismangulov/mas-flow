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
        
        query = "INSERT INTO PALLET(idPallet,idProducto,indActivo,idUbicacion,idAlmacen,fechaVencimiento) VALUES("
                + "'" +objPallet.getIdPallet()+"',"
                + "'" +objPallet.getIdProducto()+"',"
                + "'" +objPallet.getIndActivo()+"',"
                + "'" +objPallet.getIdUbicacion()+"',"
                + "'" +objPallet.getIdAlmacen()+"',"
                +objPallet.getFechaVencimiento()+")";
                                
        try{
            objConexion.EjecutarUID(query);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
        }
        finally{objConexion.SalirUID();}
    }
    
//    public void modificar(PalletBE objPallet){
//
//    }
        
    public void eliminar(String idPallet){

        objConexion = new conexion();
        query = "DELETE FROM PALLET WHERE idPallet ='" + idPallet + "'";
        
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
            String strIdUbicacion = rs.getString("idUbicacion");
            String strIdAlmacen = rs.getString("idAlmacen");
            Date dateFechaVencimiento = rs.getDate("FechaVencimiento");
            
            objPalletBE = new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento);
                
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objPalletBE;
        
    }   
    
    public ArrayList<PalletBE> queryByAlmacenAllPalletsDisponibles(String idAlmacen){
        
        objConexion = new conexion();
        query = "SELECT * FROM Pallet WHERE indActivo = '0' AND idAlmacen ='" + idAlmacen + "'";
        rs = objConexion.EjecutarS(query);
        arrPallets = new ArrayList<PalletBE>();
        try {
            while (rs.next()) {
                
            String strIdPallet = rs.getString("IdPallet");
            String strIdProducto = rs.getString("IdProducto");
            String strIndActivo= rs.getString("IndActivo");
            String strIdUbicacion = rs.getString("idUbicacion");
            String strIdAlmacen = rs.getString("idAlmacen");
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
            String strIdUbicacion = rs.getString("idUbicacion");
            String strIdAlmacen = rs.getString("idAlmacen");
            Date dateFechaVencimiento = rs.getDate("FechaVencimiento");
            
            arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento));
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        return arrPallets;
        
    } 
    
    public ArrayList<PalletBE> queryListSearch(String idPallet, String idProducto, String idAlmacen) {
        
        boolean flagIdRack = false;
        objConexion = new conexion();
        
        query = "SELECT * FROM PALLET WHERE indActivo ='1' AND idAlmacen ='" +idAlmacen+"'";

        if (!idPallet.equals("")){
            query = query + " AND idPallet LIKE '%" + idPallet + "%'";
        }
        if (!idProducto.equals(""))
            query = query + " AND idProducto LIKE '%" + idProducto + "%'";

        rs = objConexion.EjecutarS(query);
        arrPallets = new ArrayList<PalletBE>();
        
        Date dateFechaVencimiento = null;
        
        try {
            while (rs.next()) {
                
                String strIdPallet = rs.getString("IdPallet");
                String strIdProducto = rs.getString("IdProducto");
                String strIndActivo= rs.getString("IndActivo");
                String strIdUbicacion = rs.getString("idUbicacion");
                String strIdAlmacen = rs.getString("idAlmacen");
                if (rs.getDate("FechaVencimiento") != null)
                    dateFechaVencimiento = rs.getDate("FechaVencimiento");
                
                arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrPallets;
    }

    public PalletBE queryByIdUbicacion(String idUbicacion) {
        
        objConexion = new conexion();
        query = "SELECT * FROM Pallet WHERE idUbicacion ='" + idUbicacion + "'";
        rs = objConexion.EjecutarS(query);
        arrPallets = new ArrayList<PalletBE>();
        
        try {
            rs.next();
                
            String strIdPallet = rs.getString("IdPallet");
            String strIdProducto = rs.getString("IdProducto");
            String strIndActivo= rs.getString("IndActivo");
            String strIdUbicacion = rs.getString("idUbicacion");
            String strIdAlmacen = rs.getString("idAlmacen");
            Date dateFechaVencimiento = rs.getDate("FechaVencimiento");
            
            objPalletBE = new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento);
                       
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
            objPalletBE = null;
        }
        return objPalletBE;
        
    }

    public void reubicarPallet(String strIdPallet, String strIdUbicacionOrigen, String strIdUbicacionDestino) {
        
        boolean exito = false;
        objConexion = new conexion();
        query = "UPDATE PALLET SET idUbicacion = '" + strIdUbicacionDestino + "' WHERE idPallet ='" +strIdPallet +"'";
        
        try{
            objConexion.EjecutarUID(query);
            exito = true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
        }
        finally{objConexion.SalirUID();}
        
        objUtilitario = new Utilitario();
        String strIdHistorialPallet = "";
        
        try {
            strIdHistorialPallet = objUtilitario.generaCodigo("historialpallet", 8);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RackDA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RackDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (exito){
            
            query = "INSERT INTO HISTORIALPALLET(idHistorialPallet, idPallet, idUbicacionOrigen,idUbicacionDestino,fechamovimiento) "
                    + "VALUES('"+strIdHistorialPallet+"',"
                    + "'"+strIdPallet+"',"
                    + "'"+strIdUbicacionOrigen+"',"
                    + "'"+strIdUbicacionDestino+"',"
                    + null +")";

            try{
                objConexion.EjecutarUID(query);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
            }
            finally{objConexion.SalirUID();}
        }
    }

    public ArrayList<PalletBE> queryList() {
        objConexion = new conexion();
        
        query = "SELECT * FROM PALLET";

        rs = objConexion.EjecutarS(query);
        arrPallets = new ArrayList<PalletBE>();
        
        Date dateFechaVencimiento = null;
        
        try {
            while (rs.next()) {
                
                String strIdPallet = rs.getString("IdPallet");
                String strIdProducto = rs.getString("IdProducto");
                String strIndActivo= rs.getString("IndActivo");
                String strIdUbicacion = rs.getString("idUbicacion");
                String strIdAlmacen = rs.getString("idAlmacen");
                if (rs.getDate("FechaVencimiento") != null)
                    dateFechaVencimiento = rs.getDate("FechaVencimiento");
                
                arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrPallets;
    }

}
