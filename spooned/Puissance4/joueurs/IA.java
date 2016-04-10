package Puissance4.joueurs;


public class IA extends Puissance4.joueurs.Joueur implements java.lang.Runnable {
    private byte profondeur;

    private Puissance4.donnees.Grille g;

    private int nivEvaluation;

    private Puissance4.Jeu jeu;

    public IA(byte prof ,int nivEvaluation ,java.awt.Color couleur ,Puissance4.donnees.Grille g ,Puissance4.Jeu j) {
        super("Ordinateur", 0, couleur);
        this.profondeur = prof;
        this.g = g;
        this.nivEvaluation = nivEvaluation;
        this.jeu = j;
    }

    public void run() {
    }

    public int jouer(int dcj, int dlj) {
        return alphabeta(profondeur, dcj, dlj);
    }

    public int evaluation(Puissance4.donnees.Grille grille, int dcj, int dlj) {
        if ((nivEvaluation) == 1) {
            return (gagner(100000, grille, dcj, dlj)) + ((int)(((java.lang.Math.random()) * 20)));
        } else {
            return 0;
        }
    }

    public int gagner(int p, Puissance4.donnees.Grille grille, int dcj, int dlj) {
        if ((jeu != null)) {
            if (jeu.gagner(this, grille, dcj, dlj)) {
                return p;
            } else {
                if ((jeu != null)) {
                    if ((jeu != null)) {
                        if (jeu.gagner(jeu.getProchainJoueur(), grille, dcj, dlj)) {
                            return -p;
                        } else {
                            return 0;
                        }
                    } 
                } 
            }
        } 
    }

    public int nbPieges(Puissance4.joueurs.Joueur joueur, int p, Puissance4.donnees.Jeton[][] g) {
        boolean ok = false;
        ok = false;
        int compteur = 0;
        compteur = 0;
        int i;
        int j;
        for (i = 0 ; (g != null) && (i < (g.length)) ; i++) {
            for (j = 0 ; (g != null) && (g[0] != null) && (j < (g[0].length)) ; j++) {
                ok = false;
                if ((g != null) && ((g[i][j]) == null)) {
                    if ((i - 3) >= 0) {
                        if (((g != null) && (((g[(i - 3)][j]) != null)) && (g != null) && (((g[(i - 2)][j]) != null))) && (g != null) && (((g[(i - 1)][j]) != null))) {
                            if (((g != null) && (((g[(i - 3)][j].getJoueur()) == joueur)) && (g != null) && (((g[(i - 2)][j].getJoueur()) == joueur))) && (g != null) && (((g[(i - 1)][j].getJoueur()) == joueur))) {
                                ok = true;
                            } 
                        } 
                    } 
                    if ((g != null)) {
                        if ((i + 3) <= ((g.length) - 1)) {
                            if (((g != null) && (((g[(i + 3)][j]) != null)) && (g != null) && (((g[(i + 2)][j]) != null))) && (g != null) && (((g[(i + 1)][j]) != null))) {
                                if (((g != null) && (((g[(i + 3)][j].getJoueur()) == joueur)) && (g != null) && (((g[(i + 2)][j].getJoueur()) == joueur))) && (g != null) && (((g[(i + 1)][j].getJoueur()) == joueur))) {
                                    ok = true;
                                } 
                            } 
                        } 
                    } 
                } 
                if (ok) {
                    ok = false;
                    if ((g != null) && (g[i] != null)) {
                        if ((j + 4) <= ((g[i].length) - 1)) {
                            if ((g != null) && ((g[i][(j + 1)]) == null)) {
                                if ((i - 3) >= 0) {
                                    if (((g != null) && (((g[(i - 1)][(j + 2)]) != null)) && (g != null) && (((g[(i - 2)][(j + 3)]) != null))) && (g != null) && (((g[(i - 3)][(j + 4)]) != null))) {
                                        if (((g != null) && (((g[(i - 1)][(j + 2)].getJoueur()) == joueur)) && (g != null) && (((g[(i - 2)][(j + 3)].getJoueur()) == joueur))) && (g != null) && (((g[(i - 3)][(j + 4)].getJoueur()) == joueur))) {
                                            ok = true;
                                        } 
                                    } 
                                } 
                                if ((g != null)) {
                                    if ((i + 3) <= ((g.length) - 1)) {
                                        if (((g != null) && (((g[(i + 1)][(j + 2)]) != null)) && (g != null) && (((g[(i + 2)][(j + 3)]) != null))) && (g != null) && (((g[(i + 3)][(j + 4)]) != null))) {
                                            if (((g != null) && (((g[(i + 1)][(j + 2)].getJoueur()) == joueur)) && (g != null) && (((g[(i + 2)][(j + 3)].getJoueur()) == joueur))) && (g != null) && (((g[(i + 3)][(j + 4)].getJoueur()) == joueur))) {
                                                ok = true;
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                    if ((j - 4) >= 0) {
                        if ((g != null) && ((g[i][(j - 1)]) == null)) {
                            if ((i - 3) >= 0) {
                                if (((g != null) && (((g[(i - 1)][(j - 2)]) != null)) && (g != null) && (((g[(i - 2)][(j - 3)]) != null))) && (g != null) && (((g[(i - 3)][(j - 4)]) != null))) {
                                    if (((g != null) && (((g[(i - 1)][(j - 2)].getJoueur()) == joueur)) && (g != null) && (((g[(i - 2)][(j - 3)].getJoueur()) == joueur))) && (g != null) && (((g[(i - 3)][(j - 4)].getJoueur()) == joueur))) {
                                        ok = true;
                                    } 
                                } 
                            } 
                            if ((g != null)) {
                                if ((i + 3) <= ((g.length) - 1)) {
                                    if (((g != null) && (((g[(i + 1)][(j - 2)]) != null)) && (g != null) && (((g[(i + 2)][(j - 3)]) != null))) && (g != null) && (((g[(i + 3)][(j - 4)]) != null))) {
                                        if (((g != null) && (((g[(i + 1)][(j - 2)].getJoueur()) == joueur)) && (g != null) && (((g[(i + 2)][(j - 3)].getJoueur()) == joueur))) && (g != null) && (((g[(i + 3)][(j - 4)].getJoueur()) == joueur))) {
                                            ok = true;
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                    if (ok) {
                        compteur = compteur + p;
                    } 
                } 
            }
        }
        java.lang.System.gc();
        return compteur;
    }

    private int passerLesLignesVides(Puissance4.donnees.Jeton[][] tab) {
        int i = 0;
        i = 0;
        int j = 0;
        j = 0;
        boolean ok = false;
        ok = false;
        while ((tab != null) && ((i < (tab.length))) && (!ok)) {
            j = 0;
            while ((tab != null) && (tab[i] != null) && ((j < (tab[i].length))) && (!ok)) {
                ok = false;
                if ((tab != null) && ((tab[i][j]) != null)) {
                    ok = true;
                } 
                j++;
            }
            i++;
        }
        tab = null;
        return j < 2 ? 0 : j - 2;
    }

    private int nbPionsTroisAlignes(Puissance4.joueurs.Joueur joueur, int p, Puissance4.donnees.Jeton[][] tab) {
        int i = 0;
        i = 0;
        int j = 0;
        j = 0;
        int result = 0;
        result = 0;
        boolean aligner = false;
        aligner = false;
        for (i = 0 ; (tab != null) && (i < (tab.length)) ; i++) {
            j = 0;
            if ((tab != null)) {
                for (j = passerLesLignesVides(tab) ; (tab != null) && (tab[0] != null) && (j < (tab[0].length)) ; j++) {
                    aligner = false;
                    if ((tab != null) && ((tab[i][j]) == null)) {
                        if ((i - 3) >= 0) {
                            if (((tab != null) && (((tab[(i - 3)][j]) != null)) && (tab != null) && (((tab[(i - 2)][j]) != null))) && (tab != null) && (((tab[(i - 1)][j]) != null))) {
                                if (((tab != null) && (((tab[(i - 3)][j].getJoueur()) == joueur)) && (tab != null) && (((tab[(i - 2)][j].getJoueur()) == joueur))) && (tab != null) && (((tab[(i - 1)][j].getJoueur()) == joueur))) {
                                    aligner = true;
                                } 
                            } 
                        } 
                        if ((tab != null) && ((i + 3) < (tab.length))) {
                            if (((tab != null) && (((tab[(i + 3)][j]) != null)) && (tab != null) && (((tab[(i + 2)][j]) != null))) && (tab != null) && (((tab[(i + 1)][j]) != null))) {
                                if (((tab != null) && (((tab[(i + 3)][j].getJoueur()) == joueur)) && (tab != null) && (((tab[(i + 2)][j].getJoueur()) == joueur))) && (tab != null) && (((tab[(i + 1)][j].getJoueur()) == joueur))) {
                                    aligner = true;
                                } 
                            } 
                        } 
                        if ((tab != null) && (tab[i] != null) && ((j + 3) < (tab[i].length))) {
                            if (((tab != null) && (((tab[i][(j + 3)]) != null)) && (tab != null) && (((tab[i][(j + 2)]) != null))) && (tab != null) && (((tab[i][(j + 1)]) != null))) {
                                if (((tab != null) && (((tab[i][(j + 3)].getJoueur()) == joueur)) && (tab != null) && (((tab[i][(j + 2)].getJoueur()) == joueur))) && (tab != null) && (((tab[i][(j + 1)].getJoueur()) == joueur))) {
                                    aligner = true;
                                } 
                            } 
                        } 
                        if ((tab != null) && (tab[i] != null) && ((j + 3) < (tab[i].length))) {
                            if ((i - 3) >= 0) {
                                if (((tab != null) && (((tab[(i - 3)][(j + 3)]) != null)) && (tab != null) && (((tab[(i - 2)][(j + 2)]) != null))) && (tab != null) && (((tab[(i - 1)][(j + 1)]) != null))) {
                                    if (((tab != null) && (((tab[(i - 3)][(j + 3)].getJoueur()) == joueur)) && (tab != null) && (((tab[(i - 2)][(j + 2)].getJoueur()) == joueur))) && (tab != null) && (((tab[(i - 1)][(j + 1)].getJoueur()) == joueur))) {
                                        aligner = true;
                                    } 
                                } 
                            } 
                            if ((tab != null) && ((i + 3) < (tab.length))) {
                                if (((tab != null) && (((tab[(i + 3)][(j + 3)]) != null)) && (tab != null) && (((tab[(i + 2)][(j + 2)]) != null))) && (tab != null) && (((tab[(i + 1)][(j + 1)]) != null))) {
                                    if (((tab != null) && (((tab[(i + 3)][(j + 3)].getJoueur()) == joueur)) && (tab != null) && (((tab[(i + 2)][(j + 2)].getJoueur()) == joueur))) && (tab != null) && (((tab[(i + 1)][(j + 1)].getJoueur()) == joueur))) {
                                        aligner = true;
                                    } 
                                } 
                            } 
                        } 
                        if ((j - 3) >= 0) {
                            if ((i - 3) >= 0) {
                                if (((tab != null) && (((tab[(i - 3)][(j - 3)]) != null)) && (tab != null) && (((tab[(i - 2)][(j - 2)]) != null))) && (tab != null) && (((tab[(i - 1)][(j - 1)]) != null))) {
                                    if (((tab != null) && (((tab[(i - 3)][(j - 3)].getJoueur()) == joueur)) && (tab != null) && (((tab[(i - 2)][(j - 2)].getJoueur()) == joueur))) && (tab != null) && (((tab[(i - 1)][(j - 1)].getJoueur()) == joueur))) {
                                        aligner = true;
                                    } 
                                } 
                            } 
                            if ((tab != null) && ((i + 3) < (tab.length))) {
                                if (((tab != null) && (((tab[(i + 3)][(j - 3)]) != null)) && (tab != null) && (((tab[(i + 2)][(j - 2)]) != null))) && (tab != null) && (((tab[(i + 1)][(j - 1)]) != null))) {
                                    if (((tab != null) && (((tab[(i + 3)][(j - 3)].getJoueur()) == joueur)) && (tab != null) && (((tab[(i + 2)][(j - 2)].getJoueur()) == joueur))) && (tab != null) && (((tab[(i + 1)][(j - 1)].getJoueur()) == joueur))) {
                                        aligner = true;
                                    } 
                                } 
                            } 
                        } 
                        if (aligner) {
                            result = result + p;
                            aligner = false;
                        } 
                    } 
                }
            } 
        }
        return result;
    }

    public int alphabeta(byte prof, int dcj, int dlj) {
        Puissance4.donnees.Grille grille = null;
        grille = new Puissance4.donnees.Grille(g);
        if ((grille != null)) {
            grille.setJeu(null);
        } 
        int[] tab = null;
        tab = alphabetaRec(prof, java.lang.Integer.MIN_VALUE, java.lang.Integer.MAX_VALUE, grille, true, dcj, dlj);
        java.lang.System.gc();
        return tab[0];
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    private int[] alphabetaRec(byte prof, int alpha, int beta, Puissance4.donnees.Grille grille, boolean max, int dcj, int dlj) {
        int[] duo = null;
        duo = new int[2];
        int[] temp;
        int m;
        int nbr;
        boolean gagner = false;
        gagner = (jeu != null) && ((jeu.gagner(this, grille, dcj, dlj)) || (jeu.gagner(jeu.getProchainJoueur(), grille, dcj, dlj)));
        if ((grille != null) && (((prof == 0) || gagner) || (grille.grillePleine()))) {
            duo[0] = 0;
            if (gagner || (prof == 0)) {
                if ((grille != null)) {
                    duo[1] = evaluation(grille, dcj, dlj);
                } 
            } else {
                duo[1] = 0;
            }
        } else {
            if ((grille != null)) {
                nbr = grille.getNbC();
            } 
            if (max) {
                m = java.lang.Integer.MIN_VALUE;
                while ((m < beta) && (nbr > 0)) {
                    if ((grille != null)) {
                        if (grille.possibleJouer((nbr - 1))) {
                            if ((grille != null)) {
                                grille.mettreJeton(this, (nbr - 1));
                            } 
                            if ((grille != null)) {
                                temp = alphabetaRec(((byte)(prof - 1)), alpha, beta, grille, !max, (nbr - 1), ((grille.getIemeTab((nbr - 1))) + 1));
                            } 
                            if ((temp != null) && ((temp[1]) > m)) {
                                if ((temp != null)) {
                                    m = temp[1];
                                } 
                                duo[0] = nbr - 1;
                                if ((temp != null)) {
                                    duo[1] = temp[1];
                                } 
                            } 
                            if ((grille != null)) {
                                grille.enleverJeton((nbr - 1));
                            } 
                            alpha = Puissance4.joueurs.IA.max(alpha, m);
                        } 
                    } 
                    nbr = nbr - 1;
                }
            } else {
                m = java.lang.Integer.MAX_VALUE;
                while ((m > alpha) && (nbr > 0)) {
                    if ((grille != null)) {
                        if (grille.possibleJouer((nbr - 1))) {
                            if ((grille != null)) {
                                if ((jeu != null)) {
                                    grille.mettreJeton(jeu.getProchainJoueur(), (nbr - 1));
                                } 
                            } 
                            if ((grille != null)) {
                                temp = alphabetaRec(((byte)(prof - 1)), alpha, beta, grille, !max, (nbr - 1), ((grille.getIemeTab((nbr - 1))) + 1));
                            } 
                            if ((temp != null) && ((temp[1]) < m)) {
                                if ((temp != null)) {
                                    m = temp[1];
                                } 
                                duo[0] = nbr - 1;
                                if ((temp != null)) {
                                    duo[1] = temp[1];
                                } 
                            } 
                            if ((grille != null)) {
                                grille.enleverJeton((nbr - 1));
                            } 
                            beta = Puissance4.joueurs.IA.min(beta, m);
                        } 
                    } 
                    nbr = nbr - 1;
                }
            }
        }
        return duo;
    }
}

