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
    private String descripcion;
    private ArrayList<PerfilDetalleBE> listaPerfilDetalles = new ArrayList<PerfilDetalleBE>();
    private String indActivo;

    public PerfilBE() {

    }
    
    public PerfilBE(String idPerfil,String descripcion,ArrayList<PerfilDetalleBE>listaPerfilDetalles){
   
        this.idPerfil=idPerfil;
        this.descripcion=descripcion;
        this.listaPerfilDetalles=listaPerfilDetalles;
        
    }

    public PerfilBE(String descripcion, String indActivo) {
        this.descripcion = descripcion;
        this.indActivo = indActivo;
    }

    public PerfilBE(String idPerfil, String descripcion, String indActivo) {
        this.idPerfil = idPerfil;
        this.descripcion = descripcion;
        this.indActivo = indActivo;
    } 

    public ArrayList<PerfilDetalleBE> getListaPerfilDetalles() {
        return listaPerfilDetalles;
    }

    public void setListaPerfilDetalles(ArrayList<PerfilDetalleBE> listaPerfilDetalles) {
        this.listaPerfilDetalles = listaPerfilDetalles;
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
