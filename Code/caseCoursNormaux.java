/**
 * 
 */
package projetJAVA;

import tpJAVA.Cercle;

/**
 * @author G�rault
 *
 */
public class caseCoursNormaux extends CasePayante{
	int prixAchat;

	public caseCoursNormaux(boolean achetable, int gainECTS, int prixAchat){
		super(achetable, gainECTS);
		this.prixAchat = prixAchat;
	}
}
