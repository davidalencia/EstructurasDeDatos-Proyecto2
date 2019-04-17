package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.ArbolBinarioCompleto;

public class ArbolBinarioCompletoSVG<T extends Comparable<T>>
    extends ArbolBinarioCompleto<T>  implements toSVG<T> {

  public String toSVG(){
    return ArbolBinarioSVG.toSVG(raiz, elementos);
  }
}
