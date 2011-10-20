/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BD.Utilitario;
import BusinessEntity.FamiliaBE;
import DataAccess.FamiliaDA;

/**
 *
 * @author DIEGO
 */
public class FamiliaBL {
    public boolean insertar(String nombre,String descripcion) throws Exception{
        boolean exito = false;
        FamiliaBE familia = new FamiliaBE(Utilitario.generaCodigo("familia",6),nombre,descripcion,"1");
        FamiliaDA objFamiliaDA = new FamiliaDA();
        exito = objFamiliaDA.insertar(familia);
        return exito;
    }
}
