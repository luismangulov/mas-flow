/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.MovimientoInternoBE;
import Util.Utilitario;
import Util.conexion;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

/**
 *
 * @author victor
 */
public class MovimientoInternoDA {

    conexion objConexion;
    String query;
    String strFechaInicio;
    String strFechaFin;
    ArrayList<MovimientoInternoBE> arrMovimientosInternos = new ArrayList<MovimientoInternoBE>();
    ResultSet rs;
    SimpleDateFormat df;
    Utilitario objUtilitario;

    
    public ArrayList<MovimientoInternoBE> queryListSearch(String strNombreProducto, String strIdAlmacen, Date fechaInicio, Date fechaFin) {
        
        objConexion = new conexion();
        boolean flagProducto = false;
        boolean flagAlmacen = false;
        df = new SimpleDateFormat("yyyy-MM-dd");
        strFechaInicio = df.format(fechaInicio).toString() + " 00:00:00.000";
        strFechaFin = df.format(fechaFin).toString() + " 23:59:59.000";
        
        query = "SELECT m.idmovimientointerno, m.idubicacionorigen, m.idubicaciondestino, m.fecha, "
                + "m.descripcion, m.idPallet, m.idalmacen, m.idusuario FROM MOVIMIENTOINTERNO m, PALLET p, PRODUCTO pr"
                + " WHERE m.idPallet = p.idPallet AND p.idProducto = pr.idproducto ";
        
        if (!strNombreProducto.equals(""))
            query = query + " AND pr.nombre LIKE '%" +strNombreProducto+ "%' ";
        
        
        if (!strIdAlmacen.equals(""))
            query = query + " AND m.idAlmacen ='" +strIdAlmacen + "'";
        
            query = query + " AND m.FECHA BETWEEN '" + strFechaInicio + "' AND '" + strFechaFin + "'";

        
        rs = objConexion.EjecutarS(query);
        
        try{
            while(rs.next()){
                
                String strIdMovimientoInterno = rs.getString("IdMovimientoInterno");
                String strIdUbicacionOrigen = rs.getString("IdUbicacionOrigen");
                String strIdUbicacionDestino = rs.getString("IdUbicacionDestino");
                Timestamp dateFecha = rs.getTimestamp("Fecha");
                String strDescripcion = rs.getString("Descripcion");
                String strIdPallet = rs.getString("IdPallet");
                strIdAlmacen = rs.getString("IdAlmacen");
                String strIdUsuario = rs.getString("idUsuario");
                
                arrMovimientosInternos.add(new MovimientoInternoBE(strIdMovimientoInterno,strIdUbicacionOrigen,strIdUbicacionDestino,dateFecha,strDescripcion,strIdPallet,strIdAlmacen,strIdUsuario));
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            objConexion.SalirS();
        }
        
        return arrMovimientosInternos;
    }

    public boolean insertar(MovimientoInternoBE objMovimientoInternoBE) {
        
        objConexion = new conexion();
        boolean exito = false;
        objUtilitario = new Utilitario();
        String strIdMovimientoInterno = "";
        
        try {
            strIdMovimientoInterno = objUtilitario.generaCodigo("movimientointerno", 8);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MovimientoInternoDA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MovimientoInternoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        objMovimientoInternoBE.setIdMovimiento(strIdMovimientoInterno);
        Date time = new Date();
        Timestamp fechaActual = new Timestamp(time.getTime());
        objMovimientoInternoBE.setFecha(fechaActual);
        
        if (objMovimientoInternoBE.getIdUbicacionOrigen() == null){
            query = "INSERT INTO MOVIMIENTOINTERNO(idmovimientoInterno,idAlmacen,idPallet,idUbicacionDestino, fecha ,descripcion,idusuario)"
                            + "VALUES('"+strIdMovimientoInterno+"',"
                        + "'"+objMovimientoInternoBE.getIdAlmacen() + "',"
                        + "'"+objMovimientoInternoBE.getIdPallet() + "',"
                        + "'"+objMovimientoInternoBE.getIdUbicacionDestino()+"',"
                        + "'"+objMovimientoInternoBE.getFecha() +"',"
                        + "'"+objMovimientoInternoBE.getDescripcion()+"',"
                        + "'"+objMovimientoInternoBE.getIdUsuario() + "')";
            
        }else if(objMovimientoInternoBE.getIdUbicacionDestino() == null){
        
        query = "INSERT INTO MOVIMIENTOINTERNO(idmovimientoInterno,idAlmacen,idPallet,idUbicacionOrigen,fecha ,descripcion,idusuario) "
                + "VALUES('"+strIdMovimientoInterno+"',"
                + "'"+objMovimientoInternoBE.getIdAlmacen() + "',"
                + "'"+objMovimientoInternoBE.getIdPallet() + "',"
                + "'"+objMovimientoInternoBE.getIdUbicacionOrigen()+"',"
                + "'"+objMovimientoInternoBE.getFecha() +"',"
                + "'"+objMovimientoInternoBE.getDescripcion()+"',"
                + "'"+objMovimientoInternoBE.getIdUsuario() + "')";
        }else
            
            query = "INSERT INTO MOVIMIENTOINTERNO(idmovimientoInterno,idAlmacen,idPallet,idUbicacionDestino, idUbicacionOrigen,fecha ,descripcion,idusuario) "
                + "VALUES('"+strIdMovimientoInterno+"',"
                + "'"+objMovimientoInternoBE.getIdAlmacen() + "',"
                + "'"+objMovimientoInternoBE.getIdPallet() + "',"
                + "'"+objMovimientoInternoBE.getIdUbicacionDestino()+"',"
                + "'"+objMovimientoInternoBE.getIdUbicacionOrigen()+"',"
                + "'"+objMovimientoInternoBE.getFecha() +"',"
                + "'"+objMovimientoInternoBE.getDescripcion()+"',"
                + "'"+objMovimientoInternoBE.getIdUsuario() + "')";
        
        
        try{
            objConexion.EjecutarUID(query);
            exito = true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
            exito = false;
        }finally{objConexion.SalirUID();}
        
        return exito;

    }
    
    public ArrayList<MovimientoInternoBE> queryAll() {
        objConexion = new conexion();
        
        query = "SELECT * FROM MOVIMIENTOINTERNO";
                
        rs = objConexion.EjecutarS(query);
        
        try{
            while(rs.next()){
                
                String strIdMovimientoInterno = rs.getString("IdMovimientoInterno");
                String strIdUbicacionOrigen = rs.getString("IdUbicacionOrigen");
                String strIdUbicacionDestino = rs.getString("IdUbicacionDestino");
                Timestamp dateFecha = rs.getTimestamp("Fecha");
                String strDescripcion = rs.getString("Descripcion");
                String strIdPallet = rs.getString("IdPallet");
                String strIdAlmacen = rs.getString("IdAlmacen");
                String strIdUsuario = rs.getString("idUsuario");
                
                arrMovimientosInternos.add(new MovimientoInternoBE(strIdMovimientoInterno,strIdUbicacionOrigen,strIdUbicacionDestino,dateFecha,strDescripcion,strIdPallet,strIdAlmacen,strIdUsuario));
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            objConexion.SalirS();
        }
        
        return arrMovimientosInternos;
    }
    
    
}
