/**
 * 
 */
package projetJAVA;

/**
 * @author G�rault
 *
 */
public class CasePrison {

	
	
	public void prison(){
		if (Etudiant.etatPrison > 0) // si etatPrison de la classe Etudiant �gal � zero alors jouer
			Etudiant.etatPrison --; //sinon d�sincrementer l'etat de 1
	}
}
