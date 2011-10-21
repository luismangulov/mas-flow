/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

/**
 *
 * @author DIEGO
 */
public class UnidadMedidaBE {
    private String idUnidadMedida;
    private String nombre;
    private String descripcion;
    private String estado;

    public UnidadMedidaBE(){}

    public UnidadMedidaBE(String idUnidadMedida, String nombre, String descripcion, String estado) {
        this.idUnidadMedida = idUnidadMedida;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getidUnidadMedida() {
        return idUnidadMedida;
    }

    public void setidUnidadMedida(String idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
