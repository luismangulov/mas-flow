/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity;
import java.util.Date;
/**
 *
 * @author giuliana
 */
public class EntidadBE {

private String IdEntidad;
private String NroDocumento;
private String Direccion;
private String Telefono;
private String Email;
private String NombreContacto;
private String DNIContacto;
private String TelefonoContacto;
private String ApellidoPaterno;
private String ApellidoMaterno;
private Character Sexo;
private Date FechaNacimiento;
private String IdEstadoEntidad;
private String IdTipoPersona;
private String RazonSocial;
private String PaginaWeb;
private String IdTipoEntidad;

  
    
    public EntidadBE(String IdEntidad,String RUCDNI,String Direccion,String Telefono,
        String Email,String NombreContacto,String DNIContacto,String TelefonoContacto,
        String ApellidoPaterno,String ApellidoMaterno,Character Sexo,Date FechaNacimiento,
        String IdEstadoEntidad,String IdTipoPersona,String RazonSocial,String PaginaWeb,
        String IdTipoEntidad){


        this.IdEntidad=IdEntidad;
        this.NroDocumento=NroDocumento;
        this.Direccion=Direccion;
        this.Telefono=Telefono;
        this.Email=Email;
        this.NombreContacto=NombreContacto;
        this.DNIContacto=DNIContacto;
        this.TelefonoContacto=TelefonoContacto;
        this.ApellidoPaterno=ApellidoPaterno;
        this.ApellidoMaterno=ApellidoMaterno;
        this.Sexo=Sexo;
        this.FechaNacimiento=FechaNacimiento;
        this.IdEstadoEntidad=IdEstadoEntidad;
        this.IdTipoPersona=IdTipoPersona;
        this.RazonSocial=RazonSocial;
        this.PaginaWeb=PaginaWeb;
        this.IdTipoEntidad=IdTipoEntidad;


    }




}
