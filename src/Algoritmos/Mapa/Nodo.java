/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Algoritmos.Mapa;

/**
 *
 * @author carlitos
 */
public class Nodo {

   protected int x;

   protected int y;

   protected int id;

   protected boolean nodoInicial=false;

   protected Object item;
   
   public Nodo(int id, int x, int y, Object item) {
    this.id=id;
    this.x=x;
    this.y=y;
    this.item = item;
   }

   public double distancia(Nodo otroNodo) {
    return distancia(otroNodo.getX(), otroNodo.getY());
   }

   protected double distancia(int pX, int pY) {
    double dx=this.x - pX;
    double dy=this.y - pY;
    double distancia=Math.sqrt(dx * dx + dy * dy);
    return distancia;
   }

   public int getX() {
      return x;
   }

   public int getY() {
      return y;
   }
   
   public Object getItem() {
      return item;
   }

   @Override
   public boolean equals(Object obj) {
      if(obj==null) return false;
      if(obj==this) return true;
      if(!(obj instanceof Nodo)) return false;
      return ((Nodo)obj).id==this.id;
   }

   public int getId() {
      return id;
   }

}
