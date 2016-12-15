package ephecopoly.view;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;

import javax.swing.*;

import ephecopoly.controller.JeuxController;
import ephecopoly.model.*;

public class JeuxVueGraphique extends JeuxVue{

	private JFrame ephecopoly = new JFrame ("Ephecopoly");
	private JTextArea textArea = new JTextArea ("Ephecopoly ...");
	private JButton etudier = new JButton ("Etudier le cours");
	private JButton lance = new JButton ("Lancer les dés");
	private JButton rien = new JButton ("Ne rien faire");
	private JTextArea chatArea = new JTextArea ("chat");
	private JTextArea chatEcrit = new JTextArea (" écrire dans le chat ...");
	private JButton parler = new JButton ("Parler dans le chat");
	
	public  void setTextArea(String str){
		textArea.append(str);
	}
	public void setChatArea(String str){
		chatArea.append(str);
	}
	public String getChatEcrit(){
		String chat = null;
		chat = chatEcrit.getText();
		return chat;
	}
	public void addEtudierListener(ActionListener a){
		etudier.addActionListener(a);
	}
	public void addLanceListener(ActionListener a){
		lance.addActionListener(a);
	}
	public void addRienListener(ActionListener a){
		rien.addActionListener(a);
	}
	public JeuxVueGraphique(Jeux model, JeuxController controller){
		
		super(model, controller);
		build();
	
	}
	public void affiche(String str){
		textArea.append(str);
	}
	public void build(){
		// paramétrage de la fenêtre
		ephecopoly.setSize (800, 600);
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
		left.setPreferredSize(new Dimension(500, 600));
		box.add(left);
		
		// paramétrage d'une zone d'affichage de texte à gauche 
		textArea.setPreferredSize(new Dimension(500, 570));
		textArea.setBackground(Color.orange);
		textArea.setEditable (false); 
		left.add(textArea);
		
		// création de la boite à layout horizontal à gauche en bas
		Box bottomleft = Box.createHorizontalBox();
		bottomleft.setPreferredSize(new Dimension(500, 30));
		left.add(bottomleft);
		
		// paramétrisation des différents boutons à gauche
		bottomleft.add(etudier);
		bottomleft.add(lance);
		bottomleft.add(rien);
			
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
		
		ephecopoly.setVisible(true);
	}
	public void paintComponent(Graphics g){
		 g.drawString("Bonne partie! Amusez vous bien. Noé et Gérault", 150, 20);
	}
	public static void main(String[] args){
	}
	
	public void update(Observable arg0, Object arg1) {
		build();
	}
}