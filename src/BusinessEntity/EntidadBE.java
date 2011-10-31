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

    private String idEntidad;//13
    private String nroDocumento;//11
    private String direccion;//60
    private String telefono;//12
    private String email;//30
    private String nombreContacto;//30
    private String dniContacto;//8
    private String telefonoContacto;//12
    private String razonSocial;//60
    private String paginaWeb;//30
    private String indActivo;//1
    private String idCIUU;//1

    public EntidadBE(){}

    public EntidadBE(String idEntidad, String nroDocumento, String direccion,
    String telefono, String email, String nombreContacto, String dniContacto,
    String telefonoContacto, String razonSocial,
    String paginaWeb,  String indActivo, String idCIUU)
    {


        this.idEntidad=idEntidad;
        this.nroDocumento=nroDocumento;
        this.direccion=direccion;
        this.telefono=telefono;
        this.email=email;
        this.nombreContacto=nombreContacto;
        this.dniContacto=dniContacto;
        this.telefonoContacto=telefonoContacto;
        this.razonSocial=razonSocial;
        this.paginaWeb=paginaWeb;
        this.indActivo=indActivo;
        this.idCIUU=idCIUU;

    }

    /**
     * @return the idEntidad
     */
    public String getIdEntidad() {
        return idEntidad;
    }

    /**
     * @param idEntidad the idEntidad to set
     */
    public void setIdEntidad(String idEntidad) {
        this.idEntidad = idEntidad;
    }

    /**
     * @return the nroDocumento
     */
    public String getNroDocumento() {
        return nroDocumento;
    }

    /**
     * @param nroDocumento the nroDocumento to set
     */
    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nombreContacto
     */
    public String getNombreContacto() {
        return nombreContacto;
    }

    /**
     * @param nombreContacto the nombreContacto to set
     */
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    /**
     * @return the dniContacto
     */
    public String getDniContacto() {
        return dniContacto;
    }

    /**
     * @param dniContacto the dniContacto to set
     */
    public void setDniContacto(String dniContacto) {
        this.dniContacto = dniContacto;
    }

    /**
     * @return the telefonoContacto
     */
    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    /**
     * @param telefonoContacto the telefonoContacto to set
     */
    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    /**
     * @return the razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * @param razonSocial the razonSocial to set
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * @return the paginaWeb
     */
    public String getPaginaWeb() {
        return paginaWeb;
    }

    /**
     * @param paginaWeb the paginaWeb to set
     */
    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    /**
     * @return the indActivo
     */
    public String getIndActivo() {
        return indActivo;
    }

    /**
     * @param indActivo the indActivo to set
     */
    public void setIndActivo(String indActivo) {
        this.indActivo = indActivo;
    }

    /**
     * @return the idCIUU
     */
    public String getIdCIUU() {
        return idCIUU;
    }

    /**
     * @param idCIUU the idCIUU to set
     */
    public void setIdCIUU(String idCIUU) {
        this.idCIUU = idCIUU;
    }




}
