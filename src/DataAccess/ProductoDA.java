/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import BusinessEntity.ProductoBE;
import Util.conexion;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Util.Utilitario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author victor
 */
public class ProductoDA {

    private conexion objConexion;
    private ResultSet rs;
    private ProductoBE objProducto;
    private boolean boolExito;
    private String query;
    private ArrayList<ProductoBE> arrProductos;

    public void insertar(ProductoBE objProducto){
        boolExito = false;
        objConexion = new conexion();
        Utilitario objUtilitario = new Utilitario();

        try {
            objProducto.setIdProducto(objUtilitario.generaCodigo("Producto", 6));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        }

        query = "INSERT INTO Producto(idProducto, nombre, descripcion,"
                + "maxCantPorPallet, idUnidadMedida, idFamilia, indActivo) "
                + "VALUES('"+ objProducto.getIdProducto() +"','" + objProducto.getNombre()
                +"','" + objProducto.getDescripcion() +"','" + objProducto.getMaxCantPorPallet()
                +"','" + objProducto.getIdUnidadMedida() +"','" + objProducto.getIdFamilia()
                +"','" + objProducto.getEstado() +"')";

        try{
            objConexion.EjecutarUID(query);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
        }
        finally{objConexion.SalirUID();}
    }

    public void modificar(ProductoBE productoBE) {
        boolExito = false;
        objConexion = new conexion();
        query = "UPDATE PRODUCTO set nombre = '"+ productoBE.getNombre() +"',"
                             + " descripcion ='"+ productoBE.getDescripcion() + "', "
                             + "maxCantPorPallet = '"+ productoBE.getMaxCantPorPallet() + "', "
                             + "idUnidadMedida ='" + productoBE.getIdUnidadMedida() +"', "
                             + " idFamilia = '" + productoBE.getIdFamilia() + "' "
                             +" WHERE idProducto ='" + productoBE.getIdProducto() +"'";
        try{
            objConexion.EjecutarUID(query);
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo modificar el registro", "Error", 0);
        }finally{
            objConexion.SalirUID();
        }
    }

    public void eliminar(String idProducto) {
        boolExito = false;
        objConexion = new conexion();
        query = "UPDATE PRODUCTO set indActivo = '0' WHERE idProducto ='"+idProducto+"'";
        try{
            objConexion.EjecutarUID(query);
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro", "Error", 0);
        }finally{
            objConexion.SalirUID();
        }
    }

    public ArrayList<ProductoBE> queryAllProductoActivo(){
        objConexion = new conexion();
        query = "SELECT * FROM PRODUCTO WHERE indActivo = '1'";
        rs = objConexion.EjecutarS(query);
        try {
            while (rs.next()) {
                String strIdProducto = rs.getString("IdProducto");
                String strNombreProducto = rs.getString("Nombre");
                String strDescripcion = rs.getString("Descripcion");
                int intMaxCantPorPallet = rs.getInt("MaxCantPorPallet");
                String strIdUnidadMedida = rs.getString("idUnidadMedida");
                String strIdFamilia = rs.getString("idFamilia");
                String strIndActivo = rs.getString("IndActivo");
                
                arrProductos.add(new ProductoBE(strIdProducto,strNombreProducto,strDescripcion,intMaxCantPorPallet,
                                  strIdUnidadMedida,strIdFamilia,strIndActivo));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        return arrProductos;
    }

    public ArrayList<ProductoBE> queryListSearch(String idProducto, String nombre, String idFamilia) {
        boolean flagIdProd = false;
        boolean flagNombre = false;
        boolean flagFamilia = false;
        objConexion = new conexion();
        query = "SELECT * FROM PRODUCTO WHERE indActivo ='1'";

        if (!idProducto.equals("")){
            query = query + " AND idProducto LIKE '%" + idProducto + "%'";
            flagIdProd = true;
        }
        if (!nombre.equals("")){
            flagNombre = true;
            if(flagIdProd == true)
                query = query + "AND ";
            else 
                query = query + " WHERE ";
            query = query + "nombre LIKE '%" + nombre + "%'";
        }
        if (!idFamilia.equals("")){
            if(flagIdProd == true || flagNombre == true)
                query = query + "AND ";
            else 
                query = query + " WHERE ";
            query = query + "idFamilia LIKE '%" + idFamilia + "%'";
        }
        rs = objConexion.EjecutarS(query);
        arrProductos = new ArrayList<ProductoBE>();
        try {
            while (rs.next()) {
                String strIdProducto = rs.getString("IdProducto");
                String strNombreProducto = rs.getString("Nombre");
                String strDescripcion = rs.getString("Descripcion");
                int intMaxCantPorPallet = rs.getInt("MaxCantPorPallet");
                String strIdUnidadMedida = rs.getString("idUnidadMedida");
                String strIdFamilia = rs.getString("idFamilia");
                String strIndActivo = rs.getString("IndActivo");
                
                arrProductos.add(new ProductoBE(strIdProducto,strNombreProducto,strDescripcion,intMaxCantPorPallet,
                                  strIdUnidadMedida,strIdFamilia,strIndActivo));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        return arrProductos;
    }
    
    
    public ProductoBE queryByIdProducto(String idProducto) {
        objConexion = new conexion();
        String query = "SELECT * FROM PRODUCTO WHERE IDPRODUCTO = '" + idProducto + "'";
        rs =objConexion.EjecutarS(query);

        try {
            rs.next();
            String strIdProducto = rs.getString("IdProducto");
            String strNombreProducto = rs.getString("Nombre");
            String strDescripcion = rs.getString("Descripcion");
            int intMaxCantPorPallet = rs.getInt("MaxCantPorPallet");
            String strIdUnidadMedida = rs.getString("idUnidadMedida");
            String strIdFamilia = rs.getString("idFamilia");
            String strIndActivo = rs.getString("IndActivo");

            objProducto = new ProductoBE(strIdProducto,strNombreProducto,strDescripcion,
            intMaxCantPorPallet,strIdUnidadMedida,strIdFamilia,strIndActivo);

        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        }


        return objProducto;
    }
}
