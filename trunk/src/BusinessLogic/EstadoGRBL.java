/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.EstadoGRBE;
import DataAccess.EstadoGRDA;

/**
 *
 * @author DIEGO
 */
public class EstadoGRBL {
    public EstadoGRBE queryByDescripcionEstadoGR(String descripcion){
        EstadoGRDA objEstadoGRDA = new EstadoGRDA();
        return objEstadoGRDA.queryByDescripcionEstadoGR(descripcion);
    }
}