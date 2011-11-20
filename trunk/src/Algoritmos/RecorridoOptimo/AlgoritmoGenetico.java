/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Algoritmos.RecorridoOptimo;

import Algoritmos.Mapa.Mapa;
import Algoritmos.Mapa.Nodo;
import BusinessEntity.RackBE;
import BusinessEntity.UbicacionBE;
import BusinessLogic.RackBL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author carlitos
 */
public class AlgoritmoGenetico {

//Atributos de configuracion
   private static int tamanoPoblacionInicial=100;
   private static double tasaCrecimiento=0.00075;
   private static int ratioMutacion=(int)(1/0.5);
   private static int maxEdadMejorDistancia=70;
   private static int maxNumGeneraciones=200;

//Atributos de ejecucion
   private static Nodo nodos[]=null;
   private static volatile boolean flagInicio=false;
   private static volatile boolean flagFin=false;
   private static Cromosoma mejorCromosoma;
   private static long tiempoInicio=0;
   private static long tiempoEjecucion=0;
   private static int edadMejorDistancia;
   private static int generacion=0;
   private static double mejorDistancia=0;
   
//Atributos del algoritmo
   private static List<Cromosoma> poblacion=Collections.synchronizedList(new ArrayList<Cromosoma>());
   private static Random rnd;
   private static int tamanoPoblacion;
   private static int puertaPosX;
   private static int puertaPosY;
   public static ArrayList<ArrayList<Ruta>> rutas;


//metodos del algoritmo
   public static void inicializar(final Nodo puntos[]) {
      rnd=new Random();

      poblacion.clear();
      tamanoPoblacion=tamanoPoblacionInicial;
      
      final List<Integer> hilosEnEjecucion=Collections.synchronizedList(new ArrayList<Integer>());

      final Thread parentThread=Thread.currentThread();
      int maxNumHilos=Runtime.getRuntime().availableProcessors()*2;

      //Usa varios hilos para crear la población inicial
      for(int i=0; i<maxNumHilos; i++) {
         hilosEnEjecucion.add(1);
         new Thread(new Runnable(){public void run() {
            while(poblacion.size()<tamanoPoblacion) {
               Cromosoma cromosoma=new Cromosoma(puntos);
               aleatorizar(rnd,cromosoma.getGenes());
               cromosoma.calcularDistanciaTotal();
               poblacion.add(cromosoma);
            }
            hilosEnEjecucion.remove(0);
            parentThread.interrupt();
         }}).start();
      }
      
      while(hilosEnEjecucion.size()>0) {
         try {
            Thread.sleep(1000);
         } catch(Throwable e) {
            //nop
         }
      }

      ordenarPoblacion();
   }

    public static void aleatorizar(final Random aleatorizador, final Nodo[] puntos) {

      final int numPuntos=puntos.length;

      for(int i=0; i<numPuntos; i++) {
         int i1=i;
         int i2=aleatorizador.nextInt(numPuntos);
         if(i2==i1) {
            if(i2>0) { i2--; } else { i2++; }
         }
         Nodo temp=puntos[i1];
         puntos[i1]=puntos[i2];
         puntos[i2]=temp;
      }

      int etapas=10*numPuntos;

      for(int n=0; n<etapas; n++) {
         int i1=aleatorizador.nextInt(numPuntos);
         int i2=aleatorizador.nextInt(numPuntos);
         if(i1!=i2) {
               Nodo temp=puntos[i1];
               puntos[i1]=puntos[i2];
               puntos[i2]=temp;
         }
      }
   }


  public static void ordenarPoblacion() {
      Collections.sort(poblacion,new Comparator<Cromosoma>() {
         public int compare(Cromosoma o1, Cromosoma o2) {
            double distancia1=o1.getDistanciaTotal();
            double distancia2=o2.getDistanciaTotal();
            return (distancia1<distancia2 ? -1 : (distancia1>distancia2?1 : 0));
         }
      });
   }
  

   public static Cromosoma obtenerMejorCromosoma() {
      return poblacion.get(0);
   }


   public static void siguienteGeneracion() {
      //los mejores son la primera mitad de la poblacion
      final int numMejores=(int)(tamanoPoblacion*0.5);

      //deja la mejor parte de la poblacion
      int size=poblacion.size();
      while(size>numMejores) {
         poblacion.remove(size-1);
         size--;
      }

      final List<Integer> hilosEnEjecucion=Collections.synchronizedList(new ArrayList<Integer>());
      final Thread hiloPadre=Thread.currentThread();

      int maxNumHilos=Runtime.getRuntime().availableProcessors()*2;

      final int numPorHilo=numMejores/maxNumHilos;

      for(int i=0; i<maxNumHilos; i++) {
            hilosEnEjecucion.add(1);
            new Thread(new Runnable(){public void run() {
               for(int index=0; index<numPorHilo; index++) {
                  crecerPoblacion(numMejores);
               }
               hilosEnEjecucion.remove(0);
               hiloPadre.interrupt();
            }}).start();
      }
      while(hilosEnEjecucion.size()>0) {
         try {
            Thread.sleep(1000);
         } catch(Throwable e) {
            //nop
         }
      }

      calcularDistanciasCromosomas();
      ordenarPoblacion();

      //Remueve los peores cromosomas (excedentes)
      size=poblacion.size();
      while(size>tamanoPoblacion) {
         poblacion.remove(size-1);
         size--;
      }

      //crece el tamaño de la poblacion
      tamanoPoblacion=(int)(tamanoPoblacion*(1+tasaCrecimiento));
   }


   protected static void crecerPoblacion(int numMejores) {
      //aleatoreamente encuentra los padres
      int i1=rnd.nextInt(numMejores);
      int i2=rnd.nextInt(numMejores);
      if(i1==i2) {
         if(i2>0) { i2--; } else {i2++; }
      }

      //obtiene los hijos
      obtenerHijos(poblacion.get(i1),poblacion.get(i2));
   }


   protected static void obtenerHijos(Cromosoma padre1, Cromosoma padre2) {
      
      Nodo hijo1[]=padre1.getGenes().clone();
      Nodo hijo2[]=padre2.getGenes().clone();
      Nodo hijo3[]=casamiento(padre1, padre2);
      Nodo hijo4[]=casamiento(padre2, padre1);
      Nodo hijo5[]=hijo3.clone();
      Nodo hijo6[]=hijo4.clone();

      mutacion(hijo1);
      mutacion(hijo2);
      mutacion(hijo5);
      mutacion(hijo6);

      heuristico2opt(hijo1);
      heuristico2opt(hijo2);
      heuristico2opt(hijo3);
      heuristico2opt(hijo4);
      heuristico2opt(hijo5);
      heuristico2opt(hijo6);

      poblacion.add(new Cromosoma(hijo1));
      poblacion.add(new Cromosoma(hijo2));
      poblacion.add(new Cromosoma(hijo3));
      poblacion.add(new Cromosoma(hijo4));
      poblacion.add(new Cromosoma(hijo5));
      poblacion.add(new Cromosoma(hijo6));
   }


   private static void calcularDistanciasCromosomas()
   {
        for (Cromosoma cromosoma : poblacion)
            cromosoma.calcularDistanciaTotal();
   }

   
//Operadores

   protected static void mutacion(Nodo puntos[]) {
      if(rnd.nextInt(ratioMutacion)==0) {
         int i1=rnd.nextInt(puntos.length);
         int i2=rnd.nextInt(puntos.length);
         if(i1==i2) {
            if(i2>0) {
               i2--;
            } else {
               i2++;
            }
         }
         Nodo temp=puntos[i1];
         puntos[i1]=puntos[i2];
         puntos[i2]=temp;
      }
   }
   

    protected static Nodo[] casamiento(Cromosoma cromosoma1, Cromosoma cromosoma2) {

     Nodo[] c1=cromosoma1.getGenes();
     Nodo[] c2=cromosoma2.getGenes();

     int n = c1.length;

     LinkedList<Nodo> salida = new LinkedList<Nodo>();
     LinkedList<Nodo> noSeleccionado = new LinkedList<Nodo>();

     salida.add(c1[0]);
     for (int j = 1; j < n; j++) { 
       noSeleccionado.add(c1[j]);
     }

     while (noSeleccionado.size() > 1) {
       Nodo last = salida.getLast();
       Nodo n1 = encontrarSiguiente(c1, last);
       Nodo n2 = encontrarSiguiente(c2, last);

       Nodo seleccionado, otro;

       boolean seleccionado1;

       if (n1 == null) {
         seleccionado1 = false;
       }
       else if (n2 == null) {
         seleccionado1 = true;
       }
       else {
         seleccionado1 = last.distancia(n1) < last.distancia(n2);
       }

       if (seleccionado1) {
         seleccionado = n1;
         otro = n2;
       }
       else {
         seleccionado = n2;
         otro = n1;
       }

       if (salida.contains(seleccionado))
         seleccionado = otro;
       if (seleccionado == null || salida.contains(seleccionado)) {
         seleccionado = noSeleccionado.getFirst();
       }

       salida.add(seleccionado);
       noSeleccionado.remove(seleccionado);
     }

     salida.add(noSeleccionado.getLast());

     Nodo[] c = new Nodo[n];
     Iterator gi = salida.iterator();

     for (int i = 0; i < 0; i++) {
       c[i] = c1[i];
     }

     for (int i = 0; i < c.length; i++) {
       c[i] = (Nodo) gi.next();
     }

     return c;

   }


   protected static Nodo encontrarSiguiente(Nodo[] puntos, Nodo x) {
     for (int i = 0; i < puntos.length - 1; i++) {
       if (puntos[i].equals(x))
         return puntos[i + 1];
     }
     return puntos[0];
   }



   public static void heuristico2opt(Nodo[] puntos) {
       boolean hecho = false;
       int numPuntos = puntos.length;
       for(int k = 0; k < numPuntos && !hecho; k++)
       {
           hecho = true;
           for(int i = 0; i < numPuntos; i++)
           {
               for(int j = i + 2; j < numPuntos; j++)
                   if(
                      puntos[i].distancia(puntos[(i + 1) % numPuntos]) + puntos[j].distancia(puntos[(j + 1) % numPuntos])
                		   >
                   	  puntos[i].distancia(puntos[j]) + puntos[(i + 1) % numPuntos].distancia(puntos[(j + 1) % numPuntos])
                   )
                   {
                       Nodo tmp = puntos[(i + 1) % numPuntos];
                       puntos[(i + 1) % numPuntos] = puntos[j];
                       puntos[j] = tmp;
                       invertir(puntos, i + 2, j - 1);
                       hecho = false;
                   }
           }
       }
   }

   public static void invertir(Nodo[] puntos, int indiceInicial, int indiceFinal)
   {
       if(indiceInicial >= indiceFinal || indiceInicial >= puntos.length || indiceFinal < 0)
           return;
       for(; indiceInicial < indiceFinal; indiceFinal--)
       {
           Nodo tmp = puntos[indiceInicial];
           puntos[indiceInicial] = puntos[indiceFinal];
           puntos[indiceFinal] = tmp;
           indiceInicial++;
       }

   }


   private static boolean esObligatorio(int pos, Nodo[] arregloNodos, ArrayList<UbicacionBE> listaUbicaciones, Mapa mapa)
   {
        if ((arregloNodos[pos].getX()==mapa.getPosPuertaX())&&(arregloNodos[pos].getY()==mapa.getPosPuertaY())) return true;

        for (UbicacionBE u : listaUbicaciones)
        {
            RackBE rack=null;
            for (RackBE r : mapa.getListaRacks())
            {
                if (r.getIdRack().equals(u.getIdRack()))
                {
                    rack=r;
                    break;
                }
            }
            if (rack==null) return false;

            if (rack.getOrientacion().equals("V"))
            {
                if ((arregloNodos[pos].getX()==rack.getPosX())&&(arregloNodos[pos].getY()==rack.getPosY()+u.getColumna()-1)) return true;
                //Nodo nodo = new Nodo(id,rack.getPosX(),rack.getPosY()+ubicacion.getColumna()-1,ubicacion);
            }
            else
            {
                if ((arregloNodos[pos].getX()==rack.getPosX()+u.getColumna()-1)&&(arregloNodos[pos].getY()==rack.getPosY())) return true;
            }
        }
        
        return false;
   }


   public static Ruta obtenerRuta(Nodo nodoObligatorio1, Nodo nodoObligatorio2)
   {
       for (int i=0; i<rutas.size() ;i++)
       {
           for (int j=0; j<rutas.size() ;j++)
           {
                if (((rutas.get(i)).get(j).getProductoOrigen().getId()== nodoObligatorio1.getId())
                   && ((rutas.get(i)).get(j).getProductoDestino().getId()== nodoObligatorio2.getId()))
                        return (rutas.get(i)).get(j);
           }
       }
       return null;
   }


   private static ArrayList<Nodo> obtenerMejorRecorrido(Cromosoma mejorCromosoma)
   {
        ArrayList<Nodo> listaNodos = new ArrayList<Nodo>();
        
        Nodo mejoresNodos[]=mejorCromosoma.getGenes();
        for (int i=0;i<mejoresNodos.length-1;i++)
        {
           Nodo nodo1=mejoresNodos[i];
           Nodo nodo2=mejoresNodos[i+1];
           Ruta ruta = obtenerRuta(nodo1,nodo2);
           Nodo rutaOptima[] = ruta.getRutaOptima();

           for (int j=0;j<rutaOptima.length-1;j++)
           {
                Nodo punto1=rutaOptima[j];
                Nodo punto2=rutaOptima[j+1];
                listaNodos.add(punto1);
                listaNodos.add(punto2);
           }

        }

        Nodo nodo1=mejoresNodos[mejoresNodos.length-1];
        Nodo nodo2=mejoresNodos[0];
        Ruta ruta = obtenerRuta(nodo1,nodo2);
        Nodo rutaOptima[] = ruta.getRutaOptima();

        for (int j=0;j<rutaOptima.length-1;j++)
        {
            Nodo punto1=rutaOptima[j];
            Nodo punto2=rutaOptima[j+1];
            listaNodos.add(punto1);
            listaNodos.add(punto2);
        }

        
        return listaNodos;
   }


   private static ArrayList<Nodo> eliminarDuplicados(ArrayList<Nodo> listaNodos)
   {
       ArrayList<Nodo> listaNodosTemp = new ArrayList<Nodo>();
       
        for (Nodo nodo1 : listaNodos)
        {
            boolean esta=false;

            for (Nodo nodo2 : listaNodosTemp)
            {   
                if ((nodo1.getX()==nodo2.getX()) && (nodo1.getY()==nodo2.getY()))
                {
                    esta=true;
                    break;
                }
            }

            if (!esta)
            {
                listaNodosTemp.add(nodo1);
            }
        }

        int id=0;
        for (Nodo nodo : listaNodosTemp)
        {
            nodo.setId(id);
            id++;
        }

        return listaNodosTemp;
   }

   private static ArrayList<Nodo> eliminarDuplicadosObligatorios(ArrayList<Nodo> listaNodos)
   {
        HashSet hs = new HashSet();
        hs.addAll(listaNodos);
        listaNodos.clear();
        listaNodos.addAll(hs);

        return listaNodos;
   }
   
   public static ArrayList<Nodo> convertirANodoDePaso(ArrayList<Nodo> listaNodos,ArrayList<Nodo> nodosObligatorios)
   {
        ArrayList<Nodo> temp = new ArrayList<Nodo>();

        for (int i=0; i<nodosObligatorios.size(); i++)
        {
            Nodo nodo = nodosObligatorios.get(i);
            if (!nodo.isNodoInicial())
            {
                Nodo mejorVecino = mejorVecino(nodo, listaNodos, nodosObligatorios);
                if (mejorVecino != null)
                {
                    temp.add(mejorVecino);
                }
            }
        }

        temp = eliminarDuplicadosObligatorios(temp);
        return temp;
   }


   public static Nodo mejorVecino(Nodo nodo, ArrayList<Nodo> listaNodos, ArrayList<Nodo> nodosObligatorios)
   {
       ArrayList<Nodo> vecinos=new ArrayList<Nodo>();

       for (Nodo n : listaNodos)
       {
            if ((
                (n.getX()-1==nodo.getX() && n.getY()==nodo.getY()) ||
                (n.getX()+1==nodo.getX() && n.getY()==nodo.getY()) ||
                (n.getX()==nodo.getX() && n.getY()+1==nodo.getY()) ||
                (n.getX()==nodo.getX() && n.getY()-1==nodo.getY())
               ) && (n.getItem()==null) /*&& !estaEnNodosObligatorios(n,nodosObligatorios)*/)
            {
                vecinos.add(n);
            }
       }

       if (vecinos.isEmpty()) return null;

       Collections.sort(vecinos,new Comparator<Nodo>() {
       public int compare(Nodo u1, Nodo u2) {
           double distancia1 = distanciaALaPuerta(u1);
           double distancia2 = distanciaALaPuerta(u2);
           return (distancia1<distancia2 ? -1 : (distancia1>distancia2?1 : 0));
        }
       });
       
       return vecinos.get(0);
   }


    private static double distanciaALaPuerta(Nodo u)
    {
        double dx;
        double dy;

        dx= puertaPosX - u.getX();
        dy= puertaPosY - u.getY();

        double distanciaALaPuerta=Math.sqrt(dx * dx + dy * dy);
        return distanciaALaPuerta;
    }


    private static boolean estaEnNodosObligatorios(Nodo nodo, ArrayList<Nodo> nodosObligatorios)
    {
        for (Nodo n : nodosObligatorios)
        {
            if (nodo.getId()==n.getId())
            {
                return true;
            }
        }
        return false;
    }




//Aplicacion
//Recibe una lista de puntos obligatorios de tipo ArrayList UbicacionBE (primer piso) y obtiene el recorrido optimo
  public static ArrayList<Nodo> ejecutar(Mapa mapa, ArrayList<UbicacionBE> listaUbicaciones) {
      try {

         generacion=0;
         
         rutas = new ArrayList<ArrayList<Ruta>>();

         ArrayList<Nodo> listaNodos = eliminarDuplicados(mapa.getListaNodos());
         
         int posInicial=0;
         Nodo[] arregloNodos = new Nodo[listaNodos.size()];
         for (int i=0;i<listaNodos.size();i++)
         {
            arregloNodos[i]=listaNodos.get(i);

            if (arregloNodos[i].isNodoInicial())
            {
                posInicial = i;
                puertaPosX=arregloNodos[i].getX();
                puertaPosY=arregloNodos[i].getY();
            }
         }
         
         
         Ruta.llenarMatrizAdy(arregloNodos);
         
         ArrayList<Nodo> nodosObligatorios = new ArrayList<Nodo>();
         for (int i=0; i<arregloNodos.length; i++)
         {
            if (esObligatorio(i,arregloNodos,listaUbicaciones,mapa))
            {
                nodosObligatorios.add(arregloNodos[i]);
            }
         }         

         nodosObligatorios = convertirANodoDePaso(listaNodos,nodosObligatorios);
         nodosObligatorios.add(arregloNodos[posInicial]);

         for (Nodo n1 : nodosObligatorios)
         {
            ArrayList<Ruta> temp = new ArrayList<Ruta>();
            for (Nodo n2 : nodosObligatorios)
            {
                    Ruta r = new Ruta(n1,n2,arregloNodos);
                    temp.add(r);
            }
            rutas.add(temp);            
         }

         arregloNodos = new Nodo[nodosObligatorios.size()];
         for (int i=0;i<nodosObligatorios.size();i++)
         {
            arregloNodos[i]=nodosObligatorios.get(i);
         }
         
         nodos = arregloNodos;
 
//         tiempoInicio=System.currentTimeMillis();
         inicializar(nodos);

         edadMejorDistancia=0;

         double distanciaAnterior=0;
         mejorDistancia=0;
         

         //Empieza la evolucion. Finaliza cuando se cumple alguna de las condiciones de parada.
         while(!flagFin) {

            mejorCromosoma=obtenerMejorCromosoma();
            mejorDistancia=mejorCromosoma.getDistanciaTotal();

            if(distanciaAnterior==mejorDistancia) {
               edadMejorDistancia++;
            } else {
               edadMejorDistancia=0;
            }

            if(edadMejorDistancia>=maxEdadMejorDistancia) {
               flagFin=true;
            }
            
            distanciaAnterior=mejorDistancia;

            if(generacion+1>=maxNumGeneraciones) {
               flagFin=true;
            }

            siguienteGeneracion();

            generacion++;
         } 

//         tiempoEjecucion=System.currentTimeMillis()-tiempoInicio;
//         flagInicio=false;

         Cromosoma c = obtenerMejorCromosoma();
         ArrayList<Nodo> mejorRecorrido = obtenerMejorRecorrido(c);

         rutas.clear();
         poblacion.clear();
         nodos=null;

         return mejorRecorrido;


      } catch(Throwable e) {
         return null;
      }
   }


}
