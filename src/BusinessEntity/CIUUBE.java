/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity;

/**
 *
 * @author giuliana
 */
public class CIUUBE {

    private String idCIUU;
    private String descripcion;

    public CIUUBE(){

    }

    public CIUUBE(String idCIUU, String descripcion){

        this.idCIUU=idCIUU;
        this.descripcion=descripcion;

    }

    /**
     * @return the idCIUU
     */
    public String getIdCIUU() {
        return idCIUU;
    }

    /**
     * @param idCIUU the idCIUU to set
     */
    public void setIdCIUU(String idCIUU) {
        this.idCIUU = idCIUU;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
