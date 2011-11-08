/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.PerfilBE;
import BusinessEntity.PerfilDetalleBE;
import DataAccess.FamiliaDA;
import DataAccess.PerfilDA;
import Util.Utilitario;
import java.util.ArrayList;

/**
 *
 * @author Florencio
 */
public class PerfilBL {
    
    private PerfilBE perfil;

    public boolean insertarPerfil(String descripcion,ArrayList <PerfilDetalleBE>listaDetallePerfiles)throws Exception{
        boolean exito =false;
//        PerfilBE objPerfilBE=new PerfilBE(Utilitario.generaCodigo("perfil",6),descripcion,listaDetallePerfiles);
//        PerfilDA objPerfilDA =new PerfilDA();
//        exito=objPerfilDA.insertarPerfil(objPerfilBE);
        return exito;
    }
    
    
    public PerfilBE queryByNombre(String nombre){// sin detalle
        PerfilDA objPerfilDA = new PerfilDA();
        return objPerfilDA.queryByNombre(nombre);
        
        
    }

    
   public ArrayList<PerfilBE> queryAll(){
        PerfilDA objPerfilDA = new PerfilDA();
        return objPerfilDA.queryAll();
    }
    
    public PerfilBE queryByIdPerfil(String idPerfil){
        PerfilDA objPerfilDA = new PerfilDA();
        return objPerfilDA.queryByIdPerfil(idPerfil);
    }
    
   public PerfilBE queryById(String idPerfil){
        PerfilDA objPerfilDA = new PerfilDA();
        return objPerfilDA.queryById(idPerfil);       
   }
    

    public PerfilBE getPerfil() {
        return perfil;
    }

    /**
     * @param familia the familia to set
     */
    public PerfilBE setPerfil(String idPerfil,String descripcion,String indEstado) {
        perfil = new PerfilBE(idPerfil,descripcion,indEstado);
        return perfil;
    }

    public ArrayList<PerfilBE> buscar(String idPerfil, String descripcion, String idAplicacion, String idServicio, String indActivo) {
        PerfilDA objPerfilDA = new PerfilDA();
        return objPerfilDA.buscar(idPerfil,descripcion,idAplicacion,idServicio,indActivo);
    }

    public boolean eliminar(String codigo) {
        PerfilDA objPerfilDA = new PerfilDA();
        return objPerfilDA.eliminar(codigo);
    }

    public boolean insertar(String descripcion,String estado) throws Exception{
        boolean exito = false;
        perfil = new PerfilBE(Utilitario.generaCodigo("perfil",6),descripcion,estado);
        PerfilDA objPerfilDA = new PerfilDA();
        exito = objPerfilDA.insertar(getPerfil());
        return exito;
    }

     public boolean modificar(PerfilBE objPerfil) throws Exception{
          boolean exito = false;
          PerfilDA objPerfilDA = new PerfilDA();
          exito = objPerfilDA.modificar(objPerfil);
          return exito;
     }

    
}
