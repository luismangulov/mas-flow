/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

import java.util.Date;

/**
 *
 * @author Florencio
 */
public class UsuarioContrasenaBE {
    private String indDetalle;
    private String idUsuario;
    private String contrasena;
    private Date fechaInicio;
    private Date fechaFin;

    public UsuarioContrasenaBE(String indDetalle, String idUsuario, String contrasena, Date fechaInicio, Date fechaFin) {
        this.indDetalle = indDetalle;
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIndDetalle() {
        return indDetalle;
    }

    public void setIndDetalle(String indDetalle) {
        this.indDetalle = indDetalle;
    }
    
            
}
