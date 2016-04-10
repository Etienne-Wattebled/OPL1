package Puissance4.donnees;

import Puissance4.joueurs.*;
import java.awt.Color;

public class Jeton {
	Joueur joueur;
	public Jeton(Joueur joueur) {
		this.joueur = joueur;
	}
	public Color getCouleur() {
		return joueur.getCouleur();
	}
	public Joueur getJoueur() {
		return joueur;
	}
	public boolean memeJoueur(Jeton j) {
		return joueur == j.getJoueur();
	}
}
