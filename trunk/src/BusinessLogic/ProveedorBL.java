/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;
import BusinessEntity.ProveedorBE;
import DataAccess.ProveedorDA;
/**
 *
 * @author victor
 */
public class ProveedorBL {
    public void insertarProveedor(ProveedorBE proveedor) throws Exception{
        ProveedorDA proveedorDA = new ProveedorDA();
        proveedorDA.insertarProveedor(proveedor);
    }
}
