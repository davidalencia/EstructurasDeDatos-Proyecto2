package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.ArbolBinarioOrdenado;

public class ArbolBinarioOrdenadoSVG<T extends Comparable<T>>
    extends ArbolBinarioOrdenado<T>  implements toSVG<T> {

  public String toSVG(){
    return ArbolBinarioSVG.toSVG(raiz, elementos);
  }
}
