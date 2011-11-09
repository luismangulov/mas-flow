/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.MovimientoInternoBE;
import java.util.Date;
import DataAccess.MovimientoInternoDA;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class MovimientoInternoBL {

    MovimientoInternoDA objMovimientoInternoDA;
    
    public ArrayList<MovimientoInternoBE> getSearchList(String strIdProducto, String strIdAlmacen, Date fechaInicio, Date fechaFin) {
        objMovimientoInternoDA = new MovimientoInternoDA();
        return objMovimientoInternoDA.queryListSearch(strIdProducto, strIdAlmacen, fechaInicio, fechaFin);
    }

    public void insertar(MovimientoInternoBE objMovimientoInternoBE) {
        objMovimientoInternoDA = new MovimientoInternoDA();
        objMovimientoInternoDA.insertar(objMovimientoInternoBE);
    }

    public ArrayList<MovimientoInternoBE> getAll() {
        objMovimientoInternoDA = new MovimientoInternoDA();
        return objMovimientoInternoDA.queryAll();
    }
    
}
