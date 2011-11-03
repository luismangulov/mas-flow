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
        // 0 bloqueada, 1 disponible, 2 en uso
        
        if (indActivo.equals("1"))     
            query = "UPDATE UBICACION set indActivo = '0' WHERE idUbicacion = '" + idUbicacion + "'";
        else //if (indActivo.equals("0"))
            query = "UPDATE UBICACION set indActivo = '1' WHERE idUbicacion = '" + idUbicacion + "'";
        try{
            objConexion.EjecutarUID(query);
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
        }finally{
            objConexion.SalirUID();
        }
    }

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
        }finally{
            objConexion.SalirS();
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
        }finally{
            objConexion.SalirS();
        }
        return objUbicacion;
    }

    public ArrayList<UbicacionBE> queryUbicacionesByRack(String idRack, String indActivo) {
        objConexion = new conexion();
        
        if (indActivo.equals("3"))
            query = "SELECT * FROM UBICACION WHERE idRack ='" +idRack+"'";
        else
            query = "SELECT * FROM UBICACION WHERE indActivo = '"+indActivo+"' AND idRack ='" +idRack+"'";
        
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
        }finally{
            objConexion.SalirS();
        }
        return arrUbicaciones;
    }

    public UbicacionBE queryUbicacionByRackFilaColumna(String strIdRack, int intFila, int intColumna, String indActivo) {
        objConexion = new conexion();
        
        if (indActivo.equals("3"))
            query = "SELECT * FROM UBICACION WHERE idRack = '" +strIdRack+ 
                "' AND fila ="+intFila+" AND columna ="+intColumna+"";
        else
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
            objUbicacion = null;
        }finally{
            objConexion.SalirS();
        }
        return objUbicacion;
    }

    public ArrayList<UbicacionBE> queryUbicacionesByZona(String strIdZona, String indActivo) {
        objConexion = new conexion();
        
        if (indActivo.equals("3"))
            query = "SELECT A.idUbicacion, A.fila, A.columna, A.indActivo, A.idRack "
                + "FROM UBICACION A, RACK B WHERE A.idRack = B.idRack AND B.idZona = '" + strIdZona +"'";
        else
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
        }finally{
            objConexion.SalirS();
        }
        return arrUbicaciones;
    }

    public ArrayList<UbicacionBE> queryUbicacionesByAlmacen(String strIdAlmacen, String indActivo) {
        objConexion = new conexion();

        if (indActivo.equals("3"))
            query = "SELECT U.idUbicacion, U.fila, U.columna, U.indActivo, U.idRack "
                + "FROM UBICACION U, RACK R, ZONA Z "
                + "WHERE Z.idZona = R.idZona AND U.idRack = R.idRack AND Z.idAlmacen= '" + strIdAlmacen +"'";
        else 
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
        }finally{
            objConexion.SalirS();
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
        }finally{
            objConexion.SalirS();
        }
        return arrUbicaciones;
    }
    
     public int queryCantUbicacionesLibres(String idFamilia, String idAlmacen){
       
        rs = null;
        objConexion = new conexion();
        query = "SELECT COUNT(u.idUbicacion) FROM almacen a, zona z, familia f, zonaxfamilia zxf, rack r, ubicacion u WHERE a.idalmacen = z.idalmacen ANd z.idzona = zxf.idzona AND zxf.idfamilia = f.idfamilia AND z.idzona = r.idzona AND u.idrack = r.idrack AND u.indactivo = '1'";
                query+= " AND f.idfamilia = '"+idFamilia+"' AND a.idalmacen = '"+idAlmacen+"'";
        int cantUbicacinesLibres = 0;
        try{
            rs = objConexion.EjecutarS(query);
            
            if (rs.next()){
                cantUbicacinesLibres  = rs.getInt(1);
            }
               
        } catch (Exception e){
                System.out.println(e.getMessage());
        }finally{
            objConexion.SalirS();
        }
        return cantUbicacinesLibres;
    }
     
     public int queryCantUbicacionesOcupadas(String idFamilia, String idAlmacen,String idProducto){
       
        rs = null;
        objConexion = new conexion();
        query = "SELECT COUNT(u.idUbicacion) FROM almacen a, zona z, familia f, zonaxfamilia zxf, rack r, ubicacion u, pallet p WHERE a.idalmacen = z.idalmacen ANd z.idzona = zxf.idzona AND zxf.idfamilia = f.idfamilia AND z.idzona = r.idzona AND u.idrack = r.idrack AND u.indactivo = '2' AND p.idubicacion = u.idubicacion";
                query+= " AND f.idfamilia = '"+idFamilia+"' AND p.idalmacen = '"+idAlmacen+"' AND p.idproducto = '"+idProducto+"' AND a.idalmacen = '"+idAlmacen+"'";
        int cantUbicacinesLibres = 0;
        try{
            rs = objConexion.EjecutarS(query);
            
            if (rs.next()){
                cantUbicacinesLibres  = rs.getInt(1);
            }
               
        } catch (Exception e){
                System.out.println(e.getMessage());
        }finally{
            objConexion.SalirS();
        }
        return cantUbicacinesLibres;
    }
     
     
     public int queryCantidadUbicacionesOcupadasEnRack(String strIdRack){
        
        int intCantUbicaciones = 0;
        objConexion = new conexion();
        query = "SELECT COUNT(idUbicacion) as contador FROM UBICACION WHERE indActivo = '2' OR indActivo = '0' AND idRack = '" +strIdRack + "'";
        
        rs = objConexion.EjecutarS(query);
        
        try{
            rs.next();
            intCantUbicaciones = rs.getInt("contador");
        }catch (SQLException ex){
            
        }finally{
            objConexion.SalirS();
        }
        
        return intCantUbicaciones;
    }

    public boolean queryBloquearUbicacionesByRack(String strIdRack) {
           
        boolExito = false;
        objConexion = new conexion();
        // 0 bloqueada, 1 disponible, 2 en uso

        query = "UPDATE UBICACION set indActivo = '0' WHERE idRack= '" + strIdRack + "'";
        try{
            objConexion.EjecutarUID(query);
            boolExito = true;
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                boolExito = false;
        }finally{
            objConexion.SalirUID();
        }
        return boolExito;
    }

    public boolean queryDesbloquearUbicacionesByRack(String strIdRack) {
           
        boolExito = false;
        objConexion = new conexion();
        // 0 bloqueada, 1 disponible, 2 en uso

        query = "UPDATE UBICACION set indActivo = '1' WHERE idRack= '" + strIdRack + "'";
        try{
            objConexion.EjecutarUID(query);
            boolExito = true;
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                boolExito = false;
        }finally{
            objConexion.SalirUID();
        }
        return boolExito;
    }
    
}
