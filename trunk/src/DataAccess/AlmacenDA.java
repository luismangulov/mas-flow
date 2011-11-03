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
                + "telefono, idDistrito, idProvincia, idDepartamento, indActivo, puertaX, puertaY, identificador) "
                + "VALUES('"+ objAlmacen.getIdAlmacen() +"','"+ objAlmacen.getNombre()
                +"',"+ objAlmacen.getLargo() +","+ objAlmacen.getAncho()+",'"
                + objAlmacen.getDireccion() +"','"+ objAlmacen.getTelefono()+"','"
                + objAlmacen.getIdDistrito() +"','"+ objAlmacen.getIdProvincia()+"','"
                + objAlmacen.getIdDepartamento() +"','"+ objAlmacen.getIndActivo() +"', "
                + objAlmacen.getPuertaX() +","+ objAlmacen.getPuertaY()
                +",'"+ objAlmacen.getIdentificador()+"')";

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
                + "telefono, idDistrito, idProvincia, idDepartamento, indActivo, puertaX, puertaY, identificador "
                + " FROM Almacen order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdAlmacen;
            String strNombre;
            double dblLargo;
            double dblAncho;
            String strDireccion;
            String strTelefono;
            String strIdDistrito;
            String strIdProvincia;
            String strIdDepartamento;
            String strIndActivo;
            int intPuertaX;
            int intPuertaY;
            String strIdentificador;

            while (rs.next()){

                strIdAlmacen = rs.getString(1).trim();
                strNombre = rs.getString(2).trim();
                dblLargo = rs.getDouble(3);
                dblAncho = rs.getDouble(4);
                strDireccion= rs.getString(5).trim();
                strTelefono= rs.getString(6).trim();
                strIdDistrito= rs.getString(7).trim();
                strIdProvincia= rs.getString(8).trim();
                strIdDepartamento= rs.getString(9).trim();
                strIndActivo= rs.getString(10).trim();
                intPuertaX = rs.getInt(11);
                intPuertaY = rs.getInt(12);
                strIdentificador = rs.getString(13).trim();

                arrAlmacen.add(new AlmacenBE(strIdAlmacen, strNombre, dblLargo, dblAncho, strDireccion,
                strTelefono, strIdDistrito, strIdProvincia, strIdDepartamento, strIndActivo, intPuertaX, intPuertaY, strIdentificador));
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
                + "telefono, idDistrito, idProvincia, idDepartamento, indActivo, puertaX, puertaY,identificador "
                + " FROM Almacen WHERE IndActivo = '1' order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdAlmacen;
            String strNombre;
            double dblLargo;
            double dblAncho;
            String strDireccion;
            String strTelefono;
            String strIdDistrito;
            String strIdProvincia;
            String strIdDepartamento;
            String strIndActivo;
            int intPuertaX;
            int intPuertaY;
            String strIdentificador;

            while (rs.next()){

                strIdAlmacen = rs.getString(1).trim();
                strNombre = rs.getString(2).trim();
                dblLargo = rs.getDouble(3);
                dblAncho = rs.getDouble(4);
                strDireccion= rs.getString(5).trim();
                strTelefono= rs.getString(6).trim();
                strIdDistrito= rs.getString(7).trim();
                strIdProvincia= rs.getString(8).trim();
                strIdDepartamento= rs.getString(9).trim();
                strIndActivo= rs.getString(10).trim();
                intPuertaX = rs.getInt(11);
                intPuertaY = rs.getInt(12);
                strIdentificador = rs.getString(13).trim();

                arrAlmacen.add(new AlmacenBE(strIdAlmacen, strNombre, dblLargo, dblAncho, strDireccion,
                strTelefono, strIdDistrito, strIdProvincia, strIdDepartamento, strIndActivo, intPuertaX, intPuertaY, strIdentificador));
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
                + "telefono, idDistrito, idProvincia, idDepartamento, indActivo, puertaX, puertaY, identificador FROM Almacen ";
           sql += " WHERE idalmacen='"+codigo+"'";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdAlmacen;
            String strNombre;
            double dblLargo;
            double dblAncho;
            String strDireccion;
            String strTelefono;
            String strIdDistrito;
            String strIdProvincia;
            String strIdDepartamento;
            String strIndActivo;
            String strIdentificador;
            int intPuertaX;
            int intPuertaY;

            if (rs.next()){

                strIdAlmacen = rs.getString(1).trim();
                strNombre = rs.getString(2).trim();
                dblLargo = rs.getDouble(3);
                dblAncho = rs.getDouble(4);
                strDireccion= rs.getString(5).trim();
                strTelefono= rs.getString(6).trim();
                strIdDistrito= rs.getString(7).trim();
                strIdProvincia= rs.getString(8).trim();
                strIdDepartamento= rs.getString(9).trim();
                strIndActivo= rs.getString(10).trim();
                intPuertaX = rs.getInt(11);
                intPuertaY = rs.getInt(12);
                strIdentificador = rs.getString(13).trim();

                almacen = new AlmacenBE(strIdAlmacen, strNombre, dblLargo, dblAncho, strDireccion,
                strTelefono, strIdDistrito, strIdProvincia, strIdDepartamento, strIndActivo, intPuertaX, intPuertaY, strIdentificador);
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
                    "indactivo='"+objAlmacen.getIndActivo()+ "', "+
                    "puertaX="+objAlmacen.getPuertaX()+ ", "+
                    "puertaY="+objAlmacen.getPuertaY()+ ", "+
                    "identificador='"+objAlmacen.getIdentificador()+"' "+
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
              String idProvincia, String idDistrito, String identificador){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<AlmacenBE> arrAlmacen = new ArrayList<AlmacenBE>();
        

        String sql = "SELECT idAlmacen, nombre, largo, ancho, direccion, "
                + "telefono, idDistrito, idProvincia, idDepartamento, indActivo, puertaX, puertaY, identificador FROM Almacen";
              
       boolean primero;
        primero = true;
        //sql+= " WHERE";
        if(!(codigo.equals("")) || !(nombre.equals("")) || !indActivo.equals("")
                || !idDepartamento.equals("") || !idProvincia.equals("") || !idDistrito.equals("") || !identificador.equals("")){
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
           if (!identificador.equals("")){
               if(primero == true){
                   sql+= " WHERE";
                   primero = false;
               }else if(primero == false)sql+= " AND ";
               sql +=  " identificador LIKE '%"+identificador+"%'";
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
            double dblLargo;
            double dblAncho;
            String strDireccion;
            String strTelefono;
            String strIdDistrito;
            String strIdProvincia;
            String strIdDepartamento;
            String strIndActivo;
            int intPuertaX;
            int intPuertaY;
            String strIdentificador;

            while (rs.next()){

                strIdAlmacen = rs.getString(1).trim();
                strNombre = rs.getString(2).trim();
                dblLargo = rs.getDouble(3);
                dblAncho = rs.getDouble(4);
                strDireccion= rs.getString(5).trim();
                strTelefono= rs.getString(6).trim();
                strIdDistrito= rs.getString(7).trim();
                strIdProvincia= rs.getString(8).trim();
                strIdDepartamento= rs.getString(9).trim();
                strIndActivo= rs.getString(10).trim();
                intPuertaX = rs.getInt(11);
                intPuertaY = rs.getInt(12);
                strIdentificador = rs.getString(13).trim();

                arrAlmacen.add(new AlmacenBE(strIdAlmacen, strNombre, dblLargo, dblAncho, strDireccion,
                strTelefono, strIdDistrito, strIdProvincia, strIdDepartamento, strIndActivo, intPuertaX, intPuertaY, strIdentificador));
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
