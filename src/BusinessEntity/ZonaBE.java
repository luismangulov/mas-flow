/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class ZonaBE {
    private String idZona;//6
    private String nombre;//30
    private String identificador;//13
    private String indActivo;//1
    private String idAlmacen;//6
    private int posX;//6
    private int posY; //6
    private int largo;//6
    private int ancho; //6
    private ArrayList <FamiliaBE> familias;
    
    

    public ZonaBE() {
    }

    public ZonaBE(String idZona, String nombre, String identificador, String indActivo,
            String idAlmacen, int posX, int posY, int ancho, int largo, ArrayList <FamiliaBE> familias) {
        this.idZona = idZona;
        this.nombre = nombre;
        this.identificador = identificador;
        this.indActivo = indActivo;
        this.idAlmacen = idAlmacen;
        this.posX =posX;
        this.posY=posY;
        this.ancho=ancho;
        this.largo=largo;
        this.familias=familias;



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

    /**
     * @return the posX
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @param posX the posX to set
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * @return the posY
     */
    public int getPosY() {
        return posY;
    }

    /**
     * @param posY the posY to set
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * @return the largo
     */
    public int getLargo() {
        return largo;
    }

    /**
     * @param largo the largo to set
     */
    public void setLargo(int largo) {
        this.largo = largo;
    }

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
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

    /**
     * @return the familias
     */
    public ArrayList<FamiliaBE> getFamilias() {
        return familias;
    }

    /**
     * @param familias the familias to set
     */
    public void setFamilias(ArrayList<FamiliaBE> familias) {
        this.familias = familias;
    }
}
