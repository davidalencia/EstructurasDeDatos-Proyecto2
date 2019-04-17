package mx.unam.ciencias.edd.proyecto2.svg;

public class DobleFlecha extends SVG {

  private boolean cabezera;

  //marker-end="url(#end-arrow)" marker-start="url(#start-arrow)"
  public DobleFlecha(String x1, String y1, String x2, String y2, String stroke){
    super("line");
    cabezera = true;
    setAtributo("x1", x1);
    setAtributo("y1", y1);
    setAtributo("x2", x2);
    setAtributo("y2", y2);
    setAtributo("stroke", stroke);
    setAtributo("marker-end", "url(#end-arrow)");
    setAtributo("marker-start", "url(#start-arrow)");
  }
  public DobleFlecha(Integer x1, Integer y1, Integer x2, Integer y2, String stroke){
    super("line");
    cabezera = true;
    setAtributo("x1", x1.toString());
    setAtributo("y1", y1.toString());
    setAtributo("x2", x2.toString());
    setAtributo("y2", y2.toString());
    setAtributo("stroke", stroke);
    setAtributo("marker-end", "url(#end-arrow)");
    setAtributo("marker-start", "url(#start-arrow)");
  }
  public DobleFlecha(String x1, String y1, String x2, String y2){
    super("line");
    cabezera = true;
    setAtributo("x1", x1);
    setAtributo("y1", y1);
    setAtributo("x2", x2);
    setAtributo("y2", y2);
    setAtributo("stroke", "black");
    setAtributo("marker-end", "url(#end-arrow)");
    setAtributo("marker-start", "url(#start-arrow)");
  }
  public DobleFlecha(Integer x1, Integer y1, Integer x2, Integer y2){
    super("line");
    cabezera = true;
    setAtributo("x1", x1.toString());
    setAtributo("y1", y1.toString());
    setAtributo("x2", x2.toString());
    setAtributo("y2", y2.toString());
    setAtributo("stroke", "black");
    setAtributo("marker-end", "url(#end-arrow)");
    setAtributo("marker-start", "url(#start-arrow)");
  }

  public static SVG headers(){
    SVG r = new SVG("defs");
    String s = "<marker id='end-arrow' markerWidth='10' markerHeight='10' refX='0' refY='5' orient='auto' markerUnits='strokeWidth'>\n"+
      "<path d='M0,0 L0,10 L5,5 z' fill='black' />\n"+
      "</marker>\n"+
      "<marker id='start-arrow' markerWidth='10' markerHeight='10' refX='0' refY='5' orient='auto' markerUnits='strokeWidth'>\n"+
      "<path d='M5,0 L5,10 L0,5 z' fill='black' />\n"+
      "</marker>\n";
    r.setContenido(s);
    return r;
  }
  public void setCabezera(boolean cabezera){
    this.cabezera = cabezera;
  }
  @Override public String toString(){
    String s ="";
    if(cabezera){
      s = "<defs>\n"+
      "<marker id='end-arrow' markerWidth='10' markerHeight='10' refX='0' refY='5' orient='auto' markerUnits='strokeWidth'>\n"+
        "<path d='M0,0 L0,10 L5,5 z' fill='black' />\n"+
        "</marker>\n"+
        "<marker id='start-arrow' markerWidth='10' markerHeight='10' refX='0' refY='5' orient='auto' markerUnits='strokeWidth'>\n"+
        "<path d='M5,0 L5,10 L0,5 z' fill='black' />\n"+
        "</marker>\n"+
      "</defs>\n";
    }
    s += super.toString();
    return s;
  }
}
