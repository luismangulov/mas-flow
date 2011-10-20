/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;
import BusinessEntity.ProveedorBE;
import BD.conexion;
/**
 *
 * @author victor
 */
public class ProveedorDA {
    public boolean insertarProveedor(ProveedorBE objProveedor) throws Exception{
        boolean boolExito = false;
        conexion objConexion = new conexion();
        String sql = "INSERT INTO Entidad(identidad,direccion,telefono,email,nombrecontacto,dnicontacto,telefonocontacto,idtipopersona,razonsocial,paginaweb,idtipoentidad,nrodocumento,indactivo,idciuu) VALUES('"+ objProveedor.getCodigo() +"', '" + objProveedor.getDireccion() +"', '" + objProveedor.getTelefono() + "', '" + objProveedor.getEmail() + "', '" + objProveedor.getNombreContacto() + "', '" + objProveedor.getDNIContacto() + "', '" + objProveedor.getTelefonoContacto() + "', '" + objProveedor.getTipoPersona() + "', '" + objProveedor.getRazonSocial() + "', '" + objProveedor.getPaginaWeb() + "', 'P' , '" + objProveedor.getNroDocumento() + "', 'A', '" + objProveedor.getCiuu() + "')";

        try{
            objConexion.EjecutarUID(sql);
            boolExito = true;

        }catch(Exception e){
            System.out.println(e.getMessage());

        }
        finally{objConexion.SalirUID();}

    return boolExito;
    }
}
