/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessEntity.NotaIngresoBE;
import BusinessLogic.EntidadBL;
import Util.conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DIEGO
 */
public class NotaIngresoDA {
    public boolean insertar(NotaIngresoBE objNotaIngreso) throws Exception{
        
        boolean boolExito = false;
        conexion objConexion = new conexion();
       
        String sql = "INSERT INTO notaingreso(idnotaingreso, fecha, identidad, indEstado) VALUES('"+ objNotaIngreso.getCodigo() +"','"+ objNotaIngreso.getFecha() +"','"+ objNotaIngreso.getProveedor().getIdEntidad() +"','"+ objNotaIngreso.getEstado() +"')";
        
        try{
            objConexion.EjecutarUID(sql);
            boolExito=true;
         }catch (Exception a){
            System.out.println(a.getMessage());
        }
        finally{objConexion.SalirUID();}
        
        return boolExito;
    }
     
     public ArrayList<NotaIngresoBE> queryAllNotaIngreso(){
        conexion objConexion=new conexion();
        ResultSet rs = null;
        ArrayList<NotaIngresoBE> arrNotaIngreso = new ArrayList<NotaIngresoBE>();
        String sql = "SELECT idnotaingreso,fecha,identidad,indestado FROM notaingreso order by 1";
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
                //EntidadBE objEntidadBE = objEntidadBL.getCliente(strIdEntidad);
                //arrNotaIngreso.add(new NotaIngresoBE(strCodigo,fecha,objEntidadBE));
            }
             
        }catch (Exception a){
            System.out.println(a.getMessage());
         }
         finally{
             objConexion.SalirS();
         }
      
        return arrNotaIngreso;
    }
}
