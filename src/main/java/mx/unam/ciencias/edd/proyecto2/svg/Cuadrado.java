package mx.unam.ciencias.edd.proyecto2.svg;

public class Cuadrado extends SVG {

  //<rect x="50" y="50" width="200" height="100""/>
  public Cuadrado(String x, String y, String width, String height){
    super("rect");
    setAtributo("width", width);
    setAtributo("height", height);
    setAtributo("x", x);
    setAtributo("y", y);
  }
  public Cuadrado(Integer x,Integer y,Integer width,Integer height){
    super("rect");
    setAtributo("width", width.toString());
    setAtributo("height", height.toString());
    setAtributo("x", x.toString());
    setAtributo("y", y.toString());
  }

}
