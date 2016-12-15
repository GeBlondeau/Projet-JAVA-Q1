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
	private JButton lance = new JButton ("Lancer les d�s");
	private JButton rien = new JButton ("Ne rien faire");
	private JTextArea chatArea = new JTextArea ("chat");
	private JTextArea chatEcrit = new JTextArea (" �crire dans le chat ...");
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
		// param�trage de la fen�tre
		ephecopoly.setSize (800, 600);
		ephecopoly.setLocation(500, 250);
		ephecopoly.setLocationRelativeTo(null);
		ephecopoly.setResizable(false);
		ephecopoly.setAlwaysOnTop(false);
		ephecopoly.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		// cr�ation de la boite � layout principale
		Box main = Box.createHorizontalBox();
		// on met la boite dans la fen�tre
		Container contentpane = ephecopoly.getContentPane();
		contentpane.add(main);
				
		// cr�ation de la boite � layout horizontal box
		Box box = Box.createHorizontalBox();
		main.add(box);
		
		// cr�ation de la boite � layout vertical � gauche
		Box left = Box.createVerticalBox();
		left.setPreferredSize(new Dimension(500, 600));
		box.add(left);
		
		// param�trage d'une zone d'affichage de texte � gauche 
		textArea.setPreferredSize(new Dimension(500, 570));
		textArea.setBackground(Color.orange);
		textArea.setEditable (false); 
		left.add(textArea);
		
		// cr�ation de la boite � layout horizontal � gauche en bas
		Box bottomleft = Box.createHorizontalBox();
		bottomleft.setPreferredSize(new Dimension(500, 30));
		left.add(bottomleft);
		
		// param�trisation des diff�rents boutons � gauche
		bottomleft.add(etudier);
		bottomleft.add(lance);
		bottomleft.add(rien);
			
		// cr�ation de la boite � layout vertical � droite
		Box right = Box.createVerticalBox();
		right.setPreferredSize(new Dimension(300, 600));
		box.add(right);
				
		// param�trisation de la zone d'affichage du chat � droite
		chatArea.setPreferredSize(new Dimension(300, 520));
		chatArea.setBackground(Color.blue);
		chatArea.setEditable (false); 
		right.add(chatArea);
		
		// param�trisation de la zone d'�criture du chat � droite
		chatEcrit.setPreferredSize(new Dimension(300, 50));
		chatEcrit.setBackground(Color.white);
		chatEcrit.setEditable (true); 
		right.add(chatEcrit);
						
		// param�trisation du bouton � droite
		right.add(parler);
		
		ephecopoly.setVisible(true);
	}
	public void paintComponent(Graphics g){
		 g.drawString("Bonne partie! Amusez vous bien. No� et G�rault", 150, 20);
	}
	public static void main(String[] args){
	}
	
	public void update(Observable arg0, Object arg1) {
		build();
	}
}