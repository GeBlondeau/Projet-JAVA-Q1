package Projet;
import java.util.ArrayList;
import java.util.List;


public class Plateau {
	
	List<Case> listeCase = new ArrayList<Case>();
	
	private void remplirListe(Case cour){
		listeCase.add(cour);
	}
	public void creationPlateau(){
		remplirListe(C0);
		remplirListe(C1);
		remplirListe(C2);
		remplirListe(C3);
		remplirListe(C4);
		remplirListe(C5);
		remplirListe(C6);
		remplirListe(C7);
		remplirListe(C8);
		remplirListe(C9);
		remplirListe(C10);
		remplirListe(C11);
		remplirListe(C12);
		remplirListe(C13);
		remplirListe(C14);
		remplirListe(C15);
		remplirListe(C16);
		remplirListe(C17);
		remplirListe(C18);
		remplirListe(C19);
		remplirListe(C20);
		remplirListe(C21);
		remplirListe(C22);
		remplirListe(C23);
		remplirListe(C24);
		remplirListe(C25);
		remplirListe(C26);
		remplirListe(C27);
		remplirListe(C28);
		remplirListe(C29);
		remplirListe(C30);
		remplirListe(C31);
		remplirListe(C32);
		remplirListe(C33);
		remplirListe(C34);
		remplirListe(C35);
		remplirListe(C36);
		remplirListe(C37);
		remplirListe(C38);
		remplirListe(C39);
	}
	
	// Plateau Ephecopoly
			Case C0=new Case(0,0,null,"Case de départ",0);
		//Premiere ligne
			Case C1=new Case(10,3,null,"Introduction télécom",1);		//Prix d'achats, prix du loyer, propriétaire, nom de la case, position 
			Case C2=new Case(0,2,null,"Interrogation",2);
		    Case C3=new Case(7,2,null,"Télécommunication",3);
		    Case C4=new Case(0,4,null,"Examen",4);
		    Case C5=new Case(5,2,null,"Javascript",5);
			Case C6=new Case(20,7,null,"Mathématique complexe",6);
			Case C7=new Case(0,0,null,"Chance",7);
			Case C8=new Case(17,5,null,"Mathématique exposantiel",8);
			Case C9=new Case(16,9,null,"Mathématique trigonométrie",9);
			Case C10=new Case(0,0,null,"Prison",10);
			
		//Deuxieme ligne
			Case C11=new Case(15,7,null,"Initiation au pc pratique",11);
			Case C12=new Case(6,2,null,"Anglais",12);
			Case C13=new Case(11,4,null,"Introduction initiation au pc",13);
			Case C14=new Case(17,7,null,"Initiation chapitre2",14);
			Case C15=new Case(5,2,null,"HTML",15);
			Case C16=new Case(14,4,null,"Réseau théorie",16);
			Case C17=new Case(0,2,null,"Interrogation",17);
			Case C18=new Case(15,4,null,"Réseau pratique",18);
			Case C19=new Case(16,9,null,"Réseau 2ème",19);
			Case C20=new Case(0,0,null,"Parking Gratuit",20);	
			
		//Troisieme ligne
			Case C21=new Case(20,11,null,"Service réseau projet",21);
			Case C22=new Case(0,0,null,"Chance",22);
			Case C23=new Case(15,8,null,"Service réseau théorie",23);
			Case C24=new Case(15,10,null,"Service réseau pratique",24);
			Case C25=new Case(2,5,null,"CSS",25);
			Case C26=new Case(20,11,null,"Os théorie",26);
			Case C27=new Case(19,9,null,"Os pratique",27);
			Case C28=new Case(6,2,null,"Nérlandais",28);
			Case C29=new Case(20,8,null,"Os oral",29);
			Case C30=new Case(0,0,null,"Allez en Prison",30);	

		//Quatrieme ligne
			Case C31=new Case(25,14,null,"Développement application théorie",31);
			Case C32=new Case(20,14,null,"Développement application pratique",32);
			Case C33=new Case(0,2,null,"Interrogation",33);
			Case C34=new Case(25,4,null,"Développement application projet",34);
			Case C35=new Case(5,2,null,"SQL",35);
		    Case C36=new Case(0,0,null,"Chance",36);
			Case C37=new Case(30,18,null,"Electronique analogique",37);
			Case C38=new Case(0,10,null,"Exams Aout",38);
			Case C39=new Case(45,32,null,"Electronique digital",39);
		
	public static void main(String[] args){
		Plateau nouv = new Plateau();
		nouv.creationPlateau();
		Case C40 = new Case(50,20,null,"case de noé",40);
		System.out.println(C40.getPositionCase());
	}

}