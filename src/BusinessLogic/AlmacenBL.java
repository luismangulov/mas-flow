/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.AlmacenBE;
import BusinessEntity.PalletBE;
import DataAccess.AlmacenDA;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class AlmacenBL {
    
    ArrayList<AlmacenBE> arrAlmacenes;
    AlmacenDA objAlmacenDA;
    
    public void insertar(AlmacenBE objAlmacenBE){
        
    }
    
    public void modificar(AlmacenBE objAlmacenBE){
        
    }
    
    public void eliminar(String idAlmacen){
        
    }
    
    public ArrayList<AlmacenBE> getAllAlmacenActivo(){
        
        arrAlmacenes = new ArrayList<AlmacenBE>();
        objAlmacenDA = new AlmacenDA();
        return objAlmacenDA.queryAllAlmacen();
        
    }

    public AlmacenBE getAlmacenByNombre(String strNombreAlmacen) {
        objAlmacenDA = new AlmacenDA();
        return objAlmacenDA.queryByNombreAlmacen(strNombreAlmacen);
    }

    public AlmacenBE getAlmacenById(String idAlmacen) {
        objAlmacenDA = new AlmacenDA();
        return objAlmacenDA.queryByIdProducto(idAlmacen);
    }


    
    
}
