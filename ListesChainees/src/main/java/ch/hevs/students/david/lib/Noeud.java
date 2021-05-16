package ch.hevs.students.david.lib;

public class Noeud
    {
    private Info info ;
    private Noeud suivant ;

    // constructeurs
    public Noeud()
        {
        info = null ;
        suivant = null ;
        }

    public Noeud(Noeud n)
        {
        info = n.info ;
        suivant = n.suivant ;
        }



    public Noeud(Info info)
        {
        this.info = info ;
        suivant = null ;
        }

  // getteurs

    public Noeud getSuivant()
        {
        return suivant ;
        }

    public Info getInfo()
        {
        return info ;
        }

    // setteurs

    public void setSuivant(Noeud nouveau)
        {
        suivant = nouveau ;
        }

    //utile lors d'�changes de noeuds, donc d'infos
    public void setInfo(Info nouveau)
        {
        info = nouveau ;
        }
    }
