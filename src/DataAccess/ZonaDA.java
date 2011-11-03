/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Util.conexion;
import BusinessEntity.ZonaBE;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import BusinessEntity.FamiliaBE;

/**
 *
 * @author victor
 */
public class ZonaDA {

    ArrayList<ZonaBE> arrZonas;
    ZonaBE objZonaBE;
    conexion objConexion;
    String query;


    public ArrayList<ZonaBE> queryAllZona(){

        objConexion = new conexion();
        ResultSet rs = null;
        arrZonas = new ArrayList<ZonaBE>();

        query = "SELECT idZona, nombre, identificador, indActivo,"
                + " idAlmacen, posX, posY, ancho, largo FROM Zona order by 1";

        try{
            rs = objConexion.EjecutarS(query);
            String strIdZona;
            String strNombre;
            String strIdentificador;
            String strIndActivo;
            String strIdAlmacen;
            int intX;
            int intY;
            int intAncho;
            int intLargo;
            ArrayList <FamiliaBE> familias;

            while (rs.next()){

                strIdZona = rs.getString(1).trim();
                strNombre = rs.getString(2).trim();
                strIdentificador = rs.getString(3).trim();
                strIndActivo = rs.getString(4).trim();
                strIdAlmacen = rs.getString(5).trim();
                intX = rs.getInt(6);
                intY= rs.getInt(7);
                intAncho= rs.getInt(8);
                intLargo= rs.getInt(9);

                familias= querryAllFamilias(strIdZona);

                arrZonas.add(new ZonaBE(strIdZona, strNombre, strIdentificador, strIndActivo,
                strIdAlmacen, intX, intY, intAncho, intLargo, familias));
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrZonas;
    }

    public ArrayList<ZonaBE> queryAllZonaActiva(){

        objConexion = new conexion();
        ResultSet rs = null;
        arrZonas = new ArrayList<ZonaBE>();

        query = "SELECT idZona, nombre, identificador, indActivo,"
                + " idAlmacen, posX, posY, ancho, largo FROM Zona WHERE IndActivo = '1' order by 1";

        try{
            rs = objConexion.EjecutarS(query);
            String strIdZona;
            String strNombre;
            String strIdentificador;
            String strIndActivo;
            String strIdAlmacen;
            int intX;
            int intY;
            int intAncho;
            int intLargo;
            ArrayList <FamiliaBE> familias;

            while (rs.next()){

                strIdZona = rs.getString(1).trim();
                strNombre = rs.getString(2).trim();
                strIdentificador = rs.getString(3).trim();
                strIndActivo = rs.getString(4).trim();
                strIdAlmacen = rs.getString(5).trim();
                intX = rs.getInt(6);
                intY= rs.getInt(7);
                intAncho= rs.getInt(8);
                intLargo= rs.getInt(9);

                familias= querryAllFamilias(strIdZona);

                arrZonas.add(new ZonaBE(strIdZona, strNombre, strIdentificador, strIndActivo,
                strIdAlmacen, intX, intY, intAncho, intLargo, familias));
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrZonas;
    }



    public ZonaBE queryByIdZona(String idZona){

        objConexion = new conexion();
        ResultSet rs = null;
        arrZonas = new ArrayList<ZonaBE>();

        query = "SELECT idZona, nombre, identificador, indActivo,"
                + " idAlmacen, posX, posY, ancho, largo FROM Zona WHERE idZona = '"+idZona+"' order by 1";

        try{
            rs = objConexion.EjecutarS(query);
            String strIdZona;
            String strNombre;
            String strIdentificador;
            String strIndActivo;
            String strIdAlmacen;
            int intX;
            int intY;
            int intAncho;
            int intLargo;
            ArrayList <FamiliaBE> familias;

            if (rs.next()){

                strIdZona = rs.getString(1).trim();
                strNombre = rs.getString(2).trim();
                strIdentificador = rs.getString(3).trim();
                strIndActivo = rs.getString(4).trim();
                strIdAlmacen = rs.getString(5).trim();
                intX = rs.getInt(6);
                intY= rs.getInt(7);
                intAncho= rs.getInt(8);
                intLargo= rs.getInt(9);
                familias= querryAllFamilias(strIdZona);

                objZonaBE= new ZonaBE(strIdZona, strNombre, strIdentificador, strIndActivo,
                strIdAlmacen, intX, intY, intAncho, intLargo, familias);
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e, query, 0);
         }
         finally{
             objConexion.SalirS();
         }

      return objZonaBE;
    }


    private ArrayList<FamiliaBE> querryAllFamilias(String strIdZona) {
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<FamiliaBE> arrFamilia = new ArrayList<FamiliaBE>();
        String sql = "SELECT ZF.idfamilia, nombre, descripcion, indActivo FROM Familia F, ZonaXFamilia ZF "
                + "WHERE IndActivo = '1'  and F.idfamilia= ZF.idfamilia and idzona='"+strIdZona+"' order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdFamilia;
            String strNombre;
            String strDescripcion;
            String strIndActivo;

            while (rs.next()){
            strIdFamilia = rs.getString(1).trim();
            strNombre = rs.getString(2).trim();
            strDescripcion = rs.getString(3).trim();
            strIndActivo = rs.getString(4).trim();
            arrFamilia.add(new FamiliaBE(strIdFamilia,strNombre,strDescripcion,strIndActivo));
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrFamilia;
    }

    public boolean insertar(ZonaBE zona) {
        boolean boolExito = false;
        objConexion = new conexion();

        String sql = "INSERT INTO zona(idZona, nombre, identificador, indActivo,"
                + " idAlmacen, posX, posY, ancho, largo) "
                + "VALUES('"+ zona.getIdZona() +"','"+ zona.getNombre() +"','"
                + zona.getIdentificador() +"','"+ zona.getIndActivo()
                +"','"+ zona.getIdAlmacen()
                +"',"+ zona.getPosX() +","+ zona.getPosY()
                +","+ zona.getAncho()+","+ zona.getLargo()
                +") ;";

        if (!zona.getFamilias().isEmpty()){
            int i=0;
            while (i<zona.getFamilias().size()){
                sql= sql + "INSERT INTO zonaXfamilia(idZona, idFamilia) values ('"+zona.getIdZona()
                        +"','"+zona.getFamilias().get(i).getIdFamilia()+"'); ";
                i++;
            }
        }
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}

        return boolExito;
    }

    public boolean modificar(ZonaBE objZona) {
        boolean boolExito = false;
        objConexion = new conexion();

        String sql = "UPDATE zona SET ";
             sql += "nombre='"+objZona.getNombre()+"'," +
                    "identificador='"+objZona.getIdentificador()+ "',"+
                    "indActivo='"+objZona.getIndActivo()+ "',"+
                    "idAlmacen='"+objZona.getIdAlmacen()+ "',"+
                    "posX="+objZona.getPosX()+ ","+
                    "posY="+objZona.getPosY()+ ","+
                    "ancho="+objZona.getAncho()+ ","+
                    "largo="+objZona.getLargo()+
                    " WHERE idZona='"+objZona.getIdZona()+"'; "
                    + "DELETE FROM zonaXfamilia WHERE idZona='"+objZona.getIdZona()+"'; ";

            if (!objZona.getFamilias().isEmpty()){
                int i=0;
                while (i<objZona.getFamilias().size()){
                sql= sql + "INSERT INTO zonaXfamilia(idZona, idFamilia) values ('"+objZona.getIdZona()
                        +"','"+objZona.getFamilias().get(i).getIdFamilia()+"'); ";
                i++;
            }
        }

        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}

        return boolExito;

    }

    public boolean eliminar(String codZona) {
        boolean boolExito = false;
        objConexion = new conexion();

        String sql = "DELETE FROM ZonaXfamilia WHERE idzona='"+codZona+"'; "
                + "DELETE FROM zona WHERE idZona='"+codZona+"'; ";

        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}

        return boolExito;
    }

    public ArrayList<ZonaBE> buscar(String codigo, String nombre, String indActivo, String idAlmacen, String identificador) {

        objConexion = new conexion();
        ResultSet rs = null;
        arrZonas = new ArrayList<ZonaBE>();

        query = "SELECT idZona, nombre, identificador, indActivo,"
                + " idAlmacen, posX, posY, ancho, largo FROM Zona";

         boolean primero;
        primero = true;
        //query+= " WHERE";
        if(!(codigo.equals("")) || !(nombre.equals("")) || !indActivo.equals("") || !idAlmacen.equals("") || !identificador.equals("")){
           if (!codigo.equals("")){
               if(primero == true){
                   query+= " WHERE";
                   primero = false;
               }else if(primero == false)query+= " AND ";
               query +=  " idzona LIKE '%"+codigo+"%'";
           }
           if (!nombre.equals("")){
               if(primero == true){
                   query+= " WHERE";
                   primero = false;
               }else if(primero == false)query+= " AND ";
               query += " nombre LIKE '%"+nombre+"%'";
           }
           if (!idAlmacen.equals("")){
               if(primero == true){
                   query+= " WHERE";
                   primero = false;
               }else if(primero == false)query+= " AND ";
               query += " idAlmacen LIKE '%"+idAlmacen+"%'";
           }
           if (!identificador.equals("")){
               if(primero == true){
                   query+= " WHERE";
                   primero = false;
               }else if(primero == false)query+= " AND ";
               query += " identificador LIKE '%"+identificador+"%'";
           }
           if(indActivo.equals("1")){
               if(primero == true){
                   query+= " WHERE";
                   primero = false;
               }else if(primero == false)query+= " AND ";
               query += " indactivo = '1'";
           }
           if(indActivo.equals("0")){
               if(primero == true){
                   query+= " WHERE";
                   primero = false;
               }else if(primero == false)query+= " AND ";
               query += " indactivo = '0'";
           }
        }
        query +=" order by 1";




        try{
            rs = objConexion.EjecutarS(query);
            String strIdZona;
            String strNombre;
            String strIdentificador;
            String strIndActivo;
            String strIdAlmacen;
            int intX;
            int intY;
            int intAncho;
            int intLargo;
            ArrayList <FamiliaBE> familias;

            while (rs.next()){

                strIdZona = rs.getString(1).trim();
                strNombre = rs.getString(2).trim();
                strIdentificador = rs.getString(3).trim();
                strIndActivo = rs.getString(4).trim();
                strIdAlmacen = rs.getString(5).trim();
                intX = rs.getInt(6);
                intY= rs.getInt(7);
                intAncho= rs.getInt(8);
                intLargo= rs.getInt(9);

                familias= querryAllFamilias(strIdZona);

                arrZonas.add(new ZonaBE(strIdZona, strNombre, strIdentificador, strIndActivo,
                strIdAlmacen, intX, intY, intAncho, intLargo, familias));
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrZonas;

    }

    // lo agregué yo (víctor)

        public ArrayList<ZonaBE> queryZonasByAlmacen(String idAlmacen) {

        objConexion = new conexion();
        ResultSet rs = null;
        arrZonas = new ArrayList<ZonaBE>();

        query = "SELECT * FROM Zona WHERE IndActivo = '1' AND idAlmacen ='" +idAlmacen +"'";

        try{
            rs = objConexion.EjecutarS(query);

            while(rs.next()){

            String strIdZona = rs.getString("idZona");
            String strNombre = rs.getString("nombre");
            String strIndActivo = rs.getString("indActivo");
            String strIdAlmacen = rs.getString("idAlmacen");
            int intLargo = rs.getInt("Largo");
            int intAncho = rs.getInt("Ancho");
            int intPosX = rs.getInt("PosX");
            int intPosY = rs.getInt("posY");
            String strIdentificador = rs.getString("Identificador");

            arrZonas.add(objZonaBE = new ZonaBE(strIdZona,strNombre,strIdentificador,strIndActivo,strIdAlmacen,intPosX,intPosY,intAncho,intLargo,null));
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrZonas;
    }

    public ZonaBE queryByIdentificadorZona(String identificador){

        objConexion = new conexion();
        ResultSet rs = null;
        // aquí cambié el código víctor
        query = "SELECT * FROM Zona WHERE identificador = '"+identificador+"'";

        try{
            rs = objConexion.EjecutarS(query);

            rs.next();
            String strIdZona = rs.getString("idZona");
            String strNombre = rs.getString("nombre");
            String strIndActivo = rs.getString("indActivo");
            String strIdAlmacen = rs.getString("idAlmacen");
            int intLargo = rs.getInt("Largo");
            int intAncho = rs.getInt("Ancho");
            int intPosX = rs.getInt("PosX");
            int intPosY = rs.getInt("posY");
            String strIdentificador = rs.getString("Identificador");

            objZonaBE = new ZonaBE(strIdZona,strNombre,strIdentificador,strIndActivo,strIdAlmacen,intPosX,intPosY,intAncho,intLargo,null);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e, query, 0);
         }
         finally{
             objConexion.SalirS();
         }

      return objZonaBE;
    }

        public ArrayList<ZonaBE> queryZonasByFamilia(String strIdAlmacen, String strIdFamilia) {
        objConexion = new conexion();
        ResultSet rs = null;
        arrZonas = new ArrayList<ZonaBE>();

        query = "SELECT z.idZona, z.Nombre, z.indActivo, z.idAlmacen, z.largo, z.ancho, z.posx, z.posy, z.identificador FROM ALMACEN a, ZONA z, FAMILIA f, ZONAXFAMILIA zxf "
                + " WHERE z.IndActivo = '1' AND a.idAlmacen = z.idAlmacen "
                + " AND z.idZona = zxf.idZona AND f.idFamilia = zxf.idFamilia "
                + " AND a.idAlmacen ='" +strIdAlmacen +"' AND f.idFamilia ='" +strIdFamilia +"'";

        try{
            rs = objConexion.EjecutarS(query);

            while(rs.next()){

            String strIdZona = rs.getString("idZona").trim();
            String strNombre = rs.getString("nombre").trim();
            String strIndActivo = rs.getString("indActivo").trim();
            strIdAlmacen = rs.getString("idAlmacen").trim();
            int intLargo = rs.getInt("Largo");
            int intAncho = rs.getInt("Ancho");
            int intPosX = rs.getInt("PosX");
            int intPosY = rs.getInt("posY");
            String strIdentificador = rs.getString("Identificador").trim();

            arrZonas.add(objZonaBE = new ZonaBE(strIdZona,strNombre,strIdentificador,strIndActivo,strIdAlmacen,intPosX,intPosY,intAncho,intLargo,null));
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrZonas;
    }
}
