package ephecopoly.view;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Scanner;

import javax.swing.*;

import ephecopoly.controller.JeuxController;
import ephecopoly.model.*;

public class JeuxVueGraphique extends JeuxVue{

	private JFrame ephecopoly = new JFrame ("Ephecopoly");
	private JTextArea textArea = new JTextArea ("Bienvenue dans cette partie d'Ephecopoly \n");
	private JButton etudier = new JButton ("Etudier le cours");
	private JButton lance = new JButton ("Lancer les dés");
	private JButton rien = new JButton ("Ne rien faire");
	private JTextArea chatArea = new JTextArea ("chat");
	private JTextArea chatEcrit = new JTextArea (" Pour écrire dans le chat écriver ici");
	private JButton parler = new JButton ("Ecrire dans le chat");
	protected Scanner sc;
	
	public  void setTextArea(String str){
		textArea.setText(str + "\n");
	}
	public void setChatArea(String str){
		chatArea.append("- " + str + "\n");
	}
	public String getChatEcrit(){
		String chat = null;
		chat = chatEcrit.getText();
		return chat;
	}
	public JeuxVueGraphique(Jeux jeu, JeuxController controller){
		
		super(jeu, controller);
		sc = new Scanner(System.in);
		build();
	}
	public void affiche(Jeux jeu, String str){
		setTextArea(str);
	}
	public void build(){
		
		// blocage des boutons pendant la création de la fenêtre
		etudier.setEnabled(false);
		lance.setEnabled(false);
		rien.setEnabled(false);
		
		// paramétrage de la fenêtre
		ephecopoly.setSize (1000, 600);
		ephecopoly.setLocation(500, 250);
		ephecopoly.setLocationRelativeTo(null);
		ephecopoly.setResizable(false);
		ephecopoly.setAlwaysOnTop(false);
		ephecopoly.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		// création de la boite à layout principale
		Box main = Box.createHorizontalBox();
		// on met la boite dans la fenêtre
		Container contentpane = ephecopoly.getContentPane();
		contentpane.add(main);
				
		// création de la boite à layout horizontal box
		Box box = Box.createHorizontalBox();
		main.add(box);
		
		// création de la boite à layout vertical à gauche
		Box left = Box.createVerticalBox();
		left.setPreferredSize(new Dimension(700, 600));
		box.add(left);
		
		// paramétrage d'une zone d'affichage de texte à gauche 
		textArea.setPreferredSize(new Dimension(700, 570));
		textArea.setBackground(Color.orange);
		textArea.setEditable (false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		left.add(textArea);
		
		// création de la boite à layout horizontal à gauche en bas
		Box bottomleft = Box.createHorizontalBox();
		bottomleft.setPreferredSize(new Dimension(700, 30));
		left.add(bottomleft);
		
		// paramétrisation des différents boutons à gauche
		bottomleft.add(etudier);
		etudier.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent event){
			    System.out.println("Oui");
			  }
		});
		bottomleft.add(lance);
		lance.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent event){
			    controller.setEtatDes(jeu, jeu.getEtudiantActuel(), true);
			  }
		});
		bottomleft.add(rien);
		rien.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent event){
			    System.out.println("Non");
			  }
		});
			
		// création de la boite à layout vertical à droite
		Box right = Box.createVerticalBox();
		right.setPreferredSize(new Dimension(300, 600));
		box.add(right);
				
		// paramétrisation de la zone d'affichage du chat à droite
		chatArea.setPreferredSize(new Dimension(300, 520));
		chatArea.setBackground(Color.blue);
		chatArea.setEditable (false); 
		right.add(chatArea);
		
		// paramétrisation de la zone d'écriture du chat à droite
		chatEcrit.setPreferredSize(new Dimension(300, 50));
		chatEcrit.setBackground(Color.white);
		chatEcrit.setEditable (true); 
		right.add(chatEcrit);
						
		// paramétrisation du bouton à droite
		right.add(parler);
		parler.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent event){
			    setChatArea(getChatEcrit());
			  }
		});
		
		// affichage de la fenêtre
		ephecopoly.setVisible(true);
		
		// délocage des boutons une fois que la fenêtre est visible
		etudier.setEnabled(true);
		lance.setEnabled(true);
		rien.setEnabled(true);
	}
	public static void main(String[] args){
	}
	
	public void update(Observable arg0, Object arg1) {
		affiche(jeu, jeu.getJeuString());
	}
}