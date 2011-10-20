/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class conexion {

    private Connection con;
    private String driver;
    private String url;
    private String user;
    private String password;
    private Statement stmt;
    
    
    public conexion()
    {
      
        //jdbc:postgreslq://ubicacion_de_BD:puerto/nombre_BD
        driver = "org.postgresql.Driver";
        url = "jdbc:postgresql://quilla.lab.inf.pucp.edu.pe:1051/postgres";
        user = "postgres";
        password = "imperio";
        stmt= null;
        con = null;

    }

      //Para ejecutar sentencias Insert,Update,Delete
    public void EjecutarUID(String QueryUID) {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user , password);
            stmt = con.createStatement();
            stmt.executeUpdate(QueryUID);
        }
        catch ( Exception e ) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    
     //Cerrar la Conexion
    public void SalirUID() {
        try {
            stmt.close();
            con.close();
        }
        catch( Exception e ){
            System.out.println(e.getMessage());
        }
    }
    
     //Para ejecutar Select
    public ResultSet EjecutarS(String QueryS) {
        ResultSet rs = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user , password);
            stmt = con.createStatement();
            //Query
            rs = stmt.executeQuery(QueryS);
        }
        catch ( Exception e ){
            System.out.println(e.getMessage());
        }
        return rs;
    }

    //Para cerrar la conexion
    public void SalirS() {
        try {
            stmt.execute("END");
            stmt.close();
            con.close();
        }
        catch( Exception e ){
            System.out.println(e.getMessage());
        }
    }
    
}
