/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

import Util.Utilitario;
import BusinessEntity.EntidadBE;
import DataAccess.EntidadDA;
import java.util.ArrayList;

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


        public ArrayList<EntidadBE> buscarEntidad(String idEntidad, String nroDocumento, String razonSocial,
              String idCIUU, String indActivo, String tipoEntidad) throws Exception{

            ArrayList<EntidadBE> arrEntidad;
        
        EntidadDA objEntidadDA = new EntidadDA();
        arrEntidad = objEntidadDA.buscar( idEntidad,  nroDocumento,  razonSocial,
               idCIUU,  indActivo,  tipoEntidad);
        return arrEntidad;
        }

        public EntidadBE getCliente(String codigo) throws Exception{ EntidadBE e = null;

        EntidadDA objEntidadDA = new EntidadDA();
        e = objEntidadDA.queryClientebyCodigo(codigo);

        return e;
        
        }

        public ArrayList<EntidadBE> getAllClientes() throws Exception{
        ArrayList<EntidadBE>  arrEntidades = null;
       
        EntidadDA objEntidadDA = new EntidadDA();
        arrEntidades = objEntidadDA.queryAllEntidad("C");
        return arrEntidades;
        }

        public ArrayList<EntidadBE> getAllClientesActivos() throws Exception{
        ArrayList<EntidadBE>  arrEntidades = null;
       
        EntidadDA objEntidadDA = new EntidadDA();
        arrEntidades = objEntidadDA.queryAllEntidadActivo("C");
        return arrEntidades;
        }


}
