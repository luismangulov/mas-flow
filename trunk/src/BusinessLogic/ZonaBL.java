/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.ZonaBE;
import DataAccess.ZonaDA;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class ZonaBL {
    
    ZonaDA objZonaDA;
    ZonaBE objZonaBE;
    
    public ZonaBE getByIdZona(String idZona){
        objZonaDA = new ZonaDA();
        return objZonaDA.queryByIdZona(idZona);
    }
    
    public ZonaBE getByIdentificadorZona(String identificador){
        objZonaDA = new ZonaDA();
        return objZonaDA.queryByIdentificadorZona(identificador);
    }

    public ArrayList<ZonaBE> getZonasByAlmacen(String idAlmacen) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
