/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import Util.conexion;
import BusinessEntity.UnidadMedidaBE;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author victor
 */
public class UnidadMedidaDA {

    public UnidadMedidaBE queryByIdUnidadMedida(String idUnidadMedida){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        UnidadMedidaBE objUnidadMedidaBE = null;
        String sql = "SELECT idUnidadMedida,descripcion,indactivo,nombre FROM UnidadMedida "
                     + " WHERE idUnidadMedida='"+idUnidadMedida+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdUnidadMedida;
            String strNombre;
            String strDescripcion;
            String strEstado;
            if (rs.next()){
                strIdUnidadMedida = rs.getString(1);
                strNombre = rs.getString(4);
                strDescripcion = rs.getString(2);
                strEstado = rs.getString(3);
                objUnidadMedidaBE = new UnidadMedidaBE(strIdUnidadMedida,strNombre,strDescripcion,strEstado);
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return objUnidadMedidaBE;
    }

    public UnidadMedidaBE queryByNombreUnidadMedida(String nombreUnidadMedida){
        conexion objConexion=new conexion();
        UnidadMedidaBE objUnidadMedidaBE = null;
        ResultSet rs = null;
        String sql = "SELECT idUnidadMedida,descripcion,indactivo,nombre FROM UnidadMedida "
                     + " WHERE nombre='"+nombreUnidadMedida+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdUnidadMedida;
            String strNombre;
            String strDescripcion;
            String strEstado;
            if (rs.next()){
                strIdUnidadMedida = rs.getString(1);
                strNombre = rs.getString(4);
                strDescripcion = rs.getString(2);
                strEstado = rs.getString(3);
                objUnidadMedidaBE = new UnidadMedidaBE(strIdUnidadMedida,strNombre,strDescripcion,strEstado);
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return objUnidadMedidaBE;
    }

    public ArrayList<UnidadMedidaBE> queryAllUnidadMedida() {
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<UnidadMedidaBE> arrUnidadMedida = new ArrayList<UnidadMedidaBE>();
        String sql = "SELECT * FROM UnidadMedida";

        try{
            rs=objConexion.EjecutarS(sql);
            String strIdUnidadMedida;
            String strNombre;
            String strDescripcion;
            String strIndActivo;

            while (rs.next()){
                strIdUnidadMedida = rs.getString(1);
                strNombre = rs.getString(4);
                strDescripcion = rs.getString(2);
                strIndActivo = rs.getString(3);

                arrUnidadMedida.add(new UnidadMedidaBE(strIdUnidadMedida,strNombre,strDescripcion,strIndActivo));
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrUnidadMedida;
    }
}
