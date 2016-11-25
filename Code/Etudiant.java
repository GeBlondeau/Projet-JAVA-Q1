/**
 * 
 */
package projetJAVA;

/**
 * @author Gérault
 *
 */
public class Etudiant extends Solvable{
	static int etatPrison;
	
	public Etudiant(int ects){
		super (ects);
		Solvable.ects = ects;
	}

}
