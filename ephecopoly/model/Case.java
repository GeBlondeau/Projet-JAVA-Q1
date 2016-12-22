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
	 * Cr�� une nouvelle case avec un prix d'achat, un loyer, un propri�taire, 
	 * 		un nom, une position et une "achetabilit�e".
	 * @param prixAchat int : prix d'achat de la case.
	 * @param prixLoyer int : loyer � payer au proi�taire de la case (si il y en � un).
	 * @param proprietaire Etudiant : le propri�taire de la case, par d�faut �gal � null.
	 * @param nomCase String : le nom de la case.
	 * @param positionCase int : la position de la case sur le plateau de jeu.
	 * @param achetable boolean : si true la case peut �tre achet�e par un �tudiant,
	 * 		si false la case ne pourra jamais �tre achet�e.
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