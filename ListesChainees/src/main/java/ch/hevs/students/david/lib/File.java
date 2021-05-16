package ch.hevs.students.david.lib;

public class File {

    private int longueur;
    private Noeud premier;
    private Noeud dernier;

    //constructeur
    public File() {
        longueur = 0;
        premier = null;
        dernier = null;
    }

    public File(int[] valeurs) {
        for (Integer i :
                valeurs) {
            Noeud n = new Noeud(new Info(i));
            enfile(n);
        }
    }

    // getteurs
    public int getLongueur() {
        return longueur;
    }

    public Noeud getPremier() {
        return premier;
    }

    public Noeud getDernier() {
        return dernier;
    }

    // setteurs
    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public void setPremier(Noeud premier) {
        this.premier = premier;
    }

    public void setDernier(Noeud dernier) {
        this.dernier = dernier;
    }

    // méthodes

    public boolean estVide() {
        return (longueur == 0);
    }

    public void enfile(Noeud nouveau) {
        if (estVide())
            premier = nouveau;
        else
            dernier.setSuivant(nouveau);

        dernier = nouveau;

        ++longueur;
    }

    public Noeud defile() {
        if (longueur == 0)
            return null;

        Noeud debut = premier;
        premier = premier.getSuivant();

        if (longueur == 1)
            dernier = null;
        else
            debut.setSuivant(null);

        --longueur;
        return debut;
    }

    public Noeud defileElement(int n) {
        if (n <= 0 || n > longueur)
            return null;

        File travail = new File();

        for (int i = 1; i < n; i++)
            travail.enfile(defile());

        Noeud retour = defile();

        travail.concat(this);
        concat(travail);
        return retour;
    }


    public void concat(File file2) {
        if (file2.estVide())
            return;

        if (estVide())
            premier = file2.getPremier();
        else
            dernier.setSuivant(file2.getPremier());

        dernier = file2.getDernier();
        longueur += file2.getLongueur();

        file2.setLongueur(0);
        file2.setPremier(null);
        file2.setDernier(null);
    }

    // échange de 2 noeuds référencés dans une file:
    // on échange les références des infos.
    public void echange(Noeud noeud1, Noeud noeud2) {
        Info temp = noeud1.getInfo();
        noeud1.setInfo(noeud2.getInfo());
        noeud2.setInfo(temp);
    }

    public void affiche() {
        Noeud courant = premier;

        while (courant != null) {
            //System.out.print(courant.getInfo().toString()+ " ");
            System.out.print(courant.getInfo().getValeur() + " ");
            courant = courant.getSuivant();
        }
        System.out.println();
    }

    public String toString() {
        String chaine = "";
        Noeud courant = premier;

        while (courant != null) {
            chaine += courant.getInfo().toString() + " ";
            courant = courant.getSuivant();
        }
        return chaine;
    }


    /************************************/

    // Exercice 2
    public void removeElement(/*File f,*/ int n) {
        Noeud courant = getPremier();
        int idx = 0;
        while (courant != null) {
            idx++;
            if (courant.getInfo().getValeur() == n) {
                defileElement(idx);
                break;
            }
            courant = courant.getSuivant();
        }
    }

    // Exercice 4
    // Ecrire une méthode qui étant donné deux files triées, les fusionne.
    public void fusionne(File f2) {
        File travail = new File();

        Noeud courant_f1 = getPremier();
        Noeud courant_f2 = f2.getPremier();

        while (courant_f1 != null || courant_f2 != null) {
            if (courant_f1.getInfo().getValeur() <= courant_f2.getInfo().getValeur()) {
                travail.enfile(courant_f1);
                courant_f1 = courant_f1.getSuivant();
            } else {
                travail.enfile(courant_f2);
                courant_f2 = courant_f2.getSuivant();
            }
        }
        if (courant_f2 != null) {
            travail.enfile(courant_f2);
        }
        setPremier(travail.getPremier());
        setDernier(travail.getDernier());
        setLongueur(travail.longueur);
    }


    public void radixSort() {
        File file[] = new File[10];

        for (int i = 0; i < 10; i++)
            file[i] = new File();

        int diviseur = 1;

        for (int pos = 0; pos < 3; pos++) {        // 3 passages nombres jusqu'à 999

            while (!estVide()) {
                Noeud noeud = defile();
                int chiffre = noeud.getInfo().getValeur() / diviseur % 10;
                file[chiffre].enfile(noeud);
            }

            for (int i = 0; i < 10; i++)
                concat(file[i]);

            diviseur *= 10;

            //affiche();
        }

    }

    public void inverse() {
        File travail = new File();
        for (int i = this.longueur; i > 0; i--) {
            travail.enfile(defileElement(i));
        }
        travail.concat(this);
        concat(travail);
    }

    public void inverseNicole() {
        if(longueur <= 1)
            return;
        Noeud temp = defile();
        inverseNicole();
        enfile(temp);
    }

    public void rechercheEtSupprimePremier(int recherche) {
        Noeud courant = getPremier();
        int idx = 0;
        while (courant != null) {
            idx++;
            if (courant.getInfo().getValeur() == recherche) {
                defileElement(idx);
                break;
            }
            courant = courant.getSuivant();
        }
    }

    public boolean contient(int recherche) {
        Noeud courant = getPremier();
        while (courant != null) {
            if (courant.getInfo().getValeur() == recherche) {
                return true;
            }
            courant = courant.getSuivant();
        }
        return false;
    }

    public void insereDansFileTriee(int aInserer) {
        Noeud courant = getPremier();
        File travail = new File();
        boolean insere = false;
        while (courant != null) {

            if(courant.getInfo().getValeur() < aInserer) {
               travail.enfile(courant);
               courant = courant.getSuivant();
           } else {
               travail.enfile(new Noeud(new Info(aInserer)));
               travail.enfile(courant);
               this.premier = travail.getPremier();
               insere = true;
               break;
           }
        }

        if(!insere) {
            enfile(new Noeud(new Info(aInserer)));
        }
    }
}
