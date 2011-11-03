/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Algoritmos.RecorridoOptimo;

import Algoritmos.Mapa.Nodo;

/**
 *
 * @author carlitos
 */
public class Cromosoma {

   protected Nodo[] genes;

   protected double distanciaTotal;

   public Cromosoma(Nodo[] genes) {
      this.genes=genes.clone();
   }
   
   public void calcularDistanciaTotal() {

        distanciaTotal=0;
        double distanciaActual=0;

        Nodo mejoresNodos[]=ordenarCromosoma(this).getGenes();
        for (int i=0;i<mejoresNodos.length-1;i++)
        {
            Nodo nodo1=mejoresNodos[i];
            Nodo nodo2=mejoresNodos[i+1];
            Ruta ruta = AlgoritmoGenetico.obtenerRuta(nodo1,nodo2);
            distanciaActual = ruta.getDistanciaTotal();
            distanciaTotal+=distanciaActual;
        }

        Nodo nodo1=mejoresNodos[mejoresNodos.length-1];
        Nodo nodo2=mejoresNodos[0];
        Ruta ruta = AlgoritmoGenetico.obtenerRuta(nodo1,nodo2);
        distanciaActual = ruta.getDistanciaTotal();
        distanciaTotal+=distanciaActual;
       
   }
   

    public static Cromosoma ordenarCromosoma(final Cromosoma cromosoma)
    {
        int posPuerta=0;
        int numProductos = cromosoma.getGenes().length;

        //La puerta siempre tiene Id = 0
        for (int i=0;i<numProductos;i++)
            if (cromosoma.getGenes()[i].getId()==0)
            {
               posPuerta=i;
               break;
            }

        Cromosoma c = cromosoma;

        Nodo productos[]=new Nodo[numProductos];

        for(int i=posPuerta;i<numProductos;i++)
        {
            productos[i-posPuerta]=c.getGenes()[i];
        }

        for(int i=0;i<posPuerta;i++)
        {
            productos[numProductos-posPuerta+i]=c.getGenes()[i];
        }

        c.setGenes(productos);

        return c;
    }

   
   public double getDistanciaTotal() {
      return distanciaTotal;
   }


   public Nodo[] getGenes() {
      return genes;
   }

   public void setGenes(Nodo productos[]) {
      genes = productos;
   }

}
