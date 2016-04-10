package Puissance4.donnees;


public class Launcher extends java.lang.Thread {
    private Puissance4.Jeu jeu;

    public Launcher(Puissance4.Jeu j) {
        jeu = j;
    }

    public Launcher(Puissance4.donnees.Launcher l) {
        this.jeu = l.getJeu();
    }

    public Puissance4.Jeu getJeu() {
        return jeu;
    }

    public void run() {
        if ((jeu != null)) {
            jeu.start();
        } 
    }

    public void reset() {
        if ((jeu != null)) {
            jeu.reset();
        } 
    }

    public void setSemaphore(java.util.concurrent.Semaphore s) {
        if ((jeu != null)) {
            jeu.setSemaphore(s);
        } 
    }

    public java.util.concurrent.Semaphore getSemaphore() {
        return jeu.getSemaphore();
    }
}

