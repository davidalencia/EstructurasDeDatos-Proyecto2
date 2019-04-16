package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.Coleccion;

public interface toSVG<T> extends Coleccion<T> {
  public String toSVG();
}
