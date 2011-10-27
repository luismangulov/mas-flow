/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Util.conexion;
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
       
        String sql = "INSERT INTO familia(idfamilia, nombre, descripcion, indactivo) VALUES('"+ objFamilia.getIdFamilia() +"','"+ objFamilia.getNombre() +"','"+ objFamilia.getDescripcion() +"','"+ objFamilia.getEstado() +"')";
        
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
        String sql = "SELECT idfamilia,nombre,descripcion,indactivo FROM Familia WHERE IndActivo = '1' order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strCodigo;
            String strNombre;
            String strDescripcion;
            String strEstado;
            while (rs.next()){
              
                strCodigo = rs.getString(1).trim();
                strNombre = rs.getString(2).trim();
                strDescripcion = rs.getString(3).trim();
                strEstado = rs.getString(4).trim();
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

     public FamiliaBE queryByIdFamilia(String codigo){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        FamiliaBE familia = null;
        String sql = "SELECT idfamilia,nombre,descripcion,indactivo FROM Familia ";
           sql += " WHERE idfamilia='"+codigo+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strCodigo;
            String strNombre;
            String strDescripcion;
            String strEstado;
            if (rs.next()){
              
                 strCodigo = rs.getString(1).trim();
                strNombre = rs.getString(2).trim();
                strDescripcion = rs.getString(3).trim();
                strEstado = rs.getString(4).trim();
                familia = new FamiliaBE(strCodigo,strNombre,strDescripcion,strEstado);
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return familia;
    }

    public FamiliaBE queryByNombreFamilia(String nombreFamilia){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        FamiliaBE familia = null;
        String sql = "SELECT idfamilia,nombre,descripcion,indactivo FROM Familia ";
           sql += " WHERE nombre='"+nombreFamilia+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strCodigo;
            String strNombre;
            String strDescripcion;
            String strEstado;
            if (rs.next()){

                 strCodigo = rs.getString(1).trim();
                strNombre = rs.getString(2).trim();
                strDescripcion = rs.getString(3).trim();
                strEstado = rs.getString(4).trim();
                familia = new FamiliaBE(strCodigo,strNombre,strDescripcion,strEstado);
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return familia;
    }
    
     public boolean modificar(FamiliaBE objFamilia) throws Exception{
        
        boolean boolExito = false;
        conexion objConexion = new conexion();
       
        String sql = "UPDATE familia SET";
             sql += " nombre='"+objFamilia.getNombre()+"'," +
                    "descripcion='"+objFamilia.getDescripcion()+ "',"+
                     "indactivo='"+objFamilia.getEstado()+ "'"+ 
                    " WHERE idfamilia='"+objFamilia.getIdFamilia()+"'";
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        
        return boolExito;
    }
     
      public boolean eliminar(String codFamilia) throws Exception{
        
        boolean boolExito = false;
        conexion objConexion = new conexion();
       
        String sql = "DELETE FROM familia";
             sql += " WHERE idfamilia='"+codFamilia+"'";
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        
        return boolExito;
    }
      
    public ArrayList<FamiliaBE> buscar(String codigo,String nombre,String estado){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<FamiliaBE> arrFamilia = new ArrayList<FamiliaBE>();
        String indActivo = "";
        if(estado.equals("Activo")){
            indActivo = "1";
        }else if(estado.equals("Inactivo")){
             indActivo = "0";
        }
        
        String sql = "SELECT idfamilia,nombre,descripcion,indactivo FROM Familia";
                //" WHERE indactivo ='"+indActivo+"'";
       boolean primero;
        primero = true;
        //sql+= " WHERE";
        if(!(codigo.equals("")) || !(nombre.equals("")) || !estado.equals("")){
           if (!codigo.equals("")){           
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql +=  " idfamilia LIKE '%"+codigo+"%'";
           }
           if (!nombre.equals("")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql += " nombre LIKE '%"+nombre+"%'";
           }
           if(estado.equals("Activo")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql += " indactivo = '1'";
           }    
           if(estado.equals("Inactivo")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql += " indactivo = '0'";
           } 
        }
        sql +=" order by 1";
              
        
        try{
            rs=objConexion.EjecutarS(sql);
            String strCodigo;
            String strNombre;
            String strDescripcion;
            String strEstado;
            while (rs.next()){
              
                strCodigo = rs.getString(1).trim();
                strNombre = rs.getString(2).trim();
                strDescripcion = rs.getString(3).trim();
                strEstado = rs.getString(4).trim();
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

    
    public ArrayList<FamiliaBE> buscarAyuda(String codigo,String nombre){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<FamiliaBE> arrFamilia = new ArrayList<FamiliaBE>();
               
        String sql = "SELECT idfamilia,nombre,descripcion,indactivo FROM Familia WHERE indactivo = '1'";
                //" WHERE indactivo ='"+indActivo+"'";
       boolean primero;
       
        //sql+= " WHERE";
        if(!(codigo.equals("")) || !(nombre.equals(""))){
           if (!codigo.equals("")){ 
               sql +=  " AND idfamilia LIKE '%"+codigo+"%'";
           }
           if (!nombre.equals("")){
               sql += " AND nombre LIKE '%"+nombre+"%'";
           }
        }
        sql +=" order by 1";
              
        
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
