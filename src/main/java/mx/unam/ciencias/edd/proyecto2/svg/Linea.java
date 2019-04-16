package mx.unam.ciencias.edd.proyecto2.svg;

public class Linea extends SVG {

  //<line x1='100' y1='40' x2='160' y2='160' stroke='blue'/>
  public Linea(String x1, String y1, String x2, String y2, String stroke){
    super("line");
    setAtributo("x1", x1);
    setAtributo("y1", y1);
    setAtributo("x2", x2);
    setAtributo("y2", y2);
    setAtributo("stroke", stroke);
  }
  public Linea(Integer x1, Integer y1, Integer x2, Integer y2, String stroke){
    super("line");
    setAtributo("x1", x1.toString());
    setAtributo("y1", y1.toString());
    setAtributo("x2", x2.toString());
    setAtributo("y2", y2.toString());
    setAtributo("stroke", stroke);
  }
  public Linea(String x1, String y1, String x2, String y2){
    super("line");
    setAtributo("x1", x1);
    setAtributo("y1", y1);
    setAtributo("x2", x2);
    setAtributo("y2", y2);
    setAtributo("stroke", "black");
  }
  public Linea(Integer x1, Integer y1, Integer x2, Integer y2){
    super("line");
    setAtributo("x1", x1.toString());
    setAtributo("y1", y1.toString());
    setAtributo("x2", x2.toString());
    setAtributo("y2", y2.toString());
    setAtributo("stroke", "black");
  }
}
