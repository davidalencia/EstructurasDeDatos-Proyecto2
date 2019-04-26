package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.MonticuloMinimo;
import mx.unam.ciencias.edd.Coleccion;
import mx.unam.ciencias.edd.ComparableIndexable;
import mx.unam.ciencias.edd.VerticeArbolBinario;

public class MonticuloMinimoSVG<T extends ComparableIndexable<T>>
  extends MonticuloMinimo<T> implements toSVG{

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

  static Integer x0 = 20;
  static Integer y0 = 20;
  static Integer ancho = 30;
  static Integer alto = 30;

  private T superget(int i){
    return get(i);
  }

  public MonticuloMinimoSVG(Coleccion<T> c){
    super(c);
  }

  public String toSVG(){
    SVG svg  = ArbolBinarioSVG.toSVG(new VerticeArreglo(0), getElementos());
    Integer h;
    Atributo altura = svg.getAtributo("height");
    try{
      h = Integer.parseInt(altura.getValor());
      y0 = h;
      h += 100;
      altura.setValor(h.toString());
    }catch (Exception e) {}
    svg.setAtributo(altura);

    SVG g = new SVG("g");
    int alfa = 0;
    for (T e: this) {
      VerticeArreglo v = new VerticeArreglo(alfa);
      String color = (alfa%2==0)? "black": "red";
      int x1 =x0+ancho*alfa+ancho*2/3, y1 = y0+ancho;
      if(v.hayDerecho()){
        SVG f = flecha(
            x1,  //x1
            y1,  //y1
            x1, //CurvaX
            y0+ancho*5,  //CurvaY
            x0+(2*alfa+2)*ancho+ancho/3, //x2
            y0+ancho); //y2
        f.setAtributo("stroke", color);
        g.agregaSVG(f);
      }
      if(v.hayIzquierdo()){
        SVG f =flecha(
            x1,  //x1
            y1,  //y1
            x1, //CurvaX
            y0+ancho*5,  //CurvaY
            x0+(2*alfa+1)*ancho+ancho/3, //x2
            y0+ancho); //y2
        f.setAtributo("stroke", color);
        g.agregaSVG(f);
      }
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

  private SVG flecha(int x1, int y1, int curvaX, int curvaY, int x2, int y2){
    SVG flecha = new SVG("path");
    flecha.setAtributo("fill", "none");
    flecha.setAtributo("d",
                       String.format("M%d,%d Q%d,%d %d,%d, l-3,0 l3-3, l3,3 l-3,0",
                                     x1, y1,curvaX, curvaY, x2, y2+4));
    return flecha;
  }
}
