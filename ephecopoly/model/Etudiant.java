package ephecopoly.model;

/*
 * @author Lambin N., Blondeau G.
 */

import java.util.Random;
import java.util.Observable;

public class Etudiant extends Observable {
	
	private int ects; 
	private int etatPrison; 
	private int positionEtudiant; 
	private String nomEtudiant; 
	private boolean etatJeu;  
	private boolean etatDes; 
	
	/*
	 * Créé un nouvel étudiant avec des ects, un etatPrison, une position, 
	 * 		un nom, un etatJeu et un etatDes.
	 * 
	 * @param ects int : argent possédé par l'étudiant, l'étudiant commence la partie avec 100 ects.
	 * @param etatPrison int : si 0 l'étudiant est libre; sinon c'est égal au nombres de tours 
	 * 		que l'étudiant passera en prison.
	 * @param positionEtudiant int : compris entre 0 et 39 
	 * 		définis la position de l'étudiant sur le plateau.
	 * @param nomEtudiant String : nom de l'étudiant
	 * @param etatJeu boolean : si true l'étudiant est encore dans la partie, 
	 * 		si false létudiant est éliminé de la partie
	 * @param etatDes boolean : défini si l'étudiant lance les dés ou non, est à false par défaut
	 */
	public Etudiant(int ects, int etatPrison, int positionEtudiant, String nomEtudiant, boolean etatJeu, boolean etatDes){
		this.ects = ects;
		this.etatPrison = etatPrison;
		this.positionEtudiant = positionEtudiant;
		this.nomEtudiant = nomEtudiant;
		this.etatJeu = etatJeu;
		this.etatDes = etatDes;
	}
	
	/* 
	* Méthode permettant de simuler un lancement de 2 dés avec la même 
	* 		probabilitée de résultat que dans la réalitée 
	* @return : une valeur comprise entre 2 et 12.
	*/
	public int lanceDes(){
		Random rand = new Random();
		int nombre1 = 1 + rand.nextInt(7-1); //Entre 1 et 6 
		int nombre2 = 1 + rand.nextInt(7-1); //Entre 1 et 6
		int valeur =  nombre1 + nombre2; //Additionner la valeur des 2 dés
		return valeur;
	}
	
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
		return positionEtudiant;
	}
	public void setPositionEtudiant(int positionJoueur) {
		this.positionEtudiant = positionJoueur;
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
	
	public void main(String arg[]){
		
	}
}