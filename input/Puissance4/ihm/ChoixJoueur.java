package Puissance4.ihm;

import Puissance4.*;
import Puissance4.joueurs.*;
import Puissance4.donnees.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ChoixJoueur extends JPanel {
	private Font fond, fond1;
	private Label labelSeparV, labelSeparH ; 
	private JLabel labelChoix1, labelChoix2, nivProf1, nivProf2, labelEva1, labelEva2; 
	private JTextField nomJ1, nomJ2;
	private JRadioButton boutonJ1, boutonJ2, boutonO1, boutonO2;
	private ButtonGroup grp1, grp2;
	private JPanel panelJ1, panelNiveau1, panelEva1, panelNiv1, panelChoix1,  panelTout1, panelV ; 
	private JPanel  panelJ2, panelNiveau2, panelEva2, panelNiv2, panelChoix2, panelTout2, panelH;
	private Integer[] chiffreProf, chiffreEva;	
	private JComboBox <Integer> niveau1, niveau2, evaluation1, evaluation2;
	private int choixNiveau,choixEva;

	public ChoixJoueur() {
		
		fond = new Font("TimesRoman", Font.BOLD, 18);
		fond1 = new Font("TimesRoman", Font.PLAIN, 17);
		
		chiffreProf = new Integer[] {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		chiffreEva = new Integer[] {1};
		niveau1 =new JComboBox <Integer> (chiffreProf);
		niveau2 =new JComboBox <Integer> (chiffreProf);
		evaluation1 =new JComboBox <Integer> (chiffreEva);
		evaluation2 =new JComboBox <Integer> (chiffreEva);
		
		labelSeparV = new Label("");
		labelSeparV.setPreferredSize(new Dimension(10,10));
		labelSeparH = new Label("");
		labelSeparH.setPreferredSize(new Dimension(10,10));
		
		nivProf1 = new JLabel("Niveau de profondeur");
		nivProf1.setFont(fond1);
		nivProf2 = new JLabel("Niveau de profondeur");
		nivProf2.setFont(fond1);
		labelEva1 = new JLabel("Niveau d'\u00e9valuation");
		labelEva1.setFont(fond1);
		labelEva2 = new JLabel("Niveau d'\u00e9valuation");
		labelEva2.setFont(fond1);
		labelChoix1 = new JLabel("Choix du 1 joueur", JLabel.CENTER);
		labelChoix1.setFont(fond);
		labelChoix2 = new JLabel("Choix du 2 joueur", JLabel.CENTER);
		labelChoix2.setFont(fond);
		
		nomJ1 = new JTextField("Joueur 1", 10);
		nomJ2 = new JTextField("Joueur 2",10);

		boutonJ1 = new JRadioButton("Nom du joueur 1 : ", true);
		boutonJ2 = new JRadioButton("Nom du joueur 2 : ");
		boutonO1 = new JRadioButton("Ordinateur 1 ");
		boutonO2 = new JRadioButton("Ordinateur 2 ", true);
		boutonJ1.setFont(fond1);
		boutonJ2.setFont(fond1);
		boutonO1.setFont(fond1);
		boutonO2.setFont(fond1);
		
		grp1 = new ButtonGroup();
		grp1.add(boutonJ1);
		grp1.add(boutonO1);
		grp2 = new ButtonGroup();
		grp2.add(boutonJ2);
		grp2.add(boutonO2);
		
		panelJ1 =new JPanel();
		panelJ1.add(labelChoix1);
		
		panelChoix1 =new JPanel(new BorderLayout());
		panelChoix1.add(boutonJ1, BorderLayout.WEST);
		panelChoix1.add(nomJ1, BorderLayout.EAST);
		panelChoix1.add(boutonO1, BorderLayout.SOUTH);
		
		panelNiveau1 = new JPanel();
		panelNiveau1.add(niveau1);
		panelNiveau1.add(nivProf1);
		
		panelEva1 = new JPanel();
		panelEva1.add(evaluation1);
		panelEva1.add(labelEva1);
		
		panelNiv1 = new JPanel(new GridLayout(2,2)); 
		panelNiv1.add(panelNiveau1);
		panelNiv1.add(panelEva1);
		
		panelTout1 = new JPanel(new BorderLayout());
		panelTout1.add(panelJ1, BorderLayout.NORTH);
		panelTout1.add(panelChoix1, BorderLayout.EAST);
		panelTout1.add(panelNiv1, BorderLayout.SOUTH);
		
		panelJ2 =new JPanel();
		panelJ2.add(labelChoix2);
		
		panelChoix2 =new JPanel(new BorderLayout());
		panelChoix2.add(boutonJ2, BorderLayout.WEST);
		panelChoix2.add(nomJ2, BorderLayout.EAST);
		panelChoix2.add(boutonO2, BorderLayout.SOUTH);
		
		panelNiveau2 = new JPanel();
		panelNiveau2.add(niveau2);
		panelNiveau2.add(nivProf2);
		
		panelEva2 = new JPanel();
		panelEva2.add(evaluation2);
		panelEva2.add(labelEva2);
		
		panelNiv2 = new JPanel(new GridLayout(2,2)); 
		panelNiv2.add(panelNiveau2);
		panelNiv2.add(panelEva2);
		
		panelTout2 = new JPanel(new BorderLayout());
		panelTout2.add(panelJ2, BorderLayout.NORTH);
		panelTout2.add(panelChoix2, BorderLayout.EAST);
		panelTout2.add(panelNiv2, BorderLayout.SOUTH);
		
		panelV = new JPanel();
		panelV.setPreferredSize(new Dimension(50,50));
		panelH = new JPanel();
		panelH.setPreferredSize(new Dimension(50,50));
		
		this.setLayout(new BorderLayout());
		this.add(panelTout1, BorderLayout.WEST);
		this.add(panelV, BorderLayout.CENTER);
		this.add(panelTout2, BorderLayout.EAST);
		this.add(panelH, BorderLayout.SOUTH);
	}
	// retourne le nom des joueur Humains
	public String getJoueur1() {
		return nomJ1.getText();
	}
	public String getJoueur2() {
		return nomJ2.getText();
	}
	// Renvoie vrai sur les cases cochees 
	public boolean isSelectedJ1() {
		return boutonJ1.isSelected();
	}
	public boolean isSelectedJ2() {
		return boutonJ2.isSelected();
	}
	public boolean isSelectedO1() {
		return boutonO1.isSelected();
	}
	public boolean isSelectedO2() {
		return boutonO2.isSelected();
	}
	// Retourne / Affecte le niveau par rapport au prodondeur choisie
	public int getNiveauJ1() {
		choixNiveau = chiffreProf[niveau1.getSelectedIndex()];
		return choixNiveau;
	}
	public void setNiveauJ1(byte modif) {
		choixNiveau = modif;
	}
	public int getNiveauJ2() {
		choixNiveau = chiffreProf[niveau2.getSelectedIndex()];
		return choixNiveau;
	}
	public void setNiveauJ2(byte modif) {
		choixNiveau = modif;
	}
	// Retourne / Affecte le niveau d'evaluation
	public int getEvaluationJ1() {
		return choixEva = (int) chiffreEva[evaluation1.getSelectedIndex()];
	}
	public void setEvaluationJ1(int modif) {
		choixEva = modif;
	}
	public int getEvaluationJ2() {
		return choixEva = (int) chiffreEva[evaluation2.getSelectedIndex()];
	}
	public void setEvaluationJ2(int modif) {
		choixEva = modif;
	}
}

