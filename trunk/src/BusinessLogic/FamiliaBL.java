/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.FamiliaBE;
import DataAccess.FamiliaDA;

/**
 *
 * @author DIEGO
 */
public class FamiliaBL {
    public void insertar(String nombre,String descripcion) throws Exception{
        FamiliaBE familia = new FamiliaBE("000001",nombre,descripcion,"1");
        FamiliaDA objFamiliaDA = new FamiliaDA();
        objFamiliaDA.insertar(familia);
    }
}
