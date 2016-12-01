package Ephecopoly;
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
			Case C0=new Case(0,15,null,"Case de départ",0,false);
		//Premiere ligne
							//Prix d'achats, prix du loyer, propriétaire, nom de la case, position 
			Case C1=new Case(10,3,null,"Introduction télécom",1,true);
			Case C2=new Case(0,2,null,"Interrogation",2,false);
		    Case C3=new Case(7,2,null,"Télécommunication",3,true);
		    Case C4=new Case(0,15,null,"Examen",4,false);
		    Case C5=new Case(5,2,null,"Javascript",5,true);
			Case C6=new Case(20,7,null,"Mathématique complexe",6,true);
			Case C7=new Case(0,0,null,"Chance",7,false);
			Case C8=new Case(17,5,null,"Mathématique exponentiel",8,true);
			Case C9=new Case(16,9,null,"Mathématique trigonométrie",9,true);
			Case C10=new Case(0,0,null,"Prison",10,false);
			
		//Deuxieme ligne
			Case C11=new Case(15,7,null,"Initiation au pc pratique",11,true);
			Case C12=new Case(6,2,null,"Anglais",12,true);
			Case C13=new Case(11,4,null,"Introduction initiation au pc",13,true);
			Case C14=new Case(17,7,null,"Initiation chapitre2",14,true);
			Case C15=new Case(5,2,null,"HTML",15,true);
			Case C16=new Case(14,4,null,"Réseau théorie",16,true);
			Case C17=new Case(0,2,null,"Interrogation",17,false);
			Case C18=new Case(15,4,null,"Réseau pratique",18,true);
			Case C19=new Case(16,9,null,"Réseau 2ème",19,true);
			Case C20=new Case(0,0,null,"Parking Gratuit",20,false);	
			
		//Troisieme ligne
			Case C21=new Case(20,11,null,"Service réseau projet",21,true);
			Case C22=new Case(0,0,null,"Chance",22,false);
			Case C23=new Case(15,8,null,"Service réseau théorie",23,true);
			Case C24=new Case(15,10,null,"Service réseau pratique",24,true);
			Case C25=new Case(2,5,null,"CSS",25,true);
			Case C26=new Case(20,11,null,"Os théorie",26,true);
			Case C27=new Case(19,9,null,"Os pratique",27,true);
			Case C28=new Case(6,2,null,"Néerlandais",28,true);
			Case C29=new Case(20,8,null,"Os oral",29,true);
			Case C30=new Case(0,0,null,"Allez en Prison",30,false);	

		//Quatrieme ligne
			Case C31=new Case(25,14,null,"Développement application théorie",31,true);
			Case C32=new Case(20,14,null,"Développement application pratique",32,true);
			Case C33=new Case(0,2,null,"Interrogation",33,false);
			Case C34=new Case(25,4,null,"Développement application projet",34,true);
			Case C35=new Case(5,2,null,"SQL",35,true);
		    Case C36=new Case(0,0,null,"Chance",36,false);
			Case C37=new Case(30,18,null,"Electronique analogique",37,true);
			Case C38=new Case(0,10,null,"Exams Aout",38,false);
			Case C39=new Case(45,32,null,"Electronique digital",39,true);

}