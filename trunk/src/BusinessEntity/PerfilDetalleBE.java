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
    private AplicacionBE aplicacion;
    private ServicioBE servicio;

    public PerfilDetalleBE() {
    }


    public PerfilDetalleBE(PerfilBE perfil, String indDetalle, AplicacionBE aplicacion, ServicioBE servicio) {
        this.perfil = perfil;
        this.indDetalle = indDetalle;
        this.aplicacion = aplicacion;
        this.servicio = servicio;
    }

    
    
    public AplicacionBE getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(AplicacionBE aplicacion) {
        this.aplicacion = aplicacion;
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

    public ServicioBE getServicio() {
        return servicio;
    }

    public void setServicio(ServicioBE servicio) {
        this.servicio = servicio;
    }
    
    

 
    
    
}
