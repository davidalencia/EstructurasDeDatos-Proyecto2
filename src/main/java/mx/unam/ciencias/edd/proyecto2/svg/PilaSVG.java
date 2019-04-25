package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.Pila;
import mx.unam.ciencias.edd.Coleccion;
import java.util.Iterator;

public class PilaSVG<T> extends Pila<T> implements toSVG{

  public PilaSVG(Coleccion<T> c){
    for (T e: c)
      mete(e);
  }
  public int getElementos(){
    return getElementos(cabeza, 0);
  }
  private int getElementos(Nodo n, int omega){
    if(n==null)
      return omega;
    return getElementos(n.siguiente, ++omega);
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
