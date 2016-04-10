package Puissance4.ihm;
import Puissance4.*;
import Puissance4.donnees.*;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.util.concurrent.Semaphore;

/** Affichage de la fenetre qui va contenir l'affichage de la grille  **/
public class IHM extends JFrame {
	private Launcher l;
	private Font fond1;
	private int hauteur;
	private int largeur;
	private Color fond;
	private int nbC;
	private int nbL;
	private JButton couleurGrille;
	private JLabel labelJ1, labelJ2,separ;
	private AffichageGrille grille;
	private JPanel affBas;
	private JLabel pjoueur;
	public IHM(String titre, int largeur, int hauteur, int nbL, int nbC) {
		super(titre);
		init(titre, largeur,hauteur,nbL,nbC,Color.CYAN,null);
	}			
	public IHM(String titre, int largeur, int hauteur, int nbL, int nbC, Jeu j) {
		super(titre);
		init(titre, largeur,hauteur,nbL,nbC,Color.CYAN,j);
	}
	public IHM(String titre, int largeur, int hauteur, int nbL, int nbC, Color cGrille, Jeu j) {
		super(titre);
		init(titre, largeur,hauteur,nbL,nbC,cGrille,j);
	}
	public IHM(String titre, int largeur, int hauteur, int nbL, int nbC, Color cGrille) {
		super(titre);
		init(titre, largeur,hauteur,nbL,nbC,cGrille,null);
	}
	public void setCouleurFond(Color c) {
		fond = c;	
	}
	public void setLauncher(Launcher a) {
		l = a;
	}
	private void init(String titre, int largeur, int hauteur, int nbL, int nbC, Color cGrille, Jeu j) {
		grille = new AffichageGrille(nbC,nbL+1,cGrille, largeur, hauteur,j);
		affBas = new JPanel();
		pjoueur = new JLabel("",JLabel.LEFT);
		fond1 = new Font("TimesRoman", Font.BOLD, 18);
		pjoueur.setFont(fond1);	
		JButton stop = new JButton("Stop");
		JButton recommencer = new JButton("Reset");
		recommencer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					if (l != null) {
						Semaphore sem = l.getSemaphore();
						if (l.isAlive()) {
							l.interrupt();
						}
						l = new Launcher(l);
						l.reset();
						Semaphore n = new Semaphore(0);
						l.setSemaphore(n);
						l.start();
					}
				}
		});
		stop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					System.exit(0);
				}
		});
		separ = new JLabel("");
		affBas.add(recommencer);
		affBas.add(separ);
		affBas.add(stop);
		this.setPreferredSize(new Dimension(largeur+100,hauteur+100));
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(affBas, BorderLayout.SOUTH);
		this.getContentPane().add(grille, BorderLayout.NORTH);
		this.getContentPane().add(pjoueur,BorderLayout.CENTER);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setLocation(300,100);
	}
	public void refresh() {
		grille.refresh();
	}
	public void clear() {
		grille.clear();
	}
	public void changerCouleurJetonGrille(Color c, int x, int y) {
		grille.changerCouleurJetonGrille(c,x,y);
	}
	public void raz() {
		grille.clear();
	}
	public Launcher getLauncher() {
		return l;
	}
	public void message(String s) {
		pjoueur.setText(s);
		repaint();
	}
	public void afficherMessage(String titre, String message){
		JOptionPane.showMessageDialog(this,message,titre, JOptionPane.INFORMATION_MESSAGE);
	}
}



