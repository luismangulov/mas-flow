/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

import java.util.Date;

/**
 *
 * @author victor
 */
public class PalletBE {
    
    private String idPallet;
    private String idProducto;
    private String indActivo; // 1: ocupado, 2: despachado, 3: desechado
    private String idUbicacion;
    private String idAlmacen;
    private Date fechaVencimiento;
    private String idNotaIngreso;
    private String idGuiaRemision;


    public PalletBE() {
    }

    public PalletBE(String idPallet, String idProducto, String indActivo, String idUbicacion, String idAlmacen, Date fechaVencimiento,String idNotaIngreso, String idGuiaRemision) {
        this.idPallet = idPallet;
        this.idProducto = idProducto;
        this.indActivo = indActivo;
        this.idUbicacion = idUbicacion;
        this.idAlmacen = idAlmacen;
        this.fechaVencimiento = fechaVencimiento;
        this.idNotaIngreso = idNotaIngreso;
        this.idGuiaRemision = idGuiaRemision;
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
    
    public String getIdNotaIngreso() {
        return idNotaIngreso;
    }

    public void setIdNotaIngreso(String idNotaIngreso) {
        this.idNotaIngreso = idNotaIngreso;
    }
    
    public String getIdGuiaRemision() {
        return idGuiaRemision;
    }

    public void setIdGuiaRemision(String idGuiaRemision) {
        this.idGuiaRemision = idGuiaRemision;
    }

}
