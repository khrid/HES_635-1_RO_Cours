package ch.hevs.students.david.exercices;

import ch.hevs.students.david.lib.File;
import ch.hevs.students.david.lib.Info;
import ch.hevs.students.david.lib.Noeud;

import java.util.Scanner;

public class TestExerciceFile2 {

    public static void main(String[] args) {
        //exercice4EtPrecedents();

        /* Exercice 5 */
        exercice5();
    }

    private static void exercice4EtPrecedents() {
        // TODO Auto-generated method stub
        int tab[] = {369, 512, 711, 982, 147, 565, 911, 769};

        File travail = new File(tab);
        File travailTriee = new File(tab);

        /* Exercice 1 (cf Serie1)
            Ecrire une méthode qui inverse le contenu d’une file.
        */
        System.out.println("");
        System.out.println("Ex 1 Inverse contenu file");
        travail.affiche();
        travail.inverseNicole();
        travail.affiche();

        /* Exercice 2 (cf Serie1)
            Radix Sort.
        */
        System.out.println("");
        System.out.println("Ex 2 Radix sort");
        travailTriee.affiche();
        travailTriee.radixSort();
        travailTriee.affiche();

        /* Exercice 3  (cf Serie1)
            Ecrire une méthode qui étant donné un entier x et une file F,
            recherche et supprime le premier nœud contenant la valeur x.
         */
        System.out.println("");
        System.out.println("Ex 3 recherche et supprime premier noeud");
        travail.affiche();
        travail.rechercheEtSupprimePremier(982);
        travail.affiche();

        /* Exercice 4
            Ecrire une méthode qui étant donné un entier x et une file ordonnée d’entiers F,
            insère un nœud contenant la valeur x de sorte que la file reste ordonnée.
        */
        System.out.println("");
        System.out.println("Ex 4 insertion dans liste triee");
        travailTriee.affiche();
        travailTriee.insereDansFileTriee(1470);
        travailTriee.affiche();
    }

    /**
     * Exercice 5
     * Ecrire ce programme qui teste vos files :
     * Votre programme lit au clavier une suite de nombres entiers terminée par la valeur 0 et construit une file
     * avec ces entiers (sauf le 0 final). Cette file doit insérer les éléments dans l’ordre croissant,
     * et une valeur n’est stockée qu’une seule fois dans la liste.
     * <p>
     * On affichera le contenu de cette file 1.
     * <p>
     * Le programme lit ensuite une autre suite de nombres entiers terminée par la valeur 0 et construit une file
     * avec ces entiers (sauf le 0 final). Cette deuxième file doit garder les éléments dans l’ordre dans
     * lequel ils ont été introduits, mais une valeur n’est stockée qu’une seule fois dans la liste.
     * <p>
     * On affichera le contenu de cette file 2.
     * <p>
     * Les éléments de la seconde file devront être supprimées de la première file.
     * <p>
     * A la fin le programme affiche le contenu des deux files.
     */
    private static void exercice5() {
        System.out.print("File 1");
        File f1 = demandeSaisieUtilisateur(new File(), true);
        System.out.print("Contenu de la file 1 ");
        f1.affiche();

        System.out.print("File 2");
        File f2 = demandeSaisieUtilisateur(new File(), false);
        System.out.print("Contenu de la file 2 ");
        f2.affiche();

        // Parcours des éléments de f2 pour les supprimer de f1
        Noeud courantFile2 = f2.getPremier();
        while (courantFile2 != null) {
            f1.rechercheEtSupprimePremier(courantFile2.getInfo().getValeur());
            courantFile2 = courantFile2.getSuivant();
        }

        // Affichage du contenu des deux files
        System.out.print("Contenu de la file 1 ");
        f1.affiche();
        System.out.print("Contenu de la file 2 ");
        f2.affiche();
    }

    public static File demandeSaisieUtilisateur(File f, boolean tri) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez les valeurs (0 pour terminer) : ");
        int userInput = scanner.nextInt();
        while (userInput != 0) {
            System.out.println();
            if (f.estVide()) {
                f.enfile(new Noeud(new Info(userInput)));
            } else if (!f.contient(userInput)) {
                if (tri) f.radixSort();
                f.insereDansFileTriee(userInput);
            }
            System.out.print("Contenu file : ");
            f.affiche();

            System.out.println("Entrez les valeurs (0 pour terminer) : ");
            userInput = scanner.nextInt();
        }
        return f;
    }
}

