/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.AlmacenBE;
import Util.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author victor
 */

public class AlmacenDA {
    
    conexion objConexion;
    ResultSet rs;
    String query;
    ArrayList<AlmacenBE> arrAlmacenes;
    AlmacenBE objAlmacenBE;
    
    public ArrayList<AlmacenBE> queryAllAlmacen(){
        
        objConexion = new conexion();
        query = "SELECT * FROM ALMACEN WHERE indActivo = '1'";
        rs = objConexion.EjecutarS(query);
        arrAlmacenes = new ArrayList<AlmacenBE>();
        try {
            while (rs.next()) {
                
                String strIdAlmacen = rs.getString("IdAlmacen");
                String strNombre = rs.getString("Nombre");
                double douLargo = rs.getDouble("Largo");
                double douancho = rs.getDouble("Ancho");
                String strDireccion = rs.getString("Direccion");
                String strTelefono = rs.getString("Telefono");
                String strIdDistrito = rs.getString("idDistrito");
                String strIdProvincia = rs.getString("idProvincia");
                String strIdDepartamento = rs.getString("idDepartamento");
                String strIndActivo = rs.getString("indActivo");
            
            arrAlmacenes.add(new AlmacenBE(strIdAlmacen,strNombre,douLargo,douancho,strDireccion,strTelefono,
                    strIdDistrito,strIdProvincia,strIdDepartamento,strIndActivo));
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        return arrAlmacenes;
        
    }

    public AlmacenBE queryByNombreAlmacen(String strNombreAlmacen) {
        objConexion = new conexion();
        String query = "SELECT * FROM ALMACEN WHERE nombre = '" + strNombreAlmacen + "'";
        rs =objConexion.EjecutarS(query);

        try {
            rs.next();
            String strIdAlmacen = rs.getString("IdAlmacen");
            String strNombre = rs.getString("Nombre");
            double douLargo = rs.getDouble("Largo");
            double douAncho = rs.getDouble("Ancho");
            String strDireccion = rs.getString("Direccion");
            String strTelefono = rs.getString("Telefono");
            String strIdDistrito = rs.getString("idDistrito");
            String strIdProvincia = rs.getString("idProvincia");
            String strIdDepartamento = rs.getString("idDepartamento");
            String strIndActivo = rs.getString("indActivo");
            
            objAlmacenBE = new AlmacenBE(strIdAlmacen,strNombre,douLargo,douAncho,strDireccion,strTelefono,
                    strIdDistrito,strIdProvincia,strIdDepartamento,strIndActivo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }


        return objAlmacenBE;
    }

    public AlmacenBE queryByIdProducto(String idAlmacen) {
        objConexion = new conexion();
        String query = "SELECT * FROM PRODUCTO WHERE idAlmacen = '" + idAlmacen + "'";
        rs =objConexion.EjecutarS(query);

        try {
            rs.next();
            String strIdAlmacen = rs.getString("IdAlmacen");
            String strNombre = rs.getString("Nombre");
            double douLargo = rs.getDouble("Largo");
            double douAncho = rs.getDouble("Ancho");
            String strDireccion = rs.getString("Direccion");
            String strTelefono = rs.getString("Telefono");
            String strIdDistrito = rs.getString("idDistrito");
            String strIdProvincia = rs.getString("idProvincia");
            String strIdDepartamento = rs.getString("idDepartamento");
            String strIndActivo = rs.getString("indActivo");
            
            objAlmacenBE = new AlmacenBE(strIdAlmacen,strNombre,douLargo,douAncho,strDireccion,strTelefono,
                    strIdDistrito,strIdProvincia,strIdDepartamento,strIndActivo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }


        return objAlmacenBE;
    }
}
