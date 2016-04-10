package Puissance4.ihm;


public class AffichageGrille extends javax.swing.JPanel {
    private Puissance4.Jeu jeu;

    private java.awt.Color cGrille;

    private int nbC;

    private int nbL;

    private javax.swing.JPanel grille;

    private int hauteur;

    private int largeur;

    private int c = 0;

    public AffichageGrille(int nombreColonnes ,int nombreLignes ,java.awt.Color cGrille ,int largeur ,int hauteur ,Puissance4.Jeu j) {
        init(nombreColonnes, nombreLignes, cGrille, largeur, hauteur, j);
    }

    public AffichageGrille(int nombreColonnes ,int nombreLignes ,java.awt.Color cGrille ,int largeur ,int hauteur) {
        init(nombreColonnes, nombreLignes, cGrille, largeur, hauteur, null);
    }

    private void init(int nombreColonnes, int nombreLignes, java.awt.Color cGrille, int largeur, int hauteur, Puissance4.Jeu j) {
        setVisible(true);
        setPreferredSize(new java.awt.Dimension(largeur , hauteur));
        this.jeu = j;
        this.nbC = nombreColonnes;
        this.nbL = nombreLignes;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.cGrille = cGrille;
        int i;
        grille = new javax.swing.JPanel();
        if ((grille != null)) {
            grille.setLayout(new java.awt.GridLayout(nbL , nbC));
        } 
        Puissance4.ihm.AffichageJeton case2;
        for (i = 0 ; i < (nbC) ; i++) {
            case2 = new Puissance4.ihm.AffichageJeton((((int)(largeur)) / (nbC)) , (((int)(hauteur)) / (nbL)) , java.awt.Color.WHITE , java.awt.Color.WHITE);
            if ((grille != null)) {
                grille.add(case2);
            } 
        }
        for (i = 0 ; i < (((nbC) * (nbL)) - (nbC)) ; i++) {
            case2 = new Puissance4.ihm.AffichageJeton((((int)(largeur)) / (nbC)) , (((int)(hauteur)) / (nbL)) , java.awt.Color.WHITE , cGrille);
            if ((grille != null)) {
                grille.add(case2);
            } 
        }
        if ((grille != null)) {
            grille.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent e) {
                    Puissance4.joueurs.Joueur j = null;
                    if ((jeu != null)) {
                        j = jeu.getJoueurHumainJouer();
                    } 
                    if ((jeu) != null) {
                        if ((jeu != null)) {
                            if ((e != null)) {
                                jeu.jouer(j, ((int)((e.getX()) / (((getLargeur()) / (nbC)) + 10))));
                            } 
                        } 
                    } 
                }
            });
        } 
        if ((grille != null)) {
            grille.addMouseMotionListener(new java.awt.event.MouseMotionListener() {
                int c = 0;

                private boolean xDansPanel(java.awt.event.MouseEvent e) {
                    return ((e.getX()) > 0) && ((e.getX()) < (getLargeur()));
                }

                public void mouseMoved(java.awt.event.MouseEvent e) {
                    int souris = 0;
                    if ((e != null)) {
                        souris = ((int)((e.getX()) / (((getLargeur()) / (nbC)) + 10)));
                    } 
                    if ((e != null) && (((c) != souris) && (xDansPanel(e)))) {
                        Puissance4.joueurs.Joueur j = null;
                        if ((jeu != null)) {
                            j = jeu.getJoueurHumainJouer();
                        } 
                        if (j != null) {
                            if ((java.awt.Color.WHITE != null)) {
                                changerCouleurJetonHaut(java.awt.Color.WHITE, c);
                            } 
                            if ((j != null) && (j.getCouleur() != null)) {
                                changerCouleurJetonHaut(j.getCouleur(), souris);
                            } 
                            c = souris;
                        } 
                    } 
                }

                public void mouseDragged(java.awt.event.MouseEvent e) {
                }
            });
        } 
        setLayout(new java.awt.BorderLayout());
        if ((grille != null)) {
            add(grille, java.awt.BorderLayout.CENTER);
        } 
    }

    private int conv(int x, int y, int nbC) {
        return (y * nbC) + x;
    }

    private void changerCouleur(java.awt.Color c, int x, int y) {
        java.awt.Component[] composants = null;
        if ((grille != null)) {
            composants = grille.getComponents();
        } 
        int a = 0;
        a = conv(x, y, nbC);
        javax.swing.JPanel jp = null;
        if ((composants != null)) {
            jp = ((javax.swing.JPanel)(composants[a]));
        } 
        if (jp instanceof Puissance4.ihm.AffichageJeton) {
            Puissance4.ihm.AffichageJeton aff = null;
            aff = ((Puissance4.ihm.AffichageJeton)(jp));
            if ((aff != null)) {
                aff.changerCouleur(c);
            } 
        } 
    }

    public void changerCouleurJetonHaut(java.awt.Color c, int x) {
        if ((x >= 0) && (x < (nbC))) {
            if ((c != null)) {
                changerCouleur(c, x, 0);
            } 
        } 
    }

    public void changerCouleurJetonGrille(java.awt.Color c, int x, int y) {
        if ((((x >= 0) && (x < (nbC))) && ((y + 1) >= 0)) && ((y + 1) < (nbL))) {
            if ((c != null)) {
                changerCouleur(c, x, (y + 1));
            } 
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
        Puissance4.ihm.AffichageJeton a;
        java.awt.Component[] composants = null;
        if ((grille != null)) {
            composants = grille.getComponents();
        } 
        int i = 0;
        for (i = 0 ; (composants != null) && (i < (composants.length)) ; i++) {
            if ((composants != null) && ((composants[i]) instanceof Puissance4.ihm.AffichageJeton)) {
                if ((composants != null)) {
                    a = ((Puissance4.ihm.AffichageJeton)(composants[i]));
                } 
                if ((a != null)) {
                    a.changerCouleur(java.awt.Color.white);
                } 
                if ((a != null)) {
                    a.repaint();
                } 
            } 
        }
    }

    public void refresh() {
        Puissance4.ihm.AffichageJeton a;
        java.awt.Component[] composants = null;
        if ((grille != null)) {
            composants = grille.getComponents();
        } 
        int i = 0;
        for (i = 0 ; (composants != null) && (i < (composants.length)) ; i++) {
            if ((composants != null) && ((composants[i]) instanceof Puissance4.ihm.AffichageJeton)) {
                if ((composants != null)) {
                    a = ((Puissance4.ihm.AffichageJeton)(composants[i]));
                } 
                if ((a != null)) {
                    a.repaint();
                } 
            } 
        }
    }
}

