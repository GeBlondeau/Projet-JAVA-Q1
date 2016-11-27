/**
 * 
 */
package projetJAVA;

/**
 * @author Gérault
 *
 */
public class CaseParkingGratuit extends Case {

	public CaseParkingGratuit(boolean achetable) {
		super(achetable);
	}

	public void recevoirArgent(){
		Etudiant.ects = Etudiant.ects + 5;
	}
}
