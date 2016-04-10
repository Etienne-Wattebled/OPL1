package Puissance4.donnees;

import Puissance4.joueurs.*;
import Puissance4.donnees.*;
import Puissance4.ihm.*;
import Puissance4.*;
import java.awt.Color;

public class Grille {
	private Jeton grille[][];
	private int tab[];
	private Jeu jeu;
	public Grille(int nbC, int nbL, Jeu jeu) {
		grille = new Jeton[nbC][nbL];
		tab = new int[nbC];
		initGrilleTab();
		this.jeu = jeu;
	}
	public Grille(Grille g) {
		this.grille = uneCopieGrille(g);
		this.tab = uneCopieTab(g);
		this.jeu = g.getJeu();
	}
	private Jeton[][] uneCopieGrille(Grille g) {
		Jeton tab[][] = g.getJetons();
		Jeton tab2[][] = new Jeton[tab.length][tab[0].length];
		for (int i=0;i<tab.length;i++) {
			for (int j=0;j<tab[i].length;j++) {
				tab2[i][j] = tab[i][j];
			}
		}
		return tab2;
		
	}
	private int[] uneCopieTab(Grille g) {
		int tab[] = g.getTab();
		int tab2[] = new int[tab.length];
		for (int i=0;i<tab.length;i++) {
			tab2[i] = tab[i];
		}
		return tab2;
	}
	public Jeu getJeu() {
		return jeu;
	}
	public void initGrilleTab() {
		for(int i=0;i<grille.length;i++) {
			for(int j=0;j<grille[i].length;j++) {
				grille[i][j] = null;
			}
		}
		for (int i=0;i<grille.length;i++) {
			tab[i] = grille[i].length-1;
		}
	}
	public int getNbC() {
		return grille.length;
	}
	public int getNbL() {
		return grille[0].length;
	}
	public boolean possibleJouer(int c) {
		return ((c<0)||(c>tab.length-1))?false:(tab[c]>=0);
	}
	public boolean possibleJouer(int x, int y) {
		return (existeCase(x,y))?(grille[x][y] == null):false;
	}
	public boolean grillePleine() {
		return grillePleine(tab);
	}
	public boolean grillePleine(int tab2[]) {
		boolean res=true;
		int i=0;
		while ((i<tab2.length) && (res)) {
			res = (tab2[i] == -1);
			i = i+1;
		}
		return res;
	}
	private boolean existeCase(int x, int y) {
		return ((x >=0) && (y >= 0) && (x < grille.length) && (y < grille[0].length));
	}
	public boolean existeJeton(Joueur j, int x, int y) {
		if (!existeCase(x,y)) {
			return false;
		}
		else {
			if (grille[x][y] != null) {
				Jeton jet = (Jeton) grille[x][y];
				return (jet.getJoueur() == j);
			}
			else {
				return false;
			}
		}
	}
	public void setJeu(Jeu j) {
		this.jeu = j;
	}
	public void mettreJeton(Joueur j, int c) {
		if (tab[c]>=0) {
			grille[c][tab[c]] = new Jeton(j);
			if (jeu != null) {
				jeu.setDcj(c);
				jeu.setDlj(tab[c]);
				jeu.afficherJeton(j.getCouleur(),c,tab[c]);
				jeu.refreshAffichage();
			}	
			tab[c] = tab[c]-1;	
		}
	}
	// attention, ne pas utiliser en cours de jeu. Uniquement dedie a l'IA.
	// car on ne sait plus le dernier jeton joue du coup.
	public void enleverJeton(int c) {
		if (tab[c] < grille[0].length-1) {
			tab[c]= tab[c]+1;
			if (jeu != null) {
				jeu.afficherJeton(Color.WHITE,c,tab[c]);
				jeu.refreshAffichage();
			}
			grille[c][tab[c]] = null;
		}
	}
	public void jouer(Joueur j, int c) {
		int x = c, y = 0;
		tab[c] = tab[c]-1;
		grille[x][y] = new Jeton(j);
		while(this.possibleJouer(x,y+1)) {
			grille[x][y+1] = grille[x][y];
			grille[x][y] = null;
			y = y+1;
		}
		if (jeu != null) {
			jeu.setDcj(x);
			jeu.setDlj(y);
			jeu.afficherJeton(j.getCouleur(),x,y);
			jeu.refreshAffichage();
		}		
	}
	public Jeton getJeton(int x, int y) {
		return grille[x][y];
	}
	public Jeton[][] getJetons() {
		return grille;
	}
	public int[] getTab() {
		return tab;
	}
	public int getIemeTab(int i) {
		return tab[i];
	}
}
