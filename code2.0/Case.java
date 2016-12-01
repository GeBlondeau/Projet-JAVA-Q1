package Projet;

public class Case {
	
	static int prixAchat;
	static int prixLoyer;
	static Etudiant proprietaire;
	static String nomCase;
	static int positionCase;
	
	public int getPrixAchat() {
		return prixAchat;
	}

	public int getPrixLoyer() {
		return prixLoyer;
	}

	public Etudiant getProprietaire() {
		return proprietaire;
	}

	public String getNomCase() {
		return nomCase;
	}

	public int getPositionCase() {
		return positionCase;
	}

	public Case(int prixAchat, int prixLoyer, Etudiant proprietaire, String nomCase, int positionCase) {	
	}
	
}