/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

import DataAccess.PerfilDetalleDA;
import java.util.ArrayList;

    
    
    
    
/**
 *
 * @author Florencio
 */
public class UsuarioSistema {
  
    public static UsuarioBE usuario;
    
    public static boolean PermisoParaAplicacion(String idAplicacion){
        
        PerfilDetalleDA objPerfilDetalleDA=new PerfilDetalleDA();
        ArrayList <String>listaAplicaciones = objPerfilDetalleDA.queryAllIdAplicacionesPorPerfil(usuario.getPerfil().getIdPerfil());
        
        for (int i=0;i<listaAplicaciones.size();i++){
            
            if(listaAplicaciones.get(i).equals(idAplicacion)){
                return true;                
            }                   
        }              
        return false;
        
    }
}
