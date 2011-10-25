/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.PalletBE;
import DataAccess.PalletDA;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class PalletBL {

    PalletDA objPalletDA;
    ArrayList<PalletBE> arrPallets;
    
    public void insertar(PalletBE objPalletBE) {
        objPalletDA = new PalletDA();
        objPalletDA.insertar(objPalletBE);
    }
    
//    public void modificar(PalletBE objPalletBE) {
//        objPalletDA = new PalletDA();
//        objPalletDA.modificar(objPalletBE);
//    }
        
    public void eliminar(String strIdPallet) {
        objPalletDA = new PalletDA();
        objPalletDA.eliminar(strIdPallet);
    }

    public ArrayList<PalletBE> getListSearch(String idPallet, String idProducto, String idAlmacen) {
        objPalletDA = new PalletDA();
        return objPalletDA.queryListSearch(idPallet, idProducto, idAlmacen);
    }
    
    
}
