/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import BusinessEntity.ProductoBE;
import BD.conexion;
import BusinessEntity.EntidadBE;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import BD.Utilitario;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private ArrayList<ProductoBE> arrProductoBE;

    public boolean insertar(ProductoBE objProducto){
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
                + "maxCantPorPallet, idUnidadMedida, idFamilia, indActivo, precio) "
                + "VALUES('"+ objProducto.getIdProducto() +"','" + objProducto.getNombre()
                +"','" + objProducto.getDescripcion() +"','" + objProducto.getMaxCantPorPallet()
                +"','" + objProducto.getIdUnidadMedida() +"','" + objProducto.getIdFamilia()
                +"','" + objProducto.getEstado() +"','" + objProducto.getPrecio() + "')";

         try{
            objConexion.EjecutarUID(query);
            boolExito=true;
         }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally{objConexion.SalirUID();}

        return boolExito;
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
            int intPrecio = rs.getInt("precio");
            objProducto = new ProductoBE(strIdProducto,strNombreProducto,strDescripcion,
            intMaxCantPorPallet,strIdUnidadMedida,strIdFamilia,strIndActivo,intPrecio);

        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        }


        return objProducto;
    }

    public boolean modificar(ProductoBE productoBE) {
        boolExito = false;
        objConexion = new conexion();
        query = "UPDATE PRODUCTO nombre = '"+productoBE.getNombre()+"', descripcion ='"+productoBE.getDescripcion()+
                        "', maxCantPorPallet = '"+String.valueOf(productoBE.getMaxCantPorPallet())+"', idUnidadMedida ='"
                        +productoBE.getIdUnidadMedida()+"', idFamilia = '" +productoBE.getIdFamilia()+ "', precio ='"+String.valueOf(productoBE.getPrecio())+"'"
                        +" WHERE idProducto ='" +productoBE.getIdProducto();
        objConexion.EjecutarUID(query);
        boolExito = true;
        return boolExito;
    }

    public boolean eliminar(ProductoBE productoBE) {
        boolExito = false;
        objConexion = new conexion();
        query = "UPDATE PRODUCTO indActivo = '0' WHERE idProducto ='"+productoBE.getIdProducto()+"'";
        objConexion.EjecutarS(query);
        boolExito = true;
        return boolExito;
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
                int intPrecio = rs.getInt("precio");
                arrProductoBE.add(new ProductoBE(strIdProducto,strNombreProducto,strDescripcion,intMaxCantPorPallet,
                                  strIdUnidadMedida,strIdFamilia,strIndActivo,intPrecio));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrProductoBE;
    }

    public ArrayList<ProductoBE> queryListSearch(String idProducto, String nombre, String idFamilia) {
        boolean flagIdProd = false;
        boolean flagNombre = false;
        boolean flagFamilia = false;
        objConexion = new conexion();
        query = "SELECT * FROM PRODUCTO";

        if (idProducto != ""){
            query = query + "WHERE idProducto LIKE '%" + idProducto + "%'";
            flagIdProd = true;
        }
        if (nombre != ""){
            flagNombre = true;
            if(flagIdProd == true)
                query = query + "AND ";
            query = query + "nombre LIKE '%" + nombre + "%'";
        }
        if (idFamilia != ""){
            if(flagIdProd == true || flagNombre == true)
                query = query + "AND ";
            query = query + "idFamilia LIKE '%" + idFamilia + "%'";
        }
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
                int intPrecio = rs.getInt("precio");
                arrProductoBE.add(new ProductoBE(strIdProducto,strNombreProducto,strDescripcion,intMaxCantPorPallet,
                                  strIdUnidadMedida,strIdFamilia,strIndActivo,intPrecio));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrProductoBE;
    }

//            conexion objConexion=new conexion();
//        ResultSet rs = null;
//        ArrayList<FamiliaBE> arrFamilia = new ArrayList<FamiliaBE>();
//        String sql = "SELECT idfamilia,nombre,descripcion,indactivo FROM Familia";
//        boolean primero = false;
//        sql+= " WHERE IndActivo = '1'";
//        if(!(codigo.equals("")) || !(nombre.equals(""))){
//           if (!codigo.equals("")){
//                sql += "AND idfamilia LIKE '%" + codigo + "%'";
//           }
//           if (!nombre.equals("")){
//
//                sql += "AND nombre LIKE '%" + nombre + "%'";
//           }
//


}
