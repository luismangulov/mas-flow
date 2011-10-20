/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BD.conexion;
import BusinessEntity.FamiliaBE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DIEGO
 */
public class FamiliaDA {
    
    public boolean insertar(FamiliaBE objFamilia) throws Exception{
        
        boolean boolExito = false;
        conexion objConexion = new conexion();
       
        String sql = "INSERT INTO familia(idfamilia, nombre, descripcion, indactivo) VALUES('"+ objFamilia.getCodigo() +"','"+ objFamilia.getNombre() +"','"+ objFamilia.getDescripcion() +"','"+ objFamilia.getEstado() +"')";
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        
        return boolExito;
    }
    
    public ArrayList<FamiliaBE> queryAllFamilia(){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<FamiliaBE> arrFamilia = new ArrayList<FamiliaBE>();
        String sql = "SELECT idfamilia,nombre,descripcion,indactivo FROM Familia WHERE IndActivo = 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strCodigo;
            String strNombre;
            String strDescripcion;
            String strEstado;
            while (rs.next()){
              
                strCodigo = rs.getString(1);
                strNombre = rs.getString(2);
                strDescripcion = rs.getString(3);
                strEstado = rs.getString(4);
                arrFamilia.add(new FamiliaBE(strCodigo,strNombre,strDescripcion,strEstado));
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrFamilia;
    }
}
