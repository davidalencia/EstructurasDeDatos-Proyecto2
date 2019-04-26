package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.MonticuloArreglo;
import mx.unam.ciencias.edd.Coleccion;
import mx.unam.ciencias.edd.ComparableIndexable;
import mx.unam.ciencias.edd.ValorIndexable;
import mx.unam.ciencias.edd.VerticeArbolBinario;
import java.util.Iterator;

public class MonticuloArregloSVG<T extends ComparableIndexable<T>>
  extends MonticuloArreglo<T> implements toSVG{

  public MonticuloArregloSVG(Coleccion c){
    super(c);
  }

  public String toSVG(){
    Integer x0 = 20;
    Integer y0 = 20;
    Integer ancho = 30;
    Integer alto = 30;
    SVG svg = new SVG("svg");
    SVG g = new SVG("g");
    int alfa = 0;
    while(!esVacia()){
      T e = elimina();
      Cuadrado c = new Cuadrado(x0+ancho*alfa, y0, ancho, alto);
      c.setAtributo("fill", "white");
      c.setAtributo("stroke", "black");
      String s = e.toString().split(":")[0];
      Texto t = new Texto(x0+ancho*alfa+ancho/3, y0+ancho*2/3, s);
      g.agregaSVG(c);
      g.agregaSVG(t);
      alfa++;
    }
    svg.setAtributo("width", ""+((getElementos()+2)*ancho));
    svg.agregaSVG(g);
    return svg.toString();
  }
}
