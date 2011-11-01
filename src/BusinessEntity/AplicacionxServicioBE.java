package BusinessEntity;

import java.util.ArrayList;

/**
 *
 * @author Florencio
 */
public class AplicacionxServicioBE {
    
    private AplicacionBE aplicacion;
    private ArrayList<ServicioBE> listaServicios = new ArrayList<ServicioBE>();

    public AplicacionxServicioBE() {
    }

    
    public AplicacionxServicioBE(AplicacionBE aplicacion, ArrayList<ServicioBE> listaServicios) {
        this.aplicacion = aplicacion;
        this.listaServicios=listaServicios;
    }
  
    
    public AplicacionBE getAplicacion() {
        return aplicacion;
    }
    


    public void setAplicacion(AplicacionBE aplicacion) {
        this.aplicacion = aplicacion;
    }

    public ArrayList<ServicioBE> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(ArrayList<ServicioBE> listaServicios) {
        this.listaServicios = listaServicios;
    }

}
