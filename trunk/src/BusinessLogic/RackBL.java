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
    
    public void modificar(RackBE objRack){
        objRackDA = new RackDA();
        objRackDA.modificar(objRack);
    }
        
    public void eliminar(String idRack){
        objRackDA = new RackDA();
        objRackDA.eliminar(idRack);
    }
     
    public RackBE getByIdRack(String idRack){
        objRackDA = new RackDA();
        return objRackDA.queryByIdRack(idRack);
    }   
    
    public ArrayList<RackBE> getAllRack(){
        objRackDA = new RackDA();
        return objRackDA.queryAllActivo();
    }    
    
    public ArrayList<RackBE> getListSearch(String idRack, String idZona){
        objRackDA = new RackDA();
        return objRackDA.queryListSearch(idRack, idZona);
    }

    public ArrayList<RackBE> getRacksByZona(String idZona) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
