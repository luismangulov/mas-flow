/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.UbicacionBE;
import Util.conexion;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Util.Utilitario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author victor
 */
public class UbicacionDA {
    
    private conexion objConexion;
    private ResultSet rs;
    private UbicacionBE objUbicacion;
    private boolean boolExito;
    private String query;
    private ArrayList<UbicacionBE> arrUbicaciones;
    
    public void insertar(UbicacionBE objUbicacionBE){
        boolExito = false;
        objConexion = new conexion();
        Utilitario objUtilitario = new Utilitario();

        try {
            objUbicacionBE.setIdUbicacion(objUtilitario.generaCodigo("Ubicacion", 6));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        }

        query = "INSERT INTO Ubicacion(idUbicacion, fila, columna,"
                + "indActivo, idRack) "
                + "VALUES('"+ objUbicacionBE.getIdUbicacion() +"','" + objUbicacionBE.getFila()
                +"','" + objUbicacionBE.getColumna() +"','" + objUbicacionBE.getIndActivo()
                +"','" + objUbicacionBE.getIdRack() + "')";

        try{
            objConexion.EjecutarUID(query);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
        }
        finally{objConexion.SalirUID();}
    }

    public void bloquearUbicacion(String idUbicacion){
        
        boolExito = false;
        objConexion = new conexion();
        query = "UPDATE UBICACION set indActivo = '0' WHERE idUbicacion = '" + idUbicacion + "'";
        try{
            objConexion.EjecutarUID(query);
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
        }finally{
            objConexion.SalirUID();
        }
    }
        
    public void desbloquearUbicacion(String idUbicacion){
        
        boolExito = false;
        objConexion = new conexion();
        query = "UPDATE UBICACION set indActivo = '1' WHERE idUbicacion = '" + idUbicacion + "'";
        try{
            objConexion.EjecutarUID(query);
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
        }finally{
            objConexion.SalirUID();
        }
    }

    public void eliminarUbicacionesRack(String idRack) {
        boolExito = false;
        objConexion = new conexion();
        query = "DELETE UBICACION WHERE idRack ='" + idRack + "'";
        try{
            objConexion.EjecutarUID(query);
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro", "Error", 0);
        }finally{
            objConexion.SalirUID();
        }
    }

    public ArrayList<UbicacionBE> queryAllUbicacionActiva(){
        
        objConexion = new conexion();
        query = "SELECT * FROM UBICACION WHERE indActivo = '1'";
        rs = objConexion.EjecutarS(query);
        try {
            while (rs.next()) {
                String strIdUbicacion = rs.getString("IdUbicacion");
                int fila = rs.getInt("Fila");
                int columna = rs.getInt("Columna");
                String strIndActivo = rs.getString("IndActivo");
                String idRack = rs.getString("idRack");
                arrUbicaciones.add(new UbicacionBE(strIdUbicacion,fila,columna,strIndActivo,idRack));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        return arrUbicaciones;
    }
    
}
