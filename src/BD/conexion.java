/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;
import java.sql.*;

/**
 *
 * @author diego
 */
public class conexion {

    public static Connection cnn = null;
    public void estableceCnn()
    {
        if (cnn != null)
            return;
        //jdbc:postgreslq://ubicacion_de_BD:puerto/nombre_BD
        String driver = "org.postgresql.Driver";
        String url = "Jdbc:postgresql://quilla.lab.inf.pucp.edu.pe:1051/template1/";
        String user = "postgres";
        String password = "imperio";

        try
        {
            Class.forName(driver);
            cnn = DriverManager.getConnection(url,user,password);
//            Statement stmt = cnn.createStatement();
            if (cnn != null){
                System.out.println("Conexión a base de datos ... Ok");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void cerrarCnn()
    {
        try{
        cnn.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
