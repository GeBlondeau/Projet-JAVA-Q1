/*
 * 
 */
package projet_java;
/**
 * @authors No� Lambin and G�rault Blondeau
 */
public class CaseParkingGratuit extends Case {

	public CaseParkingGratuit(boolean achetable) {
		super(achetable);
	}

	// l'�tudiant qui tombe sur la case r�cup�re l'argent (ects) des 'imp�ts'/interro
	public void recevoirArgent(int y){
		Etudiant.ects += y;
	}
}