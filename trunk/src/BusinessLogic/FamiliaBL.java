/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BD.Utilitario;
import BusinessEntity.FamiliaBE;
import DataAccess.FamiliaDA;
import java.util.ArrayList;

/**
 *
 * @author DIEGO
 */
public class FamiliaBL {
    private FamiliaBE familia;
    public boolean insertar(String nombre,String descripcion,String estado) throws Exception{
        boolean exito = false;
        familia = new FamiliaBE(Utilitario.generaCodigo("familia",6),nombre,descripcion,estado);
        FamiliaDA objFamiliaDA = new FamiliaDA();
        exito = objFamiliaDA.insertar(getFamilia());
        return exito;
    }
    
    public boolean eliminar(String codFamilia) throws Exception{
        boolean exito = false;
        FamiliaDA objFamiliaDA = new FamiliaDA();
        exito = objFamiliaDA.eliminar(codFamilia);
        return exito;
    }
    public String getIdFamilia(String nombreFamilia){
        FamiliaDA familiaDA = new FamiliaDA();
        familia = new FamiliaBE();
        familia = familiaDA.queryByNombreFamilia(nombreFamilia);
        if (familia == null)
            return "";
        return familia.getIdFamilia();
    }

    public ArrayList<FamiliaBE> queryAllFamilia(){
        FamiliaDA objFamiliaDA = new FamiliaDA();
        return objFamiliaDA.queryAllFamilia();
    }
    
    public FamiliaBE queryByIdFamilia(String codigo){
        FamiliaDA objFamiliaDA = new FamiliaDA();
        return objFamiliaDA.queryByIdFamilia(codigo);
    }
    
     public boolean modificar(FamiliaBE objFamilia) throws Exception{
          boolean exito = false;
          FamiliaDA objFamiliaDA = new FamiliaDA();
          exito = objFamiliaDA.modificar(objFamilia);
          return exito;
     }
    
     public ArrayList<FamiliaBE> buscar(String codigo,String nombre, String estado){
          FamiliaDA objFamiliaDA = new FamiliaDA();
          return objFamiliaDA.buscar(codigo, nombre, estado);
     }
     
    /**
     * @return the familia
     */
    public FamiliaBE getFamilia() {
        return familia;
    }

    /**
     * @param familia the familia to set
     */
    public FamiliaBE setFamilia(String codigo,String nombre,String descripcion,String estado) {
        familia = new FamiliaBE(codigo,nombre,descripcion,estado);
        return familia;
    }

    public ArrayList<FamiliaBE> getAllFamilia() {
        ArrayList<FamiliaBE>  arrFamilia = null;
        FamiliaDA objFamiliaDA = new FamiliaDA();
        arrFamilia = objFamiliaDA.queryAllFamilia();
        return arrFamilia;
    }
    
}
