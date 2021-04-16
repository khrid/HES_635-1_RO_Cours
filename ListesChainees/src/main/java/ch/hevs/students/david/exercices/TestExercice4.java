package ch.hevs.students.david.exercices;

import ch.hevs.students.david.lib.File;
import ch.hevs.students.david.lib.Info;
import ch.hevs.students.david.lib.Noeud;

public class TestExercice4 {
    public static void main(String[] args) {
        File file = new File();

        file.enfile(new Noeud(new Info(1)));
        file.enfile(new Noeud(new Info(2)));
        file.enfile(new Noeud(new Info(3)));
        file.enfile(new Noeud(new Info(4)));
        file.enfile(new Noeud(new Info(6)));
        file.enfile(new Noeud(new Info(8)));
        file.enfile(new Noeud(new Info(9)));

        File file2 = new File();
        file2.enfile(new Noeud(new Info(0)));
        file2.enfile(new Noeud(new Info(2)));
        file2.enfile(new Noeud(new Info(4)));
        file2.enfile(new Noeud(new Info(8)));
        //file2.enfile(new Noeud(new Info(10)));


        file.affiche();
        file2.affiche();
        file.fusionne(file2);

        file.affiche();
    }
}
