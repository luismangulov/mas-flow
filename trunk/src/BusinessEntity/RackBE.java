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
    private int posX;
    private int posY;
    private int pisos;
    private int columnas;
    private String indActivo;
    private String idZona;
    private String identificador;
    private String orientacion; // 'V': vertical, 'H': horizontal

    public RackBE() {
    }

    public RackBE(String idRack, int posX, int posY, int pisos, int columnas, String indActivo, String idZona, String identificador, String orientacion) {
        this.idRack = idRack;
        this.posX = posX;
        this.posY = posY;
        this.pisos = pisos;
        this.columnas = columnas;
        this.indActivo = indActivo;
        this.idZona = idZona;
        this.identificador = identificador;
        this.orientacion = orientacion;
        
    }
    
        public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
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

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }
}
