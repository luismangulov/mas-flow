/*
 * To change this template, choose Tools | Templates
 * and open the templpublic DepartamentoBE(String idDepartamento, String descripcion){
    
        this.idDepartamento=idDepartamento;
        this.descripcion=descripcion;
    }ate in the editor.
 */

package BusinessEntity;

/**
 *
 * @author giuliana
 */
public class DepartamentoBE {

    private String idDepartamento;
    private String descripcion;

    public DepartamentoBE(String idDepartamento, String descripcion){
    
        this.idDepartamento=idDepartamento;
        this.descripcion=descripcion;
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
