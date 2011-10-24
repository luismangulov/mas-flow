/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

/**
 *
 * @author Florencio
 */
public class PerfilDetalleBE {
    
    private PerfilBE perfil;
    private String indDetalle;
    private AplicacionxServicioBE aplicacionxservicio;

    public AplicacionxServicioBE getAplicacionxservicio() {
        return aplicacionxservicio;
    }

    public void setAplicacionxservicio(AplicacionxServicioBE aplicacionxservicio) {
        this.aplicacionxservicio = aplicacionxservicio;
    }

    public String getIndDetalle() {
        return indDetalle;
    }

    public void setIndDetalle(String indDetalle) {
        this.indDetalle = indDetalle;
    }

    public PerfilBE getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilBE perfil) {
        this.perfil = perfil;
    }
    
    
    
    
}
