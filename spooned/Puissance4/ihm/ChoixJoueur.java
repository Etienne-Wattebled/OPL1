package Puissance4.ihm;


public class ChoixJoueur extends javax.swing.JPanel {
    private java.awt.Font fond;

    private java.awt.Font fond1;

    private java.awt.Label labelSeparV;

    private java.awt.Label labelSeparH;

    private javax.swing.JLabel labelChoix1;

    private javax.swing.JLabel labelChoix2;

    private javax.swing.JLabel nivProf1;

    private javax.swing.JLabel nivProf2;

    private javax.swing.JLabel labelEva1;

    private javax.swing.JLabel labelEva2;

    private javax.swing.JTextField nomJ1;

    private javax.swing.JTextField nomJ2;

    private javax.swing.JRadioButton boutonJ1;

    private javax.swing.JRadioButton boutonJ2;

    private javax.swing.JRadioButton boutonO1;

    private javax.swing.JRadioButton boutonO2;

    private javax.swing.ButtonGroup grp1;

    private javax.swing.ButtonGroup grp2;

    private javax.swing.JPanel panelJ1;

    private javax.swing.JPanel panelNiveau1;

    private javax.swing.JPanel panelEva1;

    private javax.swing.JPanel panelNiv1;

    private javax.swing.JPanel panelChoix1;

    private javax.swing.JPanel panelTout1;

    private javax.swing.JPanel panelV;

    private javax.swing.JPanel panelJ2;

    private javax.swing.JPanel panelNiveau2;

    private javax.swing.JPanel panelEva2;

    private javax.swing.JPanel panelNiv2;

    private javax.swing.JPanel panelChoix2;

    private javax.swing.JPanel panelTout2;

    private javax.swing.JPanel panelH;

    private java.lang.Integer[] chiffreProf;

    private java.lang.Integer[] chiffreEva;

    private javax.swing.JComboBox<java.lang.Integer> niveau1;

    private javax.swing.JComboBox<java.lang.Integer> niveau2;

    private javax.swing.JComboBox<java.lang.Integer> evaluation1;

    private javax.swing.JComboBox<java.lang.Integer> evaluation2;

    private int choixNiveau;

    private int choixEva;

    public ChoixJoueur() {
        fond = new java.awt.Font("TimesRoman" , java.awt.Font.BOLD , 18);
        fond1 = new java.awt.Font("TimesRoman" , java.awt.Font.PLAIN , 17);
        chiffreProf = new java.lang.Integer[]{ 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 , 11 , 12 , 13 , 14 , 15 };
        chiffreEva = new java.lang.Integer[]{ 1 };
        niveau1 = new javax.swing.JComboBox<java.lang.Integer>(chiffreProf);
        niveau2 = new javax.swing.JComboBox<java.lang.Integer>(chiffreProf);
        evaluation1 = new javax.swing.JComboBox<java.lang.Integer>(chiffreEva);
        evaluation2 = new javax.swing.JComboBox<java.lang.Integer>(chiffreEva);
        labelSeparV = new java.awt.Label("");
        labelSeparV.setPreferredSize(new java.awt.Dimension(10 , 10));
        labelSeparH = new java.awt.Label("");
        labelSeparH.setPreferredSize(new java.awt.Dimension(10 , 10));
        nivProf1 = new javax.swing.JLabel("Niveau de profondeur");
        nivProf1.setFont(fond1);
        nivProf2 = new javax.swing.JLabel("Niveau de profondeur");
        nivProf2.setFont(fond1);
        labelEva1 = new javax.swing.JLabel("Niveau d\'évaluation");
        labelEva1.setFont(fond1);
        labelEva2 = new javax.swing.JLabel("Niveau d\'évaluation");
        labelEva2.setFont(fond1);
        labelChoix1 = new javax.swing.JLabel("Choix du 1 joueur" , javax.swing.SwingConstants.CENTER);
        labelChoix1.setFont(fond);
        labelChoix2 = new javax.swing.JLabel("Choix du 2 joueur" , javax.swing.SwingConstants.CENTER);
        labelChoix2.setFont(fond);
        nomJ1 = new javax.swing.JTextField("Joueur 1" , 10);
        nomJ2 = new javax.swing.JTextField("Joueur 2" , 10);
        boutonJ1 = new javax.swing.JRadioButton("Nom du joueur 1 : " , true);
        boutonJ2 = new javax.swing.JRadioButton("Nom du joueur 2 : ");
        boutonO1 = new javax.swing.JRadioButton("Ordinateur 1 ");
        boutonO2 = new javax.swing.JRadioButton("Ordinateur 2 " , true);
        boutonJ1.setFont(fond1);
        boutonJ2.setFont(fond1);
        boutonO1.setFont(fond1);
        boutonO2.setFont(fond1);
        grp1 = new javax.swing.ButtonGroup();
        grp1.add(boutonJ1);
        grp1.add(boutonO1);
        grp2 = new javax.swing.ButtonGroup();
        grp2.add(boutonJ2);
        grp2.add(boutonO2);
        panelJ1 = new javax.swing.JPanel();
        panelJ1.add(labelChoix1);
        panelChoix1 = new javax.swing.JPanel(new java.awt.BorderLayout());
        panelChoix1.add(boutonJ1, java.awt.BorderLayout.WEST);
        panelChoix1.add(nomJ1, java.awt.BorderLayout.EAST);
        panelChoix1.add(boutonO1, java.awt.BorderLayout.SOUTH);
        panelNiveau1 = new javax.swing.JPanel();
        panelNiveau1.add(niveau1);
        panelNiveau1.add(nivProf1);
        panelEva1 = new javax.swing.JPanel();
        panelEva1.add(evaluation1);
        panelEva1.add(labelEva1);
        panelNiv1 = new javax.swing.JPanel(new java.awt.GridLayout(2 , 2));
        panelNiv1.add(panelNiveau1);
        panelNiv1.add(panelEva1);
        panelTout1 = new javax.swing.JPanel(new java.awt.BorderLayout());
        panelTout1.add(panelJ1, java.awt.BorderLayout.NORTH);
        panelTout1.add(panelChoix1, java.awt.BorderLayout.EAST);
        panelTout1.add(panelNiv1, java.awt.BorderLayout.SOUTH);
        panelJ2 = new javax.swing.JPanel();
        panelJ2.add(labelChoix2);
        panelChoix2 = new javax.swing.JPanel(new java.awt.BorderLayout());
        panelChoix2.add(boutonJ2, java.awt.BorderLayout.WEST);
        panelChoix2.add(nomJ2, java.awt.BorderLayout.EAST);
        panelChoix2.add(boutonO2, java.awt.BorderLayout.SOUTH);
        panelNiveau2 = new javax.swing.JPanel();
        panelNiveau2.add(niveau2);
        panelNiveau2.add(nivProf2);
        panelEva2 = new javax.swing.JPanel();
        panelEva2.add(evaluation2);
        panelEva2.add(labelEva2);
        panelNiv2 = new javax.swing.JPanel(new java.awt.GridLayout(2 , 2));
        panelNiv2.add(panelNiveau2);
        panelNiv2.add(panelEva2);
        panelTout2 = new javax.swing.JPanel(new java.awt.BorderLayout());
        panelTout2.add(panelJ2, java.awt.BorderLayout.NORTH);
        panelTout2.add(panelChoix2, java.awt.BorderLayout.EAST);
        panelTout2.add(panelNiv2, java.awt.BorderLayout.SOUTH);
        panelV = new javax.swing.JPanel();
        panelV.setPreferredSize(new java.awt.Dimension(50 , 50));
        panelH = new javax.swing.JPanel();
        panelH.setPreferredSize(new java.awt.Dimension(50 , 50));
        setLayout(new java.awt.BorderLayout());
        add(panelTout1, java.awt.BorderLayout.WEST);
        add(panelV, java.awt.BorderLayout.CENTER);
        add(panelTout2, java.awt.BorderLayout.EAST);
        add(panelH, java.awt.BorderLayout.SOUTH);
    }

    public java.lang.String getJoueur1() {
        return nomJ1.getText();
    }

    public java.lang.String getJoueur2() {
        return nomJ2.getText();
    }

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

    public int getNiveauJ1() {
        if ((chiffreProf != null)) {
            if ((niveau1 != null)) {
                choixNiveau = chiffreProf[niveau1.getSelectedIndex()];
            } 
        } 
        return choixNiveau;
    }

    public void setNiveauJ1(byte modif) {
        choixNiveau = modif;
    }

    public int getNiveauJ2() {
        if ((chiffreProf != null)) {
            if ((niveau2 != null)) {
                choixNiveau = chiffreProf[niveau2.getSelectedIndex()];
            } 
        } 
        return choixNiveau;
    }

    public void setNiveauJ2(byte modif) {
        choixNiveau = modif;
    }

    public int getEvaluationJ1() {
        return choixEva = ((int)(chiffreEva[evaluation1.getSelectedIndex()]));
    }

    public void setEvaluationJ1(int modif) {
        choixEva = modif;
    }

    public int getEvaluationJ2() {
        return choixEva = ((int)(chiffreEva[evaluation2.getSelectedIndex()]));
    }

    public void setEvaluationJ2(int modif) {
        choixEva = modif;
    }
}

