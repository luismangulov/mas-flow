/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

/**
 *
 * @author carlitos
 */
public class Configuracion {

    private static double largoPallet=1.2;
    private static double anchoPallet=1.2;
    private static String empresa = "ASOCIACION CIVIL IMPACTA S.A.";




    

    /**
     * @return the largoPallet
     */
    public static double getLargoPallet() {
        return largoPallet;
    }

    /**
     * @param aLargoPallet the largoPallet to set
     */
    public static void setLargoPallet(double aLargoPallet) {
        largoPallet = aLargoPallet;
    }

    /**
     * @return the anchoPallet
     */
    public static double getAnchoPallet() {
        return anchoPallet;
    }

    /**
     * @param aAnchoPallet the anchoPallet to set
     */
    public static void setAnchoPallet(double aAnchoPallet) {
        anchoPallet = aAnchoPallet;
    }

    /**
     * @return the empresa
     */
    public static String getEmpresa() {
        return empresa;
    }

    /**
     * @param aEmpresa the empresa to set
     */
    public static void setEmpresa(String aEmpresa) {
        empresa = aEmpresa;
    }
    


}
