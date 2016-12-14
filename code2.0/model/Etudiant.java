package ephecopoly.model;

import java.util.Random;
import java.util.Observable;

public class Etudiant extends Observable {
	
	public int getEcts() {
		return ects;
	}
	public void setEcts(int ects) {
		this.ects += ects;
		setChanged();
		notifyObservers();
	}
	public int getEtatPrison() {
		return etatPrison;
	}
	public void setEtatPrison(int etatPrison) {
		this.etatPrison = etatPrison;
		setChanged();
		notifyObservers();
	}
	public int getPositionEtudiant() {
		return positionJoueur;
	}
	public void setPositionEtudiant(int positionJoueur) {
		this.positionJoueur = positionJoueur;
		setChanged();
		notifyObservers();
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
	public void main(String arg[]){
		
	}
}