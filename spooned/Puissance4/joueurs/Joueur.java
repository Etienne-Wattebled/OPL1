package Puissance4.joueurs;


public class Joueur {
    private java.lang.String nom;

    private int score;

    private java.awt.Color couleur;

    private void init(java.lang.String nom, int score, java.awt.Color couleur) {
        this.nom = nom;
        this.score = score;
        this.couleur = couleur;
    }

    public Joueur(java.lang.String nom ,int score ,java.awt.Color couleur) {
        init(nom, score, couleur);
    }

    public Joueur(java.lang.String nom ,java.awt.Color couleur) {
        init(nom, 0, couleur);
    }

    public void gagner() {
        score = (score) + 1;
    }

    public java.awt.Color getCouleur() {
        return couleur;
    }

    public int getScore() {
        return score;
    }

    public java.lang.String getNom() {
        return nom;
    }
}

