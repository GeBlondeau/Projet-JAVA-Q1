package ephecopoly.model;

/*
 * @author Lambin N., Blondeau G.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class Jeux extends Observable{

	
	private static List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
	
	private String jeuString = null;
	private Etudiant etudiantActuel;
	
	/* 
	 *Méthode utilisée pour mettre finà la partie d'un étudiant en particulier. 
	 */
	public void finDuJeu(Etudiant etudiant){
		etudiant.setEtatJeu(false);
	}
	/* 
	 * Méthode permettant de remplir la liste des joueurs au début de la partie.
	 */
	public void remplirListe(Etudiant joueur){
		listeEtudiant.add(joueur);
	}
	
	public void creationPlateau(Plateau plateau){
		plateau.creationPlateau();
	}
	public Etudiant getEtudiantActuel() {
		return etudiantActuel;
	}
	public void setEtudiantActuel(Etudiant etudiantActuel) {
		this.etudiantActuel = etudiantActuel;
		setChanged();
		notifyObservers();
	}
	public List<Etudiant> getListeEtudiant(){
		return listeEtudiant;
	}
	public int getPrixAchat(Case cours) {
		return cours.getPrixAchat();
	}
	public int getPrixLoyer(Case cours) {
		return cours.getPrixLoyer();
	}
	public Etudiant getProprietaire(Case cours) {
		return cours.getProprietaire();
	}
	public void setProprietaire(Etudiant proprietaire, Case cours) {
		cours.setProprietaire(proprietaire);
		setChanged();
		notifyObservers();
	}
	public String getNomCase(Case cours) {
		return cours.getNomCase();
	}
	public int getPositionCase(Case cours) {
		return cours.getPositionCase();
	}
	public boolean getAchetable(Case cours) {
		return cours.getAchetable();
	}
	
	public int getEcts(Etudiant etudiant) {
		return etudiant.getEcts();
	}
	public void setEcts(Etudiant etudiant, int ects) {
		etudiant.setEcts(ects);
		setChanged();
		notifyObservers();
	}
	public int getEtatPrison(Etudiant etudiant) {
		return etudiant.getEtatPrison();
	}
	public void setEtatPrison(Etudiant etudiant, int etatPrison) {
		etudiant.setEtatPrison(etatPrison);
		setChanged();
		notifyObservers();
	}
	public int getPositionEtudiant(Etudiant etudiant) {
		return etudiant.getPositionEtudiant();
	}
	public void setPositionEtudiant(Etudiant etudiant, int positionJoueur) {
		etudiant.setPositionEtudiant(positionJoueur);
		setChanged();
		notifyObservers();
	}
	public String getNomEtudiant(Etudiant etudiant) {
		return etudiant.getNomEtudiant();
	}
	public boolean getEtatJeu(Etudiant etudiant) {
		return etudiant.getEtatJeu();
	}
	public void setEtatJeu(Etudiant etudiant, boolean jeuEtudiant) {
		etudiant.setEtatJeu(jeuEtudiant);
		setChanged();
		notifyObservers();
	}
	public boolean getEtatDes(Etudiant etudiant) {
		return etudiant.getEtatDes();
	}
	public void setEtatDes(Etudiant etudiant, boolean jeuEtudiant) {
		etudiant.setEtatDes(jeuEtudiant);
		setChanged();
		notifyObservers();
	}
	public int lanceDes(Etudiant etudiant){
		return etudiant.lanceDes();
	}
	
	public List<Case> getListeCase(Plateau plateau) {
		return plateau.getListeCase();
	}
	public Case getCase(Etudiant etudiant, Jeux jeu, Plateau plateau){
		return plateau.getCase(etudiant, jeu);
	}
	public String getJeuString() {
		return jeuString;
	}
	public void addJeuString(String jeuString) {
		this.jeuString += jeuString;
		setChanged();
		notifyObservers();
	}
	public void setJeuString(String jeuString) {
		this.jeuString = jeuString;
		setChanged();
		notifyObservers();
	}
	public static void main(String[] args){
		
	}
}