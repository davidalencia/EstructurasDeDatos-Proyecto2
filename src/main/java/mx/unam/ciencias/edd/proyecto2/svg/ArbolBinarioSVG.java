package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.ArbolBinario;
import mx.unam.ciencias.edd.VerticeArbolBinario;

public abstract class ArbolBinarioSVG {

    final static int ALTO = 25;
    final static int ANCHO = 20;
    final static int RADIO = 16;
    final static int Y0 = ALTO*2;
    static int ancho_total = 0;

    public static String toSVG(VerticeArbolBinario raiz, int elementos){
      return toSVG(raiz, elementos, (c, v)->c, (t, v)->t);
    }

    public static String toSVG(VerticeArbolBinario raiz,
                               int elementos,
                               ModificaSVG modificaCirculo,
                               ModificaSVG modificaTexto){
      if(raiz==null)
        return "";
      int elementosPB =(int) Math.pow(2, raiz.altura());
      ancho_total = elementosPB*RADIO*3;
      SVG svg = new SVG("svg");
      SVG g = new SVG("g");
      int x0 = ancho_total/2;
      toSVG(g, raiz, x0, modificaCirculo, modificaTexto);
      svg.agregaSVG(g);
      svg.setAtributo("width", ""+ancho_total);
      svg.setAtributo("height", ""+(2*Y0+(raiz.altura()+1)*(ALTO+RADIO)));
      return svg.toString();
    }
    private static void toSVG(SVG svg,
                              VerticeArbolBinario v,
                              int x,
                              ModificaSVG modificaCirculo,
                              ModificaSVG modificaTexto){
      int y = Y0+v.profundidad()*ALTO*2;
      Circulo c = new Circulo(x,y, RADIO);
      c.setAtributo("stroke", "black");
      c.setAtributo("fill", "white");
      svg.agregaSVG(modificaCirculo.modifica(c, v));
      Texto t = new Texto(x-RADIO/2, y+5, v.get().toString());
      svg.agregaSVG(modificaTexto.modifica(t, v));
      int deltaX = (int) Math.floor(ancho_total/Math.pow(2, v.profundidad()+1))/2;
      int yHijos = Y0+ALTO*(v.profundidad()+1)*2-RADIO;
      if(v.hayIzquierdo()){
        int xIzq = x-deltaX;
        svg.agregaSVG(new Linea(x, y+RADIO, xIzq, yHijos));
        toSVG(svg, v.izquierdo(), xIzq, modificaCirculo, modificaTexto);
      }
      if(v.hayDerecho()){
        int xDer = x+deltaX;
        svg.agregaSVG(new Linea(x, y+RADIO, xDer, yHijos));
        toSVG(svg, v.derecho(), xDer, modificaCirculo, modificaTexto);
      }
    }
}
