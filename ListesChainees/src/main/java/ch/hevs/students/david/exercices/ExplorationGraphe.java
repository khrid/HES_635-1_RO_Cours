package ch.hevs.students.david.exercices;

import ch.hevs.students.david.lib.File;
import ch.hevs.students.david.lib.Graphe;

public class ExplorationGraphe {
    public static void main(String[] args) {
        int[][] matrice = {
                /* depuis 0 on peut aller à */ {1, 2, 3},
                /* depuis 1 on peut aller à */ {4},
                /* depuis 2 on peut aller à */ {4, 5, 6},
                /* depuis 3 on peut aller à */ {6},
                /* depuis 4 on peut aller à */ {7},
                /* depuis 5 on peut aller à */ {7},
                /* depuis 6 on peut aller à */ {7},
                /* depuis 7 on peut aller à */ {},
        };

        Graphe g = new Graphe(matrice);
        g.afficheListe();
        //g.explorationRecursive(0);
        g.explorationFile(0);
        g.affichePredecesseurs();
        File f1 = g.chemin(0, 7);
        f1.affiche();
        File f2 = g.chemin(2, 6);
        f2.affiche();
    }
}
