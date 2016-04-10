package Puissance4.ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Puissance4.*;
import Puissance4.joueurs.*;
import Puissance4.donnees.*;

// Le panel qui contiendra le choix de la couleur des jetons et du fond 
public class ChoixCouleur extends JPanel {
	private JComboBox <String> listeF, listeJ1, listeJ2;
	private JComboBox <Integer> listeNbC, listeNbL, listeH, listeL;
	private String[] textCouleur;
	private Color[] couleur;
	private Integer[] taille, dimension;
	private JLabel labelF, labelJ1, labelJ2;
	private JLabel labelNbC, labelNbL, labelDim, labelTaille, labelH, labelL;
	private AffichageJeton jetonJ1, jetonJ2;
	private Color choixF, choixJ1, choixJ2;
	private JPanel panelF, panelJ1, panelJ2, panelJetons, panelToutC, panel, separ; 
	private JPanel panelNbC, panelNbL, panelH, panelL, panelTaille, panelDim, panelToutT  ; 
	private Font fond, fond1;
	private int nbC, nbL, hauteur, largeur;
	public ChoixCouleur() {
		fond1 = new Font("TimesRoman", Font.BOLD, 18);
		fond = new Font("TimesRoman", Font.PLAIN, 17);
		textCouleur = new String[] {"Bleu", "Vert", "Cyan", "Magenta", "Orange", "Rose", "Jaune", "Rouge", "Noir", "Violet", "Gris"} ;
		couleur = new Color[] {new Color(44, 117, 255), new Color(87, 213, 59), Color.CYAN, Color.MAGENTA, new Color(255, 162, 43), new Color(255, 103, 216), Color.YELLOW, Color.RED, new Color(19, 14, 10), new Color(136, 6, 206), new Color(175, 175, 175) };
		taille = new Integer[] {500, 600, 700, 800, 900, 100};
		dimension = new Integer[] {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		jetonJ1 = new AffichageJeton(120, 120);
		jetonJ2 = new AffichageJeton(120, 120);	
		labelF = new JLabel("Choix de la couleur de fond", JLabel.CENTER);
		labelJ1 = new JLabel("Joueur 1", JLabel.CENTER);
		labelJ2 = new JLabel("Joueur 2", JLabel.CENTER);
		labelF.setFont(fond1);
		labelJ1.setFont(fond);
		labelJ2.setFont(fond);
		listeF = new JComboBox <String> (textCouleur);
		listeJ1 = new JComboBox <String> (textCouleur);
		listeJ2 = new JComboBox <String> (textCouleur);
		labelDim = new JLabel("Choix de la dimension du jeu", JLabel.CENTER);
		labelDim.setFont(fond1);
		labelNbL = new JLabel("Nombre de lignes");
		labelNbL.setFont(fond);
		labelNbC = new JLabel("Nombre de colonnes");
		labelNbC.setFont(fond);
		labelTaille = new JLabel("Choix de la taille de la fen\u00eatre", JLabel.CENTER);
		labelTaille.setFont(fond1);
		labelH = new JLabel("Hauteur");
		labelH.setFont(fond);
		labelL = new JLabel("Largeur");
		labelL.setFont(fond);
		listeNbC = new JComboBox <Integer> (dimension);
		listeNbL = new JComboBox <Integer> (dimension);
		listeH = new JComboBox <Integer> (taille);
		listeL = new JComboBox <Integer> (taille);
		// Le choix de la couleur de fond
		ActionListener ChoixF = new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choixF = couleur[listeF.getSelectedIndex()];
				jetonJ1.changerCouleurFond(couleur[listeF.getSelectedIndex()]);
				jetonJ2.changerCouleurFond(couleur[listeF.getSelectedIndex()]);
			}
		};
	 	//Le choix de la couleur du joueur 1	
	 	ActionListener ChoixJ1 = new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 			choixJ1 = couleur[listeJ1.getSelectedIndex()];
	 			jetonJ1.changerCouleur(couleur[listeJ1.getSelectedIndex()]);
	 		}
	 	};	
	 	//Le choix de la couleur du joueur 2	
	 	ActionListener ChoixJ2 = new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 			choixJ2= couleur[listeJ2.getSelectedIndex()];
	 			jetonJ2.changerCouleur(couleur[listeJ2.getSelectedIndex()]);
	 		}
	 	};	
		listeF.addActionListener(ChoixF);
		listeJ1.addActionListener(ChoixJ1);
		listeJ2.addActionListener(ChoixJ2);
		//Pour la partie couleur
		panelF = new JPanel(new BorderLayout());
		panelF.add(labelF, BorderLayout.NORTH);
		panelF.add(listeF, BorderLayout.SOUTH);
		panelJ1 = new JPanel(new BorderLayout());
		panelJ1.add(labelJ1, BorderLayout.NORTH);
		panelJ1.add(jetonJ1, BorderLayout.CENTER);
		panelJ1.add(listeJ1, BorderLayout.SOUTH);
		panelJ2 = new JPanel(new BorderLayout());
		panelJ2.add(labelJ2, BorderLayout.NORTH);
		panelJ2.add(jetonJ2, BorderLayout.CENTER);
		panelJ2.add(listeJ2, BorderLayout.SOUTH);
		panelJetons = new JPanel(new BorderLayout());
		panelJetons.add(panelJ1, BorderLayout.WEST);
		panelJetons.add(panelJ2, BorderLayout.EAST);
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(20,20));
		panelToutC = new JPanel(new BorderLayout());
		panelToutC.add(panelF, BorderLayout.NORTH);
		panelToutC.add(panel, BorderLayout.CENTER);
		panelToutC.add(panelJetons, BorderLayout.SOUTH);
		//Pour la partie taille
		panelNbC = new JPanel();
		panelNbC.add(listeNbC);
		panelNbC.add(labelNbC);
		panelNbL = new JPanel();
		panelNbL.add(listeNbL);
		panelNbL.add(labelNbL);
		panelDim = new JPanel(new BorderLayout());
		panelDim.add(labelDim, BorderLayout.NORTH);
		panelDim.add(panelNbC, BorderLayout.CENTER);
		panelDim.add(panelNbL, BorderLayout.SOUTH);
		panelH = new JPanel();
		panelH.add(listeH);
		panelH.add(labelH);
		panelL = new JPanel();
		panelL.add(listeL);
		panelL.add(labelL);
		panelTaille = new JPanel(new BorderLayout());
		panelTaille.add(labelTaille, BorderLayout.NORTH);
		panelTaille.add(panelH, BorderLayout.CENTER);
		panelTaille.add(panelL, BorderLayout.SOUTH);
		panelToutT = new JPanel(new BorderLayout());
		panelToutT.add(panelDim, BorderLayout.NORTH);
		panelToutT.add(panelTaille, BorderLayout.SOUTH);
		separ = new JPanel();
		separ.setPreferredSize(new Dimension(20,20));
		this.setLayout(new BorderLayout());
		this.add(panelToutC, BorderLayout.WEST);
		this.add(separ, BorderLayout.SOUTH);
		this.add(panelToutT, BorderLayout.EAST);
	}
	public Color getCouleurF() {
		return choixF;
	}
	// Joueur 1
	public Color getCouleurJ1() {
		return choixJ1;
	}
	// Joueur 2
	public Color getCouleurJ2() {
		return choixJ2;
	}
	// Fond
	public void setCouleurF(int i) {
		listeF.setSelectedIndex(i);
	}
	// Joueur 1
	public void setCouleurJ1(int i) {
		listeJ1.setSelectedIndex(i);
	}
	// Joueur 2
	public void setCouleurJ2(int i) {
		listeJ2.setSelectedIndex(i);
	}
	//Retourne / Affecte le nombre de colonne choisie
	public int getNbC() {
		return nbC = (int) dimension[listeNbC.getSelectedIndex()];
	}
	public void setNbC(int i) {
		nbC =i ;
	}
	public void setSelectedNbC(int i) {
		listeNbC.setSelectedIndex(i);
	}
	//Retourne / Affecte le nombre de ligne choisie
	public int getNbL() {
		return nbL = (int) dimension[listeNbL.getSelectedIndex()];
	}
	public void setNbL(int i) {
		nbL =i ;
	}
	public void setSelectedNbL(int i) {
		listeNbL.setSelectedIndex(i);
	}
	//Retourne / Affecte la hauteur choisie
	public int getHauteur() {
		return hauteur = (int) taille[listeH.getSelectedIndex()];
	}
	public void setHauteur(int i) {
		hauteur =i ;
	}
	//Retourne / Affecte la largeur choisie
	public int getLargeur() {
		return largeur = (int) taille[listeL.getSelectedIndex()];
	}
	public void setLargeur(int i) {
		largeur =i ;
	}
}
