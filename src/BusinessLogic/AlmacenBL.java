/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.AlmacenBE;
import java.util.ArrayList;
import DataAccess.AlmacenDA;
import Util.Utilitario;
/**
 *
 * @author victor
 */
public class AlmacenBL {



     private AlmacenBE almacen;

    public boolean insertar(String idAlmacen, String nombre, double largo, double ancho,
            String direccion, String telefono, String idDistrito, String idProvincia, 
            String idDepartamento, String indActivo, int puertaX, int puertaY) throws Exception{
        boolean exito = false;
        almacen = new AlmacenBE(Utilitario.generaCodigo("almacen",6), nombre, largo, ancho,
                direccion, telefono, idDistrito, idProvincia, idDepartamento, indActivo, puertaX, puertaY);
        AlmacenDA objAlmacenDA = new AlmacenDA();
        exito = objAlmacenDA.insertar(getAlmacen());
        return exito;

    }
    
     public boolean modificar(AlmacenBE objAlmacen) throws Exception{
          boolean exito = false;
          AlmacenDA objAlmacenDA = new AlmacenDA();
          exito = objAlmacenDA.modificar(objAlmacen);
          return exito;
     }
    
    public boolean eliminar(String codAlmacen) throws Exception{
        boolean exito = false;
        AlmacenDA objAlmacenDA = new AlmacenDA();
        exito = objAlmacenDA.eliminar(codAlmacen);
        return exito;
    }


      public ArrayList<AlmacenBE> buscar(String codigo,String nombre, String indActivo, String idDepartamento,
              String idProvincia, String idDistrito){
          AlmacenDA objAlmacenDA = new AlmacenDA();
          return objAlmacenDA.buscar(codigo, nombre, indActivo,idDepartamento, idProvincia, idDistrito);
     }


    public ArrayList<AlmacenBE> getAllAlmacen(){

        AlmacenDA objAlmacenDA = new AlmacenDA();
        return objAlmacenDA.queryAllAlmacen();

    }
    
     public ArrayList<AlmacenBE> getAllAlmacenActivo(){
        AlmacenDA objAlmacenDA = new AlmacenDA();
        return objAlmacenDA.queryAllAlmacenActivo();

    }

     public AlmacenBE getAlmacen(String codigo){
        AlmacenDA objAlmacenDA = new AlmacenDA();
        return objAlmacenDA.queryByIdAlmacen(codigo);
    }

    /**
     * @return the almacen
     */
    public AlmacenBE getAlmacen() {
        return almacen;
    }


}
