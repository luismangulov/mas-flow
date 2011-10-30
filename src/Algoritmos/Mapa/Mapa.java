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
import Util.Configuracion;
import java.util.ArrayList;

/**
 *
 * @author carlitos
 */
public class Mapa {
    
    private Nodo[][] mapa;
    private AlmacenBE almacen;
    private double AL; //largo almacen
    private double AA; //ancho almacen
    private double PL; //largo pallet
    private double PA; //ancho pallet
    private int numX;
    private int numY;
    private int posPuertaX; //posicion puerta x
    private int posPuertaY; //posicion puerta y

    private ArrayList<ZonaBE> listaZonas;
    private ArrayList<RackBE> listaRacks; //lista de racks por cada zona

    public Mapa(AlmacenBE almacen)
    {
        //almacen = Almacen.obtenerAlmacen(idAlmacen)
        //listaZonas = Zona.obtenerZonas(idAlmacen)
        //listaRacks = Rack.obtenerRacks(zona.getIdZona())

        PL = Configuracion.getLargoPallet();
        PA = Configuracion.getAnchoPallet();

        AL = almacen.getLargo();
        AA = almacen.getAncho();

        numX = (int)(AL/PL);
        numY = (int)(AA/PA);

        mapa = new Nodo[numX][numY];

        inicializarMapa();

        for (RackBE rack : listaRacks)
        {
            llenarUbicacionesRack(rack);
        }

    }


    private void inicializarMapa()
    {
        int id=0;
        for (int i=0;i<numX;i++)
        {
            for (int j=0;j<numY;j++)
            {
                //Nodo nodo = new Nodo(id,x,y,item);
                Nodo nodo = new Nodo(id,i,j,null);
                mapa[i][j]=nodo;
                id++;
            }
        }
    }


    private void llenarUbicacionesRack(RackBE rack)
    {
        //ArrayList<UbicacionBE> listaUbicacion = RackDA.ObtenerUbicaciones(rack.getIdRack());
        ArrayList<UbicacionBE> listaUbicacion = null;

        for (UbicacionBE ubicacion : listaUbicacion)
        {
                //if (rack.esVertical())
                    mapa[rack.getPosX()][rack.getPosY()+ubicacion.getColumna()].setItem(ubicacion);
                //else
                //  mapa[rack.getPosX()+ubicacion.getColumna()][rack.getPosY()].setItem(ubicacion);
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


    public ArrayList<RackBE> getListaRacks() {
        return listaRacks;
    }


    
}
