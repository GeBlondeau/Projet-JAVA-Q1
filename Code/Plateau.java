package projet_java;

public class Plateau {
	
	// chaque ligne est composée de : nomCase, achetable, gainECTS, prixAchat, nomMéthode
	String tableauDeCase[][] = new String [40][4];
	
	// crée le plateau de jeu en définissant les "valeurs" de toutes les cases
	public void lancementJeu(){
		tableauDeCase[0][0] = ("Case départ");
		tableauDeCase[0][1] = ("false");
		tableauDeCase[0][2] = ("");
		tableauDeCase[0][3] = ("");
		tableauDeCase[0][4] = ("");
	}

	public void main() {

	}

}
