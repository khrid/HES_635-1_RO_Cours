package ch.hevs.students.david.exercices;

import ch.hevs.students.david.lib.File;
import ch.hevs.students.david.lib.Info;
import ch.hevs.students.david.lib.Noeud;

/**
 * Exercice 2
 * Ecrire une méthode qui étant donné un entier x et une file F,
 * recherche et supprime le premier nœud contenant la valeur x.
 */

public class TestExercice2 {
    public static void main(String[] args) {
        File file = new File();

        file.enfile(new Noeud(new Info(3)));
        file.enfile(new Noeud(new Info(6)));
        file.enfile(new Noeud(new Info(2)));
        file.enfile(new Noeud(new Info(1)));
        file.enfile(new Noeud(new Info(9)));
        file.enfile(new Noeud(new Info(8)));
        file.enfile(new Noeud(new Info(4)));

        file.affiche();

        file.removeElement( 2);
        file.affiche();
    }
}
