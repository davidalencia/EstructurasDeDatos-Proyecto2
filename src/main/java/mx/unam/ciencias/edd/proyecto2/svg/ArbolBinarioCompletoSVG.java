package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.ArbolBinarioCompleto;
import mx.unam.ciencias.edd.Coleccion;

public class ArbolBinarioCompletoSVG<T extends Comparable<T>>
    extends ArbolBinarioCompleto<T>  implements toSVG<T> {

  public ArbolBinarioCompletoSVG(Coleccion<T> c){
    super(c);
  }

  public String toSVG(){
    return ArbolBinarioSVG.toSVG(raiz, elementos);
  }
}
