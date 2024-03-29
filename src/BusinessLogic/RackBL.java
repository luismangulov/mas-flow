/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.RackBE;
import DataAccess.RackDA;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class RackBL {
    
    RackDA objRackDA;
    public void insertar(RackBE objRack){
        objRackDA = new RackDA();
        objRackDA.insertar(objRack);
    }
    
    public boolean modificar(RackBE objRack){
        objRackDA = new RackDA();
        return objRackDA.modificar(objRack);
    }
        
    public boolean eliminar(String idRack){
        objRackDA = new RackDA();
        return objRackDA.eliminar(idRack);
    }
     
    public RackBE getByIdRack(String idRack){
        objRackDA = new RackDA();
        return objRackDA.queryByIdRack(idRack);
    }   
    
    public ArrayList<RackBE> getAllRack(){
        objRackDA = new RackDA();
        return objRackDA.queryAllActivo();
    }    
    
    public ArrayList<RackBE> getListSearch(String idAlmacen, String idRack, String idZona, String indActivos){
        objRackDA = new RackDA();
        return objRackDA.queryListSearch(idAlmacen, idRack, idZona, indActivos);
    }

    public ArrayList<RackBE> getRacksByZona(String idZona) {
        objRackDA = new RackDA();
        return objRackDA.queryRackByZona(idZona);
    }

    public RackBE getRackByIdUbicacion(String strIdUbicacion) {
        objRackDA = new RackDA();
        return objRackDA.queryRackByUbicacion(strIdUbicacion);
    }
    
    public RackBE getByIdentificador(String strIdentificador){
        objRackDA = new RackDA();
        return objRackDA.queryRackByIdentificador(strIdentificador);
    }
}

