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

    public void modificar(ProductoBE productoBE) {
        objProductoDA = new ProductoDA();
        objProductoDA.modificar(productoBE);
    }
    
    public void eliminar(String idProducto) {
        objProductoDA = new ProductoDA();
        objProductoDA.eliminar(idProducto);
    }
    
    public ProductoBE getByIdProducto(String idProducto) {
        objProductoDA = new ProductoDA();
        return objProductoDA.queryByIdProducto(idProducto);
    }

    public ArrayList<ProductoBE> getAllProductoActivo(){
        objProductoDA = new ProductoDA();
        return objProductoDA.queryAllProductoActivo();
    }

    public ArrayList<ProductoBE> getListSearch(String idProducto, String nombre, String familia){
        objProductoDA = new ProductoDA();
        return objProductoDA.queryListSearch(idProducto, nombre, familia);
    }

}
