package Puissance4.donnees;


public class Jeton {
    Puissance4.joueurs.Joueur joueur;

    public Jeton(Puissance4.joueurs.Joueur joueur) {
        this.joueur = joueur;
    }

    public java.awt.Color getCouleur() {
        return joueur.getCouleur();
    }

    public Puissance4.joueurs.Joueur getJoueur() {
        return joueur;
    }

    public boolean memeJoueur(Puissance4.donnees.Jeton j) {
        return (joueur) == (j.getJoueur());
    }
}

