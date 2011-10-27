/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;


import BusinessEntity.PerfilBE;
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
       
        String sql = "INSERT INTO perfil(idPerfil, descripcion, indactivo) VALUES('"+ objPerfil.getIdPerfil()+"','"+ objPerfil.getDescripcion() +"','"+ objPerfil.getIndActivo()+"')";
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        
        return boolExito;
    }
    
        public boolean insertarPerfil(PerfilBE objPerfil) throws Exception{
        
        boolean boolExito = false;
        conexion objConexion = new conexion();
       
        String sql = "INSERT INTO perfil(idPerfil, descripcion, indactivo) VALUES('"+ objPerfil.getIdPerfil()+"','"+ objPerfil.getDescripcion() +"','1')";
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        
        return boolExito;
    }
    
    public ArrayList<PerfilBE> queryAllPerfil(){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<PerfilBE> arrPerfil = new ArrayList<PerfilBE>();
        String sql = "SELECT idPerfil,descripcion,indactivo FROM Perfil WHERE IndActivo = '1' order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdPerfil;
            String strDescripcion;
            String strIndActivo;
            while (rs.next()){
              
                strIdPerfil = rs.getString(1);
                strDescripcion = rs.getString(2);
                strIndActivo = rs.getString(3);
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

     public PerfilBE queryByIdPerfil(String idPerfil){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        PerfilBE perfil = null;
        String sql = "SELECT idPerfil,descripcion,indactivo FROM Perfil ";
           sql += " WHERE idPerfil='"+idPerfil+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdPerfil;
            String strDescripcion;
            String strIndActivo;
            if (rs.next()){
              
                strIdPerfil = rs.getString(1);
                strDescripcion = rs.getString(2);
                strIndActivo = rs.getString(3);
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

    public PerfilBE queryByNombre(String descripcion){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        PerfilBE perfil = null;
        String sql = "SELECT idPerfil,descripcion,indactivo FROM Perfil ";
           sql += " WHERE descripcion='"+descripcion+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdPerfil;
            String strDescripcion;
            String strIndActivo;
            if (rs.next()){

                strIdPerfil = rs.getString(1);
                strDescripcion = rs.getString(2);
                strIndActivo = rs.getString(3);
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
     
      public boolean eliminar(String idPerfil) throws Exception{
        
        boolean boolExito = false;
        conexion objConexion = new conexion();
       
        String sql = "DELETE FROM Perfil";
             sql += " WHERE idPerfil='"+idPerfil+"'";
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        
        return boolExito;
    }
      
//    public ArrayList<FamiliaBE> buscar(String codigo,String nombre,String estado){
//        conexion objConexion=new conexion();
//        ResultSet rs = null;
//        ArrayList<FamiliaBE> arrFamilia = new ArrayList<FamiliaBE>();
//        String indActivo = "";
//        if(estado.equals("Activo")){
//            indActivo = "1";
//        }else if(estado.equals("Inactivo")){
//             indActivo = "0";
//        }
//        
//        String sql = "SELECT idfamilia,nombre,descripcion,indactivo FROM Familia";
//                //" WHERE indactivo ='"+indActivo+"'";
//       boolean primero;
//        primero = true;
//        //sql+= " WHERE";
//        if(!(codigo.equals("")) || !(nombre.equals("")) || !estado.equals("")){
//           if (!codigo.equals("")){           
//               if(primero == true){
//                   sql+= " WHERE";
//                   primero = false;
//               }else if(primero == false)sql+= " AND ";
//               sql +=  " idfamilia LIKE '%"+codigo+"%'";
//           }
//           if (!nombre.equals("")){
//               if(primero == true){
//                   sql+= " WHERE";
//                   primero = false;
//               }else if(primero == false)sql+= " AND ";
//               sql += " nombre LIKE '%"+nombre+"%'";
//           }
//           if(estado.equals("Activo")){
//               if(primero == true){
//                   sql+= " WHERE";
//                   primero = false;
//               }else if(primero == false)sql+= " AND ";
//               sql += " indactivo = '1'";
//           }    
//           if(estado.equals("Inactivo")){
//               if(primero == true){
//                   sql+= " WHERE";
//                   primero = false;
//               }else if(primero == false)sql+= " AND ";
//               sql += " indactivo = '0'";
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
//    
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
