/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CargaMasiva;

import Util.conexion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author florencio
 */
public class CargaMasiva {


   public void cargaData(){

      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      conexion objConexion=new conexion();
      ResultSet rs = null;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         String ruta = System.getProperty("user.dir") +
                                "/src/CargaMasiva/DATAMASIVA.TXT";
         archivo = new File (ruta);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         String sql = null;
         String nombreTabla;
         ArrayList <String> campos=new ArrayList<String>();
         ArrayList <String> valores=new ArrayList<String>();
         
         while((linea=br.readLine())!=null){
            if(linea.equals("fin"))break;
            //System.out.println(linea);
            nombreTabla=linea;
            linea=br.readLine();
            //System.out.println(linea);
            campos=leerCadena(linea);// nombre campos
            while(!(linea=br.readLine()).equals("*")){
                valores=leerCadena(linea);//valores
                //System.out.println(linea.trim());
                sql= "INSERT INTO "+nombreTabla+"(";
                    for(int i=0;i<campos.size();i++){
                    if (i==(campos.size()-1)){
                        sql+=" "+campos.get(i)+" ";
                    }else
                        sql+=" "+campos.get(i)+" , ";
                }
                sql+=" ) VALUES ( ";

                for(int i=0;i<valores.size();i++){
                    if (i==(valores.size()-1)){
                        sql+="'"+valores.get(i)+"'";
                    }else
                        sql+="'"+valores.get(i)+"',";
                }
                sql+=")";
                System.out.println(sql);
//                rs=objConexion.EjecutarS(sql);
//                rs=objConexion.EjecutarS("commit");
//                objConexion.SalirS();

             }
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta
         // una excepcion.
         try{
            if( null != fr ){
               fr.close();
            }
         }catch (Exception e2){
            e2.printStackTrace();
         }
      }
   }

    private ArrayList<String> leerCadena(String linea) {
        ArrayList <String> cadena=new ArrayList<String>();
        String input = linea;
        String delimiter = ",";
        String[] fields = input.split(delimiter,-1);
        for (int i = 0; i < fields.length; i++) {
            fields[i].replace('/', ',');
            cadena.add(fields[i]);
            //System.out.println(fields[i]);
        }
        return cadena;
    }


}
