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
              
                strIdPerfil = rs.getString(1);
                strDescripcion = rs.getString(2);
                strIndActivo = rs.getString(3);
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
