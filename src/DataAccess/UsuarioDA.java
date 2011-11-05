/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.EstadoUsuarioBE;
import BusinessEntity.PerfilBE;
import BusinessEntity.UsuarioBE;
import Util.conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Florencio
 */
public class UsuarioDA {
    
     public boolean insertar(UsuarioBE objUsuario) {
        
        boolean boolExito = false;
        conexion objConexion = new conexion();       
        String sql = "INSERT INTO usuario(idUsuario, nombre, apellidopaterno,apellidomaterno, idPerfil, idEstadoUsuario,limiteIntentos) VALUES('"+ objUsuario.getIdUsuario() +"','"+ objUsuario.getNombre() +"','"+ objUsuario.getPaterno() +"','"+ objUsuario.getMaterno()+"','"+ objUsuario.getPerfil().getIdPerfil() +"','"+ objUsuario.getEstadoUsuario().getIdEstadoUsuario() +"','"+ objUsuario.getLimiteIntentos() +"')";
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        
        return boolExito;
    }
    
    public ArrayList<UsuarioBE> queryAllUsuario(){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<UsuarioBE> arrUsuario = new ArrayList<UsuarioBE>();
        String sql = "SELECT idUsuario,nombre,apellidopaterno,apellidomaterno,idPerfil,idEstadoUsuario,limiteIntentos FROM usuario  order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdUsuario;
            String strNombre;
            String strPaterno;
            String strMaterno;
            String strIdPerfil;
            String strIdEstadoUsuario;
            int intLimiteIntentos;
            
            PerfilDA objPerfilDA=new PerfilDA();
            PerfilBE objPerfilBE=new PerfilBE();
            EstadoUsuarioDA objEstadoUsuarioDA=new EstadoUsuarioDA();
            EstadoUsuarioBE objEstadoUsuarioBE=new EstadoUsuarioBE();

            while (rs.next()){
              
                strIdUsuario = rs.getString(1).trim();
                strNombre = rs.getString(2).trim();
                strPaterno = rs.getString(3).trim();
                strMaterno = rs.getString(4).trim();
                strIdPerfil = rs.getString(5).trim();
                objPerfilBE= objPerfilDA.queryById(strIdPerfil);
                strIdEstadoUsuario = rs.getString(6).trim();
                objEstadoUsuarioBE= objEstadoUsuarioDA.queryByIdEstadoUsuario(strIdEstadoUsuario);
                intLimiteIntentos = rs.getInt(7);
                arrUsuario.add(new UsuarioBE(strIdUsuario,strNombre,strPaterno,strMaterno,objPerfilBE,objEstadoUsuarioBE,intLimiteIntentos));
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrUsuario;
    }

       
     public UsuarioBE queryByIdUsuario(String idUsuario){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        UsuarioBE usuario = null;
        String sql = "SELECT idUsuario,nombre,apellidopaterno,apellidomaterno,idPerfil,idEstadoUsuario,limiteIntentos FROM Usuario ";
           sql += " WHERE idUsuario='"+idUsuario+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdUsuario;
            String strNombre;
            String strPaterno;
            String strMaterno;
            String strIdPerfil;
            String strIdEstadoUsuario;
            int intLimiteIntentos;
            PerfilDA objPerfilDA=new PerfilDA();
            PerfilBE objPerfilBE=new PerfilBE();
            EstadoUsuarioDA objEstadoUsuarioDA=new EstadoUsuarioDA();
            EstadoUsuarioBE objEstadoUsuarioBE=new EstadoUsuarioBE();
            
            if (rs.next()){                   
                
                strIdUsuario = rs.getString(1).trim();
                strNombre = rs.getString(2).toString().trim();
                strPaterno = rs.getString(3).toString().trim();
                strMaterno = rs.getString(4).toString().trim();
                strIdPerfil = rs.getString(5).toString().trim();
                objPerfilBE= objPerfilDA.queryById(strIdPerfil);
                strIdEstadoUsuario = rs.getString(6).toString().trim();
                objEstadoUsuarioBE= objEstadoUsuarioDA.queryByIdEstadoUsuario(strIdEstadoUsuario);
                intLimiteIntentos = rs.getInt(7);
                usuario = new UsuarioBE(strIdUsuario,strNombre,strPaterno,strMaterno,objPerfilBE,objEstadoUsuarioBE,intLimiteIntentos);
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return usuario;
    }

//    public FamiliaBE queryByNombreFamilia(String nombreFamilia){
//        conexion objConexion=new conexion();
//        ResultSet rs = null;
//        FamiliaBE familia = null;
//        String sql = "SELECT idfamilia,nombre,descripcion,indactivo FROM Familia ";
//           sql += " WHERE nombre='"+nombreFamilia+"'";
//        try{
//            rs=objConexion.EjecutarS(sql);
//            String strCodigo;
//            String strNombre;
//            String strDescripcion;
//            String strEstado;
//            if (rs.next()){
//
//                strCodigo = rs.getString(1);
//                strNombre = rs.getString(2);
//                strDescripcion = rs.getString(3);
//                strEstado = rs.getString(4);
//                familia = new FamiliaBE(strCodigo,strNombre,strDescripcion,strEstado);
//            }
//
//        }catch (Exception a){
//            System.out.println(a.getMessage());
//         }
//         finally{
//             objConexion.SalirS();
//         }
//
//        return familia;
//    }
    
     public boolean modificar(UsuarioBE objUsuario) throws Exception{
        
        boolean boolExito = false;
        conexion objConexion = new conexion();
       
        String sql = "UPDATE usuario SET ";
                sql+="nombre='"+objUsuario.getNombre()+"'," +
                    "apellidopaterno='"+objUsuario.getPaterno()+ "',"+
                    "apellidomaterno='"+objUsuario.getMaterno()+ "',"+ 
                    "idPerfil='"+objUsuario.getPerfil().getIdPerfil()+ "',"+ 
                    "idEstadoUsuario='"+objUsuario.getEstadoUsuario().getIdEstadoUsuario()+ "',"+ 
                    "limiteIntentos='"+objUsuario.getLimiteIntentos()+"' "+
                    "WHERE idUsuario='"+objUsuario.getIdUsuario()+"'";
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        
        return boolExito;
    }
     
      public boolean eliminar(String IdUsuario) throws Exception{
        
        boolean boolExito = false;
        conexion objConexion = new conexion();
       
        String sql = "DELETE FROM Usuario";
             sql += " WHERE idUsuario='"+IdUsuario+"'";
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}        
        return boolExito;
    }
    

      
    public ArrayList<UsuarioBE> buscar(String idUsuario,String nombre,String paterno,String materno,String idPerfil, String idEstadoUsuario){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<UsuarioBE> arrUsuario = new ArrayList<UsuarioBE>();
        String indActivo = "";
        if(idEstadoUsuario.equals("Activo")){
            indActivo = "1";
        }else if(idEstadoUsuario.equals("Inactivo")){
             indActivo = "0";
        }
        
        String sql = "SELECT idUsuario,nombre,apellidopaterno,apellidomaterno,idPerfil,idEstadoUsuario,limiteIntentos FROM Usuario";
                //" WHERE indactivo ='"+indActivo+"'";
       boolean primero;
        primero = true;
        //sql+= " WHERE";
        if(!(idUsuario.equals("")) || !(nombre.equals("")) || !paterno.equals("")|| !materno.equals("")|| !idPerfil.equals("")|| !idEstadoUsuario.equals("")){
           if (!idUsuario.equals("")){           
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql +=  " idUsuario LIKE '%"+idUsuario+"%'";
           }
           if (!nombre.equals("")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql += " nombre LIKE '%"+nombre+"%'";
           }
           if (!paterno.equals("")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql += " apellidopaterno LIKE '%"+paterno+"%'";
           }
           if (!materno.equals("")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql += " apellidomaterno LIKE '%"+materno+"%'";
           }
           if (!idPerfil.equals("")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql += " idPerfil LIKE '%"+idPerfil+"%'";
           }
       
           
           if(idEstadoUsuario.equals("Activo")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql += " indactivo = '1'";
           }    
           if(idEstadoUsuario.equals("Inactivo")){
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
            String strIdUsuario;
            String strNombre;
            String strPaterno;
            String strMaterno;
            String strIdPerfil;
            String strIdEstadoUsuario;
            int intLimiteIntentos;
            PerfilDA objPerfilDA=new PerfilDA();
            PerfilBE objPerfilBE=new PerfilBE();
            EstadoUsuarioDA objEstadoUsuarioDA=new EstadoUsuarioDA();
            EstadoUsuarioBE objEstadoUsuarioBE=new EstadoUsuarioBE();

            while (rs.next()){
              
                strIdUsuario = rs.getString(1).trim();
                strNombre = rs.getString(2).trim();
                strPaterno = rs.getString(3).trim();
                strMaterno = rs.getString(4).trim();
                strIdPerfil = rs.getString(5).trim();
                objPerfilBE= objPerfilDA.queryByIdPerfil(strIdPerfil);
                strIdEstadoUsuario = rs.getString(6).trim();
                objEstadoUsuarioBE= objEstadoUsuarioDA.queryByIdEstadoUsuario(strIdEstadoUsuario);
                intLimiteIntentos = rs.getInt(7);
                arrUsuario.add(new UsuarioBE(strIdUsuario,strNombre,strPaterno,strMaterno,objPerfilBE,objEstadoUsuarioBE,intLimiteIntentos));
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrUsuario;
  
    }

    
//    public ArrayList<FamiliaBE> buscarAyuda(String codigo,String nombre){
//        conexion objConexion=new conexion();
//        ResultSet rs = null;
//        ArrayList<FamiliaBE> arrFamilia = new ArrayList<FamiliaBE>();
//               
//        String sql = "SELECT idfamilia,nombre,descripcion,indactivo FROM Familia WHERE indactivo = '1'";
//                //" WHERE indactivo ='"+indActivo+"'";
//       boolean primero;
//       
//        //sql+= " WHERE";
//        if(!(codigo.equals("")) || !(nombre.equals(""))){
//           if (!codigo.equals("")){ 
//               sql +=  " AND idfamilia LIKE '%"+codigo+"%'";
//           }
//           if (!nombre.equals("")){
//               sql += " AND nombre LIKE '%"+nombre+"%'";
//           }
//        }
//        sql +=" order by 1";
//              
//        
//        try{
//            rs=objConexion.EjecutarS(sql);
//            String strCodigo;
//            String strNombre;
//            String strDescripcion;
//            String strEstado;
//            while (rs.next()){
//              
//                strCodigo = rs.getString(1);
//                strNombre = rs.getString(2);
//                strDescripcion = rs.getString(3);
//                strEstado = rs.getString(4);
//                arrFamilia.add(new FamiliaBE(strCodigo,strNombre,strDescripcion,strEstado));
//            }
//             
//        }catch (Exception a){
//            System.out.println(a.getMessage());
//         }
//         finally{
//             objConexion.SalirS();
//         }
//      
//        return arrFamilia;
//    }
//    
    
    
}
