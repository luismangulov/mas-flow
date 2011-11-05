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
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DIEGO
 */
public class DetalleNotaIngresoBL {
    public boolean insertar(String idNotaIngreso,String idProducto,int cantidad,Date fecha) throws FileNotFoundException, IOException, Exception{
        boolean exito = false;
        DetalleNotaIngresoBE objDetalleNotaIngresoBE;
        
        //objDetalleNotaIngresoBE = new DetalleNotaIngresoBE(Utilitario.generaCodigoDetalle("detallenotaingreso","idnotaingreso",idNotaIngreso,6),cantidad,idProducto);
        objDetalleNotaIngresoBE = new DetalleNotaIngresoBE(Utilitario.generaCodigo("detallenotaingreso", 6),cantidad,idProducto,fecha);
        DetalleNotaIngresoDA objDetalleNotaIngresoDA = new DetalleNotaIngresoDA();
        exito = objDetalleNotaIngresoDA.insertar(objDetalleNotaIngresoBE,idNotaIngreso);
        return exito;
    }
     public ArrayList<DetalleNotaIngresoBE> queryAllDetalleNotaIngreso(String codNotaIngreso){
         DetalleNotaIngresoDA objDetalleNotaIngresoDA = new DetalleNotaIngresoDA();
         return objDetalleNotaIngresoDA.queryAllDetalleNotaIngreso(codNotaIngreso);
     }
     
}
