/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;
import java.sql.Connection;

/**
 *
 * @author diego
 */
public class conexion {

    private static String strConexion;
    private static String user;
    private static String password;
    public conexion(){
        // la ip 127.0.0.1 es un ejemplo
        strConexion = "jdbc:postgresql://127.0.0.1/database1";
        user = "postgres";
        password = "dp";
    }
    
}
