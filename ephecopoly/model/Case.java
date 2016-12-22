package ephecopoly.model;

/*
 * @author Lambin N., Blondeau G.
 */

import java.util.Observable;

public class Case extends Observable{
	
	private int prixAchat; 
	private int prixLoyer; 
	private Etudiant proprietaire;
	private String nomCase; 
	private int positionCase; 
	private boolean achetable; 
	
	/*
	 * Créé une nouvelle case avec un prix d'achat, un loyer, un propriétaire, 
	 * 		un nom, une position et une "achetabilitée".
	 * @param prixAchat int : prix d'achat de la case.
	 * @param prixLoyer int : loyer à payer au proiétaire de la case (si il y en à un).
	 * @param proprietaire Etudiant : le propriétaire de la case, par défaut égal à null.
	 * @param nomCase String : le nom de la case.
	 * @param positionCase int : la position de la case sur le plateau de jeu.
	 * @param achetable boolean : si true la case peut être achetée par un étudiant,
	 * 		si false la case ne pourra jamais être achetée.
	 */
	public Case(int prixAchat, int prixLoyer, Etudiant proprietaire, String nomCase
			, int positionCase, boolean achetable) {
		this.prixAchat = prixAchat;
		this.prixLoyer = prixLoyer;
		this.proprietaire = proprietaire;
		this.nomCase = nomCase;
		this.positionCase = positionCase;
		this.achetable = achetable;
		
	}
	
	public int getPrixAchat() {
		return prixAchat;
	}
	public int getPrixLoyer() {
		return prixLoyer;
	}
	public Etudiant getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Etudiant proprietaire) {
		this.proprietaire = proprietaire;
	}
	public String getNomCase() {
		return nomCase;
	}
	public int getPositionCase() {
		return positionCase;
	}
	public boolean getAchetable() {
		return achetable;
	}
}