package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.MonticuloMinimo;
import mx.unam.ciencias.edd.Coleccion;
import mx.unam.ciencias.edd.ComparableIndexable;
import mx.unam.ciencias.edd.ValorIndexable;
import mx.unam.ciencias.edd.VerticeArbolBinario;

public class MonticuloMinimoSVG<T extends ComparableIndexable<T>>
  extends MonticuloMinimo<T> implements toSVG<T>{

  private class VerticeArreglo implements VerticeArbolBinario<String> {
    Integer i;
    private VerticeArreglo(int i){
      this.i = i;
    }
    public boolean hayPadre(){
      return i!=0;
    }
    public boolean hayIzquierdo(){
      return 2*i+1< getElementos();
    }
    public boolean hayDerecho(){
      return 2*i+2< getElementos();
    }
    public VerticeArbolBinario<String> padre(){
      int padre = (i-1)/2;
      return new VerticeArreglo(padre);
    }
    public VerticeArbolBinario<String> izquierdo(){
      return new VerticeArreglo(2*i+1);
    }
    public VerticeArbolBinario<String> derecho(){
      return new VerticeArreglo(2*i+2);
    }
    public int altura(){
      return (int) (Math.log(getElementos()) / Math.log(2));
    }
    public int profundidad(){
      return (int) (Math.log(i+1) / Math.log(2));
    }
    public String get(){
      return superget(i).toString().split(":")[0];
    }
  }
  private T superget(int i){
    return get(i);
  }

  public MonticuloMinimoSVG(Coleccion<T> c){
    super(c);
  }

  public String toSVG(){
    return ArbolBinarioSVG.toSVG(new VerticeArreglo(0), getElementos());
  }
}
