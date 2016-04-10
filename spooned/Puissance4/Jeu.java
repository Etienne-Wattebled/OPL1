package Puissance4;


public class Jeu {
    private boolean graphique;

    private int dcj;

    private int dlj;

    private Puissance4.donnees.Grille g;

    private Puissance4.ihm.IHM ihm;

    private Puissance4.joueurs.Joueur joueur;

    private Puissance4.joueurs.Joueur prochainJoueur;

    private java.util.concurrent.Semaphore semJoueur;

    public Jeu(boolean graphique) {
        this.g = null;
        this.ihm = null;
        this.joueur = null;
        this.prochainJoueur = null;
        this.semJoueur = null;
        dcj = 0;
        dlj = 0;
        this.graphique = graphique;
        if (graphique) {
            new Puissance4.ihm.PremiereFenetre(this);
        } else {
            initConsole();
        }
    }

    public Jeu(Puissance4.donnees.Grille grille ,Puissance4.ihm.IHM ihm ,Puissance4.joueurs.Joueur jproch ,Puissance4.joueurs.Joueur j) {
        this.g = grille;
        this.ihm = ihm;
        this.prochainJoueur = jproch;
        this.joueur = j;
        this.semJoueur = null;
        dcj = 0;
        dlj = 0;
    }

    public java.util.concurrent.Semaphore getSemaphore() {
        return semJoueur;
    }

    public void reset() {
        if (!(graphique)) {
            if ((joueur != null)) {
                if ((joueur != null)) {
                    java.lang.System.out.println((((joueur.getNom()) + " : ") + (joueur.getScore())));
                } 
            } 
            if ((prochainJoueur != null)) {
                if ((prochainJoueur != null)) {
                    java.lang.System.out.println((((prochainJoueur.getNom()) + " : ") + (prochainJoueur.getScore())));
                } 
            } 
        } 
        if ((ihm) != null) {
            if ((ihm != null)) {
                ihm.raz();
            } 
        } 
        if ((g) != null) {
            if ((g != null)) {
                g.initGrilleTab();
            } 
        } 
        dcj = 0;
        dlj = 0;
    }

    public void setDcj(int a) {
        dcj = a;
    }

    public void setDlj(int a) {
        dlj = a;
    }

    public void setGrille(Puissance4.donnees.Grille g) {
        this.g = g;
    }

    public void setJoueur(Puissance4.joueurs.Joueur j) {
        joueur = j;
    }

    public void setProchainJoueur(Puissance4.joueurs.Joueur j) {
        prochainJoueur = j;
    }

    public void setIHM(Puissance4.ihm.IHM i) {
        ihm = i;
    }

    public Puissance4.ihm.IHM getIHM() {
        return ihm;
    }

    public boolean getGraphique() {
        return graphique;
    }

    public Puissance4.joueurs.Joueur getJoueurHumainJouer() {
        if (((joueur) instanceof Puissance4.joueurs.IA) && ((prochainJoueur) instanceof Puissance4.joueurs.IA)) {
            return null;
        } else {
            if (!((joueur) instanceof Puissance4.joueurs.IA)) {
                return joueur;
            } else {
                if (!((prochainJoueur) instanceof Puissance4.joueurs.IA)) {
                    return prochainJoueur;
                } else {
                    return null;
                }
            }
        }
    }

    public void setSemaphore(java.util.concurrent.Semaphore sem) {
        this.semJoueur = sem;
    }

    public void refreshAffichage() {
        if ((ihm != null)) {
            ihm.refresh();
        } 
    }

    public Puissance4.joueurs.Joueur getProchainJoueur() {
        return prochainJoueur;
    }

    public Puissance4.joueurs.Joueur getJoueur() {
        return joueur;
    }

    public void changerJoueur() {
        Puissance4.joueurs.Joueur interm = null;
        interm = prochainJoueur;
        prochainJoueur = joueur;
        joueur = interm;
    }

    public boolean possibleJouer(int c) {
        return g.possibleJouer(c);
    }

    public boolean grillePleine(int[] tab) {
        return g.grillePleine(tab);
    }

    public boolean finDeJeu(Puissance4.donnees.Grille g) {
        boolean grillePleine = false;
        if ((g != null)) {
            if ((g != null)) {
                grillePleine = g.grillePleine(g.getTab());
            } 
        } 
        boolean unGagnant = false;
        unGagnant = (joueur != null) && ((gagner(joueur)) || (gagner(prochainJoueur)));
        return grillePleine || unGagnant;
    }

    public boolean finDeJeu() {
        return finDeJeu(g);
    }

    public void jouer(Puissance4.joueurs.Joueur j, int c) {
        if (((j == (joueur)) && (possibleJouer(c))) && (!(finDeJeu()))) {
            if (!(graphique)) {
                if ((j != null)) {
                    java.lang.System.out.println((("OK " + (j.getNom())) + ". Ton coup est valide."));
                } 
            } 
            if ((g != null)) {
                g.jouer(j, c);
            } 
            if (!(j instanceof Puissance4.joueurs.IA)) {
                if ((semJoueur != null)) {
                    semJoueur.release();
                } 
            } 
        } else {
            if (!(graphique)) {
                if ((j != null)) {
                    java.lang.System.out.println(("Pas possible de jouer ici " + (j.getNom())));
                } 
            } else {
                if ((ihm != null)) {
                    if ((j != null)) {
                        ihm.message(("Pas possible de jouer ici " + (j.getNom())));
                    } 
                } 
            }
        }
    }

    public boolean gagner(Puissance4.joueurs.Joueur joueur) {
        return gagner(joueur, g, dcj, dlj);
    }

    public boolean gagner(Puissance4.joueurs.Joueur joueur, Puissance4.donnees.Grille grille, int c, int l) {
        if ((grille != null) && (((grille.getJeton(c, l)) == null)) || (grille != null) && (grille.getJeton(c, l) != null) && (((grille.getJeton(c, l).getJoueur()) != joueur))) {
            return false;
        } else {
            int gauche = 0;
            gauche = 0;
            int droite = 0;
            droite = 0;
            int i = 0;
            i = 1;
            boolean continuer = false;
            continuer = true;
            while (continuer && (i <= 3)) {
                if ((grille != null)) {
                    continuer = grille.existeJeton(joueur, (c - i), l);
                } 
                if (continuer) {
                    gauche++;
                    i++;
                } 
            }
            if (gauche == 3) {
                return true;
            } 
            i = 1;
            continuer = true;
            while (continuer && (i <= 3)) {
                if ((grille != null)) {
                    continuer = grille.existeJeton(joueur, (c + i), l);
                } 
                if (continuer) {
                    droite++;
                    i++;
                } 
            }
            if ((gauche + droite) >= 3) {
                return true;
            } 
            i = 1;
            gauche = 0;
            droite = 0;
            continuer = true;
            while (continuer && (i <= 3)) {
                if ((grille != null)) {
                    continuer = grille.existeJeton(joueur, c, (l - i));
                } 
                if (continuer) {
                    gauche++;
                    i++;
                } 
            }
            if (gauche == 3) {
                return true;
            } 
            i = 1;
            continuer = true;
            while (continuer && (i <= 3)) {
                if ((grille != null)) {
                    continuer = grille.existeJeton(joueur, c, (l + i));
                } 
                if (continuer) {
                    droite++;
                    i++;
                } 
            }
            if ((gauche + droite) >= 3) {
                return true;
            } 
            i = 1;
            gauche = 0;
            droite = 0;
            continuer = true;
            while (continuer && (i <= 3)) {
                if ((grille != null)) {
                    continuer = grille.existeJeton(joueur, (c - i), (l - i));
                } 
                if (continuer) {
                    gauche++;
                    i++;
                } 
            }
            if (gauche == 3) {
                return true;
            } 
            i = 1;
            continuer = true;
            while (continuer && (i <= 3)) {
                if ((grille != null)) {
                    continuer = grille.existeJeton(joueur, (c + i), (l + i));
                } 
                if (continuer) {
                    droite++;
                    i++;
                } 
            }
            if ((gauche + droite) >= 3) {
                return true;
            } 
            i = 1;
            gauche = 0;
            droite = 0;
            continuer = true;
            while (continuer && (i <= 3)) {
                if ((grille != null)) {
                    continuer = grille.existeJeton(joueur, (c + i), (l - i));
                } 
                if (continuer) {
                    gauche++;
                    i++;
                } 
            }
            if (gauche == 3) {
                return true;
            } 
            i = 1;
            continuer = true;
            while (continuer && (i <= 3)) {
                if ((grille != null)) {
                    continuer = grille.existeJeton(joueur, (c - i), (l + i));
                } 
                if (continuer) {
                    droite++;
                    i++;
                } 
            }
            if ((gauche + droite) >= 3) {
                return true;
            } 
            return false;
        }
    }

    public boolean unGagnant() {
        if ((prochainJoueur != null)) {
            if (gagner(prochainJoueur)) {
                return true;
            } else {
                return false;
            }
        } 
    }

    public void start() {
        while ((!(finDeJeu())) && (!(java.lang.Thread.currentThread().isInterrupted()))) {
            if (!(graphique)) {
                if ((joueur != null)) {
                    java.lang.System.out.println(("Au tour de: " + (joueur.getNom())));
                } 
            } else {
                if ((ihm != null)) {
                    if ((joueur != null)) {
                        ihm.message(("Au tour de : " + (joueur.getNom())));
                    } 
                } 
            }
            if ((joueur) instanceof Puissance4.joueurs.IA) {
                Puissance4.joueurs.IA ia = null;
                ia = ((Puissance4.joueurs.IA)(joueur));
                if ((g != null)) {
                    if ((ia != null)) {
                        g.jouer(ia, ia.jouer(dcj, dlj));
                    } 
                } 
            } else {
                if ((semJoueur != null)) {
                    semJoueur.acquireUninterruptibly();
                } 
            }
            changerJoueur();
            if ((ihm != null)) {
                ihm.refresh();
            } 
        }
        if (graphique) {
            if ((ihm != null)) {
                ihm.message("Partie terminée.");
            } 
        } 
        if (unGagnant()) {
            if ((prochainJoueur != null)) {
                prochainJoueur.gagner();
            } 
            if (!(graphique)) {
                if ((prochainJoueur != null)) {
                    java.lang.System.out.println(("Bravo " + (prochainJoueur.getNom())));
                } 
                java.lang.System.out.println(getScores());
            } else {
                if ((ihm != null)) {
                    if ((prochainJoueur != null)) {
                        ihm.afficherMessage(("Bravo " + (prochainJoueur.getNom())), getScores());
                    } 
                } 
            }
        } else {
            if (!(graphique)) {
                java.lang.System.out.println("Match nul");
                java.lang.System.out.println(getScores());
            } else {
                if ((ihm != null)) {
                    ihm.afficherMessage("Match nul", getScores());
                } 
            }
        }
    }

    public Puissance4.donnees.Launcher getLauncher() {
        return ihm.getLauncher();
    }

    public void initConsole() {
        int a = 0;
        a = 0;
        int b = 0;
        b = 0;
        java.lang.String s = null;
        s = "";
        java.util.Scanner scan = null;
        scan = new java.util.Scanner(java.lang.System.in);
        java.lang.String fond = null;
        fond = "bleu";
        java.lang.String jeton1 = null;
        jeton1 = "rouge";
        java.lang.String jeton2 = null;
        jeton2 = "jaune";
        if ((this.g) == null) {
            java.lang.System.out.println("Nombre de colonnes ?");
            if ((scan != null)) {
                a = scan.nextInt();
            } 
            java.lang.System.out.println("Nombre de lignes ?");
            if ((scan != null)) {
                b = scan.nextInt();
            } 
            if ((a >= 4) && (b >= 4)) {
                g = new Puissance4.donnees.Grille(a , b , this);
            } else {
                java.lang.System.out.println("Grille trop petite. Changement en 7,6");
                this.g = new Puissance4.donnees.Grille(7 , 6 , this);
            }
        } else {
            if ((this.g != null)) {
                this.g.initGrilleTab();
            } 
        }
        if ((ihm) == null) {
            java.lang.System.out.println("Titre ?");
            if ((scan != null)) {
                s = scan.next();
            } 
            java.lang.System.out.println("Largeur d\'affichage ?");
            if ((scan != null)) {
                a = scan.nextInt();
            } 
            java.lang.System.out.println("Hauteur d\'affichage ?");
            if ((scan != null)) {
                b = scan.nextInt();
            } 
            java.lang.System.out.println("Couleur de la grille ? noir bleu cyan magenta orange rose rouge jaune vert");
            if ((scan != null)) {
                fond = scan.next();
            } 
            if ((g != null)) {
                if ((g != null)) {
                    if ((fond != null)) {
                        this.ihm = new Puissance4.ihm.IHM(s , a , b , g.getNbL() , g.getNbC() , traduireCouleur(fond) , this);
                    } 
                } 
            } 
            Puissance4.donnees.Launcher l = null;
            l = new Puissance4.donnees.Launcher(this);
            if ((ihm != null)) {
                ihm.setLauncher(l);
            } 
        } else {
            if ((ihm != null)) {
                ihm.clear();
            } 
        }
        if ((joueur) == null) {
            joueur = donnerJoueur(false);
        } 
        if ((prochainJoueur) == null) {
            prochainJoueur = donnerJoueur(true);
        } 
        if ((!((joueur) instanceof Puissance4.joueurs.IA)) || (!((prochainJoueur) instanceof Puissance4.joueurs.IA))) {
            java.util.concurrent.Semaphore sem = null;
            sem = new java.util.concurrent.Semaphore(0);
            if ((sem != null)) {
                setSemaphore(sem);
            } 
        } 
    }

    private java.awt.Color traduireCouleur(java.lang.String couleur) {
        java.lang.String c = null;
        if ((couleur != null)) {
            c = couleur.toLowerCase();
        } 
        java.awt.Color couleurM;
        switch (c) {
            case "bleu" :
                couleurM = new java.awt.Color(44 , 117 , 255);
                break;
            case "vert" :
                couleurM = new java.awt.Color(87 , 213 , 59);
                break;
            case "cyan" :
                couleurM = java.awt.Color.CYAN;
                break;
            case "magenta" :
                couleurM = java.awt.Color.MAGENTA;
                break;
            case "orange" :
                couleurM = new java.awt.Color(255 , 73 , 1);
                break;
            case "rose" :
                couleurM = new java.awt.Color(249 , 66 , 158);
                break;
            case "jaune" :
                couleurM = java.awt.Color.YELLOW;
                break;
            case "rouge" :
                couleurM = java.awt.Color.RED;
                break;
            case "noir" :
                couleurM = new java.awt.Color(19 , 14 , 10);
                break;
            case "gris" :
                couleurM = new java.awt.Color(175 , 175 , 175);
                break;
            default :
                couleurM = new java.awt.Color(38 , 196 , 236);
        }
        return couleurM;
    }

    public void afficherJeton(java.awt.Color c, int x, int y) {
        if ((ihm != null)) {
            ihm.changerCouleurJetonGrille(c, x, y);
        } 
    }

    public java.lang.String getScores() {
        return ((((((joueur.getNom()) + " : ") + (joueur.getScore())) + "\n") + (prochainJoueur.getNom())) + " : ") + (prochainJoueur.getScore());
    }

    private Puissance4.joueurs.Joueur donnerJoueur(boolean a) {
        java.lang.String s = null;
        s = "";
        java.lang.String c = null;
        c = "";
        java.util.Scanner scan = null;
        scan = new java.util.Scanner(java.lang.System.in);
        java.lang.System.out.println((("Que voulez-vous pour le joueur " + (a ? 2 : 1)) + " ? \'ordinateur\' ou \'humain\' ? Veuillez saisir sans les \' \'"));
        s = new java.util.Scanner(java.lang.System.in).next();
        Puissance4.joueurs.Joueur j = null;
        j = null;
        int i = 0;
        i = 0;
        if ((s != null)) {
            if (s.equals("ordinateur")) {
                byte b = 0;
                b = 0;
                java.lang.System.out.println("Profondeur (coups d\'avance). Ne tapez pas une grande valeur. Conseil : entre 7 et 12. Plus la profondeur est haute, plus l\'IA sera robuste.");
                if ((scan != null)) {
                    b = scan.nextByte();
                } 
                java.lang.System.out.println("Niveau. (Il n\'existe que le niveau 1 dans la version actuelle)");
                if ((scan != null)) {
                    i = scan.nextInt();
                } 
                java.lang.System.out.println("Couleur de l\'IA ? bleu, vert, cyan, magenta, orange, rose, jaune, rouge, noir, gris");
                if ((scan != null)) {
                    c = scan.next();
                } 
                Puissance4.joueurs.IA ordinateur = null;
                if ((c != null)) {
                    ordinateur = new Puissance4.joueurs.IA(b , i , traduireCouleur(c) , this.g , this);
                } 
                java.lang.Thread ia = null;
                ia = new java.lang.Thread(ordinateur);
                if ((ia != null)) {
                    ia.start();
                } 
                j = ordinateur;
            } else {
                java.lang.System.out.println("Quel est votre nom ?");
                if ((scan != null)) {
                    s = scan.next();
                } 
                java.lang.System.out.println("Couleur jeton ? bleu, vert, cyan, magenta, orange, rose, jaune, rouge, noir, gris");
                if ((scan != null)) {
                    c = scan.next();
                } 
                if ((c != null)) {
                    j = new Puissance4.joueurs.Joueur(s , 0 , traduireCouleur(c));
                } 
            }
        } 
        return j;
    }

    public static void main(java.lang.String[] args) {
        Puissance4.Jeu jeu = null;
        jeu = new Puissance4.Jeu(true);
    }
}

