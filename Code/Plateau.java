/**
 * 
 */
package projetJAVA;

/**
 * @author Gérault
 *
 */

public class Plateau {
	
	// chaque ligne est composée de : nomCase, achetable, gainECTS, prixAchat, nomMéthode
	String tableauDeCase[][] = new String [40][4];
	
	// crée le plateau de jeu en définissant les "valeurs" de toutes les cases
	public void lancementJeu(){
		String tableauDeCase[][] = {{"Case départ","false","","",""},{"Introduction télécom","True","3","10",""},{"Interrogation","False","2","0",""},{"Télécommunication","True","2","7",""},{"Examen","False","","4",""},{"Javascript","True","2","5",""},{"Initiation init","True","7","20",""},{"Anglais","True","2","6",""},{"Chance","","","",""},{"Introduction init","4","11","",""},{"Init chap2","True","7","17",""},{"Html","True","2","5",""},{"Réseau théorie","True","6","14",""},{"Interrogation","False","2","0",""},{"Réseau pratique","True","4","15",""},{"Réseau 2eme","True","9","16",""},{"Parking Gratuit","False","0","0",""},{"Service réseau projet","True","11","20",""},{"Chance","","","",""},{"Service réseau théorie","True","8","15",""},{"Service réseau pratique","True","10","15",""},{"CSS","True","2","5",""},{"Os théorie","True","11","20",""},{"Os pratique","True","9","19",""},{"Nérlandais","True","2","6"},{"Os oral","True","8","20",""},{"Aller en prison","False","","",""},{"Développement application théorie","True","14","25",""},{"Développement application pratique","True","14","20",""},{"Interrogations","False","2","0",""},{"Développement application projet","True","4","25",""},{"SQL","True","2","5",""},{"Chance","","","",""},{"Electronique analogique","True","18","30",""},{"Exams Aout","False","10","0",""},{"Electricité digital","true","32","45",""}};
		
	}	
	public static void main(String [] args) {
		/*String tableauDeCase[][] = {{"Case départ","false","","",""},{"Introduction télécom","True","3","10",""},{"Interrogation","False","2","0",""},{"Télécommunication","True","2","7",""},{"Examen","False","","4",""},{"Javascript","True","2","5",""},{"Initiation init","True","7","20",""},{"Anglais","True","2","6",""},{"Chance","","","",""},{"Introduction init","4","11","",""},{"Init chap2","True","7","17",""},{"Html","True","2","5",""},{"Réseau théorie","True","6","14",""},{"Interrogation","False","2","0",""},{"Réseau pratique","True","4","15",""},{"Réseau 2eme","True","9","16",""},{"Parking Gratuit","False","0","0",""},{"Service réseau projet","True","11","20",""},{"Chance","","","",""},{"Service réseau théorie","True","8","15",""},{"Service réseau pratique","True","10","15",""},{"CSS","True","2","5",""},{"Os théorie","True","11","20",""},{"Os pratique","True","9","19",""},{"Nérlandais","True","2","6"},{"Os oral","True","8","20",""},{"Aller en prison","False","","",""},{"Développement application théorie","True","14","25",""},{"Développement application pratique","True","14","20",""},{"Interrogations","False","2","0",""},{"Développement application projet","True","4","25",""},{"SQL","True","2","5",""},{"Chance","","","",""},{"Electronique analogique","True","18","30",""},{"Exams Aout","False","10","0",""},{"Electricité digital","true","32","45",""}};
		
		for(int i=0; i<40 ; i++){
			for(int j=0; j<5;j++){
				System.out.println("[" + i + "][" + j + "] " + tableauDeCase[i][j]);
			}
		}*/
	}

}
