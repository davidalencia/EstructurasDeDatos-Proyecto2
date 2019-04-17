package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.Pila;
import java.util.Iterator;

public class PilaSVG<T> extends Pila<T> implements toSVG<T> {

  private class Iterador implements Iterator<T> {

      private Nodo n;

      /* Inicializa al iterador. */
      public Iterador() {}

      /* Nos dice si hay un elemento siguiente. */
      @Override public boolean hasNext() {
          return esVacia();
      }

      /* Regresa el siguiente elemento en orden BFS. */
      @Override public T next() {
          return saca();
      }
  }

  @Override public void agrega(T elemento){
      mete(elemento);
  }
  @Override public void elimina(T elemento){
      if(elemento==null)
        return;
      elimina(null, cabeza, elemento);
  }
  private void elimina(Nodo anterior, Nodo n, T e){
    if(n==null)
      return;
    if(e.equals(n.elemento)){
      if(anterior==null)
        cabeza = n.siguiente;
      else
        anterior.siguiente = n.siguiente;
      if(anterior.siguiente==null);
        rabo=anterior;
      return;
    }
    elimina(n, n.siguiente, e);
  }
  @Override public boolean contiene(T elemento){
    if(elemento==null)
      return false;
    return contiene(cabeza, elemento);
  }
  private boolean contiene(Nodo n, T e){
    if(n==null)
      return false;
    return (e.equals(n.elemento))? true: contiene(n.siguiente, e);
  }
  @Override public int getElementos(){
    return getElementos(cabeza, 0);
  }
  private int getElementos(Nodo n, int omega){
    if(n==null)
      return omega;
    return getElementos(n.siguiente, ++omega);
  }
  @Override public void limpia(){
    cabeza = rabo = null;
  }
  @Override public Iterator iterator(){
    return new Iterador();
  }

  @Override public String toSVG(){
    final Integer x0 = 20;
    final Integer y0 = 20;
    final Integer alto = 25;
    final Integer ancho = 35;
    final Integer altoTotal = y0*3/2+alto*getElementos();

    SVG svg = new SVG("svg");
    svg.setAtributo("height", ""+(altoTotal+y0));
    SVG g = new SVG("g");
    g.agregaSVG(new Linea(x0, y0, x0, altoTotal));
    g.agregaSVG(new Linea(x0+ancho, y0, x0+ancho, altoTotal));
    g.agregaSVG(new Linea(x0, altoTotal, x0+ancho, altoTotal));

    Nodo n = cabeza;
    Integer alfa = 0;
    while(n!=null){
      Integer y = altoTotal-alto*alfa-alto/2;
      Texto t = new Texto(x0+ancho/3, y, n.elemento.toString());
      g.agregaSVG(t);
      n = n.siguiente;
      alfa++;
    }

    svg.agregaSVG(g);
    return svg.toString();
  }

}
