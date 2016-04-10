package Puissance4.ihm;


public class AffichageJeton extends javax.swing.JPanel {
    private java.awt.Color couleur;

    private java.awt.Color couleurFond;

    private int x;

    private int y;

    public AffichageJeton(int w ,int h) {
        init(java.awt.Color.WHITE, java.awt.Color.CYAN, w, h);
    }

    public AffichageJeton(int w ,int h ,java.awt.Color c ,java.awt.Color c2) {
        init(c, c2, w, h);
    }

    private void init(java.awt.Color couleur, java.awt.Color couleurFond, int w, int h) {
        this.x = w;
        this.y = h;
        setPreferredSize(new java.awt.Dimension(w , h));
        setVisible(true);
        this.couleur = couleur;
        this.couleurFond = couleurFond;
        if ((couleurFond != null)) {
            setBackground(couleurFond);
        } 
    }

    public void paintComponent(java.awt.Graphics g) {
        if ((super != null)) {
            super.paintComponent(g);
        } 
        if ((g != null)) {
            g.setColor(couleur);
        } 
        if ((g != null)) {
            g.fillOval(10, 10, ((x) - 20), ((y) - 20));
        } 
    }

    public void changerCouleur(java.awt.Color c) {
        couleur = c;
        repaint();
    }

    public void changerCouleurFond(java.awt.Color c) {
        if ((c != null)) {
            setBackground(c);
        } 
        repaint();
    }
}

