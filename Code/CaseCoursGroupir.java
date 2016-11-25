/**
 * 
 */
package projet_java;

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
	public String toString(){
		String result = "La case rapporte : "  + gainECTS + "\n";
		result += "La Case est achetable : " + achetable + "\n";
		result += "La case coûte : " + prixAchat + " ECTS \n";
		return result;
	}
	public void CalculGainsECTS(){
		
	}
	
	public static void main(String[] args) {
		CaseCoursGroupir eau = new CaseCoursGroupir(true, 5, 50 );
		System.out.println(eau.prixAchat);

	}

}
