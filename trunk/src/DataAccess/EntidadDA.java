/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import BD.conexion;
import BusinessEntity.EntidadBE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author giuliana
 */
public class EntidadDA {

        public boolean insertar(EntidadBE objEntidad) throws Exception{

        boolean boolExito = false;
        conexion objConexion = new conexion();

        String sql = "INSERT INTO Entidad(idEntidad, nroDocumento, direccion,"
                + "telefono, email, nombreContacto, dniContacto, telefonoContacto, "
                + "idTipoPersona, razonSocial, paginaWeb, idTipoEntidad, indActivo, idCIUU) "
                + "VALUES('"+ objEntidad.getIdEntidad() +"','" + objEntidad.getNroDocumento()
                +"','" + objEntidad.getDireccion() +"','" + objEntidad.getTelefono()
                +"','" + objEntidad.getEmail() +"','" + objEntidad.getNombreContacto()
                +"','" + objEntidad.getDniContacto() +"','" + objEntidad.getTelefonoContacto()
                +"','" + objEntidad.getIdTipoPersona() +"','" + objEntidad.getRazonSocial()
                +"','" + objEntidad.getPaginaWeb() +"','" + objEntidad.getIdTipoEntidad()
                +"','" + objEntidad.getIndActivo() +"','" + objEntidad.getIdCIUU() +"');";

         try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}

        return boolExito;
    }




        public ArrayList<EntidadBE> queryAllCliente(){

        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<EntidadBE> arrEntidad = new ArrayList<EntidadBE>();
        String sql = "SELECT idEntidad, nroDocumento, direccion, telefono, email, nombreContacto, "
                + "dniContacto, telefonoContacto, idTipoPersona, razonSocial, paginaWeb, "
                + "idTipoEntidad, indActivo, idCIUU FROM Familia WHERE IndActivo = 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdEntidad;
            String strNroDocumento;
            String strDireccion;
            String strTelefono;
            String strEmail;
            String strNombreContacto;
            String strDniContacto;
            String strTelefonoContacto;
            String strIdTipoPersona;
            String strRazonSocial;
            String strPaginaWeb;
            String strIdTipoEntidad;
            String strIndActivo;
            String strIdCIUU;
            while (rs.next()){
                strIdEntidad = rs.getString(1);
                strNroDocumento = rs.getString(2);
                strDireccion = rs.getString(3);
                strTelefono = rs.getString(4);
                strEmail = rs.getString(5);
                strNombreContacto = rs.getString(6);
                strDniContacto = rs.getString(7);
                strTelefonoContacto = rs.getString(8);
                strIdTipoPersona = rs.getString(9);
                strRazonSocial = rs.getString(10);
                strPaginaWeb = rs.getString(11);
                strIdTipoEntidad = rs.getString(12);
                strIndActivo = rs.getString(13);
                strIdCIUU = rs.getString(14);

                arrEntidad.add(new EntidadBE( strIdEntidad,  strNroDocumento,  strDireccion,
                strTelefono,  strEmail,  strNombreContacto,  strDniContacto,
                strTelefonoContacto,  strIdTipoPersona,  strRazonSocial,
                strPaginaWeb,  strIdTipoEntidad,  strIndActivo,  strIdCIUU));
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrEntidad;
    }

}
