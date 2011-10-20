/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity;

/**
 *
 * @author giuliana
 */
public class EntidadBE {

    private String idEntidad;
    private String nroDocumento;
    private String direccion;
    private String telefono;
    private String email;
    private String nombreContacto;
    private String dniContacto;
    private String telefonoContacto;
    private String idTipoPersona;
    private String razonSocial;
    private String paginaWeb;
    private String idTipoEntidad;
    private String indActivo;
    private String idCIUU;



    public EntidadBE(String idEntidad, String nroDocumento, String direccion,
    String telefono, String email, String nombreContacto, String dniContacto,
    String telefonoContacto, String idTipoPersona, String razonSocial,
    String paginaWeb, String idTipoEntidad, String indActivo, String idCIUU){


        this.idEntidad=idEntidad;
        this.nroDocumento=nroDocumento;
        this.direccion=direccion;
        this.telefono=telefono;
        this.email=email;
        this.nombreContacto=nombreContacto;
        this.dniContacto=dniContacto;
        this.telefonoContacto=telefonoContacto;
        this.idTipoPersona=idTipoPersona;
        this.razonSocial=razonSocial;
        this.paginaWeb=paginaWeb;
        this.idTipoEntidad=idTipoEntidad;
        this.indActivo=indActivo;
        this.idCIUU=idCIUU;

    }




}
