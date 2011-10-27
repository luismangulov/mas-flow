/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.UbicacionBE;
import DataAccess.UbicacionDA;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class UbicacionBL {
    
    UbicacionDA objUbicacionDA;
    
    public void insertar(UbicacionBE objUbicacionBE){
        objUbicacionDA = new UbicacionDA();
        objUbicacionDA.insertar(objUbicacionBE);
    }
    
    public void bloquearUbicacion(String idUbicacion, String indActivo){
        objUbicacionDA = new UbicacionDA();
        objUbicacionDA.bloquearUbicacion(idUbicacion, indActivo);
    }
    
    public boolean eliminarUbicacionesByRack(String idRack){
        objUbicacionDA = new UbicacionDA();
        return objUbicacionDA.eliminarUbicacionesRack(idRack);
    }

    public ArrayList<UbicacionBE> getUbicacionesByRack(String idRack) {
        objUbicacionDA = new UbicacionDA();
        return objUbicacionDA.queryUbicacionesByRack(idRack);
    }

    public UbicacionBE getUbicacionById(String strIdUbicacion) {
        objUbicacionDA = new UbicacionDA();
        return objUbicacionDA.queryUbicacionById(strIdUbicacion);
    }

    public UbicacionBE getUbicacionByRackFilaColumna(String strIdRack, int intFila, int intColumna, String indActivo) {
        objUbicacionDA = new UbicacionDA();
        return objUbicacionDA.queryUbicacionByRackFilaColumna(strIdRack,intFila,intColumna, indActivo);
                
    }

    public ArrayList<UbicacionBE> getUbicacionesByZona(String strIdZona, String indActivo) {
        objUbicacionDA = new UbicacionDA();
        return objUbicacionDA.queryUbicacionesByZona(strIdZona, indActivo);
    }

    public ArrayList<UbicacionBE> getUbicacionesByAlmacen(String strIdAlmacen, String indActivo) {
        objUbicacionDA = new UbicacionDA();
        return objUbicacionDA.queryUbicacionesByAlmacen(strIdAlmacen, indActivo);
    }

    public ArrayList<UbicacionBE> getAll() {
        objUbicacionDA = new UbicacionDA();
        return objUbicacionDA.queryAll();
    }
            
}
