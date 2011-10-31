/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import Util.conexion;
import BusinessEntity.EntidadBE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author giuliana
 */
public class EntidadDA {

        public boolean insertar(EntidadBE objEntidad) throws Exception{

        boolean boolExito = false;
        conexion objConexion = new conexion();

        String sql = "INSERT INTO Entidad(idEntidad, nroDocumento, direccion,"
                + "telefono, email, nombreContacto, dniContacto, telefonoContacto, "
                + "razonSocial, paginaWeb, indActivo, idCIUU) "
                + "VALUES('"+ objEntidad.getIdEntidad() +"','" + objEntidad.getNroDocumento()
                +"','" + objEntidad.getDireccion() +"','" + objEntidad.getTelefono()
                +"','" + objEntidad.getEmail() +"','" + objEntidad.getNombreContacto()
                +"','" + objEntidad.getDniContacto() +"','" + objEntidad.getTelefonoContacto()
                +"','" + objEntidad.getRazonSocial() +"','" + objEntidad.getPaginaWeb() +"','" 
                + objEntidad.getIndActivo() +"','" + objEntidad.getIdCIUU() +"');";

         try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}

        return boolExito;
    }



        public ArrayList<EntidadBE> queryAllEntidad(String tipo){

        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<EntidadBE> arrEntidad = new ArrayList<EntidadBE>();
        String sql = "SELECT idEntidad, nroDocumento, direccion, telefono, email, nombreContacto, "
                + "dniContacto, telefonoContacto, razonSocial, paginaWeb, "
                + "indActivo, idCIUU FROM Entidad WHERE idEntidad like '"+tipo+"%' order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdEntidad;
            String strNroDocumento;
            String strDireccion;
            String strTelefono;
            String strEmail;
            String strNombreContacto;
            String strDniContacto;
            String strTelefonoContacto;
            String strRazonSocial;
            String strPaginaWeb;
            String strIndActivo;
            String strIdCIUU;
            while (rs.next()){
                strIdEntidad = rs.getString(1).trim();
                strNroDocumento = rs.getString(2).trim();
                strDireccion = rs.getString(3).trim();
                strTelefono = rs.getString(4).trim();
                strEmail = rs.getString(5).trim();
                strNombreContacto = rs.getString(6).trim();
                strDniContacto = rs.getString(7).trim();
                strTelefonoContacto = rs.getString(8).trim();
                strRazonSocial = rs.getString(9).trim();
                strPaginaWeb = rs.getString(10).trim();
                strIndActivo = rs.getString(11).trim();
                strIdCIUU = rs.getString(12).trim();

                arrEntidad.add(new EntidadBE( strIdEntidad,  strNroDocumento,  strDireccion,
                strTelefono,  strEmail,  strNombreContacto,  strDniContacto, strTelefonoContacto,
                        strRazonSocial, strPaginaWeb,  strIndActivo,  strIdCIUU));
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrEntidad;
    }


        public ArrayList<EntidadBE> queryAllEntidadActivo(String tipo){

        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<EntidadBE> arrEntidad = new ArrayList<EntidadBE>();
        String sql = "SELECT idEntidad, nroDocumento, direccion, telefono, email, nombreContacto, "
                + "dniContacto, telefonoContacto, razonSocial, paginaWeb, "
                + "indActivo, idCIUU FROM Entidad WHERE IndActivo = '1' and idEntidad like '"+tipo+"%' order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdEntidad;
            String strNroDocumento;
            String strDireccion;
            String strTelefono;
            String strEmail;
            String strNombreContacto;
            String strDniContacto;
            String strTelefonoContacto;
            String strRazonSocial;
            String strPaginaWeb;
            String strIndActivo;
            String strIdCIUU;
            while (rs.next()){
                strIdEntidad = rs.getString(1).trim();
                strNroDocumento = rs.getString(2).trim();
                strDireccion = rs.getString(3).trim();
                strTelefono = rs.getString(4).trim();
                strEmail = rs.getString(5).trim();
                strNombreContacto = rs.getString(6).trim();
                strDniContacto = rs.getString(7).trim();
                strTelefonoContacto = rs.getString(8).trim();
                strRazonSocial = rs.getString(9).trim();
                strPaginaWeb = rs.getString(10).trim();
                strIndActivo = rs.getString(11).trim();
                strIdCIUU = rs.getString(12).trim();

                arrEntidad.add(new EntidadBE( strIdEntidad,  strNroDocumento,  strDireccion,
                strTelefono,  strEmail,  strNombreContacto,  strDniContacto, strTelefonoContacto,
                        strRazonSocial, strPaginaWeb,  strIndActivo,  strIdCIUU));
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrEntidad;
    }

        public EntidadBE querybyCodigo(String codigo){

        conexion objConexion=new conexion();
        ResultSet rs = null;
        EntidadBE e= new EntidadBE();
        String sql = "SELECT idEntidad, nroDocumento, direccion, telefono, email, nombreContacto, "
                + "dniContacto, telefonoContacto, razonSocial, paginaWeb, "
                + " indActivo, idCIUU FROM Entidad WHERE "
                + "identidad='"+ codigo+"';";
        try{
            rs=objConexion.EjecutarS(sql);
            String strIdEntidad;
            String strNroDocumento;
            String strDireccion;
            String strTelefono;
            String strEmail;
            String strNombreContacto;
            String strDniContacto;
            String strTelefonoContacto;
            String strRazonSocial;
            String strPaginaWeb;
            String strIndActivo;
            String strIdCIUU;

            rs.next();
            strIdEntidad = rs.getString(1).trim();
            strNroDocumento = rs.getString(2).trim();
            strDireccion = rs.getString(3).trim();
            strTelefono = rs.getString(4).trim();
            strEmail = rs.getString(5).trim();
            strNombreContacto = rs.getString(6).trim();
            strDniContacto = rs.getString(7).trim();
            strTelefonoContacto = rs.getString(8).trim();
            strRazonSocial = rs.getString(9).trim();
            strPaginaWeb = rs.getString(10).trim();
            strIndActivo = rs.getString(11).trim();
            strIdCIUU = rs.getString(12).trim();

                e = new EntidadBE( strIdEntidad,  strNroDocumento,  strDireccion,
                strTelefono,  strEmail,  strNombreContacto,  strDniContacto,
                strTelefonoContacto, strRazonSocial, strPaginaWeb,  strIndActivo, strIdCIUU);


        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return e;
    }


        public ArrayList<EntidadBE> buscar(String tipoEntidad, String tipoPersona, String nroDocumento,
                String razonSocial, String direccion, String indActivo){

        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<EntidadBE> arrEntidad = new ArrayList<EntidadBE>();

        String sql = "SELECT idEntidad, nroDocumento, direccion, telefono, email, nombreContacto, "
                + "dniContacto, telefonoContacto, razonSocial, paginaWeb, "
                + "indActivo, idCIUU FROM Entidad WHERE idEntidad like '"+tipoEntidad+"%'";

        if (tipoPersona == null ? "" != null : !tipoPersona.equals("")){
            if (tipoPersona.equals("E")){sql= sql + "and  length(nroDocumento)=11  ";}
            else if (tipoPersona.equals("P")){sql= sql + "and  length(nroDocumento)=8 ";}
        }

        if (nroDocumento == null ? "" != null : !nroDocumento.equals("")){
            sql= sql + "and  nroDocumento like '%"+ nroDocumento+"%' ";
        }

        if (razonSocial == null ? "" != null : !razonSocial.equals("")){
            sql= sql + "and  razonSocial like '%"+ razonSocial+"%' ";
        }

        if (direccion == null ? "" != null : !direccion.equals("")){
            sql= sql + "and  direccion like '%"+ direccion+"%' ";
        }

        if (indActivo == null ? "" != null : !indActivo.equals("")){
            sql= sql + "and  indActivo like '"+ indActivo+"' ";
        }

        sql =sql +  " order by 1";

        try{
            rs=objConexion.EjecutarS(sql);
            String strIdEntidad;
            String strNroDocumento;
            String strDireccion;
            String strTelefono;
            String strEmail;
            String strNombreContacto;
            String strDniContacto;
            String strTelefonoContacto;
            String strRazonSocial;
            String strPaginaWeb;
            String strIndActivo;
            String strIdCIUU;
            while (rs.next()){
                strIdEntidad = rs.getString(1).trim();
                strNroDocumento = rs.getString(2).trim();
                strDireccion = rs.getString(3).trim();
                strTelefono = rs.getString(4).trim();
                strEmail = rs.getString(5).trim();
                strNombreContacto = rs.getString(6).trim();
                strDniContacto = rs.getString(7).trim();
                strTelefonoContacto = rs.getString(8).trim();
                strRazonSocial = rs.getString(9).trim();
                strPaginaWeb = rs.getString(10).trim();
                strIndActivo = rs.getString(11).trim();
                strIdCIUU = rs.getString(12).trim();

                arrEntidad.add(new EntidadBE( strIdEntidad,  strNroDocumento,  strDireccion,
                strTelefono,  strEmail,  strNombreContacto,  strDniContacto, strTelefonoContacto,
                        strRazonSocial, strPaginaWeb,  strIndActivo,  strIdCIUU));
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }

        return arrEntidad;
    }


     public boolean modificar( EntidadBE objEntidad) throws Exception{

        boolean boolExito = false;
        conexion objConexion = new conexion();

        String sql = "update Entidad set  "
                
                +" direccion='" + objEntidad.getDireccion() +"', telefono='" + objEntidad.getTelefono()
                +"', email='" + objEntidad.getEmail() +"', nombrecontacto='" + objEntidad.getNombreContacto()
                +"', dnicontacto='" + objEntidad.getDniContacto() +"',telefonocontacto='" + objEntidad.getTelefonoContacto()
                +"', razonsocial='" + objEntidad.getRazonSocial()+"', paginaweb='" + objEntidad.getPaginaWeb() 
                +"', indActivo='" + objEntidad.getIndActivo() +"', idciuu='" + objEntidad.getIdCIUU()
                +"' where  identidad='"+ objEntidad.getIdEntidad() +"'";

         try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}

        return boolExito;
    }

    public boolean eliminar(String idEntidad) {

        boolean boolExito = false;
        conexion objConexion = new conexion();

        String sql = "DELETE FROM entidad";
             sql += " WHERE idEntidad='"+idEntidad+"'";

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
