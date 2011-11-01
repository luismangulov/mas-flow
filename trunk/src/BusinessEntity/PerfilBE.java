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
    private ArrayList<PerfilDetalleBE> listaPerfilDetalle = new ArrayList<PerfilDetalleBE>();
    private String indActivo;

    public PerfilBE() {

    }
    
   public PerfilBE(String idPerfil,String descripcion,ArrayList<PerfilDetalleBE>listaPerfilDetalle,String indActivo){
   //public PerfilBE(String idPerfil,String descripcion,PerfilDetalleBE perfilDetalle,String indActivo){
   
        this.idPerfil=idPerfil;
        this.descripcion=descripcion;
        //this.listaPerfilDetalles=listaPerfilDetalles;
        this.listaPerfilDetalle=listaPerfilDetalle;
        this.indActivo=indActivo;
        
    }

    public PerfilBE(String idPerfil, String descripcion, String indActivo) {
        this.idPerfil = idPerfil;
        this.descripcion = descripcion;
        this.indActivo = indActivo;
    } 

    public ArrayList<PerfilDetalleBE> getListaPerfilDetalle() {
        return listaPerfilDetalle;
    }

    public void setListaPerfilDetalle(ArrayList<PerfilDetalleBE> listaPerfilDetalles) {
        this.listaPerfilDetalle = listaPerfilDetalles;
    }

//    public PerfilDetalleBE getPerfilDetalle() {
//        return perfilDetalle;
//    }
//
//    public void setPerfilDetalle(PerfilDetalleBE perfilDetalle) {
//        this.perfilDetalle = perfilDetalle;
//    }
    
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
