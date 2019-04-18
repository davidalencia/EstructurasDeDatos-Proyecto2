package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.Cola;
import java.util.Iterator;
import mx.unam.ciencias.edd.Coleccion;

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

  public ColaSVG(Coleccion<T> c){
    for (T e: c)
      agrega(e);
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
    final Integer ancho = 35;
    final Integer alto = 35;
    final Integer anchoTotal = x0+getElementos()*ancho;
    SVG svg = new SVG("svg");
    svg.setAtributo("width", ""+(anchoTotal+ancho));
    SVG g = new SVG("g");
    svg.agregaSVG(new Linea(x0/2, y0, anchoTotal ,y0));
    svg.agregaSVG(new Linea(x0/2, y0+alto, anchoTotal, y0+alto));
    svg.agregaSVG(Flecha.headers());
    Flecha f1 = new Flecha(0, y0+alto/2, x0, y0+alto/2);
    Flecha f2 = new Flecha(anchoTotal-x0/2, y0+alto/2, anchoTotal+x0/2, y0+alto/2);
    f1.setCabezera(false);
    f2.setCabezera(false);
    svg.agregaSVG(f1);
    svg.agregaSVG(f2);
    Nodo n = cabeza;
    Integer alfa = 0;
    while(n!=null){
      Integer x = x0+alfa*ancho;
      Texto t = new Texto(x+ancho/3, y0+alto*2/3, n.elemento.toString());
      g.agregaSVG(t);
      n = n.siguiente;
      alfa++;
    }

    svg.agregaSVG(g);
    return svg.toString();
  }
}
