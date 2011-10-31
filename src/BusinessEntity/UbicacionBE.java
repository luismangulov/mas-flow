/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

/**
 *
 * @author victor
 */
public class UbicacionBE {
    private String idUbicacion;
    private int fila;
    private int columna;
    private String indActivo; // 0 bloqueada, 1 disponible, 2 en uso
    private String idRack;

    public UbicacionBE() {
    }

    public UbicacionBE(String idUbicacion, int fila, int columna, String indActivo, String idRack) {
        this.idUbicacion = idUbicacion;
        this.fila = fila;
        this.columna = columna;
        this.indActivo = indActivo;
        this.idRack = idRack;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public String getIdRack() {
        return idRack;
    }

    public void setIdRack(String idRack) {
        this.idRack = idRack;
    }

    public String getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(String idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getIndActivo() {
        return indActivo;
    }

    public void setIndActivo(String indActivo) {
        this.indActivo = indActivo;
    }
}
