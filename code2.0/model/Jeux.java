package ephecopoly.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Observable;


public class Jeux extends Observable{

	static Scanner sc = new Scanner(System.in);
	public static List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
	
	public void remplirListe(Etudiant joueur){
		listeEtudiant.add(joueur);
	}
	public List<Etudiant> getListeEtudiant(){
		return listeEtudiant;
	}
	public void lancerJeu(){
		Jeux jeu = new Jeux();
		Etudiant Etudiant1 = new Etudiant(100, 0, 0,"Le Bon");
		Etudiant Etudiant2 = new Etudiant(100, 0, 0,"La Brute");
		//Etudiant Etudiant3 = new Etudiant(100, 0, 0,"Le Truand");
		//Etudiant Etudiant4 = new Etudiant(100, 0, 0,"Pour réussir l'année");
		jeu.remplirListe(Etudiant1);
		jeu.remplirListe(Etudiant2);
		//jeu.remplirListe(Etudiant3);
		//jeu.remplirListe(Etudiant4);
	}
	public void finDuJeu(){
		
	}
	
	public static void main(String[] args){
		
	}
}