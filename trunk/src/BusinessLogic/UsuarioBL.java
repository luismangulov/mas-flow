/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Util.Utilitario;
import BusinessEntity.UsuarioBE;
import DataAccess.UsuarioDA;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Florencio
 */
public class UsuarioBL {
    
    
    private UsuarioBE usuario;
    
    public boolean insertar(String nombre,String paterno,String materno, String password,String idPerfil, String idEstadoUsuario,int limiteIntentos, Date fechaCambioClave ) throws Exception{
        boolean exito = false;
        usuario = new UsuarioBE(Utilitario.generaCodigo("usuario",6),nombre,paterno,materno, password, idPerfil,idEstadoUsuario,limiteIntentos,fechaCambioClave);
        UsuarioDA objUsuarioDA = new UsuarioDA();
        exito = objUsuarioDA.insertar(getUsuario());
        return exito;
    }
    
    public boolean eliminar(String idUsuario) throws Exception{
        boolean exito = false;
        UsuarioDA objUsuarioDA = new UsuarioDA();
        exito = objUsuarioDA.eliminar(idUsuario);
        return exito;
    }
//    public String getIdUsuario(String nombreFamilia){
//        FamiliaDA familiaDA = new FamiliaDA();
//        familia = new FamiliaBE();
//        familia = familiaDA.queryByNombreFamilia(nombreFamilia);
//        if (familia == null)
//            return "";
//        return familia.getIdFamilia();
//    }

    public ArrayList<UsuarioBE> queryAllUsuario(){
        UsuarioDA objUsuarioDA = new UsuarioDA();
        return objUsuarioDA.queryAllFamilia();
    }
    
    public UsuarioBE queryByIdFamilia(String idUsuario){
        UsuarioDA objUsuarioDA = new UsuarioDA();
        return objUsuarioDA.queryByIdUsuario(idUsuario);
    }
    
     public boolean modificar(UsuarioBE objUsuario) throws Exception{
          boolean exito = false;
          UsuarioDA objUsuarioDA = new UsuarioDA();
          exito = objUsuarioDA.modificar(objUsuario);
          return exito;
     }
    
     public ArrayList<UsuarioBE> buscar(String idUsuario,String nombre, String paterno,String materno,String idPerfil, String idEstado){
          UsuarioDA objUsuarioDA = new UsuarioDA();
          return objUsuarioDA.buscar(idUsuario, nombre,paterno,materno,idPerfil,idEstado);
     }
     
//     public ArrayList<FamiliaBE> buscarAyuda(String codigo,String nombre){
//         FamiliaDA objFamiliaDA = new FamiliaDA();
//         return objFamiliaDA.buscarAyuda(codigo, nombre);
//     }
     

    public UsuarioBE getUsuario() {
        return usuario;
    }

    public UsuarioBE setUsuario(String idUsuario,String nombre,String paterno,String materno,String password,String idPerfil, String idEstadoUsuario,int limiteIntentos, Date fechaCambioClave) {
        usuario = new UsuarioBE(idUsuario,nombre,paterno,materno,password,idPerfil,idEstadoUsuario,limiteIntentos,fechaCambioClave);
        return usuario;
    }

    public ArrayList<UsuarioBE> getAllFamilia() {
        ArrayList<UsuarioBE>  arrUsuario = null;
        UsuarioDA objUsuarioDA = new UsuarioDA();
        arrUsuario = objUsuarioDA.queryAllUsuario();
        return arrUsuario;
    }
    
    
}
