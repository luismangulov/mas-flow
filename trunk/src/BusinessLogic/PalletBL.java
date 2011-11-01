/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

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
        
    public void eliminar(String strIdPallet) {
        objPalletDA = new PalletDA();
        objPalletDA.eliminar(strIdPallet);
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
    
    public boolean reubicarPallet(String strIdPallet, String strIdUbicacionOrigen, String strIdUbicacionDestino, Date dateMovimiento){
        objPalletDA = new PalletDA();
        return objPalletDA.reubicarPallet(strIdPallet,strIdUbicacionOrigen,strIdUbicacionDestino, dateMovimiento);
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
    
    
}
