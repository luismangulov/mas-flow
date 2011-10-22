/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.ZonaBE;
import DataAccess.ZonaDA;

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
    
    public ZonaBE getByNombreZona(String nombreZona){
        objZonaDA = new ZonaDA();
        return objZonaDA.queryByNombreZona(nombreZona);
    }
}
