package Puissance4.ihm;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

/** Affichage du jeton **/
public class AffichageJeton extends JPanel {
	private Color couleur; 
	private Color couleurFond;
	private int x,y;
	public AffichageJeton(int w, int h) {
		init(Color.WHITE,Color.CYAN,w,h);
	}
	public AffichageJeton(int w, int h, Color c, Color c2) {
		init(c,c2,w,h);
	}
	private void init(Color couleur, Color couleurFond, int w, int h) {
		this.x = w;
		this.y = h;
		this.setPreferredSize(new Dimension(w,h));
		this.setVisible(true);
		this.couleur = couleur;
		this.couleurFond = couleurFond;
		this.setBackground(couleurFond);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(couleur);
		g.fillOval(10,10,x-20,y-20);
	} 
	public void changerCouleur(Color c) {
		couleur = c;
		this.repaint();
	}
	public void changerCouleurFond(Color c) {
		this.setBackground(c);
		this.repaint();
	}	
}
