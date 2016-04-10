package Puissance4.ihm;


public class IHM extends javax.swing.JFrame {
    private Puissance4.donnees.Launcher l;

    private java.awt.Font fond1;

    private int hauteur;

    private int largeur;

    private java.awt.Color fond;

    private int nbC;

    private int nbL;

    private javax.swing.JButton couleurGrille;

    private javax.swing.JLabel labelJ1;

    private javax.swing.JLabel labelJ2;

    private javax.swing.JLabel separ;

    private Puissance4.ihm.AffichageGrille grille;

    private javax.swing.JPanel affBas;

    private javax.swing.JLabel pjoueur;

    public IHM(java.lang.String titre ,int largeur ,int hauteur ,int nbL ,int nbC) {
        super(titre);
        init(titre, largeur, hauteur, nbL, nbC, java.awt.Color.CYAN, null);
    }

    public IHM(java.lang.String titre ,int largeur ,int hauteur ,int nbL ,int nbC ,Puissance4.Jeu j) {
        super(titre);
        init(titre, largeur, hauteur, nbL, nbC, java.awt.Color.CYAN, j);
    }

    public IHM(java.lang.String titre ,int largeur ,int hauteur ,int nbL ,int nbC ,java.awt.Color cGrille ,Puissance4.Jeu j) {
        super(titre);
        init(titre, largeur, hauteur, nbL, nbC, cGrille, j);
    }

    public IHM(java.lang.String titre ,int largeur ,int hauteur ,int nbL ,int nbC ,java.awt.Color cGrille) {
        super(titre);
        init(titre, largeur, hauteur, nbL, nbC, cGrille, null);
    }

    public void setCouleurFond(java.awt.Color c) {
        fond = c;
    }

    public void setLauncher(Puissance4.donnees.Launcher a) {
        l = a;
    }

    private void init(java.lang.String titre, int largeur, int hauteur, int nbL, int nbC, java.awt.Color cGrille, Puissance4.Jeu j) {
        grille = new Puissance4.ihm.AffichageGrille(nbC , (nbL + 1) , cGrille , largeur , hauteur , j);
        affBas = new javax.swing.JPanel();
        pjoueur = new javax.swing.JLabel("" , javax.swing.SwingConstants.LEFT);
        fond1 = new java.awt.Font("TimesRoman" , java.awt.Font.BOLD , 18);
        if ((pjoueur != null)) {
            pjoueur.setFont(fond1);
        } 
        javax.swing.JButton stop = null;
        stop = new javax.swing.JButton("Stop");
        javax.swing.JButton recommencer = null;
        recommencer = new javax.swing.JButton("Reset");
        if ((recommencer != null)) {
            recommencer.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent ae) {
                    if ((l) != null) {
                        java.util.concurrent.Semaphore sem = null;
                        if ((l != null)) {
                            sem = l.getSemaphore();
                        } 
                        if ((l != null)) {
                            if (l.isAlive()) {
                                if ((l != null)) {
                                    l.interrupt();
                                } 
                            } 
                        } 
                        l = new Puissance4.donnees.Launcher(l);
                        if ((l != null)) {
                            l.reset();
                        } 
                        java.util.concurrent.Semaphore n = null;
                        n = new java.util.concurrent.Semaphore(0);
                        if ((l != null)) {
                            l.setSemaphore(n);
                        } 
                        if ((l != null)) {
                            l.start();
                        } 
                    } 
                }
            });
        } 
        if ((stop != null)) {
            stop.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent ae) {
                    java.lang.System.exit(0);
                }
            });
        } 
        separ = new javax.swing.JLabel("");
        if ((affBas != null)) {
            affBas.add(recommencer);
        } 
        if ((affBas != null)) {
            affBas.add(separ);
        } 
        if ((affBas != null)) {
            affBas.add(stop);
        } 
        setPreferredSize(new java.awt.Dimension((largeur + 100) , (hauteur + 100)));
        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().add(affBas, java.awt.BorderLayout.SOUTH);
        getContentPane().add(grille, java.awt.BorderLayout.NORTH);
        getContentPane().add(pjoueur, java.awt.BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocation(300, 100);
    }

    public void refresh() {
        if ((grille != null)) {
            grille.refresh();
        } 
    }

    public void clear() {
        if ((grille != null)) {
            grille.clear();
        } 
    }

    public void changerCouleurJetonGrille(java.awt.Color c, int x, int y) {
        if ((grille != null)) {
            grille.changerCouleurJetonGrille(c, x, y);
        } 
    }

    public void raz() {
        if ((grille != null)) {
            grille.clear();
        } 
    }

    public Puissance4.donnees.Launcher getLauncher() {
        return l;
    }

    public void message(java.lang.String s) {
        if ((pjoueur != null)) {
            pjoueur.setText(s);
        } 
        repaint();
    }

    public void afficherMessage(java.lang.String titre, java.lang.String message) {
        javax.swing.JOptionPane.showMessageDialog(this, message, titre, javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
}

