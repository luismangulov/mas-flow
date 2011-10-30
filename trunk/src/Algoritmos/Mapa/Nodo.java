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

   private int x;

   private int y;

   private int id;

   private boolean nodoInicial=false;

   private Object item;
   
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

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param nodoInicial the nodoInicial to set
     */
    public void setNodoInicial(boolean nodoInicial) {
        this.nodoInicial = nodoInicial;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Object item) {
        this.item = item;
    }

    /**
     * @return the nodoInicial
     */
    public boolean isNodoInicial() {
        return nodoInicial;
    }

}
