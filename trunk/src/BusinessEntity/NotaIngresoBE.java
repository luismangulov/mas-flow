/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

import java.util.Date;

/**
 *
 * @author DIEGO
 */
public class NotaIngresoBE {
    private String codigo;
    private Date fecha;
    private EntidadBE proveedor;
    private String estado;

    
    public NotaIngresoBE(String codigo,Date fecha,String codProveedor,String estado){
        this.codigo = codigo;
        this.fecha = fecha;
        this.proveedor = null;
        this.proveedor.setIdEntidad(codProveedor);
        this.estado = estado;
    }
    
    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the proveedor
     */
    public EntidadBE getProveedor() {
        return proveedor;
    }

    /**
     * @param cliente the proveedor to set
     */
    public void setProveedor(EntidadBE proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
