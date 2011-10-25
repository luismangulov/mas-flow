/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity;

/**
 *
 * @author giuliana
 */
public class DistritoBE {

    private String idDistrito;
    private String descripcion;
    private String idDepartamento;
    private String idProvincia;

    public DistritoBE(String idDepartamento, String idProvincia, String idDistrito, String descripcion){

        this.idDepartamento=idDepartamento;
        this.idProvincia=idProvincia;
        this.idDistrito=idDistrito;
        this.descripcion=descripcion;
    }

    /**
     * @return the idDistrito
     */
    public String getIdDistrito() {
        return idDistrito;
    }

    /**
     * @param idDistrito the idDistrito to set
     */
    public void setIdDistrito(String idDistrito) {
        this.idDistrito = idDistrito;
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

    /**
     * @return the idDepartamento
     */
    public String getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * @param idDepartamento the idDepartamento to set
     */
    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    /**
     * @return the idProvincia
     */
    public String getIdProvincia() {
        return idProvincia;
    }

    /**
     * @param idProvincia the idProvincia to set
     */
    public void setIdProvincia(String idProvincia) {
        this.idProvincia = idProvincia;
    }
}
