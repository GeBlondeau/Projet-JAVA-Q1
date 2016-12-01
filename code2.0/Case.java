package Projet;

public class Case {
	
	private int prixAchat;
	private int prixLoyer;
	private String proprietaire;
	private String nomCase;
	private int positionCase;
	private boolean achetable;
	
	public int getPrixAchat() {
		return prixAchat;
	}
	public int getPrixLoyer() {
		return prixLoyer;
	}
	public String getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(String proprietaire) {
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

	public Case(int prixAchat, int prixLoyer, String proprietaire, String nomCase
			, int positionCase, boolean achetable) {
		this.prixAchat = prixAchat;
		this.prixLoyer = prixLoyer;
		this.proprietaire = proprietaire;
		this.nomCase = nomCase;
		this.positionCase = positionCase;
		this.achetable = achetable;
		
	}
	
}