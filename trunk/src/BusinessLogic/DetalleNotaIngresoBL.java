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

/**
 *
 * @author DIEGO
 */
public class DetalleNotaIngresoBL {
    public boolean insertar(String idNotaIngreso,String idProducto,int cantidad) throws FileNotFoundException, IOException, Exception{
        boolean exito = false;
        DetalleNotaIngresoBE objDetalleNotaIngresoBE;
        
        objDetalleNotaIngresoBE = new DetalleNotaIngresoBE(Utilitario.generaCodigo("detalleguiaremision",6),cantidad,idProducto);
        DetalleNotaIngresoDA objDetalleNotaIngresoDA = new DetalleNotaIngresoDA();
        exito = objDetalleNotaIngresoDA.insertar(objDetalleNotaIngresoBE,idNotaIngreso);
        return exito;
    }
     public ArrayList<DetalleNotaIngresoBE> queryAllDetalleNotaIngreso(String codNotaIngreso){
         DetalleNotaIngresoDA objDetalleNotaIngresoDA = new DetalleNotaIngresoDA();
         return objDetalleNotaIngresoDA.queryAllDetalleNotaIngreso(codNotaIngreso);
     }
     
}
