package mx.unam.ciencias.edd.proyecto2.svg;

public class Texto extends SVG {

  //<text font-family='sans-serif' x='10' y='45'>1a</text>
  public Texto(String x, String y, String texto){
    super("text");
    setAtributo("x", x);
    setAtributo("y", y);
    setContenido(texto);
  }
  public Texto(Integer x, Integer y, String texto){
    this(x.toString(), y.toString(), texto);
  }

}
