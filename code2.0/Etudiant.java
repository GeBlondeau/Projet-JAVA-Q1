package Projet;

import java.util.Random;

public class Etudiant {
	
	public int getEcts() {
		return ects;
	}
	public void setEcts(int ects) {
		this.ects += ects;
	}
	public int getEtatPrison() {
		return etatPrison;
	}
	public void setEtatPrison(int etatPrison) {
		this.etatPrison = etatPrison;
	}
	public int getPositionJoueur() {
		return positionJoueur;
	}
	public void setPositionJoueur(int positionJoueur) {
		this.positionJoueur = positionJoueur;
	}
	public String getNomEtudiant() {
		return nomEtudiant;
	}

	private int ects;
	private int etatPrison;
	private int positionJoueur;
	private String nomEtudiant;

	public Etudiant(int ects, int etatPrison, int positionJoueur, String nomEtudiant){
		this.ects = ects;
		this.etatPrison = etatPrison;
		this.positionJoueur = positionJoueur;
		this.nomEtudiant = nomEtudiant;
	}
	
	public int lanceDes(){
		Random rand = new Random();
		int nombre1 = 1 + rand.nextInt(7-1); //Entre 1 et 6 
		int nombre2 = 1 + rand.nextInt(7-1); //Entre 1 et 6
		int valeur =  nombre1 + nombre2; //Additionner les deux dés à la position actuel du joueur
		return valeur;
	}
	
	public void affiche(String string){
		System.out.println(string);
	}
	public void lancementTourEtudiant(Etudiant etudiant, Jeux jeu, Plateau plateau){
		if(etudiant.getEtatPrison() == 0){
			
			jeu.affichage(plateau, etudiant, jeu);
		}
		else {
			affiche("Vous êtes en Prison pour encore : " + etudiant.getEtatPrison()  
					+ " tour(s).");
			etudiant.setEtatPrison(etudiant.getEtatPrison()-1);
		}
	}
	
	public void main(String arg[]){
		
	}
}