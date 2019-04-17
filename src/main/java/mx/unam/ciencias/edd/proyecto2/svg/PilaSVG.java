package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.Pila;
import java.util.Iterator;

public class PilaSVG<T> extends Pila<T> implements toSVG<T> {

  private class Iterador implements Iterator<T> {

      private Nodo n;

      /* Inicializa al iterador. */
      public Iterador() {
        n = cabeza;
      }

      /* Nos dice si hay un elemento siguiente. */
      @Override public boolean hasNext() {
          return n!=null && n.siguiente !=null;
      }

      /* Regresa el siguiente elemento en orden BFS. */
      @Override public T next() {
          n = n.siguiente;
          return n.elemento;
      }
  }

}
