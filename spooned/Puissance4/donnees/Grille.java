package Puissance4.donnees;


public class Grille {
    private Puissance4.donnees.Jeton[][] grille;

    private int[] tab;

    private Puissance4.Jeu jeu;

    public Grille(int nbC ,int nbL ,Puissance4.Jeu jeu) {
        grille = new Puissance4.donnees.Jeton[nbC][nbL];
        tab = new int[nbC];
        initGrilleTab();
        this.jeu = jeu;
    }

    public Grille(Puissance4.donnees.Grille g) {
        this.grille = uneCopieGrille(g);
        this.tab = uneCopieTab(g);
        this.jeu = g.getJeu();
    }

    private Puissance4.donnees.Jeton[][] uneCopieGrille(Puissance4.donnees.Grille g) {
        Puissance4.donnees.Jeton[][] tab = null;
        if ((g != null)) {
            tab = g.getJetons();
        } 
        Puissance4.donnees.Jeton[][] tab2 = null;
        if ((tab != null)) {
            if ((tab != null) && (tab[0] != null)) {
                tab2 = new Puissance4.donnees.Jeton[tab.length][tab[0].length];
            } 
        } 
        int i = 0;
        for (i = 0 ; (tab != null) && (i < (tab.length)) ; i++) {
            int j = 0;
            for (j = 0 ; (tab != null) && (tab[i] != null) && (j < (tab[i].length)) ; j++) {
                if ((tab2 != null)) {
                    if ((tab != null)) {
                        tab2[i][j] = tab[i][j];
                    } 
                } 
            }
        }
        return tab2;
    }

    private int[] uneCopieTab(Puissance4.donnees.Grille g) {
        int[] tab = null;
        if ((g != null)) {
            tab = g.getTab();
        } 
        int[] tab2 = null;
        if ((tab != null)) {
            tab2 = new int[tab.length];
        } 
        int i = 0;
        for (i = 0 ; (tab != null) && (i < (tab.length)) ; i++) {
            if ((tab != null)) {
                tab2[i] = tab[i];
            } 
        }
        return tab2;
    }

    public Puissance4.Jeu getJeu() {
        return jeu;
    }

    public void initGrilleTab() {
        int i = 0;
        for (i = 0 ; i < (grille.length) ; i++) {
            int j = 0;
            for (j = 0 ; (grille != null) && (grille[i] != null) && (j < (grille[i].length)) ; j++) {
                if ((grille != null)) {
                    grille[i][j] = null;
                } 
            }
        }
        for (i = 0 ; i < (grille.length) ; i++) {
            if ((grille != null) && (grille[i] != null)) {
                tab[i] = (grille[i].length) - 1;
            } 
        }
    }

    public int getNbC() {
        return grille.length;
    }

    public int getNbL() {
        return grille[0].length;
    }

    public boolean possibleJouer(int c) {
        return (c < 0) || (c > ((tab.length) - 1)) ? false : (tab[c]) >= 0;
    }

    public boolean possibleJouer(int x, int y) {
        return existeCase(x, y) ? (grille[x][y]) == null : false;
    }

    public boolean grillePleine() {
        return grillePleine(tab);
    }

    public boolean grillePleine(int[] tab2) {
        boolean res = false;
        res = true;
        int i = 0;
        i = 0;
        while ((tab2 != null) && ((i < (tab2.length))) && res) {
            res = (tab2 != null) && ((tab2[i]) == (-1));
            i = i + 1;
        }
        return res;
    }

    private boolean existeCase(int x, int y) {
        return (((x >= 0) && (y >= 0)) && (x < (grille.length))) && (y < (grille[0].length));
    }

    public boolean existeJeton(Puissance4.joueurs.Joueur j, int x, int y) {
        if (!(existeCase(x, y))) {
            return false;
        } else {
            if ((grille != null) && ((grille[x][y]) != null)) {
                Puissance4.donnees.Jeton jet = null;
                if ((grille != null)) {
                    jet = ((Puissance4.donnees.Jeton)(grille[x][y]));
                } 
                return (jet.getJoueur()) == j;
            } else {
                return false;
            }
        }
    }

    public void setJeu(Puissance4.Jeu j) {
        this.jeu = j;
    }

    public void mettreJeton(Puissance4.joueurs.Joueur j, int c) {
        if ((tab != null) && ((tab[c]) >= 0)) {
            if ((grille != null)) {
                if ((tab != null)) {
                    grille[c][tab[c]] = new Puissance4.donnees.Jeton(j);
                } 
            } 
            if ((jeu) != null) {
                if ((jeu != null)) {
                    jeu.setDcj(c);
                } 
                if ((jeu != null)) {
                    if ((tab != null)) {
                        jeu.setDlj(tab[c]);
                    } 
                } 
                if ((jeu != null)) {
                    if ((j != null)) {
                        if ((tab != null)) {
                            jeu.afficherJeton(j.getCouleur(), c, tab[c]);
                        } 
                    } 
                } 
                if ((jeu != null)) {
                    jeu.refreshAffichage();
                } 
            } 
            if ((tab != null)) {
                tab[c] = (tab[c]) - 1;
            } 
        } 
    }

    public void enleverJeton(int c) {
        if ((grille != null) && (grille[0] != null)) {
            if ((tab != null) && ((tab[c]) < ((grille[0].length) - 1))) {
                if ((tab != null)) {
                    tab[c] = (tab[c]) + 1;
                } 
                if ((jeu) != null) {
                    if ((jeu != null)) {
                        if ((tab != null)) {
                            jeu.afficherJeton(java.awt.Color.WHITE, c, tab[c]);
                        } 
                    } 
                    if ((jeu != null)) {
                        jeu.refreshAffichage();
                    } 
                } 
                if ((grille != null)) {
                    if ((tab != null)) {
                        grille[c][tab[c]] = null;
                    } 
                } 
            } 
        } 
    }

    public void jouer(Puissance4.joueurs.Joueur j, int c) {
        int x = 0;
        x = c;
        int y = 0;
        y = 0;
        if ((tab != null)) {
            tab[c] = (tab[c]) - 1;
        } 
        if ((grille != null)) {
            grille[x][y] = new Puissance4.donnees.Jeton(j);
        } 
        while (possibleJouer(x, (y + 1))) {
            if ((grille != null)) {
                if ((grille != null)) {
                    grille[x][(y + 1)] = grille[x][y];
                } 
            } 
            if ((grille != null)) {
                grille[x][y] = null;
            } 
            y = y + 1;
        }
        if ((jeu) != null) {
            if ((jeu != null)) {
                jeu.setDcj(x);
            } 
            if ((jeu != null)) {
                jeu.setDlj(y);
            } 
            if ((jeu != null)) {
                if ((j != null)) {
                    jeu.afficherJeton(j.getCouleur(), x, y);
                } 
            } 
            if ((jeu != null)) {
                jeu.refreshAffichage();
            } 
        } 
    }

    public Puissance4.donnees.Jeton getJeton(int x, int y) {
        return grille[x][y];
    }

    public Puissance4.donnees.Jeton[][] getJetons() {
        return grille;
    }

    public int[] getTab() {
        return tab;
    }

    public int getIemeTab(int i) {
        return tab[i];
    }
}

