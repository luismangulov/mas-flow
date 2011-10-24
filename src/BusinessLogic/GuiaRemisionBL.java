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
    public boolean insertar(Date fecha,String codCliente) throws Exception{
        boolean exito = false;
        objGuiaRemisionBE = new GuiaRemisionBE(Utilitario.generaCodigo("guiaremision",6),fecha,codCliente);
        GuiaRemisionDA objGuiaRemisionDA = new GuiaRemisionDA();
        exito = objGuiaRemisionDA.insertar(objGuiaRemisionBE);
        return exito;
    }
    
    public ArrayList<GuiaRemisionBE> queryAllGuiaRemision(){
        GuiaRemisionDA objGuiaRemisionDA = new GuiaRemisionDA();
        return objGuiaRemisionDA.queryAllGuiaRemision();
    }
}
