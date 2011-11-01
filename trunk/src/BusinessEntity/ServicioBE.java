/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

/**
 *
 * @author Florencio
 */
public class ServicioBE {
    private String idServicio;
    private String Descripcion;

    public ServicioBE() {
    }
    

    public ServicioBE(String idServicio, String Descripcion) {
        this.idServicio = idServicio;
        this.Descripcion = Descripcion;
    }

    
    public String getIdDescripcion() {
        return Descripcion;
    }

    public void setIdDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }
    
    
}
