/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

/**
 *
 * @author victor
 */
public class ZonaBE {
    private String idZona;
    private String nombre;
    private String descripcion;
    private String indActivo;
    private String idAlmacen;

    public ZonaBE() {
    }

    public ZonaBE(String idZona, String nombre, String descripcion, String indActivo, String idAlmacen) {
        this.idZona = idZona;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.indActivo = indActivo;
        this.idAlmacen = idAlmacen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(String idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getIdZona() {
        return idZona;
    }

    public void setIdZona(String idZona) {
        this.idZona = idZona;
    }

    public String getIndActivo() {
        return indActivo;
    }

    public void setIndActivo(String indActivo) {
        this.indActivo = indActivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
