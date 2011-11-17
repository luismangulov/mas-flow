/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.MovimientoInternoBE;
import BusinessEntity.PalletBE;
import DataAccess.PalletDA;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author victor
 */
public class PalletBL {

    PalletDA objPalletDA;
    ArrayList<PalletBE> arrPallets;
    private String strIdZona;
    
    public void insertar(PalletBE objPalletBE) {
        objPalletDA = new PalletDA();
        objPalletDA.insertar(objPalletBE);
    }
        
    public void desechar(PalletBE objPalletBE) {
        objPalletDA = new PalletDA();
        objPalletDA.desechar(objPalletBE);
    }

    public ArrayList<PalletBE> getListSearch(String idPallet, String idProducto, String idAlmacen) {
        objPalletDA = new PalletDA();
        return objPalletDA.queryListSearch(idPallet, idProducto, idAlmacen);
    }
    
    public ArrayList<PalletBE> getAll() {
        objPalletDA = new PalletDA();
        return objPalletDA.queryList();
    }

    public PalletBE getPalletByIdUbicacion(String strIdUbicacion) {
        objPalletDA = new PalletDA();
        return objPalletDA.queryByIdUbicacion(strIdUbicacion);
    }
    
    public ArrayList<PalletBE> getPalletsByRack(String strIdRack) {
        objPalletDA = new PalletDA();
        return objPalletDA.queryPalletsByRack(strIdRack);
    }

    public ArrayList<PalletBE> getPalletsByZona(String strIdZona) {
        objPalletDA = new PalletDA();
        return objPalletDA.queryPalletsByIdZona(strIdZona);
    }

    public ArrayList<PalletBE> getPalletsByAlmacen(String strIdAlmacen) {
        objPalletDA = new PalletDA();
        return objPalletDA.queryPalletsByIdAlmacen(strIdAlmacen);
    }
    
    public PalletBE getPallet(String strIdPallet) {
        objPalletDA = new PalletDA();
        return objPalletDA.queryByIdPallet(strIdPallet);
    }

    public ArrayList<PalletBE> getPalletListSearch(String strIdAlmacen, String strIdZona, String strIdRack, String strIdUbicacion, String strNombreProducto, String strIdPallet) {
        objPalletDA = new PalletDA();
        return objPalletDA.queryPalletListSearch(strIdAlmacen, strIdZona, strIdRack, strIdUbicacion, strNombreProducto, strIdPallet);
    }
    
    public ArrayList<PalletBE> getPalletByIdNotaIngreso(String strIdNotaIngreso){
        objPalletDA = new PalletDA();
        return objPalletDA.queryPalletByIdNotaIngreso(strIdNotaIngreso);
    }
    
    public boolean liberarPallet(String strIdPallet) {
        objPalletDA = new PalletDA();
        return objPalletDA.liberarPallet(strIdPallet);
    }
    
    public boolean asociarUbicacionAPallet(String strIdPallet, String strIdUbicacion){
        objPalletDA = new PalletDA();
        return objPalletDA.asociarUbicacionAPallet(strIdPallet, strIdUbicacion);
    }
        
    public boolean despacharPallet(String strIdPallet){ 
        objPalletDA = new PalletDA();
        return objPalletDA.despacharPallet(strIdPallet);
    }
    
    public boolean asociarGuiaRemision(String strIdPallet, String strIdGuiaRemision){
        objPalletDA = new PalletDA();
        return objPalletDA.asociarGuiaRemision(strIdPallet, strIdGuiaRemision);
    }
    
    public ArrayList<PalletBE> getPalletByIdGuiaRemision(String strIdGuiaRemision){
        objPalletDA = new PalletDA();
        return objPalletDA.queryPalletByIdGuiaRemision(strIdGuiaRemision);
    }
    
}
