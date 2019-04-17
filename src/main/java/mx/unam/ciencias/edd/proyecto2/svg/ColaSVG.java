package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.Cola;
import java.util.Iterator;

public class ColaSVG<T> extends Cola<T> implements toSVG<T> {


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
    contiene(n.siguiente, e);
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
    final Integer ancho = 35;
    final Integer alto = 35;
    SVG svg = new SVG("svg");
    svg.setAtributo("width", ""+(x0+getElementos()*(ancho)+1));
    SVG g = new SVG("g");
    Nodo n = cabeza;
    Integer alfa = 0;
    while(n!=null){
      Integer x = x0+alfa*ancho;
      Cuadrado c = new Cuadrado(x, y0, ancho, alto);
      c.setAtributo("fill", "white");
      c.setAtributo("stroke", "black");
      Texto t = new Texto(x+ancho/3, y0+alto*2/3, n.elemento.toString());
      g.agregaSVG(c);
      g.agregaSVG(t);
      n = n.siguiente;
      alfa++;
    }

    svg.agregaSVG(g);
    return svg.toString();
  }
}
