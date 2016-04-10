package Puissance4.donnees;

import Puissance4.*;
import java.util.concurrent.Semaphore;

public class Launcher extends Thread {
	private Jeu jeu;
	public Launcher(Jeu j) {
		jeu = j;
	}
	public Launcher(Launcher l) {
		this.jeu = l.getJeu();
	}
	public Jeu getJeu() {
		return jeu;
	}
	public void run() {
		jeu.start();
	}
	public void reset() {
		jeu.reset();
	}
	public void setSemaphore(Semaphore s) {
		jeu.setSemaphore(s);
	}
	public Semaphore getSemaphore() {
		return jeu.getSemaphore();
	}
}
