package mx.unam.ciencias.edd.proyecto2.svg;

import mx.unam.ciencias.edd.Lista;

public class SVG {

  private String tipo;
  private Lista<Object> elementos;
  private Lista<Atributo> atributos;

  public SVG(String tipo){
    this.tipo = tipo;
    elementos = new Lista<Object>();
    atributos = new Lista<Atributo>();
  }
  public SVG(String tipo, String contenido){
    this.tipo = tipo;
    elementos = new Lista<Object>();
    elementos.agrega(contenido);
    atributos = new Lista<Atributo>();
  }

 /**
  * Regresa el valor de algun atributo
  */
 public Atributo getAtributo(String s){
   return getAtributo(new Atributo(s));
 }
 public Atributo getAtributo(Atributo otro){
   for (Atributo a: atributos)
     if(a.equals(otro))
      return a;
   return null;
 }
 /**
  * Cambia el valor de algun atributo
  */
 public void setAtributo(String attr, String val){
   setAtributo(new Atributo(attr, val));
 }
 public void setAtributo(Atributo nuevo){
    atributos.elimina(nuevo);
    atributos.agrega(nuevo);

 }

  /**
   * Regresa el valor de contenido
   * @return contenido
   */
  public String getContenido(){
    for (Object o: elementos)
      if(o instanceof String)
        return (String) o;
    return "";
  }
  /**
   * Cambia el valor de contenido
   * @return contenido
   */
  public void setContenido(String contenido){
    for (Object o: elementos)
      if(o instanceof String)
        elementos.elimina((String) o);
    elementos.agrega(contenido);
  }

  public void agregaSVG(SVG svg){
    elementos.agrega(svg);
  }

  @Override public String toString(){
    String s = "<"+tipo;
    for (Atributo attr: atributos)
      s+=String.format(" %s='%s'", attr.getAtributo(), attr.getValor());
    s+=">";
    for (Object ele: elementos)
      s+="\n"+ele.toString();
    s+="\n</"+tipo+">";
    return s;
  }
}
