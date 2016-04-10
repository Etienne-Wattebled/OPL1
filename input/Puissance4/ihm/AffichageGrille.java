package Puissance4.ihm;

import Puissance4.donnees.*;
import Puissance4.*;
import Puissance4.joueurs.*;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Component;

/** Affichage de la grille qui va contenir le les jetons **/
public class AffichageGrille extends JPanel {
	private Jeu jeu;
	private Color cGrille ;
	private int nbC;
	private int nbL;
	private JPanel grille;
	private int hauteur;
	private int largeur;
	private int c=0;
	public AffichageGrille(int nombreColonnes, int nombreLignes, Color cGrille, int largeur, int hauteur, Jeu j) {
		init(nombreColonnes,nombreLignes,cGrille, largeur, hauteur,j);
	}
	public AffichageGrille(int nombreColonnes, int nombreLignes, Color cGrille, int largeur, int hauteur) {
		init(nombreColonnes,nombreLignes,cGrille, largeur, hauteur,null);
	}
	private void init(int nombreColonnes, int nombreLignes, Color cGrille, int largeur, int hauteur, Jeu j) {
		this.setVisible(true);
		this.setPreferredSize(new Dimension(largeur,hauteur));
		this.jeu = j;
		this.nbC = nombreColonnes;
		this.nbL = nombreLignes;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.cGrille = cGrille;
		
		int i;
		grille = new JPanel();
		grille.setLayout(new GridLayout(nbL,nbC));
		AffichageJeton case2;
		for (i = 0; i < nbC ; i++) {
			case2 = new AffichageJeton((int) largeur/nbC,(int) hauteur/nbL, Color.WHITE, Color.WHITE);
			//case2.setLayout(new BorderLayout());
			grille.add(case2);
		}
		for (i = 0; i < (nbC*nbL)-nbC; i++) {
			case2 = new AffichageJeton((int) largeur/nbC,(int) hauteur/nbL, Color.WHITE, cGrille);
			//case2.setLayout(new BorderLayout());
			grille.add(case2);
		}
		grille.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Joueur j = jeu.getJoueurHumainJouer();
				if (jeu != null) {
					jeu.jouer(j,(int)((e.getX())/((getLargeur()/nbC)+10)));
				}
			}
		});
		grille.addMouseMotionListener(new MouseMotionListener() {
			int c = 0;
			private boolean xDansPanel(MouseEvent e) {
				return ((e.getX() > 0) && (e.getX() < getLargeur())); 
			}
			public void mouseMoved(MouseEvent e)  {	
				int souris = (int)((e.getX())/((getLargeur()/nbC)+10));
				if ((c != souris) && (xDansPanel(e))) {
					Joueur j = jeu.getJoueurHumainJouer();
					if (j != null) {
						changerCouleurJetonHaut(Color.WHITE,c);
						changerCouleurJetonHaut(j.getCouleur(),souris);
						c = souris;
					}
				}
			}
			public void  mouseDragged(MouseEvent e) {
			}
		});
		this.setLayout(new BorderLayout());
		this.add(grille, BorderLayout.CENTER);
	}
	private int conv(int x, int y, int nbC) {
		return y*nbC+x;
	}
	private void changerCouleur(Color c, int x, int y) {
		Component[] composants = grille.getComponents();
		int a = conv(x,y,nbC);
		JPanel jp = (JPanel) composants[a];
		if (jp instanceof AffichageJeton) {
			AffichageJeton aff = (AffichageJeton) jp;
			aff.changerCouleur(c);
		}
	}
	public void changerCouleurJetonHaut(Color c, int x) {
		if ((x >= 0) && (x < nbC)) {
			changerCouleur(c,x,0);
		}
	}
	public void changerCouleurJetonGrille(Color c, int x, int y) {
		if ((x >= 0)&& (x < nbC) && (y+1 >= 0) && (y+1 < nbL)) {
			changerCouleur(c,x,y+1);
		}
	}
	public int getHauteur() {
		return hauteur;
	}
	public int getLargeur() {
		return largeur;
	}
	public int getNbC() {
		return nbC;
	}
	public int getNbL() {
		return nbL;
	}
	public void clear() {
		AffichageJeton a;
		Component[] composants = grille.getComponents();
		for (int i=0;i<composants.length;i++) {
			if (composants[i] instanceof AffichageJeton) {
				a = (AffichageJeton) composants[i];
				a.changerCouleur(Color.white);
				a.repaint();
			}
		}
	}
	public void refresh() {
		AffichageJeton a;
		Component[] composants = grille.getComponents();
		for (int i=0;i<composants.length;i++) {
			if (composants[i] instanceof AffichageJeton) {
				a = (AffichageJeton) composants[i];
				a.repaint();
			}
		}
	}
}
