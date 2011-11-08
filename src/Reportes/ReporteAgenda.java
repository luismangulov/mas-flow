/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Reportes;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;

/**
 *
 * @author WinDoctor
 */
public class ReporteAgenda 
{
    private Connection conn;
    private final String login = "root"; //usuario de acceso a MySQL
    private final String password = "sesamo"; //contraseña de usuario
    private String url = "jdbc:mysql://localhost/addressbook";
    private String id_contact;
    public ReporteAgenda()
    {        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver"); //se carga el driver
            conn = DriverManager.getConnection(url,login,password);
        } 
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        
        
    }
    
    public void runReporte(String id_contact)
    {
        //this.id_contact="";
        //this.id_contact = id;
        
        try
        {            
            String master = System.getProperty("user.dir") +
                                "/reportes/contactos.jasper";
            
            System.out.println("master" + master);
            if (master == null) 
            {                
                System.out.println("No encuentro el archivo del reporte maestro.");
                System.exit(2);
            } 

            JasperReport masterReport = null;
            try 
            {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } 
            catch (JRException e) 
            {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                System.exit(3);
            }              
            
            //este es el parámetro, se pueden agregar más parámetros
            //basta con poner mas parametro.put
            Map parametro = new HashMap();
            parametro.put("id",id_contact);           

            //Reporte diseñado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn);

            //Se lanza el Viewer de Jasper, no termina aplicación al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("MUNDO BYTE");
            jviewer.setVisible(true);
        }

        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
        
    }
    
    public void cerrar()
    {
                try 
                {
                    conn.close();
                } 
                catch (SQLException ex) 
                {
                    ex.printStackTrace();
                }
    }
}
