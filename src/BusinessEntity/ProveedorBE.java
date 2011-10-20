/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity;

/**
 *
 * @author victor
 */
public class ProveedorBE {
    private String codigo;
    private String NroDocumento;
    private String razonSocial;
    private String ciuu;
    private String direccion;
    private String telefono;
    private String paginaWeb;
    private String email;
    private String nombreContacto;
    private String DNIContacto;
    private String telefonoContacto;
    private char tipoPersona;

    public char getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(char tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getCiuu() {
        return ciuu;
    }

    public void setCiuu(String ciuu) {
        this.ciuu = ciuu;
    }

    public String getDNIContacto() {
        return DNIContacto;
    }

    public void setDNIContacto(String DNIContacto) {
        this.DNIContacto = DNIContacto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getNroDocumento() {
        return NroDocumento;
    }

    public void seNroDocumento(String NroDocumento) {
        this.NroDocumento = NroDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

   
   


}
