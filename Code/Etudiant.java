package projet_java;

public class Etudiant extends Solvable {
	
	int etatPrison;
	
	public Etudiant(int ects, int etatPrison){
		super(ects);
		this.etatPrison = etatPrison;
	}
	
	public void main(String arg[]){
		Etudiant etu = new Etudiant(50, 0);
		
		
	}
}
