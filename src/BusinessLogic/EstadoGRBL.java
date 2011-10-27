/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.EstadoGRBE;
import DataAccess.EstadoGRDA;
import java.util.ArrayList;

/**
 *
 * @author DIEGO
 */
public class EstadoGRBL {
    public EstadoGRBE queryByDescripcionEstadoGR(String descripcion){
        EstadoGRDA objEstadoGRDA = new EstadoGRDA();
        return objEstadoGRDA.queryByDescripcionEstadoGR(descripcion);
    }
    public EstadoGRBE queryByIdEstadoGRBE(String codigo){
        EstadoGRDA objEstadoGRDA = new EstadoGRDA();
        return objEstadoGRDA.queryByIdEstadoGRBE(codigo);
    }
    
     public ArrayList<EstadoGRBE> queryAllEstadoGRBE(){
        EstadoGRDA objEstadoGRDA = new EstadoGRDA();
        return objEstadoGRDA.queryAllEstadoGRBE();
     }
}
