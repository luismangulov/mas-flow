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

    
    public ArrayList<MovimientoInternoBE> queryListSearch(String strIdProducto, String strIdAlmacen, Date fechaInicio, Date fechaFin) {
        
        objConexion = new conexion();
        boolean flagProducto = false;
        boolean flagAlmacen = false;
        df = new SimpleDateFormat("yyyy-MM-dd");
        strFechaInicio = df.format(fechaInicio).toString();
        strFechaFin = df.format(fechaFin).toString();
        
        query = "SELECT m.idmovimientointerno, m.idubicacionorigen, m.idubicaciondestino, m.fecha, "
                + "m.descripcion, m.idPallet, m.idalmacen FROM MOVIMIENTOINTERNO m, PALLET p"
                + " WHERE m.idPallet = p.idPallet";
        
        if (!strIdProducto.equals(""))
            query = query + " AND p.idProducto LIKE '%" +strIdProducto+ "%' ";
        
        
        if (!strIdAlmacen.equals(""))
            query = query + " AND m.idAlmacen ='" +strIdAlmacen + "'";
        
        if (flagProducto || flagAlmacen)
            query = query + " AND m.FECHA BETWEEN '" +strFechaInicio+ "' AND '" +strFechaFin+ "'";
        
        rs = objConexion.EjecutarS(query);
        
        try{
            while(rs.next()){
                
                String strIdMovimientoInterno = rs.getString("IdMovimientoInterno");
                String strIdUbicacionOrigen = rs.getString("IdUbicacionOrigen");
                String strIdUbicacionDestino = rs.getString("IdUbicacionDestino");
                Date dateFecha = rs.getDate("Fecha");
                String strDescripcion = rs.getString("Descripcion");
                String strIdPallet = rs.getString("IdPallet");
                strIdAlmacen = rs.getString("IdAlmacen");
                
                arrMovimientosInternos.add(new MovimientoInternoBE(strIdMovimientoInterno,strIdUbicacionOrigen,strIdUbicacionDestino,dateFecha,strDescripcion,strIdPallet,strIdAlmacen));
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            objConexion.SalirS();
        }
        
        return arrMovimientosInternos;
    }

    public void insertar(MovimientoInternoBE objMovimientoInternoBE) {
        
        objConexion = new conexion();
        
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
        
        query = "INSERT INTO MOVIMIENTOINTERNO(idmovimientoInterno,idUbicacionOrigen,idUbicacionDestino, fecha ,descripcion, idPallet, idAlmacen) "
                + "VALUES('"+strIdMovimientoInterno+"',"
                + "'"+objMovimientoInternoBE.getIdUbicacionOrigen()+"',"
                + "'"+objMovimientoInternoBE.getIdUbicacionDestino()+"',"
                + "'"+objMovimientoInternoBE.getFecha() +"',"
                + "'"+objMovimientoInternoBE.getDescripcion()+"',"
                + "'"+objMovimientoInternoBE.getIdPallet() + "',"
                + "'"+objMovimientoInternoBE.getIdAlmacen() + "')";

        try{
            objConexion.EjecutarUID(query);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
        }finally{objConexion.SalirUID();}

    }
    
    public boolean reubicarPallet(MovimientoInternoBE objMovimientoInternoBE) {
        
        boolean exito = false;
        objConexion = new conexion();
        
        // se setea la disponibilidad "1" de la ubicacion anterior
        query = "UPDATE UBICACION SET indActivo = '1' WHERE idUbicacion = '" + objMovimientoInternoBE.getIdUbicacionOrigen() + "'";
        
        try{
            objConexion.EjecutarUID(query);
            exito = true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
            exito = false;
        }
        finally{objConexion.SalirUID();}
        
        if (exito){
            // se asocia el pallet a la ubicacion destino
            query = "UPDATE PALLET SET idUbicacion = '" + objMovimientoInternoBE.getIdUbicacionDestino() + "' WHERE idPallet ='" +objMovimientoInternoBE.getIdPallet() +"'";

            try{
                objConexion.EjecutarUID(query);
                exito = true;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
                exito = false;
            }
            finally{objConexion.SalirUID();}

            // se cambia el estado de la ubicacion destino a en uso
            query = "UPDATE UBICACION SET indActivo = '2' WHERE idUbicacion ='" + objMovimientoInternoBE.getIdUbicacionDestino() +"'";

            try{
                objConexion.EjecutarUID(query);
                exito = true;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
                exito = false;
            }
            finally{objConexion.SalirUID();}
            
            if (exito){
            
                objUtilitario = new Utilitario();
                String strIdMovimientoInterno = "";
                try {
                    strIdMovimientoInterno = objUtilitario.generaCodigo("movimientointerno", 8);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PalletDA.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(PalletDA.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                objMovimientoInternoBE.setIdMovimiento(strIdMovimientoInterno);

                query = "INSERT INTO MOVIMIENTOINTERNO(idmovimientoInterno,idUbicacionOrigen,idUbicacionDestino, fecha ,descripcion, idPallet, idAlmacen) "
                        + "VALUES('"+strIdMovimientoInterno+"',"
                        + "'"+objMovimientoInternoBE.getIdUbicacionOrigen()+"',"
                        + "'"+objMovimientoInternoBE.getIdUbicacionDestino()+"',"
                        + "'"+objMovimientoInternoBE.getFecha() +"',"
                        + "'"+objMovimientoInternoBE.getDescripcion()+"',"
                        + "'"+objMovimientoInternoBE.getIdPallet() + "',"
                        + "'"+objMovimientoInternoBE.getIdAlmacen() + "')";

                try{
                    objConexion.EjecutarUID(query);
                    exito = true;
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
                    exito = false;
                }
                finally{objConexion.SalirUID();}

            }
        }
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
                Date dateFecha = rs.getDate("Fecha");
                String strDescripcion = rs.getString("Descripcion");
                String strIdPallet = rs.getString("IdPallet");
                String strIdAlmacen = rs.getString("IdAlmacen");
                
                arrMovimientosInternos.add(new MovimientoInternoBE(strIdMovimientoInterno,strIdUbicacionOrigen,strIdUbicacionDestino,dateFecha,strDescripcion,strIdPallet,strIdAlmacen));
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            objConexion.SalirS();
        }
        
        return arrMovimientosInternos;
    }
    
    
}