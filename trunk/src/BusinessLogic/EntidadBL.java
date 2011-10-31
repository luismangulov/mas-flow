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
        public boolean insertar(String idEntidad, String nroDocumento, String direccion,
    String telefono, String email, String nombreContacto, String dniContacto,
    String telefonoContacto, String razonSocial,
    String paginaWeb,  String indActivo, String idCIUU) throws Exception{
        boolean exito = false;
        EntidadBE Entidad = new EntidadBE(idEntidad, nroDocumento,  direccion,
            telefono, email, nombreContacto, dniContacto, telefonoContacto, razonSocial,
            paginaWeb, indActivo, idCIUU);
        EntidadDA objEntidadDA = new EntidadDA();
        exito = objEntidadDA.insertar(Entidad);
        return exito;
        }

         public boolean modificar( String idEntidad, String nroDocumento, String direccion,
    String telefono, String email, String nombreContacto, String dniContacto,
    String telefonoContacto, String razonSocial,
    String paginaWeb,  String indActivo, String idCIUU) throws Exception{
        boolean exito = false;
        EntidadBE Entidad = new EntidadBE(idEntidad, nroDocumento,  direccion,
            telefono, email, nombreContacto, dniContacto, telefonoContacto, razonSocial,
            paginaWeb, indActivo, idCIUU);
        EntidadDA objEntidadDA = new EntidadDA();
        exito = objEntidadDA.modificar(Entidad);
        return exito;
        }


        public boolean eliminar(String idEntidad) throws Exception{
        boolean exito = false;
        EntidadDA objEntidadDA = new EntidadDA();
        exito = objEntidadDA.eliminar(idEntidad);
        return exito;
        }


        public ArrayList<EntidadBE> buscarCliente(String tipo, String nroDocumento,
                String razonSocial, String direccion, String indActivo){

        EntidadDA objEntidadDA = new EntidadDA();
        return objEntidadDA.buscar("C", tipo, nroDocumento, razonSocial, direccion, indActivo);
        
        }


        public ArrayList<EntidadBE> buscarProveedor(String tipo, String nroDocumento,
                String razonSocial, String direccion, String indActivo) {

        EntidadDA objEntidadDA = new EntidadDA();
        return objEntidadDA.buscar("P", tipo, nroDocumento, razonSocial, direccion, indActivo);

        }


        public EntidadBE getCliente(String codigo) { EntidadBE e = null;

        EntidadDA objEntidadDA = new EntidadDA();
        e = objEntidadDA.querybyCodigo(codigo);

        return e;

        }


         public EntidadBE getProveedor(String codigo) { EntidadBE e = null;

        EntidadDA objEntidadDA = new EntidadDA();
        e = objEntidadDA.querybyCodigo(codigo);

        return e;

        }


        public ArrayList<EntidadBE> getAllClientes() throws Exception{
        ArrayList<EntidadBE>  arrEntidades = null;

        EntidadDA objEntidadDA = new EntidadDA();
        arrEntidades = objEntidadDA.queryAllEntidad("C");
        return arrEntidades;
        }

        public ArrayList<EntidadBE> getAllProveedores() throws Exception{
        ArrayList<EntidadBE>  arrEntidades = null;

        EntidadDA objEntidadDA = new EntidadDA();
        arrEntidades = objEntidadDA.queryAllEntidad("P");
        return arrEntidades;
        }



        public ArrayList<EntidadBE> getAllClientesActivos() throws Exception{
        ArrayList<EntidadBE>  arrEntidades = null;

        EntidadDA objEntidadDA = new EntidadDA();
        arrEntidades = objEntidadDA.queryAllEntidadActivo("C");
        return arrEntidades;
        }

        public ArrayList<EntidadBE> getAllProveedoresActivos() throws Exception{
        ArrayList<EntidadBE>  arrEntidades = null;

        EntidadDA objEntidadDA = new EntidadDA();
        arrEntidades = objEntidadDA.queryAllEntidadActivo("P");
        return arrEntidades;
        }


}