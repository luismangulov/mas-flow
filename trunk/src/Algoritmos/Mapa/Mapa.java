/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Algoritmos.Mapa;

import Algoritmos.RecorridoOptimo.Cromosoma;
import BusinessEntity.AlmacenBE;
import BusinessEntity.RackBE;
import BusinessEntity.UbicacionBE;
import BusinessEntity.ZonaBE;
import java.util.ArrayList;

/**
 *
 * @author carlitos
 */
public class Mapa {
    
    private Nodo[][] mapa;
    private double AL; //largo almacen
    private double AA; //ancho almacen
    private double PL; //largo pallet
    private double PA; //ancho pallet
    private int numX;
    private int numY;
    private int posPuertaX; //posicion puerta x
    private int posPuertaY; //posicion puerta y

    private ArrayList<ZonaBE> listaZonas;
    private ArrayList<ArrayList<RackBE>> listaRacks; //lista de racks por cada zona

    public Mapa(AlmacenBE almacen)
    {
        


        //listaZonas()=AlmacenDA.obtenerZonas(idAlmacen)

        listaRacks = new ArrayList<ArrayList<RackBE>>();
        for (ZonaBE zona : listaZonas)
        {
            ArrayList<RackBE> temp = new ArrayList<RackBE>();
            //temp = ZonaDA.obtenerRacks(zona.getIdZona())
            listaRacks.add(temp);
        }

    }


    public void mostrarGraficoMapa(String idAlmacen)
    {
    
    }


    public void mostrarGraficoMapa(ArrayList<UbicacionBE> mejoresUbicaciones)
    {

    }


    public void mostrarGraficoMapa(Cromosoma mejorCromosoma)
    {

    }


    public Nodo[][] getMapa() {
        return mapa;
    }


    public int getNumX() {
        return numX;
    }


    public int getNumY() {
        return numY;
    }


    public ArrayList<ZonaBE> getListaZonas() {
        return listaZonas;
    }


    public ArrayList<ArrayList<RackBE>> getListaRacks() {
        return listaRacks;
    }


    
}
