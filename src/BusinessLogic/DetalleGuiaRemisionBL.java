/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Util.Utilitario;
import BusinessEntity.DetalleGuiaRemisionBE;
import DataAccess.DetalleGuiaRemisionDA;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author DIEGO
 */
public class DetalleGuiaRemisionBL {
  
    public boolean insertar(String idGuiaRemision,String idProducto,int cantidad) throws FileNotFoundException, IOException, Exception{
        boolean exito = false;
        DetalleGuiaRemisionBE objDetalleGuiaRemisionBE;
        
        //objDetalleGuiaRemisionBE = new DetalleGuiaRemisionBE(Utilitario.generaCodigoDetalle("detalleguiaremision","idguiaremision",idGuiaRemision,6),cantidad,idProducto);
        objDetalleGuiaRemisionBE = new DetalleGuiaRemisionBE(Utilitario.generaCodigo("detalleguiaremision",6),cantidad,idProducto);
        DetalleGuiaRemisionDA objDetalleGuiaRemisionDA = new DetalleGuiaRemisionDA();
        exito = objDetalleGuiaRemisionDA.insertar(objDetalleGuiaRemisionBE,idGuiaRemision);
        return exito;
    }
    
     public ArrayList<DetalleGuiaRemisionBE> queryAllDetalleGuiaRemision(String codGuiaRemision){
          DetalleGuiaRemisionDA objDetalleGuiaRemisionDA = new DetalleGuiaRemisionDA();
          return objDetalleGuiaRemisionDA.queryAllDetalleGuiaRemision(codGuiaRemision);
      }
    
}
