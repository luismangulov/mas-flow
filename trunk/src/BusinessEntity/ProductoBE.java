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
    private String codigo;
    private String nombre;
    private String descripcion;
    private int maxCantPorPallet;
    private FamiliaBE familia;
    private UnidadMedidaBE unidadMedida;
    private double precio;
    private String estado;


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public FamiliaBE getFamilia() {
        return familia;
    }

    public void setFamilia(FamiliaBE familia) {
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public UnidadMedidaBE getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedidaBE unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
}
