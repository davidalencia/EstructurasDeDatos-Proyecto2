package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.Cola;
import java.util.Iterator;
import mx.unam.ciencias.edd.Coleccion;

public class ColaSVG<T> extends Cola<T> implements toSVG {

  public ColaSVG(Coleccion<T> c){
    for (T e: c)
      mete(e);
  }

  public int getElementos(){
    return getElementos(cabeza, 0);
  }
  private int getElementos(Nodo n, int omega){
    return (n==null)? omega: getElementos(n.siguiente, ++omega);
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
