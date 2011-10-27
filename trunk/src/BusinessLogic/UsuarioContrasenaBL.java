/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.UsuarioContrasenaDA;

/**
 *
 * @author Florencio
 */
public class UsuarioContrasenaBL {
    
    public String corroborarContrasena(String idUsuario, String password){
        UsuarioContrasenaDA objUsuarioContrasenaDA = new UsuarioContrasenaDA();
        return objUsuarioContrasenaDA.corroborarContrasena(idUsuario,password);
    }
    
}
