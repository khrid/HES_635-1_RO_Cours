package ch.hevs.students.david.lib;

public class Graphe {
    private final File[] liste;
    private int[] predecesseurs;

    public Graphe() {
        liste = new File[0];
    }

    public Graphe(int n) {
        liste = new File[n];
        for (int i = 0; i < n; i++)
            liste[i] = new File();
    }

    public Graphe(int matrice[][]) {
        int n = matrice.length;
        predecesseurs = new int[n];
        for (int i = 0; i < n; i++) {
            predecesseurs[i] = 0;
        }
        //affichePredecesseurs();

        liste = new File[n];
        for (int i = 0; i < n; i++) {
            liste[i] = new File();
        }

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                liste[i].enfile(new Noeud(new Info(matrice[i][j])));
            }
        }
    }

    public void afficheListe() {
        for (int i = 0; i < liste.length; i++) {
            System.out.print("file[" + i + "]: ");
            liste[i].affiche();
            //System.out.println();
        }
    }

    /**
     * Dans votre classe Graphe écrivez une méthode d’exploration récursive, respectant l’idée suivante :
     * Si le sommet est marqué on arrête.
     * Sinon, on le marque et on lance l’exploration depuis l’ensemble de ses successeurs.
     * On affichera les sommets au fur et à mesure du marquage
     */
    public void explorationRecursive(int sommet) {
        boolean[] sommetsVisites = new boolean[liste.length];
        _explorationRecursive(sommet, sommetsVisites);
    }

    public void _explorationRecursive(int sommet, boolean[] sommetsVisites) {
        // clause de finitude
        if(sommetsVisites[sommet])
            return;

        // pas récursif
        System.out.println("Marquage de : " + sommet);
        sommetsVisites[sommet] = true;

        while(liste[sommet].getPremier() != null) {
            Noeud current = liste[sommet].defile();

            if(predecesseurs[current.getInfo().getValeur()] == 0) {
                predecesseurs[current.getInfo().getValeur()] = sommet;
            }

            _explorationRecursive(current.getInfo().getValeur(), sommetsVisites);
        }
    }

    public void explorationFile(int depart) {
        boolean[] sommetsVisites = new boolean[liste.length];
        File f = new File();
        f.enfile(new Noeud(new Info(depart)));

        while (!f.estVide()) {
            int sommet = f.defile().getInfo().getValeur();
            sommetsVisites[sommet] = true;
            System.out.println("Marquage de : " + sommet);

            Noeud courant = liste[sommet].getPremier();
            while (courant != null) {
                int suivant = courant.getInfo().getValeur();
                if(predecesseurs[suivant] == 0)
                    predecesseurs[suivant] = sommet;

                if(!sommetsVisites[suivant]) {
                    if(!f.contient(suivant)) {
                        f.enfile(new Noeud(new Info(courant.getInfo().getValeur())));
                    }
                }
                courant = courant.getSuivant();
            }
        }
    }

    public void affichePredecesseurs() {
        for (int predecesseur : predecesseurs) {
            System.out.print(predecesseur + " ");
        }
        System.out.println();
    }

    public File chemin(int debut, int fin) {
        File f = new File();
        f.enfile(new Noeud(new Info(fin)));

        while (fin != 0) {
            f.enfile(new Noeud(new Info(predecesseurs[fin])));
            fin = predecesseurs[fin];
        }

        //_chemin(debut, fin, f);
        f.inverse();
        return f;
    }
}
