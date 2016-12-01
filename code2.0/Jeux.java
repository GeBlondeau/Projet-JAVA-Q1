package Projet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

public class Jeux extends Observable{

	static Scanner sc = new Scanner(System.in);
	static List<Etudiant> listeJoueur = new ArrayList<Etudiant>();
	
	public void remplirListe(Etudiant joueur){
		listeJoueur.add(joueur);
	}
	public void lancementJeu(){
		Jeux jeu = new Jeux();
		Etudiant Etudiant1 = new Etudiant(100, 0, 0);
		Etudiant Etudiant2 = new Etudiant(100, 0, 0);
		Etudiant Etudiant3 = new Etudiant(100, 0, 0);
		Etudiant Etudiant4 = new Etudiant(100, 0, 0);
		jeu.remplirListe(Etudiant1);
		jeu.remplirListe(Etudiant2);
		jeu.remplirListe(Etudiant3);
		jeu.remplirListe(Etudiant4);
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
				for (Etudiant etudiant: listeJoueur){
					affiche("------------------------------");
					try{
						
						affiche(etudiant.toString());
						
						affiche("Pour lancer les dés appuyer sur une ou plusieurs touches du clavier et faites enter.");
						String c = sc.next();
						if(c.length()!=0){
							int deplacement = etudiant.lanceDes();
							affiche("La valeur des dés est : " + deplacement + ".");
							etudiant.positionJoueur = etudiant.positionJoueur + deplacement;
							
							if(etudiant.positionJoueur < 40);
							else {etudiant.positionJoueur -= 40;
								etudiant.ects += 25;}
							Case cours = plateau.listeCase.get(etudiant.positionJoueur);
							affiche("Vous êtes arrivé sur " + cours.getNomCase() + ".");
							
							if(cours.getAchetable() && cours.getProprietaire() == null){
								affiche("La case coute " + cours.getPrixAchat() + " ects.");
								affiche("Il vous reste " + etudiant.ects +" ects.");
								
								boolean	format = true;
								while(format){
									try{
										affiche("Acheter la case oui : Y, non : N.");
										String achat = sc.next();
										if(achat.length()==1){
											switch(achat){
											case "Y" :
												etudiant.ects -= cours.getPrixAchat();
												cours.setProprietaire(etudiant.toString());
												affiche("Félicitation vous venez d'acheter " + cours.getNomCase() + ".");
												affiche("Il vous reste " + etudiant.ects + " ects.");
												format = false;
												break;
											case "N" :
												affiche("Dommage une prochaine fois peut-être.");
												format = false;
												break;
											default :
												affiche("Format d'input incorrect error5");
											}	
										}
										else 
											affiche("Format d'input incorrect error4");
									}
									catch(InputMismatchException f){
										affiche("Format d'input incorrect error3");
									}
								}
							}
							else if(cours.getAchetable()){
								affiche("La case a déja été achetée par : " + cours.getProprietaire());
								int loyer = cours.getPrixLoyer();
								affiche("Vous devez payer : " + loyer + " ects.");
								affiche("Il vous reste " + etudiant.ects + " ects.");
							}
							else 
								affiche("La case n'est pas achetable");
								int position = cours.getPositionCase();
								switch(position){
								case 0 : 
									etudiant.ects += 25;
									affiche("Vous venez de recevoir 25 ects, vous avez maintenant " 
											+ etudiant.ects + " ects.");
								case 2 :
								
								
								}
						}
							
						else {
							affiche("Format d'input incorrect error2");
							break;
						}
					}
					catch(InputMismatchException e){
					affiche("Format d'input incorrect error1");
					}
					
				}
			
			}
		
	}
}