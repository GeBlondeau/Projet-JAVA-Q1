package ephecopoly.model;

import java.util.Random;
import java.util.Observable;

public class Etudiant extends Observable {
	
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
	public int getPositionEtudiant() {
		return positionJoueur;
	}
	public void setPositionEtudiant(int positionJoueur) {
		this.positionJoueur = positionJoueur;
	}
	public String getNomEtudiant() {
		return nomEtudiant;
	}
	public boolean getEtatJeu() {
		return etatJeu;
	}
	public void setEtatJeu(boolean jeuEtudiant) {
		this.etatJeu = jeuEtudiant;
	}
	public boolean getEtatDes() {
		return etatDes;
	}
	public void setEtatDes(boolean jeuEtudiant) {
		this.etatDes = jeuEtudiant;
	}

	private int ects;
	private int etatPrison;
	private int positionJoueur;
	private String nomEtudiant;
	private boolean etatJeu;
	private boolean etatDes;

	public Etudiant(int ects, int etatPrison, int positionJoueur, String nomEtudiant, boolean etatJeu, boolean etatDes){
		this.ects = ects;
		this.etatPrison = etatPrison;
		this.positionJoueur = positionJoueur;
		this.nomEtudiant = nomEtudiant;
		this.etatJeu = etatJeu;
		this.etatDes = etatDes;
	}
	
	public int lanceDes(){
		Random rand = new Random();
		int nombre1 = 1 + rand.nextInt(7-1); //Entre 1 et 6 
		int nombre2 = 1 + rand.nextInt(7-1); //Entre 1 et 6
		int valeur =  nombre1 + nombre2; //Additionner les deux dés à la position actuel du joueur
		return valeur;
	}
	public void main(String arg[]){
		
	}
}