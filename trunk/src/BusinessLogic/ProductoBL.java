/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

import BusinessEntity.ProductoBE;
import DataAccess.ProductoDA;

/**
 *
 * @author victor
 */
public class ProductoBL {
    public boolean insertar(ProductoBE producto){
        ProductoDA productoDA = new ProductoDA();
        return productoDA.insertar(producto);
    }
}
