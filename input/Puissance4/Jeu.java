package Puissance4;

import Puissance4.joueurs.*;
import Puissance4.ihm.*;
import Puissance4.donnees.*;
import java.util.concurrent.Semaphore;
import java.util.Scanner;
import java.awt.Color;

public class Jeu {
	private boolean graphique;
	private int dcj; // derniere colonne jouee
	private int dlj; // derniere ligne jouee
	private Grille g;
	private IHM ihm;
	private Joueur joueur;
	private Joueur prochainJoueur;
	private Semaphore semJoueur;
	public Jeu(boolean graphique) {
		this.g = null;
		this.ihm = null;
		this.joueur = null;
		this.prochainJoueur = null;
		this.semJoueur = null;
		dcj = 0;
		dlj = 0;
		this.graphique = graphique;
		if (graphique) {
			new PremiereFenetre(this);
		}
		else {
			initConsole();
		}
	}
	public Jeu(Grille grille, IHM ihm, Joueur jproch, Joueur j) {
		this.g = grille;
		this.ihm = ihm;
		this.prochainJoueur = jproch;
		this.joueur = j;
		this.semJoueur = null;
		dcj = 0;
		dlj = 0;
	}
	public Semaphore getSemaphore() {
		return semJoueur;
	}
	public void reset() {
		if (!graphique) {
			System.out.println(joueur.getNom() + " : " + joueur.getScore());
			System.out.println(prochainJoueur.getNom() + " : " + prochainJoueur.getScore());
		}
		if (ihm != null) {
			ihm.raz();
		}
		if (g != null) {
			g.initGrilleTab();
		}
		dcj = 0;
		dlj = 0;
	}
	public void setDcj(int a) {
		dcj = a;
	}
	public void setDlj(int a) {
		dlj = a;
	}
	public void setGrille(Grille g) {
		this.g = g;
	}
	public void setJoueur(Joueur j) {
		joueur = j;
	}
	public void setProchainJoueur(Joueur j) {
		prochainJoueur = j;
	}
	public void setIHM(IHM i) {
		ihm = i;
	}
	public IHM getIHM() {
		return ihm;
	}
	public boolean getGraphique() {
		return graphique;
	}
	public Joueur getJoueurHumainJouer() {
		if ((joueur instanceof IA) && (prochainJoueur instanceof IA)) {
			return null;
		}
		else {
			if (!(joueur instanceof IA)) {
				return joueur;
			}
			else {
				if (!(prochainJoueur instanceof IA)) {
					return prochainJoueur;
				}
				else {
					return null;
				}
			}
		}
	}
	public void setSemaphore(Semaphore sem) {
		this.semJoueur = sem;
	}
	public void refreshAffichage() {
		ihm.refresh();
	}
	public Joueur getProchainJoueur() {
		return prochainJoueur;
	}
	public Joueur getJoueur() {
		return joueur;	
	}
	public void changerJoueur() {
		Joueur interm = prochainJoueur;
		prochainJoueur = joueur;
		joueur = interm;
	}
	public boolean possibleJouer(int c) {
		return g.possibleJouer(c);
	}
	public boolean grillePleine(int tab[]) {
		return g.grillePleine(tab);
	}
	public boolean finDeJeu(Grille g) {
		boolean grillePleine = g.grillePleine(g.getTab());
		boolean unGagnant = ((gagner(joueur)) || gagner(prochainJoueur));
		return (grillePleine || unGagnant);
	}
	public boolean finDeJeu() {
		return finDeJeu(g);
	}
	public void jouer(Joueur j, int c) {
		if ((j == joueur) && possibleJouer(c) && (!finDeJeu())) {
			if (!graphique) {
				System.out.println("OK " + j.getNom() + ". Ton coup est valide.");
			}
			g.jouer(j,c);
			if (!(j instanceof IA)) {
				semJoueur.release();
			}
		}
		else {
			if (!graphique) {
				System.out.println("Pas possible de jouer ici " + j.getNom());
			}
			else {
				ihm.message("Pas possible de jouer ici " + j.getNom());
			}
		}
	}
	public boolean gagner(Joueur joueur) {
		return gagner(joueur,g,dcj,dlj);	
	}
	public boolean gagner(Joueur joueur,Grille grille, int c, int l) {
		if ((grille.getJeton(c,l) == null) || (grille.getJeton(c,l).getJoueur() != joueur)) {
			return false;
		}
		else {
			int gauche=0;
			int droite=0;
			int i=1;
			boolean continuer=true;
			// ligne on compte a gauche
			while ((continuer) && (i <= 3)){
				continuer = grille.existeJeton(joueur,c-i,l);
				if (continuer) {
					gauche++;
					i++;
				}
			}
			if (gauche == 3) {
				return true;
			}
			i = 1;
			continuer = true;
			while ((continuer) && (i <= 3)){
				continuer = grille.existeJeton(joueur,c+i,l);
				if (continuer) {
					droite++;
					i++;
				}
			}
			if ((gauche + droite) >= 3) {
				return true;
			}
			// colonne
			i = 1;
			gauche = 0;
			droite = 0;
			continuer = true;
			while ((continuer) && (i <= 3)){
				continuer = grille.existeJeton(joueur,c,l-i);
				if (continuer) {
					gauche++;
					i++;
				}
			}
			if (gauche == 3) {
				return true;
			}
			i = 1;
			continuer = true;
			while ((continuer) && (i <= 3)){
				continuer = grille.existeJeton(joueur,c,l+i);
				if (continuer) {
					droite++;
					i++;
				}
			}
			if ((gauche + droite) >= 3) {
				return true;
			}
			// diagonal \
			i = 1;
			gauche = 0;
			droite = 0;
			continuer = true;
			while ((continuer) && (i <= 3)){
				continuer = grille.existeJeton(joueur,c-i,l-i);
				if (continuer) {
					gauche++;
					i++;
				}
			}
			if (gauche == 3) {
				return true;
			}
			i = 1;
			continuer = true;
			while ((continuer) && (i <= 3)){
				continuer = grille.existeJeton(joueur,c+i,l+i);
				if (continuer) {
					droite++;
					i++;
				}
			}
			if ((gauche + droite) >= 3) {
				return true;
			}
			// diagonal /
			i = 1;
			gauche = 0;
			droite = 0;
			continuer = true; 
			while ((continuer) && (i <= 3)){
				continuer = grille.existeJeton(joueur,c+i,l-i);
				if (continuer) {
					gauche++;
					i++;
				}
			}
			if (gauche == 3) {
				return true;
			}
			i = 1;
			continuer = true;
			while ((continuer) && (i <= 3)){
				continuer = grille.existeJeton(joueur,c-i,l+i);
				if (continuer) {
					droite++;
					i++;
				}
			}
			if ((gauche + droite) >= 3) {
				return true;
			}
			return false;
		}
	}
	public boolean unGagnant() {
		if (gagner(prochainJoueur)) {
			return true;
		}
		else {
			return false;	
		}
	}
	public void start() {
		while((!finDeJeu()) && (!Thread.currentThread().isInterrupted())) {
			if (!graphique) {
				System.out.println("Au tour de: " + joueur.getNom());
			}
			else {
				ihm.message("Au tour de : " + joueur.getNom());
			}
			if (joueur instanceof IA) {
				IA ia = (IA) joueur;
				g.jouer(ia,ia.jouer(dcj,dlj));
			}
			else {
				semJoueur.acquireUninterruptibly();
			}
			changerJoueur();
			ihm.refresh();
		}
		if (graphique) {
			ihm.message("Partie termin\u00e9e.");
		}
		if (unGagnant()) {
			prochainJoueur.gagner();
			if (!graphique) {
				System.out.println("Bravo " + prochainJoueur.getNom());
				System.out.println(getScores());
			}
			else {
				ihm.afficherMessage("Bravo " + prochainJoueur.getNom(),getScores());
			}
		}
		else {
			if (!graphique) {
				System.out.println("Match nul");
				System.out.println(getScores());
			}
			else {
				ihm.afficherMessage("Match nul",getScores());
			}
		}
	}
	public Launcher getLauncher() {
		return ihm.getLauncher();
	}
	public void initConsole() {
		int a=0,b=0;
		String s = "";
		Scanner scan = new Scanner(System.in);
		String fond="bleu",jeton1="rouge",jeton2="jaune";
		if (this.g == null) {
			System.out.println("Nombre de colonnes ?");
			a = scan.nextInt();
			System.out.println("Nombre de lignes ?");
			b = scan.nextInt();
			if ((a >= 4) && (b >= 4)) {
				g = new Grille(a,b,this);
			}
			else {
				System.out.println("Grille trop petite. Changement en 7,6");
				this.g = new Grille(7,6,this);
			}
		}
		else {
			this.g.initGrilleTab();
		}
		if (ihm == null) {
			System.out.println("Titre ?");
			s = scan.next();
			System.out.println("Largeur d'affichage ?");
			a = scan.nextInt();
			System.out.println("Hauteur d'affichage ?");
			b = scan.nextInt();
			System.out.println("Couleur de la grille ? noir bleu cyan magenta orange rose rouge jaune vert");
			fond = scan.next();
			this.ihm = new IHM(s,a,b,g.getNbL(),g.getNbC(),traduireCouleur(fond),this);
			Launcher l = new Launcher(this);
			ihm.setLauncher(l);
		}
		else {
			ihm.clear();
		}
		if (joueur == null) {
			joueur = donnerJoueur(false);
		}
		if (prochainJoueur == null) {
			prochainJoueur = donnerJoueur(true);
		}
		if (!(joueur instanceof IA) || !(prochainJoueur instanceof IA) ) {
			Semaphore sem = new Semaphore(0);
			this.setSemaphore(sem);
		}
	}
	private Color traduireCouleur(String couleur) {
		String c = couleur.toLowerCase();
		Color couleurM;
		switch(c) {
		case "bleu" : couleurM = new Color(44, 117, 255);
			break;
		case "vert" : couleurM = new Color(87, 213, 59);
			break;
		case "cyan" : couleurM = Color.CYAN;
			break;
		case "magenta" : couleurM = Color.MAGENTA;
			break;
		case "orange" : couleurM = new Color(255, 73, 1);
			break;
		case "rose" : couleurM = new Color(249, 66, 158);
			break;
		case "jaune" : couleurM = Color.YELLOW;
			break;
		case "rouge" : couleurM = Color.RED;
			break;
		case "noir" : couleurM = new Color(19, 14, 10);
			break;
		case "gris" : couleurM = new Color(175, 175, 175);
			break;
			default : couleurM = new Color(38,196, 236);	
		}
		return couleurM;
	}
	public void afficherJeton(Color c, int x, int y) {
		ihm.changerCouleurJetonGrille(c,x,y);
	}
	public String getScores() {
		return (joueur.getNom() + " : " + joueur.getScore() + "\n" + prochainJoueur.getNom() + " : " + prochainJoueur.getScore());
  	}
	private Joueur donnerJoueur(boolean a) {
		String s = "",c="";
		Scanner scan = new Scanner(System.in);
		System.out.println("Que voulez-vous pour le joueur " + ((a)?2:1) + " ? 'ordinateur' ou 'humain' ? Veuillez saisir sans les ' '");
		s = new Scanner(System.in).next();
		Joueur j=null;
		int i =0;
		if (s.equals("ordinateur")) {
			byte b=0;
			System.out.println("Profondeur (coups d'avance). Ne tapez pas une grande valeur. Conseil : entre 7 et 12. Plus la profondeur est haute, plus l'IA sera robuste.");
			b = scan.nextByte();
			System.out.println("Niveau. (Il n'existe que le niveau 1 dans la version actuelle)");
			i = scan.nextInt();
			System.out.println("Couleur de l'IA ? bleu, vert, cyan, magenta, orange, rose, jaune, rouge, noir, gris");
			c = scan.next();
			IA ordinateur = new IA(b,i,traduireCouleur(c),this.g,this);
			Thread ia = new Thread(ordinateur);
			ia.start();
			j = ordinateur;
		}
		else {
			System.out.println("Quel est votre nom ?");
			s = scan.next();
			System.out.println("Couleur jeton ? bleu, vert, cyan, magenta, orange, rose, jaune, rouge, noir, gris");
			c = scan.next();
			j = new Joueur(s,0,traduireCouleur(c));
		}
		return j;
	}
	public static void main(String args[]) {
		Jeu jeu = new Jeu(true);
	}
}