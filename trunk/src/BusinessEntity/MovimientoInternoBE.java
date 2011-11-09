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
public class MovimientoInternoBE {
    
    private String idMovimiento;
    private String idUbicacionOrigen;
    private String idUbicacionDestino;
    private Date fecha;
    private String descripcion;
    private String idPallet;
    private String idAlmacen;
    private String idUsuario;


    public MovimientoInternoBE() {
    }

    public MovimientoInternoBE(String idMovimiento, String idUbicacionOrigen, String idUbicacionDestino, Date fecha, String descripcion, String idPallet, String idAlmacen,String idUsuario) {
        this.idMovimiento = idMovimiento;
        this.idUbicacionOrigen = idUbicacionOrigen;
        this.idUbicacionDestino = idUbicacionDestino;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.idPallet = idPallet;
        this.idAlmacen = idAlmacen;
        this.idUsuario = idUsuario;           
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(String idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getIdPallet() {
        return idPallet;
    }

    public void setIdPallet(String idPallet) {
        this.idPallet = idPallet;
    }

    public String getIdUbicacionDestino() {
        return idUbicacionDestino;
    }

    public void setIdUbicacionDestino(String idUbicacionDestino) {
        this.idUbicacionDestino = idUbicacionDestino;
    }

    public String getIdUbicacionOrigen() {
        return idUbicacionOrigen;
    }

    public void setIdUbicacionOrigen(String idUbicacionOrigen) {
        this.idUbicacionOrigen = idUbicacionOrigen;
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
    
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    
}
