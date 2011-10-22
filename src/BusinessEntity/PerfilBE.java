/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity;

/**
 *
 * @author florencio
 */
public class PerfilBE {
    private String idPerfil;
    private String descripcion;
    private String indActivo;

    public PerfilBE() {

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getIndActivo() {
        return indActivo;
    }

    public void setIndActivo(String indActivo) {
        this.indActivo = indActivo;
    }

}
