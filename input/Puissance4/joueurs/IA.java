package Puissance4.joueurs;

import java.awt.Color;
import java.io.*;
import Puissance4.joueurs.*;
import Puissance4.donnees.*;
import Puissance4.*;

public class IA extends Joueur implements Runnable {
	private byte profondeur;
	private Grille g;
	private int nivEvaluation;
	private Jeu jeu;
	public IA(byte prof, int nivEvaluation, Color couleur, Grille g, Jeu j) {
		super("Ordinateur",0,couleur);
		this.profondeur = prof;
		this.g = g;
		this.nivEvaluation = nivEvaluation;
		this.jeu = j;
	}
	public void run() {
	}
	public int jouer(int dcj, int dlj) {
		return alphabeta(profondeur,dcj,dlj);
	}
	public int evaluation(Grille grille, int dcj, int dlj) {
		if (nivEvaluation == 1) {
			return gagner(100000,grille,dcj,dlj) + (int)(Math.random()*20);
		}
		else {
			return 0;
		}
	}
	public int gagner(int p, Grille grille, int dcj, int dlj) {
		if (jeu.gagner(this,grille,dcj,dlj)) {
			return p;
		}
		else {
			if (jeu.gagner(jeu.getProchainJoueur(),grille,dcj,dlj)) {
				return -p;
			}
			else {
				return 0;
			}
		}
	}
	public int nbPieges(Joueur joueur, int p, Jeton g[][]) {
		boolean ok = false;
		int compteur = 0;
		int i,j;
		for( i =0; i< g.length; i++ ) {
			for( j =0; j< g[0].length; j++ ) {
				ok = false;
				if (g[i][j] == null) {
					if((i-3) >= 0) {
						if ((g[i-3][j] !=null) && (g[i-2][j] != null) && (g[i-1][j] != null)) {
							if ((g[i-3][j].getJoueur() == joueur) && (g[i-2][j].getJoueur() == joueur) && (g[i-1][j].getJoueur() == joueur)) {
								ok = true;
							}
						}
					}
					if((i+3) <=(g.length-1) ) {
						if ((g[i+3][j] !=null) && (g[i+2][j] != null) && (g[i+1][j] != null)) {
							if( (g[i+3][j].getJoueur() == joueur) && (g[i+2][j].getJoueur() == joueur) && (g[i+1][j].getJoueur() == joueur)) {
								ok =true;
							}
						}
					}
				}
				if (ok) {
					ok = false;
					if ((j+4) <= g[i].length-1) {
						if (g[i][j+1] == null) {
							if ((i-3) >= 0) {
								if ((g[i-1][j+2] != null) && (g[i-2][j+3] != null) && (g[i-3][j+4] != null)) { 
									if ((g[i-1][j+2].getJoueur() == joueur) && (g[i-2][j+3].getJoueur() == joueur) && (g[i-3][j+4].getJoueur() == joueur)) { 
										ok = true; 
									}
								}
							}
							if ((i+3) <= g.length-1) {
								if ((g[i+1][j+2] != null) && (g[i+2][j+3] != null) && (g[i+3][j+4] != null)) { 
									if ((g[i+1][j+2].getJoueur() == joueur) && (g[i+2][j+3].getJoueur() == joueur) && (g[i+3][j+4].getJoueur() == joueur)) { 
										ok = true; 
									}
								}
							}
						}
					}
					if ((j-4) >= 0) {
						if (g[i][j-1] == null) {
							if ((i-3) >= 0) {
								if ((g[i-1][j-2] != null) && (g[i-2][j-3] != null) && (g[i-3][j-4] != null)) { 
									if ((g[i-1][j-2].getJoueur() == joueur) && (g[i-2][j-3].getJoueur() == joueur) && (g[i-3][j-4].getJoueur() == joueur)) { 
										ok = true; 
									}
								}
							}
							if ((i+3) <= g.length-1) {
								if ((g[i+1][j-2] != null) && (g[i+2][j-3] != null) && (g[i+3][j-4] != null)) {
									if ((g[i+1][j-2].getJoueur() == joueur) && (g[i+2][j-3].getJoueur() == joueur) && (g[i+3][j-4].getJoueur() == joueur)) { 
										ok = true; 
									}
								}
							}
						}
					}
					if (ok) { 
						compteur = compteur+p;
					}
				}
			}
		}
		System.gc();
		return compteur;
	}
	private int passerLesLignesVides(Jeton tab[][]) {
		int i =0, j =0;
		boolean ok = false;
		while ((i<tab.length) && (!ok)) {
			j=0;
			while ((j< tab[i].length) && (!ok)) {
				ok=false;
				if(tab[i][j] != null) {
					ok = true;
				}
				j++;
			} 
			i++;
		}
		tab = null;
		return (j<2)?0:j-2;
	}
	private int nbPionsTroisAlignes(Joueur joueur, int p, Jeton tab[][]) {
		int i=0;
		int j=0;
		int result=0;
		boolean aligner = false;
		for(i=0; i<tab.length; i++) {
			j=0;
			for(j=passerLesLignesVides(tab); j <tab[0].length; j++) {
				aligner = false;
				if(tab[i][j] == null) {
					// En ligne gauche
					if((i-3) >= 0) {
						// Serie de 3 alignes xxxV
						if((tab[i-3][j] != null) && (tab[i-2][j] != null) && (tab[i-1][j] != null)) {
							if((tab[i-3][j].getJoueur() == joueur) && (tab[i-2][j].getJoueur() == joueur) && (tab[i-1][j].getJoueur() == joueur)) {
								aligner = true;
							}
						}
					}
					// En ligne droite
					if((i+3) < tab.length) {
						// Serie de 3 lignes Vxxx
						if((tab[i+3][j] != null) && (tab[i+2][j] !=null) && (tab[i+1][j] != null)) {
							if((tab[i+3][j].getJoueur() == joueur) && (tab[i+2][j].getJoueur() == joueur) && (tab[i+1][j].getJoueur() == joueur)) {
								aligner = true;
							}
						}
					}
					// En colonne bas
					if ((j+3) < tab[i].length) {
						if ((tab[i][j+3] != null) && (tab[i][j+2] != null) && (tab[i][j+1] != null)) {
							if ((tab[i][j+3].getJoueur() == joueur) && (tab[i][j+2].getJoueur() == joueur) && (tab[i][j+1].getJoueur() == joueur)) { 
								aligner= true;
							}
						}
					}
					// En diagonal bas
					if ((j+3) < tab[i].length) {
						if ((i-3) >= 0) {
							if ((tab[i-3][j+3] != null) && (tab[i-2][j+2] != null) && (tab[i-1][j+1] != null)) { 
								if ((tab[i-3][j+3].getJoueur() == joueur) && (tab[i-2][j+2].getJoueur() == joueur) && (tab[i-1][j+1].getJoueur() == joueur)) { 
									aligner= true;
								}
							}
						}
						if ((i+3) < tab.length) {
							if ((tab[i+3][j+3] != null) && (tab[i+2][j+2] != null) && (tab[i+1][j+1] != null)) { 
								if ((tab[i+3][j+3].getJoueur() == joueur) && (tab[i+2][j+2].getJoueur() == joueur) && (tab[i+1][j+1].getJoueur() == joueur)) {
									aligner = true;
								}
							}
						}
					}
					//En diagonal Haut
					if ((j-3) >= 0) {
						if ((i-3) >= 0) {
							if ((tab[i-3][j-3] != null) && (tab[i-2][j-2] != null) && (tab[i-1][j-1] != null)) { 
								if ((tab[i-3][j-3].getJoueur() == joueur) && (tab[i-2][j-2].getJoueur() == joueur) && (tab[i-1][j-1].getJoueur() == joueur)) { 
									aligner = true;
								}
								
							}
						}
						if ((i+3) < tab.length) {
							if ((tab[i+3][j-3] != null) && (tab[i+2][j-2] != null) && (tab[i+1][j-1] != null)) { 
								if ((tab[i+3][j-3].getJoueur() == joueur) && (tab[i+2][j-2].getJoueur() == joueur) && (tab[i+1][j-1].getJoueur() == joueur)) { 
									aligner = true;
								}
							}
						}
					}
					if (aligner) {
						result = result+p;
						aligner = false;
					}
				}
			}
		}
		return result;
	}
	public int alphabeta(byte prof, int dcj, int dlj) {
		Grille grille = new Grille(g);
		grille.setJeu(null);
		int tab[] = alphabetaRec(prof,Integer.MIN_VALUE,Integer.MAX_VALUE,grille,true,dcj,dlj);
		System.gc();
		return tab[0];
	}
	public static int max(int a, int b) {
		return (a>b)?a:b;
	}
	public static int min(int a, int b) {
		return (a<b)?a:b;
	}
	private int[] alphabetaRec(byte prof, int alpha, int beta, Grille grille, boolean max, int dcj, int dlj) {
		int duo[] = new int[2];
		int temp[];
		int m,nbr;
		boolean gagner = (jeu.gagner(this,grille, dcj, dlj) || jeu.gagner(jeu.getProchainJoueur(),grille, dcj, dlj));
		if ((prof == 0) || gagner || (grille.grillePleine())) {
			duo[0] = 0;
			if (gagner || prof == 0) {
				duo[1] = evaluation(grille,dcj,dlj);
			}
			else {
				duo[1] = 0;
			}
		}
		else {
			nbr = grille.getNbC();
			if (max) {
				m = Integer.MIN_VALUE;
				while ((m<beta) && (nbr>0)) {
					if (grille.possibleJouer(nbr-1)) {
						grille.mettreJeton(this,nbr-1);
						temp = alphabetaRec((byte)(prof-1),alpha,beta,grille,!max,nbr-1,grille.getIemeTab(nbr-1)+1);
						if (temp[1] > m) {
							m = temp[1];
							duo[0] = nbr-1;
							duo[1] = temp[1];
						}
						grille.enleverJeton(nbr-1);
						alpha = max(alpha,m);
					}
					nbr = nbr-1;
				}
			}
			else {
				m = Integer.MAX_VALUE;
				while ((m > alpha) && (nbr > 0)) {					
					if (grille.possibleJouer(nbr-1)) {
						grille.mettreJeton(jeu.getProchainJoueur(),nbr-1);
						temp = alphabetaRec((byte)(prof-1),alpha,beta,grille,!max,nbr-1,grille.getIemeTab(nbr-1)+1);
						if (temp[1] < m) {
							m = temp[1];
							duo[0] = nbr-1;
							duo[1] = temp[1];
						}
						grille.enleverJeton(nbr-1);
						beta = min(beta,m);
						
					}
					nbr = nbr-1;
				}
				
			}
		}
		return duo;
	}
}