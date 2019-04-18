package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.Grafica;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.Coleccion;
import mx.unam.ciencias.edd.VerticeGrafica;
import java.util.Iterator;


public class GraficaSVG<T> extends Grafica<T> implements toSVG<T> {
   class CirculoInformativo{
    private Integer radio, x, y;
    private T e;
    CirculoInformativo(int radio, int x, int y){
      this.radio = radio;
      this.x = x;
      this.y = y;
      e = null;
     }
     CirculoInformativo(int radio, int x, int y, T e){
       this.radio = radio;
       this.x = x;
       this.y = y;
       this.e = e;
      }
      @Override public boolean equals(Object o){
        try{
          CirculoInformativo c = (CirculoInformativo) o;
          return e.equals(c.e);
        }catch (Exception e) {
          return false;
        }
      }
  }

  public GraficaSVG(Coleccion<T> c){
    super();
    if(c.getElementos()%2!=0)
      throw new IllegalArgumentException();
    Iterator<T> i = c.iterator();
    while(i.hasNext()){
      T e1 = i.next();
      T e2 = i.next();
      if(!contiene(e1))
        agrega(e1);
      if(!contiene(e2))
        agrega(e2);
      if(!e1.equals(e2))
        conecta(e1, e2);
    }
  }

  public String toSVG(){
    final Integer RADIO = 16;
    final Double teta = 2*Math.PI/getElementos();
    CirculoInformativo granC = new CirculoInformativo(RADIO*getElementos()*3,
                                                      RADIO*(getElementos()*3+2),
                                                      RADIO*(getElementos()*3+2));
    SVG svg = new SVG("svg");
    svg.setAtributo("width", ""+(granC.radio*2+RADIO*4+1));
    svg.setAtributo("height", ""+(granC.radio*2+RADIO*4+1));
    SVG g = new SVG("g");
    Lista<CirculoInformativo> circulos = new Lista<>();
    Integer alfa = 0;
    for (T e: this) {
      Integer x = (int) Math.floor(granC.x-granC.radio*Math.cos(alfa*teta));
      Integer y = (int) Math.floor(granC.y-granC.radio*Math.sin(alfa*teta));
      Circulo c = new Circulo(x,y, RADIO);
      circulos.agrega(new CirculoInformativo(RADIO,x,y,e));
      c.setAtributo("stroke", "black");
      c.setAtributo("fill", "white");
      Texto t = new Texto(x-RADIO/2, y+5, e.toString());
      g.agregaSVG(c);
      g.agregaSVG(t);
      alfa++;
    }
    for (T e: this) {
      CirculoInformativo c = new CirculoInformativo(0,0,0, e);
      c = circulos.get(circulos.indiceDe(c));
      VerticeGrafica<T> v = vertice(e);
      for (VerticeGrafica<T> vecino: v.vecinos()) {
        CirculoInformativo circuloVecino = new CirculoInformativo(0,0,0, vecino.get());
        circuloVecino = circulos.get(circulos.indiceDe(circuloVecino));
        Double ca = (double) c.x-circuloVecino.x;
        Double co = (double) c.y-circuloVecino.y;
        Double hip = Math.sqrt(Math.pow(ca, 2)+Math.pow(co, 2));
        Integer x1 = (int) Math.floor(c.x -RADIO*(ca/hip));
        Integer y1 = (int) Math.floor(c.y -RADIO*(co/hip));
        Integer x2 = (int) Math.floor(circuloVecino.x +RADIO*(ca/hip));
        Integer y2 = (int) Math.floor(circuloVecino.y +RADIO*(co/hip));
        Linea l = new Linea( x1, y1, x2, y2);
        g.agregaSVG(l);
      }
    }
    svg.agregaSVG(g);
    return svg.toString();
  }
}
