/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Util.Utilitario;
import BusinessEntity.GuiaRemisionBE;
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
    public boolean insertar(Date fecha,String codCliente) throws Exception{
        boolean exito = false;
        
        setObjGuiaRemisionBE(new GuiaRemisionBE(Utilitario.generaCodigo("guiaremision",6),fecha,codCliente,"1"));
        GuiaRemisionDA objGuiaRemisionDA = new GuiaRemisionDA();
        exito = objGuiaRemisionDA.insertar(getObjGuiaRemisionBE());
        return exito;
    }
    
    public ArrayList<GuiaRemisionBE> queryAllGuiaRemision(){
        GuiaRemisionDA objGuiaRemisionDA = new GuiaRemisionDA();
        return objGuiaRemisionDA.queryAllGuiaRemision();
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
