package mx.unam.ciencias.edd.proyecto2.svg;

public class DobleFlecha extends SVG {

  public DobleFlecha(String x1, String y1, String x2, String y2, String stroke){
    super("line");
    setAtributo("x1", x1);
    setAtributo("y1", y1);
    setAtributo("x2", x2);
    setAtributo("y2", y2);
    setAtributo("stoke", stroke);
  }
  public DobleFlecha(Integer x1, Integer y1, Integer x2, Integer y2, String stroke){
    super("line");
    setAtributo("x1", x1.toString());
    setAtributo("y1", y1.toString());
    setAtributo("x2", x2.toString());
    setAtributo("y2", y2.toString());
    setAtributo("stoke", stroke);
  }
  @Override public String toString(){
    String s = "<defs>\n"+
      "<marker id='end-arrow' markerWidth='10' markerHeight='10' refX='0' refY='3' orient='auto' markerUnits='strokeWidth'>\n"+
        "<path d='M0,1 L0,5 L3,3 z' fill='black' />\n"+
      "</marker>\n"+
      "<marker id='start-arrow' markerWidth='10' markerHeight='10' refX='0' refY='3' orient='auto' markerUnits='strokeWidth'>\n"+
        "<path d='M3,1 L3,5 L0,3 z' fill='black' />\n"+
      "</marker>\n"+
    "</defs>\n";
    s += super.toString();
    return s;
  }
}
