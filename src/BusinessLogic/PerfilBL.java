/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.PerfilBE;
import DataAccess.FamiliaDA;
import DataAccess.PerfilAD;
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
        PerfilAD objPerfilDA = new PerfilAD();
        exito = objPerfilDA.insertar(getPerfil());
        return exito;
    }
    
    public boolean eliminar(String idPerfil) throws Exception{
        boolean exito = false;
        PerfilAD objPerfilDA = new PerfilAD();
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
        PerfilAD objPerfilDA = new PerfilAD();
        return objPerfilDA.queryAllPerfil();
    }
    
    public PerfilBE queryByIdPerfil(String idPerfil){
        PerfilAD objPerfilDA = new PerfilAD();
        return objPerfilDA.queryByIdPerfil(idPerfil);
    }
    
     public boolean modificar(PerfilBE objPerfil) throws Exception{
          boolean exito = false;
          PerfilAD objPerfilDA = new PerfilAD();
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
        PerfilAD objPerfilDA = new PerfilAD();
        arrPerfil = objPerfilDA.queryAllPerfil();
        return arrPerfil;
    }
    
}
