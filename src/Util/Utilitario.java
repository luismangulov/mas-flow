/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DIEGO
 */
public class Utilitario {
     public static String generaCodigo(String strNombreTabla, int intCantidadCaracteres) throws FileNotFoundException, IOException {
        conexion objConexion = new conexion();
        String strSentencia = "SELECT MAX(id"+strNombreTabla+") FROM "+strNombreTabla;
        String strId = "";


        try {
            ResultSet rs = objConexion.EjecutarS(strSentencia);

            if (rs.next()) {
                strId = rs.getString(1);
                if (strId!=null && !strId.equals("")) {
                    int intId = Integer.parseInt(strId);
                    intId++;
                    strId = "" + intId;
                    while (strId.length() < intCantidadCaracteres)
                        strId = "0" + strId;
                }
                else{
                    strId="";
                    for( int i=1; i<intCantidadCaracteres;i++) strId +="0";
                    strId +=1;   
                }
             }
             else{
                 strId="";
                 for( int i=1; i<intCantidadCaracteres;i++) strId +="0";
                 strId +=1;
             }
                            
        }
        catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{
            objConexion.SalirS();
        }
        return strId;
    }
     
     public static boolean validarCadenaNumerica(String strCadena) {
        try {
            Integer.parseInt(strCadena);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validarCadenaNumericaReal(String strCadena){
        try {
            Double.parseDouble(strCadena);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean validarCadenaNumericaRealPositiva(String strCadena){
        try {
            double dlbReal=Double.parseDouble(strCadena);
            if (dlbReal>0) return true;
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean validarCadenaAlfabetica(char chrCaracter) {
        String strCadena = "" + chrCaracter;
        if (strCadena.matches("[a-zA-Z áéíóúñ]*"))
            return true;
        else
            return false;
    }

    public static boolean validarCadenaAlfaNumerica(char chrCaracter) {
        String strCadena = "" + chrCaracter;
        if (strCadena.matches("[a-zA-Z0-9 áéíóúñ]*"))
            return true;
        else
            return false;
    }

    public static boolean validarSoloNumeros(char chrCaracter) {
        String strCadena = "" + chrCaracter;
        if (strCadena.matches("[0-9]"))
            return true;
        else
            return false;
    }



    public static boolean validarSoloNumerosRealesPositivos(char chrCaracter) {
        String strCadena = "" + chrCaracter;
        if (strCadena.matches("[0-9,.]"))
            return true;
        else
            return false;
    }

    
    public static boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            return true;
        }else{
            return false;
        }
    }    
}
