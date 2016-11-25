/**
 * 
 */
package projetJAVA;

/**
 * @author Gérault
 *
 */
public class Jeux {
	static int position;


	public int lanceDes(){
		Random rand = new Random();
		int nombre1 = 1 + rand.nextInt(7-1); //Entre 1 et 6 
		int nombre2 = 1 + rand.nextInt(7-1); //Entre 1 et 6
		int nombreFinal = nombre1 + nombre2; //Additionner les deux dés	 
		return nombreFinal; //remplacer emplacement par la valeur de placeActeul à la fin du tour
	}
	public static void arrylist(String[] args) {
		  listeJoueur = new ArrayList<String>();
		  listeJoueur = null;					//Vider la liste
		  listeJoueur.add("Etudiant1");			//Jouter des étudiants
		  listeJoueur.add("Etudiant2");
		  listeJoueur.add("Etudiant3");
		  listeJoueur.add("Etudiant4");
	}
}
