/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
