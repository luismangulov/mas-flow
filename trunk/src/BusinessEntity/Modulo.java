/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

import java.util.ArrayList;

/**
 *
 * @author Florencio
 */
public class Modulo {
    private String idModulo;
    private String descripcion;
    private ArrayList<AplicacionxServicioBE> listaAplicacionxServicioBE = new ArrayList<AplicacionxServicioBE>();

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public ArrayList<AplicacionxServicioBE> getListaAplicacionxServicioBE() {
        return listaAplicacionxServicioBE;
    }

    public void setListaAplicacionxServicioBE(ArrayList<AplicacionxServicioBE> listaAplicacionxServicioBE) {
        this.listaAplicacionxServicioBE = listaAplicacionxServicioBE;
    }
    
    
}
