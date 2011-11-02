/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.EstadoGRBE;
import Util.Utilitario;
import BusinessEntity.GuiaRemisionBE;
import DataAccess.EstadoGRDA;
import DataAccess.GuiaRemisionDA;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DIEGO
 */
public class GuiaRemisionBL {
    private GuiaRemisionBE objGuiaRemisionBE;
    private String codigo;
    public boolean insertar(Date fecha,String codCliente, String codAlmacen) throws Exception{
        boolean exito = false;
        EstadoGRDA objEstadoGRDA = new EstadoGRDA();
        EstadoGRBE objEstadoGRBE = new EstadoGRBE();
        objEstadoGRBE = objEstadoGRDA.queryByDescripcionEstadoGR("Registrado");
        
        objGuiaRemisionBE = new GuiaRemisionBE(Utilitario.generaCodigo("guiaremision",6),fecha,codCliente,codAlmacen, objEstadoGRBE);
        GuiaRemisionDA objGuiaRemisionDA = new GuiaRemisionDA();
        exito = objGuiaRemisionDA.insertar(objGuiaRemisionBE);
        return exito;
    }
    
     public boolean cambiarEstado(String strCodigo,String codEstado) throws Exception{
        boolean exito = false;
        GuiaRemisionDA objGuiaRemisionDA = new GuiaRemisionDA();
        exito = objGuiaRemisionDA.cambiarEstado(strCodigo, codEstado);
        return exito;
     }
    
    public ArrayList<GuiaRemisionBE> queryAllGuiaRemision(){
        GuiaRemisionDA objGuiaRemisionDA = new GuiaRemisionDA();
        return objGuiaRemisionDA.queryAllGuiaRemision();
    }
    
    public ArrayList<GuiaRemisionBE> buscar(String codigo,String nombcliente,String codestado,String idAlmacen){
        GuiaRemisionDA objGuiaRemisionDA = new GuiaRemisionDA();
        return objGuiaRemisionDA.buscar(codigo, nombcliente, codestado, idAlmacen);
    }

     public ArrayList<GuiaRemisionBE> buscarbyCodigoEntidad(String codigo){
          GuiaRemisionDA objGuiaRemisionDA = new GuiaRemisionDA();
        return objGuiaRemisionDA.buscarbyCodigoEntidad(codigo);
     }
    
    
    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the objGuiaRemisionBE
     */
    public GuiaRemisionBE getObjGuiaRemisionBE() {
        return objGuiaRemisionBE;
    }

    /**
     * @param objGuiaRemisionBE the objGuiaRemisionBE to set
     */
    public void setObjGuiaRemisionBE(GuiaRemisionBE objGuiaRemisionBE) {
        this.objGuiaRemisionBE = objGuiaRemisionBE;
    }
}
