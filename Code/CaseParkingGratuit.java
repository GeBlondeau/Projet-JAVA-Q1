/*
 * 
 */
package projet_java;
/**
 * @authors Noé Lambin and Gérault Blondeau
 */
public class CaseParkingGratuit extends Case {

	public CaseParkingGratuit(boolean achetable) {
		super(achetable);
	}

	// l'étudiant qui tombe sur la case récupère l'argent (ects) des 'impôts'/interro
	public void recevoirArgent(int y){
		Etudiant.ects += y;
	}
}