/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.UsuarioContrasenaBE;
import DataAccess.UsuarioContrasenaDA;
import java.util.Date;

/**
 *
 * @author Florencio
 */
public class UsuarioContrasenaBL {
    
    public String corroborarContrasena(String idUsuario, String password){
        UsuarioContrasenaDA objUsuarioContrasenaDA = new UsuarioContrasenaDA();
        return objUsuarioContrasenaDA.corroborarContrasena(idUsuario,password);
    }

    public String actualizarContrasena(String idUsuario, String nuevoPassword,Date fechaInicio,Date fechaFin) {
        UsuarioContrasenaDA objUsuarioContrasenaDA = new UsuarioContrasenaDA();
        return objUsuarioContrasenaDA.actualizarContrasena(idUsuario,nuevoPassword,fechaInicio,fechaFin);
    }

    public String insertarUsuarioContrasena(String indDetalle,String idUsuario, String password, Date fechaInicio, Date fechaFin) {
        UsuarioContrasenaDA objUsuarioContrasenaDA = new UsuarioContrasenaDA();
        return objUsuarioContrasenaDA.insertarUsuarioContrasena(indDetalle,idUsuario,password,fechaInicio,fechaFin);
    }

    public UsuarioContrasenaBE QueryByIdUsuario(String idUsuario) {
        UsuarioContrasenaDA objUsuarioContrasenaDA = new UsuarioContrasenaDA();
        return objUsuarioContrasenaDA.QueryByIdUsuario(idUsuario);

    }
    
}
