/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity;

/**
 *
 * @author florencio
 */
public class UsuarioBE {

    private String idUsuario;
    private String nombre;
    private String password;
    private String idEstadousuario;
    private String idPerfil;

    public UsuarioBE() {
    }

    public String getIdEstadousuario() {
        return idEstadousuario;
    }

    public void setIdEstadousuario(String idEstadousuario) {
        this.idEstadousuario = idEstadousuario;
    }

    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
