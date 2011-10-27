/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.ZonaBE;
import DataAccess.ZonaDA;
import java.util.ArrayList;
import BusinessEntity.FamiliaBE;
import Util.Utilitario;

/**
 *
 * @author victor
 */
public class ZonaBL {
    
   
    private ZonaBE zona;

    public boolean insertar(String idZona, String nombre, String identificador, String indActivo,
            String idAlmacen, int posX, int posY, int ancho, int largo, ArrayList <FamiliaBE> familias)
            throws Exception{
        boolean exito = false;
        zona = new ZonaBE(Utilitario.generaCodigo("Zona",6), nombre, identificador, indActivo,
            idAlmacen, posX, posY, ancho, largo, familias);
        ZonaDA objZonaDA = new ZonaDA();
        exito = objZonaDA.insertar(getZona());
        return exito;

    }
    
     public boolean modificar(ZonaBE objZona) throws Exception{
          boolean exito = false;
          ZonaDA objZonaDA = new ZonaDA();
          exito = objZonaDA.modificar(objZona);
          return exito;
     }
    
    public boolean eliminar(String codZona) throws Exception{
        boolean exito = false;
        ZonaDA objZonaDA = new ZonaDA();
        exito = objZonaDA.eliminar(codZona);
        return exito;
    }


      public ArrayList<ZonaBE> buscar(String codigo,String nombre, String indActivo, String idAlmacen,
              String identificador){
          ZonaDA objZonaDA = new ZonaDA();
          return objZonaDA.buscar(codigo, nombre, indActivo,idAlmacen, identificador);
     }


    public ArrayList<ZonaBE> getAllZona(){

        ZonaDA objZonaDA = new ZonaDA();
        return objZonaDA.queryAllZona();

    }
    
     public ArrayList<ZonaBE> getAllZonaActivo(){
        ZonaDA objZonaDA = new ZonaDA();
        return objZonaDA.queryAllZonaActiva();

    }

     public ZonaBE getZona(String codigo){
        ZonaDA objZonaDA = new ZonaDA();
        return objZonaDA.queryByIdZona(codigo);
    }
     
     // víctor

    public ZonaBE getByIdentificadorZona(String identificador){
        ZonaDA objZonaDA = new ZonaDA();
        return objZonaDA.queryByIdentificadorZona(identificador);
    }

    public ArrayList<ZonaBE> getZonasByAlmacen(String idAlmacen) {
        ZonaDA objZonaDA = new ZonaDA();
        return objZonaDA.queryZonasByAlmacen(idAlmacen);
    }

    /**
     * @return the zona
     */
    public ZonaBE getZona() {
        return zona;
    }


}
