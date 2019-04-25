package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.ArbolRojinegro;
import mx.unam.ciencias.edd.Coleccion;

public class ArbolRojinegroSVG<T extends Comparable<T>>
    extends ArbolRojinegro<T>  implements toSVG {

  public ArbolRojinegroSVG(Coleccion<T> c){
    super(c);
  }

  public String toSVG(){
    return ArbolBinarioSVG.toSVG(raiz, elementos, (c, v)->{
      try{
        VerticeRojinegro vr = (VerticeRojinegro) v;
        switch (vr.color) {
          case NEGRO:
            c.setAtributo("fill", "black");
            c.setAtributo("stroke", "black");
            break;
          case ROJO:
            c.setAtributo("fill", "red");
            c.setAtributo("stroke", "red");
            break;
          case NINGUNO:
            break;
        }
      }catch (Exception e) {}
      return c;
    }, (t, v)->{
      t.setAtributo("fill", "white");
      return t;
    }).toString();
  }
}
