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
    private EntidadBE proveedor = new EntidadBE();
    private EstadoNIBE estado = new EstadoNIBE();
    
    public NotaIngresoBE(String codigo,Date fecha,String codProveedor,EstadoNIBE estado){
        this.codigo = codigo;
        this.fecha = fecha;
        this.proveedor.setIdEntidad(codProveedor);
        this.estado = estado;
    }
    
     public NotaIngresoBE(String codigo,Date fecha,EntidadBE objProveedor,EstadoNIBE estado){
        this.codigo = codigo;
        this.fecha = fecha;
//        this.proveedor.setIdEntidad(objProveedor.getIdEntidad());
//        this.proveedor.setNroDocumento(objProveedor.getNroDocumento()) ;
//        this.proveedor.setDireccion(objProveedor.getDireccion());
//        this.proveedor.setTelefono(objProveedor.getTelefono());
//        this.proveedor.setEmail(objProveedor.getEmail());
//        this.proveedor.setNombreContacto(objProveedor.getNombreContacto());
//        this.proveedor.setDniContacto(objProveedor.getDniContacto());
//        this.proveedor.setTelefonoContacto(objProveedor.getTelefonoContacto());
//        this.proveedor.setRazonSocial(objProveedor.getRazonSocial());
//        this.proveedor.setPaginaWeb(objProveedor.getPaginaWeb());
//        this.proveedor.setIndActivo(objProveedor.getIndActivo());
//        this.proveedor.setIdCIUU(objProveedor.getIdCIUU());
        this.proveedor = objProveedor;
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
    public EstadoNIBE getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EstadoNIBE estado) {
        this.estado = estado;
    }

    
    
}
