/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BD.conexion;
import BusinessEntity.GuiaRemisionBE;

/**
 *
 * @author DIEGO
 */
public class GuiaRemisionDA {
     public boolean insertar(GuiaRemisionBE objGuiaRemision) throws Exception{
        
        boolean boolExito = false;
        conexion objConexion = new conexion();
       
        String sql = "INSERT INTO guiaremision(idguiaremision, fecha, identidad) VALUES('"+ objGuiaRemision.getCodigo() +"','"+ objGuiaRemision.getFecha() +"','"+ objGuiaRemision.getCliente().getIdEntidad() +"')";
        
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
