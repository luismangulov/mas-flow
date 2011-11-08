/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.EstadoUsuarioBE;
import BusinessEntity.PerfilBE;
import Util.Utilitario;
import BusinessEntity.UsuarioBE;
import DataAccess.EstadoUsuarioDA;
import DataAccess.PerfilDA;
import DataAccess.UsuarioDA;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Florencio
 */
public class UsuarioBL {
    
    
    private UsuarioBE usuario;
    
    public String insertar(String idUsuario,String nombre,String paterno,String materno,String idPerfil, String idEstadoUsuario,int limiteIntentos) throws FileNotFoundException, IOException
    {
       String exito;
//        Dim odaPerfil As New PerfilDA()
//        Dim obePerfil As PerfilBE = odaPerfil.queryByIdPerfilSinDetalle(perfil)
//        Dim obeUsuario As New UsuarioBE("", codigo, obeEmpleado, obePerfil)
        PerfilDA objPerfilDA=new PerfilDA();
        PerfilBE objPerfilBE = objPerfilDA.queryById(idPerfil);
        
        EstadoUsuarioDA objEstadoUsuarioDA=new EstadoUsuarioDA();
        EstadoUsuarioBE objEstadoUsuarioBE = objEstadoUsuarioDA.queryByIdEstadoUsuario(idEstadoUsuario);
        
        usuario = new UsuarioBE(idUsuario,nombre,paterno,materno,objPerfilBE,objEstadoUsuarioBE,limiteIntentos);
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
        return objUsuarioDA.queryAllUsuario();
    }
    
    public UsuarioBE queryByIdUsuario(String idUsuario){
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

    public UsuarioBE setUsuario(String idUsuario,String nombre,String paterno,String materno,String idPerfil, String idEstadoUsuario,int limiteIntentos) {
        PerfilDA objPerfilDA=new PerfilDA();
        PerfilBE objPerfilBE = objPerfilDA.queryByIdPerfil(idPerfil);        
        EstadoUsuarioDA objEstadoUsuarioDA=new EstadoUsuarioDA();
        EstadoUsuarioBE objEstadoUsuarioBE = objEstadoUsuarioDA.queryByIdEstadoUsuario(idEstadoUsuario);
        usuario = new UsuarioBE(idUsuario,nombre,paterno,materno,objPerfilBE,objEstadoUsuarioBE,limiteIntentos);
        return usuario;
    }

    public ArrayList<UsuarioBE> getAllUsuario() {
        
        ArrayList<UsuarioBE>  arrUsuario = null;
        UsuarioDA objUsuarioDA = new UsuarioDA();
        arrUsuario = objUsuarioDA.queryAllUsuario();
        return arrUsuario;
    }
    

    
}
