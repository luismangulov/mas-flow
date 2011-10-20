/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

import BD.Utilitario;
import BusinessEntity.EntidadBE;
import DataAccess.EntidadDA;

/**
 *
 * @author giuliana
 */
public class EntidadBL {
        public boolean insertarEntidad( String nroDocumento, String direccion,
            String telefono, String email, String nombreContacto, String dniContacto,
            String telefonoContacto, String idTipoPersona, String razonSocial,
            String paginaWeb, String idTipoEntidad, String indActivo, String idCIUU) throws Exception{
        boolean exito = false;
        EntidadBE Entidad = new EntidadBE(Utilitario.generaCodigo("Entidad",6),nroDocumento,
                direccion,telefono, email, nombreContacto, dniContacto, telefonoContacto,
                idTipoPersona, razonSocial, paginaWeb, idTipoEntidad, indActivo, idCIUU);
        EntidadDA objEntidadDA = new EntidadDA();
        exito = objEntidadDA.insertar(Entidad);
        return exito;
    }
}
