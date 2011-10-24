/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity;

import java.util.Date;

/**
 *
 * @author florencio
 */
public class UsuarioBE {



    private String idUsuario;
    private String nombre;
    private String paterno;
    private String materno;
    private String password;
    private String idPerfil;
    private String idEstadoUsuario;
    private int limiteIntentos;
    private Date fechaCambioClave;

    
    public UsuarioBE() {
    }

    public UsuarioBE(String idUsuario, String nombre, String paterno, String materno, String password, String idPerfil, String idEstadoUsuario, int limiteIntentos, Date fechaCambioClave) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.password = password;
        this.idPerfil = idPerfil;
        this.idEstadoUsuario = idEstadoUsuario;
        this.limiteIntentos = limiteIntentos;
        this.fechaCambioClave = fechaCambioClave;
    }
    public Date getFechaCambioClave() {
        return fechaCambioClave;
    }

    public void setFechaCambioClave(Date fechaCambioClave) {
        this.fechaCambioClave = fechaCambioClave;
    }

    public String getIdEstadousuario() {
        return idEstadoUsuario;
    }

    public void setIdEstadousuario(String idEstadoUsuario) {
        this.idEstadoUsuario = idEstadoUsuario;
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

    public String getLimiteIntentos() {
        return limiteIntentos;
    }

    public void setLimiteIntentos(String limiteIntentos) {
        this.limiteIntentos = limiteIntentos;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
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

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }
    
    
   

}
