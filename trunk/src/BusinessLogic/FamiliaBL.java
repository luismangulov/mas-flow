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
    public boolean insertar(String nombre,String descripcion) throws Exception{
        boolean exito = false;
        familia = new FamiliaBE(Utilitario.generaCodigo("familia",6),nombre,descripcion,"1");
        FamiliaDA objFamiliaDA = new FamiliaDA();
        exito = objFamiliaDA.insertar(getFamilia());
        return exito;
    }
    
    public ArrayList<FamiliaBE> queryAllFamilia(){
        FamiliaDA objFamiliaDA = new FamiliaDA();
        return objFamiliaDA.queryAllFamilia();
    }
    
    /**
     * @return the familia
     */
    public FamiliaBE getFamilia() {
        return familia;
    }
    
}
