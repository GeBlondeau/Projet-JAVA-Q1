/**
 * 
 */
package projetJAVA;

/**
 * @author G�rault
 *
 */
public class CasePrison extends Case {

	
	
	public CasePrison(boolean achetable) {
		super(achetable);
	}

	public void purgerLaPeine(){
		if (Etudiant.etatPrison > 0) // si etatPrison de la classe Etudiant �gal � zero alors jouer
			Etudiant.etatPrison --; //sinon d�sincrementer l'etat de 1
	}
}
