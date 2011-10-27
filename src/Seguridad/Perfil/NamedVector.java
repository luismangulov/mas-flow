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

  public NamedVector(String name) {
    this.name = name;
  }

  public NamedVector(String name, Object elements[]) {
    this.name = name;
    for (int i = 0, n = elements.length; i < n; i++) {
      add(elements[i]);
    }
  }

  public String toString() {
    return "[" + name + "]";
  }
}
