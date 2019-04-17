package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.Lista;
import java.util.Iterator;


public class ListaSVG<T> extends Lista<T> implements toSVG<T> {

  public String toSVG(){
    final Integer x0 = 20;
    final Integer y0 = 20;
    final Integer ancho = 35;
    final Integer alto = 35;
    final Integer largoFlecha = 45;

    SVG svg = new SVG("svg");
    svg.setAtributo("width", ""+(x0+getElementos()*(ancho+largoFlecha)+1));
    SVG g = new SVG("g");
    g.agregaSVG(DobleFlecha.headers());
    Integer alfa = 0;
    Iterator i = iterator();
    while(i.hasNext()){
      T e = (T) i.next();
      Integer x = x0+alfa*(ancho+largoFlecha);
      Cuadrado c = new Cuadrado(x, y0, ancho, alto);
      c.setAtributo("fill", "white");
      c.setAtributo("stroke", "black");
      Texto t = new Texto(x+ancho/3, y0+alto*2/3, e.toString());
      g.agregaSVG(c);
      g.agregaSVG(t);

      if(i.hasNext()){
        DobleFlecha flecha = new DobleFlecha(x+ancho+2,
        y0+alto/2,
        x+ancho+largoFlecha-7,
        y0+alto/2);
        flecha.setCabezera(false);
        g.agregaSVG(flecha);
      }
      alfa++;
    }
    svg.agregaSVG(g);
    return svg.toString();
  }

}
