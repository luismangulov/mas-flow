/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

/**
 *
 * @author victor
 */
public class RackBE {
    private String idRack;
    private Double ancho;
    private Double alto;
    private int pisos;
    private int columnas;
    private String indActivo;
    private String idZona;

    public RackBE() {
    }

    public RackBE(String idRack, Double ancho, Double alto, int pisos, int columnas, String indActivo, String idZona) {
        this.idRack = idRack;
        this.ancho = ancho;
        this.alto = alto;
        this.pisos = pisos;
        this.columnas = columnas;
        this.indActivo = indActivo;
        this.idZona = idZona;
    }
    
        public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public String getIdRack() {
        return idRack;
    }

    public void setIdRack(String idRack) {
        this.idRack = idRack;
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

    public int getPisos() {
        return pisos;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

}
