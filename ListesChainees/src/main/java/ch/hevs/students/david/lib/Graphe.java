package ch.hevs.students.david.lib;

public class Graphe {
    private final File[] liste;

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
            System.out.println();
        }
    }
}
