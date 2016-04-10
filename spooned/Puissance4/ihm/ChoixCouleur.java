package Puissance4.ihm;


public class ChoixCouleur extends javax.swing.JPanel {
    private javax.swing.JComboBox<java.lang.String> listeF;

    private javax.swing.JComboBox<java.lang.String> listeJ1;

    private javax.swing.JComboBox<java.lang.String> listeJ2;

    private javax.swing.JComboBox<java.lang.Integer> listeNbC;

    private javax.swing.JComboBox<java.lang.Integer> listeNbL;

    private javax.swing.JComboBox<java.lang.Integer> listeH;

    private javax.swing.JComboBox<java.lang.Integer> listeL;

    private java.lang.String[] textCouleur;

    private java.awt.Color[] couleur;

    private java.lang.Integer[] taille;

    private java.lang.Integer[] dimension;

    private javax.swing.JLabel labelF;

    private javax.swing.JLabel labelJ1;

    private javax.swing.JLabel labelJ2;

    private javax.swing.JLabel labelNbC;

    private javax.swing.JLabel labelNbL;

    private javax.swing.JLabel labelDim;

    private javax.swing.JLabel labelTaille;

    private javax.swing.JLabel labelH;

    private javax.swing.JLabel labelL;

    private Puissance4.ihm.AffichageJeton jetonJ1;

    private Puissance4.ihm.AffichageJeton jetonJ2;

    private java.awt.Color choixF;

    private java.awt.Color choixJ1;

    private java.awt.Color choixJ2;

    private javax.swing.JPanel panelF;

    private javax.swing.JPanel panelJ1;

    private javax.swing.JPanel panelJ2;

    private javax.swing.JPanel panelJetons;

    private javax.swing.JPanel panelToutC;

    private javax.swing.JPanel panel;

    private javax.swing.JPanel separ;

    private javax.swing.JPanel panelNbC;

    private javax.swing.JPanel panelNbL;

    private javax.swing.JPanel panelH;

    private javax.swing.JPanel panelL;

    private javax.swing.JPanel panelTaille;

    private javax.swing.JPanel panelDim;

    private javax.swing.JPanel panelToutT;

    private java.awt.Font fond;

    private java.awt.Font fond1;

    private int nbC;

    private int nbL;

    private int hauteur;

    private int largeur;

    public ChoixCouleur() {
        fond1 = new java.awt.Font("TimesRoman" , java.awt.Font.BOLD , 18);
        fond = new java.awt.Font("TimesRoman" , java.awt.Font.PLAIN , 17);
        textCouleur = new java.lang.String[]{ "Bleu" , "Vert" , "Cyan" , "Magenta" , "Orange" , "Rose" , "Jaune" , "Rouge" , "Noir" , "Violet" , "Gris" };
        couleur = new java.awt.Color[]{ new java.awt.Color(44 , 117 , 255) , new java.awt.Color(87 , 213 , 59) , java.awt.Color.CYAN , java.awt.Color.MAGENTA , new java.awt.Color(255 , 162 , 43) , new java.awt.Color(255 , 103 , 216) , java.awt.Color.YELLOW , java.awt.Color.RED , new java.awt.Color(19 , 14 , 10) , new java.awt.Color(136 , 6 , 206) , new java.awt.Color(175 , 175 , 175) };
        taille = new java.lang.Integer[]{ 500 , 600 , 700 , 800 , 900 , 100 };
        dimension = new java.lang.Integer[]{ 5 , 6 , 7 , 8 , 9 , 10 , 11 , 12 , 13 , 14 , 15 };
        jetonJ1 = new Puissance4.ihm.AffichageJeton(120 , 120);
        jetonJ2 = new Puissance4.ihm.AffichageJeton(120 , 120);
        labelF = new javax.swing.JLabel("Choix de la couleur de fond" , javax.swing.SwingConstants.CENTER);
        labelJ1 = new javax.swing.JLabel("Joueur 1" , javax.swing.SwingConstants.CENTER);
        labelJ2 = new javax.swing.JLabel("Joueur 2" , javax.swing.SwingConstants.CENTER);
        labelF.setFont(fond1);
        labelJ1.setFont(fond);
        labelJ2.setFont(fond);
        listeF = new javax.swing.JComboBox<java.lang.String>(textCouleur);
        listeJ1 = new javax.swing.JComboBox<java.lang.String>(textCouleur);
        listeJ2 = new javax.swing.JComboBox<java.lang.String>(textCouleur);
        labelDim = new javax.swing.JLabel("Choix de la dimension du jeu" , javax.swing.SwingConstants.CENTER);
        labelDim.setFont(fond1);
        labelNbL = new javax.swing.JLabel("Nombre de lignes");
        labelNbL.setFont(fond);
        labelNbC = new javax.swing.JLabel("Nombre de colonnes");
        labelNbC.setFont(fond);
        labelTaille = new javax.swing.JLabel("Choix de la taille de la fenêtre" , javax.swing.SwingConstants.CENTER);
        labelTaille.setFont(fond1);
        labelH = new javax.swing.JLabel("Hauteur");
        labelH.setFont(fond);
        labelL = new javax.swing.JLabel("Largeur");
        labelL.setFont(fond);
        listeNbC = new javax.swing.JComboBox<java.lang.Integer>(dimension);
        listeNbL = new javax.swing.JComboBox<java.lang.Integer>(dimension);
        listeH = new javax.swing.JComboBox<java.lang.Integer>(taille);
        listeL = new javax.swing.JComboBox<java.lang.Integer>(taille);
        java.awt.event.ActionListener ChoixF = null;
        ChoixF = new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                choixF = couleur[listeF.getSelectedIndex()];
                jetonJ1.changerCouleurFond(couleur[listeF.getSelectedIndex()]);
                jetonJ2.changerCouleurFond(couleur[listeF.getSelectedIndex()]);
            }
        };
        java.awt.event.ActionListener ChoixJ1 = null;
        ChoixJ1 = new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                choixJ1 = couleur[listeJ1.getSelectedIndex()];
                jetonJ1.changerCouleur(couleur[listeJ1.getSelectedIndex()]);
            }
        };
        java.awt.event.ActionListener ChoixJ2 = null;
        ChoixJ2 = new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                choixJ2 = couleur[listeJ2.getSelectedIndex()];
                jetonJ2.changerCouleur(couleur[listeJ2.getSelectedIndex()]);
            }
        };
        listeF.addActionListener(ChoixF);
        listeJ1.addActionListener(ChoixJ1);
        listeJ2.addActionListener(ChoixJ2);
        panelF = new javax.swing.JPanel(new java.awt.BorderLayout());
        panelF.add(labelF, java.awt.BorderLayout.NORTH);
        panelF.add(listeF, java.awt.BorderLayout.SOUTH);
        panelJ1 = new javax.swing.JPanel(new java.awt.BorderLayout());
        panelJ1.add(labelJ1, java.awt.BorderLayout.NORTH);
        panelJ1.add(jetonJ1, java.awt.BorderLayout.CENTER);
        panelJ1.add(listeJ1, java.awt.BorderLayout.SOUTH);
        panelJ2 = new javax.swing.JPanel(new java.awt.BorderLayout());
        panelJ2.add(labelJ2, java.awt.BorderLayout.NORTH);
        panelJ2.add(jetonJ2, java.awt.BorderLayout.CENTER);
        panelJ2.add(listeJ2, java.awt.BorderLayout.SOUTH);
        panelJetons = new javax.swing.JPanel(new java.awt.BorderLayout());
        panelJetons.add(panelJ1, java.awt.BorderLayout.WEST);
        panelJetons.add(panelJ2, java.awt.BorderLayout.EAST);
        panel = new javax.swing.JPanel();
        panel.setPreferredSize(new java.awt.Dimension(20 , 20));
        panelToutC = new javax.swing.JPanel(new java.awt.BorderLayout());
        panelToutC.add(panelF, java.awt.BorderLayout.NORTH);
        panelToutC.add(panel, java.awt.BorderLayout.CENTER);
        panelToutC.add(panelJetons, java.awt.BorderLayout.SOUTH);
        panelNbC = new javax.swing.JPanel();
        panelNbC.add(listeNbC);
        panelNbC.add(labelNbC);
        panelNbL = new javax.swing.JPanel();
        panelNbL.add(listeNbL);
        panelNbL.add(labelNbL);
        panelDim = new javax.swing.JPanel(new java.awt.BorderLayout());
        panelDim.add(labelDim, java.awt.BorderLayout.NORTH);
        panelDim.add(panelNbC, java.awt.BorderLayout.CENTER);
        panelDim.add(panelNbL, java.awt.BorderLayout.SOUTH);
        panelH = new javax.swing.JPanel();
        panelH.add(listeH);
        panelH.add(labelH);
        panelL = new javax.swing.JPanel();
        panelL.add(listeL);
        panelL.add(labelL);
        panelTaille = new javax.swing.JPanel(new java.awt.BorderLayout());
        panelTaille.add(labelTaille, java.awt.BorderLayout.NORTH);
        panelTaille.add(panelH, java.awt.BorderLayout.CENTER);
        panelTaille.add(panelL, java.awt.BorderLayout.SOUTH);
        panelToutT = new javax.swing.JPanel(new java.awt.BorderLayout());
        panelToutT.add(panelDim, java.awt.BorderLayout.NORTH);
        panelToutT.add(panelTaille, java.awt.BorderLayout.SOUTH);
        separ = new javax.swing.JPanel();
        separ.setPreferredSize(new java.awt.Dimension(20 , 20));
        setLayout(new java.awt.BorderLayout());
        add(panelToutC, java.awt.BorderLayout.WEST);
        add(separ, java.awt.BorderLayout.SOUTH);
        add(panelToutT, java.awt.BorderLayout.EAST);
    }

    public java.awt.Color getCouleurF() {
        return choixF;
    }

    public java.awt.Color getCouleurJ1() {
        return choixJ1;
    }

    public java.awt.Color getCouleurJ2() {
        return choixJ2;
    }

    public void setCouleurF(int i) {
        if ((listeF != null)) {
            listeF.setSelectedIndex(i);
        } 
    }

    public void setCouleurJ1(int i) {
        if ((listeJ1 != null)) {
            listeJ1.setSelectedIndex(i);
        } 
    }

    public void setCouleurJ2(int i) {
        if ((listeJ2 != null)) {
            listeJ2.setSelectedIndex(i);
        } 
    }

    public int getNbC() {
        return nbC = ((int)(dimension[listeNbC.getSelectedIndex()]));
    }

    public void setNbC(int i) {
        nbC = i;
    }

    public void setSelectedNbC(int i) {
        if ((listeNbC != null)) {
            listeNbC.setSelectedIndex(i);
        } 
    }

    public int getNbL() {
        return nbL = ((int)(dimension[listeNbL.getSelectedIndex()]));
    }

    public void setNbL(int i) {
        nbL = i;
    }

    public void setSelectedNbL(int i) {
        if ((listeNbL != null)) {
            listeNbL.setSelectedIndex(i);
        } 
    }

    public int getHauteur() {
        return hauteur = ((int)(taille[listeH.getSelectedIndex()]));
    }

    public void setHauteur(int i) {
        hauteur = i;
    }

    public int getLargeur() {
        return largeur = ((int)(taille[listeL.getSelectedIndex()]));
    }

    public void setLargeur(int i) {
        largeur = i;
    }
}

