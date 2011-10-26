/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.DetalleNotaIngresoBE;
import DataAccess.DetalleNotaIngresoDA;
import Util.Utilitario;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author DIEGO
 */
public class DetalleNotaIngresoBL {
    public boolean insertar(String idNotaIngreso,String idProducto,int cantidad) throws FileNotFoundException, IOException, Exception{
        boolean exito = false;
        DetalleNotaIngresoBE objDetalleNotaIngresoBE;
        
        objDetalleNotaIngresoBE = new DetalleNotaIngresoBE(Utilitario.generaCodigo("detalleguiaremision",6),cantidad,idProducto);
        DetalleNotaIngresoDA objDetalleGuiaRemisionDA = new DetalleNotaIngresoDA();
        exito = objDetalleGuiaRemisionDA.insertar(objDetalleNotaIngresoBE,idNotaIngreso);
        return exito;
    }
}