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
    private String indActivo;
    private String idAlmacen;
    private Double largo;
    private Double ancho;
    private int posX;
    private int posY;
    private String identificador;
    
    public ZonaBE() {
    }

    public ZonaBE(String idZona, String nombre, String indActivo, String idAlmacen, Double largo, Double ancho, int posX, int posY, String identificador) {
        this.idZona = idZona;
        this.nombre = nombre;
        this.indActivo = indActivo;
        this.idAlmacen = idAlmacen;
        this.largo = largo;
        this.ancho = ancho;
        this.posX = posX;
        this.posY = posY;
        this.identificador = identificador;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
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

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getIndActivo() {
        return indActivo;
    }

    public void setIndActivo(String indActivo) {
        this.indActivo = indActivo;
    }

    public Double getLargo() {
        return largo;
    }

    public void setLargo(Double largo) {
        this.largo = largo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    
}
