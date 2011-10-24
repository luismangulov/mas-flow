/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

/**
 *
 * @author victor
 */
public class AlmacenBE {
    
    private String idAlmacen;
    private String nombre;
    private double largo;
    private double ancho;
    private String direccion;
    private String telefono;
    private String idDistrito;
    private String idProvincia;
    private String idDepartamento;
    private String indActivo;

    public AlmacenBE() {
    }

    public AlmacenBE(String idAlmacen, String nombre, double largo, double ancho, String direccion, String telefono, String idDistrito, String idProvincia, String idDepartamento, String indActivo) {
        this.idAlmacen = idAlmacen;
        this.nombre = nombre;
        this.largo = largo;
        this.ancho = ancho;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idDistrito = idDistrito;
        this.idProvincia = idProvincia;
        this.idDepartamento = idDepartamento;
        this.indActivo = indActivo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(String idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(String idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(String idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getIndActivo() {
        return indActivo;
    }

    public void setIndActivo(String indActivo) {
        this.indActivo = indActivo;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
