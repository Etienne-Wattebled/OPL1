package Puissance4.ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Semaphore;
import Puissance4.*;
import Puissance4.joueurs.*;
import Puissance4.donnees.*;

public class PremiereFenetre extends JFrame {
	private JLabel principeJeu, suite, suite2, haut;
	private JButton jouer, quitter;
	private JPanel affichage, bouton, panelHaut;
	private Font fond, fond1;
	
	public PremiereFenetre(Jeu jeu) {
		super("Jouer au Puissance 4");
		haut = new JLabel();
		principeJeu = new JLabel("  ****  Principe du Jeu  ****  ", JLabel.CENTER);
		suite = new JLabel("          Le jeu consiste \u00e0 aligner 4 pions de m\u00eame couleur pour gagner.          ", JLabel.CENTER);
		suite2 = new JLabel("          Sur ce, bon jeu et bon courage          ", JLabel.CENTER);
		
		fond = new Font("TimesRoman", Font.BOLD, 18);
		fond1 = new Font("TimesRoman", Font.PLAIN, 18);
		principeJeu.setFont(fond);
		suite.setFont(fond1);
		suite2.setFont(fond1);
		
		// Quand l'utilisateur cliquera sur jouer
		ActionListener fenetre2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Menu menu = new Menu(jeu);		
				dispose();			
			}
		};
		jouer = new JButton("Jouer");
		jouer.addActionListener(fenetre2);
		
		
		// Quand l'utilisateur cliquera sur quitter
		ActionListener quitterJeu = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		quitter = new JButton("Quitter");
		quitter.addActionListener(quitterJeu);
		
		affichage = new JPanel();
		affichage.setLayout(new BorderLayout());
		affichage.add(principeJeu, BorderLayout.NORTH);
		affichage.add(suite, BorderLayout.CENTER);
		affichage.add(suite2, BorderLayout.SOUTH);
		
		bouton = new JPanel();
		bouton.add(jouer);
		bouton.add(quitter);
		
		panelHaut = new JPanel();
		panelHaut.setBackground(new Color(169, 234, 254));
		affichage.setBackground(new Color(169, 234, 254));
		bouton.setBackground(new Color(169, 234, 254));
		
		this.getContentPane().add(panelHaut, BorderLayout.NORTH);
		this.getContentPane().add(affichage, BorderLayout.CENTER);
		this.getContentPane().add(bouton, BorderLayout.SOUTH);
		this.setLocation(300,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
	}
}
