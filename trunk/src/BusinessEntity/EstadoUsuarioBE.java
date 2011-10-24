/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

/**
 *
 * @author Florencio
 */
public class EstadoUsuarioBE {
    private String idEstadoUsuario;
    private String descripcion;

    public EstadoUsuarioBE() {
    }

    public EstadoUsuarioBE(String idEstadoUsuario, String descripcion) {
        this.idEstadoUsuario = idEstadoUsuario;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdEstadoUsuario() {
        return idEstadoUsuario;
    }

    public void setIdEstadoUsuario(String idEstadoUsuario) {
        this.idEstadoUsuario = idEstadoUsuario;
    }
    
    
}
