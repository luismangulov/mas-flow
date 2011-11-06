/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

/**
 *
 * @author victor
 */
import BusinessEntity.MovimientoInternoBE;
import BusinessEntity.PalletBE;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import Util.conexion;
import Util.Utilitario;
import java.util.Date;
import java.io.IOException;
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
        
        query = "INSERT INTO PALLET(idPallet,idProducto,indActivo,idUbicacion,idAlmacen,fechaVencimiento, idNotaIngreso) VALUES("
                + "'" +objPallet.getIdPallet()+"',"
                + "'" +objPallet.getIdProducto()+"',"
                + "'" +objPallet.getIndActivo()+"',"
                + "'" +objPallet.getIdUbicacion()+"',"
                + "'" +objPallet.getIdAlmacen()+"', "
                + "'" +objPallet.getFechaVencimiento()+"',"
                + "'" +objPallet.getIdNotaIngreso()+"')";
                                
        try{
            objConexion.EjecutarUID(query);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
        }
        finally{objConexion.SalirUID();}
    }

        
    public void desechar(PalletBE objPalletBE){

        objConexion = new conexion();
        
        //se coloca la disponibilidad de la ubicacion
        query = "UPDATE UBICACION SET indactivo = '1' WHERE idubicacion = '" + objPalletBE.getIdUbicacion() + "'";
        
        try{
            objConexion.EjecutarUID(query);
        } catch (Exception e){

        }finally{
            objConexion.SalirUID();
        }
        
        //se desecha el pallet   
        query = "UPDATE PALLET SET indActivo = '3' WHERE idPallet ='" + objPalletBE.getIdPallet() + "'";
        
        try{
            objConexion.EjecutarUID(query);
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo desechar el pallet", "Error", 0);
        }finally{
            objConexion.SalirUID();
        }
        
        //se setea en 0 la ubicacion del pallet
        query = "UPDATE PALLET SET idUbicacion = '000000' WHERE idPallet ='" + objPalletBE.getIdPallet() + "'";
        
        try{
            objConexion.EjecutarUID(query);
        } catch (Exception e){

        }finally{
            objConexion.SalirUID();
        }
    }
    
    public PalletBE queryByIdPallet(String strIdPallet){
        
        objConexion = new conexion();
        String query = "SELECT * FROM PALLET WHERE IDPALLET = '" + strIdPallet + "'";
        
        rs =objConexion.EjecutarS(query);
        objPalletBE = null;
        
        try {
            rs.next();
//            String strIdPallet = rs.getString("IdPallet");
            String strIdProducto = rs.getString("IdProducto");
            String strIndActivo= rs.getString("IndActivo");
            String strIdUbicacion = rs.getString("idUbicacion");
            String strIdAlmacen = rs.getString("idAlmacen");
            Date dateFechaVencimiento = rs.getDate("FechaVencimiento");
            String strIdNotaIngreso = rs.getString("idNotaIngreso");
            
            objPalletBE = new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso);
                
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConexion.SalirS();
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
            String strIdNotaIngreso = rs.getString("idNotaIngreso");
            
            arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso));
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            objConexion.SalirS();
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
            String strIdNotaIngreso = rs.getString("idNotaIngreso");
            
            arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso));
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            objConexion.SalirS();
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
                String strIdNotaIngreso = rs.getString("idNotaIngreso");
                
                arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConexion.SalirS();
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
            String strIdNotaIngreso = rs.getString("idNotaIngreso");
            
            objPalletBE = new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso);
                       
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
            objPalletBE = null;
        } finally {
            objConexion.SalirS();
        }
        return objPalletBE;
        
    }

    public ArrayList<PalletBE> queryList() {
        objConexion = new conexion();
        
        query = "SELECT * FROM PALLET WHERE indActivo = '1'";

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
                String strIdNotaIngreso = rs.getString("idNotaIngreso");
                
                arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConexion.SalirS();
        }
        return arrPallets;
    }

    public ArrayList<PalletBE> queryPalletsByRack(String strIdRack) {
        
        objConexion = new conexion();
        
        query = "SELECT p.idPallet, p.idProducto, p.indActivo, p.idUbicacion, p.idAlmacen, p.fechaVencimiento "
                + "FROM PALLET p, UBICACION u WHERE p.indActivo = '1' AND p.idUbicacion = u.idUbicacion AND u.idrack = '" +strIdRack + "'";

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
                String strIdNotaIngreso = rs.getString("idNotaIngreso");
                
                arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConexion.SalirS();
        }
        return arrPallets;
    }

    public ArrayList<PalletBE> queryPalletsByIdZona(String strIdZona) {
        objConexion = new conexion();
        
        query = "SELECT p.idPallet, p.idProducto, p.indActivo, p.idUbicacion, p.idAlmacen, p.fechaVencimiento "
                + "FROM PALLET p, UBICACION u, RACK r, ZONA z"
                + " WHERE p.indactivo = '1' AND p.idUbicacion = u.idUbicacion AND u.idRack = r.idRack AND "
                + " r.idZona = z.idZona AND z.idZona = '" +strIdZona+"'";

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
                String strIdNotaIngreso = rs.getString("idNotaIngreso");
                
                arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConexion.SalirS();
        }
        return arrPallets;
    }

    public ArrayList<PalletBE> queryPalletsByIdAlmacen(String idAlmacen) {
       objConexion = new conexion();
        
        query = "SELECT * FROM PALLET WHERE indActivo = '1' AND idAlmacen = '" + idAlmacen + "'";

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
                String strIdNotaIngreso = rs.getString("idNotaIngreso");
                
                arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConexion.SalirS();
        }
        return arrPallets;
    }

    public ArrayList<PalletBE> queryPalletListSearch(String strIdAlmacen, String strIdZona, String strIdRack, int intFila, int intColumna, String strIdPallet, String strIdProducto) {
        
        objConexion = new conexion();        
        arrPallets = new ArrayList<PalletBE>();
        
        query = "SELECT p.idPallet, p.idProducto, p.indActivo, p.idUbicacion, p.idAlmacen, p.fechaVencimiento"
                + " FROM PALLET p, UBICACION u, RACK r, ZONA z, ALMACEN a "
                + " WHERE p.indactivo = '1' AND a.IdAlmacen = z.IdAlmacen AND z.IdZona = r.IdZona"
                + " AND u.idRack = r.idrack AND u.idubicacion = p.idubicacion";
        if (!strIdAlmacen.equals(""))
            query = query + " AND a.IdAlmacen = '" + strIdAlmacen + "'";
        
        if (!strIdZona.equals(""))
            query = query + " AND z.idZona ='" +strIdZona+"'";
        if (!strIdRack.equals(""))
            query = query + " AND r.idRack ='" +strIdRack+"'";
        if (intFila!=0 && intColumna!=0)
            query = query + " AND u.fila = " + intFila + " AND u.columna =" +intColumna + "";
        if (!strIdProducto.equals(""))
            query = query + " AND p.idProducto LIKE '%"+strIdProducto+"%'";
        if (!strIdPallet.equals(""))
            query = query + " AND p.idPallet LIKE '%"+strIdPallet+"%'";
        
        Date dateFechaVencimiento = null;
        rs = objConexion.EjecutarS(query);
        
        try{
            
            while (rs.next()){
                
                strIdPallet = rs.getString("IdPallet");
                strIdProducto = rs.getString("IdProducto");
                String strIndActivo= rs.getString("IndActivo");
                String strIdUbicacion = rs.getString("idUbicacion");
                strIdAlmacen = rs.getString("idAlmacen");
                if (rs.getDate("FechaVencimiento") != null)
                    dateFechaVencimiento = rs.getDate("FechaVencimiento");
                String strIdNotaIngreso = rs.getString("idNotaIngreso");
                
                arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso));
            }
            
            
        }catch (SQLException ex){
            
        }finally{
            objConexion.SalirS();
        }
        
        return arrPallets;
    }

}
