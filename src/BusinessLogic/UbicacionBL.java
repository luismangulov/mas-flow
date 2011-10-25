/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.UbicacionBE;
import DataAccess.UbicacionDA;
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

    public ArrayList<UbicacionBE> getUbicacionesByRack(String idRack) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public UbicacionBE getUbicacionByIdUbicacion(String strIdUbicacion) {
        objUbicacionDA = new UbicacionDA();
        return objUbicacionDA.queryUbicacionByIdUbicacion(strIdUbicacion);
    }
            
}
