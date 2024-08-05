package fr.pompey.dev.afpa.main;

import java.util.Random;
import java.util.Scanner;

public class Main {

    // Déclaration d'un attribut scanner pour la classe
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        while (true) {
            main.menu();
        }
    }

    private void menu() {
        int nbExo;
        String afficherExercice = "\n\n1) Exo1\n2) Exo2\n3) Exo3\n4) Exo4\n5) Exo5\n6) Exo6\n7) Exo7\n";

        System.out.println(afficherExercice);

        System.out.print("Veuillez choisir un exercice :");
        nbExo = sc.nextInt();
        switch (nbExo) {
            case 1:
                exo1();
                break;
            case 2:
                exo2();
                break;
            case 3:
                exo3();
                break;
            case 4:
                exo4();
                break;
            case 5:
                exo5();
                break;
            case 6:
                exo6();
                break;
            case 7:
                exo7();
                break;
            default:
                System.out.println("Ce n'est pas un exercice !");
        }
    }

    private void exo1() {
        double a, b, c, delta, x1 = 0, x2 = 0, x;

        System.out.print("Essayons de résoudre l'équation du second degré :");
        System.out.print("Entrer les valeurs de a, b, c, tel que ax²+bx+c=0\n\n :");
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        delta = b * b - 4 * a * c;

        if (delta > 0) {
            x1 = (-b + Math.sqrt(delta)) / (2 * a);
            x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Il y a 2 solutions: " + x1 + " et " + x2);
        } else if (delta == 0) {
            x = -b / (2 * a);
            System.out.println("Il y a une solution: " + x);
        } else {
            System.out.println("Il n'y a pas de solutions ");
        }
    }

    private void exo2() {
        int x, y;
        long res;
        System.out.println("Entrer des entiers x et y positif");
        x = sc.nextInt();
        y = sc.nextInt();
        res = puissance(x, y);
        System.out.println("Le résultat de x puissance y est : " + res);
    }

    private long puissance(int x, int y) {
        long res = 1;
        long base = x;

        while (y > 0) {
            if ((y & 1) == 1) {
                res *= base;
            }
            base *= base;
            y >>= 1;
        }

        return res;
    }

    private void exo3() {
        final int TAILLE_MAX = 10;
        int[] TabEntiers = {-10, -5, 0, 3, 8, 12, 15, 20, 25, 30};

        System.out.println("Tableau avant rangement");
        afficherTableau1D(TabEntiers);

        System.out.println("Tableau après rangement");
        afficherTableau1D(TabEntiers);

        System.out.println("Entrer la valeur de x à rechercher");
        int x = sc.nextInt();

        int position = rechercherEntier(TabEntiers, x);

        if (position != -1) {
            System.out.println("La valeur " + x + " se trouve à la position (index) : " + position);
        } else {
            System.out.println("La valeur " + x + " n'existe pas dans le tableau.");
        }
    }

    private void afficherTableau1D(int[] tab) {
        for (int i : tab) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private int rechercherEntier(int[] tab, int x) {
        int debut = 0;
        int fin = tab.length - 1;

        while (debut <= fin) {
            int milieu = debut + (fin - debut) / 2;
            if (tab[milieu] == x) {
                return milieu;
            }
            if (tab[milieu] < x) {
                debut = milieu + 1;
            } else {
                fin = milieu - 1;
            }
        }

        return -1;
    }

    private void exo4() {
        final int TAILLE = 10;
        int[] tableau = new int[TAILLE];
        Random random = new Random();

        for (int i = 0; i < TAILLE; i++) {
            tableau[i] = random.nextInt(101);
        }

        System.out.print("Tableau: ");
        for (int i : tableau) {
            System.out.print(i + " ");
        }
        System.out.println();

        int maxValue = lireMaxTabEntiers(tableau);
        System.out.println("La valeur maximale est: " + maxValue);
    }

    public static int lireMaxTabEntiers(int[] tableau) {
        int max = tableau[0];
        for (int i = 1; i < tableau.length; i++) {
            if (tableau[i] > max) {
                max = tableau[i];
            }
        }
        return max;
    }

    private void exo5() {
        final int LIGNES = 10;
        final int COLONNES = 10;
        int[][] TabMultiplication = new int[LIGNES][COLONNES];

        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                TabMultiplication[i][j] = i * j;
            }
        }

        afficherTableau2D(TabMultiplication);

        boolean continuer = true;
        while (continuer) {
            try {
                System.out.print("Entrez la valeur de X (entre 0 et 9): ");
                int X = sc.nextInt();
                System.out.print("Entrez la valeur de Y (entre 0 et 9): ");
                int Y = sc.nextInt();

                if (X >= 0 && X <= 9 && Y >= 0 && Y <= 9) {
                    int produit = TabMultiplication[X][Y];
                    System.out.println("Le résultat de " + X + " x " + Y + " = " + produit);
                } else {
                    System.out.println("Veuillez entrer des entiers entre 0 et 9 !");
                }
            } catch (Exception e) {
                System.out.println("Veuillez entrer un entier valide !");
                sc.next();
            }

            System.out.print("Souhaitez-vous encore un calcul ? (oui/non): ");
            String reponse = sc.next();
            if (reponse.equalsIgnoreCase("non")) {
                continuer = false;
            }
        }
    }

    private void afficherTableau2D(int[][] tableau) {
        System.out.println("Tableau de multiplication :");
        for (int[] ligne : tableau) {
            for (int val : ligne) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }

    private void exo6() {
        final int TAILLE = 10;
        int[] tableau = new int[TAILLE];
        remplirTableau(tableau);
        System.out.println("Tableau avant tri :");
        afficherTableau1D(tableau);
        trierTableau(tableau, true);
        System.out.println("Tableau après tri :");
        afficherTableau1D(tableau);
    }

    private void remplirTableau(int[] tableau) {
        Random rand = new Random();
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = rand.nextInt(101);
        }
    }

    private void trierTableau(int[] tableau, boolean croissant) {
        for (int i = 1; i < tableau.length; i++) {
            int cle = tableau[i];
            int j = i - 1;
            if (croissant) {
                while (j >= 0 && tableau[j] > cle) {
                    tableau[j + 1] = tableau[j];
                    j = j - 1;
                }
            } else {
                while (j >= 0 && tableau[j] < cle) {
                    tableau[j + 1] = tableau[j];
                    j = j - 1;
                }
            }
            tableau[j + 1] = cle;
        }
    }

    private void exo7() {
        int operator, n1, n2;
        System.out.println("Choisissez une opération: ");
        System.out.println("1: Addition (+)");
        System.out.println("2: Soustraction (-)");
        System.out.println("3: Multiplication (*)");
        System.out.println("4: Division (/)");
        operator = sc.nextInt();

        System.out.print("Entrez le premier nombre: ");
        n1 = sc.nextInt();
        System.out.print("Entrez le deuxième nombre: ");
        n2 = sc.nextInt();

        switch (operator) {
            case 1:
                System.out.println("Résultat: " + (n1 + n2));
                break;
            case 2:
                System.out.println("Résultat: " + (n1 - n2));
                break;
            case 3:
                System.out.println("Résultat: " + (n1 * n2));
                break;
            case 4:
                if (n2 != 0) {
                    System.out.println("Résultat: " + (n1 / n2));
                } else {
                    System.out.println("Erreur: Division par zéro !");
                }
                break;
            default:
                System.out.println("Opération invalide !");
        }
    }
}
