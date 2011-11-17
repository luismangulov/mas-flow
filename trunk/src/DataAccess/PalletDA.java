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
        //query = "INSERT INTO PALLET(idPallet,idNotaIngreso,idProducto,idUbicacion,idAlmacen,indActivo,fechaVencimiento,idGuiaRemision) VALUES("
        query = "INSERT INTO PALLET(idPallet,idNotaIngreso,idProducto,idUbicacion,idAlmacen,indActivo,fechaVencimiento) VALUES("
                + "'" +objPallet.getIdPallet()+"',"
                + "'" +objPallet.getIdNotaIngreso()+"',"
                + "'" +objPallet.getIdProducto()+"',"
                + "'" +objPallet.getIdUbicacion()+"',"
                + "'" +objPallet.getIdAlmacen()+"', "
                + "'" +objPallet.getIndActivo()+"',"
                + "'" +objPallet.getFechaVencimiento()+"')";
//                + "'" +objPallet.getIdGuiaRemision()+"')";
                                
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
        query = "UPDATE PALLET SET idUbicacion = " + null + " WHERE idPallet ='" + objPalletBE.getIdPallet() + "'";
        
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
            strIdPallet = rs.getString("IdPallet");
            String strIdProducto = rs.getString("IdProducto");
            String strIndActivo= rs.getString("IndActivo");
            String strIdUbicacion = rs.getString("idUbicacion");
            String strIdAlmacen = rs.getString("idAlmacen");
            Date dateFechaVencimiento = rs.getDate("FechaVencimiento");
            String strIdNotaIngreso = rs.getString("idNotaIngreso");
            String strIdGuiaRemision = "";
            if (rs.getObject("idGuiaRemision") != null)
                strIdGuiaRemision = rs.getString("idGuiaRemision");
            
            objPalletBE = new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso,strIdGuiaRemision);
                
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
            String strIdGuiaRemision = "";
            if (rs.getObject("idGuiaRemision")!= null)
                strIdGuiaRemision = rs.getString("idGuiaRemision");
            
            arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso,strIdGuiaRemision));
            
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
            String strIdGuiaRemision = "";
            if (rs.getObject("idGuiaRemision")!= null)
                strIdGuiaRemision = rs.getString("idGuiaRemision");
            
            arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso,strIdGuiaRemision));
            
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
                String strIdGuiaRemision = "";
                if (rs.getObject("idGuiaRemision")!= null)
                    strIdGuiaRemision = rs.getString("idGuiaRemision");;
                
                arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso,strIdGuiaRemision));
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
        query = "SELECT * FROM Pallet WHERE indActivo = '1' AND idUbicacion ='" + idUbicacion + "'";
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
            String strIdGuiaRemision = "";
            if (rs.getObject("idGuiaRemision")!= null)
                strIdGuiaRemision = rs.getString("idGuiaRemision");
            
            objPalletBE = new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso,strIdGuiaRemision);
                       
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
                String strIdGuiaRemision = "";
                if (rs.getObject("idGuiaRemision")!= null)
                    strIdGuiaRemision = rs.getString("idGuiaRemision");
                
                arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso,strIdGuiaRemision));
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
                String strIdGuiaRemision = "";
                if (rs.getObject("idGuiaRemision")!= null)
                    strIdGuiaRemision = rs.getString("idGuiaRemision");
                
                arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso,strIdGuiaRemision));
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
                String strIdGuiaRemision = "";
                if (rs.getObject("idGuiaRemision")!= null)
                    strIdGuiaRemision = rs.getString("idGuiaRemision");
                
                arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso,strIdGuiaRemision));
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
                String strIdGuiaRemision = "";
                if (rs.getObject("idGuiaRemision")!= null)
//                Object obj =rs.getObject("idGuiaRemision");
//                if (obj != null)
                    strIdGuiaRemision = rs.getString("idGuiaRemision");
                
                arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso,strIdGuiaRemision));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConexion.SalirS();
        }
        return arrPallets;
    }

    public ArrayList<PalletBE> queryPalletListSearch(String strIdAlmacen, String strIdZona, String strIdRack, int intFila, int intColumna, String strIdPallet, String strNombreProducto) {
        
        objConexion = new conexion();        
        arrPallets = new ArrayList<PalletBE>();
        
        query = "SELECT p.idPallet, p.idProducto, p.indActivo, p.idUbicacion, p.idAlmacen, p.fechaVencimiento, p.idnotaingreso, p.idguiaremision"
                + " FROM PRODUCTO pr, PALLET p, UBICACION u, RACK r, ZONA z, ALMACEN a "
                + " WHERE p.indactivo = '1' AND a.IdAlmacen = z.IdAlmacen AND z.IdZona = r.IdZona"
                + " AND u.idRack = r.idrack AND u.idubicacion = p.idubicacion AND pr.idProducto = p.idProducto";
        
        if (!strIdAlmacen.equals(""))
            query = query + " AND a.IdAlmacen = '" + strIdAlmacen + "'";
        
        if (!strIdZona.equals(""))
            query = query + " AND z.idZona ='" +strIdZona+"'";
        
        if (!strIdRack.equals(""))
            query = query + " AND r.idRack ='" +strIdRack+"'";
        
        if (intFila!=0 && intColumna!=0)
            query = query + " AND u.fila = " + intFila + " AND u.columna =" +intColumna + "";
        
        if (!strNombreProducto.equals(""))
            query = query + " AND pr.nombre LIKE '%"+strNombreProducto+"%'";
        
        if (!strIdPallet.equals(""))
            query = query + " AND p.idPallet LIKE '%"+strIdPallet+"%'";
        
        Date dateFechaVencimiento = null;
        String strIdNotaIngreso = "";
        rs = objConexion.EjecutarS(query);
        
        try{
            
            while (rs.next()){
                
                strIdPallet = rs.getString("IdPallet");
                String strIdProducto = rs.getString("IdProducto");
                String strIndActivo= rs.getString("IndActivo");
                String strIdUbicacion = rs.getString("idUbicacion");
                strIdAlmacen = rs.getString("idAlmacen");
                if (rs.getObject("FechaVencimiento") != null)
                    dateFechaVencimiento = rs.getDate("FechaVencimiento");
                strIdNotaIngreso = rs.getString("idNotaIngreso");
                String strIdGuiaRemision = "";
                if (rs.getObject("idGuiaRemision")!= null)
                    strIdGuiaRemision = rs.getString("idGuiaRemision");
                
                arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso,strIdGuiaRemision));
            }
            
            
        }catch (SQLException ex){
            
        }finally{
            objConexion.SalirS();
        }
        
        return arrPallets;
    }

    public ArrayList<PalletBE> queryPalletByIdNotaIngreso(String strIdNotaIngreso) {
                
        objConexion = new conexion();        
        arrPallets = new ArrayList<PalletBE>();
        
        query = "SELECT * FROM PALLET WHERE idNotaIngreso = '" +strIdNotaIngreso + "'";
        
        Date dateFechaVencimiento = null;
        rs = objConexion.EjecutarS(query);
        
        try{
            
            while (rs.next()){
                
                String strIdPallet = rs.getString("IdPallet");
                String strIdProducto = rs.getString("IdProducto");
                String strIndActivo= rs.getString("IndActivo");
                String strIdUbicacion = rs.getString("idUbicacion");
                String strIdAlmacen = rs.getString("idAlmacen");
                if (rs.getObject("FechaVencimiento") != null)
                    dateFechaVencimiento = rs.getDate("FechaVencimiento");
                strIdNotaIngreso = rs.getString("idNotaIngreso");
                String strIdGuiaRemision = "";
                if (rs.getObject("idGuiaRemision")!= null)
                    strIdGuiaRemision = rs.getString("idGuiaRemision");
                
                arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso,strIdGuiaRemision));
            }
            
            
        }catch (SQLException ex){
            
        }finally{
            objConexion.SalirS();
        }
        
        return arrPallets;
    }
    
    public boolean liberarPallet(String strIdPallet) {
        
        boolean exito = false;
        objConexion = new conexion();
        
        // se setea la disponibilidad "1" de la ubicacion anterior
        query = "UPDATE UBICACION SET indActivo = '1' WHERE idUbicacion = '" + strIdPallet + "'";
        
        try{
            objConexion.EjecutarUID(query);
            exito = true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
            exito = false;
        }
        finally{objConexion.SalirUID();}
        
        return exito;
    }
    
    public boolean asociarUbicacionAPallet(String strIdPallet, String strIdUbicacion){
        
        boolean exito = false;
        objConexion = new conexion();
        // se asocia el pallet a la ubicacion destino
        query = "UPDATE PALLET SET idUbicacion = '" + strIdUbicacion + "' WHERE idPallet ='" + strIdPallet+"'";

        try{
            objConexion.EjecutarUID(query);
            exito = true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
            exito = false;
        }
        finally{objConexion.SalirUID();}
        
        return exito;

    }

    public boolean despacharPallet(String strIdPallet) {
        boolean exito = false;
        objConexion = new conexion();
        // se cambia el estado de la ubicacion destino a en uso
        query = "UPDATE PALLET SET indActivo = '2' WHERE idPallet ='" + strIdPallet +"'";

        try{
            objConexion.EjecutarUID(query);
            exito = true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
            exito = false;
        }
        finally{objConexion.SalirUID();}

        return exito;
    }

    public boolean asociarGuiaRemision(String strIdPallet, String strIdGuiaRemision) {
        boolean exito = false;
        objConexion = new conexion();
        // se cambia el estado de la ubicacion destino a en uso
        query = "UPDATE PALLET SET idGuiaRemision = '" + strIdGuiaRemision + "' WHERE idPallet ='" + strIdPallet +"'";

        try{
            objConexion.EjecutarUID(query);
            exito = true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
            exito = false;
        }
        finally{objConexion.SalirUID();}

        return exito;
    }
    
        public ArrayList<PalletBE> queryPalletByIdGuiaRemision(String strIdGuiaRemision) {
                
        objConexion = new conexion();        
        arrPallets = new ArrayList<PalletBE>();
        
        query = "SELECT * FROM PALLET WHERE idGuiaRemision = '" +strIdGuiaRemision + "'";
        
        Date dateFechaVencimiento = null;
        rs = objConexion.EjecutarS(query);
        
        try{
            
            while (rs.next()){
                
                String strIdPallet = rs.getString("IdPallet");
                String strIdProducto = rs.getString("IdProducto");
                String strIndActivo= rs.getString("IndActivo");
                String strIdUbicacion = rs.getString("idUbicacion");
                String strIdAlmacen = rs.getString("idAlmacen");
                if (rs.getObject("FechaVencimiento") != null)
                    dateFechaVencimiento = rs.getDate("FechaVencimiento");
                String strIdNotaIngreso = rs.getString("idNotaIngreso");
                if (rs.getObject("idGuiaRemision")!= null)
                    strIdGuiaRemision = rs.getString("idGuiaRemision");
                
                arrPallets.add(new PalletBE(strIdPallet,strIdProducto,strIndActivo,strIdUbicacion,strIdAlmacen,dateFechaVencimiento,strIdNotaIngreso,strIdGuiaRemision));
            }
            
            
        }catch (SQLException ex){
            
        }finally{
            objConexion.SalirS();
        }
        
        return arrPallets;
    }

}