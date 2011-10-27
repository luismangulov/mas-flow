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
    public boolean insertar(String descripcion,String indEstado) throws Exception{
        boolean exito = false;
        perfil = new PerfilBE(Utilitario.generaCodigo("perfil",6),descripcion,indEstado);
        PerfilDA objPerfilDA = new PerfilDA();
        exito = objPerfilDA.insertar(getPerfil());
        return exito;
    }
    
    public boolean insertarPerfil(String descripcion,ArrayList <PerfilDetalleBE>listaDetallePerfiles)throws Exception{
        boolean exito =false;
        PerfilBE objPerfilBE=new PerfilBE(Utilitario.generaCodigo("perfil",6),descripcion,listaDetallePerfiles);
        PerfilDA objPerfilDA =new PerfilDA();
        exito=objPerfilDA.insertarPerfil(objPerfilBE);
        return exito;
    }
    
    public boolean eliminar(String idPerfil) throws Exception{
        boolean exito = false;
        PerfilDA objPerfilDA = new PerfilDA();
        exito = objPerfilDA.eliminar(idPerfil);
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

    public ArrayList<PerfilBE> queryAllPerfil(){
        PerfilDA objPerfilDA = new PerfilDA();
        return objPerfilDA.queryAllPerfil();
    }
    
    public PerfilBE queryByIdPerfil(String idPerfil){
        PerfilDA objPerfilDA = new PerfilDA();
        return objPerfilDA.queryByIdPerfil(idPerfil);
    }
    
     public boolean modificar(PerfilBE objPerfil) throws Exception{
          boolean exito = false;
          PerfilDA objPerfilDA = new PerfilDA();
          exito = objPerfilDA.modificar(objPerfil);
          return exito;
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

    public ArrayList<PerfilBE> getAllPerfil() {
        ArrayList<PerfilBE>  arrPerfil = null;
        PerfilDA objPerfilDA = new PerfilDA();
        arrPerfil = objPerfilDA.queryAllPerfil();
        return arrPerfil;
    }
    
}
