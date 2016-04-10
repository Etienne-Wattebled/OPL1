package Puissance4.ihm;

import javax.swing.*;                       
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Semaphore;
import Puissance4.*;
import Puissance4.joueurs.*;
import Puissance4.donnees.*;

public class Menu extends JFrame {
	private JButton ok;
	private ChoixCouleur couleur;
	private ChoixJoueur joueur;
	private JPanel bouton;
	
	public Menu(Jeu jeu) {
		super("Param\u00e8tres");
		couleur = new ChoixCouleur();
		couleur.setCouleurF(2);
		couleur.setCouleurJ1(7);
		couleur.setCouleurJ2(6);
		couleur.setSelectedNbC(2);
		couleur.setSelectedNbL(1);
		joueur = new ChoixJoueur();
		
		ActionListener valider = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Joueur j1 = null;
				Joueur j2 = null;
				Color fond = couleur.getCouleurF();
				Color joueur1 = couleur.getCouleurJ1();
				Color joueur2 = couleur.getCouleurJ2();
				//Les conditions concernant les couleurs
				if (!(((fond != joueur1) && (fond != joueur2) && (joueur1 != joueur2)))) { 
					String m = "Erreur : Choix couleur";
					afficheMessage(m);
				}
				else {
					//Les conditions concernant les joueurs
					Grille g = new Grille(couleur.getNbC(),couleur.getNbL(),jeu);
					if(joueur.isSelectedJ1()) {
						j1 = new Joueur(joueur.getJoueur1(),couleur.getCouleurJ1());
					}
					else {	
						j1 = new IA((byte)joueur.getNiveauJ1(),joueur.getEvaluationJ1(),couleur.getCouleurJ1(),g,jeu);
					}
					if(joueur.isSelectedJ2()) {
						j2 = new Joueur(joueur.getJoueur2(),couleur.getCouleurJ2());
					}
					else {	
						j2 = new IA((byte)joueur.getNiveauJ2(),joueur.getEvaluationJ2(),couleur.getCouleurJ2(),g,jeu);
					}
					IHM ihm = new IHM("Puissance 4",couleur.getLargeur(), couleur.getHauteur(), couleur.getNbL(), couleur.getNbC(),couleur.getCouleurF(),jeu);
					jeu.setGrille(g);
					jeu.setIHM(ihm);
					jeu.setJoueur(j1);
					jeu.setProchainJoueur(j2);
					if (!(j1 instanceof IA) || !(j2 instanceof IA)) {
						Semaphore sem = new Semaphore(0);
						jeu.setSemaphore(sem);
					}
					Launcher l = new Launcher(jeu);
					ihm.setLauncher(l);
					l.start();
					setVisible(false);
					dispose();
				}
			}              
		};
		ok = new JButton("Valider");
		ok.addActionListener(valider);
		
		bouton = new JPanel();
		bouton.add(ok);
		
		this.getContentPane().add(joueur, BorderLayout.NORTH);
		this.getContentPane().add(couleur, BorderLayout.CENTER);
		this.getContentPane().add(bouton, BorderLayout.SOUTH);
		this.setVisible(true);
		this.setLocation(100,100);
		this.setResizable(false);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	public void afficheMessage(String m){
		JOptionPane.showMessageDialog(this,m,"Attention", JOptionPane.WARNING_MESSAGE);
	}
}
