package projet_java;

public class Plateau {
	
	// chaque ligne est compos�e de : nomCase, achetable, gainECTS, prixAchat, nomM�thode
	String tableauDeCase[][] = new String [40][4];
	
	// cr�e le plateau de jeu en d�finissant les "valeurs" de toutes les cases
	public void lancementJeu(){
		tableauDeCase[0][0] = ("Case d�part");
		tableauDeCase[0][1] = ("false");
		tableauDeCase[0][2] = ("");
		tableauDeCase[0][3] = ("");
		tableauDeCase[0][4] = ("");
	}

	public void main() {

	}

}
