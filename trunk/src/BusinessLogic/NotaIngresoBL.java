/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessEntity.NotaIngresoBE;
import DataAccess.NotaIngresoDA;
import Util.Utilitario;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DIEGO
 */
public class NotaIngresoBL {
    private NotaIngresoBE objNotaIngresoBE;
    private String codigo;
    public boolean insertar(Date fecha,String codCliente) throws Exception{
        boolean exito = false;
        
        objNotaIngresoBE =new NotaIngresoBE(Utilitario.generaCodigo("notaingreso",6),fecha,codCliente,"1");
        NotaIngresoDA objNotaIngresoDA = new NotaIngresoDA();
        exito = objNotaIngresoDA.insertar(objNotaIngresoBE);
        return exito;
    }
    
    public ArrayList<NotaIngresoBE> queryAllNotaIngreso(){
        NotaIngresoDA objGuiaRemisionDA = new NotaIngresoDA();
        return objGuiaRemisionDA.queryAllNotaIngreso();
    }

    /**
     * @return the objNotaIngresoBE
     */
    public NotaIngresoBE getObjNotaIngresoBE() {
        return objNotaIngresoBE;
    }
}
