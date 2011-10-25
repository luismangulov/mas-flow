/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

import java.sql.Date;

/**
 *
 * @author victor
 */
public class PalletBE {
    
    private String idPallet;
    private String idProducto;
    private String indActivo; // 0: vacío, 1: ocupado, 2: averiado
    private String idUbicacion;
    private String idAlmacen;
    private Date fechaVencimiento;

    public PalletBE() {
    }

    public PalletBE(String idPallet, String idProducto, String indActivo, String idUbicacion, String idAlmacen, Date fechaVencimiento) {
        this.idPallet = idPallet;
        this.idProducto = idProducto;
        this.indActivo = indActivo;
        this.idUbicacion = idUbicacion;
        this.idAlmacen = idAlmacen;
        this.fechaVencimiento = fechaVencimiento;
    }
    
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(String idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getIdPallet() {
        return idPallet;
    }

    public void setIdPallet(String idPallet) {
        this.idPallet = idPallet;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
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
