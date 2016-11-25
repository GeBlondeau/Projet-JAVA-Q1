/**
 * 
 */
package projetJAVA;

/**
 * @author Gérault
 *
 */
public class CaseParkingGratuis extends Case {

	public CaseParkingGratuis(boolean achetable) {
		super(achetable);
	}

	public void recevoirArgent(){
		Etudiant.ects = Etudiant.ects + 5;
	}
}
