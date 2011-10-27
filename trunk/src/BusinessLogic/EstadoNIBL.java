/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.EstadoNIBE;
import DataAccess.EstadoNIDA;
import java.util.ArrayList;

/**
 *
 * @author DIEGO
 */
public class EstadoNIBL {
    public EstadoNIBE queryByDescripcionEstadoNI(String descripcion){
        EstadoNIDA objEstadoNIDA = new EstadoNIDA();
        return objEstadoNIDA.queryByDescripcionEstadoNI(descripcion);
    }
    public EstadoNIBE queryByIdEstadoNI(String codigo){
        EstadoNIDA objEstadoGRDA = new EstadoNIDA();
        return objEstadoGRDA.queryByIdEstadoNI(codigo);
    }
    
     public ArrayList<EstadoNIBE> queryAllEstadoNIBE(){
         EstadoNIDA objEstadoGRDA = new EstadoNIDA();
        return objEstadoGRDA.queryAllEstadoNIBE();
     }
}
