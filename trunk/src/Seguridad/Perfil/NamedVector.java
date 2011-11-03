/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Perfil;

import java.util.Vector;

/**
 *
 * @author Florencio
 */
public class NamedVector extends Vector {
    
    String name;
    boolean selected;

  public NamedVector(String name) {
    this.name = name;
  }
  
  public NamedVector(String text, boolean selected) {
    this.name = text;
    this.selected = selected;
  }

  public NamedVector(String name, Object elements[]) {
    this.name = name;
    for (int i = 0, n = elements.length; i < n; i++) {
      add(elements[i]);
    }
  }

  public String toString() {
    //return "[" + name + "]";
      return name;
  }

  
  //agregado
    public int getElementCount() {
        return elementCount;
    }

    public void setElementCount(int elementCount) {
        this.elementCount = elementCount;
    }

  
  
}
