/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

import BusinessEntity.ProductoBE;
import DataAccess.ProductoDA;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class ProductoBL {

    private ProductoDA objProductoDA;

    public void insertar(ProductoBE producto){
        objProductoDA = new ProductoDA();
        objProductoDA.insertar(producto);
    }

    public boolean modificar(ProductoBE productoBE) {
        objProductoDA = new ProductoDA();
        return objProductoDA.modificar(productoBE);
    }
    
    public boolean eliminar(String idProducto) {
        objProductoDA = new ProductoDA();
        return objProductoDA.eliminar(idProducto);
    }
    
    public ProductoBE getByIdProducto(String idProducto) {
        objProductoDA = new ProductoDA();
        return objProductoDA.queryByIdProducto(idProducto);
    }

    public ArrayList<ProductoBE> getAllProductoActivo(){
        objProductoDA = new ProductoDA();
        return objProductoDA.queryAllProductoActivo();
    }

    public ArrayList<ProductoBE> getListSearch(String idProducto, String nombre, String familia, String strIndActivo){
        objProductoDA = new ProductoDA();
        return objProductoDA.queryListSearch(idProducto, nombre, familia, strIndActivo);
    }
    
    public ProductoBE getByNombreProducto(String nombreProducto){
        objProductoDA = new ProductoDA();
        return objProductoDA.queryByNombreProducto(nombreProducto);
    }


}
