/**
 * 
 */
package projetJAVA;

/**
 * @author Gérault
 *
 */
public class CasePrison {

	
	
	public void purgerLaPeine(){
		if (Etudiant.etatPrison > 0) // si etatPrison de la classe Etudiant égal à zero alors jouer
			Etudiant.etatPrison --; //sinon désincrementer l'etat de 1
	}
}
