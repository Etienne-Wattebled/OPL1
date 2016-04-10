package Puissance4.ihm;


public class Menu extends javax.swing.JFrame {
    private javax.swing.JButton ok;

    private Puissance4.ihm.ChoixCouleur couleur;

    private Puissance4.ihm.ChoixJoueur joueur;

    private javax.swing.JPanel bouton;

    public Menu(Puissance4.Jeu jeu) {
        super("Paramètres");
        couleur = new Puissance4.ihm.ChoixCouleur();
        couleur.setCouleurF(2);
        couleur.setCouleurJ1(7);
        couleur.setCouleurJ2(6);
        couleur.setSelectedNbC(2);
        couleur.setSelectedNbL(1);
        joueur = new Puissance4.ihm.ChoixJoueur();
        java.awt.event.ActionListener valider = null;
        valider = new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                Puissance4.joueurs.Joueur j1 = null;
                j1 = null;
                Puissance4.joueurs.Joueur j2 = null;
                j2 = null;
                java.awt.Color fond = null;
                fond = couleur.getCouleurF();
                java.awt.Color joueur1 = null;
                joueur1 = couleur.getCouleurJ1();
                java.awt.Color joueur2 = null;
                joueur2 = couleur.getCouleurJ2();
                if (!(((fond != joueur1) && (fond != joueur2)) && (joueur1 != joueur2))) {
                    java.lang.String m = null;
                    m = "Erreur : Choix couleur";
                    afficheMessage(m);
                } else {
                    Puissance4.donnees.Grille g = null;
                    g = new Puissance4.donnees.Grille(couleur.getNbC() , couleur.getNbL() , jeu);
                    if (joueur.isSelectedJ1()) {
                        j1 = new Puissance4.joueurs.Joueur(joueur.getJoueur1() , couleur.getCouleurJ1());
                    } else {
                        j1 = new Puissance4.joueurs.IA(((byte)(joueur.getNiveauJ1())) , joueur.getEvaluationJ1() , couleur.getCouleurJ1() , g , jeu);
                    }
                    if (joueur.isSelectedJ2()) {
                        j2 = new Puissance4.joueurs.Joueur(joueur.getJoueur2() , couleur.getCouleurJ2());
                    } else {
                        j2 = new Puissance4.joueurs.IA(((byte)(joueur.getNiveauJ2())) , joueur.getEvaluationJ2() , couleur.getCouleurJ2() , g , jeu);
                    }
                    Puissance4.ihm.IHM ihm = null;
                    ihm = new Puissance4.ihm.IHM("Puissance 4" , couleur.getLargeur() , couleur.getHauteur() , couleur.getNbL() , couleur.getNbC() , couleur.getCouleurF() , jeu);
                    jeu.setGrille(g);
                    jeu.setIHM(ihm);
                    jeu.setJoueur(j1);
                    jeu.setProchainJoueur(j2);
                    if ((!(j1 instanceof Puissance4.joueurs.IA)) || (!(j2 instanceof Puissance4.joueurs.IA))) {
                        java.util.concurrent.Semaphore sem = null;
                        sem = new java.util.concurrent.Semaphore(0);
                        jeu.setSemaphore(sem);
                    } 
                    Puissance4.donnees.Launcher l = null;
                    l = new Puissance4.donnees.Launcher(jeu);
                    ihm.setLauncher(l);
                    l.start();
                    setVisible(false);
                    dispose();
                }
            }
        };
        ok = new javax.swing.JButton("Valider");
        ok.addActionListener(valider);
        bouton = new javax.swing.JPanel();
        bouton.add(ok);
        getContentPane().add(joueur, java.awt.BorderLayout.NORTH);
        getContentPane().add(couleur, java.awt.BorderLayout.CENTER);
        getContentPane().add(bouton, java.awt.BorderLayout.SOUTH);
        setVisible(true);
        setLocation(100, 100);
        setResizable(false);
        pack();
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }

    public void afficheMessage(java.lang.String m) {
        javax.swing.JOptionPane.showMessageDialog(this, m, "Attention", javax.swing.JOptionPane.WARNING_MESSAGE);
    }
}

