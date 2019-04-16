package mx.unam.ciencias.edd.proyecto2.svg;

public class Circulo extends SVG {

  //<circle cx='100' cy='40' r='20'/>
  public Circulo(String cx, String cy, String r){
    super("circle");
    setAtributo("cx", cx);
    setAtributo("cy", cy);
    setAtributo("r", r);
  }
  public Circulo(Integer cx, Integer cy, Integer r){
    super("circle");
    setAtributo("cx", cx.toString());
    setAtributo("cy", cy.toString());
    setAtributo("r", r.toString());
  }
}
