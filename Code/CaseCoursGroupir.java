/**
 * 
 */
package projetJAVA;

/**
 * @author Noé Lambin
 *
 */
public class CaseCoursGroupir extends CasePayante {

	int prixAchat;
	
	public CaseCoursGroupir(boolean achetable, int gainECTS, int prixAchat){
		super(achetable, gainECTS);
		this.prixAchat = prixAchat;
	}

	public void CalculGainsECTS(){
		
	}
}