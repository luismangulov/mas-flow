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
public class ClienteDA {

        public ArrayList<EntidadBE> queryAllCliente(){
        conexion cnn = new conexion();
        cnn.estableceCnn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<EntidadBE> arrCliente = new ArrayList<EntidadBE>();
        try{
            pstmt = cnn.cnn.prepareStatement("SELECT "
                    + "IdEntidad,RUCDNI,Direccion,Telefono,Email,NombreContacto,"
                    + "DNIContacto,TelefonoContacto,ApellidoPaterno,ApellidoMaterno,"
                    + "Sexo,FechaNacimiento,IdEstadoEntidad,IdTipoPersona,RazonSocial,"
                    + "PaginaWeb,IdTipoEntidad "
                    + "FROM Entidad WHERE tipoEntidad='C'");
            String IdEntidad;
            String RUCDNI;
            String Direccion;
            String Telefono;
            String Email;
            String NombreContacto;
            String DNIContacto;
            String TelefonoContacto;
            String ApellidoPaterno;
            String ApellidoMaterno;
            Character Sexo;
            Date FechaNacimiento;
            String IdEstadoEntidad;
            String IdTipoPersona;
            String RazonSocial;
            String PaginaWeb;
            String IdTipoEntidad;


            while (rs.next()) {

                IdEntidad= rs.getString(1);
                RUCDNI= rs.getString(2);
                Direccion= rs.getString(3);
                Telefono= rs.getString(4);
                Email= rs.getString(5);
                NombreContacto= rs.getString(6);
                DNIContacto= rs.getString(7);
                TelefonoContacto= rs.getString(8);
                ApellidoPaterno= rs.getString(9);
                ApellidoMaterno= rs.getString(10);
                Sexo= rs.getString(11).charAt(1);
                FechaNacimiento= rs.getDate(12);
                IdEstadoEntidad= rs.getString(13);
                IdTipoPersona= rs.getString(14);
                RazonSocial= rs.getString(15);
                PaginaWeb= rs.getString(16);
                IdTipoEntidad= rs.getString(17);

                arrCliente.add(new EntidadBE(IdEntidad,RUCDNI,Direccion,Telefono,
                    Email,NombreContacto,DNIContacto,TelefonoContacto,ApellidoPaterno,
                    ApellidoMaterno,Sexo,FechaNacimiento,IdEstadoEntidad,IdTipoPersona,
                    RazonSocial,PaginaWeb,IdTipoEntidad));
            }

        }catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//6. Se cierran todos los objetos de conexion. ES EL MAS IMPORTANTE
			try { if (rs != null) {rs.close();} } catch(Exception e){e.printStackTrace();}
			try { if (pstmt != null) {pstmt.close();} } catch(Exception e){e.printStackTrace();}

		}


        return arrCliente;

    }
}
