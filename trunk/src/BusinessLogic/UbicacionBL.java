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
    
    public void bloquearUbicacion(String idUbicacion){
        
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

    public UbicacionBE getUbicacionByRackFilaColumna(String strIdRack, int intFila, int intColumna) {
        objUbicacionDA = new UbicacionDA();
        return objUbicacionDA.queryUbicacionByRackFilaColumna(strIdRack,intFila,intColumna);
                
    }

    public ArrayList<UbicacionBE> getUbicacionesByZona(String strIdZona) {
        objUbicacionDA = new UbicacionDA();
        return objUbicacionDA.queryUbicacionesByZona(strIdZona);
    }

    public ArrayList<UbicacionBE> getUbicacionesByAlmacen(String strIdAlmacen) {
        objUbicacionDA = new UbicacionDA();
        return objUbicacionDA.queryUbicacionesByAlmacen(strIdAlmacen);
    }
            
}
