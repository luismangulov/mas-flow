/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Util.conexion;
import BusinessEntity.EntidadBE;
import BusinessEntity.GuiaRemisionBE;
import BusinessLogic.EntidadBL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

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
     
     public ArrayList<GuiaRemisionBE> queryAllGuiaRemision(){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<GuiaRemisionBE> arrGuiaRemision = new ArrayList<GuiaRemisionBE>();
        String sql = "SELECT idguiaremision,fecha,identidad FROM guiaremision order by 1";
        try{
            rs=objConexion.EjecutarS(sql);
            String strCodigo;
            Date fecha;
            String strIdEntidad;
            String strEstado;
            while (rs.next()){
              
                strCodigo = rs.getString(1);
                fecha = rs.getDate(2);
                strIdEntidad = rs.getString(3);
                strEstado = rs.getString(4);
                EntidadBL objEntidadBL = new EntidadBL();
                EntidadBE objEntidadBE = objEntidadBL.getCliente(strIdEntidad);
                arrGuiaRemision.add(new GuiaRemisionBE(strCodigo,fecha,objEntidadBE));
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrGuiaRemision;
    }
}
