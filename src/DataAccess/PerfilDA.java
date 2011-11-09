/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;


import BusinessEntity.PerfilBE;
import BusinessEntity.PerfilDetalleBE;
import Util.conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Florencio
 */
public class PerfilDA {
    

    public boolean insertar(PerfilBE objPerfil) throws Exception{
        
        boolean boolExito = false;
        conexion objConexion = new conexion();
       
        String sql = "INSERT INTO perfil(idperfil, descripcion, indactivo) VALUES('"+ objPerfil.getIdPerfil() +"','"+ objPerfil.getDescripcion() +"','"+ objPerfil.getIndActivo() +"')";
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        
        return boolExito;
    }
    
     public PerfilBE queryById(String codigo){ //sin detalle
        conexion objConexion=new conexion();
        ResultSet rs = null;
        PerfilBE perfil = null;
        String sql = "SELECT idPerfil,descripcion,indactivo FROM Perfil ";
           sql += " WHERE idPerfil='"+codigo+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdPerfil;
            String strDescripcion;
            String strIndActivo;
            if (rs.next()){
                strIdPerfil = rs.getString(1).trim();
                strDescripcion = rs.getString(2).trim();
                strIndActivo = rs.getString(3).trim();
                perfil = new PerfilBE(strIdPerfil,strDescripcion,strIndActivo);
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }      
        return perfil;
    }
    
   
    public ArrayList<PerfilBE> queryAll(){ // sin detalle perfil
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<PerfilBE> arrPerfil = new ArrayList<PerfilBE>();
        String sql = "SELECT idPerfil,descripcion,indactivo FROM Perfil order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdPerfil;
            String strDescripcion;
            String strIndActivo;
            while (rs.next()){
              
                strIdPerfil = rs.getString(1).trim();
                strDescripcion = rs.getString(2).trim();
                strIndActivo = rs.getString(3).trim();
                arrPerfil.add(new PerfilBE(strIdPerfil,strDescripcion,strIndActivo));
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrPerfil;
    }

     public PerfilBE queryByIdPerfil(String idPerfil){ //con detalle
        conexion objConexion=new conexion();
        ResultSet rs = null;
        PerfilBE perfil = null;
        ArrayList<PerfilDetalleBE> arrPerfilDetalle = new ArrayList<PerfilDetalleBE>();
        PerfilDetalleDA objPerfilDetalleDA= new PerfilDetalleDA();
        String sql = "SELECT idPerfil,descripcion,indactivo FROM Perfil ";
           sql += " WHERE idPerfil='"+idPerfil+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdPerfil;
            String strDescripcion;
            String strIndActivo;
            if (rs.next()){
              
                strIdPerfil = rs.getString(1).trim();
                strDescripcion = rs.getString(2).trim();
                strIndActivo = rs.getString(3).trim();
                arrPerfilDetalle= objPerfilDetalleDA.queryAllByIdPerfil(idPerfil);
                perfil = new PerfilBE(strIdPerfil,strDescripcion,arrPerfilDetalle,strIndActivo);
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return perfil;
    }

     
      public PerfilBE queryByNombre(String nombre){ //sin detalle perfil
        conexion objConexion=new conexion();
        ResultSet rs = null;
        PerfilBE perfil = null;
        String sql = "SELECT idPerfil,descripcion,indactivo FROM Perfil ";
           sql += " WHERE descripcion='"+nombre+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdPerfil;
            String strDescripcion;
            String strIndActivo;
            if (rs.next()){

                strIdPerfil = rs.getString(1).trim();
                strDescripcion = rs.getString(2).trim();
                strIndActivo = rs.getString(3).trim();
                perfil = new PerfilBE(strIdPerfil,strDescripcion,strIndActivo);
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return perfil;
    }

    

      
    public ArrayList<PerfilBE> buscar(String idPerfil, String descripcion, String idAplicacion, String idServicio, String indActivo) {
        
 
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<PerfilBE> arrPerfil = new ArrayList<PerfilBE>();
//        String indActivo = "";
//        if(estado.equals("Activo")){
//            indActivo = "1";
//        }else if(estado.equals("Inactivo")){
//             indActivo = "0";
//        }
        
        String sql = "SELECT DISTINCT P.idPerfil,P.descripcion,P.indactivo FROM Perfil P,PerfilDetalle PD ";
                
                //" WHERE indactivo ='"+indActivo+"'";
       boolean primero;
        primero = true;
        //sql+= " WHERE";
        if(!(idPerfil.equals("")) || !(descripcion.equals("")) || !idAplicacion.equals("")|| !idServicio.equals("")|| !indActivo.equals("")){
           if (!idPerfil.equals("")){           
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql +=  " P.idPerfil LIKE '%"+idPerfil+"%'";
           }
           if (!descripcion.equals("")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql += " P.descripcion LIKE '%"+descripcion+"%'";
           }
           if (!idAplicacion.equals("")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql += " PD.idAplicacion LIKE '%"+idAplicacion+"%'";
           }
           if (!idServicio.equals("")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql += " PD.idServicio LIKE '%"+idServicio+"%'";
           }
                     
           if(indActivo.equals("1")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql += " P.indactivo = '1'";
           }    
           if(indActivo.equals("0")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql += " P.indactivo = '0'";
           } 
        }
        sql +=" order by 1";
              
        
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdPerfil;
            String strDescripcion;
            String strIndActivo;
            while (rs.next()){
              
                strIdPerfil = rs.getString(1).trim();
                strDescripcion = rs.getString(2).trim();
                strIndActivo = rs.getString(3).trim();
                arrPerfil.add(new PerfilBE(strIdPerfil,strDescripcion,strIndActivo));
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrPerfil;
    }

    

    public boolean eliminar(String codigo) {
        
        boolean boolExito = false;
        conexion objConexion = new conexion();

        String sql = "DELETE FROM perfilDetalle";
             sql += " WHERE idPerfil='"+codigo+"'";
        
        try{
            objConexion.EjecutarUID(sql);

         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}        
        
        
       
        sql = "DELETE FROM perfil";
             sql += " WHERE idPerfil='"+codigo+"'";
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        
        return boolExito;   
        
        
    
    }

    public boolean modificar(PerfilBE objPerfil) throws Exception{

        boolean boolExito = false;
        conexion objConexion = new conexion();

        String sql = "UPDATE perfil SET ";
             sql += "descripcion='"+objPerfil.getDescripcion()+ "',"+
                     "indactivo='"+objPerfil.getIndActivo()+ "'"+
                    " WHERE idPerfil='"+objPerfil.getIdPerfil()+"'";

        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}

        return boolExito;
    }


    
 
    
    
}
