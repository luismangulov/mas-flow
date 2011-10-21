/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

/**
 *
 * @author DIEGO
 */
public class FamiliaBE {
    private String idFamilia;
    private String nombre;
    private String descripcion;
    private String indActivo;

    /**
     * @return the codigo
     */

    public FamiliaBE(){}

    public FamiliaBE(String idFamilia,String nombre,String descripcion, String indActivo){
        this.idFamilia = idFamilia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.indActivo = indActivo;
    }
           
    public String getIdFamilia() {
        return idFamilia;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setIdFamilia(String idFamilia) {
        this.idFamilia = idFamilia;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @return the estado
     */
    public String getEstado() {
        return indActivo;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String indActivo) {
        this.indActivo = indActivo;
    }
}
