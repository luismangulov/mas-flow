/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Util.Utilitario;
import BusinessEntity.DetalleGuiaRemisionBE;
import DataAccess.DetalleGuiaRemisionDA;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author DIEGO
 */
public class DetalleGuiaRemisionBL {
    public boolean insertar(String idGuiaRemision,String idProducto,int cantidad,double subtotal) throws FileNotFoundException, IOException, Exception{
        boolean exito = false;
        DetalleGuiaRemisionBE objDetalleGuiaRemisionBE;
        objDetalleGuiaRemisionBE = new DetalleGuiaRemisionBE(Utilitario.generaCodigo("detalleguiaremision",6),cantidad,subtotal,idProducto);
        DetalleGuiaRemisionDA objDetalleGuiaRemisionDA = new DetalleGuiaRemisionDA();
        exito = objDetalleGuiaRemisionDA.insertar(objDetalleGuiaRemisionBE,idGuiaRemision);
        return exito;
    }
}
