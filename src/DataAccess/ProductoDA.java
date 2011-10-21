/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import BusinessEntity.ProductoBE;
import BD.conexion;
import BusinessEntity.EntidadBE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author victor
 */
public class ProductoDA {
    public boolean insertar(ProductoBE objProducto){
        boolean boolExito = false;
        conexion objConexion = new conexion();

        String sql = "INSERT INTO Producto(idProducto, nombre, descripcion,"
                + "maxCantPorPallet, idUnidadMedida, idFamilia, indActivo, precio, "
                + "VALUES('"+ objProducto.getIdProducto() +"','" + objProducto.getNombre()
                +"','" + objProducto.getDescripcion() +"','" + objProducto.getMaxCantPorPallet()
                +"','" + objProducto.getIdUnidadMedida() +"','" + objProducto.getIdFamilia()
                +"','" + objProducto.getEstado() +"','" + objProducto.getPrecio() + "')";

         try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally{objConexion.SalirUID();}

        return boolExito;
    }
}
