package ch.hevs.students.david.lib;

public class Info {

  private int valeur ;

  public Info(int valeur)
  {
    this.valeur = valeur ;
  }

  //getteur

  public int getValeur()
  {
    return valeur ;
  }

  //setteur

  public void setValeur(int valeur)
  {
    this.valeur = valeur ;
  }

  public String toString()
  {
     return (valeur + " ") ;
  }
}
