/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;
import BusinessEntity.UnidadMedidaBE;
import DataAccess.UnidadMedidaDA;
import java.util.ArrayList;
/**
 *
 * @author victor
 */
public class UnidadMedidaBL {

    public String getIdUnidadMedida(String nombreUnidadMedida){
        UnidadMedidaDA objUnidadMedidaDA = new UnidadMedidaDA();
        String idUnidadMedida = objUnidadMedidaDA.queryByIdUnidadMedida(nombreUnidadMedida).getidUnidadMedida();
        return idUnidadMedida;
    }

    public ArrayList<UnidadMedidaBE> getAllUnidadMedida(){
        ArrayList<UnidadMedidaBE>  arrUnidadMedida = null;
        UnidadMedidaDA objUnidadDA = new UnidadMedidaDA();
        arrUnidadMedida = objUnidadDA.queryAllUnidadMedida();
        return arrUnidadMedida;
    }
}
