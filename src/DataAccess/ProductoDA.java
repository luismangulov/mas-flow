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
                + "VALUES('"+ objProducto.getIdProducto() +"','" + objProducto.getNombre().toUpperCase()
                +"','" + objProducto.getDescripcion().toUpperCase() +"','" + objProducto.getMaxCantPorPallet()
                +"','" + objProducto.getIdUnidadMedida() +"','" + objProducto.getIdFamilia()
                +"','" + objProducto.getEstado() +"')";

        try{
            objConexion.EjecutarUID(query);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
        }
        finally{objConexion.SalirUID();}
    }

    public boolean modificar(ProductoBE objProductoBE) {
        boolExito = false;
        objConexion = new conexion();
        
        if (objProductoBE.getEstado().equals("0"))
            if (queryCantidadProducto(objProductoBE.getIdProducto())>0){
                JOptionPane.showMessageDialog(null, "No se puede inactivar el producto, existen pallets asociados a éste");
                boolExito = false;
                return boolExito;
            }
        
        query = "UPDATE PRODUCTO set nombre = '"+ objProductoBE.getNombre().toUpperCase() +"',"
                             + " descripcion ='"+ objProductoBE.getDescripcion().toUpperCase() + "', "
                             + "maxCantPorPallet = '"+ objProductoBE.getMaxCantPorPallet() + "', "
                             + "idUnidadMedida ='" + objProductoBE.getIdUnidadMedida() +"', "
                             + " idFamilia = '" + objProductoBE.getIdFamilia() + "', "
                             + " indActivo = '" +objProductoBE.getEstado() + "' "
                             +" WHERE idProducto ='" + objProductoBE.getIdProducto() +"'";
        try{
            objConexion.EjecutarUID(query);
            boolExito = true;
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo modificar el registro", "Error", 0);
                boolExito = false;
        }finally{
            objConexion.SalirUID();
        }
        return boolExito;
    }

    public boolean eliminar(String idProducto) {
        boolean boolExito = false;
        objConexion = new conexion();
        
        if (queryCantidadProducto(idProducto)>0){
            JOptionPane.showMessageDialog(null, "No se puede eliminar el producto, existen pallets asociados a éste");
        }
        else{
            query = "DELETE FROM PRODUCTO WHERE idProducto ='"+idProducto+"'";
            try{
                objConexion.EjecutarUID(query);
                boolExito = true;
            } catch (Exception e){
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro", "Error", 0);
                    boolExito = false;
            }finally{
                objConexion.SalirUID();
            }
        }
        return boolExito;
    }

    public ArrayList<ProductoBE> queryAllProductoActivo(){
        objConexion = new conexion();
        query = "SELECT * FROM PRODUCTO WHERE indActivo = '1'";
        rs = objConexion.EjecutarS(query);
        arrProductos = new ArrayList<ProductoBE>();
        try {
            while (rs.next()) {
                String strIdProducto = rs.getString("IdProducto").trim();
                String strNombreProducto = rs.getString("Nombre").trim();
                String strDescripcion = rs.getString("Descripcion").trim();
                int intMaxCantPorPallet = rs.getInt("MaxCantPorPallet");
                String strIdUnidadMedida = rs.getString("idUnidadMedida").trim();
                String strIdFamilia = rs.getString("idFamilia").trim();
                String strIndActivo = rs.getString("IndActivo").trim();
                
  
                arrProductos.add(new ProductoBE(strIdProducto,strNombreProducto,strDescripcion,intMaxCantPorPallet,
                                  strIdUnidadMedida,strIdFamilia,strIndActivo));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            objConexion.SalirS();
        }
        return arrProductos;
    }

    public ArrayList<ProductoBE> queryListSearch(String idProducto, String nombre, String idFamilia, String strIndActivo) {

        objConexion = new conexion();
        query = "SELECT * FROM PRODUCTO WHERE indActivo LIKE '%"+strIndActivo+"%'";

        if (!idProducto.equals("")){
            query = query + " AND idProducto LIKE '%" + idProducto + "%'";

        }
        if (!nombre.equals("")){
            query = query + " AND nombre LIKE '%" + nombre + "%'";
        }
        if (!idFamilia.equals("")){
            query = query + " AND idFamilia LIKE '%" + idFamilia + "%'";
        }
        
        query = query + "ORDER BY 1";
        
        rs = objConexion.EjecutarS(query);
        arrProductos = new ArrayList<ProductoBE>();
        try {
            while (rs.next()) {
                String strIdProducto = rs.getString("IdProducto");
                String strNombreProducto = rs.getString("Nombre").trim();
                String strDescripcion = rs.getString("Descripcion").trim();
                int intMaxCantPorPallet = rs.getInt("MaxCantPorPallet");
                String strIdUnidadMedida = rs.getString("idUnidadMedida");
                String strIdFamilia = rs.getString("idFamilia");
                strIndActivo = rs.getString("IndActivo");
                
                arrProductos.add(new ProductoBE(strIdProducto,strNombreProducto,strDescripcion,intMaxCantPorPallet,
                                  strIdUnidadMedida,strIdFamilia,strIndActivo));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            objConexion.SalirS();
        }
        return arrProductos;
    }
    
    
    public ProductoBE queryByIdProducto(String idProducto) {
        objConexion = new conexion();
        String query = "SELECT * FROM PRODUCTO WHERE IDPRODUCTO = '" + idProducto + "'";
        query = query + "ORDER BY 1";
        rs =objConexion.EjecutarS(query);

        try {
            rs.next();

                String strIdProducto = rs.getString("IdProducto");
                String strNombreProducto = rs.getString("Nombre").trim();
                String strDescripcion = rs.getString("Descripcion").trim();
                int intMaxCantPorPallet = rs.getInt("MaxCantPorPallet");
                String strIdUnidadMedida = rs.getString("idUnidadMedida");
                String strIdFamilia = rs.getString("idFamilia");
                String strIndActivo = rs.getString("IndActivo");
                
                objProducto = new ProductoBE(strIdProducto,strNombreProducto,strDescripcion,
                intMaxCantPorPallet,strIdUnidadMedida,strIdFamilia,strIndActivo);

        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
            objProducto = null;
        } finally {
            objConexion.SalirS();
        }


        return objProducto;
    }

    public ProductoBE queryByNombreProducto(String nombreProducto) {
        objConexion = new conexion();
        String query = "SELECT * FROM PRODUCTO WHERE nombre = '" + nombreProducto + "'";
        query = query + "ORDER BY 1";
        rs =objConexion.EjecutarS(query);

        try {
            rs.next();

                String strIdProducto = rs.getString("IdProducto");
                String strNombreProducto = rs.getString("Nombre").trim();
                String strDescripcion = rs.getString("Descripcion").trim();
                int intMaxCantPorPallet = rs.getInt("MaxCantPorPallet");
                String strIdUnidadMedida = rs.getString("idUnidadMedida");
                String strIdFamilia = rs.getString("idFamilia");
                String strIndActivo = rs.getString("IndActivo");
                
                objProducto = new ProductoBE(strIdProducto,strNombreProducto,strDescripcion,
                intMaxCantPorPallet,strIdUnidadMedida,strIdFamilia,strIndActivo);


        } catch (SQLException ex) {
//            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
            objProducto = null;
        } finally {
            objConexion.SalirS();
        }


        return objProducto;
    }
    
    public int queryCantidadProducto(String strIdProducto){
        
        int intCantProd = 0;
        objConexion = new conexion();
        
        query = "SELECT COUNT(idPallet) as cuenta FROM PALLET WHERE idProducto = '" +strIdProducto+"'";
        rs = objConexion.EjecutarS(query);
        
        try{
            rs.next();
            intCantProd = rs.getInt("cuenta");
        }catch(SQLException ex){
            
        }finally{
            objConexion.SalirS();
        };

        return intCantProd;
    }

}
