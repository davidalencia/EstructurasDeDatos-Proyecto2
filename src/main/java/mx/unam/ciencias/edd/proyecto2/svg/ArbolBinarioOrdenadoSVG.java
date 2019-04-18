package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.ArbolBinarioOrdenado;
import mx.unam.ciencias.edd.Coleccion;

public class ArbolBinarioOrdenadoSVG<T extends Comparable<T>>
    extends ArbolBinarioOrdenado<T>  implements toSVG<T> {

  public ArbolBinarioOrdenadoSVG(Coleccion<T> c){
    super(c);
  }
  public String toSVG(){
    return ArbolBinarioSVG.toSVG(raiz, elementos);
  }
}
