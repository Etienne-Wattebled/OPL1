package Puissance4.joueurs;

import Puissance4.joueurs.*;
import java.awt.*;
import java.util.concurrent.Semaphore;
public class Joueur {
	private String nom;
	private int score;
	private Color couleur;
	private void init(String nom, int score, Color couleur) {
		this.nom = nom;
		this.score = score;
		this.couleur = couleur;
	}
	public Joueur(String nom, int score, Color couleur) {
		init(nom,score,couleur);
	}
	public Joueur(String nom, Color couleur) {
		init(nom,0,couleur);
	}
	public void gagner() {
		score = score +1;
	}
	public Color getCouleur() {
		return couleur;
	}
	public int getScore() {
		return score;
	}
	public String getNom() {
		return nom;
	}
}