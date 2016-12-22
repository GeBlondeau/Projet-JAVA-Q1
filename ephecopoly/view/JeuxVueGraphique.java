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
	private JButton oui = new JButton ("Oui");
	private JButton lance = new JButton ("Lancer les d�s");
	private JButton non = new JButton ("Non");
	private JButton b2 = new JButton("2");
	private JButton b3 = new JButton("3");
	private JButton b4 = new JButton("4");
	private JButton b5 = new JButton("5");
	private JButton b6 = new JButton("6");
	private JTextArea nomEtudiant = new JTextArea();
	private JTextArea chatArea = new JTextArea ("chat");
	private JTextArea chatEcrit = new JTextArea (" Pour �crire dans le chat �criver ici");
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
		
		// blocage des boutons pendant la cr�ation de la fen�tre
		oui.setEnabled(false);
		lance.setEnabled(false);
		non.setEnabled(false);
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
		b5.setEnabled(false);
		b6.setEnabled(false);
		
		// param�trage de la fen�tre
		ephecopoly.setSize (1000, 600);
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
		left.setPreferredSize(new Dimension(700, 600));
		box.add(left);
		
		// param�trage de la zone d'affichage de texte en haut � gauche 
		textArea.setPreferredSize(new Dimension(700, 570));
		textArea.setBackground(Color.orange);
		textArea.setEditable (false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		left.add(textArea);
		
		// cr�ation de la boite � layout horizontal en bas � gauche
		Box bottomleft = Box.createHorizontalBox();
		bottomleft.setPreferredSize(new Dimension(700, 30));
		left.add(bottomleft);
		
		// param�trage des diff�rents boutons � gauche
		bottomleft.add(nomEtudiant);
		bottomleft.add(b2);
		bottomleft.add(b3);
		bottomleft.add(b4);
		bottomleft.add(b5);
		bottomleft.add(b6);
		bottomleft.add(lance);
		lance.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent event){
			    controller.setEtatDes(jeu, jeu.getEtudiantActuel(), true);
			  }
		});
		bottomleft.add(oui);
		oui.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent event){
			    System.out.println("Oui");
			  }
		});
		bottomleft.add(non);
		non.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent event){
			    System.out.println("Non");
			  }
		});
			
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
		parler.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent event){
			    setChatArea(getChatEcrit());
			  }
		});
		
		// affichage de la fen�tre
		ephecopoly.setVisible(true);
		
		// d�locage des boutons une fois que la fen�tre est visible
		oui.setEnabled(true);
		lance.setEnabled(true);
		non.setEnabled(true);
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);
		b5.setEnabled(true);
		b6.setEnabled(true);
	}
	public static void main(String[] args){
	}
	
	public void update(Observable arg0, Object arg1) {
		affiche(jeu, jeu.getJeuString());
	}
}
