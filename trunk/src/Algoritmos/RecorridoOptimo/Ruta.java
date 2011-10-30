/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Algoritmos.RecorridoOptimo;

import Algoritmos.Mapa.Nodo;
import java.util.ArrayList;
import java.util.LinkedList;
//import java.util.Random;

/**
 *
 * @author carlitos
 */
public class Ruta {
//Esta clase debe ser serializada

    private Nodo productoOrigen;

    private Nodo productoDestino;

    private Nodo rutaOptima[] = null;

    private double distanciaTotal;

    private static ArrayList<ArrayList<Double>> ady;

    public Ruta(Nodo origen, Nodo destino,final Nodo nodos[])
    {
        productoOrigen = origen;
        productoDestino = destino;
        aplicarDijkstra(nodos);
    }
    
   public static Ruta obtenerRuta(Nodo producto1, Nodo producto2)
   {
        //HACER QUERY A LA BD PARA OBTENER LA RUTA ENTRE EL PRODUCTO1 Y EL PRODUCTO2
       return null;
   }

    private void aplicarDijkstra(final Nodo puntos[])
    {
	ArrayList<Double> distancia = new ArrayList<Double>();
        ArrayList<Boolean> visto = new ArrayList<Boolean>();
        ArrayList<Nodo> camino = new ArrayList<Nodo>();

        int i,posPuntoActual,k,MAX;

        //MAX = ady.size();
        
        MAX = puntos.length;

        for(i=0; i<MAX; i++)
        {
            visto.add(false);
            distancia.add(Double.POSITIVE_INFINITY);
            camino.add(null);
        }

        posPuntoActual=productoOrigen.getId();
        distancia.set(posPuntoActual, 0.0);
        while (!estenVistosTodos(visto))
        {
            visto.set(posPuntoActual, true);

            for(k=0; k<MAX; k++)

                    if ( distancia.get(posPuntoActual) + peso(puntos[posPuntoActual],puntos[k]) < distancia.get(k)) 
                    {
                        distancia.set(k, distancia.get(posPuntoActual) + peso(puntos[posPuntoActual],puntos[k]));
                        camino.set(k, puntos[posPuntoActual]);
                    }

            if (posPuntoActual==productoDestino.getId()) break;

            posPuntoActual = buscarMinDistancia(distancia,visto,MAX);
        }

        distanciaTotal = distancia.get(productoDestino.getId());

        LinkedList<Nodo> caminoOptimo = new LinkedList<Nodo>();
        int idPunto = productoDestino.getId();

        while ((idPunto != productoOrigen.getId()) && (camino.get(idPunto)!=null))
        {
            caminoOptimo.addFirst(puntos[idPunto]);
            idPunto = camino.get(idPunto).getId();
        }

        caminoOptimo.addFirst(productoOrigen);

        rutaOptima = new Nodo[caminoOptimo.size()];
        for (i=0;i<caminoOptimo.size();i++)
            rutaOptima[i]=caminoOptimo.get(i);
    }


    private boolean estenVistosTodos(ArrayList<Boolean> visto)
    {
        boolean vistosTodos = true;

        for (int i=0; i<visto.size(); i++)
            vistosTodos=vistosTodos && visto.get(i);

        return vistosTodos;
    }

    
    int buscarMinDistancia(ArrayList<Double> distancia, ArrayList<Boolean> visto,int MAX)
    {
        double min;
        int minPos;

        min = Double.POSITIVE_INFINITY;
        minPos = -1;

        for(int i = 0 ; i< MAX; i++)
            if ((distancia.get(i) <= min) && (!visto.get(i)))
            {
                    min = distancia.get(i);
                    minPos = i;
            }

        return minPos;
    }


    public static Double peso(Nodo producto1 , Nodo producto2)
    {
        //Devuelve la distancia entre dos nodos. Si es infinita entonces no hay conexion.
        //FALTA CARGAR LA MATRIZ DE LA BD
        return (ady.get(producto1.getId())).get(producto2.getId());
    }

    public Nodo getProductoOrigen() {
        return productoOrigen;
    }


    public Nodo getProductoDestino() {
        return productoDestino;
    }


    public double getDistanciaTotal() {
        return distanciaTotal;
    }


    public Nodo[] getRutaOptima() {
        return rutaOptima;
    }

}
