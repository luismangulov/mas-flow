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
    

//    public String getIdFamilia(String nombreFamilia){
//        FamiliaDA familiaDA = new FamiliaDA();
//        familia = new FamiliaBE();
//        familia = familiaDA.queryByNombreFamilia(nombreFamilia);
//        if (familia == null)
//            return "";
//        return familia.getIdFamilia();
//    }
    
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
    

    
//     public ArrayList<PerfilBE> buscar(String idPerfil,String descripcion, String indEstado){
//          PerfilAD objPerfilDA = new PerfilAD();
//          return objPerfilDA.buscar(idPerfil, descripcion, indEstado);
//     }
     
//     public ArrayList<PerfilBE> buscarAyuda(String idPerfil,String descripcion,String indEstado){
//         FamiliaDA objFamiliaDA = new FamiliaDA();
//         return objFamiliaDA.buscarAyuda(codigo, nombre);
//     }
     
    /**
     * @return the familia
     */
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


    
}
