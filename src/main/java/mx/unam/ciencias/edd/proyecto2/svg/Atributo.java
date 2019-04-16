package mx.unam.ciencias.edd.proyecto2.svg;

public class Atributo {

  private String atributo;
  private String valor;

  public Atributo(String atributo, String valor){
    this.atributo = atributo;
    this.valor = valor;
  }
  public Atributo(String atributo){
    this.atributo = atributo;
    this.valor = "";
  }

  /**
   * Regresa el valor de atributo
   * @return atributo
   */
  public String getAtributo(){
    return atributo;
  }
  /**
   * Regresa el valor de valor
   * @return valor
   */
  public String getValor(){
    return valor;
  }
  /**
   * Cambia el valor de valor
   * @return valor
   */
  public void setValor(String valor){
    this.valor = valor;
  }

  @Override public boolean equals(Object o){
    if(!(o instanceof Atributo))
      return false;
    Atributo a = (Atributo) o;
    return atributo.equals(a.atributo);
  }


}
