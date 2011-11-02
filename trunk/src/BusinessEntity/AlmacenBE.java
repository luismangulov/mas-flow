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
    
    private String idAlmacen;//6
    private String nombre;//10
    private double largo;//6,2
    private double ancho;//6,2
    private String direccion;//30
    private String telefono;//12
    private String idDistrito;//6
    private String idProvincia;//6
    private String idDepartamento;//6
    private String indActivo;//1
    private int puertaX;
    private int puertaY;
    private String identificador;


    public AlmacenBE() {
    }

    public AlmacenBE(String idAlmacen, String nombre, double largo, double ancho, String direccion,
            String telefono, String idDistrito, String idProvincia, String idDepartamento,
            String indActivo, int puertaX, int puertaY, String identificador) {
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
        this.puertaX = puertaX;
        this.puertaY = puertaY;
        this.identificador = identificador;
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

    /**
     * @return the puertaX
     */
    public int getPuertaX() {
        return puertaX;
    }

    /**
     * @param puertaX the puertaX to set
     */
    public void setPuertaX(int puertaX) {
        this.puertaX = puertaX;
    }

    /**
     * @return the puertaY
     */
    public int getPuertaY() {
        return puertaY;
    }

    /**
     * @param puertaY the puertaY to set
     */
    public void setPuertaY(int puertaY) {
        this.puertaY = puertaY;
    }

    /**
     * @return the identificador
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

}
