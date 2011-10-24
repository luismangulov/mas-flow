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
public class GuiaRemisionBE {
    private String codigo;
    private Date fecha;
    private EntidadBE cliente;
    private String estado;
    
    /**
     * @return the codigo
     */
    public GuiaRemisionBE(String codigo,Date fecha,String codCliente,String estado){
        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = null;
        this.cliente.setIdEntidad(codCliente);
        this.estado = estado;
    }
    public GuiaRemisionBE(String codigo,Date fecha,EntidadBE objCliente){
        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = null;
        this.cliente.setIdEntidad(objCliente.getIdEntidad());
        this.cliente.setNroDocumento(objCliente.getNroDocumento()) ;
        this.cliente.setDireccion(objCliente.getDireccion());
        this.cliente.setTelefono(objCliente.getTelefono());
        this.cliente.setEmail(objCliente.getEmail());
        this.cliente.setNombreContacto(objCliente.getNombreContacto());
        this.cliente.setDniContacto(objCliente.getDniContacto());
        this.cliente.setTelefonoContacto(objCliente.getTelefonoContacto());
        this.cliente.setIdTipoPersona(objCliente.getIdTipoPersona());
        this.cliente.setRazonSocial(objCliente.getRazonSocial());
        this.cliente.setPaginaWeb(objCliente.getPaginaWeb());
        this.cliente.setIdTipoEntidad(objCliente.getIdTipoEntidad());
        this.cliente.setIndActivo(objCliente.getIndActivo());
        this.cliente.setIdCIUU(objCliente.getIdCIUU());
    }
    
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
     * @return the cliente
     */
    public EntidadBE getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(EntidadBE cliente) {
        this.cliente = cliente;
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
