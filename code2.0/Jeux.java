package Projet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Jeux{

	static Scanner sc = new Scanner(System.in);
	static List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
	
	public void remplirListe(Etudiant joueur){
		listeEtudiant.add(joueur);
	}
	public void lancementJeu(){
		Jeux jeu = new Jeux();
		Etudiant Etudiant1 = new Etudiant(100, 0, 0,"Le Bon");
		Etudiant Etudiant2 = new Etudiant(100, 0, 0,"La Brute");
		//Etudiant Etudiant3 = new Etudiant(100, 0, 0,"Le Truand");
		//Etudiant Etudiant4 = new Etudiant(100, 0, 0,"Pour réussir l'année");
		jeu.remplirListe(Etudiant1);
		jeu.remplirListe(Etudiant2);
		//jeu.remplirListe(Etudiant3);
		//jeu.remplirListe(Etudiant4);
	}
	public void infoCase(Etudiant etudiant, Case cours){
		affiche("La case coute " + cours.getPrixAchat() + " ects.");
		affiche("La case rapporte " + cours.getPrixLoyer() + " ects.");
		affiche("Il vous reste " + etudiant.getEcts() +" ects.");
	}
	public void demandeAchatCase(Etudiant etudiant, Case cours){
		boolean	format = true;
		while(format){
			try{
				affiche("Etudier pour passer l'examen? Oui -> Y, non -> N.");
				String achat = sc.next();
				if(achat.length()==1)
					switch(achat){
					case "Y" :
						etudiant.setEcts(-cours.getPrixAchat());
						cours.setProprietaire(etudiant);
						affiche("Félicitation vous venez de réussir le cours de " 
								+ cours.getNomCase() + ".");
						affiche("Il vous reste " + etudiant.getEcts() + " ects.");
						format = false;
						break;
					case "N" :
						affiche("Dommage, on se revera en août!");
						format = false;
						break;
					default :
						affiche("Format d'input incorrect error5.");
					}
				else 
					affiche("Format d'input incorrect error4.");
			}
			catch(InputMismatchException f){
				affiche("Format d'input incorrect error3.");
			}
		}
	}
	
	public void caseDejaAchete(Etudiant etudiant){
		affiche("Vous avez déjà réussi ce cours");
		affiche("Vous avez toujours " + etudiant.getEcts() + " ects.");
	}
	public void casePayerLoyer(Etudiant etudiant, Case cours){
		affiche("Le cours a déjà été réussi par : " 
			+ cours.getProprietaire().getNomEtudiant() + ".");
		int loyer = cours.getPrixLoyer();
		etudiant.setEcts(-loyer);
		cours.getProprietaire().setEcts(loyer);
		affiche("Vous devez lui payer : " + loyer + " ects.");
		affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
	}
	public void affichage(Plateau plateau, Etudiant etudiant, Jeux jeu){
		affiche("Pour lancer les dés appuyer sur une "
				+ "ou plusieurs touches du clavier et faites enter.");
			String c = sc.next();
			if(c.length()!=0){
				int deplacement = etudiant.lanceDes();
				affiche("La valeur des dés est : " + deplacement + ".");
				etudiant.setPositionJoueur(etudiant.getPositionJoueur() + deplacement);
				
				plateau.positionEtudiant(plateau, etudiant);
				Case cours = plateau.listeCase.get(etudiant.getPositionJoueur());
				affiche("Vous êtes arrivé sur " + cours.getNomCase() + ".");
				jeu.actionCase(etudiant, cours, deplacement, jeu);
			}	
			else {
			affiche("Format d'input incorrect error2.");
			}
	}
	
	public void actionCase(Etudiant etudiant, Case cours, int deplacement, Jeux jeu){
		if(cours.getAchetable() && cours.getProprietaire() == null){
			jeu.infoCase(etudiant, cours);
			jeu.demandeAchatCase(etudiant, cours);
		}
		else if(cours.getAchetable() && cours.getProprietaire() == etudiant){
			jeu.caseDejaAchete(etudiant);
		}
		else if(cours.getAchetable() && cours.getProprietaire() != null){
			jeu.casePayerLoyer(etudiant, cours);
		}
		else {
			int position = cours.getPositionCase();
			switch(position){
			case 0 : 
				cours.caseDepart(etudiant, cours);
				break;
			case 2 :
				cours.caseInterro(etudiant, cours, deplacement);
				break;
			case 4 :
				cours.caseExamen(etudiant, cours);
				break;
			case 7 :
				cours.caseChance(etudiant, deplacement);
				break;
			case 10 :
				cours.caseVisitePrison(etudiant);
				break;
			case 17 :
				cours.caseInterro(etudiant, cours, deplacement);
				break;
			case 20 :
				cours.caseParkingGratuit(etudiant);
				break;
			case 22 :
				cours.caseMalchance(etudiant, deplacement);
				break;
			case 30 :
				cours.caseAllerEnPrison(etudiant);
				break;
			case 33 :
				cours.caseInterro(etudiant, cours, deplacement);
				break;
			case 36 :
				cours.caseChance(etudiant, deplacement);
				break;
			case 38 :
				cours.caseExamen(etudiant, cours);
				break;
			default :
				affiche("error position case1.");
			}
		}
	}
	
	public static void affiche(String string){
		System.out.println(string);
	}
	
	public static void main(String[] args){
		Jeux jeu = new Jeux();
		Plateau plateau = new Plateau();
		
		jeu.lancementJeu();
		plateau.creationPlateau();
		
			while(true){
				for (Etudiant etudiant: listeEtudiant){
					affiche("====================================================================================");
					try{
						affiche("Etudiant : " + etudiant.getNomEtudiant());
						etudiant.lancementTourEtudiant(etudiant, jeu, plateau);
					}
					catch(InputMismatchException e){
					affiche("Format d'input incorrect error1.");
					}
					
				}
			
			}
		
	}
}