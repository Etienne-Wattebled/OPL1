package Puissance4.ihm;


public class PremiereFenetre extends javax.swing.JFrame {
    private javax.swing.JLabel principeJeu;

    private javax.swing.JLabel suite;

    private javax.swing.JLabel suite2;

    private javax.swing.JLabel haut;

    private javax.swing.JButton jouer;

    private javax.swing.JButton quitter;

    private javax.swing.JPanel affichage;

    private javax.swing.JPanel bouton;

    private javax.swing.JPanel panelHaut;

    private java.awt.Font fond;

    private java.awt.Font fond1;

    public PremiereFenetre(Puissance4.Jeu jeu) {
        super("Jouer au Puissance 4");
        haut = new javax.swing.JLabel();
        principeJeu = new javax.swing.JLabel("  ****  Principe du Jeu  ****  " , javax.swing.SwingConstants.CENTER);
        suite = new javax.swing.JLabel("          Le jeu consiste à aligner 4 pions de même couleur pour gagner.          " , javax.swing.SwingConstants.CENTER);
        suite2 = new javax.swing.JLabel("          Sur ce, bon jeu et bon courage          " , javax.swing.SwingConstants.CENTER);
        fond = new java.awt.Font("TimesRoman" , java.awt.Font.BOLD , 18);
        fond1 = new java.awt.Font("TimesRoman" , java.awt.Font.PLAIN , 18);
        principeJeu.setFont(fond);
        suite.setFont(fond1);
        suite2.setFont(fond1);
        java.awt.event.ActionListener fenetre2 = null;
        fenetre2 = new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                setVisible(false);
                Puissance4.ihm.Menu menu = null;
                menu = new Puissance4.ihm.Menu(jeu);
                dispose();
            }
        };
        jouer = new javax.swing.JButton("Jouer");
        jouer.addActionListener(fenetre2);
        java.awt.event.ActionListener quitterJeu = null;
        quitterJeu = new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                java.lang.System.exit(0);
            }
        };
        quitter = new javax.swing.JButton("Quitter");
        quitter.addActionListener(quitterJeu);
        affichage = new javax.swing.JPanel();
        affichage.setLayout(new java.awt.BorderLayout());
        affichage.add(principeJeu, java.awt.BorderLayout.NORTH);
        affichage.add(suite, java.awt.BorderLayout.CENTER);
        affichage.add(suite2, java.awt.BorderLayout.SOUTH);
        bouton = new javax.swing.JPanel();
        bouton.add(jouer);
        bouton.add(quitter);
        panelHaut = new javax.swing.JPanel();
        panelHaut.setBackground(new java.awt.Color(169 , 234 , 254));
        affichage.setBackground(new java.awt.Color(169 , 234 , 254));
        bouton.setBackground(new java.awt.Color(169 , 234 , 254));
        getContentPane().add(panelHaut, java.awt.BorderLayout.NORTH);
        getContentPane().add(affichage, java.awt.BorderLayout.CENTER);
        getContentPane().add(bouton, java.awt.BorderLayout.SOUTH);
        setLocation(300, 400);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
    }
}

