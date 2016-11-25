/**
 * 
 */
package projetJAVA;

/**
 * @author Noé Lambin
 *
 */
public class CasePayante extends Case {

	/**
	 * @param args
	 */
	public int gainECTS;
	
	public CasePayante(boolean achetable, int gainECTS){
		super(achetable);
		this.gainECTS = gainECTS;
	}
	public static void main(String[] args) {

	}

}
