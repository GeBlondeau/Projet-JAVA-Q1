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
	 * Cr�� un nouvel �tudiant avec des ects, un etatPrison, une position, 
	 * 		un nom, un etatJeu et un etatDes.
	 * 
	 * @param ects int : argent poss�d� par l'�tudiant, l'�tudiant commence la partie avec 100 ects.
	 * @param etatPrison int : si 0 l'�tudiant est libre; sinon c'est �gal au nombres de tours 
	 * 		que l'�tudiant passera en prison.
	 * @param positionEtudiant int : compris entre 0 et 39 
	 * 		d�finis la position de l'�tudiant sur le plateau.
	 * @param nomEtudiant String : nom de l'�tudiant
	 * @param etatJeu boolean : si true l'�tudiant est encore dans la partie, 
	 * 		si false l�tudiant est �limin� de la partie
	 * @param etatDes boolean : d�fini si l'�tudiant lance les d�s ou non, est � false par d�faut
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
	* M�thode permettant de simuler un lancement de 2 d�s avec la m�me 
	* 		probabilit�e de r�sultat que dans la r�alit�e 
	* @return : une valeur comprise entre 2 et 12.
	*/
	public int lanceDes(){
		Random rand = new Random();
		int nombre1 = 1 + rand.nextInt(7-1); //Entre 1 et 6 
		int nombre2 = 1 + rand.nextInt(7-1); //Entre 1 et 6
		int valeur =  nombre1 + nombre2; //Additionner la valeur des 2 d�s
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