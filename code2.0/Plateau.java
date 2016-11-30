/**
 * 
 */
package Ephecopoly;

/**
 * @author Gérault
 *
 */
public class Plateau {
	
	// Plateau Ephecopoly
		Case caseDepart=new Case(0,0,null,"Case de départ",0);
	//Premiere ligne
		Case C1=new Case(10,3,null,"Introduction télécom",1);		//Prix d'achats, prix du loyer, propriétaire, nom de la case, position 
		Case CC1=new Case(0,2,null,"Interrogation",2);
	    Case C2=new Case(7,2,null,"Télécommunication",3);
	    Case EX=new Case(0,4,null,"Examen",4);
	    Case PR1=new Case(5,2,null,"Javascript",5);
		Case C3=new Case(20,7,null,"Mathématique complexe",6);
		Case CH1=new Case(0,0,null,"Chance",7);
		Case C4=new Case(17,5,null,"Mathématique exposantiel",8);
		Case C5=new Case(16,9,null,"Mathématique trigonométrie",9);
		Case Prison=new Case(0,0,null,"Prison",10);
		
	//Deuxieme ligne
		Case C6=new Case(15,7,null,"Initiation au pc pratique",11);
		Case CL1=new Case(6,2,null,"Anglais",12);
		Case C7=new Case(11,4,null,"Introduction initiation au pc",13);
		Case C8=new Case(17,7,null,"Initiation chapitre2",14);
		Case PR2=new Case(5,2,null,"HTML",15);
		Case C9=new Case(14,4,null,"Réseau théorie",16);
		Case CC2=new Case(0,2,null,"Interrogation",17);
		Case C10=new Case(15,4,null,"Réseau pratique",18);
		Case C11=new Case(16,9,null,"Réseau 2ème",19);
		Case PG=new Case(0,0,null,"Parking Gratuit",20);	
		
	//Troisieme ligne
		Case C12=new Case(20,11,null,"Service réseau projet",21);
		Case CH2=new Case(0,0,null,"Chance",22);
		Case C13=new Case(15,8,null,"Service réseau théorie",23);
		Case C14=new Case(15,10,null,"Service réseau pratique",24);
		Case PR3=new Case(2,5,null,"CSS",25);
		Case C15=new Case(20,11,null,"Os théorie",26);
		Case C16=new Case(19,9,null,"Os pratique",27);
		Case CL2=new Case(6,2,null,"Nérlandais",28);
		Case C17=new Case(20,8,null,"Os oral",29);
		Case AEP=new Case(0,0,null,"Allez en Prison",30);	

	//Quatrieme ligne
		Case C18=new Case(25,14,null,"Développement application théorie",31);
		Case C19=new Case(20,14,null,"Développement application pratique",32);
		Case CC3=new Case(0,2,null,"Interrogation",33);
		Case C20=new Case(25,4,null,"Développement application projet",34);
		Case PR4=new Case(5,2,null,"SQL",35);
	    Case CH3=new Case(0,0,null,"Chance",36);
		Case C21=new Case(30,18,null,"Electronique analogique",37);
		Case EXA=new Case(0,10,null,"Exams Aout",38);
		Case C22=new Case(45,32,null,"Electronique digital",39);

		
public Case getCasePlateau(int Pos)
{
	if(Pos==0) return (caseDepart);
	//Premiere ligne
	if(Pos==1) return (C1);
	if(Pos==2) return (CC1);
	if(Pos==3) return (C2);
	if(Pos==4) return (EX);
	if(Pos==5) return (PR1);  	
	if(Pos==6) return (C3);
	if(Pos==7) return (CH1);
	if(Pos==8) return (C4);
	if(Pos==9) return (C5);
	if(Pos==10) return (Prison);
	
	//Deuxieme ligne
	if(Pos==11) return (C6);
	if(Pos==12) return (CL1);
	if(Pos==13) return (C7);
	if(Pos==14) return (C8);
	if(Pos==15) return (PR2); 	
	if(Pos==16) return (C9);
	if(Pos==17) return (CC2);
	if(Pos==18) return (C10);
	if(Pos==19) return (C11);
	if(Pos==20) return (PG);
	
	//Troisieme ligne
	if(Pos==21) return (C12);
	if(Pos==22) return (CH2);
	if(Pos==23) return (C13);
	if(Pos==24) return (C14);
	if(Pos==25) return (PR3);    	
	if(Pos==26) return (C15);
	if(Pos==27) return (C16);
	if(Pos==28) return (CL2);
	if(Pos==29) return (C17);
	if(Pos==30) return (AEP);
	
	//Quatrieme ligne   	
	if(Pos==31) return (C18);
	if(Pos==32) return (C19);
	if(Pos==33) return (CC3);
	if(Pos==34) return (C20);
	if(Pos==35) return (PR4);
	if(Pos==36) return (CH3);  	
	if(Pos==37) return (C21);
	if(Pos==38) return (EXA);
	if(Pos==39) return (C22);
	return null;
}

}