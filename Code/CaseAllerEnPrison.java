/**
 * 
 */
package projetJAVA;

/**
 * @author G�rault
 *
 */
public class CaseAllerEnPrison extends Case {

	public CaseAllerEnPrison(boolean achetable) {
		super(achetable);
	}
	
	public void allerEnPrison(){
		Etudiant.etatPrison = 2;
		Jeux.position= 10;
	}

}
