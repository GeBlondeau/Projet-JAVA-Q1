package Projet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

public class Jeux extends Observable{

	static Scanner sc = new Scanner(System.in);
	static List<Etudiant> listeJoueur = new ArrayList<Etudiant>();
	
	public void remplirListe(Etudiant joueur){
		listeJoueur.add(joueur);
	}
	public void lancementJeu(){
		Jeux jeu = new Jeux();
		Etudiant Etudiant1 = new Etudiant(100, 0, 0);
		Etudiant Etudiant2 = new Etudiant(100, 0, 0);
		Etudiant Etudiant3 = new Etudiant(100, 0, 0);
		Etudiant Etudiant4 = new Etudiant(100, 0, 0);
		jeu.remplirListe(Etudiant1);
		jeu.remplirListe(Etudiant2);
		jeu.remplirListe(Etudiant3);
		jeu.remplirListe(Etudiant4);
	}
	
	public static void affiche(String string){
		System.out.println(string);
	}
	
	public static void main(String[] args){
		Jeux jeu = new Jeux();
		Plateau plateau = new Plateau();
		
		jeu.lancementJeu();
		plateau.creationPlateau();
		
			while(true){
				for (Etudiant elem: listeJoueur){
					try{
						
						affiche("------------------------------");
						affiche(elem.toString());
						
						affiche("Pour lancer les dés appuyer sur une touche du clavier et faites enter.");
						String c = sc.next();
						if(c.length()==1){
							
							int deplacement = elem.lanceDes();
							affiche("La valeur des dés est : " + deplacement + ".");
							elem.positionJoueur = elem.positionJoueur + deplacement;
							
							if(elem.positionJoueur < 40);
							else {elem.positionJoueur -= 40;
								elem.ects += 25;}
							Case cours = plateau.listeCase.get(elem.positionJoueur);
							affiche("Vous êtes arrivé sur " + cours.getNomCase() + ".");
							
							if(cours.getAchetable()){
								affiche("La case coùte " + cours.getPrixAchat() + " ects.");
								affiche("Il vous reste " + elem.ects +" ects.");
								affiche("Acheter la case oui : Y, non : N.");
								
								String achat = sc.next();
								if(achat.length()==1){
									switch(achat){
									case "Y" :
										elem.ects -= cours.getPrixAchat();
										cours.setProprietaire(elem.toString());
										affiche("Félicitation vous venez d'acheter " + cours.getNomCase() + ".");
										affiche("Il vous reste " + elem.ects + " ects.");
										break;
									case "N" :
										affiche("Dommage une prochaine fois peut-être.");
									}	
								}
								else break;
							}
							else{
								affiche("La case n'est pas achetable.");
							}
							
						}
						else break;
					}
					catch(InputMismatchException e){
					affiche("Format d'input incorrect");
					}
				}	
			}
			
	}
}