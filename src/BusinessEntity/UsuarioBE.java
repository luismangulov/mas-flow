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
    private String idEstadousuario;
    private String limiteIntentos;
    private Date FechaCambioClave;

    public UsuarioBE() {
    }

    public Date getFechaCambioClave() {
        return FechaCambioClave;
    }

    public void setFechaCambioClave(Date FechaCambioClave) {
        this.FechaCambioClave = FechaCambioClave;
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
