/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity;

import java.util.ArrayList;

/**
 *
 * @author florencio
 */
public class PerfilBE {
    
    private String idPerfil;
    private ArrayList<PerfilDetalleBE> listaPerfilDetalles = new ArrayList<PerfilDetalleBE>();
    private String descripcion;
    private String indActivo;

    public PerfilBE() {

    }

    public PerfilBE(String idPerfil, String descripcion, String indActivo) {
        this.idPerfil = idPerfil;
        this.descripcion = descripcion;
        this.indActivo = indActivo;
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
