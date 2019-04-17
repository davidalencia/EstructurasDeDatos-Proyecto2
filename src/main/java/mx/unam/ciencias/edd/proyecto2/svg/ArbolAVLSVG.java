package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.ArbolAVL;

public class ArbolAVLSVG<T extends Comparable<T>>
    extends ArbolAVL<T>  implements toSVG<T> {

  public String toSVG(){
    return ArbolBinarioSVG.toSVG(raiz, elementos, (c, v)->c, (t, v)->{
      SVG g = new SVG("g");
      g.agregaSVG(t);
      try {
        VerticeAVL vavl = (VerticeAVL) v;
        Integer h = vavl.altura();
        Integer hIzq = -1, hDer = -1;
        if(vavl.hayIzquierdo())
          hIzq = vavl.izquierdo.altura();
        if (vavl.hayDerecho())
          hDer = vavl.derecho.altura();
        Integer balance = hIzq-hDer;
        Integer x = Integer.parseInt(t.getAtributo("x").getValor())+25;
        Integer y = Integer.parseInt(t.getAtributo("y").getValor())-10;
        SVG info = new Texto(x, y, h+"/"+balance);
        info.setAtributo("font-size", "8");
        g.agregaSVG(info);
      } catch(Exception e) {}
      return g;
    });
  }
}
