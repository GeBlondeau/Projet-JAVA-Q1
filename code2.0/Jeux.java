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
						
						System.out.println("------------------------------");
						
						int deplacement = elem.lanceDes();
						affiche("Pour voir la valeur des dés appuyer sur une touche et faites enter.");
						String c = sc.next();
						if(c.length()==1){
							affiche("La valeur des dés est : " + deplacement);
							elem.positionJoueur = elem.positionJoueur + deplacement;
							if(elem.positionJoueur < 40){
								affiche("Vous êtes maintenant sur la " + elem.positionJoueur + "° case du plateau");
								Case cours = plateau.listeCase.get(elem.positionJoueur);
								affiche("La case s'appelle : " + cours.getNomCase());
							}
							else {
								elem.positionJoueur -= 40;
								affiche("Vous êtes maintenant sur la " + elem.positionJoueur + "° case du plateau");
								Case cours = plateau.listeCase.get(elem.positionJoueur);
								affiche("La case s'appelle : " + cours.getPrixLoyer());
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