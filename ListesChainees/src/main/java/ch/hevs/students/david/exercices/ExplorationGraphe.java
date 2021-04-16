package ch.hevs.students.david.exercices;

import ch.hevs.students.david.lib.Graphe;

public class ExplorationGraphe {
    public static void main(String[] args) {
        int matrice[][] = {{1, 2},
                {4},
                {1,3,5},
                {5},
                {3,5},
                {}};

        Graphe g = new Graphe(matrice);
        g.afficheListe();
    }
}
