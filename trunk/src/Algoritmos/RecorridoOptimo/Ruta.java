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


    public static void llenarMatrizAdy(final Nodo nodos[])
    {
        ady = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> temp;

        int i;
        int j;
        Nodo nodoi;
        Nodo nodoj;

        for (i=0 ; i < nodos.length ; i++)
        {
            temp = new ArrayList<Double>();
            nodoi = nodos[i];

            for (j=0 ; j < nodos.length ; j++)
            {
                double d;
                nodoj = nodos[j];

                if (j==i)
                    d = 0;
                else
                    d = distancia(nodoi,nodoj);

                temp.add(d);
            }
            ady.add(temp);
        }

        removerConexiones(nodos);
    }


    public static double distancia(Nodo nodoi, Nodo nodoj) {
      double x = nodoi.getX();
      double y = nodoi.getY();
      double dx= x - nodoj.getX();
      double dy= y - nodoj.getY();
      double distance=Math.sqrt(dx * dx + dy * dy);
      return distance;
    }


    //Forma una malla
    public static void removerConexiones(final Nodo punto[])
    {
        int i;
        int j;

        double pesoMax = peso(punto[0],punto[1]);
        pesoMax = pesoMax + 0.2 * pesoMax;

        i=0;
        while (i<punto.length && ady.size()>2)
        {
            j=0;
            while (j<punto.length)
            {
                if (peso(punto[i],punto[j]) > pesoMax)//((peso(punto[i],punto[j]) > pesoMax) && (i != j))
                {
                    (ady.get(i)).set(j, Double.POSITIVE_INFINITY);
                    (ady.get(j)).set(i, Double.POSITIVE_INFINITY);
                }
                j++;
            }
            i++;
        }

        
        //falta quitar las conexiones entre racks
        for (i=0;i<punto.length;i++)
        {
            if (punto[i].getItem()!=null)
            {
                removerConexionesVecinas(punto[i]);
            }
        }


    }

    private static void removerConexionesVecinas(Nodo n)
    {
        for (int i=0;i<ady.size();i++)
        {
            (ady.get(n.getId())).set(i, Double.POSITIVE_INFINITY);
            (ady.get(i)).set(n.getId(), Double.POSITIVE_INFINITY);
        }
    }
    

    private void aplicarDijkstra(final Nodo puntos[])
    {
	ArrayList<Double> distancia = new ArrayList<Double>();
        ArrayList<Boolean> visto = new ArrayList<Boolean>();
        ArrayList<Nodo> camino = new ArrayList<Nodo>();

        int i,posPuntoActual,k,MAX;
      
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


    public static Double peso(Nodo nodoObligatorio1 , Nodo nodoObligatorio2)
    {
        //Devuelve la distancia entre dos nodos. Si es infinita entonces no hay conexion.
        //FALTA CARGAR LA MATRIZ DE LA BD
        return (ady.get(nodoObligatorio1.getId())).get(nodoObligatorio2.getId());
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
