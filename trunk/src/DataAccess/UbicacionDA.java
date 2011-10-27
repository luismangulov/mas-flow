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

    public void bloquearUbicacion(String idUbicacion, String indActivo){
        
        boolExito = false;
        objConexion = new conexion();
        if (indActivo.equals("1"))            
            query = "UPDATE UBICACION set indActivo = '0' WHERE idUbicacion = '" + idUbicacion + "'";
        else
            query = "UPDATE UBICACION set indActivo = '1' WHERE idUbicacion = '" + idUbicacion + "'";
        try{
            objConexion.EjecutarUID(query);
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
        }finally{
            objConexion.SalirUID();
        }
    }
        
//    public void desbloquearUbicacion(String idUbicacion){
//        
//        boolExito = false;
//        objConexion = new conexion();
//        query = "UPDATE UBICACION set indActivo = '1' WHERE idUbicacion = '" + idUbicacion + "'";
//        try{
//            objConexion.EjecutarUID(query);
//        } catch (Exception e){
//                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
//        }finally{
//            objConexion.SalirUID();
//        }
//    }

    public boolean eliminarUbicacionesRack(String idRack){
        boolExito = false;
        objConexion = new conexion();
        if(validaBorrarUbicaciones(idRack)){
            query = "DELETE FROM UBICACION WHERE idRack ='" + idRack + "'";
            try{
                objConexion.EjecutarUID(query);
                boolExito = true;
            } catch (Exception e){
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro", "Error", 0);
            }finally{
                objConexion.SalirUID();
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Hay ubicaciones amarradas", "Error", 0);
        return boolExito;
    }
    
    public boolean validaBorrarUbicaciones(String idRack){
        boolean boolValido = false;
        rs = null;
        objConexion = new conexion();
        query = "SELECT idUbicacion FROM UBICACION WHERE indActivo = '2' OR indActivo = '3' AND idRack ='" + idRack + "'";
        try{
            rs = objConexion.EjecutarS(query);
            rs.next();
            if (!rs.isAfterLast())
                boolValido = true;
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro", "Error", 0);
        }finally{
            objConexion.SalirS();
        }
        return boolValido;
    }
    

    public ArrayList<UbicacionBE> queryAllUbicacionActiva(){
        
        objConexion = new conexion();
        query = "SELECT * FROM UBICACION WHERE indActivo = '1'";
        rs = objConexion.EjecutarS(query);
        arrUbicaciones = new ArrayList<UbicacionBE>();
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

    public UbicacionBE queryUbicacionById(String IdUbicacion) {
        objConexion = new conexion();
        query = "SELECT * FROM UBICACION WHERE idUbicacion='"+IdUbicacion+"'";
        rs = objConexion.EjecutarS(query);
        try {
            rs.next();

                String strIdUbicacion = rs.getString("IdUbicacion");
                int fila = rs.getInt("Fila");
                int columna = rs.getInt("Columna");
                String strIndActivo = rs.getString("IndActivo");
                String idRack = rs.getString("idRack");
                objUbicacion = new UbicacionBE(strIdUbicacion,fila,columna,strIndActivo,idRack);

        } catch (SQLException ex) {
            objUbicacion = null;
        }
        return objUbicacion;
    }

    public ArrayList<UbicacionBE> queryUbicacionesByRack(String idRack) {
        objConexion = new conexion();
        query = "SELECT * FROM UBICACION WHERE indActivo = '1' AND idRack ='" +idRack+"'";
        rs = objConexion.EjecutarS(query);
        arrUbicaciones = new ArrayList<UbicacionBE>();
        try {
            while (rs.next()) {
                String strIdUbicacion = rs.getString("IdUbicacion");
                int fila = rs.getInt("Fila");
                int columna = rs.getInt("Columna");
                String strIndActivo = rs.getString("IndActivo");
                String strIdRack = rs.getString("idRack");
                arrUbicaciones.add(new UbicacionBE(strIdUbicacion,fila,columna,strIndActivo,strIdRack));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        return arrUbicaciones;
    }

    public UbicacionBE queryUbicacionByRackFilaColumna(String strIdRack, int intFila, int intColumna, String indActivo) {
        objConexion = new conexion();
        query = "SELECT * FROM UBICACION WHERE indActivo = '"+indActivo+"' AND idRack = '" +strIdRack+ 
                "' AND fila ="+intFila+" AND columna ="+intColumna+"";
        rs = objConexion.EjecutarS(query);
        try {
            rs.next();
            String strIdUbicacion = rs.getString("IdUbicacion");
            int fila = rs.getInt("Fila");
            int columna = rs.getInt("Columna");
            String strIndActivo = rs.getString("IndActivo");
            String idRack = rs.getString("idRack");
            objUbicacion = new UbicacionBE(strIdUbicacion,fila,columna,strIndActivo,idRack);
        } catch (SQLException ex) {
            Logger.getLogger(UbicacionDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objUbicacion;
    }

    public ArrayList<UbicacionBE> queryUbicacionesByZona(String strIdZona, String indActivo) {
        objConexion = new conexion();
        query = "SELECT A.idUbicacion, A.fila, A.columna, A.indActivo, A.idRack "
                + "FROM UBICACION A, RACK B WHERE A.indActivo = '"+indActivo+"' AND A.idRack = B.idRack AND B.idZona = '" + strIdZona +"'";
        rs = objConexion.EjecutarS(query);
        arrUbicaciones = new ArrayList<UbicacionBE>();
        try {
            while (rs.next()) {
                String strIdUbicacion = rs.getString("IdUbicacion");
                int fila = rs.getInt("Fila");
                int columna = rs.getInt("Columna");
                String strIndActivo = rs.getString("IndActivo");
                String strIdRack = rs.getString("idRack");
                arrUbicaciones.add(new UbicacionBE(strIdUbicacion,fila,columna,strIndActivo,strIdRack));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        return arrUbicaciones;
    }

    public ArrayList<UbicacionBE> queryUbicacionesByAlmacen(String strIdAlmacen, String indActivo) {
        objConexion = new conexion();
        //select u.idubicacion from ubicacion u, rack r, zona z 
        //where u.idrack = r.idrack and r.idzona = z.idzona and z.idalmacen = '000001'
        
        //
        query = "SELECT U.idUbicacion, U.fila, U.columna, U.indActivo, U.idRack "
                + "FROM UBICACION U, RACK R, ZONA Z "
                + "WHERE U.indActivo = '"+ indActivo +"' AND Z.idZona = R.idZona AND U.idRack = R.idRack AND Z.idAlmacen= '" + strIdAlmacen +"'";
        rs = objConexion.EjecutarS(query);
        arrUbicaciones = new ArrayList<UbicacionBE>();
        try {
            while (rs.next()) {
                String strIdUbicacion = rs.getString("IdUbicacion");
                int fila = rs.getInt("Fila");
                int columna = rs.getInt("Columna");
                String strIndActivo = rs.getString("IndActivo");
                String strIdRack = rs.getString("idRack");
                arrUbicaciones.add(new UbicacionBE(strIdUbicacion,fila,columna,strIndActivo,strIdRack));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        return arrUbicaciones;
    }

    public ArrayList<UbicacionBE> queryAll() {
        
        objConexion = new conexion();
        query = "SELECT * FROM UBICACION WHERE indActivo = '1'";
        rs = objConexion.EjecutarS(query);
        arrUbicaciones = new ArrayList<UbicacionBE>();
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
