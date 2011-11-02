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
    private PerfilBE perfil;
    private EstadoUsuarioBE estadoUsuario;
    private int limiteIntentos;

    
    public UsuarioBE() {
    }

    public UsuarioBE(String idUsuario, String nombre, String paterno, String materno, PerfilBE perfil, EstadoUsuarioBE estadoUsuario, int limiteIntentos) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.perfil = perfil;
        this.estadoUsuario= estadoUsuario;
        this.limiteIntentos = limiteIntentos;
        
    }




    public EstadoUsuarioBE getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuarioBE estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public PerfilBE getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilBE perfil) {
        this.perfil = perfil;
    }



    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getLimiteIntentos() {
        return limiteIntentos;
    }

    public void setLimiteIntentos(int limiteIntentos) {
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


    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }
    
    
   

}
