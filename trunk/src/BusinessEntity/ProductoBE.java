/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

/**
 *
 * @author DIEGO
 */
public class ProductoBE {

    private String idProducto;
    private String nombre;
    private String descripcion;
    private int maxCantPorPallet;
    private String unidadMedida;
    private String familia;
    private String indActivo;

    public ProductoBE(){}

    public ProductoBE(String idProducto, String nombre, String descripcion, int maxCantPorPallet,
                      String unidadMedida, String familia, String indActivo){
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.maxCantPorPallet = maxCantPorPallet;
        this.unidadMedida = unidadMedida;
        this.familia = familia;
        this.indActivo = indActivo;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return indActivo;
    }

    public void setEstado(String indActivo) {
        this.indActivo = indActivo;
    }

    public String getIdFamilia() {
        return familia;
    }

    public void setIdFamilia(String familia) {
        this.familia = familia;
    }

    public int getMaxCantPorPallet() {
        return maxCantPorPallet;
    }

    public void setMaxCantPorPallet(int maxCantPorPallet) {
        this.maxCantPorPallet = maxCantPorPallet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdUnidadMedida() {
        return unidadMedida;
    }

    public void setIdUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
}
