/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;


import Util.conexion;
import BusinessEntity.AlmacenBE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author victor
 */
public class AlmacenDA {


     public boolean insertar(AlmacenBE objAlmacen) throws Exception{

        boolean boolExito = false;
        conexion objConexion = new conexion();

        String sql = "INSERT INTO almacen(idAlmacen, nombre, largo, ancho, direccion, "
                + "telefono, idDistrito, idProvincia, idDepartamento, indActivo) "
                + "VALUES('"+ objAlmacen.getIdAlmacen() +"','"+ objAlmacen.getNombre()
                +"',"+ objAlmacen.getLargo() +","+ objAlmacen.getAncho()+",'"
                + objAlmacen.getDireccion() +"','"+ objAlmacen.getTelefono()+"','"
                + objAlmacen.getIdDistrito() +"','"+ objAlmacen.getIdProvincia()+"','"
                + objAlmacen.getIdDepartamento() +"','"+ objAlmacen.getIndActivo() +"')";

        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}

        return boolExito;
    }

    public ArrayList<AlmacenBE> queryAllAlmacen(){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<AlmacenBE> arrAlmacen = new ArrayList<AlmacenBE>();
        String sql = "SELECT idAlmacen, nombre, largo, ancho, direccion, "
                + "telefono, idDistrito, idProvincia, idDepartamento, indActivo"
                + " FROM Almacen order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdAlmacen;
            String strNombre;
            float fltLargo;
            float fltAncho;
            String strDireccion;
            String strTelefono;
            String strIdDistrito;
            String strIdProvincia;
            String strIdDepartamento;
            String strIndActivo;

            while (rs.next()){

                strIdAlmacen = rs.getString(1);
                strNombre = rs.getString(2);
                fltLargo = rs.getFloat(3);
                fltAncho = rs.getFloat(4);
                strDireccion= rs.getString(5);
                strTelefono= rs.getString(6);
                strIdDistrito= rs.getString(7);
                strIdProvincia= rs.getString(8);
                strIdDepartamento= rs.getString(9);
                strIndActivo= rs.getString(10);

                arrAlmacen.add(new AlmacenBE(strIdAlmacen, strNombre, fltLargo, fltAncho, strDireccion,
                strTelefono, strIdDistrito, strIdProvincia, strIdDepartamento, strIndActivo));
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrAlmacen;
    }


    public ArrayList<AlmacenBE> queryAllAlmacenActivo(){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<AlmacenBE> arrAlmacen = new ArrayList<AlmacenBE>();
        String sql = "SELECT idAlmacen, nombre, largo, ancho, direccion, "
                + "telefono, idDistrito, idProvincia, idDepartamento, indActivo"
                + " FROM Almacen WHERE IndActivo = '1' order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdAlmacen;
            String strNombre;
            float fltLargo;
            float fltAncho;
            String strDireccion;
            String strTelefono;
            String strIdDistrito;
            String strIdProvincia;
            String strIdDepartamento;
            String strIndActivo;

            while (rs.next()){

                strIdAlmacen = rs.getString(1);
                strNombre = rs.getString(2);
                fltLargo = rs.getFloat(3);
                fltAncho = rs.getFloat(4);
                strDireccion= rs.getString(5);
                strTelefono= rs.getString(6);
                strIdDistrito= rs.getString(7);
                strIdProvincia= rs.getString(8);
                strIdDepartamento= rs.getString(9);
                strIndActivo= rs.getString(10);

                arrAlmacen.add(new AlmacenBE(strIdAlmacen, strNombre, fltLargo, fltAncho, strDireccion,
                strTelefono, strIdDistrito, strIdProvincia, strIdDepartamento, strIndActivo));
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrAlmacen;
    }


     public AlmacenBE queryByIdAlmacen(String codigo){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        AlmacenBE almacen = null;
        String sql = "SELECT idAlmacen, nombre, largo, ancho, direccion, "
                + "telefono, idDistrito, idProvincia, idDepartamento, indActivo FROM Almacen ";
           sql += " WHERE idalmacen='"+codigo+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdAlmacen;
            String strNombre;
            float fltLargo;
            float fltAncho;
            String strDireccion;
            String strTelefono;
            String strIdDistrito;
            String strIdProvincia;
            String strIdDepartamento;
            String strIndActivo;
            if (rs.next()){

                strIdAlmacen = rs.getString(1);
                strNombre = rs.getString(2);
                fltLargo = rs.getFloat(3);
                fltAncho = rs.getFloat(4);
                strDireccion= rs.getString(5);
                strTelefono= rs.getString(6);
                strIdDistrito= rs.getString(7);
                strIdProvincia= rs.getString(8);
                strIdDepartamento= rs.getString(9);
                strIndActivo= rs.getString(10);
                almacen = new AlmacenBE(strIdAlmacen, strNombre, fltLargo, fltAncho, strDireccion,
                strTelefono, strIdDistrito, strIdProvincia, strIdDepartamento, strIndActivo);
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return almacen;
    }

    
     public boolean modificar(AlmacenBE objAlmacen) throws Exception{

        boolean boolExito = false;
        conexion objConexion = new conexion();

        String sql = "UPDATE almacen SET ";
             sql += "nombre='"+objAlmacen.getNombre()+"'," +
                    "ancho="+objAlmacen.getAncho()+ ","+
                    "largo="+objAlmacen.getLargo()+ ","+
                    "direccion='"+objAlmacen.getDireccion()+ "',"+
                    "telefono='"+objAlmacen.getTelefono()+ "',"+
                    "idDistrito='"+objAlmacen.getIdDistrito()+ "',"+
                    "idProvincia='"+objAlmacen.getIdProvincia()+ "',"+
                    "idDepartamento='"+objAlmacen.getIdDepartamento()+ "',"+
                    "indactivo='"+objAlmacen.getIndActivo()+ "'"+
                    " WHERE idalmacen='"+objAlmacen.getIdAlmacen()+"'";

        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}

        return boolExito;
    }

      public boolean eliminar(String codAlmacen) throws Exception{

        boolean boolExito = false;
        conexion objConexion = new conexion();

        String sql = "DELETE FROM almacen";
             sql += " WHERE idalmacen='"+codAlmacen+"'";

        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}

        return boolExito;
    }

    public ArrayList<AlmacenBE> buscar(String codigo,String nombre,String indActivo, String idDepartamento,
              String idProvincia, String idDistrito){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<AlmacenBE> arrAlmacen = new ArrayList<AlmacenBE>();
        

        String sql = "SELECT idAlmacen, nombre, largo, ancho, direccion, "
                + "telefono, idDistrito, idProvincia, idDepartamento, indActivo FROM Almacen";
              
       boolean primero;
        primero = true;
        //sql+= " WHERE";
        if(!(codigo.equals("")) || !(nombre.equals("")) || !indActivo.equals("")
                || !idDepartamento.equals("") || !idProvincia.equals("") || !idDistrito.equals("")){
           if (!codigo.equals("")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql +=  " idalmacen LIKE '%"+codigo+"%'";
           }
           if (!nombre.equals("")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql += " nombre LIKE '%"+nombre+"%'";
           }
           if(indActivo.equals("1")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql += " indactivo = '1'";
           }
           if (!idDepartamento.equals("")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql +=  " iddepartamento LIKE '%"+idDepartamento+"%'";
           }
           if (!idProvincia.equals("")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql +=  " idprovincia LIKE '%"+idProvincia+"%'";
           }
           if (!idDistrito.equals("")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql +=  " iddistrito LIKE '%"+idDistrito+"%'";
           }
           if(indActivo.equals("0")){
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
            String strIdAlmacen;
            String strNombre;
            float fltLargo;
            float fltAncho;
            String strDireccion;
            String strTelefono;
            String strIdDistrito;
            String strIdProvincia;
            String strIdDepartamento;
            String strIndActivo;

            while (rs.next()){

                strIdAlmacen = rs.getString(1);
                strNombre = rs.getString(2);
                fltLargo = rs.getFloat(3);
                fltAncho = rs.getFloat(4);
                strDireccion= rs.getString(5);
                strTelefono= rs.getString(6);
                strIdDistrito= rs.getString(7);
                strIdProvincia= rs.getString(8);
                strIdDepartamento= rs.getString(9);
                strIndActivo= rs.getString(10);

                arrAlmacen.add(new AlmacenBE(strIdAlmacen, strNombre, fltLargo, fltAncho, strDireccion,
                strTelefono, strIdDistrito, strIdProvincia, strIdDepartamento, strIndActivo));
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrAlmacen;
    }


   
}
