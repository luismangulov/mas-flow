/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package masflow;

import CargaMasiva.CargaMasiva;
import Mantenimientos.Almacen.AdmAlmacen;
import Seguridad.Login;
import Seguridad.Perfil.AdmPerfil;
import Seguridad.Usuario.AdmUsuario;


/**
 *
 * @author diego
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        Login L = new Login();
        L.setVisible(true);

    }

}
