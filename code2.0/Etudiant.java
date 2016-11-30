package Ephecopoly;

public class Etudiant {
	
	int ects;
	int etatPrison;
	
	public Etudiant(int ects, int etatPrison){
		this.ects = ects;
		this.etatPrison = etatPrison;
	}
	
	public static String affiche(Etudiant x){
		String a = "Argent du joueur : " + x.ects + "\n";
		a += "Etat de prison : " + x.etatPrison;
		return a;
	}
	
	public static void main(String arg[]){
		
	}
}
