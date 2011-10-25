/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity;

/**
 *
 * @author giuliana
 */
public class ProvinciaBE {

    private String idProvincia;
    private String descripcion;
    private String idDepartamento;

    public ProvinciaBE(String idDepartamento, String idProvincia,String descripcion){

        this.idDepartamento=idDepartamento;
        this.idProvincia=idProvincia;
        this.descripcion=descripcion;
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

}
